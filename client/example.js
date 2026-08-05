const url = "http://40.0.1.155:4040/api/v1";

let n = document.getElementById("name");
let e = document.getElementById("email");
let i = document.getElementById("ip");

// const res = await fetch(url, {
//   method: "POST",
//   headers: {
//     "Content-Type": "application/json",
//   },
//   body: JSON.stringify({
//     email: "24eg107d10@anurag.edu.in",
//     name: "Praful-B",
//     ip: "192.168.137.108/24",
//   }),
// });


async function pd() {
    let obj = {
        email: n.value,
        name: e.value,
        ip: i.value,
    };
    console.log("\n\t data: " + obj);
    console.log("\n\t data: " + JSON.stringify(obj, null, 2));
}   