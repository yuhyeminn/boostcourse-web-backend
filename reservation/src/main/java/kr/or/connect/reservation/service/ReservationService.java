package kr.or.connect.reservation.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.ReservationEnrollDto;
import kr.or.connect.reservation.dto.ReservationInfo;

@Service
public interface ReservationService {

	ReservationInfo addReservation(ReservationEnrollDto resvInfo);

	List<Map<String, Object>> selectReservationInfosByEmail(String userId);

	int updateReservationCancelFlag(int resvId);

}
