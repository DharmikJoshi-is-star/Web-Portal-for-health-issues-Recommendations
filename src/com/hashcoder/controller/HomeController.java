package com.hashcoder.controller;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hashcoder.database.AnswerDB;
import com.hashcoder.database.PostDB;
import com.hashcoder.database.QueryDB;
import com.hashcoder.database.UserDB;
import com.hashcoder.model.Answer;
import com.hashcoder.model.Post;
import com.hashcoder.model.Query;
import com.hashcoder.model.User;


@Controller
public class HomeController {

	@Autowired
	User user;
	
	@Autowired
	UserDB userDB;
	
	@Autowired
	QueryDB queryDB;
	
	@Autowired
	AnswerDB answerDB;
	
	@Autowired
	PostDB postDB;
	
	@RequestMapping("/home")
	public String showHome(Model model, @RequestParam("user_id") int user_id) {
		
		try {
			User user  = userDB.getUserById(user_id);
			user = userDB.getUserValues(user);
			user = userDB.getDisease(user);
			user = userDB.getFollowers(user);
			
			for (User temp : user.getFollowers()) {
				System.out.println("follower name: ");
				System.out.println(temp.getName());
			}
			
			System.out.println("----"+user.getId());
			System.out.println(user.getName()+"----");
			
			user = userDB.getFollowings(user);
		
			for (User temp : user.getFollowing()) {
				System.out.println(temp.getName());
			}
			
			
			user.setQueries(queryDB.getQueryByUserId(user_id));
			
			for (Query que : user.getQueries()) {
				for (Answer ans : que.getAnswers()) {
					System.out.println(ans.getAnswer());
				}
			}
			
			
			user.setAnswers(answerDB.getAnswersByUserId(user_id));
			
			user=postDB.getPostsByUser(user);
			
			List<Post> posts = postDB.getAllPost();
			
			List<Query> queries = queryDB.getAll();
			
			
			List<Query> recentQueries = queryDB.getAll();
			
			recentQueries = recentQueries.stream()
					  .sorted(Comparator.comparing(Query::getDate))
					  .collect(Collectors.toList());
			
			recentQueries = recentQueries.stream()
					  .sorted(Comparator.comparing(Query::getTime))
					  .collect(Collectors.toList());
			
			for (Query query : recentQueries) {
				System.out.println(query.getQuery());
			}
			
			model.addAttribute("recentQueries",recentQueries);
			model.addAttribute("posts",posts);
			model.addAttribute("queries", queries);
			model.addAttribute("queryDB", queryDB);
			model.addAttribute("user", user);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}

	@RequestMapping("/rate-post")
	public String ratePost(@RequestParam("user_id") int user_id, 
							@RequestParam("post_id") int post_id,
							@RequestParam("rating") int rating) {
		
		try {
			postDB.insertRating(user_id, post_id, rating);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "redirect:home?user_id="+user_id;
	}

	@RequestMapping("/rate-answer")
	public String rateAnswer(@RequestParam("user_id") int user_id, 
			@RequestParam("answer_id") int answer_id,
			@RequestParam("rating") int rating) {

		try {
			answerDB.insertRatingForAnswer(user_id, answer_id, rating);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:home?user_id="+user_id;
	}
	
	@RequestMapping("/follow-user")
	public String followUser(@RequestParam("user_id") int user_id,
						@RequestParam("otherUser_id") int otherUser_id) {
		
		try {
			userDB.insertFollowOtherUser(user_id, otherUser_id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:home?user_id="+user_id;
	}
	
	
	
	@RequestMapping("/addQuery")
	public String addQuery(@RequestParam("user_id") int user_id,
							HttpServletRequest request) {
		
		try {
			String query = request.getParameter("queryField");
			queryDB.insertQuery(user_id, query);
			//put query diseases data
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:home?user_id="+user_id;
	}
	
	@RequestMapping("/addAnswer")
	public String addAnswer(@RequestParam("user_id") int user_id,
								@RequestParam("question_id") int question_id,
								HttpServletRequest request,
								@RequestParam("type") String type,
								Model model) {
		
		try {
			String answer = request.getParameter("answerField");
			
			answerDB.insertAnswer(user_id, question_id, answer, type);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			User user  = userDB.getUserById(user_id);
			user = userDB.getUserValues(user);
			user = userDB.getDisease(user);
			user = userDB.getFollowers(user);
			
			for (User temp : user.getFollowers()) {
				System.out.println("follower name: ");
				System.out.println(temp.getName());
			}
			
			System.out.println("----"+user.getId());
			System.out.println(user.getName()+"----");
			
			user = userDB.getFollowings(user);
		
			for (User temp : user.getFollowing()) {
				System.out.println(temp.getName());
			}
			
			
			user.setQueries(queryDB.getQueryByUserId(user_id));
			
			for (Query que : user.getQueries()) {
				for (Answer ans : que.getAnswers()) {
					System.out.println(ans.getAnswer());
				}
			}
			
			
			user.setAnswers(answerDB.getAnswersByUserId(user_id));
			
			user=postDB.getPostsByUser(user);
			
			List<Query> queries = queryDB.getAll();
			
			model.addAttribute("queries", queries);
			model.addAttribute("queryDB", queryDB);
			model.addAttribute("user", user);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:home?user_id="+user_id;

	
	}
	
	
	@RequestMapping("/uploadPost")
	public String uploadPost(@RequestParam("user_id") int user_id,
						@RequestParam("category") int category_id,
						HttpServletRequest request) {
		
		Post post = new Post();
		post.setPost(request.getParameter("postData").toString());
		
		try {
			postDB.insertPost(post,user_id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//request.getAttribute("category");
		
		return "redirect:home?user_id="+user_id;
	}
	
}


