import MessageBox from "~/component/items/MessageBox";
import { useEffect, useState } from "react";
import Price from "~/component/items/Price";
import { OrderNotInCart,CancelOrder } from "~/component/API/customer/order";
function OrdersOrdered() {
  const [ordered, setOrdered] = useState([]);
  const [errorMessage, setErrorMessage] = useState("");
  useEffect(() => {
    const fetchData = async () => {
      const result = await OrderNotInCart();
      if (result.success) {
        setOrdered(result.message);
      } else {
        setErrorMessage(result.message);
      }
    };
    fetchData();
  }, []);

  const getDate = (orderDate) => {
    const datePart = orderDate.substring(0, 10);
    const timePart = orderDate.substring(11, 19);
    return `${timePart} ${datePart}`;
  };

  const CancelOrders = (item) => {
    const fetchData = async () => {
      const result = await CancelOrder(item.order_id);
      setErrorMessage(result.message);
    };
    fetchData();
  }

  return (
    <div className="relative container mb-20 min-h-screen min-h-80 max-w-6xl my-4 sm:my-8 mx-auto w-full ">
      {errorMessage && <MessageBox message={errorMessage} />}
      <div className="shadow-lg pt-10 mx-auto max-w-5xl">
        <table className="w-full">
          <thead>
            <tr className="uppercase text-xs sm:text-sm text-palette-primary border-b border-palette-light">
              <th className="font-primary font-normal px-6 py-4">ID Order</th>
              <th className="font-primary font-normal px-6 py-4">Order Date</th>
              <th className="font-primary font-normal px-6 py-4">
                Total Order Price
              </th>
              <th className="font-primary font-normal px-6 py-4">
                Receiver Name
              </th>
              <th className="font-primary font-normal px-6 py-4">Address</th>
              <th className="font-primary font-normal px-6 py-4">Phone</th>
            </tr>
          </thead>
          <tbody>
            {ordered.map((item) => (
              <tr
                key={item.order_id}
                className="text-sm sm:text-base text-gray-600 text-center hover:scale-105 hover:shadow-lg transition-transform"
              >
                <td className="font-primary text-base font-light px-4 sm:px-6 py-4 hidden sm:table-cell">
                  <p className="font-bold ">{item.order_id}</p>
                </td>
                <td className="font-primary text-base font-light px-4 sm:px-6 py-4 hidden sm:table-cell">
                  {getDate(item.order_date)}
                </td>
                <td className="font-primary text-base font-light px-4 sm:px-6 py-4 hidden sm:table-cell">
                  <Price
                    currency="VND"
                    num={item?.order_total_price}
                    numSize="text-lg"
                  />
                </td>
                <td className="font-primary text-base font-light px-4 sm:px-6 py-4 hidden sm:table-cell">
                  {item.receiver_name}
                </td>
                <td className="font-primary text-base font-light px-4 sm:px-6 py-4 hidden sm:table-cell">
                  {item.address}
                </td>
                <td className="font-primary text-base font-light px-4 sm:px-6 py-4 hidden sm:table-cell">
                  {item.phone}
                </td>
                {item.order_state === "PassedToStaff" && (
                  <td className="font-primary text-base font-light px-4 sm:px-6 py-4 hidden sm:table-cell">
                    <button
                      type="button"
                      className="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900"
                      onClick={() => CancelOrders(item)}
                    >
                      Cancel Order
                    </button>
                  </td>
                )}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default OrdersOrdered;
