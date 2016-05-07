package com.scott.fu.controller;

import com.scott.fu.dto.EquipmentStatusDTO;
import com.scott.fu.dto.MachineStepDTO;
import com.scott.fu.dto.StatusDTO;
import com.scott.fu.entity.oee.MachinesDaily;
import com.scott.fu.job.CacheDataJob;
import com.scott.fu.service.PresentationService;
import com.scott.fu.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.*;

/**
 * Created by Scottfu on 2016/1/1.
 * @author Scottfu
 */
@Controller
@RequestMapping("/api")
public class DashboardController {
    @Autowired
    private ServletContext servletContext;

    @Autowired
    CacheDataJob cacheJob;
//
//    @Autowired
//    private HttpServletRequest request;

    @Autowired
    private PresentationService presentationService;


    /**
     *
     * @param title
     * @return
     */
    @RequestMapping(value = "/equipStep/dtDaily/{title}", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public @ResponseBody Object getDailyMachineDAndT2(@PathVariable String title,
                                                      @RequestParam(value = "startTime",required = true) Long startTimeMill,
                                                      @RequestParam(value = "endTime",required = true) Long endTimeMill,
                                                      @RequestParam(value = "shift",required = true) String shift) {
       String startTime = DateUtil.getInstance(DateUtil.DATE_TIME_SEC_CN).format(new Date(startTimeMill));
       String endTime = DateUtil.getInstance(DateUtil.DATE_TIME_SEC_CN).format(new Date(endTimeMill));
       return presentationService.getEquipOutputWIPByShift(title,startTime,endTime,shift);
    }

    /**
     *
     * @param title
     * @return
     */
    @RequestMapping(value = "/equipStep/dtDaily/currentShift/{title}", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public @ResponseBody Object getDailyMachineCurrentShift(@PathVariable String title) {
        return presentationService.getEquipmentCurrentShift(title);
    }

    /**
     *
     * @param title
     * @return
     */
    @RequestMapping(value = "/equipStep/dtDaily/holdInprocess/{title}", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public @ResponseBody Object getDailyMachineShiftSummary(@PathVariable String title) {
        return presentationService.getEquipHoldInprocessLots(title);
    }



    /**
     *
     * @param title
     * @return
     */
    @RequestMapping(value = "/equipStep/dtDaily/lastShift/{title}", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public @ResponseBody Object getDailyMachineLastShift(@PathVariable String title) {
        return presentationService.getEquipLastShift(title);
    }

    /**
     *
     * @param title
     * @return
     */
    @RequestMapping(value = "/equipStep/dtDaily/shiftSummary/{title}", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public @ResponseBody Object getDailyMachineHoldInprocess(
            @PathVariable String title,
            @RequestParam(value = "startTime",required = true) Long startTimeMill,
            @RequestParam(value = "endTime",required = true) Long endTimeMill) {
        String startTime = DateUtil.getInstance(DateUtil.DATE_TIME_SEC_CN).format(new Date(startTimeMill));
        String endTime = DateUtil.getInstance(DateUtil.DATE_TIME_SEC_CN).format(new Date(endTimeMill));
        return presentationService.getEquipmentShiftSummary(title, startTime, endTime);
    }

    @RequestMapping(value = "/equipStep/dtDaily/machinStepMap", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public @ResponseBody Map<String,MachineStepDTO> getMachineStepMap() {
        return presentationService.getMachineStepMap();
    }

    @RequestMapping(value = "/equipStep/dtDaily/deptTitleMap", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public @ResponseBody Map<String,List<String>> getDepartmentTitleMap() {
        return presentationService.getDepartmentStepMap();
    }

    @RequestMapping(value = "/equipStep/dtDaily/machineStepStatus/{title}", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public @ResponseBody Object getMachineSteStatus(@PathVariable String title) {
        return presentationService.queryMachineStepStatus(title);
    }

    /**
     *
     * @param title
     * @return
     */
    /*@RequestMapping(value = "/step/dtDaily/{title}", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public @ResponseBody  Map<String,EquipmentTMDTO> getDailyMachineDAndT(@PathVariable String title) {
        Date now = new Date();
        // retrieve data in last 36 hours
        Long startTimeMilli = now.getTime() - 36 * 3600 * 1000;
        Date startDate = new Date(startTimeMilli);
        System.out.println("in controller,now time is::::" + now);

        List<MaterialTAndMHistory> materialTAndMHistories = presentationService.getMachineDailyHistoryBase(title,
                DateUtil.getInstance(DateUtil.DATE_TIME_SEC_CN).format(startDate),
                DateUtil.getInstance(DateUtil.DATE_TIME_SEC_CN).format(now));

        // format data for UI use
        Map<String,EquipmentTMDTO> equipmentTMDTOMap = new HashMap<String, EquipmentTMDTO>();
        EquipmentTMDTO equipmentTMDTO = null;
        List<EquipmentTM> equipmentTMList = null;
        for (MaterialTAndMHistory materialTAndMHistory : materialTAndMHistories) {
            String mCode = materialTAndMHistory.getM_CODE();
            if(mCode == null || mCode.equals("null") || mCode.equals("")) {
                continue;
            }
            if (equipmentTMDTOMap.get(mCode) == null) {
                equipmentTMDTO = new EquipmentTMDTO();
                equipmentTMDTO.setTarget(materialTAndMHistory.gettARGET());
                equipmentTMList = new ArrayList<EquipmentTM>();
                EquipmentTM equipmentTM = new EquipmentTM();
                equipmentTM.setDaily(materialTAndMHistory.getDaily());
                equipmentTM.setHourly(materialTAndMHistory.getHourly());
                if ("Lot".equals(materialTAndMHistory.getwIP_FORM())) {
                    equipmentTM.setOutput(Integer.valueOf(materialTAndMHistory.getMeasuredQuantity()));
                    equipmentTM.setWipAmount(Integer.valueOf(materialTAndMHistory.getwIPLots()));
                } else {
                    equipmentTM.setOutput(Integer.valueOf(materialTAndMHistory.getOutputQuantity()));
                    equipmentTM.setWipAmount(Integer.valueOf(materialTAndMHistory.getwIPQuantity()));
                }
                equipmentTMList.add(equipmentTM);
                equipmentTMDTO.setEquipmentTMList(equipmentTMList);
                equipmentTMDTOMap.put(mCode, equipmentTMDTO);
            } else {
                equipmentTMDTO = equipmentTMDTOMap.get(mCode);
                equipmentTMList = equipmentTMDTO.getEquipmentTMList();
                EquipmentTM equipmentTM = new EquipmentTM();
                equipmentTM.setDaily(materialTAndMHistory.getDaily());
                equipmentTM.setHourly(materialTAndMHistory.getHourly());
                if ("Lot".equals(materialTAndMHistory.getwIP_FORM())) {
                    equipmentTM.setOutput(Integer.valueOf(materialTAndMHistory.getMeasuredQuantity()));
                    equipmentTM.setWipAmount(Integer.valueOf(materialTAndMHistory.getwIPLots()));
                } else {
                    equipmentTM.setOutput(Integer.valueOf(materialTAndMHistory.getOutputQuantity()));
                    equipmentTM.setWipAmount(Integer.valueOf(materialTAndMHistory.getwIPQuantity()));
                }
                equipmentTMList.add(equipmentTM);
                equipmentTMDTO.setEquipmentTMList(equipmentTMList);
                equipmentTMDTOMap.put(mCode, equipmentTMDTO);
            }

        }


        // add rest data hourly for one shift
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        int hour = calendar.get(Calendar.HOUR);
        int daily = calendar.get(Calendar.DAY_OF_MONTH);
        int delta = 0;
        if(hour >=7 && hour < 19) {
            delta = 19 - hour;
        } else if(hour >= 19 && hour < 24) {
            delta = 31 - hour;
        } else if(hour >=0 && hour < 7) {
            delta = 13 - hour;
        }
        for(String mCode : equipmentTMDTOMap.keySet()) {
            equipmentTMDTO = equipmentTMDTOMap.get(mCode);
            List<EquipmentTM> equipmentTMList1 = equipmentTMDTO.getEquipmentTMList();
            for(int i = 1 ; i <= delta; i++) {
                EquipmentTM equipmentTM = new EquipmentTM();
                equipmentTM.setHourly(hour + i < 10 ? "0" + (hour + i) : (hour + i) + "");
                equipmentTM.setDaily(daily + "");
                equipmentTMList1.add(equipmentTM);
            }
            equipmentTMDTO.setEquipmentTMList(equipmentTMList1);

        }
        return equipmentTMDTOMap;
    }*/

    /**
     * this method is defined to retrieve equipment status data and return JSON to presentation tier.
     * @param isNightShift defines whether the presentation is for daytime or night shift
     * @return
     */
    @RequestMapping(value = "/metroEquip/status/{isNightShift}", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public @ResponseBody List<EquipmentStatusDTO> getMetroEquipStatusInfo(
            @PathVariable Boolean isNightShift,
            @RequestParam(value = "machines", required = false) String machines,
            @RequestParam(value = "startTime",required = false) Long startTime,
            @RequestParam(value = "endTime",required = false) Long endTime) {
        List<String> machineList = new ArrayList<String>();
        if(machines != null) {
            machineList = Arrays.asList(machines.split(","));
        } else {
            machineList.add("DNV101");
            machineList.add("DNV102");
            machineList.add("TNV101");
            machineList.add("TNV102");
        }
        Calendar calendar = Calendar.getInstance();
        Date timeNow = new Date();
        String timeNowString =  DateUtil.getInstance(DateUtil.DATE_TIME_SEC_CN).format(timeNow);
        calendar.setTime(timeNow);

        String timeNightShiftStart = null;
        String timeNightShiftEnd = null;
        String timeDayShiftStart = null;
        String timeDayShiftEnd = null;
        if(calendar.get(Calendar.HOUR_OF_DAY) < 19
                && calendar.get(Calendar.HOUR_OF_DAY) >= 7) {
            timeNightShiftEnd =
                    calendar.get(Calendar.YEAR) + "-" +
                            (calendar.get(Calendar.MONTH) + 1)  + "-" +
                            calendar.get(Calendar.DAY_OF_MONTH)
                            + " 07:00:00";
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            timeNightShiftStart =
                    calendar.get(Calendar.YEAR) + "-" +
                            (calendar.get(Calendar.MONTH) + 1)  + "-" +
                            calendar.get(Calendar.DAY_OF_MONTH)
                            + " 19:00:00";

            timeDayShiftEnd = timeNowString;
            calendar.setTime(timeNow);
            calendar.add(Calendar.HOUR, -12);
            timeDayShiftStart = timeNightShiftEnd;
        } else if(calendar.get(Calendar.HOUR_OF_DAY) >= 19
                && calendar.get(Calendar.HOUR_OF_DAY) < 24) {
            timeDayShiftStart =
                    calendar.get(Calendar.YEAR) + "-" +
                            (calendar.get(Calendar.MONTH) + 1)  + "-" +
                            calendar.get(Calendar.DAY_OF_MONTH)
                            + " 07:00:00";
            timeDayShiftEnd =
                    calendar.get(Calendar.YEAR) + "-" +
                            (calendar.get(Calendar.MONTH) + 1) + "-" +
                            calendar.get(Calendar.DAY_OF_MONTH)
                            + " 19:00:00";

            timeNightShiftEnd = timeNowString;
            calendar.setTime(timeNow);
            calendar.add(Calendar.HOUR, -12);
            timeNightShiftStart = timeDayShiftEnd;
        } else if(calendar.get(Calendar.HOUR_OF_DAY) >= 0
                && calendar.get(Calendar.HOUR_OF_DAY) < 7) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            timeDayShiftStart =
                    calendar.get(Calendar.YEAR) + "-" +
                            (calendar.get(Calendar.MONTH) + 1)  + "-" +
                            calendar.get(Calendar.DAY_OF_MONTH)
                            + " 07:00:00";

            timeDayShiftEnd =
                    calendar.get(Calendar.YEAR) + "-" +
                            (calendar.get(Calendar.MONTH) + 1)  + "-" +
                            calendar.get(Calendar.DAY_OF_MONTH)
                            + " 19:00:00";

            timeNightShiftEnd = timeNowString;
            calendar.setTime(timeNow);
            calendar.add(Calendar.HOUR, -12);
            timeNightShiftStart = timeDayShiftEnd;
        }
        List<MachinesDaily> machinesDailyList = null;
        /*
            Night shift -- 19:00 ~ 7:00am
            Day work -- 7:00am ~ 19:00
        */
        List<EquipmentStatusDTO> equipmentStatusDTOList = new ArrayList<EquipmentStatusDTO>();
        if(startTime != null && endTime != null) {
            String startTimeStr = DateUtil.getInstance(DateUtil.DATE_TIME_SEC_CN).format(new Date(startTime));
            String endTimeStr = DateUtil.getInstance(DateUtil.DATE_TIME_SEC_CN).format(new Date(endTime));
            for(String name : machineList) {
                machinesDailyList
                        = presentationService
                            .getMachineDailyByResNameUnion(
                                    name,
                                    startTimeStr,
                                    endTimeStr
                            );
                EquipmentStatusDTO equipmentStatusDTO
                        = dealWithStatus(isNightShift, machinesDailyList,startTimeStr,endTimeStr);

                equipmentStatusDTO.setEquipmentName(name);
                equipmentStatusDTO.setMachinesDailyList(machinesDailyList);
                equipmentStatusDTOList.add(equipmentStatusDTO);
            }
        } else {
            if (!isNightShift) {
                for(String name : machineList) {
                machinesDailyList
                        = presentationService.getMachineDailyByResNameUnion(name, timeDayShiftStart, timeDayShiftEnd);
                EquipmentStatusDTO equipmentStatusDTO
                        = dealWithStatus(isNightShift,machinesDailyList,timeDayShiftStart, timeDayShiftEnd);
                equipmentStatusDTO.setEquipmentName(name);
                equipmentStatusDTOList.add(equipmentStatusDTO);
            }
            } else {
                for(String name : machineList) {
                    machinesDailyList
                            = presentationService.getMachineDailyByResNameUnion(name, timeNightShiftStart, timeNightShiftEnd);
                    EquipmentStatusDTO equipmentStatusDTO
                            = dealWithStatus(isNightShift,machinesDailyList,timeNightShiftStart, timeNightShiftEnd);
                    equipmentStatusDTO.setEquipmentName(name);
                    equipmentStatusDTOList.add(equipmentStatusDTO);
                }
            }
        }
        return equipmentStatusDTOList;
    }


    private EquipmentStatusDTO dealWithStatus(Boolean isNightShift, List<MachinesDaily> machinesDailyList,
                                              String timeShiftStart,
                                              String timeShiftEnd) {
        EquipmentStatusDTO equipmentStatusDTO = new EquipmentStatusDTO();
        equipmentStatusDTO.setIsNightShift(isNightShift);
        equipmentStatusDTO
                .setBeginTime(timeShiftStart);
        equipmentStatusDTO
                .setEndTime(timeShiftEnd);
        /*long durationMiliSec = 0l;
        long timeShiftStartMilli = DateUtil.getInstance(DateUtil.DATE_TIME_SEC_CN).parse(timeShiftStart).getTime();
        long timeShiftEndMilli = DateUtil.getInstance(DateUtil.DATE_TIME_SEC_CN).parse(timeShiftEnd).getTime();*/

        List<MachinesDaily> mergedMachineList = new ArrayList<MachinesDaily>();
        String state = "";
        // TODO
        if (machinesDailyList.size() == 0) {
            ;
        } else {
            state = machinesDailyList.get(0).getState();
        }
        MachinesDaily newMachineDaily;
        int i = 0;
        for (MachinesDaily machineDaily : machinesDailyList) {
            if(!state.equals(machineDaily.getState())){
                state = machineDaily.getState();
                newMachineDaily = new MachinesDaily();
                BeanUtils.copyProperties(machinesDailyList.get(i-1),newMachineDaily);
                mergedMachineList.add(newMachineDaily);
            }
            if(i == machinesDailyList.size() - 1) {
                newMachineDaily = new MachinesDaily();
                BeanUtils.copyProperties(machineDaily,newMachineDaily);
                mergedMachineList.add(newMachineDaily);
            }
            i ++;
        }
        if (mergedMachineList.size() != 0) {
            Integer status =
            mergedMachineList.get(0).getState().equals("Engineering") ? 1 :
            mergedMachineList.get(0).getState().equals("Productive") ? 2 :
            mergedMachineList.get(0).getState().equals("Standby") ? 3 :
            mergedMachineList.get(0).getState().equals("NonScheduled") ? 4 :
            mergedMachineList.get(0).getState().equals("ScheduledDown") ? 5 :
            mergedMachineList.get(0).getState().equals("UnscheduledDown") ? 6 : -1;
            equipmentStatusDTO.setCurrentStatus(status);
        } else {
            equipmentStatusDTO.setCurrentStatus(-1);
        }

        equipmentStatusDTO.setMachinesDailyList(mergedMachineList);
        return equipmentStatusDTO;
    }
}
