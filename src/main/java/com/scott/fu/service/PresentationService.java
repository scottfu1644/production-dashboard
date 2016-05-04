package com.scott.fu.service;

import com.scott.fu.dao.EquipmentDao;
import com.scott.fu.dao.mes.ProductionOrderHeadMapper;
import com.scott.fu.dao.mes.ProductionOrderStepMapper;
import com.scott.fu.dao.mes.ProductionOrderStepScrapMapper;
import com.scott.fu.dao.oee.MachinesDailyMapper;
import com.scott.fu.dto.MachineStepDTO;
import com.scott.fu.entity.DeptStep;
import com.scott.fu.entity.MachStep;
import com.scott.fu.entity.mes.ProductionOrderHead;
import com.scott.fu.entity.mes.ProductionOrderHeadExample;
import com.scott.fu.entity.mes.ProductionOrderStep;
import com.scott.fu.entity.mes.ProductionOrderStepExample;
import com.scott.fu.entity.oee.MachinesDaily;
import com.scott.fu.entity.oee.MachinesDailyExample;
import com.scott.fu.entity.oee.MaterialTAndMHistory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by ScottFu on 2015/12/28.
 */

@Service
@Transactional
public class PresentationService {
    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private EquipmentDao equipmentDao;

    private ProductionOrderHeadMapper productionOrderHeadMapper;

    private ProductionOrderHeadExample productionOrderHeadExample;

    private ProductionOrderStepExample productionOrderStepExample;

    private ProductionOrderStepMapper productionOrderStepMapper;

    private ProductionOrderStepScrapMapper productionOrderStepScrapMapper;

    private MachinesDailyMapper machinesDailyMapper;

