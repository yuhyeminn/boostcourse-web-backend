package kr.or.connect.reservation.dto;

import java.util.Date;
import java.util.List;

public class ReservationInfo {
	private long id;
	private int productId;
	private int displayInfoId;
	private int userId;
	private Date reservationDate;
	private int cancelFlag;
	private Date createDate;
	private Date modifyDate;
	private List<ReservationInfoPrice> prices;
	
	public ReservationInfo() {
		reservationDate = new Date();
		createDate = new Date();
		modifyDate = new Date();
	}
	
	public ReservationInfo(int productId, int displayInfoId, int userId, Date reservationDate) {
		super();
		this.productId = productId;
		this.displayInfoId = displayInfoId;
		this.userId = userId;
		this.reservationDate = reservationDate;
		createDate = new Date();
		modifyDate = new Date();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public int getCancelFlag() {
		return cancelFlag;
	}
	public void setCancelFlag(int cancelFlag) {
		this.cancelFlag = cancelFlag;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public List<ReservationInfoPrice> getPrices() {
		return prices;
	}

	public void setPrices(List<ReservationInfoPrice> prices) {
		this.prices = prices;
	}

	@Override
	public String toString() {
		return "ReservationInfo [id=" + id + ", productId=" + productId + ", displayInfoId=" + displayInfoId
				+ ", userId=" + userId + ", reservationDate=" + reservationDate + ", cancelFlag=" + cancelFlag
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate;
	}

}
