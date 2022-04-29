package com.mis.persistence;

import com.mis.domain.UserVO;
import com.mis.dto.LoginDTO;

public interface UserDAO {
	
	public UserVO login(LoginDTO dto) throws Exception;

}
