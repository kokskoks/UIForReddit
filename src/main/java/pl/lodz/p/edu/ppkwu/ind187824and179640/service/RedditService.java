package pl.lodz.p.edu.ppkwu.ind187824and179640.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import pl.lodz.p.edu.ppkwu.ind187824and179640.model.CategoriesDto;
import pl.lodz.p.iis.ppkwu.reddit.api.Reddit;

@Service
public class RedditService {

	private final Reddit reddit;

	@Autowired
	public RedditService(Reddit reddit) {
		super();
		this.reddit = reddit;
	}

	public void findAllCategories(DeferredResult<CategoriesDto> categories) {
		
		reddit.loadCategoriesList((result) -> {
			
			CategoriesDto categoriesDto = mapCategories(categories);
			
			categories.setResult(categoriesDto);
			});
		
	}

	private CategoriesDto mapCategories(DeferredResult<CategoriesDto> categories) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
