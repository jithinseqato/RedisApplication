package com.jithin.RedisApplication.repositories;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.jithin.RedisApplication.model.Player;

@Repository
public class PlayerRedisRepositoryImpl implements PlayerRedisRepository {

	public static String key = "KEY";

	public RedisTemplate<String, Object> redisTemplate;

	public HashOperations hashOperations;

	@Autowired
	public PlayerRedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
	}

	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public Map<Object, Object> findAllPlayers() {
		// TODO Auto-generated method stub
		return hashOperations.entries(key);
	}

	@Override
	public void add(Player player) {
		// TODO Auto-generated method stub
		hashOperations.put(key, player.getId(), player.getName());
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		hashOperations.delete(key, id);
	}

	@Override
	public Player findPlayer(String id) {
		// TODO Auto-generated method stub
		return new Player(id, (String) hashOperations.get(key, id));
	}

}
