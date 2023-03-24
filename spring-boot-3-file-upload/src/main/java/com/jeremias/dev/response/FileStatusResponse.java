package com.jeremias.dev.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileStatusResponse {
	boolean status;
	String message;
	
	
}
