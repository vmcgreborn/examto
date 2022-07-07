package com.app.service.mapping;

import com.app.persistence.entity.FriendEntity;
import com.app.util.base.BaseTransformer;
import com.app.vo.FriendVO;

public class FriendMapping implements BaseTransformer<FriendEntity, FriendVO> {

	@Override
	public FriendVO getResponse(FriendEntity in) {
		FriendVO friendVo=null;
		
		if(in!=null) {
			friendVo=new FriendVO();
			friendVo.setAge(in.getAge());
			friendVo.setLastName(in.getLastName());
			friendVo.setName(in.getName());
			
		}
		
		return friendVo;
	}

}
