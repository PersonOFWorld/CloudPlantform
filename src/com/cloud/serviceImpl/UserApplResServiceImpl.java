package com.cloud.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;



import org.springframework.stereotype.Service;

import com.cloud.entity.UseDataBean;
import com.cloud.mapper.UserApplyResMapper;
import com.cloud.service.UserApplyResService;
@Service
public class UserApplResServiceImpl implements UserApplyResService {
	@Resource(name="userApplyResMapper")
	UserApplyResMapper userApplyResMapper;
	public Boolean applyResource(UseDataBean useDataBean) {
		String time=useDataBean.getTime();
		String timed=useDataBean.getTimed();
		Calendar c = Calendar.getInstance();
		if(useDataBean.getTemPort().length()==0){
			useDataBean.setTemPort("需默认值");
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		useDataBean.setTemPort("须默认值");
		c.add(Calendar.MONTH,Integer.parseInt(timed));
		useDataBean.setTimed(format.format(c.getTime()));
		return dealPorts(useDataBean);
	}
	//拆分字符串
	public boolean dealPorts(UseDataBean useDataBean){
		int tim=0;
		String tempPort[]=useDataBean.getTemPort().split(",");
		for (int i=0;i<tempPort.length;i++) {
			useDataBean.setTemPort(tempPort[i]);
			Boolean a=userApplyResMapper.applyResource(useDataBean);
			if(a==true)
				tim++;
		}
		Boolean b=userApplyResMapper.insertInfo(useDataBean);
		if(tim==tempPort.length&&b)
			return true;
		return false;
	}

}
