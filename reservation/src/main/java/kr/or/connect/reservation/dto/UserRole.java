package kr.or.connect.reservation.dto;

public class UserRole {
	private Long id;
	private Long userId;
	private String roleName;
	
	public UserRole() {
	}

	public UserRole(Long userId, String roleName) {
		this.userId = userId;
		this.roleName = roleName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
