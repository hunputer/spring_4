package com.choa.s4.member.memberFile;

import org.springframework.stereotype.Component;

@Component
public class MemberFileDTO {

	   private long num;
	   private String id;
	   private String fileName;
	   private String oriName;
	   public long getNum() {
	      return num;
	   }
	   public void setNum(long num) {
	      this.num = num;
	   }
	   public String getId() {
	      return id;
	   }
	   public void setId(String id) {
	      this.id = id;
	   }
	   public String getFileName() {
	      return fileName;
	   }
	   public void setFileName(String fileName) {
	      this.fileName = fileName;
	   }
	   public String getOriName() {
	      return oriName;
	   }
	   public void setOriname(String oriName) {
	      this.oriName = oriName;
	   }
	   	   
}

