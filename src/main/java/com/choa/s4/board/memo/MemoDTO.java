package com.choa.s4.board.memo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class MemoDTO {
	private long num;
	private String writer;
	private String contents;
	private Date regDate;
	
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
