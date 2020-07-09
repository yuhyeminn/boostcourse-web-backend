package kr.or.connect.reservation.service;

import java.util.List;
import java.util.Map;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.DisplayImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.Promotion;

public interface ReservationService {
	public static final Integer PRODUCT_LIMIT = 4;
	
	List<Category> getCategories();

	List<Product> getProducts(int categoryId, int start);

	int getProductCount(int categoryId);

	List<Promotion> getPromotions();

	Product getProductByDisplayId(int displayId);

	List<ProductImage> getProductImages(int productId);

	List<DisplayImage> getDisplayImages(int displayId);

	int getAvgScoreByProductId(int productId);

	List<ProductPrice> getProductPricesById(int productId);

}
