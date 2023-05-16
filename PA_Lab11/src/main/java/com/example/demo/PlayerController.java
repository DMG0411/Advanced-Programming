package com.example.demo;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final List<Player> players = new ArrayList<>();
    public PlayerController(){
        players.add(new Player(1,"George Bush",'W'));
        players.add(new Player(2,"George CLinton",'B'));
    }

    @GetMapping
    public List<Player> getPlayers(){
        return players;
    }
    @GetMapping("/count")
    public int countPlayers(){
        return players.size();
    }
    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable("id") int id){
        return players.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
