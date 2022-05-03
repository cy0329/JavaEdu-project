package com.mis.persistence;

import java.util.List;

import com.mis.domain.NoticeFileVO;
import com.mis.domain.NoticeVO;
import com.mis.domain.SearchCriteria;

public interface NoticeDAO {
	
	public int adCreate(NoticeVO vo) throws Exception;
	
	public NoticeVO read(int noticeNo) throws Exception;
	
	public void adUpdate(NoticeVO vo) throws Exception;
	
	public void adDelete(int noticeNo) throws Exception;
	
	public List<NoticeVO> listSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public void insertFile(NoticeFileVO fVo) throws Exception;
	
	public void deleteFile(int noticeFileNo) throws Exception;
	
	public List<NoticeFileVO> fileList(int noticeNo) throws Exception;

}
