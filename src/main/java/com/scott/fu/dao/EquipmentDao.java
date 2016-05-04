package com.scott.fu.dao;

import com.scott.fu.core.CoreJdbcSupport;
import com.scott.fu.entity.DeptStep;
import com.scott.fu.entity.MachStep;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ScottFu on 2016/2/24.
 */

@Repository
public class EquipmentDao extends CoreJdbcSupport {

    public Object queryEquipmentOutWipList(final String title,
                                           final String startTime,
                                           final String endTime,
                                           final String shift) {
        List<SqlParameter> parameters = new ArrayList<SqlParameter>();
        parameters.add(new SqlParameter("title",Types.VARCHAR));
        parameters.add(new SqlParameter("start_time",Types.VARCHAR));
        parameters.add(new SqlParameter("end_time",Types.VARCHAR));
        parameters.add(new SqlParameter("shift",Types.VARCHAR));
        Object result = this.jdbcTemplate.call(new CallableStatementCreator() {
            @Override
            public CallableStatement
            createCallableStatement(Connection con) throws SQLException {
                CallableStatement statement = con.prepareCall("{call [Dashboard].[Dashboard_Equipment_WIPOutputChart_TEMP](?,?,?,?) } ");
                statement.setString("title", title);
                statement.setString("start_time", startTime);
                statement.setString("end_time", endTime);
                statement.setString("shift", shift);
                return statement;
            }
        },parameters).get("#result-set-1");
        return result;
    }

    public Object queryEquipmentCurrentShift(final String title) {
        List<SqlParameter> parameters = new ArrayList<SqlParameter>();
        parameters.add(new SqlParameter("title",Types.VARCHAR));
        Object result = this.jdbcTemplate.call(new CallableStatementCreator() {
            @Override
            public CallableStatement
            createCallableStatement(Connection con) throws SQLException {
                CallableStatement statement = con.prepareCall("{call [Dashboard].[Dashboard_CurrentShift](?) } ");
                statement.setString("title", title);
                return statement;
            }
        },parameters).get("#result-set-1");
        return result;
    }

    public Object queryEquipmentLastShift(final String title) {
        List<SqlParameter> parameters = new ArrayList<SqlParameter>();
        parameters.add(new SqlParameter("title",Types.VARCHAR));

        Object result = this.jdbcTemplate.call(new CallableStatementCreator() {
            @Override
            public CallableStatement
            createCallableStatement(Connection con) throws SQLException {
                CallableStatement statement = con.prepareCall("{call [Dashboard].[Dashboard_LastShift](?) } ");
                statement.setString("title", title);
                return statement;
            }
        },parameters).get("#result-set-1");
        return result;
    }

    public Object queryEquipmentHoldInprocessLots(final String title) {
        List<SqlParameter> parameters = new ArrayList<SqlParameter>();
        parameters.add(new SqlParameter("title",Types.VARCHAR));
        Object result = this.jdbcTemplate.call(new CallableStatementCreator() {
            @Override
            public CallableStatement
            createCallableStatement(Connection con) throws SQLException {
                CallableStatement statement = con.prepareCall("{call [Dashboard].[Dashboard_HoldQty](?) } ");
                statement.setString("title", title);
                return statement;
            }
        },parameters).get("#result-set-1");
        return result;
    }

    public Object queryShiftSummary(
            final String title,
            final String startTime,
            final String endTime) {
        List<SqlParameter> parameters = new ArrayList<SqlParameter>();
        parameters.add(new SqlParameter("title",Types.VARCHAR));
        parameters.add(new SqlParameter("start_time",Types.VARCHAR));
        parameters.add(new SqlParameter("end_time",Types.VARCHAR));
        Object result = this.jdbcTemplate.call(new CallableStatementCreator() {
            @Override
            public CallableStatement
            createCallableStatement(Connection con) throws SQLException {
                CallableStatement statement = con.prepareCall("{call [Dashboard].[Dashboard_Shift_Summary](?,?,?) } ");
                statement.setString("title", title);
                statement.setString("start_time", startTime);
                statement.setString("end_time", endTime);
                return statement;
            }
        },parameters).get("#result-set-1");
        return result;
    }

    public List<MachStep> queryMachineStepMap() {
        String sql = "SELECT A.Department, A.TITLE,A.TARGET,A.WIP_FORM,A.OUTPUT_FORM,B.M_Code,B.Machines "+
                "FROM [Dashboard].TITLE_CODE A LEFT JOIN [Dashboard].TITLE_STEP_MAP B "+
                "ON A.TITLE = B.TITLE ORDER BY A.TITLE";
        List<MachStep> object = (List<MachStep>)jdbcTemplate.query(sql, new ResultSetExtractor<Object>() {
            @Override
            public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<MachStep> machStepList = new ArrayList<MachStep>();
                while(rs.next()) {
                    MachStep machStep = new MachStep();
                    machStep.settITLE(rs.getString("TITLE"));
                    machStep.setMachines(rs.getString("Machines"));
                    machStep.setoUTPUT_FORM(rs.getString("OUTPUT_FORM"));
                    machStep.setwIP_FORM(rs.getString("WIP_FORM"));
                    machStep.settARGET(rs.getString("TARGET"));
                    machStep.setmCode(rs.getString("M_Code"));
                    machStepList.add(machStep);
                }
                return machStepList;
            }
        });
        return object;
    }

    public List<DeptStep> queryDepartmentSteps() {
        String sql="SELECT A.Department,STUFF(C.TITLES,1,1,'') TITLES FROM \r\n";
            sql+="(SELECT DISTINCT Department\r\n";
            sql+="FROM [Dashboard].[TITLE_CODE]) A\r\n";
            sql+="CROSS APPLY(\r\n";
            sql+="	SELECT ',' +B.TITLE  FROM [Dashboard].[TITLE_CODE] B\r\n";
            sql+="	WHERE B.Department = A.Department\r\n";
            sql+="	FOR XML PATH('')\r\n";
            sql+=") AS C(TITLES)\r\n";
        List<DeptStep> object = (List<DeptStep>)jdbcTemplate.query(sql, new ResultSetExtractor<Object>() {
            @Override
            public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<DeptStep> machStepList = new ArrayList<DeptStep>();
                while(rs.next()) {
                    DeptStep machStep = new DeptStep();
                    machStep.setDeptName(rs.getString("Department"));
                    machStep.setTitles(rs.getString("TITLES"));
                    machStepList.add(machStep);
                }
                return machStepList;
            }
        });
        return object;
    }

    public Object queryMachineStepStatus(final String title) {
        List<SqlParameter> parameters = new ArrayList<SqlParameter>();
        parameters.add(new SqlParameter("title",Types.VARCHAR));
        Object result = this.jdbcTemplate.call(new CallableStatementCreator() {
            @Override
            public CallableStatement
            createCallableStatement(Connection con) throws SQLException {
                CallableStatement statement = con.prepareCall("{call [Dashboard].[Dashboard_HoldQty](?) } ");
                statement.setString("title", title);
                return statement;
            }
        },parameters).get("#result-set-1");
        return result;
    }
}
