package com.mis.persistence;

import java.util.List;

import com.mis.domain.QnAVO;
import com.mis.domain.SearchCriteria;

public interface QnADAO {
	
	public void create(QnAVO vo) throws Exception;
	
	public QnAVO read(int qnaNo) throws Exception;
	
	public void update(QnAVO vo) throws Exception;
	
	public void delete(int qnaNo) throws Exception;
	
	public List<QnAVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public int listSearchCountCriteria(SearchCriteria cri) throws Exception;
	
	public void updateHits(int qnaNo) throws Exception;

}
