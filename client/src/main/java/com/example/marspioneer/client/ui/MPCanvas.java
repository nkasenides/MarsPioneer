package com.example.marspioneer.client.ui;

import com.example.marspioneer.client.MPClient;
import com.example.marspioneer.generation.MPTerrainGenerator;
import com.example.marspioneer.model.MPTerrainCell;
import com.example.marspioneer.model.MatrixPosition;
import com.example.marspioneer.proto.MPEntityProto;
import com.example.marspioneer.proto.MPTerrainCellProto;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    private final Image UI_RED = Toolkit.getDefaultToolkit().getImage("client/res/ui-red.png");
    private final Image UI_GREEN = Toolkit.getDefaultToolkit().getImage("client/res/ui-green.png");
    private final Image UI_BLUE = Toolkit.getDefaultToolkit().getImage("client/res/ui-blue.png");

    private final MPTerrainGenerator terrainGenerator;

    private final int DEFAULT_CELL_SIZE = 30;
    private final int MIN_CELL_SIZE = 10;
    private final int MAX_CELL_SIZE = 50;
    private final int CELL_SIZE_CHANGE = 5;
    private int cellSize = DEFAULT_CELL_SIZE;

    String message = "";

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

        int minRow = client.getCameraPosition().getRow() - (canvasHeight / 2 / cellSize) - 1;
        int maxRow = client.getCameraPosition().getRow() + (canvasHeight / 2 / cellSize) + 1;
        int minCol = client.getCameraPosition().getCol() - (canvasWidth / 2 / cellSize) - 1;
        int maxCol = client.getCameraPosition().getCol() + (canvasWidth / 2 / cellSize) + 1;

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
        printUI(g);
        printViewportData(g);

        addMouseListener(new MouseAdapter() {


            @Override
            public void mouseReleased(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                int col = (int) Math.floor((x * (canvasWidth / cellSize)) / canvasWidth - (canvasWidth / cellSize / 2) + client.getCameraPosition().getCol());
                int row = (int) Math.floor((y * (canvasHeight / cellSize)) / canvasHeight - (canvasHeight / cellSize / 2) + client.getCameraPosition().getRow());

                client.getSelectedCellPosition().setRow(row);
                client.getSelectedCellPosition().setCol(col);
                repaint();
            }
        });

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

            final int positionX = (canvasWidth / 2 - client.getCameraPosition().getCol() * cellSize + cell.getPosition().getCol() * cellSize) - cellSize / 2;
            final int positionY = (canvasHeight / 2 - client.getCameraPosition().getRow() * cellSize + cell.getPosition().getRow() * cellSize) - cellSize / 2;

            if (image != null) {
                g.drawImage(image, positionX, positionY, cellSize, cellSize, MPCanvas.this);
            }

        }

        Color fogOfWarColor = new Color(0, 0, 0, 150);
        g2d.setColor(fogOfWarColor);
        g2d.fillRect(0, 0, canvasWidth, canvasHeight);

    }

    private void printLoadedCells(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        for (Map.Entry<String, MPTerrainCellProto> entry : client.getStateCells().entrySet()) {

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

            final int positionX = (canvasWidth / 2 - client.getCameraPosition().getCol() * cellSize + cell.getPosition().getCol() * cellSize) - cellSize / 2;
            final int positionY = (canvasHeight / 2 - client.getCameraPosition().getRow() * cellSize + cell.getPosition().getRow() * cellSize) - cellSize / 2;

            if (image != null) {
                g.drawImage(image, positionX, positionY, cellSize, cellSize, MPCanvas.this);
            }
        }

    }

    private void printEntities(Graphics g) {

        for (Map.Entry<String, MPEntityProto> entry : client.getEntities().entrySet()) {

            final int positionX = (canvasWidth / 2 - client.getCameraPosition().getCol() * cellSize + entry.getValue().getPosition().getCol() * cellSize) - cellSize / 2;
            final int positionY = (canvasHeight / 2 - client.getCameraPosition().getRow() * cellSize + entry.getValue().getPosition().getRow() * cellSize) - cellSize / 2;

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
                g.drawImage(image, positionX, positionY, cellSize, cellSize, MPCanvas.this);
            }

        }
    }

    public void printUI(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        final int posSelectX = (canvasWidth / 2 - client.getCameraPosition().getCol() * cellSize + client.getSelectedCellPosition().getCol() * cellSize) - cellSize / 2;
        final int posSelectY = (canvasHeight / 2 - client.getCameraPosition().getRow() * cellSize + client.getSelectedCellPosition().getRow() * cellSize) - cellSize / 2;
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRect(posSelectX, posSelectY, cellSize, cellSize);

        g2d.drawString("Food: " + client.getPlayerResourceSet().getFood(), 10, 100);
        g2d.drawString("Sand: " + client.getPlayerResourceSet().getSand(), 10, 125);
        g2d.drawString("Water: " + client.getPlayerResourceSet().getWater(), 10, 150);
        g2d.drawString("Metal: " + client.getPlayerResourceSet().getMetal(), 10, 175);

        g2d.drawString(message, canvasWidth / 2 - 100, canvasHeight / 2 + 200);

//        Image uiImage;
//        switch (client)
//        uiImage = UI_RED;
//        g.drawImage(uiImage, 0, 0, canvasWidth, canvasHeight, null);
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

    public void increaseCellSize() {
        if (cellSize + CELL_SIZE_CHANGE <= MAX_CELL_SIZE) {
            cellSize += CELL_SIZE_CHANGE;
        }
    }

    public void decreaseCellSize() {
        if (cellSize - CELL_SIZE_CHANGE >= MIN_CELL_SIZE) {
            cellSize -= CELL_SIZE_CHANGE;
        }
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
            MPCanvas.this.message = "";
        }).start();
    }

}
