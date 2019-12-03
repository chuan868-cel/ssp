package com.oracle.common.page;

import java.io.Serializable;
import java.util.List;


public class PageView<E> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8493201024126710421L;

	/**
	 * 分页数据
	 */
	private List<E> records;

	/**
	 * 页码的开始索引类 这个类包含， startindex 开始索引 endindex 结束索引 这个数是计算出来的
	 */
	private PageIndex pageindex;

	/**
	 * 总页数 这个数是计算出来的
	 * 
	 */
	private long pageCount;

	/**
	 * 每页显示几条记录
	 */
	private int pageSize = 10;

	/**
	 * 默认 当前页 为第一页 这个数是计算出来的
	 */
	private int pageNow = 1;

	/**
	 * 总记录数
	 */
	private long rowCount;

	/**
	 * 从第几条记录开始
	 */
	private int startPage;

	/**
	 * 规定显示5个页码
	 */
	private int pagecode = 5;

	public PageView() {
	}

	/**
	 * 要获得记录的开始索引 即 开始页码
	 * 
	 * @return
	 */
	public int getFirstResult() {
		return (this.pageNow - 1) * this.pageSize;
	}

	public int getPagecode() {
		return pagecode;
	}

	public void setPagecode(int pagecode) {
		this.pagecode = pagecode;
	}

	/**
	 * 使用构造函数，，强制必需输入 每页显示数量 和 当前页
	 * 
	 * @param pageSize
	 *            每页显示数量
	 * @param pageNow
	 *            当前页
	 */
	public PageView(int pageSize, int pageNow) {
		this.pageSize = pageSize;
		this.pageNow = pageNow;
	}

	/**
	 * 使用构造函数，，强制必需输入 当前页
	 * 
	 * @param pageNow
	 *            当前页
	 */
	public PageView(int pageNow) {
		this.pageNow = pageNow;
		startPage = (this.pageNow - 1) * this.pageSize;
	}

	/**
	 * 查询结果方法 把 记录数 结果集合 放入到 PageView对象
	 * 
	 * @param rowCount
	 *            总记录数
	 * @param records
	 *            结果集合
	 */

	public void setQueryResult(long rowCount, List<E> records) {
		setRowCount(rowCount);
		setRecords(records);
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
		setPageCount(
				this.rowCount % this.pageSize == 0 ? this.rowCount / this.pageSize : this.rowCount / this.pageSize + 1);
	}

	public List<E> getRecords() {
		return records;
	}

	public void setRecords(List<E> records) {
		this.records = records;
	}

	public PageIndex getPageindex() {
		return pageindex;
	}

	public void setPageindex(PageIndex pageindex) {
		this.pageindex = pageindex;
	}

	/**
	 * WebTool这是一个分页工具类
	 * 
	 * @author Administrator
	 * 
	 *         pagecode 要获得记录的开始索引 即 开始页码 pageNow 当前页 pageCount 总页数
	 *
	 *         这个工具类 返回的是页索引 PageIndex
	 * 
	 *         在这个方法中存在一个问题，每页显示数量 和 当前页、、不能为空 必需输入
	 */
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
		this.pageindex = getPageIndex(pagecode, pageNow, pageCount);
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public long getPageCount() {
		return pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getRowCount() {
		return rowCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	private static PageIndex getPageIndex(long pagecode, int pageNow, long pageCount) {
		long startpage = pageNow - (pagecode % 2 == 0 ? pagecode / 2 - 1 : pagecode / 2);
		long endpage = pageNow + pagecode / 2;
		if (startpage < 1) {
			startpage = 1;
			if (pageCount >= pagecode)
				endpage = pagecode;
			else
				endpage = pageCount;
		}
		if (endpage > pageCount) {
			endpage = pageCount;
			if ((endpage - pagecode) > 0)
				startpage = endpage - pagecode + 1;
			else
				startpage = 1;
		}
		return new PageIndex(startpage, endpage);
	}

}
