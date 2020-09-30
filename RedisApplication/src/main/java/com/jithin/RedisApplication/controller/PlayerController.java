package com.jithin.RedisApplication.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jithin.RedisApplication.model.Player;
import com.jithin.RedisApplication.service.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@PostMapping("/value")
	public ResponseEntity<Player> addValue(@RequestBody Player player) {
		playerService.add(player);
		return ResponseEntity.ok().body(player);
	}

	@GetMapping("/value/{id}")
	public ResponseEntity<Player> getValue(@PathVariable String id) {
		return ResponseEntity.ok().body(playerService.get(id));
	}

	@GetMapping("/value")
	public ResponseEntity<Map<Object, Object>> getvalues() {
		return ResponseEntity.ok().body(playerService.get());
	}

	@DeleteMapping("/value/{id}")
	public ResponseEntity<Boolean> deleteValue(@PathVariable String id) {
		return ResponseEntity.ok().body(playerService.delete(id));
	}

}
