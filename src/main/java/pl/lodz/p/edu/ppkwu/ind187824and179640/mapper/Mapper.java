package pl.lodz.p.edu.ppkwu.ind187824and179640.mapper;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.lodz.p.edu.ppkwu.ind187824and179640.dto.CategoriesDto;
import pl.lodz.p.edu.ppkwu.ind187824and179640.dto.CategoryDto;
import pl.lodz.p.edu.ppkwu.ind187824and179640.dto.NewsDto;
import pl.lodz.p.edu.ppkwu.ind187824and179640.dto.PageDto;
import pl.lodz.p.edu.ppkwu.ind187824and179640.dto.UserDto;
import pl.lodz.p.iis.ppkwu.reddit.api.Category;
import pl.lodz.p.iis.ppkwu.reddit.api.News;
import pl.lodz.p.iis.ppkwu.reddit.api.Page;
import pl.lodz.p.iis.ppkwu.reddit.api.User;

@Component
public class Mapper {
	
	public PageDto mapPage(Page<News> page){
		
		List<News> content = page.content();
		List<NewsDto> newsDtos = new ArrayList<>();
		
		for (News news : content) {
			NewsDto newsDto = mapNews(news);
			newsDtos.add(newsDto);
		}
		
		PageDto pageDto = new PageDto(newsDtos);
		
		return pageDto;
		
		
	}

	public NewsDto mapNews(News news) {
		String title = news.title();
		
		User author = news.author();
		
		UserDto userDto = mapUser(author);
	

		
		return new NewsDto(title, userDto, null);

	}

	public UserDto mapUser(User author) {
		
		return new UserDto(author.login());
	}
	
	public CategoriesDto mapCategories(List<Category> categories){

		List<CategoryDto> categoryDtos = new ArrayList<>();
		
		for (Category category : categories) {
			CategoryDto categoryDto = new CategoryDto(category.name());
			categoryDtos.add(categoryDto);
		}
		
		CategoriesDto categoriesDto = new CategoriesDto(categoryDtos);
		
		return categoriesDto;
	}

}
