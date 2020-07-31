package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static kr.or.connect.reservation.dao.ReservationInfoDaoSqls.*;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
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
	private RowMapper<Map<String,Object>> resvInfoRowMapper = new ColumnMapRowMapper();
	
	public ReservationInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_info")
				.usingGeneratedKeyColumns("id");
	}

	public Long addReservation(ReservationInfo r) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(r);
		return insertAction.executeAndReturnKey(params).longValue();
	}

	public List<Map<String, Object>> selectReservationInfosByEmail(String userId) {
		Map<String, String> params =  Collections.singletonMap("id", userId);
		return jdbc.query(SELECT_RESV_INFOS_BY_EMAIL, params, resvInfoRowMapper);
	}

	public int updateReservationCancelFlag(int resvId) {
		Map<String, Integer> params =  Collections.singletonMap("resvId", resvId);
		return jdbc.update(UPDATE_CANCEL_FLAG_BY_ID, params);
	}

}
