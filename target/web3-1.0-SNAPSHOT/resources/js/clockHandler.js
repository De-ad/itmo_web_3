$(function (){
    function updateClock() {
        let date = new Date();
        let day = date.getUTCDay();
        let year = date.getFullYear();
        let month = date.getMonth();
        let hours = date.getHours();
        let minutes = date.getMinutes();
        let seconds = date.getSeconds();
        $('.clock').html(`${hours}:${minutes}:${seconds}  ${day}.${month}.${year}`);
    }
    updateClock();
    setInterval(updateClock, 6000);

});

