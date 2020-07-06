package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class RoleExam1 {
	
	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(501);
		System.out.println(role);
	}
}
