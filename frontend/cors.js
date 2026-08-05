const url = "http://40.0.1.155:4040/api";

async function log() {
    let req = await fetch(url);
    let res = await req.text();
    console.log("\n\t response: " + res);
    let r = document.getElementById("o");
    r.textContent = res;
}