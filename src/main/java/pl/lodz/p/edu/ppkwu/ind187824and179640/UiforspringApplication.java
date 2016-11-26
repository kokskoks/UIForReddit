package pl.lodz.p.edu.ppkwu.ind187824and179640;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pl.lodz.p.iis.ppkwu.reddit.api.Callback;
import pl.lodz.p.iis.ppkwu.reddit.api.Category;
import pl.lodz.p.iis.ppkwu.reddit.api.News;
import pl.lodz.p.iis.ppkwu.reddit.api.Page;
import pl.lodz.p.iis.ppkwu.reddit.api.Reddit;
import pl.lodz.p.iis.ppkwu.reddit.api.RedditBuilder;
import pl.lodz.p.iis.ppkwu.reddit.api.Result;
import pl.lodz.p.iis.ppkwu.reddit.api.ResultStatus;
import pl.lodz.p.iis.ppkwu.reddit.api.Subreddit;
import pl.lodz.p.iis.ppkwu.reddit.api.User;

@SpringBootApplication
public class UiforspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(UiforspringApplication.class, args);
	}
	
	@Bean
	public Reddit reddit(RedditBuilder redditBuilder){
		return redditBuilder.build();
	}
	
	@Bean
	public RedditBuilder mockRedditBuilder(){
		return new RedditBuilder() {
			
			@Override
			public RedditBuilder withCallbackExecutor(Executor callbackExecutor) {
				
				return this;
			}
			
			@Override
			public Reddit build() {
				return new Reddit() {
					
					@Override
					public User userWithLogin(String login) {
						// TODO Auto-generated method stub
						return null;
					}
					
					@Override
					public Subreddit subredditWithName(String name) {
						// TODO Auto-generated method stub
						return null;
					}
					
					@Override
					public void loadUserNews(User user, Callback<Page<News>> callback) throws NullPointerException {
						Page<News> page = dummyPage();
						
						callback.finished(dummyResult(page));
						
					}

					private <T> Result<T> dummyResult(T content) {
						return new Result<T>() {
							
							@Override
							public boolean succeeded() {
								return true;
							}
							
							@Override
							public ResultStatus status() {
								return ResultStatus.SUCCEEDED;
							}
							
							@Override
							public Optional<T> content() {
								return  Optional.of(content);
							}
						};
					}

					private Page<News> dummyPage() {
						Page<News> page = new Page<News>() {
							
							@Override
							public List<News> content() {
								
								List<News> list = new ArrayList<>();
								
								for(int i = 0; i < 5; i++){
									News news = new News() {
										
										@Override
										public String title() {
											return "title " + Math.random();
										}
										
										@Override
										public Optional<URL> thumbnailUrl() {
											
											return null;
										}
										
										@Override
										public User author() {
											User user = new User() {
												
												@Override
												public String login() {
													return "User " + Math.random();
												}
											};
											return user;
										}
									};
									
									list.add(news);
								}
								
								return list;
							}
						};
						return page;
					}
					
					@Override
					public void loadSubredditNews(Subreddit subreddit, Category category, Callback<Page<News>> callback)
							throws NullPointerException {
						Page<News> page = dummyPage();
						
						callback.finished(dummyResult(page));
						
					}
					
					@Override
					public void loadNewsByKeywords(List<String> keywords, Callback<Page<News>> callback) throws NullPointerException {
						Page<News> page = dummyPage();
						callback.finished(dummyResult(page));
						
					}
					
					@Override
					public void loadCategoriesList(Callback<List<Category>> callback) throws NullPointerException {
						List<Category> categories = new ArrayList<>();
						
						for(int i = 0; i < 5; i++){
							Category category = new Category() {
								
								@Override
								public String name() {
									return "cat " + Math.random();
								}
							};
							
							categories.add(category);
						}
						
						callback.finished(dummyResult(categories));
					}
				};
			}
		};
	}
	
}
