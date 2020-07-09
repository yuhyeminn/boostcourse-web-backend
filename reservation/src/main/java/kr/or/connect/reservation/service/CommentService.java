package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.ReservationUserComment;

public interface CommentService {

	public static final Integer COMMENT_LIMIT = 5;
	
	int getCommentsCount(int productId);

	List<ReservationUserComment> getComments(int productId, int start);

}
