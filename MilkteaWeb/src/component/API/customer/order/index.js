import getRole from "~/role";
const api ='localhost:8080/customer/my-cart/order'
async function codPayment(){
    try{
        const role= getRole()
        const response = await fetch(`${api}/COD`, {
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