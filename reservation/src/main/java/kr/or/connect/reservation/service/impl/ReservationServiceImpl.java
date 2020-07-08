package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.ReservationService;
import static kr.or.connect.reservation.service.ReservationService.*;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationDao reservationDao;
	
	@Override
	@Transactional
	public List<Category> getCategories() {
		
		List<Category> list = reservationDao.selectCategoriesAll();
		
		return list;
	}

	@Override
	public List<Product> getProducts(int categoryId, int start) {
		List<Product> list = null;
		int limit = ReservationService.PRODUCT_LIMIT;
		//categoryId가 0이거나 없을 경우 전체 목록 조회
		if(categoryId == 0) {
			list = reservationDao.selectProductsAll(start, limit);
		}else {
			list = reservationDao.selectProductsByCategoryId(categoryId,start,limit);
		}
		return list;
	}

	@Override
	public int getProductCount(int categoryId) {
		int result = 0;
		if(categoryId == 0) {
			result = reservationDao.selectProductTotalCount();
		}else {
			result = reservationDao.selectProductByCategoryCount(categoryId);
		}
		return result;
	}

	@Override
	public List<Promotion> getPromotions() {
		
		List<Promotion> list = reservationDao.selectPromotionsAll();
		
		return list;
	}

	@Override
	public Product getProductByDisplayId(int displayId) {
		Product p = reservationDao.selectProductByDisplayId(displayId);
		return p;
	}

}
