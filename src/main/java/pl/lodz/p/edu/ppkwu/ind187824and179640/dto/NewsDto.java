package pl.lodz.p.edu.ppkwu.ind187824and179640.dto;

public class NewsDto {
	private String title;
	
	private UserDto user;
	
	private String url;

	public NewsDto(String title, UserDto user, String url) {
		super();
		this.title = title;
		this.user = user;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public UserDto getUser() {
		return user;
	}

	public String getUrl() {
		return url;
	}
	
	
}
