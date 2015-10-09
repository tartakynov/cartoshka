package com.github.tartakynov.cartoshka.exceptions;

import com.github.tartakynov.cartoshka.scanner.Token;
import com.github.tartakynov.cartoshka.tree.Node;

public class CartoshkaException extends RuntimeException {
    public CartoshkaException(String message) {
        super(message);
    }

    public CartoshkaException(String message, Throwable cause) {
        super(message, cause);
    }

    public static ClassCastException incorrectComparison(Node node) {
        return new ClassCastException("Incorrect comparison");
    }

    public static CartoshkaException unexpectedChar(char character, int pos) {
        return new CartoshkaException(String.format("Unexpected character [%c] at position %d", character, pos));
    }

    public static CartoshkaException unexpectedToken(Token token) {
        return new CartoshkaException(String.format("Unexpected token %s at position %d", token.getType().name(), token.getLocation().offset));
    }

    public static CartoshkaException incorrectArgumentType(String func, String arg) {
        return new CartoshkaException(String.format("Incorrect type of argument %s for function %s", arg, func));
    }

    public static CartoshkaException incorrectArgumentCount(String func, int expected, int actual) {
        return new CartoshkaException(String.format("Wrong argument count for \"%s\", expected %d but given %d", func, expected, actual));
    }

    public static CartoshkaException invalidOperation(Node node) {
        return new CartoshkaException("Invalid operation");
    }
}
