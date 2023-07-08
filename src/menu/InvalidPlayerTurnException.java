package menu;

import chip.Side;

import java.io.Serializable;

public class InvalidPlayerTurnException extends Exception implements Serializable {
    String playerId;
    public InvalidPlayerTurnException(String message, String pid) {
        super(message);
        playerId = pid;
    }
    public String getPid(){
        return playerId;
    }
}
