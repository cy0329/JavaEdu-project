package com.mis.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.mis.domain.ProductVO;
import com.mis.domain.SearchCriteria;
import com.mis.persistence.ProductDAO;

@Repository
public class ProductServiceImpl implements ProductService{

	@Inject
	private ProductDAO dao;
	
	@Override
	public void register(ProductVO vo) throws Exception {
		
		dao.create(vo);
		
	}

	@Override
	public ProductVO read(int pno) throws Exception {
		
		dao.updateViewCount(pno);
		
		return dao.read(pno);
	}

	@Override
	public void modify(ProductVO vo) throws Exception {

		dao.update(vo);
		
	}

	@Override
	public void remove(int pno) throws Exception {
		
		dao.delete(pno);
		
	}

	@Override
	public List<ProductVO> listSearch(SearchCriteria cri) throws Exception {

		return dao.listSearchCriteria(cri);
		
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return dao.listSearchCountCriteria(cri);
		
	}

}
