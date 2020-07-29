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
import kr.or.connect.reservation.dto.ReservationInfoPrice;
@Repository
public class ReservationInfoPriceDao {
	private NamedParameterJdbcTemplate jdbc;
    private RowMapper<ReservationInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
    private SimpleJdbcInsert insertAction;
    
	public ReservationInfoPriceDao(DataSource dataSource) {
		 this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		 this.insertAction = new SimpleJdbcInsert(dataSource)
	                .withTableName("reservation_info_price")
	                .usingGeneratedKeyColumns("id");
	}

	public long addReservationInfoPrice(ReservationInfoPrice rp) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(rp);
		return insertAction.executeAndReturnKey(params).longValue();
	}

	
}
