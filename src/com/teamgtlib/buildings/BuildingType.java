package com.teamgtlib.buildings;

/**
 * Creates the corresponding Building (shop/road/bin).
 */

public enum BuildingType implements Buildable {
    SHOP{
        @Override
        public Building createObj(int x, int y) {
            return new Shop(x, y);
        }
    },
    ROAD{
        @Override
        public Building createObj(int x, int y) {
            return new Road(x, y);
        }
    },
    BIN{
        @Override
        public Building createObj(int x, int y) {
            return new Bin(x, y);
        }
    };


}
