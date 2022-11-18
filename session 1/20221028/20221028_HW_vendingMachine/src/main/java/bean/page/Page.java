package bean.page;

import java.util.List;

public abstract class Page<T> {
	
	
	private List<T> objectList;
	private int pageId;
	private int basePageId;
	private int pageDrinkCount;
	
	
	public Page(List<T> objectList, int pageId) {
		this.objectList = objectList;
		this.pageId = pageId;
		this.basePageId = (pageId-1)/3*3;
		this.pageDrinkCount = objectList.size();
	}


	
	
	public List<T> getObjectList() {
		return objectList;
	}
	public int getPageId() {
		return pageId;
	}
	public int getBasePageId() {
		return basePageId;
	}
	public int getPageDrinkCount() {
		return pageDrinkCount;
	}
	
	
	@Override
	public String toString() {
		return "Page [objectList=" + objectList + ", pageId=" + pageId + "]";
	}

}
