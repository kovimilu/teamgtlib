import com.teamgtlib.GameException;
import com.teamgtlib.Park;
import com.teamgtlib.buildings.*;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GameTests {
    @Test
    public void parkBuild() throws IOException, GameException {
        Park park = new Park();
        Building buildingOriginal = new Shop(1,1);
        Building building = park.build(1,1, BuildingType.SHOP, false);
        assertEquals(building, buildingOriginal);
    }
}

