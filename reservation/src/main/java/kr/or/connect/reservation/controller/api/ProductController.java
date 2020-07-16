package kr.or.connect.reservation.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.dto.DisplayImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.service.CommentService;
import kr.or.connect.reservation.service.ProductService;


@RestController
@RequestMapping(path="/api")
public class ProductController {
	@Autowired
	ProductService reservationService;
	
	@ApiOperation(value = "카테고리 목록 구하기")
    @ApiResponses({  // Response Message에 대한 Swagger 설명
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Exception")
    })
	@GetMapping("/categories")
	public Map<String, Object> categories() {
		Map<String, Object> map = new HashMap<>();
		
		//카테고리 목록 리스트
		List<Category> list = reservationService.getCategories();
		map.put("items", list);
		
		int size = list.size();
		map.put("size", size);
		
		return map;
	}
	
	@ApiOperation(value = "상품 목록 구하기")
	@ApiResponses({  // Response Message에 대한 Swagger 설명
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 500, message = "Exception")
	})
	@GetMapping("/displayinfos")
	public Map<String, Object> displayinfos(@RequestParam(name="categoryId", required=false, defaultValue="0")int categoryId,
											@RequestParam(name="start",required=false, defaultValue="0")int start) {
		Map<String, Object> map = new HashMap<>();
		
		//전체 상품 수 by categoryId
		int totalCount = reservationService.getProductCount(categoryId);
		map.put("totalCount", totalCount);
		
		//상품 리스트
		List<Product> list = reservationService.getProducts(categoryId,start);
		map.put("products", list);
		
		//읽어온 전시 상품 수
		int productCount = list.size();
		map.put("productCount", productCount);
		
		
		return map;
	}
	
	@ApiOperation(value = "프로모션 목록 구하기")
	@ApiResponses({  // Response Message에 대한 Swagger 설명
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 500, message = "Exception")
	})
	@GetMapping("/promotions")
	public Map<String, Object> promotions() {
		Map<String, Object> map = new HashMap<>();
		
		//프로모션 상품 목록
		List<Promotion> list = reservationService.getPromotions();
		map.put("items", list);
		
		//프로모션 개수
		map.put("size",list.size());
		
		return map;
	}
	
	@ApiOperation(value = "전시 정보 구하기")
	@ApiResponses({  // Response Message에 대한 Swagger 설명
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 500, message = "Exception")
	})
	@GetMapping("/displayinfos/{displayId}")
	public Map<String, Object> displayinfos(@PathVariable(name="displayId") int displayId) {
		Map<String, Object> map = new HashMap<>();
		
		//select product one by displayInfoId
		Product p = reservationService.getProductByDisplayId(displayId);
		map.put("product", p);
		
		int productId = p.getId();

		//전시상품 이미지 목록
		List<ProductImage> productImageList = reservationService.getProductImages(productId);
		map.put("productImages", productImageList);
		
		//전시정보 이미지 목록
		List<DisplayImage> displayImageList = reservationService.getDisplayImages(displayId);
		map.put("displayImages", displayImageList);
		
		//평균 평점
		int avgScore = reservationService.getAvgScoreByProductId(productId);
		map.put("avgScore",avgScore);
		
		//상품 가격 목록
		List<ProductPrice> productPriceList = reservationService.getProductPricesById(productId);
		map.put("productPrices", productPriceList);
		
		return map;
	}
}
