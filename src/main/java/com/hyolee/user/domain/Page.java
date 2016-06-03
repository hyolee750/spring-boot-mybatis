package com.hyolee.user.domain;

import java.util.List;

public class Page<T> {
	private List<T> list;
	private Integer pageNum = 1;//当前第几页,默认为第一页
	private Integer totalRecord;//总记录数
	private Integer pageSize = 20;//每页显示多少条记录，默认为20条记录
	private Integer totalPage;//总共多少页，根据总记录数和pagesize获得
	private Integer startIndex;//记录从数据库第几条开始查
	private Integer startPage;//显示开始页
	private Integer endPage;//显示结束页
	private Integer display = 10; //显示多少个页数，默认显示10个页码
	
	
	public Page(Integer pageNum, Integer totalRecord,Integer pageSize,Integer display) {
		
		this.pageNum = pageNum;
		this.totalRecord = totalRecord;
		this.pageSize = pageSize;
		this.display = display;
		//计算出总页数
		this.totalPage = (this.totalRecord+this.pageSize-1)/this.pageSize;
		//计算出从第几个位置查询数据库
		this.startIndex = (this.pageNum-1)*this.pageSize;
		//计算出页面的页数从第几个开始
		if (this.totalPage<=this.display) {
			this.startPage = 1;
			this.endPage = this.totalPage;
		}else {
			if (this.display%2==0) {
				this.startPage = this.pageNum-this.display/2+1;
				this.endPage = this.pageNum+this.display/2;
			}else {
				this.startPage = this.pageNum-this.display/2;
				this.endPage = this.pageNum+this.display/2;
			}
			
			if (this.startPage<1) {
				this.startPage = 1;
				this.endPage = this.display;
			}
			if (this.endPage>this.totalPage) {
				this.endPage = this.totalPage;
				this.startPage = this.totalPage-this.display+1;
			}
			
		}
	}


	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public Integer getDisplay() {
		return display;
	}

	public void setDisplay(Integer display) {
		this.display = display;
	}
}
