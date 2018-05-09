package com.bwjf.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.entity.Account;
import com.bwjf.entity.Equipment;
import com.bwjf.entity.PerformanceInfo;
import com.bwjf.mapper.PerformanceInfoMapper;
import com.bwjf.service.EqmAddService;
import com.bwjf.utils.DateUtil;
/**
 * @author wpy
 * @创建时间 2017/11/11
 * @修改时间 2017/11/12
 */
@Service
@Transactional
public class EqmAddServiceImpl implements EqmAddService {

	private DateUtil dateUtil;
	private PerformanceInfoMapper performanceInfoMapper;
	
	public DateUtil getDateUtil() {
		return dateUtil;
	}
	public void setDateUtil(DateUtil dateUtil) {
		this.dateUtil = dateUtil;
	}

	public PerformanceInfoMapper getPerformanceInfoMapper() {
		return performanceInfoMapper;
	}
	@Resource
	public void setPerformanceInfoMapper(PerformanceInfoMapper performanceInfoMapper) {
		this.performanceInfoMapper = performanceInfoMapper;
	}

	@Override
	public void add(Account account, List<Equipment> eqmNoList, String[] num, String createDate, String dataTime,String UUID)
			throws Exception {
		System.out.println("---EqmAddServiceImpl.add()---");
		//System.out.println(account.getAccountId()+","+eqmNoList.get(5).getEquipmentId()+","+num[5]+","+createDate+","+dataTime);
		PerformanceInfo performanceInfo = new PerformanceInfo();		
		for (int i = 0; i < num.length; i++) {
			if(!num[i].isEmpty()) {//数量不为空
				performanceInfo.setEmployeeId(account.getEmployeeId());
				performanceInfo.setEquipmentId(eqmNoList.get(i).getEquipmentId());
				performanceInfo.setQuantity(Integer.parseInt(num[i]));
				performanceInfo.setCreateDate(dateUtil.getDateTime(createDate));
				performanceInfo.setUuid(UUID);
				performanceInfo.setDataTime(dateUtil.getDate(dataTime));
				performanceInfoMapper.eqmAdd(performanceInfo);
			}
		}
		
	}

	

}
