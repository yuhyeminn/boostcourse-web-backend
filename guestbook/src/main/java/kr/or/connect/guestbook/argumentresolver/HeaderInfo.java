package kr.or.connect.guestbook.argumentresolver;

import java.util.HashMap;
import java.util.Map;

/*
Map객체나 Map을 상속받은 객체는 Spring에서 이미 선언한 아규먼트 리졸버가 처리하기 때문에 전달 할 수 없음
따라서 Map객체를 전달하려면 Map을 필드로 가지고 있는 별도의 객체를 선언한 후 사용해야 함
 */
public class HeaderInfo {
	private Map<String, String> map;
	
	public HeaderInfo() {
		map = new HashMap<>();
	}

	public void put(String name, String value) {
		map.put(name,  value);
	}
	
	public String get(String name) {
		return map.get(name);
	}

}
 