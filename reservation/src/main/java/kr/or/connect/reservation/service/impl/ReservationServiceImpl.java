package kr.or.connect.reservation.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationDao reservationDao;
	
	@Override
	@Transactional
	public List<Category> getCategories() {
		
		List<Category> list = reservationDao.selectAll();
		
		return list;
	}

	@Override
	public List<Map<String, Object>> getProducts(int categoryId, int start) {
		
		return null;
	}

}
