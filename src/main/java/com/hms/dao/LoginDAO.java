package com.hms.dao;


import java.util.List;


import com.hms.model.LoginVO;

public interface LoginDAO {


	public void insertLogin(LoginVO loginVO);

	public List searchLoginID(String loginService);

}
