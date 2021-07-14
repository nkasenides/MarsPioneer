package com.example.marspioneer.client.ui;

import com.example.marspioneer.client.MPClient;
import com.example.marspioneer.generation.MPTerrainGenerator;
import com.example.marspioneer.model.GeoPosition;
import com.example.marspioneer.model.MPTerrainCell;
import com.example.marspioneer.model.MatrixPosition;
import com.example.marspioneer.proto.MPEntityProto;
import com.example.marspioneer.proto.MPTerrainCellProto;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MPCanvas extends Canvas {

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

    private final Image SAND = Toolkit.getDefaultToolkit().getImage("client/res/sand.png");
    private final Image GRAVEL = Toolkit.getDefaultToolkit().getImage("client/res/gravel.png");
    private final Image ICE = Toolkit.getDefaultToolkit().getImage("client/res/ice.png");
    private final Image LAVA = Toolkit.getDefaultToolkit().getImage("client/res/lava.jpg");
    private final Image STONE = Toolkit.getDefaultToolkit().getImage("client/res/stone.jpg");

    private final MPTerrainGenerator terrainGenerator;

    private final int CELL_SIZE = 30;

    private final MPClient client;

    public MPCanvas(MPClient client) {
        this.client = client;
        terrainGenerator = new MPTerrainGenerator(client.getWorld().toObject());
        System.out.println("Gen seed: " + terrainGenerator.getWorld().getSeed());
        setBackground(Color.DARK_GRAY);
        setFocusable(true);
        requestFocus();
    }

    @Override
    public void paint(Graphics g) {
        canvasWidth = getWidth();
        canvasHeight = getHeight();

        int minRow = client.getCameraPosition().getRow() - (canvasHeight / 2 / CELL_SIZE) - 1;
        int maxRow = client.getCameraPosition().getRow() + (canvasHeight / 2 / CELL_SIZE) + 1;
        int minCol = client.getCameraPosition().getCol() - (canvasWidth / 2 / CELL_SIZE) - 1;
        int maxCol = client.getCameraPosition().getCol() + (canvasWidth / 2 / CELL_SIZE) + 1;

        HashMap<String, MPTerrainCellProto> cells = new HashMap<>();

        for (int row = minRow; row <= maxRow; row++) {
            for (int col = minCol; col <= maxCol; col++) {
                final MPTerrainCell cell = terrainGenerator.acquireCell(row, col);
                String cellHash = cell.getPosition().toHash();
                cells.put(cellHash, cell.toProto().build());
            }
        }
        client.setGeneratedCells(cells);
        //----

        printUnloadedCells(g);
        printLoadedCells(g);
        printEntities(g);
        printViewportData(g);
    }

    private void printUnloadedCells(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        for (Map.Entry<String, MPTerrainCellProto> entry : client.getGeneratedCells().entrySet()) {

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

            final int positionX = (canvasWidth / 2 - client.getCameraPosition().getCol() * CELL_SIZE + cell.getPosition().getCol() * CELL_SIZE) - CELL_SIZE / 2;
            final int positionY = (canvasHeight / 2 - client.getCameraPosition().getRow() * CELL_SIZE + cell.getPosition().getRow() * CELL_SIZE) - CELL_SIZE / 2;

            if (image != null) {
                g.drawImage(image, positionX, positionY, CELL_SIZE, CELL_SIZE, MPCanvas.this);
            }

            Color fogOfWarColor = new Color(0, 0, 0, 191);
            g.setColor(fogOfWarColor);
            g.drawRect(0, 0, canvasWidth, canvasHeight);

//            MatrixPosition paintPosition = new MatrixPosition(positionY, positionX);
//            g.setColor(color);
//            g.fillRect(paintPosition.getCol(), paintPosition.getRow(), CELL_SIZE, CELL_SIZE);

            if (cell.getPosition().getRow() == client.getSelectedCellPosition().getRow() && cell.getPosition().getCol() == client.getSelectedCellPosition().getCol()) {
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawRect(positionX, positionY, CELL_SIZE, CELL_SIZE);
            }

        }
    }

    private void printLoadedCells(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        for (Map.Entry<String, MPTerrainCellProto> entry : client.getStateCells().entrySet()) {

            final MPTerrainCellProto cell = entry.getValue();

            Color color = null;

            switch (cell.getType()) {
                case SAND_CellType:
                    color = Color.YELLOW;
                    break;
                case ROCK_CellType:
                    color = Color.DARK_GRAY;
                    break;
                case LAVA_CellType:
                    color = Color.RED;
                    break;
                case ICE_CellType:
                    color = Color.WHITE;
                    break;
                case GRAVEL_CellType:
                    color = Color.LIGHT_GRAY;
                    break;
                case UNRECOGNIZED:
                    break;
            }

            final int positionX = (canvasWidth / 2 - client.getCameraPosition().getCol() * CELL_SIZE + cell.getPosition().getCol() * CELL_SIZE) - CELL_SIZE / 2;
            final int positionY = (canvasHeight / 2 - client.getCameraPosition().getRow() * CELL_SIZE + cell.getPosition().getRow() * CELL_SIZE) - CELL_SIZE / 2;

            MatrixPosition paintPosition = new MatrixPosition(positionY, positionX);
            g.setColor(color);
            g.fillRect(paintPosition.getCol(), paintPosition.getRow(), CELL_SIZE, CELL_SIZE);

            if (cell.getPosition().getRow() == client.getSelectedCellPosition().getRow() && cell.getPosition().getCol() == client.getSelectedCellPosition().getCol()) {
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawRect(positionX, positionY, CELL_SIZE, CELL_SIZE);
            }

        }
    }

    private void printEntities(Graphics g) {

        for (Map.Entry<String, MPEntityProto> entry : client.getEntities().entrySet()) {

            final int positionX = (canvasWidth / 2 - client.getCameraPosition().getCol() * CELL_SIZE + entry.getValue().getPosition().getCol() * CELL_SIZE) - CELL_SIZE / 2;
            final int positionY = (canvasHeight / 2 - client.getCameraPosition().getRow() * CELL_SIZE + entry.getValue().getPosition().getRow() * CELL_SIZE) - CELL_SIZE / 2;

            Image image = null;
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

            if (image != null) {
                g.drawImage(image, positionX, positionY, CELL_SIZE, CELL_SIZE, MPCanvas.this);
            }

        }
    }

    public void printViewportData(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("Cell: (" + client.getSelectedCellPosition().getRow() + ", " + client.getSelectedCellPosition().getCol() + ")", 10, 25);
        g.drawString("Camera: (" + client.getCameraPosition().getRow() + ", " + client.getCameraPosition().getCol() + ")", 10, 50);
    }

    public static Color blend(Color c1, Color c2, float ratio) {
        if (ratio > 1f) ratio = 1f;
        else if (ratio < 0f) ratio = 0f;
        float iRatio = 1.0f - ratio;

        int i1 = c1.getRGB();
        int i2 = c2.getRGB();

        int a1 = (i1 >> 24 & 0xff);
        int r1 = ((i1 & 0xff0000) >> 16);
        int g1 = ((i1 & 0xff00) >> 8);
        int b1 = (i1 & 0xff);

        int a2 = (i2 >> 24 & 0xff);
        int r2 = ((i2 & 0xff0000) >> 16);
        int g2 = ((i2 & 0xff00) >> 8);
        int b2 = (i2 & 0xff);

        int a = (int) ((a1 * iRatio) + (a2 * ratio));
        int r = (int) ((r1 * iRatio) + (r2 * ratio));
        int g = (int) ((g1 * iRatio) + (g2 * ratio));
        int b = (int) ((b1 * iRatio) + (b2 * ratio));

        return new Color(a << 24 | r << 16 | g << 8 | b);
    }


}
