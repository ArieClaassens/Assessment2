/*
 * Copyright (C) 2014 Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * University of Leeds, Leeds, West Yorkshire, UK.
 * All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package BacterialBomb;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 */
public class DispersalModeller extends javax.swing.JFrame {

    //Instantiate new storage object to hold detonation map
    Storage storeDetonation = new Storage();
    //Instantiate new storage object to hold dispersal map
    Storage storeDispersal = new Storage();
    //Instantiate new storage object to hold random dispersal map
    Storage storeRandomDispersal = new Storage();

    //Instantiate new IO object
    IO io = new IO();

    //Font to use for warnings
    //From http://stackoverflow.com/questions/10630738/how-to-set-strings-font-size-style-in-java-using-font-class
    // and http://www.java2s.com/Tutorial/Java/0261__2D-Graphics/javaawtFont.htm
    Font fontWarning = new Font("Serif", Font.BOLD | Font.ITALIC, 12);
    Font fontReady = new Font("Serif", Font.PLAIN, 12);

    //Label to store last used directory, to keep saved files in same place as source files
    //Not smooth, need to get a better option, like a temp directory to use, if possible
    String filedir = null;

    //label to hold detonationPoint value
    String detonationPoint = null;

    //Method to limit file extensions to .raster on all platforms except Windows
    //Obtained from https://www.daniweb.com/software-development/java/threads/282830/file-type-filter-for-filedialog-problem 
    public class rasterFilter implements FilenameFilter {

        public boolean accept(File dir, String name) {
            return (name.endsWith(".raster"));
        }
    }

