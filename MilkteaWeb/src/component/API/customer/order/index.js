import getRole from "~/role";
const api ='http://localhost:8080/customer/my-cart/order'
async function codPayment(order){
    try{
        const role= getRole()
        const response = await fetch(`${api}/COD`, {
            method: "put",
            headers: {
              "Content-type": "application/json",
              authorization: `Bearer ${role.token}`,
            },
      
            body: JSON.stringify(order),
          });
      
          if (response.status === 200) {
            const data = await response.json();
            return { success: true, message: data.message };
          } else if (response.status === 401) {
            return { success: false, message: "You must login as a customer" };
          } else if (response.status === 400) {
            return {
              success: false,
              message: "token has wrong or expired, please login again",
            };
          } else {
            return { success: false, message: "Unexpected error" };
          }
        } catch (error) {
          return { success: false, message: "Error: " + error.message };
        }
      }

async function paypalPayment(order){
  try{
    const role= getRole()
    const response = await fetch(`${api}/paypal`, {
        method: "post",
        headers: {
          "Content-type": "application/json",
          authorization: `Bearer ${role.token}`,
        },
  
        body: JSON.stringify(order),
      });
  
      if (response.status === 200) {
        const data = await response.json();
        return { success: true, message: data.message };
      } else if (response.status === 401) {
        return { success: false, message: "You must login as a customer" };
      } else if (response.status === 400) {
        return {
          success: false,
          message: "token has wrong or expired, please login again",
        };
      } else {
        return { success: false, message: "Unexpected error" };
      }
    } catch (error) {
      return { success: false, message: "Error: " + error.message };
    }
}

async function paypalSuccess(paymentid,payerid){
  try{
    const role= getRole()
    const response = await fetch(`http://localhost:8080/paypal/pay/success?paymentId=${paymentid}&PayerID=${payerid}`, {
        method: "get",
        headers: {
          "Content-type": "application/json",
          authorization: `Bearer ${role.token}`,
        },
  
       
      });
  
      if (response.status === 200) {
        const data = await response.json();
        return { success: true, message: data.message };
      } else if (response.status === 401) {
        return { success: false, message: "You must login as a customer" };
      } else if (response.status === 400) {
        return {
          success: false,
          message: "token has wrong or expired, please login again",
        };
      } else {
        return { success: false, message: "Unexpected error" };
      }
    } catch (error) {
      return { success: false, message: "Error: " + error.message };
    }
}

async function paypalCancel(token){
  try{
    const role= getRole()
    const response = await fetch(`http://localhost:8080/paypal/pay/cancel?token=${token}`, {
        method: "get",
        headers: {
          "Content-type": "application/json",
          authorization: `Bearer ${role.token}`,
        },  
      });
  
      if (response.status === 200) {
        const data = await response.json();
        return { success: true, message: data.message };
      } else if (response.status === 401) {
        return { success: false, message: "You must login as a customer" };
      } else if (response.status === 400) {
        return {
          success: false,
          message: "token has wrong or expired, please login again",
        };
      } else {
        return { success: false, message: "Unexpected error" };
      }
    } catch (error) {
      return { success: false, message: "Error: " + error.message };
    }
}

async function OrderNotInCart(){
  try{
    const role= getRole()
    const response = await fetch(`http://localhost:8080/customer/all-orders-ordered`, {
        method: "get",
        headers: {
          "Content-type": "application/json",
          authorization: `Bearer ${role.token}`,
        },  
      });
  
      if (response.status === 200) {
        const data = await response.json();
        return { success: true, message: data};
      } else if (response.status === 401) {
        return { success: false, message: "You must login as a customer" };
      } else if (response.status === 400) {
        return {
          success: false,
          message: "token has wrong or expired, please login again",
        };
      } else {
        return { success: false, message: "Unexpected error" };
      }
    } catch (error) {
      return { success: false, message: "Error: " + error.message };
    }
}

async function CancelOrder(OrderID){
  try{
    const role= getRole()
    const response = await fetch(`http://localhost:8080/customer/all-orders-ordered/cancel-order/${OrderID}`, {
        method: "put",
        headers: {
          "Content-type": "application/json",
          authorization: `Bearer ${role.token}`,
        },  
      });
  
      if (response.status === 200) {
        const data = await response.json();
        return { success: true, message: data.message};
      } else if (response.status === 401) {
        return { success: false, message: "You must login as a customer" };
      } else if (response.status === 400) {
        return {
          success: false,
          message: "token has wrong or expired, please login again",
        };
      } else {
        return { success: false, message: "Unexpected error" };
      }
    } catch (error) {
      return { success: false, message: "Error: " + error.message };
    }
}
export {codPayment, paypalPayment,paypalSuccess,paypalCancel, OrderNotInCart, CancelOrder}