package com.jithin.RedisApplication.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jithin.RedisApplication.model.Player;
import com.jithin.RedisApplication.repositories.PlayerRedisRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRedisRepository playerRedisRepository;

	public void add(Player player) {
		playerRedisRepository.add(player);
	}

	public Player get(String id) {
		return playerRedisRepository.findPlayer(id);
	}

	public Map<Object, Object> get() {
		return playerRedisRepository.findAllPlayers();
	}

	public boolean delete(String id) {
		playerRedisRepository.delete(id);
		return true;
	}

}
