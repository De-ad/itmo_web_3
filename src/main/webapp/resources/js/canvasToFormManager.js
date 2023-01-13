


function setHiddenFormData(x, y, r){
    xValue = document.getElementById("hidden_x");
    yValue = document.getElementById("hidden_y");
    rValue = document.getElementById("hidden_r");
    //TODO: getting data from canvas
    xValue.setAttribute("value", x);
    yValue.setAttribute("value", y);
    rValue.setAttribute("value", r);
    console.log("x:", x, "y: ", y, "r:", r);
    document.getElementById("send_hidden").click();
}
