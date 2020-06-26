package com.naver.rjs;

import java.util.List;

public class RJSPageTO {

	private int curPage = 1; //현재 페이지
	private int perPage = 10; // 페이지 당 10개 글 표시
	private int pageLine = 10;	//1~10 11~20 한페이지에서 보여줄수있는 번호 갯수
	private int amount;	//게시글의 총갯수 
	private int totalPage; //총 페이지
	private int startNum;	//rownum값 1번부터  페이지 글 시작
	private int endNum;	//한페이지에서 보여줄수 있는 번호 /10번까지 페이지 끝
	private int beginPageNum;	// 출력 시작
	private int stopPageNum;	// 그만
	
	private List<RJSBoardDTO> list;
	
	public RJSPageTO() {
		changeVarVal();
	}

	public RJSPageTO(int curPage) {
		super();
		this.curPage = curPage;
		changeVarVal();
		
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
		changeVarVal();
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
		changeVarVal();
	}

	public int getPageLine() {
		return pageLine;
	}

	public void setPageLine(int pageLine) {
		this.pageLine = pageLine;
		changeVarVal();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		changeVarVal();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getBeginPageNum() {
		return beginPageNum;
	}

	public void setBeginPageNum(int beginPageNum) {
		this.beginPageNum = beginPageNum;
	}

	public int getStopPageNum() {
		return stopPageNum;
	}

	public void setStopPageNum(int stopPageNum) {
		this.stopPageNum = stopPageNum;
	}

	public List<RJSBoardDTO> getList() {
		return list;
	}

	public void setList(List<RJSBoardDTO> list) {
		this.list = list;
	}
	
	private void changeVarVal() {
		totalPage = amount/perPage;
		if (amount % perPage != 0) {
			totalPage = totalPage+1;
		}
		
		startNum = (curPage -1) * perPage +1;
		endNum = curPage * perPage;
		if (endNum > amount) {
			endNum = amount;
			// 총게시글의 수가 27
			// endNum = 30이 들어갈수 없으니까 27로 맞춘다
		}
		
		beginPageNum = ((curPage -1) / pageLine)*pageLine +1;
		stopPageNum = beginPageNum + (pageLine-1);
		if (stopPageNum > totalPage) {
			stopPageNum = totalPage;
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
}

