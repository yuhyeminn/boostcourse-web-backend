package kr.or.connect.reservation.dao;

public class ReservationInfoDaoSqls {
	public static final String INSERT_RESVINFO = "insert into reservation_info(product_id, display_info_id, user_id, reservation_date, create_date, modify_date) values (:productId, :displayInfoId, :userId, STR_TO_DATE(:reservationYearMonthDay, '%Y.%m.%d')";
}
