package com.teamgtlib;

import java.io.IOException;

public interface Drawable {
    /**
     * Determens the type of the Class then reads in the corresponding image.
     */
    void loadClassImage() throws IOException;
}
