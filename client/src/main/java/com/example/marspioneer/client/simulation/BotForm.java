//package com.example.marspioneer.client.simulation;
//
//import com.example.marspioneer.client.stubs.Stubs;
//import com.example.marspioneer.client.ui.MPCanvas;
//import com.neovisionaries.ws.client.WebSocketException;
//
//import javax.swing.*;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.io.IOException;
//
//public class BotForm extends JFrame {
//
//    private BotCanvas canvas;
//    private Bot bot;
//
//    public BotForm(Bot bot, BotCanvas canvas) {
//        this.bot = bot;
//        JFrame frame = new JFrame(bot.getBotName());
//        frame.setSize(1024, 768);
//        frame.setLocationRelativeTo(null);
//        this.canvas = canvas;
//        frame.add(this.canvas);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//
//        addWindowStateListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                try {
//                    Stubs.getBotUpdateStateStub(bot).stop();
//                    Stubs.Actions.getBotBuildFarmStub(bot).stop();
//                    Stubs.Actions.getBotBuildHubStub(bot).stop();
//                    Stubs.Actions.getBotBuildMineStub(bot).stop();
//                    Stubs.Actions.getBotBuildSandPitStub(bot).stop();
//                    Stubs.Actions.getBotBuildWellStub(bot).stop();
//                    Stubs.Actions.getBotSellBuildingStub(bot).stop();
//                } catch (WebSocketException | IOException webSocketException) {
//                    webSocketException.printStackTrace();
//                }
//            }
//        });
//
//    }
//}
