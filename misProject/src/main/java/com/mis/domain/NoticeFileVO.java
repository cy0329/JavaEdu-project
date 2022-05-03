package com.mis.domain;

public class NoticeFileVO {

	private int noticeFileNo;
	private int noticeNo;
	private String noticeFileName;
	private String FileLocation;

	public int getNoticeFileNo() {
		return noticeFileNo;
	}

	public void setNoticeFileNo(int noticeFileNo) {
		this.noticeFileNo = noticeFileNo;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeFileName() {
		return noticeFileName;
	}

	public void setNoticeFileName(String noticeFileName) {
		this.noticeFileName = noticeFileName;
	}

	public String getFileLocation() {
		return FileLocation;
	}

	public void setFileLocation(String fileLocation) {
		FileLocation = fileLocation;
	}

	@Override
	public String toString() {
		return "NoticeFileVO [noticeFileNo=" + noticeFileNo + ", noticeNo=" + noticeNo + ", noticeFileName="
				+ noticeFileName + ", FileLocation=" + FileLocation + "]";
	}

}
