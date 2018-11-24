package com.github.andrewapj;

import com.github.andrewapj.field.FieldState;
import java.util.Objects;

class Player {

    private final FieldState state;
    private final String name;

    Player(FieldState state, String name) {
        this.state = state;
        this.name = name;
    }

    FieldState getState() {
        return state;
    }

    String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Player)) {
            return false;
        }
        Player player = (Player) o;
        return state == player.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }
}
