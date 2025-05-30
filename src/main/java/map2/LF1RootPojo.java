package map2;

import java.util.ArrayList;

public class LF1RootPojo {

	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private ArrayList<Datum> data;
	private LF1Support support;

	public LF1Support getSupport() {
		return support;
	}

	public void setSupport(LF1Support support) {
		this.support = support;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public ArrayList<Datum> getData() {
		return data;
	}

	public void setData(ArrayList<Datum> data) {
		this.data = data;
	}

}
