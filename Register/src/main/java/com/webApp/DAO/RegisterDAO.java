package com.webApp.DAO;

import java.util.List;

import com.webApp.DTO.RegisterDTO;
import com.webApp.DTO.UserData;

public interface RegisterDAO {

	void inserRegisterData(RegisterDTO registerDTO);

	List<UserData> loadUserData();

}
