package com.example.marspioneer.client.simulation;

import com.example.marspioneer.client.MPClient;
import com.example.marspioneer.generation.MPTerrainGenerator;
import com.example.marspioneer.model.MPTerrainCell;
import com.example.marspioneer.proto.MPEntityProto;
import com.example.marspioneer.proto.MPTerrainCellProto;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class BotCanvas extends Canvas {

    private int canvasWidth;
    private int canvasHeight;

    private final Image RED_PLAYER = Toolkit.getDefaultToolkit().getImage("client/res/mark_red.png");
    private final Image GREEN_PLAYER = Toolkit.getDefaultToolkit().getImage("client/res/mark_green.png");
    private final Image BLUE_PLAYER = Toolkit.getDefaultToolkit().getImage("client/res/mark_blue.png");
    private final Image FARM = Toolkit.getDefaultToolkit().getImage("client/res/farm.fw.png");
    private final Image HUB = Toolkit.getDefaultToolkit().getImage("client/res/hub.fw.png");
    private final Image MINE = Toolkit.getDefaultToolkit().getImage("client/res/mine.fw.png");
    private final Image SANDPIT = Toolkit.getDefaultToolkit().getImage("client/res/sandpit.fw.png");
    private final Image WELL = Toolkit.getDefaultToolkit().getImage("client/res/well.fw.png");
    private final Image TAKEN_MARKER = Toolkit.getDefaultToolkit().getImage("client/res/x.png");

    private final Image SAND = Toolkit.getDefaultToolkit().getImage("client/res/sand.png");
    private final Image GRAVEL = Toolkit.getDefaultToolkit().getImage("client/res/gravel.png");
    private final Image ICE = Toolkit.getDefaultToolkit().getImage("client/res/ice.png");
    private final Image LAVA = Toolkit.getDefaultToolkit().getImage("client/res/lava.jpg");
    private final Image STONE = Toolkit.getDefaultToolkit().getImage("client/res/stone.jpg");

    private final Image UI_RED = Toolkit.getDefaultToolkit().getImage("client/res/ui-red.png");
    private final Image UI_GREEN = Toolkit.getDefaultToolkit().getImage("client/res/ui-green.png");
    private final Image UI_BLUE = Toolkit.getDefaultToolkit().getImage("client/res/ui-blue.png");


    private final int DEFAULT_CELL_SIZE = 40;
    private final int MIN_CELL_SIZE = 10;
    private final int MAX_CELL_SIZE = 50;
    private final int CELL_SIZE_CHANGE = 5;
    private int cellSize = DEFAULT_CELL_SIZE;

    String message = "";

    private final Bot bot;

    public BotCanvas(Bot bot) {
        this.bot = bot;
        setBackground(Color.DARK_GRAY);
        setFocusable(true);
        requestFocus();
    }

    @Override
    public void paint(Graphics g) {
        canvasWidth = getWidth();
        canvasHeight = getHeight();
        printLoadedCells(g);
        printEntities(g);
        printUI(g);
    }

    private void printLoadedCells(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        for (Map.Entry<String, MPTerrainCellProto> entry : bot.getTerrain().entrySet()) {

            final MPTerrainCellProto cell = entry.getValue();
            Image image = null;
            switch (entry.getValue().getType()) {
                case SAND_CellType:
                    image = SAND;
                    break;
                case ROCK_CellType:
                    image = STONE;
                    break;
                case LAVA_CellType:
                    image = LAVA;
                    break;
                case ICE_CellType:
                    image = ICE;
                    break;
                case GRAVEL_CellType:
                    image = GRAVEL;
                    break;
                case UNRECOGNIZED:
                    break;
            }

            final int positionX = (canvasWidth / 2 - bot.getWorldSession().getCameraPosition().getCol() * cellSize + cell.getPosition().getCol() * cellSize) - cellSize / 2;
            final int positionY = (canvasHeight / 2 - bot.getWorldSession().getCameraPosition().getRow() * cellSize + cell.getPosition().getRow() * cellSize) - cellSize / 2;

            if (image != null) {
                g.drawImage(image, positionX, positionY, cellSize, cellSize, BotCanvas.this);
            }
        }

    }

    private void printEntities(Graphics g) {

        for (Map.Entry<String, MPEntityProto> entry : bot.getEntities().entrySet()) {

            final int positionX = (canvasWidth / 2 - bot.getWorldSession().getCameraPosition().getCol() * cellSize + entry.getValue().getPosition().getCol() * cellSize) - cellSize / 2;
            final int positionY = (canvasHeight / 2 - bot.getWorldSession().getCameraPosition().getRow() * cellSize + entry.getValue().getPosition().getRow() * cellSize) - cellSize / 2;

            Image image = null;

            if (!entry.getValue().getPlayerID().equals(bot.getPlayer().getId())) {
                image = TAKEN_MARKER;
            }
            else {
                switch (entry.getValue().getBuildingEntity().getBuildingType()) {
                    case HUB_EBuildingType:
                        image = HUB;
                        break;
                    case FARM_EBuildingType:
                        image = FARM;
                        break;
                    case WELL_EBuildingType:
                        image = WELL;
                        break;
                    case MINE_EBuildingType:
                        image = MINE;
                        break;
                    case SAND_PIT_EBuildingType:
                        image = SANDPIT;
                        break;
                    case UNRECOGNIZED:
                        break;
                }
            }

            if (image != null) {
                g.drawImage(image, positionX, positionY, cellSize, cellSize, BotCanvas.this);
            }

        }
    }

    public void printUI(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        Color previousColor = g2d.getColor();
        g2d.setColor(new Color(255, 255, 255, 170));

        g2d.drawString("Food: " + bot.getResourceSet().getFood(), 10, 100);
        g2d.drawString("Sand: " + bot.getResourceSet().getSand(), 10, 125);
        g2d.drawString("Water: " + bot.getResourceSet().getWater(), 10, 150);
        g2d.drawString("Metal: " + bot.getResourceSet().getMetal(), 10, 175);

        g2d.drawString(message, canvasWidth / 2 - 100, canvasHeight / 2 + 200);
        g2d.setColor(previousColor);
    }

    public void showMessage(String message) {
        this.message = message;
        repaint();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BotCanvas.this.message = "";
        }).start();
    }

}
