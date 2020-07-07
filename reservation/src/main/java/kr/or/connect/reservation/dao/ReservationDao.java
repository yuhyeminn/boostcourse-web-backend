package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.SELECT_CATEGORIES;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Category;

@Repository
public class ReservationDao {
	
	private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
    
	public ReservationDao(DataSource dataSource) {
		 this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Category> selectAll() {
		return jdbc.query(SELECT_CATEGORIES,rowMapper);
	}
}
