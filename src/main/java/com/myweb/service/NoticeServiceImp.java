package com.myweb.service;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myweb.domain.Criteria;
import com.myweb.domain.NoticeVO;
import com.myweb.persistence.NoticeDAOImp;

public class NoticeServiceImp implements NoticeService {
	private static final Logger log = LoggerFactory.getLogger(NoticeServiceImp.class);
	@Inject
	private NoticeDAOImp ndao;
	@Override
	public int write(NoticeVO nvo) {
		return ndao.insert(nvo);
	}

	@Override
	public List<NoticeVO> list(Criteria cri) {
		return ndao.selectList(cri);
	}

	@Override
	public NoticeVO detail(Integer nno) {
		return ndao.selectOne(nno);
	}

	@Override
	public void modify(NoticeVO nvo) {
		ndao.update(nvo);
	}

	@Override
	public void remove(int nno) {
		ndao.delete(nno);
	}

	@Override
	public void removeImg(int nno) {
		ndao.deleteImg(nno);
	}

	@Override
	public void removeFile(int nno) {
		ndao.deleteFile(nno);
	}

	@Override
	public int totalCount(Criteria cri) {
		return ndao.selectOne(cri);
	}
}
