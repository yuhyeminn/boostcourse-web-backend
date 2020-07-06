package org.edwith.webbe.calculatorcli;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// ApplicationConfig.class 설정파일을 읽어들이는 ApplicationContext객체를 생성합니다.
        // 아래 한줄이 실행되면서 컴포넌트 스캔을 하고, 컴포넌트를 찾으면 인스턴스를 생성하여 ApplicationContext가 관리하게 됩니다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        // ApplicationContext가 관리하는 CalculatorService.class타입의 객체를 요청합니다.
        CalculatorService calculatorService = applicationContext.getBean(CalculatorService.class);
        
        // ApplicationContext로 부터 받은 객체를 잉요하여 덧셈을 구합니다.
        System.out.println(calculatorService.plus(10, 50));
	}
}
