package com.chicootec.dbcomparator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
  private static final long serialVersionUID = 6164842096365815740L;
  private static final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
  private static final int TEXT_FIELD_WIDTH = 30;
  private static final int FRAME_WIDTH = dimension.width - 20;
  private static final int FRAME_HEIGHT = dimension.height - 40;

  private JPanel panelTop = new JPanel();

  private Label labIp = new Label("IP");
  private Label labPort = new Label("端口");
  private Label labDb = new Label("数据库名");
  private Label labUser = new Label("用户名");
  private Label labPwd = new Label("密码");

  private TextField tfIpGood = new TextField(TEXT_FIELD_WIDTH);
  private TextField tfPortGood = new TextField(TEXT_FIELD_WIDTH);
  private TextField tfDbGood = new TextField(TEXT_FIELD_WIDTH);
  private TextField tfUserGood = new TextField(TEXT_FIELD_WIDTH);
  private TextField tfPwdGood = new TextField(TEXT_FIELD_WIDTH);

  private TextField tfIpBad = new TextField(TEXT_FIELD_WIDTH);
  private TextField tfPortBad = new TextField(TEXT_FIELD_WIDTH);
  private TextField tfDbBad = new TextField(TEXT_FIELD_WIDTH);
  private TextField tfUserBad = new TextField(TEXT_FIELD_WIDTH);
  private TextField tfPwdBad = new TextField(TEXT_FIELD_WIDTH);

  private JButton btnHaha = new JButton("退出");
  private JButton btnExchange = new JButton("交换");
  private JButton btnAction = new JButton("执行");

  private JTextArea textArea = new JTextArea("第一行是正确的，第二行是错误的。需要JRE.1.7或以上版本。祝你幸福！", 44, 105);
  private JPanel panelBottom = new JPanel();

  public MainFrame() {
    Font font = new Font("宋体", 1, 25);

    this.btnHaha.setFont(font);
    this.btnExchange.setFont(font);
    this.btnAction.setFont(font);

    this.labIp.setAlignment(1);
    this.labPort.setAlignment(1);
    this.labDb.setAlignment(1);
    this.labUser.setAlignment(1);
    this.labPwd.setAlignment(1);

    this.labIp.setFont(font);
    this.labPort.setFont(font);
    this.labDb.setFont(font);
    this.labUser.setFont(font);
    this.labPwd.setFont(font);

    GridLayout layOut = new GridLayout(3, 6);
    layOut.setHgap(3);
    layOut.setVgap(3);
    this.panelTop.setLayout(layOut);

    this.panelTop.add(this.labIp);
    this.panelTop.add(this.labPort);
    this.panelTop.add(this.labDb);
    this.panelTop.add(this.labUser);
    this.panelTop.add(this.labPwd);
    this.panelTop.add(this.btnHaha);
    this.btnHaha.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (JOptionPane.showConfirmDialog(MainFrame.this, "确定退出吗") == 0)
          System.exit(0);
      }
    });
    this.tfIpGood.setText("192.168.1.11");
    this.tfPortGood.setText("3306");
    this.tfDbGood.setText("hcc");
    this.tfUserGood.setText("root");
    this.tfPwdGood.setText("cloud_angel");

    this.tfIpBad.setText("192.168.1.149");
    this.tfPortBad.setText("3306");
    this.tfDbBad.setText("hcc");
    this.tfUserBad.setText("root");
    this.tfPwdBad.setText("cloud_angel");

    this.tfIpGood.setFont(font);
    this.tfPortGood.setFont(font);
    this.tfDbGood.setFont(font);
    this.tfUserGood.setFont(font);
    this.tfPwdGood.setFont(font);

    this.tfIpBad.setFont(font);
    this.tfPortBad.setFont(font);
    this.tfDbBad.setFont(font);
    this.tfUserBad.setFont(font);
    this.tfPwdBad.setFont(font);

    this.panelTop.add(this.tfIpGood);
    this.panelTop.add(this.tfPortGood);
    this.panelTop.add(this.tfDbGood);
    this.panelTop.add(this.tfUserGood);
    this.panelTop.add(this.tfPwdGood);
    this.panelTop.add(this.btnExchange);
    this.btnExchange.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String ipGood = MainFrame.this.tfIpGood.getText();
        String portGood = MainFrame.this.tfPortGood.getText();
        String dbGood = MainFrame.this.tfDbGood.getText();
        String userGood = MainFrame.this.tfUserGood.getText();
        String pwdGood = MainFrame.this.tfPwdGood.getText();

        String ipBad = MainFrame.this.tfIpBad.getText();
        String portBad = MainFrame.this.tfPortBad.getText();
        String dbBad = MainFrame.this.tfDbBad.getText();
        String userBad = MainFrame.this.tfUserBad.getText();
        String pwdBad = MainFrame.this.tfPwdBad.getText();

        MainFrame.this.tfIpGood.setText(ipBad);
        MainFrame.this.tfPortGood.setText(portBad);
        MainFrame.this.tfDbGood.setText(dbBad);
        MainFrame.this.tfUserGood.setText(userBad);
        MainFrame.this.tfPwdGood.setText(pwdBad);

        MainFrame.this.tfIpBad.setText(ipGood);
        MainFrame.this.tfPortBad.setText(portGood);
        MainFrame.this.tfDbBad.setText(dbGood);
        MainFrame.this.tfUserBad.setText(userGood);
        MainFrame.this.tfPwdBad.setText(pwdGood);
      }
    });
    this.panelTop.add(this.tfIpBad);
    this.panelTop.add(this.tfPortBad);
    this.panelTop.add(this.tfDbBad);
    this.panelTop.add(this.tfUserBad);
    this.panelTop.add(this.tfPwdBad);
    this.panelTop.add(this.btnAction);

    font = new Font("宋体", 2, 14);
    this.textArea.setFont(font);
    this.btnAction.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new Thread(() -> {
          Connection connRight = null;
          Connection connWrong = null;
          try {
            DbCfg right = new DbCfg(
                "jdbc:mysql://" + MainFrame.this.tfIpGood.getText() + ":"
                    + MainFrame.this.tfPortBad.getText() + "/" + MainFrame.this.tfDbGood.getText(),
                MainFrame.this.tfUserGood.getText(), MainFrame.this.tfPwdGood.getText());

            DbCfg wrong = new DbCfg(
                "jdbc:mysql://" + MainFrame.this.tfIpBad.getText() + ":"
                    + MainFrame.this.tfPortBad.getText() + "/" + MainFrame.this.tfDbBad.getText(),
                MainFrame.this.tfUserBad.getText(), MainFrame.this.tfPwdBad.getText());

            connRight = Util.getConn(right);
            connWrong = Util.getConn(wrong);
            Set<String> set = Util.compare(connRight, connWrong);
            StringBuilder sb = new StringBuilder();

            for (String str : set) {
              sb.append(str).append(System.lineSeparator());
            }
            MainFrame.this.textArea.setText(sb.toString());
          } catch (Exception e2) {
            e2.printStackTrace();
            MainFrame.this.textArea.setText(e2.toString());
            JOptionPane.showMessageDialog(MainFrame.this, "出错了！你是猴子请来的逗比吗？？");
          } finally {
            Util.close(connRight);
            Util.close(connWrong);
          }
        }).start();
        MainFrame.this.textArea.setText("执行中，请等待。。。");
      }
    });
    this.textArea.setLineWrap(true);
    this.textArea.setWrapStyleWord(true);
    this.textArea.setBackground(new Color(204, 232, 207));

    this.panelBottom.add(new JScrollPane(this.textArea));

    BorderLayout borderlayOut = new BorderLayout();
    setLayout(borderlayOut);

    add(this.panelTop, BorderLayout.NORTH);
    add(this.panelBottom, BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        MainFrame mf = new MainFrame();
        mf.setTitle("数据库对比工具");
        mf.setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
        mf.setLocation(10, 5);
        mf.setDefaultCloseOperation(3);
        mf.setIconImage(
            Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/res/mysql.png")));
        mf.setResizable(false);
        mf.setVisible(true);
      }
    });
  }
}
