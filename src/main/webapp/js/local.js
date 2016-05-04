function defineTimeScale(now, date, shift) {
    if(date === '' || (date.getFullYear() === now.getFullYear() &&
        date.getMonth() === now.getMonth() &&
        date.getDate() === now.getDate())) {
        date = now;
    }
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var d = date.getDate();
    var hours = date.getHours();
    var minute = date.getMinutes();
    var second = date.getSeconds();

    var ret = {};
    var beginTime ;
    var endTime ;
    var lastBeginTime;
    var lastEndTime;
    if(now < date) {
        return {'type': shift, 'beginTime': null, 'endTime': null, 'tips':'Date out of range!'};
    } else if (now === date){
        if(shift === 'Daytime') {
            // now is night shift, in different day
            if (hours >= 0 && hours < 7) {
                beginTime = year + '-'
                    + ( month < 9 ? ('0' + month) : month ) + '-'
                    + ( d < 9 ? ('0' + (d - 1)) : (d - 1)) + ' '
                    + '07:00:00';
                endTime = year + '-'
                    + ( month < 9 ? ('0' + month) : month ) + '-'
                    + ( d < 9 ? ('0' + (d - 1)) : (d-1)) + ' '
                    + '19:00:00';
            // now is daytime shift
            } else if (hours >= 7 && hours < 19) {
                beginTime = year + '-'
                    + ( month < 9 ? ('0' + month) : month ) + '-'
                    + ( d < 9 ? ('0' + d) : d ) + ' '
                    + '07:00:00';
                endTime = year + '-'
                    + ( month < 9 ? ('0' + month) : month ) + '-'
                    + ( d < 9 ? ('0' + d) : d ) + ' '
                    + '19:00:00';
            // now is night shift, within same day
            } else if (hours >= 19 && hours < 24) {
                beginTime = year + '-'
                    + ( month < 9 ? ('0' + month) : month ) + '-'
                    + ( d < 9 ? ('0' + d) : d ) + ' '
                    + '07:00:00';
                endTime = year + '-'
                    + ( month < 9 ? ('0' + month) : month ) + '-'
                    + ( d < 9 ? ('0' + d) : d ) + ' '
                    + '19:00:00';
            }
        } else if(shift === 'Night'){
            // now is night shift, in different day
            if (hours >= 0 && hours < 7) {
                beginTime = year + '-'
                    + ( month < 9 ? ('0' + month) : month ) + '-'
                    + ( d < 9 ? ('0' + (d - 1)) : (d - 1)) + ' '
                    + '19:00:00';
                endTime = year + '-'
                    + ( month < 9 ? ('0' + month) : month ) + '-'
                    + ( d < 9 ? ('0' + d) : d) + ' '
                    + '07:00:00';
            // now is daytime shift
            } else if (hours >= 7 && hours < 19) {
                beginTime = year + '-'
                    + ( month < 9 ? ('0' + month) : month ) + '-'
                    + ( d < 9 ? ('0' + (d-1)) : (d-1) ) + ' '
                    + '19:00:00';
                endTime = year + '-'
                    + ( month < 9 ? ('0' + month) : month ) + '-'
                    + ( d < 9 ? ('0' + d) : d ) + ' '
                    + '07:00:00';
                // now is night shift, within same day
            } else if (hours >= 19 && hours < 24) {
                beginTime = year + '-'
                    + ( month < 9 ? ('0' + month) : month ) + '-'
                    + ( d < 9 ? ('0' + d) : d ) + ' '
                    + '19:00:00';
                endTime = year + '-'
                    + ( month < 9 ? ('0' + month) : month ) + '-'
                    + ( d < 9 ? ('0' + (d+1)) : (d+1) ) + ' '
                    + '07:00:00';
            }
        }
    } else {
        if(shift === 'Daytime') {
            beginTime = year + '-'
                + ( month < 9 ? ('0' + month) : month ) + '-'
                + ( d < 9 ? ('0' + d) : d ) + ' '
                + '07:00:00';
            endTime = year + '-'
                + ( month < 9 ? ('0' + month) : month ) + '-'
                + ( d < 9 ? ('0' + d) : d) + ' '
                + '19:00:00';
        } else if(shift === 'Night') {
            beginTime = year + '-'
                + ( month < 9 ? ('0' + month) : month ) + '-'
                + ( d < 9 ? ('0' + d) : d ) + ' '
                + '19:00:00';
            endTime = year + '-'
                + ( month < 9 ? ('0' + month) : month ) + '-'
                + ( d < 9 ? ('0' + (d+1)) : (d+1) ) + ' '
                + '07:00:00';
        }
    }
    lastBeginTime = parseDateString(beginTime,'-',':').valueOf() - 1000 * 3600 * 12;
    lastEndTime = parseDateString(beginTime,'-',':').valueOf();

    ret = {
        'type': shift,
        'beginTime': beginTime,
        'endTime': endTime,
        'lastBeginTimeMilli' : lastBeginTime,
        'lastEndTimeMilli' : lastEndTime,
        'tips':'GET!'};
    return ret;
}

function parseDateString(dateString, token_date, token_hour) {
    var pieces = dateString.split(token_date);
    var years = parseInt(pieces[0], 10);
    var months = parseInt(pieces[1], 10) - 1; // months are 0 based
    var days = parseInt(pieces[2].split(' ')[0], 10);
    var hours = parseInt(pieces[2].split(' ')[1].split(token_hour)[0],10);
    var minutes = parseInt(pieces[2].split(' ')[1].split(token_hour)[1],10);
    var seconds =  parseInt(pieces[2].split(' ')[1].split(token_hour)[2],10);
    var date = new Date(years,months,days,hours,minutes,seconds);
    return date;
}


function ajaxRequest(url, method, dataType, callback, error) {
    $.ajax(
    {
        url: url,
        context: document.body,
        type: method,
        dataType: dataType,
        success: function(data){
            callback(data);
        },
        error: function(e, jqxhr, settings, exception) {
            error(e, jqxhr, settings, exception);
        }
    });
}

function ajaxRequest_no_error(url, method, dataType, callback) {
    $.ajax(
        {
            url: url,
            context: document.body,
            type: method,
            dataType: dataType,
            success: function(data){
                callback(data);
            }
        });
}