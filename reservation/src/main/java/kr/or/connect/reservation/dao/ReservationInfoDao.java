package kr.or.connect.reservation.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ReservationInfo;
@Repository
public class ReservationInfoDao {
	private NamedParameterJdbcTemplate jdbc;
    private RowMapper<ReservationInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
    private SimpleJdbcInsert insertAction;
    
	public ReservationInfoDao(DataSource dataSource) {
		 this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		 this.insertAction = new SimpleJdbcInsert(dataSource)
	                .withTableName("reservation_info")
	                .usingGeneratedKeyColumns("id");
	}

	public Long addReservation(ReservationInfo r) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(r);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
	
}
