$(document).ready(function() {
    let today = new Date()
    let curHr = today.getHours()
    if (curHr < 12) {
        $('#partOfADay').text('morning');
    } else if (curHr < 18) {
        $('#partOfADay').text('afternoon');
    } else {
        $('#partOfADay').text('evening');
    }
})