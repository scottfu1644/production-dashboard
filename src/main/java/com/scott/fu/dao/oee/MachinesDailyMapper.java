package com.scott.fu.dao.oee;

import com.scott.fu.entity.oee.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MachinesDailyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OEE.MachinesDaily
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    int countByExample(MachinesDailyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OEE.MachinesDaily
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    int deleteByExample(MachinesDailyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OEE.MachinesDaily
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OEE.MachinesDaily
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    int insert(MachinesDaily record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OEE.MachinesDaily
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    int insertSelective(MachinesDaily record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OEE.MachinesDaily
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    List<MachinesDaily> selectByExample(MachinesDailyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OEE.MachinesDaily
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    MachinesDaily selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OEE.MachinesDaily
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    int updateByExampleSelective(@Param("record") MachinesDaily record, @Param("example") MachinesDailyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OEE.MachinesDaily
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    int updateByExample(@Param("record") MachinesDaily record, @Param("example") MachinesDailyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OEE.MachinesDaily
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    int updateByPrimaryKeySelective(MachinesDaily record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table OEE.MachinesDaily
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    int updateByPrimaryKey(MachinesDaily record);


    List<MachinesDaily> selectUnionByResName(
            @Param(value = "resName") String resName,
            @Param(value = "timeStart") String timeStart,
            @Param(value = "timeEnd") String timeEnd);

    List<MaterialTAndMHistory> selectMaterialTAndMHistory(
            @Param(value = "title") String resName,
            @Param(value = "startTime") String timeStart,
            @Param(value = "endTime") String timeEnd);
    List<DevOutput> selectDevOutputData();

    /*List<PRFTrackOutAndWIP> selectStepTrackOutWIPPRF(@Param(value = "title") String resName);

    List<QVMTrackOutAndWIP> selectStepTrackOutWIPQVM(@Param(value = "title") String resName);

    List<DicingTrackOutAndWIP> selectStepTrackOutWIPDicing(@Param(value = "title") String resName);

    List<DefluxTrackOutAndWIP> selectStepTrackOutWIPDfx(@Param(value = "title") String resName);

    List<UballTrackOutAndWIP> selectStepTrackOutWIPUby(@Param(value = "title") String resName);

    List<BFLTrackOutAndWIP> selectStepTrackOutWIPBFL(@Param(value = "title") String resName);

    List<AVRTrackOutAndWIP> selectStepTrackOutWIPAVR(@Param(value = "title") String resName);

    List<LACTrackOutAndWIP> selectStepTrackOutWIPLAC(@Param(value = "title") String resName);*/
}