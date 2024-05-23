
package com.organization.mvcproject.controller;

import java.util.List;

import com.organization.mvcproject.model.GameImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.MGL_Task1.model.Game;
import com.organization.mvcproject.MGL_Task1.model.ReviewImpl;
import com.organization.mvcproject.api.service.GameService;


@org.springframework.stereotype.Controller
public class GameController {

	@Autowired
	private GameService gameService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public ModelAndView review() {
	/*
	 * update gamesPage.jsp as well.
	 * SEE:  https://www.baeldung.com/spring-circular-view-path-error
	 */
		return new ModelAndView("reviewCreatePage", "command", new ReviewImpl());
	}

	@RequestMapping(value = "/addReview", method = RequestMethod.POST)
	public ModelAndView addReview(ReviewImpl review, ModelMap model) {
		if(review.getAuthor().isEmpty()) {
			review.setAuthor("anonymous");
		}
	/*
	 * update gamesPage.jsp as well.
	 */
		return new ModelAndView("reviewDetailPage", "submittedReview", review);
	}

	
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public ModelAndView game() {
		/**
		 *
		 * update gamesPage.jsp as well.
		 * SEE:  https://www.baeldung.com/spring-circular-view-path-error
		 */
		return new ModelAndView("gamesPage", "command", new Game());
	}

	/**
	 * TODO 2.0 (Separation of concerns) consider moving all controller endpoints that return a ResponseEntity into a @RestController.
	 */
	
	//TODO 1.0 RequestMapping URL should follow RESTful.
	@RequestMapping(value = "/game/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<GameImpl>> fetchAllGames() {
		return new ResponseEntity<List<GameImpl>>(javaGameService.retrieveAllGames(), HttpStatus.OK);
	}

	//TODO 1.0 RequestMapping URL should follow RESTful convention
	@RequestMapping(value = "/createGame", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody Game game) {
		javaGameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}