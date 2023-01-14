const width =  300;
const height = 300;
const radius_pix = 100;
var prev = null;
let array;
const canvas = document.getElementById("plot");
canvas.width = width;
canvas.height = height;
const ctx = canvas.getContext('2d');

function draw() {
    drawCircle(ctx);
    drawTriangle(ctx);
    drawSquare(ctx);
    drawLines(ctx);
}

draw();

function addMouseListener(){
    canvas.addEventListener("mousedown", function (e){
        clickListener(canvas, e, ctx);
    });
}
//
// function firstDrawHandler(){
//     addMouseListener();
//     draw();
// }



function handleRChange(){
    if (prev == null){
        prev = getCoordinates().r;

    }
    if (prev !== getCoordinates().r){
        prev = getCoordinates().r
        return true;
    }
    return false;
}

function clickListener(canvas, event){
    console.log("here comes the click listener");
    const rect = canvas.getBoundingClientRect();
    const x = event.clientX - rect.left;
    const y = event.clientY - rect.top;
    let r = $('#R_value').val();
    if (validateR(r)) {
        const k = r/radius_pix;
        let xok = (x -  width/2)*k;
        let yok = (height/2 - y)*k;
        // setCanvasCoordinates(xok,yok);
        // sendCanvasRequest(getCoordinates());
    }
    else {
        document.querySelector("#R_error").innerHTML ="error: r is not set";
        console.log("error: r is not valid");
    }
}

// function drawClickDot(x, y, r, ctx){
//     ctx.beginPath();
//     ctx.fillStyle = "rgb(255,7,0)";
//     ctx.arc(x, y, 3, 0, 360);
//     ctx.fill();
// }

function drawTriangle(ctx){
    ctx.beginPath();
    ctx.fillStyle = "rgba(238, 128, 125, 0.3)";
    ctx.moveTo(150,250);
    ctx.lineTo(250,150);
    ctx.lineTo(150,150);
    ctx.fill();
}
// function drawDot(x, y, r, ctx, hit){
//     ctx.beginPath();
//     (hit) ? ctx.fillStyle = "rgb(34,255,0)" : ctx.fillStyle = "rgb(255,7,0)";
//     let cx = 150 + 100/ r * x;
//     let cy = 150 - 100/ r * y;
//     ctx.arc(cx, cy, 3, 0, 360);
//     ctx.fill();
// }

function drawCircle(ctx){
    ctx.beginPath();
    ctx.fillStyle = "rgba(238, 128, 125, 0.3)";
    ctx.moveTo(150, 150);
    ctx.arc(150 ,150 , 50, Math.PI, 1.5 * Math.PI, false);
    ctx.lineTo(150,150);
    ctx.fill();
}

function drawSquare(ctx){
    console.log("Inside square");
    ctx.beginPath();
    ctx.fillStyle = "rgba(238, 128, 125, 0.3)"
    ctx.moveTo(50,150);
    ctx.lineTo(150,150);
    ctx.lineTo(150,200);
    ctx.lineTo(50,200);
    ctx.lineTo(50,150);
    ctx.fill();
}

function drawLines(ctx){
    ctx.font = "15px serif";

    ctx.fillStyle = "rgb(0, 0, 0)";
    ctx.fillText("R", 155,50);
    ctx.fillText("R/2", 155,100);
    ctx.fillText("-R/2", 155,200);
    ctx.fillText("-R", 155,250);
    ctx.fillText("R/2", 200,145);
    ctx.fillText("-R/2", 100,145);
    ctx.fillText("-R", 50,145);


    ctx.beginPath();
    ctx.moveTo(30,150);
    ctx.lineTo(270,150);
    ctx.stroke();


    ctx.beginPath();
    ctx.moveTo(150,30);
    ctx.lineTo(150,270);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(50,145);
    ctx.lineTo(50,155);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(100,145);
    ctx.lineTo(100,155);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(200,145);
    ctx.lineTo(200,155);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(145,50);
    ctx.lineTo(155,50);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(145,100);
    ctx.lineTo(155,100);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(145,200);
    ctx.lineTo(155,200);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(145,250);
    ctx.lineTo(155,250);
    ctx.stroke();

}

function getDots(arr){
    array = arr;
}

function cleanCanvas(){
    ctx.clearRect(0, 0, width, height);
}

