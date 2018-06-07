package com.bwjf.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.service.TotalTaskService;
/**
 * 
 * @author wpy 490176245@qq.com
 * @time 2018/6/6
 * @descr 每日统计上半年、下半年、全年的“绩效”
 */
@Service
@Transactional
public class TotalTaskServiceImpl implements TotalTaskService {

	@Override
	public void countTotalforEveryday() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
