package main;

import frames.DeckPanel;
import frames.MiplePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame {


    public static void main(String[] args) {

         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArrayList<String> playerIds=new ArrayList<>();
                playerIds.add("Ivan");
                playerIds.add("Vasya");
                new Main(playerIds).setVisible(true);

            }
        });
    }
    public Main(ArrayList<String> playerIds){


      //  this.playerIds=playerIds;
        jLabel1=new JLabel();
        jLabel2 = new JLabel();


        gamePanel = new GamePanel(playerIds, jLabel1, jLabel2 );
         deckPanel = new DeckPanel(gamePanel);
        miplePanel = new MiplePanel(gamePanel);
        AssetSetter aSetter = new AssetSetter(gamePanel);
       // miplePanel.setVisible(true);
        initComponents();


    gamePanel.setupGame(gamePanel,aSetter);

    gamePanel.startGameThread();
    deckPanel.startGameThread();
    miplePanel.startGameThread();

    }
    @SuppressWarnings("unchecked")

    private void initComponents() {

miplePanel.setBackground(Color.BLACK);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        gamePanel.setMaximumSize(new java.awt.Dimension(856, 648));
        gamePanel.setMinimumSize(new java.awt.Dimension(856, 648));
        gamePanel.setPreferredSize(new java.awt.Dimension(856, 648));
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, gamePanel.screenWidth, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, gamePanel.screenHeight, Short.MAX_VALUE)
        );
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setFont(new java.awt.Font("PMingLiU-ExtB", 2, 18)); // NOI18N
       // jLabel1.setText("smthturn");
        jLabel1.setToolTipText("");
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setFont(new java.awt.Font("PMingLiU-ExtB", 2, 18)); // NOI18N
        //jLabel2.setText("jLabel2");
        jLabel2.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(deckPanel);
        deckPanel.setLayout(jPanel2Layout);
        deckPanel.setPreferredSize(new java.awt.Dimension(216, 216));
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, gamePanel.originalTileSize, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, gamePanel.originalTileSize, Short.MAX_VALUE)
        );
        javax.swing.GroupLayout miplePanelLayout = new javax.swing.GroupLayout(miplePanel);
        miplePanel.setLayout(miplePanelLayout);
        miplePanelLayout.setHorizontalGroup(
                miplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, gamePanel.mipleSize*4, Short.MAX_VALUE)
        );
        miplePanelLayout.setVerticalGroup(
                miplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, gamePanel.mipleSize*2, Short.MAX_VALUE)
        );


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)//UNRELATED
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(deckPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(miplePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))//
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(deckPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(miplePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)

                        .addGap(0, gamePanel.screenHeight-gamePanel.originalTileSize-70-gamePanel.mipleSize*2, Short.MAX_VALUE)
                        )

                        .addGroup(layout.createSequentialGroup()
                                .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>
     DeckPanel deckPanel ;
    GamePanel gamePanel;
    JLabel jLabel1;
    JLabel jLabel2;
    MiplePanel miplePanel;
}
/*JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle("CarcassoneLite");

    gamePanel = new GamePanel();
        deckPanel = new DeckPanel(gamePanel);
        initComponents();

    window.add(gamePanel);
       // window.add(deckPanel);
    window.pack();
    window.setLocationRelativeTo(null);
    window.setVisible(true);*/
//.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
