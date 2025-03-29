package outils;

import java.util.Objects;

public class Hash {
    public static int h(Object elements) {
        return Objects.hash(elements);
    }
}