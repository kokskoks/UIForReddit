package pl.lodz.p.edu.ppkwu.ind187824and179640.dto;

import java.util.List;

public class CategoriesDto {

	private List<CategoryDto> categories;

	public CategoriesDto(List<CategoryDto> categories) {
		super();
		this.categories = categories;
	}

	public List<CategoryDto> getCategories() {
		return categories;
	}
	
	
}
