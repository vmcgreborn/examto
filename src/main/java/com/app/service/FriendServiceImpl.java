package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.persistence.entity.FriendEntity;
import com.app.persistence.repository.FriendRepository;
import com.app.service.mapping.FriendMapping;
import com.app.util.ValidationUtil;
import com.app.vo.FriendVO;

@Service
public class FriendServiceImpl implements FriendService  {
	
	@Autowired
	private FriendRepository friendRepo;
	@Autowired
	private ValidationUtil validationUtil;


	@Override
	public List<FriendVO> getFriends(String name) {
		
		List<FriendEntity> friendEntityList;
		List<FriendVO> friendList=new ArrayList<FriendVO>();
		if(validationUtil.isNotNull(name)) {
			friendEntityList=friendRepo.findByName(name);
		}else {
			friendEntityList=friendRepo.findAll();
		}
		
		FriendMapping friendMapping=new FriendMapping();
		
		friendEntityList.stream().forEach(x->friendList.add(friendMapping.getResponse(x)));
		
		
		return friendList;
	}


}