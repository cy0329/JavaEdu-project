package com.mis.persistence;

import java.util.List;

import com.mis.domain.SearchCriteria;
import com.mis.domain.UserVO;
import com.mis.dto.LoginDTO;

public interface UserDAO {

	public UserVO login(LoginDTO dto) throws Exception;

	public void create(UserVO vo) throws Exception;

	public UserVO read(String usid) throws Exception;

	public void update(UserVO vo) throws Exception;

	public void delete(String usid) throws Exception;

	public List<UserVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	// 회원가입
	public void signup(UserVO vo) throws Exception;

}
