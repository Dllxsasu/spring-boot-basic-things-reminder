package com.jeremias.dev.modelos;

import java.io.Serializable;

import com.jeremias.dev.enums.UserSexEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
@Data
@AllArgsConstructor
@ToString
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String passWord;
	private UserSexEnum userSex;
	private String nickName;
	public User() {
		super();
	}
}
