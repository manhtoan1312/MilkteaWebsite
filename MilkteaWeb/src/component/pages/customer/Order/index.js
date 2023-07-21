import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getCart } from "~/component/API/customer/cart";
import { getUserProfile } from "~/component/API/customer/profile";
import Price from "~/component/items/Price";

export default function OrderPage() {
  const [cart, setCart] = useState([]);
  const [Subtotal, setSubtotal] = useState(0);
  const [errorMessage, setErrorMessage] = useState("");
  const [infor, setInfor] = useState([]);
  const [message, setMessage] = useState([]);
  const history = useNavigate();
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
        alert(errorMessage);
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
  function FinishOrder() {}

  if (cart.length == 0)
    return (
      <h2 className="text-yellow-300 text-[24px] font-bold my-6">
        Your Cart Is Empty
      </h2>
    );

  return (
    <div className="bg-gray-100 h-auto flex justify-center">
      {errorMessage && (
        <h2 className="text-red-700 text-[24px] font-bold my-6">
          {errorMessage}
        </h2>
      )}
      {!errorMessage && !cart.length == 0 && (
        <div className="mt-[50px] rounded-xl sm:w-[1000px] w-full h-full bg-white">
          <div>
            <h1 className="text-green-600 font-bold text-[40px] justify-center flex mt-8 mb-4">
              Finish Your Order
            </h1>
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
                        num={item.total_price}
                        numSize="text-lg"
                      />
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
            {Subtotal === 0 ? null : (
              <div className="flex m-[48px] mb-5 justify-end">
                <div className="font-primary text-base text-gray-600 font-semibold uppercase px-4 sm:px-6 py-4 justify-between">
                  Subtotal:
                </div>
                <div className="font-primary text-lg text-palette-primary font-medium px-4 sm:px-6 py-4">
                  <Price currency="VND" num={Subtotal} numSize="text-xl" />
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
                      Name
                    </label>
                  </div>
                  <div className="relative z-0 sm:ml-[60px] ml-2 w-full mb-6 group">
                    <input
                      type="text"
                      name="floating_address"
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
                      Address
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
                      Phone Number
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
              <div className="p-4"></div>
              <div className="flex justify-center">
                <button
                  type="button"
                  className="focus:outline-none text-white bg-yellow-400 w-40 hover:bg-yellow-500 focus:ring-4 focus:ring-yellow-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:focus:ring-yellow-900"
                >
                  Cancel
                </button>
                <button
                  type="submit"
                  className="focus:outline-none text-white bg-green-700 w-40 hover:bg-green-800 focus:ring-4 focus:ring-green-300 font-medium rounded-lg text-sm px-5 py-2.5 mb-2 dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800"
                >
                  Order
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
}
