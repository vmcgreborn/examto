package com.app.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "FRIEND", catalog = "")
@Data
public class FriendEntity {
	

    @Id()
    @Column(name = "friend_id")
    private Long id;
    @Column()
	private String name;
    @Column()
	private String lastName;
    @Column()
	private Integer age;

}
