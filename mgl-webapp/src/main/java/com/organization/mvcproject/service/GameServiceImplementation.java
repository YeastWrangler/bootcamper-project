package com.organization.mvcproject.service;

import java.util.ArrayList;
import java.util.List;

import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.model.GameImpl;
import org.springframework.stereotype.Service;



@Service()
public class GameServiceImplementation implements GameService {

	/**
	 * TODO 2.0 The class that interacts with persistent data is called a Data Access Object(DAO)
	 *  or a Repository class. The private static list is mocking our persistance of games.
	 *   
	 *  Move this list, and methods operating on this list to an appropriately named package and class.
	 */
	
	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<com.organization.mvcproject.MGL_Task1.model.Game> games = new ArrayList<com.organization.mvcproject.MGL_Task1.model.Game>();

	static {
		games = populateGames();
	}

	private static List<com.organization.mvcproject.MGL_Task1.model.Game> populateGames() {

		com.organization.mvcproject.MGL_Task1.model.Game game1 = new com.organization.mvcproject.MGL_Task1.model.Game();
		game1.setGame_id(++gameId);
		game1.setGame_genre("Sport");
		game1.setGame_name("Rocket League");

		com.organization.mvcproject.MGL_Task1.model.Game game2 = new com.organization.mvcproject.MGL_Task1.model.Game();
		game2.setGame_id(++gameId);
		game2.setGame_genre("Shooter");
		game2.setGame_name("Halo 3");

		com.organization.mvcproject.MGL_Task1.model.Game game3 = new com.organization.mvcproject.MGL_Task1.model.Game();
		game3.setGame_id(++gameId);
		game3.setGame_genre("MMORPG");
		game3.setGame_name("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}

	@Override
	public List<GameImpl> retrieveAllGames() {
		return (GameImpl) games;
	}

	@Override
	public com.organization.mvcproject.MGL_Task1.model.Game saveGame(com.organization.mvcproject.MGL_Task1.model.Game game) {
		game.setGame_id(++gameId);
		games.add(game);
		return game;
	}



}