    private MachinesDailyExample machinesDailyExample;


    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public List<ProductionOrderStep> getProductionOrderStepByLotName(String lotName) {
        productionOrderStepMapper = sqlSession.getMapper(ProductionOrderStepMapper.class);
        productionOrderStepExample = new ProductionOrderStepExample();
        productionOrderStepExample.createCriteria().andLotNumMesEqualTo(lotName);
        List<ProductionOrderStep> productionOrderSteps
                = productionOrderStepMapper.selectByExample(productionOrderStepExample);
        return productionOrderSteps;
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public List<ProductionOrderHead> getProductionOrderHeads(String lotName) {
        productionOrderHeadMapper = sqlSession.getMapper(ProductionOrderHeadMapper.class);
        productionOrderHeadExample = new ProductionOrderHeadExample();
        if(lotName != null && !lotName.equals("")) {
            productionOrderHeadExample.createCriteria().andLotNumMesEqualTo(lotName);
        }
        List<ProductionOrderHead> productionOrderHeads
                = productionOrderHeadMapper.selectByExample(productionOrderHeadExample);
        return productionOrderHeads;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public List<ProductionOrderHead> getProductionOrderHeadFetchStep(String lotName) {
        productionOrderHeadMapper = sqlSession.getMapper(ProductionOrderHeadMapper.class);
        List<ProductionOrderHead> productionOrderHeads
                = productionOrderHeadMapper.selectOrderHeadFetchStepsForHalfDayMetro();
        return productionOrderHeads;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public List<MachinesDaily> getMachinesDaily() {
        machinesDailyMapper = sqlSession.getMapper(MachinesDailyMapper.class);
        machinesDailyExample = new MachinesDailyExample();
        machinesDailyExample
                .createCriteria()
                .andResourceIn(Arrays.asList(new String[]{"DNV101","DNV102","TNV101","TNV102"}));
        List<MachinesDaily> machinesDailyList
                = machinesDailyMapper.selectByExample(machinesDailyExample);
        return machinesDailyList;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public List<MachinesDaily> getMachinesDailyByResName(String resName, Date beginTime, Date endTime) {
        machinesDailyMapper = sqlSession.getMapper(MachinesDailyMapper.class);
        machinesDailyExample = new MachinesDailyExample();
        if(beginTime != null && endTime != null) {
            machinesDailyExample
                .createCriteria()
                .andResourceEqualTo(resName)
                .andCreatetimeGreaterThanOrEqualTo(beginTime)
                .andCreatetimeLessThan(endTime);
        } else {
            machinesDailyExample
                .createCriteria()
                .andResourceEqualTo(resName);
        }
        machinesDailyExample.setOrderByClause("CreateTime Desc");
        return machinesDailyMapper.selectByExample(machinesDailyExample);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public List<MachinesDaily> getMachineDailyByResNameUnion(String resName, String beginTime, String endTime) {
        machinesDailyMapper = sqlSession.getMapper(MachinesDailyMapper.class);

        List<MachinesDaily> machinesDailyList = machinesDailyMapper.selectUnionByResName(resName,
                beginTime,
                endTime);
        return machinesDailyList;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public List<MaterialTAndMHistory> getMachineDailyHistoryBase(String title, String beginTime, String endTime) {
        machinesDailyMapper = sqlSession.getMapper(MachinesDailyMapper.class);
        List<MaterialTAndMHistory> machinesDailyList = null;
        try {
            machinesDailyList = machinesDailyMapper.selectMaterialTAndMHistory(title,
                    beginTime,
                    endTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return machinesDailyList;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public Object getEquipOutputWIPByShift(String title,
                                           String startTime,
                                           String endTime,
                                           String shift) {
        return equipmentDao.queryEquipmentOutWipList(title,startTime,endTime,shift);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public Object getEquipmentCurrentShift(String title) {
        return equipmentDao.queryEquipmentCurrentShift(title);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public Object getEquipLastShift(String title) {
        return equipmentDao.queryEquipmentLastShift(title);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public Object getEquipHoldInprocessLots(String title) {
        return equipmentDao.queryEquipmentHoldInprocessLots(title);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public Object getEquipmentShiftSummary(String title, String startTime,String endTime) {
        return equipmentDao.queryShiftSummary(title, startTime,endTime);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public Map<String,MachineStepDTO> getMachineStepMap() {
        List<MachStep> machStepList = equipmentDao.queryMachineStepMap();
        Map<String,MachineStepDTO> machineStepMap = new HashMap<String, MachineStepDTO>();
        MachineStepDTO machineStepDTO = null;
        for(MachStep machStep : machStepList) {
            if(machineStepMap.get(machStep.gettITLE()) == null) {
                machineStepDTO = new MachineStepDTO();
                List<String> machineList = new ArrayList<String>();
                List<String> mCodesList =  new ArrayList<String>();

                for(String m : machStep.getMachines().split(",")) {
                    machineList.add(m);
                }
                machineStepDTO.setMachines(machineList);
                machineStepDTO.setOutput(
                        "FP".equals(machStep.getoUTPUT_FORM()) ? "Full Panel" :
                                "QP".equals(machStep.getoUTPUT_FORM()) ? "Quarter Panel" :
                                       "Lot".equals(machStep.getoUTPUT_FORM()) ? "Lot" : "Units"
                );
                machineStepDTO.setWip(
                        "FP".equals(machStep.getwIP_FORM()) ? "Full Panel" :
                                "QP".equals(machStep.getwIP_FORM()) ? "Quarter Panel" :
                                        "Lot".equals(machStep.getwIP_FORM()) ? "Lot" : "Units"
                );
                machineStepDTO.setTarget(new Float(machStep.gettARGET()));
                mCodesList.add(machStep.getmCode());
                machineStepDTO.setmCode(mCodesList);
                machineStepMap.put(machStep.gettITLE(), machineStepDTO);
            } else {
                machineStepDTO = machineStepMap.get(machStep.gettITLE());
                for(String m : machStep.getMachines().split(",")) {
                    machineStepDTO.getMachines().add(m);
                }
                machineStepDTO.getmCode().add(machStep.getmCode());
                machineStepMap.put(machStep.gettITLE(),machineStepDTO);
            }
        }
        return machineStepMap;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public Map<String,List<String>> getDepartmentStepMap() {
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        List<DeptStep> deptSteps =  equipmentDao.queryDepartmentSteps();
        String titles = "";
        String deptName = "";
        List<String> list = null;
        for(DeptStep deptStep : deptSteps) {
            deptName = deptStep.getDeptName();
            titles = deptStep.getTitles();
            if(deptName.contains("/")) {
                for(String dept: deptName.split("/")) {
                    if(map.get(dept.trim()) == null) {
                        list = new ArrayList<String>();
                        list.add(titles);
                        map.put(dept.trim(),list);
                    } else {
                        map.get(dept.trim()).add(titles);
                    }
                }
            } else {
                list = new ArrayList<String>();
                if(map.get(deptName) == null) {

                    for(String title : titles.split(",")) {
                        list.add(title);
                    }
                    map.put(deptName,list);
                } else {
                    for(String title : titles.split(",")) {
                        map.get(deptName).add(title);
                    }

                }
            }
        }
        return map;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public Object queryMachineStepStatus(String title) {
        return equipmentDao.queryMachineStepStatus(title);
    }
}
