package com.organization.mvcproject.api.service;

import java.util.List;

import com.organization.mvcproject.MGL_Task1.model.Game;

//TODO 1.0  follow java interface naming conventions, improve interface name
public interface GameService {

	List<Game> retrieveAllGames();

	Game saveGame(Game game);

}
