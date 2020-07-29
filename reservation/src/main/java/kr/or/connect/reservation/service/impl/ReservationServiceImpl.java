package kr.or.connect.reservation.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationInfoDao;
import kr.or.connect.reservation.dao.ReservationInfoPriceDao;
import kr.or.connect.reservation.dto.ReservationEnrollDto;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationInfoPrice;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	ReservationInfoDao reservationInfoDao;
	
	@Autowired
	ReservationInfoPriceDao reservationInfoPriceDao;

	@Override
	@Transactional
	public ReservationInfo addReservation(ReservationEnrollDto resvInfo) {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy.MM.dd");
		Date resvDate = new Date();
		try {
			resvDate = fm.parse(resvInfo.getReservationYearMonthDay());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//요청바디 기반으로 생성된 ReservationInfo 객체
		ReservationInfo r = new ReservationInfo(resvInfo.getProductId(),resvInfo.getDisplayInfoId(),resvInfo.getUserId(), resvDate);
		
		//ReservaitonInfo insert 후 반환된 키값
		long resvId = reservationInfoDao.addReservation(r);
		r.setId(resvId);
		
		//ReservationInfoPrice
		List<ReservationInfoPrice> prices = resvInfo.getPrices();
		for(ReservationInfoPrice rp : prices) {
			//reservationInfoId set한 뒤에 insert
			rp.setReservationInfoId(resvId);
			long rpId = reservationInfoPriceDao.addReservationInfoPrice(rp);
			
			//반환된 ReservationInfoPrice id set하여 다시 prices에 add
			rp.setId(rpId);
		}
		r.setPrices(prices);
		
		return r;
	}

}
