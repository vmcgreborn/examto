package com.app.controller;


import org.junit.jupiter.api.Test;

import com.app.service.FriendService;
import com.app.util.ValidationUtil;

import mockit.Injectable;
import mockit.Tested;


public class FriendControllerTest {
	
	@Tested
	private FriendsController test;
	@Injectable
	private  FriendService transactionService;


    
	@Test
	public void getFriend() {

		test.getFriends();
	}
	@Test
	public void getFriendByName() {

		test.getFriendsByName("Raul");
	}


}
