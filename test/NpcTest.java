import com.teamgtlib.NPCs.Cleaner;
import com.teamgtlib.NPCs.Maintenance;
import com.teamgtlib.NPCs.Visitor;
import com.teamgtlib.NPCs.Worker;
import com.teamgtlib.Park;
import com.teamgtlib.buildings.*;
import com.teamgtlib.gui.GameFrame;
import com.teamgtlib.gui.PlayAreaPanel;
import com.teamgtlib.gui.StatusPanel;
import com.teamgtlib.pathfinding.Point_;
import org.junit.Test;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static org.junit.Assert.*;

public class NpcTest {

    //NPC
    public void start() throws IOException {
        GameFrame g = new GameFrame();
        g.bg = new PlayAreaPanel();
        g.GameFrameStatusPanel = new StatusPanel();

    }

    @Test
    public void getRidesTest() throws IOException {
        start();
        Visitor v = new Visitor();
        ArrayList<Ride> rides = v.getRides();
        Ride ride = new Ride(11,5,RideType.CASTLE);
        assertEquals(ride,rides.get(0));
    }

    @Test
    public void getBinsTest() throws IOException {
        start();
        Visitor v = new Visitor();
        ArrayList<Bin> bins = v.getBins();
        Bin bin = new Bin(5,9);
        assertEquals(bin,bins.get(0));
    }

    @Test
    public void getShopsTest() throws IOException {
        start();
        Visitor v = new Visitor();
        ArrayList<Shop> shops = v.getShops();
        Shop shop = new Shop(8,10);
        assertEquals(shop,shops.get(0));
    }

    @Test
    public void getAdjacentRoadsTest() throws IOException {
        start();
        Visitor v = new Visitor();
        Point p = new Point(10,5);
        Point p2 = v.getAdjacentRoads(Park.buildings.get(26));
        System.out.println(p2);
        assertEquals(p,p2);
    }

    @Test
    public void pathFindingTest() throws IOException {
        start();
        Visitor v = new Visitor();
        List<Point_> path =  v.pathfinding(v.getX(),v.getY(), Park.buildings.get(26).getX(),Park.buildings.get(26).getX());
        assertEquals(path.size(),3);
    }

    //Workers
    @Test
    public void maintenancePay() throws IOException {
        start();
        Maintenance m = new Maintenance();
        m.pay(100);
        assertEquals(Park.player.getBudget(), 999900);
    }


    @Test
    public void maintenanceRepair() throws IOException {
        start();
        Maintenance m = new Maintenance();
        Ride r = new Ride(10,10, RideType.CASTLE);
        r.repairedDurability(-50);
        m.repair(r);
        assertEquals(r.getDurability(), 100);
    }


    //Visitor
    @Test
    public void visitorWhatToDo() throws IOException {
        start();
        Visitor v = new Visitor();
        v.updateMood(-40);
        v.whatToDo();
        assertEquals(v.getMood(), 10);
    }

    @Test
    public void visitorThrowGarbage() throws IOException {
        start();
        Visitor v = new Visitor();
        v.throwGarbage();
        assertEquals(Park.garbage.size(), 0);
    }

}