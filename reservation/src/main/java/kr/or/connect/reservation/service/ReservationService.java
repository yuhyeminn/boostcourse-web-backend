package kr.or.connect.reservation.service;

import java.util.List;
import java.util.Map;

import kr.or.connect.reservation.dto.Category;

public interface ReservationService {

	List<Category> getCategories();

	List<Map<String, Object>> getProducts(int categoryId, int start);

}
