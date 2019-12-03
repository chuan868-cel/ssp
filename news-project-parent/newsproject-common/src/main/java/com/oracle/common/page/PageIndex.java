package com.oracle.common.page;

import java.io.Serializable;

public class PageIndex implements Serializable{
	private static final long serialVersionUID = 1L;
	private long startindex;
	private long endindex;

	public PageIndex(long startindex, long endindex) {
		this.startindex = startindex;
		this.endindex = endindex;
	}

	public long getStartindex() {
		return startindex;
	}

	public void setStartindex(long startindex) {
		this.startindex = startindex;
	}

	public long getEndindex() {
		return endindex;
	}

	public void setEndindex(long endindex) {
		this.endindex = endindex;
	}
}
