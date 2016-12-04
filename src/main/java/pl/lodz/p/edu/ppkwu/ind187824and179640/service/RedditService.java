package pl.lodz.p.edu.ppkwu.ind187824and179640.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import pl.lodz.p.edu.ppkwu.ind187824and179640.dto.CategoriesDto;
import pl.lodz.p.edu.ppkwu.ind187824and179640.dto.PageDto;
import pl.lodz.p.edu.ppkwu.ind187824and179640.mapper.Mapper;
import pl.lodz.p.iis.ppkwu.reddit.api.Category;
import pl.lodz.p.iis.ppkwu.reddit.api.Reddit;
import pl.lodz.p.iis.ppkwu.reddit.api.Subreddit;
import pl.lodz.p.iis.ppkwu.reddit.api.User;
import pl.lodz.p.iis.ppkwu.reddit.backend.data.builders.CategoryBuilder;

@Service
public class RedditService {

	private final Reddit reddit;

	private final Mapper mapper;

	@Autowired
	public RedditService(Reddit reddit, Mapper mapper) {
		super();
		this.reddit = reddit;
		this.mapper = mapper;
	}

	public void findAllCategories(DeferredResult<CategoriesDto> categories) {

		reddit.loadCategoriesList((result) -> {

			categories.setResult(mapper.mapCategories(result.content().get()));
		});

	}

	public void findSubredditWithCategory(String subredditName, String categoryName,
			DeferredResult<PageDto> deferredResult) {
		Subreddit subreddit = reddit.subredditWithName(subredditName);

		Category category = new CategoryBuilder().withName(categoryName).build();
		reddit.loadSubredditNews(subreddit, category, (result) -> {
			deferredResult.setResult(mapper.mapPage(result.content().get()));
		});

	}

	public void findUserNews(String userName, DeferredResult<PageDto> deferredResult) {
		User user = reddit.userWithLogin(userName);

		reddit.loadUserNews(user, (result) -> {
			deferredResult.setResult(mapper.mapPage(result.content().get()));
		});

	}

	public void findNewsByKeywords(String[] keywords, DeferredResult<PageDto> deferredResult) {

		reddit.loadNewsByKeywords(Arrays.asList(keywords), (result) -> {
			deferredResult.setResult(mapper.mapPage(result.content().get()));
		});
	}

}
