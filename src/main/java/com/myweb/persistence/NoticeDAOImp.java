package com.myweb.persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myweb.domain.Criteria;
import com.myweb.domain.NoticeVO;

public class NoticeDAOImp implements NoticeDAO {
	private static final Logger log = LoggerFactory.getLogger(NoticeDAOImp.class);
	private static String ns = "noticeMapper.";
	
	@Inject
	private SqlSession sql;
	
	@Override
	public int insert(NoticeVO nvo) {
		return sql.insert(ns+"add", nvo);
	}

	@Override
	public List<NoticeVO> selectList(Criteria cri) {
		return sql.selectList(ns+"list",cri);
	}

	@Override
	public NoticeVO selectOne(Integer nno) {
		return sql.selectOne(ns+"detail",nno);
	}

	@Override
	public int update(NoticeVO nvo) {
		return sql.update(ns+"modify",nvo);
	}

	@Override
	public int delete(Integer nno) {
		return sql.delete(ns+"remove",nno);
	}

	@Override
	public int deleteImg(Integer nno) {
		Map<String, Object> map =  new HashMap<>();
		map.put("nno", nno);
		map.put("nimg", "NONE");
		return sql.delete(ns+"rmImg",map);
	}

	@Override
	public int deleteFile(Integer nno) {
		Map<String, Object> map =  new HashMap<>();
		map.put("nno", nno);
		map.put("nfile", "NONE");
		return sql.delete(ns+"rmFile",map);
	}

	@Override
	public int selectOne(Criteria cri) {
		return sql.selectOne(ns+"total",cri);
	}
}
