package pl.lodz.p.edu.ppkwu.ind187824and179640.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import pl.lodz.p.iis.ppkwu.reddit.api.Category;
import pl.lodz.p.iis.ppkwu.reddit.api.News;
import pl.lodz.p.iis.ppkwu.reddit.api.Page;
import pl.lodz.p.iis.ppkwu.reddit.api.Reddit;
import pl.lodz.p.iis.ppkwu.reddit.api.Result;
import pl.lodz.p.iis.ppkwu.reddit.api.Subreddit;
import pl.lodz.p.iis.ppkwu.reddit.api.User;

@Service
public class RedditService {

	private final Reddit reddit;

	@Autowired
	public RedditService(Reddit reddit) {
		super();
		this.reddit = reddit;
	}

	public void findAllCategories(DeferredResult<Result<List<Category>>> categories) {
		
		reddit.loadCategoriesList((result) -> {
		
			
			categories.setResult(result);
			});
		
	}

	public void findSubredditWithCategory(String subredditName, String categoryName, DeferredResult<Result<Page<News>>> deferredResult) {
		Subreddit subreddit = new Subreddit() {
			
			@Override
			public String title() {
				return subredditName;
			}
		};
		
		Category category = new Category() {
			
			@Override
			public String name() {
				return categoryName;
			}
		};
		
		reddit.loadSubredditNews(subreddit, category, (result) -> {
			deferredResult.setResult(result);
		});
		
	}

	
	public void findUserNews(String userName, DeferredResult<Result<Page<News>>> deferredResult) {
		User user = new User(){
			@Override
			public String login() {
				return userName;
			}
		};
		
		reddit.loadUserNews(user, (result) -> {
			deferredResult.setResult(result);
		});
		
	}
	
	public void findNewsByKeywords(String[] keywords, DeferredResult<Result<Page<News>>> deferredResult){
		
		reddit.loadNewsByKeywords(Arrays.asList(keywords), (result) -> {
			deferredResult.setResult(result);
		});
	}
	
	
}
