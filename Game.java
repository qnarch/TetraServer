package com.company;

import java.util.ArrayList;

interface PowerUp {
    /** TODO: What methods should a PowerUp contain? */
}

interface Observer {
    void Update();
}

class Observable {
    private ArrayList<Observer> observers;

    public Observable() {
        observers = new ArrayList<Observer>();
    }

    void Attach(Observer o) {
        observers.add(o);
    }
    void Detach(Observer o) {
        observers.remove(o);
    }

    void Notify() {
        for (Observer o : observers) {
            o.Update();
        }
    }
}

class GameBoard {
    /** TODO: Find a way to store the board. */

}

class Player extends Observable implements Observer {
    private GameBoard gameBoard;
    private Game game;
    private ArrayList<PowerUp> powerUps;

    public Player(Game g) {
        game = g;

        // Add all players of the game as observers
        for (Player p : g.getPlayers()) {
            this.Attach(p);
        }

        gameBoard = new GameBoard();
        powerUps = new ArrayList<PowerUp>();
    }

    /** Get/Set */

    public void addPowerUp(PowerUp p) {
        powerUps.add(p);
    }

    public ArrayList<PowerUp> getPowerUps() {
        return powerUps;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Game getGame() {
        return game;
    }

    /** Methods */

    public void Update() {
        /** TODO: Get input from the client and update the gameboard. */
    }
}

public class Game extends Observable {
    private ArrayList<Player> players;

    public void Update() {
        for (Player p : players) {
            // Update state and notify others
            p.Update();
            p.Notify();
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
