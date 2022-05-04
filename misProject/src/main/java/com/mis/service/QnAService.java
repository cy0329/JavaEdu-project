package com.mis.service;

import java.util.List;

import com.mis.domain.QnAVO;
import com.mis.domain.SearchCriteria;

public interface QnAService {
	
	public void register(QnAVO vo) throws Exception;

	public QnAVO read(int qnaNo) throws Exception;

	public void modify(QnAVO vo) throws Exception;

	public void remove(int qnaNo) throws Exception;

	// 페이징, 검색 기능을 제공하는 list 가져오는 기능
	public List<QnAVO> listSearch(SearchCriteria cri) throws Exception;

	// 페이징, 검색 기능 게시물 수 가져오는 기능
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
}
