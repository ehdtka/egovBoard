package egovframework.board.test.domain;

public class Paging {
	private int page = 1; // 현재 페이지
	private int perPage = 10; // 한 페이지당 보여질 글 갯수
	private int startRow = 1;
	private int endRow = startRow + perPage - 1;
	private String searchKey;
	private String searchValue;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
		setRows();
	}
	private void setRows() {
		startRow = page * perPage - perPage + 1;
		endRow = startRow + perPage - 1;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
		setRows();
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public String getsearchKey() {
		return searchKey;
	}
	public void setsearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getsearchValue() {
		return searchValue;
	}
	public void setsearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public Paging(int page, int perPage, int startRow, int endRow, String searchKey, String searchValue) {
		super();
		this.page = page;
		this.perPage = perPage;
		this.startRow = startRow;
		this.endRow = endRow;
		this.searchKey = searchKey;
		this.searchValue = searchValue;
	}
	public Paging() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PagingDto [page=" + page + ", perPage=" + perPage + ", startRow=" + startRow + ", endRow=" + endRow+
				 ", searchKey=" + searchKey + ", searchValue=" + searchValue + "]";
	}
	
	
}
