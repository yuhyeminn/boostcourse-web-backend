package kr.or.connect.reservation.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.ReservationService;


@RestController
@RequestMapping(path="/api")
public class ReservationApiController {
	@Autowired
	ReservationService reservationService;
	
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
	public Map<String, Object> displayinfos(@RequestParam(name="categoryId", required=false)int categoryId, @RequestParam(name="start",required=false, defaultValue="0")int start) {
		Map<String, Object> map = new HashMap<>();
		
		//상품 리스트
		List<Map<String,Object>> list = reservationService.getProducts(categoryId,start);
		
		return map;
	}
	
	
}
