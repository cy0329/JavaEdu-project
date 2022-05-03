package com.mis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mis.domain.NoticeFileVO;
import com.mis.domain.NoticeVO;
import com.mis.domain.SearchCriteria;

@Service
public interface NoticeService {
	
	public void register(NoticeVO vo) throws Exception;
	
	public NoticeVO read(int noticeNo) throws Exception;
	
	public void modify(NoticeVO vo) throws Exception;
	
	public void remove(int noticeNo) throws Exception;
	
	public List<NoticeVO> listSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public List<NoticeFileVO> fileList(int noticeNo) throws Exception;

}
