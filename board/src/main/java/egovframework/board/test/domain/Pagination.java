package egovframework.board.test.domain;

public class Pagination {
	private int totalCount; // 데이터 갯수
	private int startPage; // 시작 페이지
	private int endPage; // 끝 페이지
	private boolean prev; // 이전 출력 여부
	private boolean next; // 페이지 출력 개수
	private int paginationCount = 10;
	private int pageCount;
	private Paging paging;
	
	public Pagination() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	private void calcData() {
		int perPage = paging.getPerPage();
		
		pageCount = totalCount / perPage;
		if (totalCount % perPage > 0) {
			pageCount += 1;
		}
		
		int page = paging.getPage();
		startPage = ((page - 1) / paginationCount) * paginationCount + 1;
		endPage = startPage + paginationCount - 1;
		if (endPage > pageCount) {
			endPage = pageCount;
		}
		
		if (startPage != 1) {
			prev = true;
		}
		
		if (endPage != pageCount) {
			next = true;
		}
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
	public int getPaginationCount() {
		return paginationCount;
	}
	public void setPaginationCount(int paginationCount) {
		this.paginationCount = paginationCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	public Pagination(int totalCount, int startPage, int endPage, boolean prev, boolean next, int paginationCount,
			int pageCount, Paging paging) {
		super();
		this.totalCount = totalCount;
		this.startPage = startPage;
		this.endPage = endPage;
		this.prev = prev;
		this.next = next;
		this.paginationCount = paginationCount;
		this.pageCount = pageCount;
		this.paging = paging;
	}
	@Override
	public String toString() {
		return "Pagination [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", prev=" + prev + ", next=" + next + ", paginationCount=" + paginationCount + ", pageCount="
				+ pageCount + ", paging=" + paging + "]";
	}
	
	
}
