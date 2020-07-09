package kr.or.connect.reservation.dao;

public class CommentDaoSqls {

	public static final String SELECT_COMMENT_COUNT = "select count(*) from reservation_user_comment where product_id = :productId";
	public static final String SELECT_COMMENTS_BY_PRODUCT_ID = "select rc.id, product_id, reservation_info_id, score, email as reservation_email, comment, rc.create_date, rc.modify_date from reservation_user_comment as rc left join user as u on rc.user_id = u.id where product_id = :productId order by rc.id desc limit :start, :limit";
}
