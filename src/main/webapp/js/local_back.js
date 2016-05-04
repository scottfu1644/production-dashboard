function defineTimeScale(date, shift) {
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var d = date.getDate();
    var hours = date.getHours();
    var minute = date.getMinutes();
    var second = date.getSeconds();

    var ret = {};
    var beginTime ;
    var endTime ;


    if (hours > 0 && hours < 7) {
        beginTime = year + '-'
            + ( month < 9 ? ('0' + month) : month ) + '-'
            + ( d < 9 ? ('0' + (d - 1)) : (d - 1) ) + ' '
            + '19:00:00';
        endTime = year + '-'
            + ( month < 9 ? ('0' + month) : month ) + '-'
            + ( d < 9 ? ('0' + d) : d ) + ' '
            + '07:00:00';

    } else if (hours >= 7 && hours < 19) {
        beginTime = year + '-'
            + ( month < 9 ? ('0' + month) : month ) + '-'
            + ( d < 9 ? ('0' + d) : d ) + ' '
            + '07:00:00';
        endTime = year + '-'
            + ( month < 9 ? ('0' + month) : month ) + '-'
            + ( d < 9 ? ('0' + d) : d ) + ' '
            + '19:00:00';
        ret['shift'] = {'type': 'day', 'beginTime': beginTime, 'endTime': endTime};
    } else if (hours >= 19) {
        beginTime = year + '-'
            + ( month < 9 ? ('0' + month) : month ) + '-'
            + ( d < 9 ? ('0' + d) : d ) + ' '
            + '19:00:00';
        endTime = year + '-'
            + ( month < 9 ? ('0' + month) : month ) + '-'
            + ( d < 9 ? ('0' + (d + 1)) : (d + 1) ) + ' '
            + '07:00:00';
        ret['shift'] = {'type': 'night', 'beginTime': beginTime, 'endTime': endTime};
    }

    return ret;
}

function parseDateString(dateString) {
    var pieces = dateString.split("-");
    var years = parseInt(pieces[0], 10);
    var months = parseInt(pieces[1], 10) - 1; // months are 0 based
    var days = parseInt(pieces[2].split(' ')[0], 10);
    var hours = parseInt(pieces[2].split(' ')[1].split(':')[0],10);
    var minutes = parseInt(pieces[2].split(' ')[1].split(':')[1],10);
    var seconds =  parseInt(pieces[2].split(' ')[1].split(':')[2],10);
    var date = new Date(years,months,days,hours,minutes,seconds);
    return date;
}