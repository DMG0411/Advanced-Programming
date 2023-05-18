package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/games")
public class GameController {
    private final List<Game> games = new ArrayList<>();

    public GameController() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        games.add(new Game(1, formatter.format(date), 5));
        games.add(new Game(2, formatter.format(date), 7));
    }

    // GET
    @GetMapping
    public List<Game> getGames() {
        return games;
    }

    @GetMapping("/count")
    public int countGames() {
        return games.size();
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable("id") int id) {
        return findById(id);
    }

    // POST
    @PostMapping
    public int createGame() {
        int id = 1 + games.size();
        // Get system date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        // Random minutes between 1 and 30
        Random random = new Random();
        int timePlayed = random.nextInt(30);

        games.add(new Game(id, formatter.format(date), timePlayed));
        return id;
    }

    private Game findById(int id) {
        for (Game game : games) {
            if (game.getId() == id) {
                return game;
            }
        }
        return null;
    }
}
