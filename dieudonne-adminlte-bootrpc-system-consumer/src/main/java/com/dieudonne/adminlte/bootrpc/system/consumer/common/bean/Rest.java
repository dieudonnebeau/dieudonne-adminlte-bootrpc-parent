package com.dieudonne.adminlte.bootrpc.system.consumer.common.bean;
/**
 * 
 * @ClassName:  Rest   
 * @Description:Rest   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月27日 上午10:28:32   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class Rest {

	private long code = 0;
	
	private long count = 0;
	
	private Object data;
	
	private String msg;

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Rest() {
		super();
	}

	public Rest(long code, long count, Object data, String msg) {
		super();
		this.code = code;
		this.count = count;
		this.data = data;
		this.msg = msg;
	}

	public static Rest ok(){
		return new Rest(200,0,null,"");
	}
	
	public static Rest ok(String msg){
		return new Rest(200,0,null,msg);
	}
	
	public static Rest okData(Object data){
		return new Rest(200,0,data,"ok");
	}

	public static Rest failure(String msg) {
		 return new Rest(500,0,null,msg);
	}
}
