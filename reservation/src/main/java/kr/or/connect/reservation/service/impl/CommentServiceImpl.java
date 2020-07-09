package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.CommentDao;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired 
	CommentDao commentDao;
	
	@Override
	public int getCommentsCount(int productId) {
		return commentDao.selectCommentsCount(productId);
	}

	@Override
	public List<ReservationUserComment> getComments(int productId, int start) {
		int limit = CommentService.COMMENT_LIMIT;
		List<ReservationUserComment> list= commentDao.selectCommentsByProductId(productId,start,limit);
		return list;
	}

}
