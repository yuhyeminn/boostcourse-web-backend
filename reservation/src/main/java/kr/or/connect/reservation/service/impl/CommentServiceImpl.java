package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CommentDao;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired 
	CommentDao commentDao;
	
	@Override
	@Transactional
	public int getCommentsCount(int productId) {
		return commentDao.selectCommentsCount(productId);
	}

	@Override
	@Transactional
	public List<ReservationUserComment> getComments(int productId, int start) {
		int limit = CommentService.COMMENT_LIMIT;
		List<ReservationUserComment> list= commentDao.selectCommentsByProductId(productId,start,limit);
		return list;
	}

}
