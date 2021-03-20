package com.teamgtlib.Buildings;

public enum RideType implements Buildable{ //TODO megcseréltem a sorrendet a GUI miatt, remélem ez majd nem okoz gondot
    CAROUSEL{
        @Override
        public Building createObj(int x, int y) {
            return new Ride(x,y,RideType.CAROUSEL);
        }
    },
    DODGEM{
        @Override
        public Building createObj(int x, int y) {
            return new Ride(x,y,RideType.DODGEM);
        }
    },
    WATERSLIDE{
        @Override
        public Building createObj(int x, int y) {
            return new Ride(x,y,RideType.WATERSLIDE);
        }
    },
    FERRISWHEEL{
        @Override
        public Building createObj(int x, int y) {
            return new Ride(x,y,RideType.FERRISWHEEL);
        }
    },
    ROLLERCOASTER{
        @Override
        public Building createObj(int x, int y) {
            return new Ride(x,y,RideType.ROLLERCOASTER);
        }
    };


}
