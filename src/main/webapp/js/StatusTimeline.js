/*
 Author: scott fu
 */
(function($, Snap){
    // Entry
    $.fn.equipTimeLine = function(options) {
        var timeLine = new TimeScale(this, options);
        console.log(this);
        return timeLine.createInstance();
    };
    // Constructor
    var TimeScale = function(selector, options) {
        this.$elem = selector;
        this.now = new Date();
        this.defaultOptions = {
            tickHeight: 8,
            textHeight: 10,
            maxBarCount : 4,
            type: 'hours',
            majorTicks:1
        };
        this.options = $.extend({}, this.defaultOptions, options);

    };
    // TimeScale prototype
    TimeScale.prototype = {
        createInstance: function(a) {
            if (this.$elem.nodeName) {
                if (this.element.nodeName == "INPUT" || this.element.nodeName == "BUTTON") {
                    throw "can be rendered only from a DIV tag."
                }
            }
            return this.render();
        },
        render : function() {

            var _this = this;
            var _now = this.now;
            var tickHeight = this.options.tickHeight;
            var textHeight = this.options.textHeight;

            var _stateMap = {
                1:'Engineering',
                2:'Productive',
                3:'Standby',
                4:'NonScheduled',
                5:'ScheduledDown',
                6:'UnscheduledDown'
            };

            this.lineElements = [];
            this.innerHTML = '';
            this.$elem.css('padding',this.$elem.width() * 0.015 + 'px');
            this.paddingX = (this.$elem.innerWidth() - this.$elem.width())/2;
            this.paddingY = (this.$elem.innerHeight() - this.$elem.height())/2;
//            console.log('---------width&height-----------');
//            console.log('width:' + this.$elem.width());
//            console.log('height:' + this.$elem.height());
//            console.log('---------width&height-----------');
            /*console.log('paddingX:' + this.paddingX);
             console.log('paddingY:' + this.paddingY);
             console.log('width:' + this.$elem.width());
             console.log('height:' + this.$elem.height());
             console.log('inner width:' + this.$elem.innerWidth());
             console.log('inner height:' + this.$elem.innerHeight());*/
            var heightUnit;

            if (this.options.machineSeries.length > this.options.maxBarCount) {
                heightUnit = this.$elem.height() / this.options.machineSeries.length;
            } else {
                heightUnit = this.$elem.height() / this.options.maxBarCount;
            }

            var actMachCount = this.options.machineSeries.length;


            this.$elem.height(actMachCount * heightUnit);

            this.width = this.$elem.width();
            this.height = this.$elem.height();

            this.yAxisOfMachines = {};
            this.centerY = {};
            // assign Y axis positions
            for(var i = 0 ; i < this.options.machineSeries.length; i++) {

                this.yAxisOfMachines[this.options.machineSeries[i].name]= {
                    y : heightUnit * i + this.paddingY/2 ,
                    height : this.height / actMachCount - this.paddingY/2
                };

                this.centerY[this.options.machineSeries[i].name] = {
                    y : (heightUnit * i + this.paddingY/2) + (this.height / actMachCount - this.paddingY/2)/2
                };
            }


            /*console.log(this.yAxisOfMachines);
             console.log('--------------------------------------');
             console.log(this.centerY);*/
            this.$elem.height(actMachCount * heightUnit + 3 * this.paddingY);
            this.height = this.$elem.height();
            this.scottsvg = $(this._svg('svg'))
                .css({'width':'100%','height':'100%','position':'relative'}); // position relative
            this.scottsvg.appendTo(this.$elem);

            var background = $(this._svg('g'))
                .attr("class", "background")
                .css({'width':'99%','height':'99%','position':'relative'});


//            background.css({'width':'100%','height':'99%','position':'absolute'});
            background.appendTo(this.scottsvg);

            this.bottomLineX = this.paddingX;
            this.bottomLineY = this.height  - textHeight - tickHeight - this.paddingX;
            this.bottomLineX1 = this.width - this.paddingX;

//            var divStatus = $(document.createElement("li"));

            var statusSvg = $(this._svg('svg'))
                .css({'width':'100%','height':'100%','position':'relative'}); // position relative
//            statusSvg.appendTo(divStatus);

            var backgroundStatus = $(this._svg('g'))
                .attr("class", "backgroundStatus")
                .css({'width':'99%','height':'99%','position':'relative'});
            backgroundStatus.appendTo(statusSvg);

            $.each(_this.centerY,function(key,obj){
//                console.log(key);
                _this.lineElements.push(_this._line(
                    _this.bottomLineX,
                    obj.y,
                        _this.bottomLineX - 10,
                    obj.y,
                    {
                        fill: _this.options.lineColor
                    }
                ).attr("stroke", _this.options.lineColor).attr("stroke-width", 1));

                var _fill = '';
                $.each(_this.options.machineSeries,function(i,machine){
                    if(machine.name === key) {
                        _fill = _this.options.machineStatusColor[_stateMap[machine.currentState]];
                    }
                });
                var circle = _this._circle(70, obj.y, heightUnit / 2.3, {
                    fill: _fill
                }).attr("stroke", _this.options.lineColor).attr("stroke-width", 1);
//                console.log(circle);
                circle.appendTo(backgroundStatus);
            });

            console.log(backgroundStatus);
            var ret = statusSvg;
            var bottomLine = this._line(
                this.bottomLineX,
                this.bottomLineY ,
                this.bottomLineX1,
                this.bottomLineY,
                {
                    fill: this.options.lineColor
                }
            ).attr("stroke", this.options.lineColor).attr("stroke-width", 1);
            this.lineElements.push(bottomLine);

            var type = this.options.type;
            var sp;
            var offset;

            var startDate = this._parseDateString(this.options.startD);
            var endDate = this._parseDateString(this.options.endD);

            var dateForType;

            if(type === 'hours') {
                offset =  (endDate.valueOf() - startDate.valueOf())/1000/3600;
            } else if(type === 'minutes') {
                offset =  (endDate.valueOf() - startDate.valueOf())/1000/60;
            } else if(type === 'years') {
                offset =  (endDate.valueOf() - startDate.valueOf())/1000/3600/24/365; // TODO for leap years
            } else {
                sp = startDate.getFullYear();
                offset = endDate.getFullYear();
            }
            for (var i = 0; i <= offset; i++) {
                var isMajorTick = (i % this.options.majorTicks === 0);
                if (isMajorTick) {
                    dateForType = this._dateOperation(type,i,startDate);
                    var tickLabelText = dateForType.getHours() + ":00";
                    var x = this._getX(dateForType);
                    if(i === 0) {
                        this.xStart = this.bottomLineX;
                        this.lineElements.push(this._line(
                            this.bottomLineX,0,
                            this.bottomLineX,this.height - textHeight - tickHeight,
                            {
                                fill: this.options.lineColor
                            }).attr("stroke", this.options.lineColor).attr("stroke-width", 1));
                    } else if(i === offset) {
                        this.xEnd = this.bottomLineX1;
                        this.lineElements.push(this._line(
                            this.bottomLineX1,0,
                            this.bottomLineX1,this.height - textHeight - tickHeight,
                            {
                                fill: this.options.lineColor
                            }
                        ).attr("stroke", this.options.lineColor).attr("stroke-width", 1));
                    } else {
                        this.lineElements.push(this._line(
                            x,this.bottomLineY,
                            x,this.height - textHeight - tickHeight,
                            {
                                fill: this.options.lineColor
                            }
                        ).attr("stroke", this.options.lineColor).attr("stroke-width", 1));
//                        this.lineElements.push(intervalTick);
                    }
                    var tickLabel = this._text(
                        x,this.height - textHeight + 2,tickLabelText,
                        {
                            fill: this.options.textColor,
                            "font-size": this.paddingX,
                            "font-family":"Calibri",
                            "text-anchor": "middle"
                        }
                    );
                    this.lineElements.push(tickLabel);
                }
            }

            /*var startDate = this._parseDateString(this.options.startD);
            var endDate = this._parseDateString(this.options.endD);*/
            var xNow = this._getX(_now);
            // for not drawing now tick while switching shifts
            if(endDate < _now) {
                this.xNow = this._getX(endDate);
            } else {
                this.xNow = this._getX(_now);
                var nowTick = this._lineNowTick(
                    xNow,0,
                    xNow,this.height,
                    {
                        fill: this.options.lineColor
                    },null).attr("stroke", 'indianred').attr("stroke-width", 0.8).attr('id','line_now_tick');
                var notReachArea = this.drawStatusBar(_this,background);
                this.lineElements.push(nowTick);
                /*setInterval(function(){
                    var _previousTime = _now;
                    var _newDate = new Date();
                    console.log(_previousTime);
                    console.log(_newDate);

                    var url = _this.options.dataProperties.dataSource
                        + '&startTime=' + _previousTime.valueOf()
                        + '&endTime=' + _newDate.valueOf();
                    console.log(url);
                    _now = _newDate;

                    var x = _this._getX(_newDate);
                    var timeDelta = x - _this.xNow;
                    _this.xNow = x;
                    nowTick = _this._lineNowTick(
                        x,0,
                        x,_this.height,
                        {
                            fill: _this.options.lineColor
                        },nowTick
                    ).attr("stroke", 'indianred').attr("stroke-width", 0.8).attr('id','line_now_tick');
                    _this.updateStatusBar(url,_this,background,timeDelta,notReachArea);
                }, _this.options.dataProperties.timeInterval * 1000); // base on minutes*/

            }


            this.drawLines(_this.lineElements,background);


            return ret;
            //////////////////////////////////////////////////////////////
            // Inner Methods
            //////////////////////////////////////////////////////////////
        },_getX : function(date) {
            var dateValue = date.valueOf();
            var start = this._parseDateString(this.options.startD).valueOf();
            var end = this._parseDateString(this.options.endD).valueOf();
            var x = ((dateValue - start) / (end - start) * (this.bottomLineX1 - this.bottomLineX)) + this.paddingX;
//            _getDateForInterval(x);
            return x;
        },_line : function(x1, y1, x2, y2, options) {
            var element = $(this._svg("line"))
                .attr("x1", x1)
                .attr("y1", y1)
                .attr("x2", x2)
                .attr("y2", y2);
            this._setSvgOptions(element, options);
            return element;
        },_circle : function(cx,cy,radius,options) {
            var element = $(this._svg("circle"))
                .attr("cx", cx)
                .attr("cy", cy)
                .attr("r", radius);
            this._setSvgOptions(element, options);
            return element;
        },_lineNowTick : function(x1, y1, x2, y2, options,nowTick) {
            var element;
            if(!nowTick) {
                element = $(this._svg("line"))
                    .attr("x1", x1)
                    .attr("y1", y1)
                    .attr("x2", x2)
                    .attr("y2", y2);
            } else {
                element = nowTick;
                element
                    .attr("x1", x1)
                    .attr("y1", y1)
                    .attr("x2", x2)
                    .attr("y2", y2);
            }
            this._setSvgOptions(element, options);
            return element;
        },_text : function(x, y, text, options) {
            var element = $(this._svg("text"))
                .attr("x", x)
                .attr("y", y)
                .text(text);
            this._setSvgOptions(element, options);
            return element;
        },_rectangle : function(x,y,width,height,options) {
            var element = $(this._svg("rect"))
                .attr("x", x)
                .attr("y", y)
                .attr("width", width)
                .attr("height", height);
            this._setSvgOptions(element, options);
            return element;
        }, _svg : function(tagName) {
            var svg = document.createElementNS('http://www.w3.org/2000/svg', tagName); //w3c svg namespace
            return svg;
        },
        //////////////////////////////////////////////////////////////
        // Drawings
        //////////////////////////////////////////////////////////////
        drawLines : function(lineElements,background) {
            $.each(lineElements,function(i,elem){
                elem.appendTo(background);
            });
        },drawStatusBar : function(thisObj,background) {
//            thisObj.yAxisOfMachines
            var dailyList;
            var x;
            var xNext;
            var startStatus;
            var width;
            var machineName;
            var area = {};
            for(var i = 0 ; i < thisObj.options.machineSeries.length; i++) {
                dailyList = $(thisObj.options.machineSeries[i].data);
                machineName = thisObj.options.machineSeries[i].name;
                if(dailyList.length === 1) {
                    x = thisObj.xStart;
                    var width = thisObj.xNow - thisObj.xStart;
                    thisObj._rectangle(
                        x,thisObj.yAxisOfMachines[machineName].y,
                        width,thisObj.yAxisOfMachines[machineName].height,
                        {
                            fill: thisObj.options.machineStatusColor[dailyList.get(0).state],
                            latest : machineName
                        }
                    ).appendTo(background);

                    var notReachArea =  thisObj._rectangle(
                        thisObj.xNow,thisObj.yAxisOfMachines[machineName].y,
                            thisObj.xEnd - thisObj.xNow,thisObj.yAxisOfMachines[machineName].height,
                        {
                            fill: '#F4EEE0'
                        }
                    );
                    notReachArea.appendTo(background);
                    area[machineName] = notReachArea;
                } else {
                    for (var j = dailyList.length - 1; j >= 0; j--) {
                        if (j === dailyList.length - 1) {
                            x = thisObj.xStart;
                        } else if(j === 0) {
                            width = this.xNow - x;
                            thisObj._rectangle(
                                x,
                                thisObj.yAxisOfMachines[machineName].y,
                                width,
                                thisObj.yAxisOfMachines[machineName].height,
                                {
                                    fill : thisObj.options.machineStatusColor[dailyList.get(j).state],
                                    latest : machineName
                                }
                            ).appendTo(background);
                            var notReachArea = thisObj._rectangle(
                                thisObj.xNow,thisObj.yAxisOfMachines[machineName].y,
                                    thisObj.xEnd - thisObj.xNow,thisObj.yAxisOfMachines[machineName].height,
                                {fill: '#F4EEE0'}
                            );
                            notReachArea.appendTo(background);
                            area[machineName] = notReachArea;
                        } else {
                            xNext = thisObj._getX(thisObj._parseDateString(dailyList.get(j).createTimeString));
                            width = xNext - x;
                            thisObj._rectangle(
                                x,thisObj.yAxisOfMachines[machineName].y,
                                width,thisObj.yAxisOfMachines[machineName].height,
                                {
                                    fill : thisObj.options.machineStatusColor[startStatus]
                                }
                            ).appendTo(background);
                            x = xNext;
                        }
                        startStatus = dailyList.get(j).state;
                    }
                }
            }
//            console.log(area);
            return area;
        },updateStatusBar : function(url,thisObj,background,xDelta,_notReachArea) {
            $.ajax({
                url: url,
                type: 'GET',
                dataType: 'JSON',
                crossDomain: true,
                headers: {
                    Accept: "application/json; charset=utf-8",
                    'Access-Control-Allow-Origin':'*'

                },
                success: function(data) {
                    drawDeltaBar(data);
                }
            });

            function drawDeltaBar(data){
                $.each(data, function(i, elem){
                    var notReachArea = _notReachArea[elem.equipmentName];
                    var latestArea = $("[latest='"+elem.equipmentName+"']");
//                    console.log(latestArea);
//                    console.log(notReachArea);
                    var notReachAreaX = parseFloat(notReachArea.attr('x'));
                    var notReachAreaY = parseFloat(notReachArea.attr('y'));
                    var notReachAreaWidth = parseFloat(notReachArea.attr('width'));
                    var notReachAreaHeight = parseFloat(notReachArea.attr('height'));
                    var x;
                    var xNext;
                    var status;
                    var newArea;
                    notReachArea.attr('x',parseFloat(notReachArea.attr("x")) + xDelta);
                    notReachArea.attr('width',parseFloat(notReachArea.attr("width")) - xDelta);
                    // no state change
                    if(elem.machinesDailyList.length === 1) {
                        latestArea.attr('width',parseFloat(latestArea.attr('width')) + xDelta);
                    } else {
                        elem.machinesDailyList.reverse();
                        var width;
                        $.each(elem.machinesDailyList,function(j,daily){
                            // latest daily machine status
                            if(j === elem.machinesDailyList.length - 1) {
                                x = parseFloat(latestArea.attr('x')) + parseFloat(latestArea.attr('width'));
                                latestArea.attr('latest','');
                                // new latest machine status
                            } else if(j === 0) {
                                xNext = thisObj._getX(thisObj._parseDateString(daily.createTimeString));
                                width = xNext - x;
                                newArea = thisObj._rectangle(
                                    x,parseFloat(latestArea.attr('y')),
                                    width,parseFloat(latestArea.attr('height')),
                                    {
                                        fill : status
                                    }
                                );
                                newArea.after(latestArea);
                                newArea.attr('latest',elem.equipmentName);
                            } else {
                                xNext = thisObj._getX(thisObj._parseDateString(daily.createTimeString));
                                width = xNext - x;
                                newArea = thisObj._rectangle(
                                    x,parseFloat(latestArea.attr('y')),
                                    width,parseFloat(latestArea.attr('height')),
                                    {
                                        fill : status
                                    }
                                );
                                newArea.after(latestArea);
                                latestArea = newArea;
                                x = xNext;
                            }
                            status = latestArea.attr('fill');
                        });
                    }
                })
            };
            //////////////////////////////////////////////////////////////
            // Utilities
            //////////////////////////////////////////////////////////////
        },_parseDateString : function(dateString) {
            var pieces = dateString.split("-");
            var years = parseInt(pieces[0], 10);
            var months = parseInt(pieces[1], 10) - 1; // months are 0 based
            var days = parseInt(pieces[2].split(' ')[0], 10);
            var hours = parseInt(pieces[2].split(' ')[1].split(':')[0],10);
            var minutes = parseInt(pieces[2].split(' ')[1].split(':')[1],10);
            var seconds =  parseInt(pieces[2].split(' ')[1].split(':')[2],10);
            var date = new Date(years,months,days,hours,minutes,seconds);
            return date;
        },_setSvgOptions : function setSvgOptions(element, options) {
            if (options) {
                for (var i in options) {
                    element.attr(i, options[i]);
                }
            }
        },_dateOperation : function (type, interval, date) {
//            var dateReturn = $.extend(true, {}, date); // jquery deep clone
            var dateReturn = new Date(date.getTime());
            switch (type) {
                case   "years"   :
                {
                    dateReturn.setFullYear(date.getFullYear() + interval);
                    break;
                }
                case   "quarter"   :
                {
                    dateReturn.setMonth(date.getMonth() + interval * 3);
                    break;
                }
                case   "months"   :
                {
                    dateReturn.setMonth(date.getMonth() + interval);
                    return date;
                    break;
                }
                case   "week"   :
                {
                    dateReturn.setDate(date.getDate() + interval * 7);
                    break;
                }
                case   "date"   :
                {
                    dateReturn.setDate(date.getDate() + interval);
                    break;
                }
                case   "hours"   :
                {
                    dateReturn.setHours(date.getHours() + interval);
                    break;
                }
                case   "minutes"   :
                {
                    dateReturn.setMinutes(date.getMinutes() + interval);
                    break;
                }
                case   "seconds"   :
                {
                    dateReturn.setSeconds(date.getSeconds() + interval);
                    break;
                }
                default:
                {
                    dateReturn.setDate(date.getDate() + interval);
                    break;
                }
            }
            return dateReturn;
        },_clone : function(obj) {
            var o;
            switch(typeof obj){
                case 'undefined': break;
                case 'string'   : o = obj + '';break;
                case 'number'   : o = obj - 0;break;
                case 'boolean'  : o = obj;break;
                case 'object'   :
                    if(obj === null){
                        o = null;
                    }else{
                        if(obj instanceof Array){
                            o = [];
                            for(var i = 0, len = obj.length; i < len; i++){
                                o.push(this._clone(obj[i]));
                            }
                        }else{
                            o = {};
                            for(var k in obj){
                                o[k] = this._clone(obj[k]);
                            }
                        }
                    }
                    break;
                default:
                    o = obj;break;
            }
            return o;
        }
    };
})(jQuery, Snap);