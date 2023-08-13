import { useState } from "react";
import { useNavigate } from "react-router-dom";
export default function MessageBox({ message }) {
  const [closeBoxs, setCloseBox] = useState(false);
  const navigate = useNavigate()
  function closeBox() {
    setCloseBox(true)
    if(message=='You must login as a customer' || message=='token has wrong or expired, please login again' || message.toLowerCase().includes('error'))
  {
    navigate('/login')
  }  
  }
  if(closeBoxs) {
    return null
  }

  return (
    <div className="absolute top-0 bottom-0 left-0 right-0">
      <div className="absolute bg-gray-400 opacity-30 top-0 bottom-0 left-0 right-0"></div>
      <div className="w-[400px] bg-white rounded-lg absolute top-1/2 left-1/2 translate-x-[-50%] translate-y-[-50%] text-center text-green-500">
        <div className=" flex items-center justify-center mt-[-20px] ">
          <h2 className="text-white flex items-center justify-center bg-green-500 w-[300px]  rounded-2xl h-11 font-bold">
            Ba Con Bao MilkTea Announce
          </h2>
        </div>
        <h2 className="mt-[30px] mb-[10px] text-[38px] text-black font-extralight">
          {message}
        </h2>
        <div className="flex justify-around">
          <button
            className="flex justify-center w-14 h-14 mb-3 font-medium items-center hover:bg-green-600 bg-green-400 outline-none text-4 text-white cursor-pointer shadow rounded-[50%]"
            type="button"
            onClick={closeBox}
          >
            OK
          </button>
        </div>
      </div>
    </div>
  );
}
