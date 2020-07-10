package kr.or.connect.guestbook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuessNumberController {
	@GetMapping("/guess")
	public String guess(@RequestParam(name="number", required=false) Integer number, HttpSession session,
			ModelMap model) {

		String message = null;

		// get방식으로 /guess 를 요청하는데 파라미터 number가 없을 경우에는 session에 count를 0으로 randomNumber엔 1부터 100사이의 값을 저장합니다.
		if(number == null) {
			session.setAttribute("count", 0);
			session.setAttribute("randomNumber", (int)(Math.random() * 100) + 1); // 1 ~ 100사이의 random값
			message = "내가 생각한 숫자를 맞춰보세요.";
		}else {

			// number파라미터가 있을 경우 세션에서 값을 읽어들인 후, number와 세션에 저장된 값을 비교합니다.
			// 값을 비교해서 작거나 크다면 카운트를 1증가시켜주고
			// 값이 같다면 세션 정보를 삭제합니다.
			// 각 상황에 맞는 메시지를 message변수에 저장을 한 후 jsp에게 전달하기 위해서 ModelMap의 addAttribute메소드를 통해 전달하게 됩니다.
			int count = (Integer)session.getAttribute("count");
			int randomNumber = (Integer)session.getAttribute("randomNumber");
		
			
			if(number < randomNumber) {
				message = "입력한 값은 내가 생각하고 있는 숫자보다 작습니다.";
				session.setAttribute("count", ++count);
			}else if(number > randomNumber) {
				message = "입력한 값은 내가 생각하고 있는 숫자보다 큽니다.";
				session.setAttribute("count", ++count);
			}else {
				message = "OK " + ++count + " 번째 맞췄습니다. 내가 생각한 숫자는 " + number + " 입니다.";
				session.removeAttribute("count");
				session.removeAttribute("randomNumber");
			}
		}
		
		model.addAttribute("message", message);
		
		return "guess";
	}
}
