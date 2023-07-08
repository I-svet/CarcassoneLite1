package menu;

import chip.Side;

import java.io.Serializable;

public class InvalidSideEdgeSubmissionException extends Exception implements Serializable {
    private Side.TypeEdge expected;
    private Side.TypeEdge actual;

    public InvalidSideEdgeSubmissionException(String message, Side.TypeEdge actual, Side.TypeEdge expected) {
        this.actual = actual;
        this.expected = expected;
    }

}
