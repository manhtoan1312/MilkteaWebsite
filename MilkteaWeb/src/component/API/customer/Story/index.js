export default async function listBlog() {
  try {
    const response = await fetch("http://localhost:8080/home/all-blogs", {
      method: "get",
    });
    return await response.json();
  } catch (e) {
    return e;
  }
}


