package com.teamgtlib.NPCs;

import com.teamgtlib.Park;
import com.teamgtlib.buildings.Building;
import com.teamgtlib.buildings.Road;
import com.teamgtlib.gui.GameFrame;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;

public abstract class NPC {
    int x, y;
    static public ArrayList<Point> gridMap2 = new ArrayList<>();

    public ArrayList pathFinding(Building obj, Building[][] playAreaPanel, ArrayList<Point> path, int x, int y ) {
        searchPath(obj, playAreaPanel, path, x, y);
        for (int i = 0; i<Park.buildings.size(); i++){
            if(Park.buildings.get(i) instanceof Road){
                ((Road) Park.buildings.get(i)).setVisited(false);
            }
        }

        //for debug
        /*if(path.size() > 0){
            for (int i = path.size()-1; i >= 0; i--)
            {
                System.out.println("test: " + path.get(i));
            }
        }else{
            System.out.println("nincs path");
        }*/

        Collections.reverse(path);

        return path;


    }

    public static boolean searchPath(Building obj, Building[][] playAreaPanel, ArrayList<Point> path, int x, int y){
        if(playAreaPanel[y][x] == playAreaPanel[obj.getY()/50][obj.getX()/50]){
            path.add(new Point(x,y));
            return true;
        }

        if(playAreaPanel[y][x] instanceof Road){
            if (((Road) playAreaPanel[y][x]).getVisited() == false){
                ((Road) playAreaPanel[y][x]).setVisited(true);

                    int dx = -1;
                    int dy = 0;
                    if(x+dx >= 0 && x+dx <= 20){
                        if(searchPath(obj,playAreaPanel,path,x+dx, y+dy)){
                            path.add(new Point(x,y));
                            return true;
                        }
                    }


                    dx = 1;
                    dy = 0;
                    if(dx + x > 0 && dx + x <= 20)
                    if(searchPath(obj,playAreaPanel,path,x+dx, y+dy)){
                        path.add(new Point(x,y));
                        return true;
                    }

                    dx = 0;
                    dy = -1;
                    if(y+dy > 0 && y+dy <= 14){
                        if(searchPath(obj,playAreaPanel,path,x+dx, y+dy)){
                            path.add(new Point(x,y));
                            return true;
                        }
                    }


                    dx = 0;
                    dy = 1;
                    if(y+dy > 0 && dy + y <= 14){
                        if(searchPath(obj,playAreaPanel,path,x+dx, y+dy)){
                            path.add(new Point(x,y));
                            return true;
                        }
                    }

            }
        }

        return false;
    }



    public abstract void whatToDo();

    public void changeParkBudgetBy(int price) { Park.player.changeBudgetBy(price); }

    public void timer(ArrayList<Point> testpath) {
        Timer t = new java.util.Timer();
        t.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                move(testpath);
                GameFrame.bg.repaint();
                t.cancel(); }
        }, 500);
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void move(ArrayList<Point> testpath) {
        for (Point p : testpath) {
            GameFrame.bg.repaint();
            wait(500);
            setX((int)p.getX()+1);
            setY((int)p.getY()+1);

        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

     public abstract String getClassString();

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
