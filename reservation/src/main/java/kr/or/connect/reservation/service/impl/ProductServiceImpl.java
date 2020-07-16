package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.DisplayImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao reservationDao;
	
	@Override
	@Transactional
	public List<Category> getCategories() {
		
		List<Category> list = reservationDao.selectCategoriesAll();
		
		return list;
	}

	@Override
	@Transactional
	public List<Product> getProducts(int categoryId, int start) {
		List<Product> list = null;
		int limit = ProductService.PRODUCT_LIMIT;
		//categoryId가 0이거나 없을 경우 전체 목록 조회
		if(categoryId == 0) {
			list = reservationDao.selectProductsAll(start, limit);
		}else {
			list = reservationDao.selectProductsByCategoryId(categoryId,start,limit);
		}
		return list;
	}

	@Override
	@Transactional
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
	@Transactional
	public List<Promotion> getPromotions() {
		
		List<Promotion> list = reservationDao.selectPromotionsAll();
		
		return list;
	}

	@Override
	@Transactional
	public Product getProductByDisplayId(int displayId) {
		Product p = reservationDao.selectProductByDisplayId(displayId);
		return p;
	}

	@Override
	@Transactional
	public List<ProductImage> getProductImages(int productId) {
		List<ProductImage> list = reservationDao.selectProductImagesByProductId(productId);
		return list;
	}

	@Override
	@Transactional
	public List<DisplayImage> getDisplayImages(int displayId) {
		List<DisplayImage> list = reservationDao.selectDisplayImagesByDisplayId(displayId);
		return list;
	}

	@Override
	@Transactional
	public int getAvgScoreByProductId(int productId) {
		return reservationDao.selectAvgScoreByProductId(productId);
	}

	@Override
	@Transactional
	public List<ProductPrice> getProductPricesById(int productId) {
		List<ProductPrice> list = reservationDao.selectProductPricesById(productId);
		return list;
	}

}
