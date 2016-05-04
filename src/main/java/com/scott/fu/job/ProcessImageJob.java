package com.scott.fu.job;


import com.scott.fu.util.FileUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.*;

/**
 * Created by ScottFu on 2016/1/5.
 */
public class ProcessImageJob {

    private String sourcePath;
    private String targetPath;
    private Map<Integer, String> regionMap;

    public ProcessImageJob(String sourcePath, String targetPath) {
        this.sourcePath = sourcePath;
        this.targetPath = targetPath;
    }

    public void setRegionMap(Map<Integer, String> regionMap) {
        this.regionMap = regionMap;
    }

    protected void execute()  {
//        String targetPath = ProcessImageJob.class.getResource("/").getPath().replaceAll("WEB-INF/classes/","")
//                + "html/PRFDashboard.png";
//        System.out.println("===================================");
//        System.out.println(targetPath);
//        System.out.println(ProcessImageJob.class.getResource("/").getPath());
//        FileUtil.convertPDF2JPGMerged(sourcePath, targetPath, regionMap);
    }
}
