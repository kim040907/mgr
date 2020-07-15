package com.home.mgr.vo;

public class PagingVO {

	// ���� ������
	private int currentPage;
	// ���� ������
	private int startPage;
	// �� ������
	private int endPage;
	// �� �Խñۼ�
	private int total;
	// �Խñ۴� ��
	private int cntPerPage;
	// ������ ������
	private int lastPage;
	// Query�� ����
	private int start;
	// Query�� ��
	private int end;
	// �ʱ������� ��
	private int cntPage = 10;

	public PagingVO(int total, int currentPage, int cntPerPage) {
		setCurrentPage(currentPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calLastPage(getTotal(), getCntPerPage());
		calStartEndPage(getCurrentPage(), cntPage);
		calStartEnd(getCurrentPage(), getCntPerPage());
	}
	
	// ������ ������
	public void calLastPage(int total, int cntPerPage) {
		setLastPage((int)Math.ceil((double)total/(double)cntPerPage));
	}
	
	// ����, �������� 
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
	// Query�� Start, End
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
