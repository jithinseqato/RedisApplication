package com.jithin.RedisApplication.repositories;

import java.util.Map;

import com.jithin.RedisApplication.model.Player;

public interface PlayerRedisRepository {

	Map<Object, Object> findAllPlayers();

	void add(Player player);

	void delete(String id);

	Player findPlayer(String id);

}
