package bean.page;

import java.util.List;

public abstract class Pages <T extends Page<S>, S> {
	private List<T> pageList;
	private int maxPageId;
	private boolean isSearchPages;
	
	
	public Pages(List<T> pageList, boolean isSearchPages) {
		this.pageList = pageList;
		this.maxPageId = pageList.size();
		this.isSearchPages = isSearchPages;
	}
	
	
	public List<T> getPageList() {
		return pageList;
	}
	public T getPageByPageId(int pageId) {
		for(T page : pageList) {
			if(page.getPageId() == pageId)
				return page;
		}
		return null;
	}
	public int getMaxPageId() {
		return maxPageId;
	}
	
	public boolean isSearchPages() {
		return isSearchPages;
	}
}
