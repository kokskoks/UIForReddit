package pl.lodz.p.edu.ppkwu.ind187824and179640.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lodz.p.iis.ppkwu.reddit.api.Reddit;

@Service
public class RedditService {

	private final Reddit reddit;

	@Autowired
	public RedditService(Reddit reddit) {
		super();
		this.reddit = reddit;
	}
	
	
	
	
}
