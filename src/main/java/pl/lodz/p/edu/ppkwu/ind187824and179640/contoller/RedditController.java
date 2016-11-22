package pl.lodz.p.edu.ppkwu.ind187824and179640.contoller;

import org.junit.experimental.categories.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.sun.research.ws.wadl.Request;

import pl.lodz.p.edu.ppkwu.ind187824and179640.model.CategoriesDto;
import pl.lodz.p.edu.ppkwu.ind187824and179640.service.RedditService;

@RestController
public class RedditController {

	private final RedditService redditService;

	@Autowired
	public RedditController(RedditService redditService) {
		super();
		this.redditService = redditService;
	}
	
	@RequestMapping(path="/categories", method=RequestMethod.GET)
	public DeferredResult<CategoriesDto> getCategories(){
		DeferredResult<CategoriesDto> result = new DeferredResult<>();
		redditService.findAllCategories(result);
		return result;
	}
	
	
}
