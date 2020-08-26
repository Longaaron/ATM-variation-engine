package com.atm.common;

public enum AtmError {

	ACCOUNT_ERR(1, "ACCOUNT_ERR"), FUNDS_ERR(2, "FUNDS_ERR"), ATM_ERR(3, "ATM_ERR"), USER_ACCOUNT_ERROR(4, "USER_ACCOUNT_ERROR"),
	PIN_ERROR(5,"PIN_ERROR");

	int enumNumber;
	String enumDes;

	private AtmError(int enumNumber, String enumDes) {
		this.enumNumber = enumNumber;
		this.enumDes = enumDes;

	}

	public int getEnumNumber() {
		return enumNumber;
	}

	public void setEnumNumber(int enumNumber) {
		this.enumNumber = enumNumber;
	}

	public String getEnumDes() {
		return enumDes;
	}

	public void setEnumDes(String enumDes) {
		this.enumDes = enumDes;
	}

}
