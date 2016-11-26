package pl.lodz.p.edu.ppkwu.ind187824and179640.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import pl.lodz.p.edu.ppkwu.ind187824and179640.service.RedditService;
import pl.lodz.p.iis.ppkwu.reddit.api.Category;
import pl.lodz.p.iis.ppkwu.reddit.api.News;
import pl.lodz.p.iis.ppkwu.reddit.api.Page;
import pl.lodz.p.iis.ppkwu.reddit.api.Result;

@RestController
public class RedditController {

	private final RedditService redditService;

	@Autowired
	public RedditController(RedditService redditService) {
		super();
		this.redditService = redditService;
	}
	
	@RequestMapping(path="/categories", method=RequestMethod.GET)
	public DeferredResult<Result<List<Category>>> getCategories(){
		DeferredResult<Result<List<Category>>> result = new DeferredResult<>();
		redditService.findAllCategories(result);
		return result;
	}
	
	@RequestMapping(path="/subbredditWithCategory", method=RequestMethod.GET)
	public DeferredResult<Result<Page<News>>> getSubredditWithCategory(@RequestParam(name="sub") String subreddit,@RequestParam(name="cat") String category){
		DeferredResult<Result<Page<News>>> deferredResult = new DeferredResult<>();
		redditService.findSubredditWithCategory(subreddit, category, deferredResult);
		return deferredResult;
	}
	
	@RequestMapping(path="/newsByUser", method=RequestMethod.GET)
	public DeferredResult<Result<Page<News>>> getUserNews(@RequestParam(name="user")String user){
		DeferredResult<Result<Page<News>>> deferredResult = new DeferredResult<>();
		redditService.findUserNews( user, deferredResult);
		return deferredResult;
	}
	
	@RequestMapping(path="/newsByKeywords", method=RequestMethod.GET)
	public DeferredResult<Result<Page<News>>> getNewsByKeywords(@RequestParam(name="keywords") String[] keywords){
		DeferredResult<Result<Page<News>>> deferredResult = new DeferredResult<>();
		redditService.findNewsByKeywords(keywords, deferredResult);
		return deferredResult;
	}
	
}