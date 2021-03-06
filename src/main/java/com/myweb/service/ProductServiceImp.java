package com.myweb.service;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.myweb.domain.Criteria;
import com.myweb.domain.ProductVO;
import com.myweb.persistence.ProductDAOImp;

@Service
public class ProductServiceImp implements ProductService{
	private static final Logger log = LoggerFactory.getLogger(ProductServiceImp.class);
	@Inject
	private ProductDAOImp pdao;
	
	@Override
	public void write(ProductVO pvo) {
		pdao.insert(pvo);
	}

	@Override
	public List<ProductVO> list(Criteria cri) {
		return pdao.selectList(cri);
	}

	@Override
	public ProductVO detail(Integer pno) {
		return pdao.selectOne(pno);
	}

	@Override
	public void modify(ProductVO pvo) {
		pdao.update(pvo);
	}

	@Override
	public void remove(Integer pno) {
		pdao.delete(pno);
	}

	@Override
	public void removeImg(int pno) {
		log.info(">>>>>>>pno = "+pno);
		pdao.deleteImg(pno);
		
	}

	@Override
	public int totalCount(Criteria cri) {
		return pdao.selectOne(cri);
	}
}
