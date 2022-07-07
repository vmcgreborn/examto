package com.app.service;

import java.util.List;

import com.app.vo.FriendVO;

public interface FriendService {

	List<FriendVO> getFriends(String name);


}