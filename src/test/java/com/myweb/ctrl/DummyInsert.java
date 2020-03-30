package com.myweb.ctrl;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.domain.ProductVO;
import com.myweb.persistence.ProductDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DummyInsert {
	private static final Logger log = LoggerFactory.getLogger(DummyInsert.class);
	
	@Inject
	private ProductDAO pdao;
	
	@Test
	public void dummyTest() throws Exception {
		for(int i=234; i<1000;i++) {
			ProductVO pvo = new ProductVO();
			pvo.setTitle(i+"번째 상품명");
			pvo.setWriter("작성자"+i);
			pvo.setContent(i+"번째 글");
			pvo.setImgfile("NONE");
			pdao.insert(pvo);
		}
	}
	
}
