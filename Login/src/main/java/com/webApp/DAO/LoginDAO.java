package com.webApp.DAO;

import java.util.List;

import com.webApp.DTO.UserData;

public interface LoginDAO {

	List<UserData> loadUserData();

}
