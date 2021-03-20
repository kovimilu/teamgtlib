package com.teamgtlib.Buildings;

public enum DecorType implements Buildable {
    BENCH{
        @Override
        public Building createObj(int x, int y) {
            return new Decor(x, y, DecorType.BENCH);
        }
    },
    BUSH{
        @Override
        public Building createObj(int x, int y) {
            return new Decor(x, y, DecorType.BUSH);
        }
    },
    TREE{
        @Override
        public Building createObj(int x, int y) {
            return new Decor(x, y, DecorType.TREE);
        }
    };


}
