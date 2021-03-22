package com.teamgtlib.Buildings;

public enum RideType implements Buildable{
    CAROUSEL{
        @Override
        public Building createObj(int x, int y) {
            return new Ride(x,y,RideType.CAROUSEL);
        }
    },
    CASTLE{
        @Override
        public Building createObj(int x, int y) {
            return new Ride(x,y,RideType.CASTLE);
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
    }


}
