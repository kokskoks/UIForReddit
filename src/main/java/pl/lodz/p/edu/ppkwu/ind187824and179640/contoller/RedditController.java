package pl.lodz.p.edu.ppkwu.ind187824and179640.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import pl.lodz.p.edu.ppkwu.ind187824and179640.dto.CategoriesDto;
import pl.lodz.p.edu.ppkwu.ind187824and179640.dto.PageDto;
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
	
	@RequestMapping(path="/subbredditWithCategory", method=RequestMethod.GET)
	public DeferredResult<PageDto> getSubredditWithCategory(@RequestParam(name="sub") String subreddit,@RequestParam(name="cat") String category){
		DeferredResult<PageDto> deferredResult = new DeferredResult<>();
		redditService.findSubredditWithCategory(subreddit, category, deferredResult);
		return deferredResult;
	}
	
	@RequestMapping(path="/newsByUser", method=RequestMethod.GET)
	public DeferredResult<PageDto> getUserNews(@RequestParam(name="user")String user){
		DeferredResult<PageDto> deferredResult = new DeferredResult<>();
		redditService.findUserNews( user, deferredResult);
		return deferredResult;
	}
	
	@RequestMapping(path="/newsByKeywords", method=RequestMethod.GET)
	public DeferredResult<PageDto> getNewsByKeywords(@RequestParam(name="keywords") String[] keywords){
		DeferredResult<PageDto> deferredResult = new DeferredResult<>();
		redditService.findNewsByKeywords(keywords, deferredResult);
		return deferredResult;
	}
	
}
