package com.app.service;



import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import com.app.persistence.entity.FriendEntity;
import com.app.persistence.repository.FriendRepository;
import com.app.util.ValidationUtil;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

@Service
public class FriendServiceImplTest {


	@Tested
	private FriendServiceImpl test;

	@Injectable
	private FriendRepository repository;

    @Injectable
    private ValidationUtil validationUtil;
	
	@Test
	public void findAllFriends() {
	
		new Expectations() {
			
			{
				
				repository.findAll();
				result = new ArrayList<FriendEntity>();
			}
			
		};
		test.getFriends(null);
		
		
	}
	




}
