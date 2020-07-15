package com.home.mgr.vo;

public class PagingVO {

	// 현재 페이지
	private int currentPage;
	// 시작 페이지
	private int startPage;
	// 끝 페이지
	private int endPage;
	// 총 게시글수
	private int total;
	// 게시글당 수
	private int cntPerPage;
	// 마지막 페이지
	private int lastPage;
	// Query용 시작
	private int start;
	// Query용 끝
	private int end;
	// 초기페이지 수
	private int cntPage = 10;

	public PagingVO(int total, int currentPage, int cntPerPage) {
		setCurrentPage(currentPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calLastPage(getTotal(), getCntPerPage());
		calStartEndPage(getCurrentPage(), cntPage);
		calStartEnd(getCurrentPage(), getCntPerPage());
	}
	
	// 마지막 페이지
	public void calLastPage(int total, int cntPerPage) {
		setLastPage((int)Math.ceil((double)total/(double)cntPerPage));
	}
	
	// 시작, 끝페이지 
	public void calStartEndPage(int currentPage, int cntPage) {
		setEndPage(((int)Math.ceil((double)currentPage/(double)cntPage)) * cntPage);
		if(getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - cntPage + 1);
		if(getStartPage() < 1) {
			setStartPage(1);
		}
	}
	// Query용 Start, End
	public void calStartEnd(int currentPage, int cntPerPage) {
		setEnd(currentPage * cntPerPage);
		setStart(getEnd() - cntPerPage + 1);
	}
	

	
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "PagingVO [currentPage=" + currentPage + ", startPage=" + startPage + ", endPage=" + endPage + ", total="
				+ total + ", cntPerPage=" + cntPerPage + ", lastPage=" + lastPage + ", start=" + start + ", end=" + end
				+ ", cntPage=" + cntPage + "]";
	}
}
