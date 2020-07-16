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
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.service.CommentService;

@RestController
@RequestMapping(path="/api")
public class CommentController {
	@Autowired
	CommentService commentService;
	

	@ApiOperation(value = "댓글 목록 구하기")
	@ApiResponses({  // Response Message에 대한 Swagger 설명
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 500, message = "Exception")
	})
	@GetMapping("/comments")
	public Map<String, Object> comments(@RequestParam(name="productId", required=false)int productId,
										@RequestParam(name="start",required=false, defaultValue="0")int start) {
		Map<String, Object> map = new HashMap<>();
		
		//해당 상품 전체 댓글 수
		int totalCount = commentService.getCommentsCount(productId);
		map.put("totalCount", totalCount);
		
		//해당 상품 댓글 목록
		List<ReservationUserComment> list = commentService.getComments(productId,start);
		map.put("products", list);
		
		//읽어온 댓글 수
		int commentCount = list.size();
		map.put("commentCount", commentCount);
		
		return map;
	}
}
