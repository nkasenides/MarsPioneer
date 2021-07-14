package com.example.marspioneer.client.ui;

import com.example.marspioneer.client.MPClient;
import com.example.marspioneer.client.stubs.Stubs;
import com.example.marspioneer.proto.BuildFarmRequest;
import com.example.marspioneer.proto.GetStateRequest;
import com.example.marspioneer.proto.GetStateResponse;
import com.neovisionaries.ws.client.WebSocketException;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.HashMap;

public class MPGameForm extends JFrame {

    private MPCanvas gameCanvas;
    private MPClient client;

    public MPGameForm(MPClient client, MPCanvas canvas) {
        this.client = client;
        JFrame frame = new JFrame("Mars Pioneer");
        frame.setSize(1024, 768);
        frame.setLocationRelativeTo(null);
        this.gameCanvas = canvas;
        frame.add(gameCanvas);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        addWindowStateListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Stubs.getUpdateStateStub(client).stop();
                    Stubs.Actions.getBuildFarmStub(client).stop();
                    Stubs.Actions.getBuildHubStub(client).stop();
                    Stubs.Actions.getBuildMineStub(client).stop();
                    Stubs.Actions.getBuildSandPitStub(client).stop();
                    Stubs.Actions.getBuildWellStub(client).stop();
                    Stubs.Actions.getSellBuildingStub(client).stop();
                } catch (WebSocketException | IOException webSocketException) {
                    webSocketException.printStackTrace();
                }
                client.stop();
            }
        });

        gameCanvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                //Camera panning:
                if (e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
                    client.getCameraPosition().setRow(client.getCameraPosition().getRow() - 1);
                }
                else if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
                    client.getCameraPosition().setRow(client.getCameraPosition().getRow() + 1);
                }
                if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
                    client.getCameraPosition().setCol(client.getCameraPosition().getCol() - 1);
                }
                else if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
                    client.getCameraPosition().setCol(client.getCameraPosition().getCol() + 1);
                }

                //Selected cell movement:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    client.getSelectedCellPosition().setRow(client.getSelectedCellPosition().getRow() - 1);
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    client.getSelectedCellPosition().setRow(client.getSelectedCellPosition().getRow() + 1);
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    client.getSelectedCellPosition().setCol(client.getSelectedCellPosition().getCol() - 1);
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    client.getSelectedCellPosition().setCol(client.getSelectedCellPosition().getCol() + 1);
                }

                if (e.getKeyCode() == KeyEvent.VK_F5) {
                    Stubs.getStateStub().sendAndWait(GetStateRequest.newBuilder()
                                    .setWorldSessionID(client.getWorldSessionID())
                                    .build(),
                            getStateResponse -> {
                                if (getStateResponse.getStatus() == GetStateResponse.Status.OK) {
                                    client.setStateCells(new HashMap<>(getStateResponse.getPartialState().getCellsMap()));
                                    client.setEntities(new HashMap<>(getStateResponse.getPartialState().getEntitiesMap()));
                                    gameCanvas.repaint();
                                    System.out.println("State retrieved");
                                }
                                else {
                                    System.err.println(getStateResponse.getMessage());
                                }
                            }
                    );
                }

                if (e.getKeyCode() == KeyEvent.VK_F) {
                    BuildFarmRequest request = BuildFarmRequest.newBuilder()
                            .setPosition(client.getSelectedCellPosition().toProto())
                            .setWorldSessionID(client.getWorldSessionID())
                            .build();
                    try {
                        Stubs.Actions.getBuildFarmStub(client).send(request.toByteArray());
                    } catch (WebSocketException | IOException webSocketException) {
                        webSocketException.printStackTrace();
                    }
                }

                gameCanvas.repaint();

            }
        });

    }
}
