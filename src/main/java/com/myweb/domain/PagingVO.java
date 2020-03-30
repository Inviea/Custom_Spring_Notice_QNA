package com.myweb.domain;

public class PagingVO {
	private int totalCnt; //총 글 수
	private Criteria cri; //DB로부터 글의 범위를 가져오기 위한 기준을 담는 객체
	private int startPage;//10개의 페이지 중 1,11,21같은 페이징 시작번호
	private int endPage;  //10개의 페이지 중 10,20,30같은 페이징 끝번호
	private boolean prev, next;

	public PagingVO() {}
	
	public PagingVO(int totalCnt, Criteria cri) {
		this.cri = cri;
		this.totalCnt = totalCnt;
		//14		/10 -> 1.4 -> 올림 -> 2 *10 페이지 14가 갖는 번호의 끛번호
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		// 끝-9=시작
		this.startPage = endPage-9;
		//DB에서 실제 글의 총개수를 가져와서 한페이지에 보여줄 글 수로 나누고 올림
		int realEndPage = (int)(Math.ceil(totalCnt*1.0/cri.getAmount()));
		//계산된 페이지의 마지막 번호는 실제 가질 수 있는 페이지의 최대 번호 보다 클 수 없음 
		if(realEndPage<endPage) {
			this.endPage= realEndPage;
		}
		//이전으로 가기 버튼은 시작 페이지 번호가 1일때보다 크면 무조건 나옴
		this.prev = this.startPage>1;
		//실제 가질수 있는 페이지의 번호보다 계산된 페이지 마지막 번호가 작으면 무조건 나옴
		this.next = this.endPage<realEndPage;
	}
	public PagingVO(Criteria cri) {
		this.cri = cri;
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		// 끝-9=시작
		this.startPage = endPage-9;
		//DB에서 실제 글의 총개수를 가져와서 한페이지에 보여줄 글 수로 나누고 올림
		int realEndPage = (int)(Math.ceil(totalCnt*1.0/cri.getAmount()));
		//계산된 페이지의 마지막 번호는 실제 가질 수 있는 페이지의 최대 번호 보다 클 수 없음 
		if(realEndPage<endPage) {
			this.endPage= realEndPage;
		}
		//이전으로 가기 버튼은 시작 페이지 번호가 1일때보다 크면 무조건 나옴
		this.prev = this.startPage>1;
		//실제 가질수 있는 페이지의 번호보다 계산된 페이지 마지막 번호가 작으면 무조건 나옴
		this.next = this.endPage<realEndPage;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

}
