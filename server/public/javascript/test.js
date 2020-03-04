console.log("Running test");

const highRoute = document.getElementById("high-route").value;

fetch(highRoute).
  then(result => result.json()).
  then(body => {
    console.log(body);
  });