package com.scott.fu.job;

import com.scott.fu.dto.*;
import com.scott.fu.entity.oee.MaterialTAndMHistory;
import com.scott.fu.service.PresentationService;
import com.scott.fu.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by ScottFu on 2016/1/20.
 */
public class CacheDataJob {

    @Autowired
    private PresentationService presentationService;

    private boolean isInit = false;

    private TrackConcurrentMap<String, EquipmentTMDTO> trackConcurrentMap
            = new TrackConcurrentMap<String, EquipmentTMDTO>();

    /**
     * @throws Exception
     */
    public void loadCache() throws Exception{

        if(!isInit) {
            Date now = new Date();
            // retrieve data in last 36 hours
            Long startTimeMilli = now.getTime() - 36 * 3600 * 1000;
            Date startDate = new Date(startTimeMilli);
            System.out.println("in controller,now time is::::" + now);

            List<MaterialTAndMHistory> materialTAndMHistories = presentationService.getMachineDailyHistoryBase("PRF",
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
            trackConcurrentMap.put("PRF",equipmentTMDTO);
            isInit = true;
        } else {

        }
    }

    public TrackConcurrentMap<String, EquipmentTMDTO> getTrackConcurrentMap() {
        return trackConcurrentMap;
    }
}
