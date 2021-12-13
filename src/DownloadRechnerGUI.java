import javax.swing.*;
import java.awt.event.*;


public class DownloadRechnerGUI {
    private JPanel MainPanel;
    private JTextField JtfData;
    private JButton JbtnDataTB;
    private JButton JbtnDataGB;
    private JButton JbtnDataMB;
    private JButton JbtnDataKB;
    private JTextField JtfDownSpeed;
    private JTextField JtfUpSpeed;
    private JButton JbtnSpeedMBits;
    private JButton JbtnSpeedGBits;
    private JButton JbtnStart;
    private JButton JbtnSpeedGBs;
    private JButton JbtnSpeedMbs;
    private JButton JbtnSpeedKBs;
    private JButton JbtnSpeedKBits;
    private JLabel JlblDownBigTime;
    private JLabel JlblDownBigTimeUnit;
    private JLabel JlblDownSmallTime;
    private JLabel JlblDownSmallTimeUnit;
    private JLabel JlblDownloadzeit;
    private JLabel JlblUploadzeit;
    private JLabel JlblUpBigTime;
    private JLabel JlblUpBigTimeUnit;
    private JLabel JlblUpSmallTime;
    private JLabel JlblUpSmallTimeUnit;
    private JLabel JlblDataSizeType;
    private JLabel JlblSpeedType;

    DownloadRechnerCalc myDRGUI = new DownloadRechnerCalc();


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public DownloadRechnerGUI() {




        JbtnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double Datasize = Double.parseDouble(JtfData.getText());
                double Upspeed = Double.parseDouble(JtfUpSpeed.getText());
                double Downspeed = Double.parseDouble(JtfDownSpeed.getText());

                myDRGUI.setDLoadSpeed(Downspeed);
                myDRGUI.setULoadSpeed(Upspeed);
                myDRGUI.setDataSize(Datasize);
                myDRGUI.calcLoadTime();

                if (myDRGUI.getDLoadTimeHours() < 1){
                    JlblDownBigTime.setText(String.valueOf(myDRGUI.getDLoadTimeMin()));
                    JlblDownBigTimeUnit.setText("min");
                    JlblDownSmallTime.setText(String.valueOf(myDRGUI.getDLoadTimeSec()));
                    JlblDownSmallTimeUnit.setText("sec");
                } else {
                    JlblDownBigTime.setText(String.valueOf(myDRGUI.getDLoadTimeHours()));
                    JlblDownBigTimeUnit.setText("h");
                    JlblDownSmallTime.setText(String.valueOf(myDRGUI.getDLoadTimeMin()));
                    JlblDownSmallTimeUnit.setText("h");
                }

                if (myDRGUI.getULoadTimeHours() < 1){
                    JlblUpBigTime.setText(String.valueOf(myDRGUI.getULoadTimeMin()));
                    JlblUpBigTimeUnit.setText("min");
                    JlblUpSmallTime.setText(String.valueOf(myDRGUI.getULoadTimeSec()));
                    JlblUpSmallTimeUnit.setText("sec");
                } else {
                    JlblUpBigTime.setText(String.valueOf(myDRGUI.getULoadTimeHours()));
                    JlblUpBigTimeUnit.setText("h");
                    JlblUpSmallTime.setText(String.valueOf(myDRGUI.getULoadTimeMin()));
                    JlblUpSmallTimeUnit.setText("min");
                }
            }
        });

        JbtnDataKB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDRGUI.setDataSizeType(1);
                JlblDataSizeType.setText("KB");
            }
        });

        JbtnDataMB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDRGUI.setDataSizeType(2);
                JlblDataSizeType.setText("MB");
            }
        });

        JbtnDataGB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDRGUI.setDataSizeType(3);
                JlblDataSizeType.setText("GB");
            }
        });

        JbtnDataTB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDRGUI.setDataSizeType(4);
                JlblDataSizeType.setText("TB");
            }
        });

        JbtnSpeedKBs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDRGUI.setSpeedSizeType(1);
                JlblSpeedType.setText("KB/s");
            }
        });

        JbtnSpeedMbs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              myDRGUI.setSpeedSizeType(2);
                JlblSpeedType.setText("MB/s");
            }
        });

        JbtnSpeedGBs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDRGUI.setSpeedSizeType(3);
                JlblSpeedType.setText("GB/s");
            }
        });

        JbtnSpeedKBits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDRGUI.setSpeedSizeType(4);
                JlblSpeedType.setText("KBit/s");
            }
        });

        JbtnSpeedMBits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDRGUI.setSpeedSizeType(5);
                JlblSpeedType.setText("MBit/s");
            }
        });

        JbtnSpeedGBits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDRGUI.setSpeedSizeType(6);
                JlblSpeedType.setText("GBit/s");
            }
        });


        JtfData.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String s = JtfData.getText();
                if (s.length() > 0) {
                    if (!checkIfNumber(s)) {

                        String Input = JtfData.getText();
                        int StringLength = Input.length();
                        JOptionPane.showMessageDialog(null, "Nur Zahlen");
                        if (StringLength < 1) {
                            StringLength = 1;
                        }
                        Input = Input.substring(0, StringLength - 1);
                        JtfData.setText(Input);
                    }
                }
            }
        });

        JtfDownSpeed.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String s = JtfData.getText();
                if (s.length() > 0) {
                    if (!checkIfNumber(s)) {
                        String Input = JtfData.getText();
                        int StringLength = Input.length();
                        JOptionPane.showMessageDialog(null, "Nur Zahlen");
                        if (StringLength < 1) {
                            StringLength = 1;
                        }
                        Input = Input.substring(0, StringLength - 1);
                        JtfData.setText(Input);
                    }
                }
            }
        });

        JtfUpSpeed.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String s = JtfData.getText();
                if (s.length() > 0) {
                    if (!checkIfNumber(s)) {
                        String Input = JtfData.getText();
                        int StringLength = Input.length();
                        JOptionPane.showMessageDialog(null, "Nur Zahlen");
                        if (StringLength < 1) {
                            StringLength = 1;
                        }
                        Input = Input.substring(0, StringLength - 1);
                        JtfData.setText(Input);
                    }
                }
            }
        });
    }

    public  boolean checkIfNumber (String s){
        boolean isNumber ;

        try {
            double j = Double.parseDouble(s);
            isNumber = true;

        } catch (Exception e){
            isNumber = false;
        }

        return isNumber;
    }

    public static void main (String [ ] args){
        JFrame frame = new JFrame("Downloadrechner");
        frame.setContentPane(new DownloadRechnerGUI().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
