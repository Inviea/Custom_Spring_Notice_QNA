package com.myweb.ctrl;
import java.io.IOException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.domain.Criteria;
import com.myweb.domain.PagingVO;
import com.myweb.service.NoticeService;
import com.myweb.util.FileProcess;

public class NoticeCtrl {
	private static final Logger log = LoggerFactory.getLogger(NoticeCtrl.class);
	@Inject
	private NoticeService nsv;
	@Inject
	private FileProcess fp;
	
	@GetMapping("/write")
	public void write() {
		log.info(">>>> 글쓰기 화면 출력 - GET");
	}
	@PostMapping("/write")
	public String write(MultipartHttpServletRequest req, RedirectAttributes reAttr) throws IllegalStateException, IOException {
		log.info(">>>> 글 등록 - Post");
		nsv.write(fp.saveAll(req));
		reAttr.addFlashAttribute("result","write_ok");
		return "redirect:/notice/list";
	}
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info(">>>>게시글 목록 출력 - Get");
		model.addAttribute("list",nsv.list(cri));
		int totalCnt = nsv.totalCount(cri);
		model.addAttribute("ngvo", new PagingVO(totalCnt, cri));
	}
	@GetMapping({"/detail","/modify"})
	public void detail(@RequestParam("nno")int nno, Model model, @ModelAttribute("cri")Criteria cri) {
		log.info(">>>> 상세 글 보기 - Get");
		model.addAttribute("nvo", nsv.detail(nno));
	}
	@PostMapping("/modify")
	public String modify(MultipartHttpServletRequest req, RedirectAttributes reAttr,@ModelAttribute("cri")Criteria cri) throws IllegalStateException, IOException {
		log.info(">>>>글 수정 - POST");
		nsv.modify(fp.allModify(req));
		reAttr.addAttribute("pageNum", cri.getPageNum());
		reAttr.addAttribute("amount", cri.getAmount());
		reAttr.addAttribute("type", cri.getType());
		reAttr.addAttribute("keyword", cri.getKeyword());
		reAttr.addFlashAttribute("result", "modify_ok");
		return "redirect:/notice/detail?nno="+req.getParameter("nno");
	}
	@PostMapping("/remove")
	public String remove(@RequestParam("nno")int nno,@RequestParam("imgfile") String imgfile, @RequestParam("attfile")String attfile,RedirectAttributes reAttr,Criteria cri) {
		log.info(">>>>글 삭제-POST");
		if(!imgfile.equals("NONE")) {
			fp.fileRemove(imgfile);
		}
		if(!attfile.equals("NONE")) {
			fp.fileRemove(attfile);
		}
		nsv.remove(nno);
		reAttr.addAttribute("pageNum", cri.getPageNum());
		reAttr.addAttribute("amount", cri.getAmount());
		reAttr.addAttribute("type", cri.getType());
		reAttr.addAttribute("keyword", cri.getKeyword());
		reAttr.addFlashAttribute("result", "remove_ok");
		return "redirect:/notice/list";
		
	}
	@PostMapping("/rmimg")
	public String removeImg(@RequestParam("nno") int nno, @RequestParam("imgfile") String imgfile) {
		log.info(">>>> 이미지 삭제 - POST");
		fp.fileRemove(imgfile);
		nsv.removeImg(nno);
		return "redirect:/";
	}
	@PostMapping("/rmatt")
	public String removeFile(@RequestParam("nno") int nno, @RequestParam("attfile") String attfile) {
		log.info(">>>> 이미지 삭제 - POST");
		fp.fileRemove(attfile);
		nsv.removeImg(nno);
		return "redirect:/";
	}
	
	
}
