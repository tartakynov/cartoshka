package com.github.tartakynov.cartoshka.tree.entities.literals;

import com.github.tartakynov.cartoshka.Location;
import com.github.tartakynov.cartoshka.scanner.TokenType;
import com.github.tartakynov.cartoshka.tree.entities.Literal;

public class Text extends Literal {
    private final String value;

    private final boolean isURL;

    private final boolean isKeyword;

    public Text(Location location, String value, boolean isURL, boolean isKeyword) {
        this.value = value;
        this.isURL = isURL;
        this.isKeyword = isKeyword;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean isText() {
        return true;
    }

    @Override
    public Literal operate(TokenType operator, Literal operand) {
        if (operator == TokenType.ADD && (operand.isNumeric() || operand.isText() || operand.isURL())) {
            return new Text(Location.combine(getLocation(), operand.getLocation()), this.toString() + operand.toString(), isURL, false);
        }

        return super.operate(operator, operand);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean isURL() {
        return isURL;
    }

    @Override
    public boolean isKeyword() {
        return isKeyword;
    }

    @Override
    public int compareTo(Literal o) {
        return value.compareTo(o.toString());
    }
}