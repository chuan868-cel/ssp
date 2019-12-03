package com.oracle.common.utils;

import java.io.Serializable;

public abstract class RandomCodeUtils implements Serializable{

	
	public static Integer createRegisterCode() {
		return (int)((Math.random()*9+1)*100000);
	}
}
