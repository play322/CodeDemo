package com.it.juc;

public enum CountryEnum {

	ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"韩"),FIVE(5,"赵"),SIX(6,"魏");

	 private Integer retCode;
	 private String retMsg;

	public Integer getRetCode() {
		return retCode;
	}

	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	CountryEnum(Integer retCode, String retMsg) {
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public static CountryEnum forEach(int index){
		CountryEnum[] myArray = CountryEnum.values();
		for (CountryEnum element:myArray){
			if (index==element.getRetCode()){
				return element;
			}
		}
		return null;
	}

}
