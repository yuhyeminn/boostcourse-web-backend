package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.CommentDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ReservationUserComment;


@Repository
public class CommentDao {
	private NamedParameterJdbcTemplate jdbc;
    private RowMapper<ReservationUserComment> commentRowMapper = BeanPropertyRowMapper.newInstance(ReservationUserComment.class);
    
	public CommentDao(DataSource dataSource) {
		 this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public int selectCommentsCount(int productId) {
		Map<String,Integer> param = new HashMap<>();
		param.put("productId",productId);
		return jdbc.queryForObject(SELECT_COMMENT_COUNT, param, Integer.class);
	}

	public List<ReservationUserComment> selectCommentsByProductId(int productId, int start, int limit) {
		Map<String,Integer> param = new HashMap<>();
		param.put("productId",productId);
		param.put("start",start);
		param.put("limit",limit);
		return jdbc.query(SELECT_COMMENTS_BY_PRODUCT_ID, param, commentRowMapper);
	}
}
