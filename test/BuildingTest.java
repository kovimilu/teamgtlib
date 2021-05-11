import com.teamgtlib.GameException;
import com.teamgtlib.NPCs.Visitor;
import com.teamgtlib.Park;
import com.teamgtlib.Player;
import com.teamgtlib.buildings.*;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class BuildingTest{
    // Ride
    @Test
    public void castleConstructor(){
        Ride castle = new Ride(1,1, RideType.CASTLE);
        assertEquals(castle.getPrice(), 90000);
    }

    @Test
    public void carosuelConstructor(){
        Ride carosuel = new Ride(1,1, RideType.CAROUSEL);
        assertEquals(carosuel.getPrice(), 55000);
    }
    @Test
    public void ferrisWheelConstructor(){
        Ride ferrisWheel = new Ride(3,5, RideType.FERRISWHEEL);
        assertEquals(ferrisWheel.getPrice(), 70000);
    }
    @Test
    public void rollerCoasterConstructor(){
        Ride rollerCoaster = new Ride(1,1, RideType.ROLLERCOASTER);
        assertEquals(rollerCoaster.getPrice(), 200000);
    }
    @Test
    public void waterSlideConstructor(){
        Ride waterSlide = new Ride(1,1, RideType.WATERSLIDE);
        assertEquals(waterSlide.getPrice(), 145000);
    }


    @Test
    public void parkBuild() throws IOException, GameException {
        Park park = new Park();
        Building buildingOriginal = new Shop(1,1);
        Building building = park.build(1,1, BuildingType.SHOP, false);
        assertEquals(building, buildingOriginal);
    }

    @Test
    public void newBuilding() throws IOException, GameException {
        Park park = new Park();
        park.build(1,1, BuildingType.SHOP, false);
        park.build(1,2, BuildingType.BIN, false);
        assertEquals(park.buildings.size(), 34);
    }

    //Decor
    @Test
    public void treeConstructor(){
        Decor tree = new Decor(3,15, DecorType.TREE);
        assertEquals(tree.getPrice(), 3550);
    }

    @Test
    public void benchConstructor(){
        Decor bench = new Decor(4,9, DecorType.BENCH);
        assertEquals(bench.getPrice(), 5000);
    }

    @Test
    public void bushConstructor(){
        Decor bush = new Decor(4,9, DecorType.BUSH);
        assertEquals(bush.getPrice(), 1500);
    }

    @Test
    public void rideStart(){
        Decor bush = new Decor(4,9, DecorType.BUSH);
        assertEquals(bush.getPrice(), 1500);
    }

    //Road + Shop
    @Test
    public void roadConstructor(){
        Road road = new Road(5,15);
        assertEquals(road.getWidth(), 1);
    }

    @Test
    public void shopConstructor(){
        Shop shop = new Shop(6,20);
        assertEquals(shop.getHeight(), 2);
    }


}