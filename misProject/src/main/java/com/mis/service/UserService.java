package com.mis.service;

import com.mis.domain.UserVO;
import com.mis.dto.LoginDTO;

public interface UserService {
	
	public UserVO login(LoginDTO dto) throws Exception;

}
