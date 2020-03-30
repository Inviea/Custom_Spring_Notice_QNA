package com.myweb.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.myweb.domain.Criteria;
import com.myweb.domain.ProductVO;

@Repository
public class ProductDAOImp implements ProductDAO {
	private static final Logger log = LoggerFactory.getLogger(ProductDAOImp.class);
	private static String ns = "productMapper.";
	
	
	@Inject
	private SqlSession sql;
	
	@Override
	public void insert(ProductVO pvo) {
		sql.insert(ns+"add",pvo);
	}

	@Override
	public List<ProductVO> selectList(Criteria cri) {
		return sql.selectList(ns+"list", cri);
	}

	@Override
	public ProductVO selectOne(Integer pno) {
		return sql.selectOne(ns+"detail",pno);
	}

	@Override
	public void update(ProductVO pvo) {
		sql.update(ns+"modify",pvo);
	}

	@Override
	public void delete(Integer pno) {
		sql.delete(ns+"remove", pno);
	}

	public void deleteImg(Integer pno) {
		Map<String,Object> map = new HashMap<>();
		map.put("pno", pno);
		map.put("imgfile", "NONE");
		sql.delete(ns+"rmImg", map);
	}

	public int selectOne() {
		return sql.selectOne(ns+"total");
	}
}
