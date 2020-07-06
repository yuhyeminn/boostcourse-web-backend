package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("초기화 완료!!");
		
		UserBean userBean = (UserBean)ac.getBean("userBean");
		userBean.setName("yu");
		UserBean userBean2 = (UserBean)ac.getBean("userBean");
		
		System.out.println(userBean.getName());
		
		if(userBean == userBean2) {
			System.out.println("같은 인스턴스입니다.");
		}
	}
}
