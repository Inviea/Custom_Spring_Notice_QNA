package com.myweb.persistence;

import java.util.List;

import com.myweb.domain.Criteria;
import com.myweb.domain.NoticeVO;

public interface NoticeDAO {
	int insert(NoticeVO nvo);
	List<NoticeVO> selectList(Criteria cri);
	NoticeVO selectOne(Integer nno);
	int update(NoticeVO nvo);
	int delete(Integer nno);
	int deleteImg(Integer nno);
	int deleteFile(Integer nno);
	int selectOne(Criteria cri);

}
