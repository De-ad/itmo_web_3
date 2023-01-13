const MAX_X = 4;
const MIN_X = -4;
const MAX_Y = 3;
const MIN_Y = -5;


const validateR = (value) => {
    let correctValues = ["1", "2", "3", "4", "5"].map(Number);
    if ((value.toString().trim() === "") || isNaN(Number(value))){
        return false;
    }
    const r = parseFloat(value);
    return (correctValues.includes(r));
}

const validateY = (value) => {
    if ((value.toString().trim() === "") || isNaN(Number(value))){
        return false;
    }
    const y = parseFloat(value);
    return (y < MAX_Y && y > MIN_Y);
}

const validateX = (value) => {
    if ((value.toString().trim() === "") || isNaN(Number(value))){
        return false;
    }
    const x = parseFloat(value);
    return (x < MAX_X && x > MIN_X);
}

function validate(x, y, r){
    return validateX(x) && validateR(r) && validateY(y);
}