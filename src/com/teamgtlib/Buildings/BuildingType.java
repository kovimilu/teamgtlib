package com.teamgtlib.Buildings;

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
    };


}
