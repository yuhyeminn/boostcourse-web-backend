package kr.or.connect.reservation.dto;

public class ReservationInfoPrice {

	private long id;
	private long reservationInfoId;
	private int productPriceId;
	private int count;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getReservationInfoId() {
		return reservationInfoId;
	}
	public void setReservationInfoId(long reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	public int getProductPriceId() {
		return productPriceId;
	}
	public void setProductPriceId(int productPriceId) {
		this.productPriceId = productPriceId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "ReservationInfoPrice [id=" + id + ", reservationInfoId=" + reservationInfoId + ", productPriceId="
				+ productPriceId + ", count=" + count + "]";
	}
	
	
}
