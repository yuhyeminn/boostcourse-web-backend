package kr.or.connect.reservation.controller.api;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.ReservationEnrollDto;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.ReservationService;

@RestController
@RequestMapping(path="/api")
public class ReservationController {

	@Autowired
	ReservationService reservationService;
	
	@ApiOperation(value = "예약 등록하기")
    @ApiResponses({  // Response Message에 대한 Swagger 설명
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Exception")
    })
	@PostMapping("/reservationInfos")
	public ReservationInfo enrollReservationInfos(@RequestBody ReservationEnrollDto resvInfo){
		
		//예약 등록 후 해당 예약 객체 반환
		ReservationInfo r = reservationService.addReservation(resvInfo);
		
		return r;
	}
	
	@ApiOperation(value = "주문 정보 구하기")
	@ApiResponses({  // Response Message에 대한 Swagger 설명
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 500, message = "Exception")
	})
	@GetMapping("/reservationInfos")
	public Map<String, Object> getReservationInfos(Principal principal){
		Map<String, Object> map = new HashMap<>();
		
		//userId == email
		String userId = principal.getName();
		
		List<Map<String,Object>> items = reservationService.selectReservationInfosByEmail(userId);
		
		map.put("items", items);
		map.put("size", items.size());
		
		return map;
	}
	
	@ApiOperation(value = "주문 취소하기")
	@ApiResponses({  // Response Message에 대한 Swagger 설명
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 500, message = "Exception")
	})
	@PutMapping("/reservationInfos")
	public Map<String,Object> cancelReservation(@RequestBody Map<String,Integer> requestBody){
		
		int id = requestBody.get("id");
		//해당 reservation의 cancel_flag 를 1로 변경
		int updateCount = reservationService.updateReservationCancelFlag(id);
		
		return Collections.singletonMap("result", updateCount > 0 ? "success" : "fail");
	}
}
