import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { getCart } from "~/component/API/customer/cart";
import {
  codPayment,
  paypalPayment,
  paypalSuccess,
  paypalCancel,
} from "~/component/API/customer/order";
import { getUserProfile } from "~/component/API/customer/profile";
import Price from "~/component/items/Price";
export default function OrderPage() {
  const [cart, setCart] = useState([]);
  const [Subtotal, setSubtotal] = useState(0);
  const [errorMessage, setErrorMessage] = useState("");
  const [infor, setInfor] = useState([]);
  const [message, setMessage] = useState([]);
  const [validationError, setValidationError] = useState("");
  const [paymentmethod, setPaymentmethod] = useState("COD");
  const [isSuccess, setIsSuccess] = useState(false);
  const history = useNavigate();
  const location = useLocation();
  useEffect(() => {
    const fetchData = async () => {
      const result = await getCart();
      if (result.success) {
        setCart(result.message);
      } else {
        setErrorMessage(result.message);
      }
      const result2 = await getUserProfile();
      if (result2.success) {
        setInfor(result2.message);
      } else {
        setErrorMessage(result2.message);
      }
    };
    fetchData();

    if (errorMessage) {
      setTimeout(() => {
        history("/login");
        localStorage.clear();
      }, 3000);
    }
  }, []);
  useEffect(() => {
    const totalPrice = cart.reduce((accumulator, item) => {
      const milkTeaPrice = item.milkTea.price;
      const quantity = item.quantity;

      const addOnTotalPrice = item.addOn.reduce((addOnAccumulator, addOn) => {
        return addOnAccumulator + addOn.price;
      }, 0);

      const itemTotalPrice = (milkTeaPrice + addOnTotalPrice) * quantity;
      return accumulator + itemTotalPrice;
    }, 0);
    setSubtotal(totalPrice);
  }, [cart]);

  // useEffect(() => {
  //   const handlePaypalReturn = async () => {
  //     const params = new URLSearchParams(location.search);

  //     if (params.has("token") && params.has("paymentId") && params.has("PayerID")) {
  //       const token = params.get("token");
  //       const paymentId = params.get("paymentId");
  //       const payerId = params.get("PayerID");

  //       const successResult = await paypalSuccess(paymentId, payerId);
  //       if (successResult.success) {
  //         setIsSuccess(true);
  //         setErrorMessage(successResult.message);
  //         history.push("/customer/cart");
  //       } else {
  //         setErrorMessage("Có lỗi xảy ra trong quá trình xử lý thanh toán.");
  //       }
  //     } else if (params.has("token")) {
  //       const token = params.get("token");
  //       try {
  //         const cancelResult = await paypalCancel(token);
  //       } catch (error) {
  //         setErrorMessage("Error while calling paypalCancel API: " + error);
  //       }
  //     }
  //   };

  //   handlePaypalReturn();
  // }, [location.search, history]);


  function getTopping(addons) {
    if (addons.length === 0) return "";
    const names = addons.map((item) => item.name);
    const result = names.join(", ");
    return result;
  }

  function handleDataInfo(event) {
    const { name, value } = event.target;
    setInfor((prevValues) => ({
      ...prevValues,
      [name]: value,
    }));
  }
  function handlePaymentMethodChange(event) {
    setPaymentmethod(event.target.value);
  }
  function FinishOrder(e) {
    e.preventDefault();
    if (!infor.name || !infor.address || !infor.phone) {
      setValidationError("Please fill in all required fields.");
    } else {
      const order = {
        receiver_name: infor.name,
        address: infor.address,
        phone: infor.phone,
        payment_method: paymentmethod,
        order_total_price: Subtotal,
        note: null,
      };
      if (!message) order.note = message;
      const fetchData = async () => {
        if (paymentmethod == "COD") {
          const result = await codPayment(order);
          if (result.success) {
            setIsSuccess(true);
          } else {
            setErrorMessage("Order failed");
          }
        } else {
          createPaypalOrder();
        }
      };
      fetchData();
      setValidationError("");
    }
  }

  if (isSuccess) {
    return (
      <div>
        <h2 className="text-green-300 grid items-center text-center h-auto pt-[100px] text-[36px] font-bold my-6">
          Congratulations On Your Successful Order
        </h2>
      </div>
    );
  }
  if (cart.length == 0)
    return (
      <div>
        <h2 className="text-yellow-300 grid items-center text-center h-auto pt-[100px] text-[36px] font-bold my-6">
          Your Cart Is Empty
        </h2>
      </div>
    );

  function handleCancel() {
    history("/customer/cart");
  }

  function createPaypalOrder(e) {
    if (!infor.name || !infor.address || !infor.phone || !paymentmethod) {
      setValidationError("Please fill in all required fields.");
    } else {
      const order = {
        receiver_name: infor.name,
        address: infor.address,
        phone: infor.phone,
        payment_method: paymentmethod,
        order_total_price: Subtotal,
        note: null,
      };
      if (!message) order.note = message;
      const fetchData = async () => {
        const result = await paypalPayment(order);
        if (result.success) {
          window.location.href = result.message;
        } else {
          setErrorMessage(result.message);
        }
      };
      fetchData();
      setValidationError("");
    }
  }

  return (
    <div className="h-auto flex justify-center">
      {errorMessage && (
        <h2 className="text-yellow-400 text-[24px] grid items-center pt-[100px] font-bold my-6">
          {errorMessage}
        </h2>
      )}
      {!errorMessage && !cart.length == 0 && (
        <div className="mt-[50px] rounded-xl sm:w-[1000px] w-full h-full bg-white">
          <div>
            <h1 className="text-green-600 font-bold text-[40px] justify-center flex mt-8 mb-4">
              Finish Your Order
            </h1>
            <div className="min-h-80 max-w-2xl my-4 sm:my-8 mx-auto w-full">
              <table className="sm:mx-[36px]">
                <tbody className="divide-y divide-palette-lighter">
                  {cart.map((item) => (
                    <tr
                      key={item.custom_milk_tea_id}
                      className="text-sm sm:text-base text-gray-600 text-center"
                    >
                      <td className="font-primary font-medium px-4 sm:px-6 py-4 flex items-center ">
                        <img
                          src={item?.milkTea?.image_url}
                          alt={item?.milkTea?.name}
                          height={64}
                          width={64}
                          className={`hidden sm:inline-flex`}
                        />
                        <div className="ml-3 pt-1 hover:text-palette-dark">
                          {item?.milkTea?.name}, {item.size}, ice:
                          {item.ice_amount}
                          %, sugar:{item.sugar_amount}%
                        </div>
                      </td>
                      <td className="font-primary text-base font-light px-4 sm:px-6 py-4 hidden sm:table-cell">
                        <span>{getTopping(item.addOn)}</span>
                      </td>
                      <td>
                        <p className="font-primary font-medium px-4 sm:px-6 py-4">
                          {item.quantity}
                        </p>
                      </td>

                      <td className="font-primary text-base font-light px-4 sm:px-6 py-4 hidden sm:table-cell">
                        <Price
                          currency="VND"
                          num={item?.milkTea?.price}
                          numSize="text-lg"
                        />
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
            {Subtotal === 0 ? null : (
              <div className="grid">
                <div className="flex m-[48px] mb-5 justify-end">
                  <div className="font-primary text-base text-gray-600 font-semibold uppercase px-4 sm:px-6 py-4 justify-between">
                    Subtotal:
                  </div>
                  <div className="font-primary text-lg text-palette-primary font-medium px-4 sm:px-6 py-4">
                    <Price currency="VND" num={Subtotal} numSize="text-xl" />
                  </div>
                </div>
              </div>
            )}
            <form onSubmit={FinishOrder}>
              <div className="sm:flex justify-around ">
                <div className="sm:w-96 w-full">
                  <div className="relative z-0 mb-6 group sm:ml-[60px] ml-2 w-full">
                    <input
                      type="text"
                      name="name"
                      id="floating_Name"
                      className="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                      placeholder=" "
                      required
                      onChange={handleDataInfo}
                      value={infor.name}
                    />
                    <label
                      htmlFor="floating_Name"
                      className="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6"
                    >
                      Name(*)
                    </label>
                  </div>
                  <div className="relative z-0 sm:ml-[60px] ml-2 w-full mb-6 group">
                    <input
                      type="text"
                      name="address"
                      id="address"
                      className="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                      placeholder=" "
                      onChange={handleDataInfo}
                      required
                      value={infor.address}
                    />
                    <label
                      htmlFor="floating_address"
                      className="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6"
                    >
                      Address(*)
                    </label>
                  </div>
                  <div className="relative z-0 sm:ml-[60px] ml-2 w-full mb-6 group">
                    <input
                      type="text"
                      pattern="[0-9]{10}"
                      name="phone"
                      id="floating_phone"
                      className="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                      placeholder=" "
                      onChange={handleDataInfo}
                      required
                      value={infor.phone}
                    />
                    <label
                      htmlFor="floating_phone"
                      className="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6"
                    >
                      Phone Number(*)
                    </label>
                  </div>
                </div>
                <div className="sm:w-96 w-full h-auto mb-8 mx-2">
                  <textarea
                    className="my-[10px] sm:p-[20px] h-full w-full hover:outline-none bg-[#f5f5f5] text-[16px] focus:ring-green-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800"
                    id="message"
                    rows="4"
                    onChange={(e) => {
                      setMessage(e.target.value);
                    }}
                    placeholder="Note"
                    value={message}
                  ></textarea>
                </div>
              </div>
              <div className="p-4">
                {/* <div className="flex justify-end ">
                  <div className="mr-2">Choose the payment method:</div>
                  <div>
                    <label>
                      <input
                        type="radio"
                        name="payment_method"
                        value="COD"
                        checked={paymentmethod === "COD"}
                        onChange={handlePaymentMethodChange}
                      />
                      <span className="radio-label mr-2">
                        COD (Cash on Delivery)
                      </span>
                    </label>
                  </div>
                  <div>
                    <label>
                      <input
                        type="radio"
                        name="payment_method"
                        value="PayPal"
                        checked={paymentmethod === "PayPal"}
                        onChange={handlePaymentMethodChange}
                      />
                      <span className="radio-label">PayPal</span>
                    </label>
                  </div>
                </div> */}
              </div>
              {validationError && (
                <p className="text-red-500 pl-10 text-sm mb-4">
                  {validationError}
                </p>
              )}

              <div className="flex justify-center">
                <button
                  type="button"
                  className="focus:outline-none text-white bg-yellow-400 w-40 hover:bg-yellow-500 focus:ring-4 focus:ring-yellow-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:focus:ring-yellow-900"
                  onClick={handleCancel}
                >
                  Cancel
                </button>
                <button
                  onClick={FinishOrder}
                  className="focus:outline-none text-white bg-green-700 w-40 hover:bg-green-800 focus:ring-4 focus:ring-green-300 font-medium rounded-lg text-sm px-5 py-2.5 mb-2 dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800"
                >
                  Order
                </button>
              </div>
              <div className="flex justify-center mb-2">
                <div className="border-b-[2px] border-green-700 w-[320px] "></div>
              </div>
              
            </form>
          </div>
        </div>
      )}
    </div>
  );
}
