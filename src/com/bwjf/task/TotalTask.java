package com.bwjf.task;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bwjf.service.TotalTaskService;

import junit.framework.Test;


/**
 * Created by caipc on 2017-09-07.
 */
@Component
public class TotalTask{
    
    /*@Scheduled(cron="0 0 2 * * ?")
    public void countTotalforEveryday() {
        
            log.info("=============开始计算绩效=============");
            try {
				totalTaskService.countTotalforEveryday();
			} catch (Exception e) {
				log.info("error:计算绩效出现异常！！");
				e.printStackTrace();
			}
            log.info("================end===============");
       
    }*/
    /*@Scheduled(cron="0 * * * * ? ")
    public void Test() {
    	log.info("---Test----");
    }*/
    
    @Autowired
    private TotalTaskService totalTaskService;
    protected static Logger log = Logger.getLogger(TotalTask.class);
}
