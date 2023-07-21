export default async function allContact(){
    try {
        const response = await fetch("http://localhost:8080/home/all-contacts", {
          method: "get",
        });
        return await response.json();
      } catch (e) {
        return e;
      }
}