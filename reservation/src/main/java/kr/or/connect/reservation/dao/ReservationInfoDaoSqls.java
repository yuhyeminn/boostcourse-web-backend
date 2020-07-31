package kr.or.connect.reservation.dao;

public class ReservationInfoDaoSqls {
//	public static final String INSERT_RESVINFO = "insert into reservation_info(product_id, display_info_id, user_id, reservation_date, create_date, modify_date) values (:productId, :displayInfoId, :userId, STR_TO_DATE(:reservationYearMonthDay, '%Y.%m.%d')";
	public static final String SELECT_RESV_INFOS_BY_EMAIL = "select ri.id, ri.product_id as productId, ri.display_info_id as displayInfoId, ri.cancel_flag as cancelFlag,"+
			" p.description as productDescription, p.content as productContent , sum(pp.price*rip.count) as sumPrice, ri.reservation_date as reservationDate, ri.create_date as createDate, ri.modify_date as modifyDate" + 
			" from reservation_info ri left join product p on ri.product_id = p.id" + 
			" join reservation_info_price rip on ri.id = rip.reservation_info_id" + 
			" join product_price pp on rip.product_price_id = pp.id" + 
			" where user_id = (select id from user where email = :id)" + 
			" group by reservation_info_id";
	public static final String UPDATE_CANCEL_FLAG_BY_ID = "update reservation_info set cancel_flag = 1 where id = :resvId ";
}