    //Method to create buffered image from Toolkit image
    //http://stackoverflow.com/questions/22426040/error-sun-awt-image-toolkitimage-cannot-be-cast-to-java-awt-image-bufferedimage
    public static BufferedImage convertToBufferedImage(Image image) {
        BufferedImage newImage = new BufferedImage(
                image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }

    //Method to create PNG or JPG from BufferedImage
    //Sourced from http://www.rgagnon.com/javadetails/java-0601.html
    public static void writeImageToPNG(File file, BufferedImage bufferedImage)
            throws IOException {
        ImageIO.write(bufferedImage, "png", file);
    }

    public static void writeImageToJPG(File file, BufferedImage bufferedImage)
            throws IOException {
        ImageIO.write(bufferedImage, "jpg", file);
    }

    /**
     * Method to set the values of jSliderTotalProbability,jTextFieldTotalProbability and jTextPaneMessages with an
     * error message to display when total probability does not equal 100% and an info message to display when the total
     * probability does equal 100%
     *
     */
    public void setSliderValues() {
        jSliderTotalProbability.setValue(jSliderEastProbability.getValue() + jSliderNorthProbability.getValue() + jSliderWestProbability.getValue() + jSliderSouthProbability.getValue());
        jTextFieldTotalProbability.setText(jSliderEastProbability.getValue() + jSliderNorthProbability.getValue() + jSliderWestProbability.getValue() + jSliderSouthProbability.getValue() + "%");
        System.out.println("jSliderTotalProbability value is now: " + jSliderTotalProbability.getValue());
        //Notify the user if the probability parameters are invalid
        if (jSliderTotalProbability.getValue() != 100) {
            jSliderTotalProbability.setForeground(Color.red);
            jTextFieldTotalProbability.setForeground(Color.red);
            jTextPaneMessages.setText("The total probability does not equal 100%.");
        } else if (jSliderTotalProbability.getValue() == 100) {
            jSliderTotalProbability.setForeground(Color.black);
            jTextFieldTotalProbability.setForeground(Color.black);
            jTextPaneMessages.setText("The total probability equals 100%. No problem there anymore");
        }
    }

    /**
     * Creates new form DispersalModeller
     */
    public DispersalModeller() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aboutDialog = new javax.swing.JDialog();
        jMenuItem5 = new javax.swing.JMenuItem();
        jFileChooser = new javax.swing.JFileChooser();
        jFileSaver = new javax.swing.JFileChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabelXPos = new javax.swing.JLabel();
        jTextFieldXPos = new javax.swing.JTextField();
        jLabelYPos = new javax.swing.JLabel();
        jTextFieldYPos = new javax.swing.JTextField();
        jSliderEastProbability = new javax.swing.JSlider();
        jSliderSouthProbability = new javax.swing.JSlider();
        jSliderWestProbability = new javax.swing.JSlider();
        jLabelNorthProbability = new javax.swing.JLabel();
        jLabelEastProbability = new javax.swing.JLabel();
        jLabelSouthProbability = new javax.swing.JLabel();
        jLabelWestProbability = new javax.swing.JLabel();
        jSliderNorthProbability = new javax.swing.JSlider();
        jButtonRunModeller = new javax.swing.JButton();
        jTextFieldParticleCount = new javax.swing.JTextField();
        jLabelParticleCount = new javax.swing.JLabel();
        jLabelWestProbability1 = new javax.swing.JLabel();
        jLabelHeightStart = new javax.swing.JLabel();
        jTextFieldStartHeight = new javax.swing.JTextField();
        jSliderTotalProbability = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneMessages = new javax.swing.JTextPane();
        jTextFieldTotalProbability = new javax.swing.JTextField();
        jLabelMouseX = new javax.swing.JLabel();
        jLabelMouseY = new javax.swing.JLabel();
        jTextFieldMouseX = new javax.swing.JTextField();
        jTextFieldMouseY = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuOpenFile = new javax.swing.JMenuItem();
        jMenuSaveFileAs = new javax.swing.JMenuItem();
        jMenuSaveRandomFile = new javax.swing.JMenuItem();
        jMenuRunModeller = new javax.swing.JMenuItem();
        jMenuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuEditGenerateRandomData = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuHelpModeller = new javax.swing.JMenuItem();
        jMenuHelpAbout = new javax.swing.JMenuItem();

        aboutDialog.setTitle("About");
        aboutDialog.setAlwaysOnTop(true);
        aboutDialog.setModal(true);

        javax.swing.GroupLayout aboutDialogLayout = new javax.swing.GroupLayout(aboutDialog.getContentPane());
        aboutDialog.getContentPane().setLayout(aboutDialogLayout);
        aboutDialogLayout.setHorizontalGroup(
            aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        aboutDialogLayout.setVerticalGroup(
            aboutDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenuItem5.setText("jMenuItem5");

        jFileChooser.setApproveButtonText("Open Input");
        jFileChooser.setApproveButtonToolTipText("");
        jFileChooser.setCurrentDirectory(new java.io.File("C:\\Git\\Assessment2\\JavaGIS\\src\\BacterialBomb"));
        jFileChooser.setDialogTitle("Choose a file to load for processing");

        jFileSaver.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        jFileSaver.setApproveButtonText("Save output");
        jFileSaver.setApproveButtonToolTipText("");
        jFileSaver.setCurrentDirectory(new java.io.File("C:\\Git\\Assessment2\\JavaGIS\\src\\BacterialBomb"));
        jFileSaver.setDialogTitle("Save modeller output");
        jFileSaver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileSaverActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biological Agent Detonation Dispersal Modeller");
        setLocationByPlatform(true);
        setName("frameMain"); // NOI18N

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setToolTipText("Tabbed pane where the maps are displayed");
        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(350, 350));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(300, 300));
        jTabbedPane1.setName("jTabbedPane1"); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(300, 300));
        jTabbedPane1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseMoved(evt);
            }
        });
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTabbedPane1MousePressed(evt);
            }
        });

        jLabelXPos.setText("X Position:");

        jTextFieldXPos.setText("00");
        jTextFieldXPos.setToolTipText("X position of the detonation point");
        jTextFieldXPos.setMaximumSize(new java.awt.Dimension(20, 20));
        jTextFieldXPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldXPosActionPerformed(evt);
            }
        });

        jLabelYPos.setText("Y Position:");

        jTextFieldYPos.setText("00");
        jTextFieldYPos.setToolTipText("Y position of the detonation point");
        jTextFieldYPos.setMaximumSize(new java.awt.Dimension(20, 20));
        jTextFieldYPos.setName(""); // NOI18N
        jTextFieldYPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldYPosActionPerformed(evt);
            }
        });

        jSliderEastProbability.setMajorTickSpacing(20);
        jSliderEastProbability.setMinorTickSpacing(10);
        jSliderEastProbability.setPaintLabels(true);
        jSliderEastProbability.setPaintTicks(true);
        jSliderEastProbability.setToolTipText("Probability of particle moving in an EASTERN direction");
        jSliderEastProbability.setValue(75);
        jSliderEastProbability.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSliderEastProbabilityMouseReleased(evt);
            }
        });
        jSliderEastProbability.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jSliderEastProbabilityKeyReleased(evt);
            }
        });

        jSliderSouthProbability.setMajorTickSpacing(20);
        jSliderSouthProbability.setMinorTickSpacing(10);
        jSliderSouthProbability.setPaintLabels(true);
        jSliderSouthProbability.setPaintTicks(true);
        jSliderSouthProbability.setToolTipText("Probability of particle moving in a SOUTHERN direction");
        jSliderSouthProbability.setValue(10);
        jSliderSouthProbability.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSliderSouthProbabilityMouseReleased(evt);
            }
        });
        jSliderSouthProbability.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jSliderSouthProbabilityKeyReleased(evt);
            }
        });

        jSliderWestProbability.setMajorTickSpacing(20);
        jSliderWestProbability.setMinorTickSpacing(10);
        jSliderWestProbability.setPaintLabels(true);
        jSliderWestProbability.setPaintTicks(true);
        jSliderWestProbability.setToolTipText("Probability of particle moving in a WESTERN direction");
        jSliderWestProbability.setValue(5);
        jSliderWestProbability.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSliderWestProbabilityMouseReleased(evt);
            }
        });
        jSliderWestProbability.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jSliderWestProbabilityKeyReleased(evt);
            }
        });

        jLabelNorthProbability.setText("% North:");

        jLabelEastProbability.setText("% East:");

        jLabelSouthProbability.setText("% South:");

        jLabelWestProbability.setText("% West:");

        jSliderNorthProbability.setMajorTickSpacing(20);
        jSliderNorthProbability.setMinorTickSpacing(10);
        jSliderNorthProbability.setPaintLabels(true);
        jSliderNorthProbability.setPaintTicks(true);
        jSliderNorthProbability.setToolTipText("Probability of particle moving in an EASTERN direction");
        jSliderNorthProbability.setValue(10);
        jSliderNorthProbability.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSliderNorthProbabilityMouseReleased(evt);
            }
        });
        jSliderNorthProbability.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jSliderNorthProbabilityKeyReleased(evt);
            }
        });

        jButtonRunModeller.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonRunModeller.setText("Run Modeller");
        jButtonRunModeller.setToolTipText("Click this button to run the modeller after setting all your parameters");
        jButtonRunModeller.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonRunModeller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRunModellerActionPerformed(evt);
            }
        });

        jTextFieldParticleCount.setText("5000");
        jTextFieldParticleCount.setToolTipText("Number of particles to use in the model calculations");

        jLabelParticleCount.setText("Particle count:");

        jLabelWestProbability1.setText("TOTAL %:");

        jLabelHeightStart.setText("Start height (m):");
        jLabelHeightStart.setToolTipText("");

        jTextFieldStartHeight.setText("75");
        jTextFieldStartHeight.setToolTipText("The height in metres at which the detonation takes place");
        jTextFieldStartHeight.setMaximumSize(new java.awt.Dimension(20, 20));
        jTextFieldStartHeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStartHeightActionPerformed(evt);
            }
        });

        jSliderTotalProbability.setMajorTickSpacing(20);
        jSliderTotalProbability.setMaximum(120);
        jSliderTotalProbability.setMinorTickSpacing(10);
        jSliderTotalProbability.setPaintLabels(true);
        jSliderTotalProbability.setPaintTicks(true);
        jSliderTotalProbability.setToolTipText("Probability of particle moving in a WESTERN direction");
        jSliderTotalProbability.setValue(100);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Direction change probabilities");

        jTextPaneMessages.setEditable(false);
        jTextPaneMessages.setText("Check this box for warnings or messages");
        jTextPaneMessages.setToolTipText("This area is used to display application messages");
        jScrollPane1.setViewportView(jTextPaneMessages);

        jTextFieldTotalProbability.setEditable(false);
        jTextFieldTotalProbability.setText("0");
        jTextFieldTotalProbability.setToolTipText("The total probability value for all the wind-speed change factors");

        jLabelMouseX.setText("Mouse X Pos:");

        jLabelMouseY.setText("Mouse Y Pos:");

        jTextFieldMouseX.setText("00");
        jTextFieldMouseX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMouseXActionPerformed(evt);
            }
        });

        jTextFieldMouseY.setText("00");

        jMenu1.setText("File");

        jMenuOpenFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuOpenFile.setText("Open File");
        jMenuOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOpenFileActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuOpenFile);

        jMenuSaveFileAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuSaveFileAs.setText("Save Raster File");
        jMenuSaveFileAs.setToolTipText("Run the Modeller before you can save the output");
        jMenuSaveFileAs.setEnabled(false);
        jMenuSaveFileAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSaveFileAsActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSaveFileAs);

        jMenuSaveRandomFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuSaveRandomFile.setText("Save Random Raster File");
        jMenuSaveRandomFile.setToolTipText("Generate Random Dispersal before you can save the output");
        jMenuSaveRandomFile.setEnabled(false);
        jMenuSaveRandomFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSaveRandomFileActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSaveRandomFile);

        jMenuRunModeller.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuRunModeller.setText("Run Modeller");
        jMenuRunModeller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRunModellerActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuRunModeller);

        jMenuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuExit.setText("Exit");
        jMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuEditGenerateRandomData.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuEditGenerateRandomData.setText("Generate Random Data");
        jMenuEditGenerateRandomData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEditGenerateRandomDataActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuEditGenerateRandomData);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        jMenuHelpModeller.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuHelpModeller.setText("Modeller Help");
        jMenuHelpModeller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHelpModellerActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuHelpModeller);

        jMenuHelpAbout.setText("About");
        jMenuHelpAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHelpAboutActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuHelpAbout);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNorthProbability)
                            .addComponent(jLabelEastProbability)
                            .addComponent(jLabelSouthProbability)
                            .addComponent(jLabelWestProbability)
                            .addComponent(jLabelWestProbability1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonRunModeller)
                                    .addComponent(jSliderNorthProbability, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSliderEastProbability, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSliderSouthProbability, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSliderWestProbability, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSliderTotalProbability, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldTotalProbability, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelHeightStart)
                                .addGap(2, 2, 2)
                                .addComponent(jTextFieldStartHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelParticleCount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldParticleCount, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelXPos)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldXPos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelMouseX)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldMouseX, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelYPos)
                                        .addGap(24, 24, 24)
                                        .addComponent(jTextFieldYPos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabelMouseY)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldMouseY, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSliderNorthProbability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNorthProbability))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabelEastProbability))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSliderEastProbability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSouthProbability)
                            .addComponent(jSliderSouthProbability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelWestProbability)
                            .addComponent(jSliderWestProbability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelWestProbability1)
                            .addComponent(jSliderTotalProbability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTotalProbability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jButtonRunModeller)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMouseX)
                            .addComponent(jLabelMouseY)
                            .addComponent(jTextFieldMouseX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldMouseY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelXPos)
                            .addComponent(jTextFieldXPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelYPos)
                            .addComponent(jTextFieldYPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelHeightStart)
                            .addComponent(jTextFieldStartHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelParticleCount)
                            .addComponent(jTextFieldParticleCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))))
        );

        jTextFieldStartHeight.getAccessibleContext().setAccessibleName("Start height");

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOpenFileActionPerformed
        /* Original code - switched to using code rolled on my own
         int returnVal = jFileChooser.showOpenDialog(this);
         if (returnVal == jFileChooser.APPROVE_OPTION) {
         File file = jFileChooser.getSelectedFile();
         try {
         // What to do with the file, e.g. display it in a TextArea
         //textarea.read( new FileReader( file.getAbsolutePath() ), null );
         //FileReader inputFile = new FileReader(file.getAbsolutePath());
         //System.out.println("File opened fine -> " + inputFile);
         store.setData(io.readData(inputFile));
                
         } catch (IOException ex) {
         System.out.println("Problem accessing file" + file.getAbsolutePath());
         }
         } else {
         System.out.println("File access cancelled by user.");
         }
         */

        FileDialog fd = new FileDialog(this, "Open Raster File", FileDialog.LOAD);
        //Implement filtering for all platforms but Windows
        rasterFilter filter = new rasterFilter();
        fd.setFilenameFilter(filter);
        //Add filtering for Windows platform
        //http://stackoverflow.com/questions/1241984/need-filedialog-with-a-file-type-filter-in-java
        //http://www.rgagnon.com/javadetails/java-0247.html
        fd.setFile("*.raster");
        //Disable multiple file selection
        fd.setMultipleMode(false);
        fd.setVisible(true);
        File f = null;
        if ((fd.getDirectory() != null) || (fd.getFile() != null)) {
            //Labels to use in saving the detonation map
            filedir = fd.getDirectory();
            String filename = fd.getFile();

            f = new File(fd.getDirectory() + fd.getFile());
            storeDetonation.setData(io.readData(f));
            //repaint();

            //Find the detonation point
            detonationPoint = storeDetonation.locateDetonationPoint(storeDetonation.data);
            System.out.println("detpoint is: " + detonationPoint + " and this is a string, BTW!!!");

            //Populate the X Position text field
            jTextFieldXPos.setText(detonationPoint.substring(detonationPoint.indexOf('{') + 1, detonationPoint.indexOf(',')));
            //Populate the Y Position text field
            jTextFieldYPos.setText(detonationPoint.substring(detonationPoint.indexOf(',') + 1, detonationPoint.indexOf('}')));

            //Populate the Total Probability text field
            jTextFieldTotalProbability.setText(jSliderTotalProbability.getValue() + "%");

            //Draw the detonation map in the tabbed pane
            Image imageDetonationMap = storeDetonation.getDataAsImage(); // or equivalent
            //g.drawImage(image, getInsets().left, getInsets().top, this);
            //jTabbedPane1.addTab("Detonation map", new JLabel(new ImageIcon(DispersalModeller.class.getResource("Bacteria-icon.png"))));
            BufferedImage bufferedImageDetonationMap = convertToBufferedImage(imageDetonationMap);
            //Stitch together filename for detonation map
            String filenameDetMap = filedir + "Detonation_map.png";
            File fileDetMap = new File(filenameDetMap);

            try {
                writeImageToPNG(fileDetMap, bufferedImageDetonationMap);
            } catch (IOException ex) {
                //handle the IOException
                System.out.println("The detonation map automated file save did not work");
            }
            //jTabbedPane1.addTab("Clicky map", new JLabel(bufferedImageDetonationMap));
            System.out.println("The fing name is " + filenameDetMap);
            //jTabbedPane1.addTab("Clicky map", new JLabel(DispersalModeller.class.getResource(f+".png")), rootPane);
            //jTabbedPane1.addTab("Clicky map", new ImageIcon(DispersalModeller.class.getResource(filename + ".png")), rootPane);

            //If the tab exists, remove it and the corresponding component. Speficfied using the index
            if (jTabbedPane1.indexOfTab("Detonation Map") >= 0) {
                jTabbedPane1.removeTabAt(jTabbedPane1.indexOfTab("Detonation Map"));
            }
            jTabbedPane1.addTab("Detonation Map", new JLabel(new ImageIcon(DispersalModeller.class.getResource(filename + ".png"))));

        }


    }//GEN-LAST:event_jMenuOpenFileActionPerformed

    private void jMenuSaveFileAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSaveFileAsActionPerformed
        /* original code
         int returnVal = jFileSaver.showSaveDialog(this);
         if (returnVal == jFileSaver.APPROVE_OPTION) {
         File file2 = jFileSaver.getSelectedFile();
         try {
         // What to do with the file, e.g. display it in a TextArea
         //textarea.read( new FileReader( file.getAbsolutePath() ), null );
         //Overwrite the chosen file, no appending.
         FileWriter writer = new FileWriter(file2, false);
         writer.append("Data inside the file");
         //writer.append(inputFile);
         writer.flush();
         writer.close();
         System.out.println("File saving worked, but did we save the dispersal map contents?");
         } catch (IOException ex) {
         System.out.println("problem accessing file" + file2.getAbsolutePath());
         }
         } else {
         System.out.println("File save cancelled by user.");
         }
         */

        FileDialog fw = new FileDialog(this, "Save Raster File", FileDialog.SAVE);
        //Implement filtering for all platforms but Windows
        rasterFilter filter = new rasterFilter();
        fw.setFilenameFilter(filter);
        //Add filtering for Windows platform
        //http://stackoverflow.com/questions/1241984/need-filedialog-with-a-file-type-filter-in-java
        //http://www.rgagnon.com/javadetails/java-0247.html
        fw.setFile("*.raster");

        fw.setVisible(true);
        File f2 = null;
        if ((fw.getDirectory() != null) || (fw.getFile() != null)) {
            f2 = new File(fw.getDirectory() + fw.getFile());
            //Need to check the content of the dispersal map first!!!
            //Need to check which map we're trying to save - processed one or the random dispersal one
            io.writeData(storeDispersal.data, f2);
            System.out.println("File save completed");
        }
    }//GEN-LAST:event_jMenuSaveFileAsActionPerformed

    private void jMenuRunModellerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRunModellerActionPerformed
        // TODO add your handling code here:
        System.out.println("TRIGGERED -----> jMenuRunModellerActionPerformed");
    }//GEN-LAST:event_jMenuRunModellerActionPerformed

    private void jMenuHelpAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHelpAboutActionPerformed
        // TODO add your handling code here:
        System.out.println("TRIGGERED -----> jMenuHelpAboutActionPerformed");
        //Display an application-modal Dialog window to the user, using the default dialog type icon
        //From https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
        JOptionPane.showMessageDialog(this,
                "Eggs are not supposed to be green.\n\r" + "And neither are toes...", "About BADdm",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuHelpAboutActionPerformed

    private void jMenuHelpModellerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHelpModellerActionPerformed
        // TODO add your handling code here:
        System.out.println("TRIGGERED -----> jMenuHelpModellerActionPerformed");
        //Load an HTML file to display app help
        new HtmlEditorKitTest();

    }//GEN-LAST:event_jMenuHelpModellerActionPerformed

    private void jMenuEditGenerateRandomDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEditGenerateRandomDataActionPerformed
        // TODO add your handling code here:
        System.out.println("TRIGGERED -----> jMenuEditGenerateRandomDataActionPerformed");
        storeRandomDispersal.setRandomData();
        //Generate and display the random dispersal map

        //Draw the random dispersal map in the tabbed pane
        Image imageRandomDispersalMap = storeRandomDispersal.getDataAsImage(); // or equivalent
        BufferedImage bufferedImageDispersalMap = convertToBufferedImage(imageRandomDispersalMap);
        //Stitch together filename for detonation map
        String filenameRandomDisMap = filedir + "Random_Dispersal_map.png";
        File fileRandomDisMap = new File(filenameRandomDisMap);

        try {
            writeImageToPNG(fileRandomDisMap, bufferedImageDispersalMap);
        } catch (IOException ex) {
            //handle the IOException
            System.out.println("The dispersal map automated file save did not work");
        }
        System.out.println("The Random Dispersal map's name is " + filenameRandomDisMap);
        //If the tab exists, remove it and the corresponding component. Speficfied using the index
        if (jTabbedPane1.indexOfTab("Random Dispersal Map") >= 0) {
            jTabbedPane1.removeTabAt(jTabbedPane1.indexOfTab("Random Dispersal Map"));
        }
        jTabbedPane1.addTab("Random Dispersal Map", new JLabel(new ImageIcon(filenameRandomDisMap)));
        System.out.println("Current Selected Index is: " + jTabbedPane1.getSelectedIndex());

        //Activate the Save Random File Menu Item
        jMenuSaveRandomFile.setEnabled(true);
        jMenuSaveRandomFile.setToolTipText("Save the random dispersal raster output");

        //Add a help text message to say that output can now be saved
        jTextPaneMessages.setText("You can now save the Random Dispersal output. Check the File menu or just press Ctl+T");


    }//GEN-LAST:event_jMenuEditGenerateRandomDataActionPerformed

    private void jMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExitActionPerformed
        //Close app and exit without any errors
        System.exit(0);
    }//GEN-LAST:event_jMenuExitActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        //jTextFieldXPos.setText(" ");
        //jTextFieldYPos.setText(" ");
        System.out.println("TRIGGERED -----> jTabbedPane1MouseClicked");
        //Capture Mouse position relative to tabbed pane and display in a text box
        //System.out.println("Coordinates: " + this.getX() + "," + this.getY() + " logged");
        //WAIT - WE'RE APPENDING TEXT TO TURN INTEGER VALUES INTO STRINGS!!! FIX IT FIX IT FIX IT
        //Only updates on the first click
        System.out.println("Coordinates: " + this.getMousePosition());
        jTextFieldXPos.setText((int)this.getMousePosition().getX() + "");
        jTextFieldYPos.setText((int)this.getMousePosition().getY() + "");
        jTextFieldMouseX.setText((int)this.getMousePosition().getX() + "");
        jTextFieldMouseY.setText((int)this.getMousePosition().getY() + "");
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTextFieldXPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldXPosActionPerformed
        // TODO add your handling code here:
        System.out.println("TRIGGERED -----> jTextFieldXPosActionPerformed");
    }//GEN-LAST:event_jTextFieldXPosActionPerformed

    private void jTextFieldYPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldYPosActionPerformed
        // TODO add your handling code here:
        System.out.println("TRIGGERED -----> jTextFieldYPosActionPerformed");
    }//GEN-LAST:event_jTextFieldYPosActionPerformed

    private void jButtonRunModellerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRunModellerActionPerformed
        // TODO add your handling code here:
        System.out.println("TRIGGERED -----> jButtonRunModellerActionPerformed");

        //Check whether we have the data and parameters required for the job and that they contain sensible values
        //We need:
        //Number of agent particles to use in the model. Must be more than zero, or else the model serves no purpose
        //try & catch?
        int bacteriaCount = Integer.parseInt(jTextFieldParticleCount.getText());

        //The detonation point X and Y values to determine where to start the calculations
        //The coordinates cannot fall outside the target area, so check for that too, assuming we're using a square image
        int xPos = Integer.parseInt(jTextFieldXPos.getText());
        int yPos = Integer.parseInt(jTextFieldYPos.getText());

        //Detonation height, equal to or higher than 0m above the surface. We're not working with subterranean
        //detonations in this model.
        int detonationHeight = Integer.parseInt(jTextFieldStartHeight.getText());

        //Wind-speed based direction change probabilities, totalling 100%. 
        //Sanity test only needs to check if total probaility = 100%; using less variables and getting value directly
        //from component, saving time and resources.
        int changeNorthProbability = jSliderNorthProbability.getValue();
        int changeEastProbability = jSliderEastProbability.getValue();
        int changeSouthProbability = jSliderSouthProbability.getValue();
        int changeWestProbability = jSliderWestProbability.getValue();

        //Data source to work from is optional. User may choose to work directly from a user-selected start point, without
        //having to open a source file first every time.        
        //Use shorthand to ensure that code cathes the error as soon as a non-compliant parameter is detected
        if ((bacteriaCount > 0) && (xPos > 0) && (xPos < storeDispersal.data.length) && (yPos > 0)
                && (yPos < storeDispersal.data.length) && (detonationHeight >= 0)
                && (jSliderTotalProbability.getValue() == 100)) {
            System.out.println("SUCCESS -----> Model will run; parameters all present and valid");
            jTextPaneMessages.setText("Thar she blows! With total probability at " + jSliderTotalProbability.getValue()
                    + ": North: " + changeNorthProbability + ", East: " + changeEastProbability
                    + ", South: " + changeSouthProbability + ", West: " + changeWestProbability);
            //Run the Modeller
            double[][] dispersalArray = storeDispersal.calculateDispersal(bacteriaCount, storeDispersal.data.length,
                    storeDispersal.data.length, xPos, yPos, changeNorthProbability, changeEastProbability, changeSouthProbability, changeWestProbability);

            //Save the data to the store.data object
            storeDispersal.data = dispersalArray;
            //Draw a density map of where all the bacteria end up as an image and displays it on the screen.

            //Generate and display the random dispersal map
            //Draw the random dispersal map in the tabbed pane
            Image imageDispersalMap = storeDispersal.getDataAsImage(); // or equivalent
            //g.drawImage(image, getInsets().left, getInsets().top, this);
            //jTabbedPane1.addTab("Detonation map", new JLabel(new ImageIcon(DispersalModeller.class.getResource("Bacteria-icon.png"))));
            BufferedImage bufferedImageDispersalMap = convertToBufferedImage(imageDispersalMap);
            //Stitch together filename for detonation map
            String filenameDisMap = filedir + "Dispersal_map.png";
            File fileDisMap = new File(filenameDisMap);

            try {
                writeImageToPNG(fileDisMap, bufferedImageDispersalMap);
            } catch (IOException ex) {
                //handle the IOException
                System.out.println("The dispersal map automated file save did not work");
            }
            System.out.println("The Dispersal map's name is " + filenameDisMap);
            //If the tab exists, remove it and the corresponding component. Speficfied using the index
            if (jTabbedPane1.indexOfTab("Dispersal Map") >= 0) {
                jTabbedPane1.removeTabAt(jTabbedPane1.indexOfTab("Dispersal Map"));
            }
            jTabbedPane1.addTab("Dispersal Map", new JLabel(new ImageIcon(filenameDisMap)));
            System.out.println("Current Selected Index is: " + jTabbedPane1.getSelectedIndex());

        } else {
            System.out.println("FAILED -----> Model will not run; incorrect parameters");
            jTextPaneMessages.setText("Hey buddy! Check your parameter values!!! This ain't gonna work...");
        }

        //Activate the Save File Menu Item
        jMenuSaveFileAs.setEnabled(true);
        jMenuSaveFileAs.setToolTipText("Save the dispersal raster output");

        //Add a help text message to say that output can now be saved
        jTextPaneMessages.setText("You can now save the Dispersal output. Check the File menu or just press Ctl+S");
        //End Modeller Button
    }//GEN-LAST:event_jButtonRunModellerActionPerformed

    private void jFileSaverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileSaverActionPerformed
        // TODO add your handling code here:
        System.out.println("TRIGGERED -----> jFileSaverActionPerformed");
    }//GEN-LAST:event_jFileSaverActionPerformed

    private void jTextFieldStartHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStartHeightActionPerformed
        // TODO add your handling code here:
        System.out.println("TRIGGERED -----> jTextFieldStartHeightActionPerformed");
    }//GEN-LAST:event_jTextFieldStartHeightActionPerformed

    private void jSliderEastProbabilityMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSliderEastProbabilityMouseReleased
        setSliderValues();
    }//GEN-LAST:event_jSliderEastProbabilityMouseReleased

    private void jSliderSouthProbabilityMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSliderSouthProbabilityMouseReleased
        setSliderValues();
    }//GEN-LAST:event_jSliderSouthProbabilityMouseReleased

    private void jSliderWestProbabilityMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSliderWestProbabilityMouseReleased
        setSliderValues();
    }//GEN-LAST:event_jSliderWestProbabilityMouseReleased

    private void jSliderNorthProbabilityMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSliderNorthProbabilityMouseReleased
        setSliderValues();
    }//GEN-LAST:event_jSliderNorthProbabilityMouseReleased

    private void jSliderNorthProbabilityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSliderNorthProbabilityKeyReleased
        setSliderValues();
    }//GEN-LAST:event_jSliderNorthProbabilityKeyReleased

    private void jSliderEastProbabilityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSliderEastProbabilityKeyReleased
        setSliderValues();
    }//GEN-LAST:event_jSliderEastProbabilityKeyReleased

    private void jSliderSouthProbabilityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSliderSouthProbabilityKeyReleased
        setSliderValues();
    }//GEN-LAST:event_jSliderSouthProbabilityKeyReleased

    private void jSliderWestProbabilityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSliderWestProbabilityKeyReleased
        setSliderValues();
    }//GEN-LAST:event_jSliderWestProbabilityKeyReleased

    private void jMenuSaveRandomFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSaveRandomFileActionPerformed
        // TODO add your handling code here:
        //Add code here to save random dispersal map as image
        FileDialog fw = new FileDialog(this, "Save Random Dispersal Raster File", FileDialog.SAVE);
        //Implement filtering for all platforms but Windows
        rasterFilter filter = new rasterFilter();
        fw.setFilenameFilter(filter);
        //Add filtering for Windows platform
        //http://stackoverflow.com/questions/1241984/need-filedialog-with-a-file-type-filter-in-java
        //http://www.rgagnon.com/javadetails/java-0247.html
        fw.setFile("*.raster");

        fw.setVisible(true);
        File f2 = null;
        if ((fw.getDirectory() != null) || (fw.getFile() != null)) {
            f2 = new File(fw.getDirectory() + fw.getFile());
            //Need to check the content of the dispersal map first!!!
            //Need to check which map we're trying to save - processed one or the random dispersal one
            io.writeData(storeRandomDispersal.data, f2);
            System.out.println("File save completed");
        }
    }//GEN-LAST:event_jMenuSaveRandomFileActionPerformed

    private void jTabbedPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MousePressed
        // TODO add your handling code here:
        System.out.println("TRIGGERED -----> jTabbedPane1MousePressed");
        //System.out.println("Coordinates: " + this.getMousePosition() + " and adjusted: " + jTabbedPane1.getMousePosition(true) + " and inside the image: " + jTabbedPane1.getMousePosition(true) + " and currently selected component: " + jTabbedPane1.getSelectedComponent());

        System.out.println("Coordinates: " + this.getMousePosition());
        jTextFieldXPos.setText((int)this.getMousePosition().getX() + "");
        jTextFieldYPos.setText((int)this.getMousePosition().getY() + "");

    }//GEN-LAST:event_jTabbedPane1MousePressed

    private void jTabbedPane1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseMoved
        // TODO add your handling code here:
        System.out.println("TRIGGERED -----> jTabbedPane1MouseMoved");
        //System.out.println("Coordinates: " + this.getMousePosition() + " and adjusted: " + jTabbedPane1.getMousePosition(true) + " and inside the image: " + jTabbedPane1.getMousePosition(true) + " and currently selected component: " + jTabbedPane1.getSelectedComponent());

        System.out.println("Coordinates: " + this.getMousePosition());
        jTabbedPane1.setToolTipText("Current mouse location: X:" + (int)this.getMousePosition().getX() + ", Y: " + (int)this.getMousePosition().getY());
        jTextFieldMouseX.setText((int)this.getMousePosition().getX() + "");
        jTextFieldMouseY.setText((int)this.getMousePosition().getY() + "");
    }//GEN-LAST:event_jTabbedPane1MouseMoved

    private void jTextFieldMouseXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMouseXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMouseXActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DispersalModeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DispersalModeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DispersalModeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DispersalModeller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DispersalModeller().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog aboutDialog;
    public javax.swing.JButton jButtonRunModeller;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JFileChooser jFileSaver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEastProbability;
    private javax.swing.JLabel jLabelHeightStart;
    private javax.swing.JLabel jLabelMouseX;
    private javax.swing.JLabel jLabelMouseY;
    private javax.swing.JLabel jLabelNorthProbability;
    private javax.swing.JLabel jLabelParticleCount;
    private javax.swing.JLabel jLabelSouthProbability;
    private javax.swing.JLabel jLabelWestProbability;
    private javax.swing.JLabel jLabelWestProbability1;
    private javax.swing.JLabel jLabelXPos;
    private javax.swing.JLabel jLabelYPos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuEditGenerateRandomData;
    private javax.swing.JMenuItem jMenuExit;
    private javax.swing.JMenuItem jMenuHelpAbout;
    private javax.swing.JMenuItem jMenuHelpModeller;
    private javax.swing.JMenuItem jMenuItem5;
    public javax.swing.JMenuItem jMenuOpenFile;
    private javax.swing.JMenuItem jMenuRunModeller;
    private javax.swing.JMenuItem jMenuSaveFileAs;
    private javax.swing.JMenuItem jMenuSaveRandomFile;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JSlider jSliderEastProbability;
    public javax.swing.JSlider jSliderNorthProbability;
    public javax.swing.JSlider jSliderSouthProbability;
    public javax.swing.JSlider jSliderTotalProbability;
    public javax.swing.JSlider jSliderWestProbability;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldMouseX;
    private javax.swing.JTextField jTextFieldMouseY;
    public javax.swing.JTextField jTextFieldParticleCount;
    public javax.swing.JTextField jTextFieldStartHeight;
    private javax.swing.JTextField jTextFieldTotalProbability;
    public javax.swing.JTextField jTextFieldXPos;
    public javax.swing.JTextField jTextFieldYPos;
    private javax.swing.JTextPane jTextPaneMessages;
    // End of variables declaration//GEN-END:variables
}
