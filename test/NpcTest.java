import com.teamgtlib.GameException;
import com.teamgtlib.Main;
import com.teamgtlib.NPCs.Maintenance;
import com.teamgtlib.NPCs.Visitor;
import com.teamgtlib.Park;
import com.teamgtlib.Player;
import com.teamgtlib.buildings.*;
import com.teamgtlib.gui.GameFrame;
import com.teamgtlib.gui.PlayAreaPanel;
import com.teamgtlib.gui.StatusPanel;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class NpcTest {
    @Test
    public void getRidesTest() throws IOException {
        GameFrame g = new GameFrame();
        g.bg = new PlayAreaPanel();
        g.GameFrameStatusPanel = new StatusPanel();
        Visitor v = new Visitor();

    }
}