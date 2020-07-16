package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ProductDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.DisplayImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.Promotion;

@Repository
public class ProductDao {
	
	private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Category> categoryRowMapper = BeanPropertyRowMapper.newInstance(Category.class);
    private RowMapper<Product> productRowMapper = BeanPropertyRowMapper.newInstance(Product.class);
    private RowMapper<Promotion> promotionRowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);
    private RowMapper<ProductImage> productImageRowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
    private RowMapper<DisplayImage> displayImageRowMapper = BeanPropertyRowMapper.newInstance(DisplayImage.class);
    private RowMapper<ProductPrice> productPriceRowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);
    
	public ProductDao(DataSource dataSource) {
		 this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Category> selectCategoriesAll() {
		return jdbc.query(SELECT_CATEGORIES,categoryRowMapper);
	}

	public List<Product> selectProductsAll(int start, int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_PRODUCTS,params,productRowMapper);
	}

	public List<Product> selectProductsByCategoryId(int categoryId, int start, int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_PRODUCTS_BY_CATEGORYID,params,productRowMapper);
	}

	public int selectProductTotalCount() {
		return jdbc.queryForObject(SELECT_PRODUCT_COUNT, Collections.emptyMap(), Integer.class);
	}

	public int selectProductByCategoryCount(int categoryId) {
		Map<String, Integer> param = new HashMap<>();
		param.put("categoryId", categoryId);
		return jdbc.queryForObject(SELECT_PRODUCT_BY_CATEGORY_COUNT, param, Integer.class);
	}

	public List<Promotion> selectPromotionsAll() {
		return jdbc.query(SELECT_PROMOTIONS,promotionRowMapper);
	}

	public Product selectProductByDisplayId(int displayId) {
		Map<String, Integer> param = new HashMap<>();
		param.put("displayId", displayId);
		return jdbc.queryForObject(SELECT_PRODUCT_BY_DISPLAY_ID, param,productRowMapper);
	}

	public List<ProductImage> selectProductImagesByProductId(int productId) {
		Map<String, Integer> param = new HashMap<>();
		param.put("productId", productId);
		return jdbc.query(SELECT_PRODUCT_IMAGES_BY_ID, param, productImageRowMapper);
	}

	public List<DisplayImage> selectDisplayImagesByDisplayId(int displayId) {
		Map<String, Integer> param = new HashMap<>();
		param.put("displayId", displayId);
		return jdbc.query(SELECT_DISPLAY_IMAGES_BY_ID, param, displayImageRowMapper);
	}

	public int selectAvgScoreByProductId(int productId) {
		Map<String, Integer> param = new HashMap<>();
		param.put("productId", productId);
		return jdbc.queryForObject(SELECT_AVG_SCORE_BY_PRODUCTID, param, Integer.class);
	}

	public List<ProductPrice> selectProductPricesById(int productId) {
		Map<String, Integer> param = new HashMap<>();
		param.put("productId", productId);
		return jdbc.query(SELECT_PRODUCT_PRICE_BY_ID, param, productPriceRowMapper);
	}
}
