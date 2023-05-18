package com.example.demo;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final List<Player> players = new ArrayList<>();
    public PlayerController(){
        players.add(new Player(1,"George Bush",'W'));
        players.add(new Player(2,"George CLinton",'B'));
    }

    // GET
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

    // POST
    @PostMapping
    public int createPlayer(@RequestParam String name, char piece){
        int id = 1 + players.size();
        players.add(new Player(id,name,piece));
        return id;
    }

    @PostMapping(value = "/obj", consumes = "application/json")
    public ResponseEntity<String> createPlayer(@RequestBody Player player){
        players.add(player);
        return new ResponseEntity<>(
                "Player successfully created!", HttpStatus.CREATED
        );
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable int id, @RequestParam String name){
        Player player = findById(id);
        if(player == null){
            return new ResponseEntity<>(
                    "Player not found!",HttpStatus.NOT_FOUND
            );
        }
        player.setName(name);
        return new ResponseEntity<>(
            "Player successfully updated!",HttpStatus.OK
        );
    }

    // DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable int id){
        Player player = findById(id);
        if(player == null){
            return new ResponseEntity<>(
              "Player not found!",HttpStatus.GONE
            );
        }
        players.remove(player);
        return new ResponseEntity<>(
                "Player successfully deleted!",HttpStatus.OK
        );
    }

    private Player findById(int id){
        for(Player player : players){
            if(player.getId() == id){
                return player;
            }
        }
        return null;
    }

}
