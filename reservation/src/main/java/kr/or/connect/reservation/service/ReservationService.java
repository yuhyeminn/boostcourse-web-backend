package kr.or.connect.reservation.service;

import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dto.ReservationEnrollDto;
import kr.or.connect.reservation.dto.ReservationInfo;

@Service
public interface ReservationService {

	ReservationInfo addReservation(ReservationEnrollDto resvInfo);

}
