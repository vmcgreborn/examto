package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.FriendService;
import com.app.vo.FriendVO;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
@RequestMapping("exam")
public class FriendsController {

	@Autowired
	private FriendService friendService;
	
	@GetMapping(path ="/friend/{name})" )
	public ResponseEntity<List<FriendVO>> getFriendsByName(@RequestParam("name") String name){

		return ResponseEntity.ok(friendService.getFriends(name));
	}
	
	@GetMapping(path ="/friend/)" )
	public ResponseEntity<List<FriendVO>> getFriends(){

		return ResponseEntity.ok(friendService.getFriends(null));
	}
}
