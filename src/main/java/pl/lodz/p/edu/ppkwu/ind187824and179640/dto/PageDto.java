package pl.lodz.p.edu.ppkwu.ind187824and179640.dto;

import java.util.List;

public class PageDto {

	private List<NewsDto> news;

	public PageDto(List<NewsDto> news) {
		super();
		this.news = news;
	}

	public List<NewsDto> getNews() {
		return news;
	}
	
	
	
}
