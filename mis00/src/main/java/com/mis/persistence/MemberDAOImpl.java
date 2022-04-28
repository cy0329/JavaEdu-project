package com.mis.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mis.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject // 선언만 해도 받아옴
	private SqlSession sqlSession;
	
	private static final String namespace = "com.mis.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		
		return sqlSession.selectOne(namespace + ".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace + ".insertMember", vo);
		
	}

	@Override
	public MemberVO readMember(String userid) {
		
		return sqlSession.selectOne(namespace + ".readMember", userid);
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) {
		
		// 문제정의 : select() 파라미터를 1개만 보낼 수 있음
		
		// 1) MemberVO를 선언해서 담아서 보낸다.
//		MemberVO mVo = new MemberVO();
//		mVO.setUserid(userid);
//		mVO.setUserpw(userpw);
//		
//		return sqlSession.selectOne(namespace + ".readWithPW", mVO);
		
		// 2) 자바에서 제공하는 컬렉션 사용 (자료구조?) (VO가 없는 경우, 또는 효율적인 방법을 고민)
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		return sqlSession.selectOne(namespace + ".readWithPW", paramMap);
	}
	
	

}
