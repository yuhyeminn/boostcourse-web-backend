package kr.or.connect.reservation.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ReservationInfo reservationInfos(@RequestBody ReservationEnrollDto resvInfo){
		
		//예약 등록 후 해당 예약 객체 반환
		ReservationInfo r = reservationService.addReservation(resvInfo);
		
		return r;
	}
	
	
}
