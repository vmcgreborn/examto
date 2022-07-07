package com.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.persistence.entity.FriendEntity;

public interface FriendRepository extends JpaRepository<FriendEntity, Long>{
	
	public List<FriendEntity> findByName(String name);
	
}
