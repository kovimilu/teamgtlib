import com.teamgtlib.GameException;
import com.teamgtlib.Park;
import com.teamgtlib.Player;
import com.teamgtlib.buildings.*;
import com.teamgtlib.gui.GameFrame;
import com.teamgtlib.gui.PlayAreaPanel;
import com.teamgtlib.gui.StatusPanel;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class ParkTest{
    //Park
    @Test
    public void parkConstructor() throws IOException {
        Park park = new Park();
        assertEquals(park.buildings.size(), 32);
    }

    @Test
    public void parkBuildingShop() throws IOException, GameException {
        Park park = new Park();
        Building buildingOriginal = new Shop(1,1);
        Building building = park.build(1,1, BuildingType.SHOP, false);
        assertEquals(building, buildingOriginal);
    }

    @Test
    public void parkBuildingBin() throws IOException, GameException {
        Park park = new Park();
        Building buildingOriginal = new Bin(1,1);
        Building building = park.build(1,1, BuildingType.BIN, false);
        assertEquals(building, buildingOriginal);
    }

    @Test
    public void parkBuildingRoad() throws IOException, GameException {
        Park park = new Park();
        Building buildingOriginal = new Road(1,1);
        Building building = park.build(1,1, BuildingType.ROAD, false);
        assertEquals(building, buildingOriginal);
    }

    @Test
    public void buildRideCarousel() throws IOException, GameException {
        Park park = new Park();
        Building buildingOriginal = new Ride(1,1, RideType.CAROUSEL);
        Building building = park.build(1,1, RideType.CAROUSEL, false);
        assertEquals(building, buildingOriginal);
    }

    @Test
    public void buildRideWaterSlide() throws IOException, GameException {
        Park park = new Park();
        Building buildingOriginal = new Ride(1,1, RideType.WATERSLIDE);
        Building building = park.build(1,1, RideType.WATERSLIDE, false);
        assertEquals(building, buildingOriginal);
    }

    @Test
    public void buildRideFerrisWheel() throws IOException, GameException {
        Park park = new Park();
        Building buildingOriginal = new Ride(1,1, RideType.FERRISWHEEL);
        Building building = park.build(1,1, RideType.FERRISWHEEL, false);
        assertEquals(building, buildingOriginal);
    }

    @Test
    public void buildRideCastle() throws IOException, GameException {
        Park park = new Park();
        Building buildingOriginal = new Ride(1,1, RideType.CASTLE);
        Building building = park.build(1,1, RideType.CASTLE, false);
        assertEquals(building, buildingOriginal);
    }

    @Test
    public void buildRideCRollerCoaster() throws IOException, GameException {
        Park park = new Park();
        Building buildingOriginal = new Ride(1,1, RideType.ROLLERCOASTER);
        Building building = park.build(1,1, RideType.ROLLERCOASTER, false);
        assertEquals(building, buildingOriginal);
    }

    @Test
    public void newBuilding() throws IOException, GameException {
        Park park = new Park();
        park.build(1,1, BuildingType.SHOP, false);
        park.build(1,2, BuildingType.BIN, false);
        assertEquals(park.buildings.size(), 34);
    }

    @Test(expected = GameException.class)
    public void testGameException() throws IOException, GameException {
        Park park = new Park();
        park.build(1,1, RideType.ROLLERCOASTER, true);
        park.build(1,1, RideType.ROLLERCOASTER, true);
        park.build(1,1, RideType.ROLLERCOASTER, true);
        park.build(1,1, RideType.ROLLERCOASTER, true);
        park.build(1,1, RideType.ROLLERCOASTER, true);
        park.build(1,1, RideType.ROLLERCOASTER, true);

    }

    public void start() throws IOException {
        GameFrame g = new GameFrame();
        g.bg = new PlayAreaPanel();
        g.GameFrameStatusPanel = new StatusPanel();

    }

    //Player
    @Test
    public void playerConstructor(){
        Player p = new Player();
        assertEquals(p.getBudget(), 1000000);
    }

    @Test
    public void hireMaintenance() throws IOException{
        start();
        Player p = new Player();
        p.hireMaintenance();
        assertEquals(p.getWorkerCount(), 1);
    }

    @Test
    public void hireCleaner() throws IOException {
        start();
        Player p = new Player();
        p.hireCleaner();
        assertEquals(p.getWorkerCount(), 1);
    }

    @Test
    public void fireCleaner() throws IOException {
        start();
        Player p = new Player();
        p.hireCleaner();
        p.fireCleaner();
        assertEquals(p.getWorkerCount(), 1);
    }

    @Test
    public void fireMaintenance() throws IOException {
        start();
        Player p = new Player();
        p.hireMaintenance();
        p.fireMaintenance();
        assertEquals(p.getWorkerCount(), 1);
    }


}