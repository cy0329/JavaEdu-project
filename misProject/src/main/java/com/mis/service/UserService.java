package com.mis.service;

import java.util.List;

import com.mis.domain.SearchCriteria;
import com.mis.domain.UserVO;
import com.mis.dto.LoginDTO;

public interface UserService {
	
	public UserVO login(LoginDTO dto) throws Exception;
	
	public void register(UserVO vo) throws Exception;

	public UserVO read(String usid) throws Exception;

	public void modify(UserVO vo) throws Exception;

	public void remove(String usid) throws Exception;

	public List<UserVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	// 회원가입
	public void memberRegister(UserVO vo) throws Exception;

}
