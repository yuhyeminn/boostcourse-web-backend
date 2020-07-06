package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class RoleExam2 {
	
	public static void main(String[] args) {
		int roleId = 500;
		String description = "CTO";
		
		RoleDao dao = new RoleDao();
		Role role = new Role(roleId, description);
		
		int insertCount = dao.addRole(role);
		System.out.println(insertCount);
	}
}
