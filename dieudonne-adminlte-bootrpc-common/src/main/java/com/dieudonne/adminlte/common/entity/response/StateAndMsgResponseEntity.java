package com.dieudonne.adminlte.common.entity.response;

public class StateAndMsgResponseEntity {
	
	/** 枚举值 */
	private int value;
	
	/** 描述 */
	private String desc;

	
	public StateAndMsgResponseEntity(int value, String desc) {
		super();
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
