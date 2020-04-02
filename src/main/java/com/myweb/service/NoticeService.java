package com.myweb.service;
import java.util.List;

import com.myweb.domain.Criteria;
import com.myweb.domain.NoticeVO;

public interface NoticeService {
	int write(NoticeVO nvo);
	List<NoticeVO> list(Criteria cri);
	NoticeVO detail(Integer nno);
	void modify(NoticeVO nvo);
	void remove(int nno);
	void removeImg(int nno);
	void removeFile(int nno);
	int totalCount(Criteria cri);

}
