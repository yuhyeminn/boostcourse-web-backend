package kr.or.connect.reservation.dto;

import java.util.Date;
import java.util.List;

public class ReservationEnrollDto {

	private int productId;
	private int displayInfoId;
	private int userId;
	private String reservationYearMonthDay;
	private List<ReservationInfoPrice> prices;
	
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
	public String getReservationYearMonthDay() {
		return reservationYearMonthDay;
	}
	public void setReservationYearMonthDay(String reservationYearMonthDay) {
		this.reservationYearMonthDay = reservationYearMonthDay;
	}
	public List<ReservationInfoPrice> getPrices() {
		return prices;
	}
	public void setPrices(List<ReservationInfoPrice> prices) {
		this.prices = prices;
	}
	
	@Override
	public String toString() {
		return "ReservationEnrollDto [productId=" + productId + ", displayInfoId=" + displayInfoId + ", userId="
				+ userId + ", reservationYearMonthDay=" + reservationYearMonthDay + ", prices=" + prices + "]";
	}
	
	
}
