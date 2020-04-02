package com.myweb.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.myweb.domain.NoticeVO;
import com.myweb.domain.ProductVO;

@Component
public class FileProcess {
	private static final Logger log = LoggerFactory.getLogger(FileProcess.class);

	@Resource(name = "upImages")
	String upImages;
	public ProductVO fileSave(MultipartHttpServletRequest req) throws IllegalStateException, IOException {
		log.info(">>>> 파일 저장-Multi");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		MultipartFile imgfile = req.getFile("imgfile");
		ProductVO pvo = new ProductVO(title, writer, content);
		if(imgfile.isEmpty()) {
			pvo.setImgfile("NONE");
		}else {
			String orgFileName = imgfile.getOriginalFilename(); //첨부한 파일에서 파일 이름 추출
			String saveFileName = UUID.randomUUID().toString() + "_" + orgFileName; //중복 되지 않는 파일 이름 생성
			File file = new File(upImages+saveFileName); //파일 객체 생성
			imgfile.transferTo(file); //파일 객체 복사(저장, 복사)
			pvo.setImgfile(saveFileName); //ProductVO에 파일명 넘기기 (저장)
		}
		return pvo;
	}
	

	public ProductVO fileModify(MultipartHttpServletRequest req) throws IllegalStateException, IOException {
		log.info(">>>> 파일 수정 -Multi");
		int pno = Integer.parseInt(req.getParameter("pno"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String imgfile = req.getParameter("imgfile");
		MultipartFile new_imgfile = req.getFile("new_imgfile");
		ProductVO pvo = new ProductVO(pno, title, content);
		if(new_imgfile.isEmpty()) {
			pvo.setImgfile(imgfile);
		}else {
			String orgFileName = new_imgfile.getOriginalFilename(); //첨부한 파일에서 파일 이름 추출
			String saveFileName = UUID.randomUUID().toString() + "_" + orgFileName; //중복 되지 않는 파일 이름 생성
			File file = new File(upImages+saveFileName); //파일 객체 생성
			new_imgfile.transferTo(file); //파일 객체 복사(저장, 복사)
			pvo.setImgfile(saveFileName); //ProductVO에 파일명 넘기기 (저장)
			fileRemove(imgfile);
		}
		return pvo;
	}
	public NoticeVO saveAll(MultipartHttpServletRequest req) throws IllegalStateException, IOException {
		log.info(">>>> 파일 저장-Multi");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		MultipartFile imgfile = req.getFile("img");
		MultipartFile attfile = req.getFile("file");
		NoticeVO nvo = new NoticeVO(title, writer, content);
		if(imgfile.isEmpty()) {
			nvo.setImg("NONE");
		}else {
			String orgImgName = imgfile.getOriginalFilename(); //첨부한 파일에서 파일 이름 추출
			String saveImgName = UUID.randomUUID().toString() + "_" + orgImgName; //중복 되지 않는 파일 이름 생성
			String orgFileName = imgfile.getOriginalFilename(); //첨부한 파일에서 파일 이름 추출
			String saveFileName = UUID.randomUUID().toString() + "_" + orgFileName; //중복 되지 않는 파일 이름 생성
			File img = new File(upImages+saveImgName); //파일 객체 생성
			File file = new File(upImages+saveFileName); //파일 객체 생성
			imgfile.transferTo(img); //파일 객체 복사(저장, 복사)
			attfile.transferTo(file);
			nvo.setImg(saveImgName); //ProductVO에 파일명 넘기기 (저장)
			nvo.setFile(saveFileName); //ProductVO에 파일명 넘기기 (저장)
		}
		return nvo;
	}
	public NoticeVO allModify(MultipartHttpServletRequest req) throws IllegalStateException, IOException {
		log.info(">>>> 파일 수정 -Multi");
		int nno = Integer.parseInt(req.getParameter("pno"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String imgfile = req.getParameter("img");
		String attfile = req.getParameter("file");
		MultipartFile new_imgfile = req.getFile("new_imgfile");
		MultipartFile new_attfile = req.getFile("new_attfile");
		NoticeVO nvo = new NoticeVO(nno, title, content);
		if(new_imgfile.isEmpty()) {
			nvo.setImg(imgfile);
		}else {
			String orgImgName = new_imgfile.getOriginalFilename(); //첨부한 파일에서 파일 이름 추출
			String saveImgName = UUID.randomUUID().toString() + "_" + orgImgName; //중복 되지 않는 파일 이름 생성
			File img = new File(upImages+saveImgName); //파일 객체 생성
			new_imgfile.transferTo(img); //파일 객체 복사(저장, 복사)
			nvo.setImg(saveImgName); //ProductVO에 파일명 넘기기 (저장)
			fileRemove(imgfile);
		}
		if(new_attfile.isEmpty()){
			nvo.setFile(attfile);
		}else {
			String orgFileName = new_attfile.getOriginalFilename(); //첨부한 파일에서 파일 이름 추출
			String saveFileName = UUID.randomUUID().toString() + "_" + orgFileName; //중복 되지 않는 파일 이름 생성
			File file = new File(upImages+saveFileName); //파일 객체 생성
			new_attfile.transferTo(file); //파일 객체 복사(저장, 복사)
			nvo.setFile(saveFileName); //ProductVO에 파일명 넘기기 (저장)
			fileRemove(attfile);
		}
		return nvo;
	}

	public void fileRemove(String imgfile) {
		log.info(">>>> 파일삭제");
		new File(upImages+imgfile).delete();
	}

}
