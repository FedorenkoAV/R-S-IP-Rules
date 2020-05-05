/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r_s_ip_rules;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Fedorenko Aleksandr
 */
public class RSIPRules extends javax.swing.JFrame {

    private static final String TAG = "MainActivity"; //NOI18N

    int cats[] = {225, 1, 33, 65, 97, 129, 161, 193};
    int equipment[] = {0, 1, 10, 11, 12, 13, 14, 15, 16, 17, 0};
    String[] arrEquipment = {java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("BSCU 1"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("BSCU 2"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("CHU 1"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("CHU 2"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("CHU 3"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("CHU 4"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("CHU 5"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("CHU 6"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("CHU 7"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("CHU 8"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("CAVITY COMBINER")};
    String[] ipnList = {java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("SCN"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("DVRS"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("DWS"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("NDB"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("NMS-CLIENT1"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("NMS-CLIENT2"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("DVRS-CLIENT"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("DWS-CLIENT"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("IP SWITCH"),};
    String[] bs_ipn_selector = { java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("BS NUMBER"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("IPN NUMBER") };
    String[] choose;
    int selectedItem;

    ArrayList<Image> imageList;

    /**
     * Creates new form RSIPRules
     */
    public RSIPRules() {
        Image img1 = new ImageIcon(this.getClass().getResource("icons/icons8-интернет-центр-16.png")).getImage(); //NOI18N
        Image img2 = new ImageIcon(this.getClass().getResource("icons/icons8-интернет-центр-32.png")).getImage(); //NOI18N
        Image img3 = new ImageIcon(this.getClass().getResource("icons/icons8-интернет-центр-48.png")).getImage(); //NOI18N
        Image img4 = new ImageIcon(this.getClass().getResource("icons/icons8-интернет-центр-96.png")).getImage(); //NOI18N
        Image img5 = new ImageIcon(this.getClass().getResource("icons/icons8-интернет-центр-256.png")).getImage(); //NOI18N
        
//        Image img1 = new ImageIcon(this.getClass().getResource("icons/icons8-распределитель-нагрузки-16.png")).getImage();
//        Image img2 = new ImageIcon(this.getClass().getResource("icons/icons8-распределитель-нагрузки-32.png")).getImage();
//        Image img3 = new ImageIcon(this.getClass().getResource("icons/icons8-распределитель-нагрузки-48.png")).getImage();
//        Image img4 = new ImageIcon(this.getClass().getResource("icons/icons8-распределитель-нагрузки-96.png")).getImage();
//        Image img5 = new ImageIcon(this.getClass().getResource("icons/icons8-распределитель-нагрузки-256.png")).getImage();

        imageList = new ArrayList<>();
        imageList.add(img1);
        imageList.add(img2);
        imageList.add(img3);
        imageList.add(img4);
        imageList.add(img5);
        
        initComponents();
        spinnerBS_IPN_selector.setSelectedIndex(0);
        
        
    }

    void findIP() {
//        String resultString;
        int bs;
        try {
            bs = Integer.parseInt(etBSNum.getText());
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, etBSNum.getText() + java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString(" NOT A NUMBER."), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
            return;
        }
//        Log.d(TAG, "bs = " + bs);
        int num3 = 0;
        int num4 = 0;
        switch (selectedItem) {
            case 0:
                if (bs > 1233 || bs < 1) {
                    javax.swing.JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("1 <= BS <= 1233"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
                    etNumber3.setText(""); //NOI18N
                    etNumber4.setText(""); //NOI18N
                    return;
                }
                num3 = 101 + (bs - 1) / 8;
                int equ = equipment[spinnerEqu.getSelectedIndex()];
                num4 = equ + cats[(bs % 8)];
                break;
            case 1:
                if (bs > 22 || bs < 1) {
                    javax.swing.JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("1 <= IPN <= 22"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
                    etNumber3.setText(""); //NOI18N
                    etNumber4.setText(""); //NOI18N
                    return;
                }
                num3 = bs;
                int selectedIPN = spinnerEqu.getSelectedIndex();
                switch (selectedIPN) {
                    case 0:
                        num4 = 1;
                        break;
                    case 1:
                        num4 = 31;
                        break;
                    case 2:
                        num4 = 32;
                        break;
                    case 3:
                        num4 = 62;
                        break;
                    case 4:
                        num4 = 101;
                        break;
                    case 5:
                        num4 = 102;
                        break;
//                    case "NMS-Client3":
//                        num4 = 225;
//                        break;
                    case 6:
                        num4 = 111;
                        break;
                    case 7:
                        num4 = 112;
                        break;
                    case 8:
                        num4 = 253;
                        break;
                }
                break;
        }
        etNumber1.setText(etFirstIPNum.getText());
        etNumber2.setText(etSecondIPNum.getText());
        etNumber3.setText(num3 + ""); //NOI18N
        etNumber4.setText(num4 + ""); //NOI18N

    }

    void findEqu() {
        //Log.d(TAG, "findEqu start");
        int ipNum3 = 0;
        int ipNum4 = 0;
        try {
            ipNum3 = Integer.parseInt(etNumber3.getText());
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, etNumber3.getText() + java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString(" NOT A NUMBER."), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
        }
        //Log.d(TAG, "int Number3 = " + ipNum3);
        try {
            ipNum4 = Integer.parseInt(etNumber4.getText());
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, etNumber4.getText() + java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString(" NOT A NUMBER."), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
        }
        //Log.d(TAG, "int Number4 = " + ipNum4);
        int equNum;
        if (spinnerBS_IPN_selector.getSelectedItem().toString().equals(java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("IPN NUMBER"))) {
            StringBuilder ipn = new StringBuilder(""); //NOI18N
            if (ipNum3 % 2 == 0) {
                ipn.append(java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("IPN-2 "));
            } else {
                ipn.append(java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("IPN-1 "));
            }
            switch (ipNum4) {
                case 1:
                    ipn.append(java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("SCN"));
                    break;
                case 31:
                    ipn.append(java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("DVRS"));
                    break;
                case 32:
                    ipn.append(java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("DWS"));
                    break;
                case 62:
                    ipn.append(java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("NDB"));
                    break;
                case 101:
                    ipn.append(java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("NMS-CLIENT1"));
                    break;
                case 102:
                    ipn.append(java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("NMS-CLIENT2"));
                    break;
                case 225:
                    ipn.append(java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("NMS-CLIENT3"));
                    break;
                case 111:
                    ipn.append(java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("DVRS-CLIENT"));
                    break;
                case 112:
                    ipn.append(java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("DWS-CLIENT"));
                    break;
                case 253:
                    ipn.append(java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("IP SWITCH"));
                    break;
            }
            tvCalcEqu.setText(ipn.toString());            
        } else {
            int bs = (ipNum3 - 101) * 8 + 1;

            if (ipNum4 > 224) {
                equNum = ipNum4 - 225;
                bs += 7;
            } else if (ipNum4 > 192) {
                equNum = ipNum4 - 193;
                bs += 6;
            } else if (ipNum4 > 160) {
                equNum = ipNum4 - 161;
                bs += 5;
            } else if (ipNum4 > 128) {
                equNum = ipNum4 - 129;
                bs += 4;
            } else if (ipNum4 > 96) {
                equNum = ipNum4 - 97;
                bs += 3;
            } else if (ipNum4 > 64) {
                equNum = ipNum4 - 65;
                bs += 2;
            } else if (ipNum4 > 32) {
                equNum = ipNum4 - 33;
                bs += 1;
            } else {
                equNum = ipNum4 - 1;
            }
            if (equNum > 17 || equNum < 0) {
                equNum = 2;
            }
            //Log.d(TAG, "equNum = " + equNum);
            //Log.d(TAG, "bs = " + bs);
//            String[] arrEquipment = getResources().getStringArray(R.array.equList);
            String strEquipment = java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("UNDEFINED EQUIPMENT");
            switch (equNum) {
                case 0:
                    strEquipment = arrEquipment[0];
                    break;
                case 1:
                    strEquipment = arrEquipment[1];
                    break;
                case 10:
                    strEquipment = arrEquipment[2];
                    break;
                case 11:
                    strEquipment = arrEquipment[3];
                    break;
                case 12:
                    strEquipment = arrEquipment[4];
                    break;
                case 13:
                    strEquipment = arrEquipment[5];
                    break;
                case 14:
                    strEquipment = arrEquipment[6];
                    break;
                case 15:
                    strEquipment = arrEquipment[7];
                    break;
                case 16:
                    strEquipment = arrEquipment[8];
                    break;
                case 17:
                    strEquipment = arrEquipment[9];
                    break;

            }
            String result = java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("BS");            
            tvCalcEqu.setText(result + bs + " " + strEquipment); //NOI18N
            
        }
    }

    String pasteFromClipboard() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable clipData = clipboard.getContents(null);
        String pasteString = ""; //NOI18N
        if (clipData.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                pasteString = (String) clipData.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException ex) {

            }
        }
        return pasteString;
    }

    /*
    Здесь копируем в буфер обмена переданную строку 
     */
    void copyToClipboard(String copyString) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection clipData;
        clipData = new StringSelection(copyString);
        clipboard.setContents(clipData, clipData);
    }
    
    boolean isNumber (String str) {
        boolean result = false;
        try {            
            int num = Integer.parseInt(str);
            if (num >= 0 && num < 255) {
                result = true;
            }            
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, str + java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString(" NOT A NUMBER."), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItemCopyIP = new javax.swing.JMenuItem();
        jMenuItemPasteIP = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItemCopy = new javax.swing.JMenuItem();
        jMenuItemPaste = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spinnerBS_IPN_selector = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        spinnerEqu = new javax.swing.JComboBox<>();
        btCalcIP = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tvCalcEqu = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        etFirstIPNum = new javax.swing.JFormattedTextField();
        etSecondIPNum = new javax.swing.JFormattedTextField();
        etBSNum = new javax.swing.JFormattedTextField();
        etNumber1 = new javax.swing.JFormattedTextField();
        etNumber2 = new javax.swing.JFormattedTextField();
        etNumber3 = new javax.swing.JFormattedTextField();
        etNumber4 = new javax.swing.JFormattedTextField();

        jMenuItemCopyIP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r_s_ip_rules/icons/copy.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules"); // NOI18N
        jMenuItemCopyIP.setText(bundle.getString("COPY IP ADDRESS")); // NOI18N
        jMenuItemCopyIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCopyIPActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemCopyIP);

        jMenuItemPasteIP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r_s_ip_rules/icons/paste.png"))); // NOI18N
        jMenuItemPasteIP.setText(bundle.getString("PASTE IP ADDRESS")); // NOI18N
        jMenuItemPasteIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPasteIPActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemPasteIP);

        jMenuItemCopy.setText(bundle.getString("COPY")); // NOI18N
        jMenuItemCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCopyActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItemCopy);

        jMenuItemPaste.setText(bundle.getString("PASTE")); // NOI18N
        jPopupMenu2.add(jMenuItemPaste);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(bundle.getString("RSIPRules.title")); // NOI18N
        setIconImages(imageList);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setComponentPopupMenu(jPopupMenu1);

        jLabel1.setText(bundle.getString("FIRST IP NUMBER")); // NOI18N

        jLabel2.setText(bundle.getString("SECOND IP NUMBER")); // NOI18N

        spinnerBS_IPN_selector.setModel(new javax.swing.DefaultComboBoxModel<>(bs_ipn_selector));
        spinnerBS_IPN_selector.setComponentPopupMenu(jPopupMenu1);
        spinnerBS_IPN_selector.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                spinnerBS_IPN_selectorItemStateChanged(evt);
            }
        });
        spinnerBS_IPN_selector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spinnerBS_IPN_selectorActionPerformed(evt);
            }
        });

        jLabel3.setText(bundle.getString("EQUIPMENT")); // NOI18N

        spinnerEqu.setMaximumRowCount(11);
        spinnerEqu.setToolTipText(bundle.getString("RSIPRules.spinnerEqu.toolTipText")); // NOI18N
        spinnerEqu.setComponentPopupMenu(jPopupMenu1);

        btCalcIP.setText(bundle.getString("CALCULATE IP")); // NOI18N
        btCalcIP.setComponentPopupMenu(jPopupMenu1);
        btCalcIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcIPActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(java.awt.Color.red);
        jLabel4.setText(bundle.getString("IP ADDRESS:")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(java.awt.Color.red);
        jLabel5.setText(bundle.getString("RSIPRules.jLabel5.text")); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(java.awt.Color.red);
        jLabel6.setText(bundle.getString("RSIPRules.jLabel6.text")); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(java.awt.Color.red);
        jLabel7.setText(bundle.getString("RSIPRules.jLabel7.text")); // NOI18N

        btnFind.setText(bundle.getString("FIND EQUIPMENT")); // NOI18N
        btnFind.setComponentPopupMenu(jPopupMenu1);
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(java.awt.Color.red);
        jLabel8.setText(bundle.getString("EQUIPMENT:")); // NOI18N

        tvCalcEqu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tvCalcEqu.setForeground(java.awt.Color.red);

        jLabel10.setText(bundle.getString("©FEDORENKO ALEKSANDR")); // NOI18N

        etFirstIPNum.setColumns(3);
        etFirstIPNum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        etFirstIPNum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        etFirstIPNum.setText(bundle.getString("RSIPRules.etFirstIPNum.text")); // NOI18N
        etFirstIPNum.setToolTipText(bundle.getString("RSIPRules.etFirstIPNum.toolTipText")); // NOI18N

        etSecondIPNum.setColumns(3);
        etSecondIPNum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        etSecondIPNum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        etSecondIPNum.setText(bundle.getString("RSIPRules.etSecondIPNum.text")); // NOI18N
        etSecondIPNum.setToolTipText(bundle.getString("RSIPRules.etSecondIPNum.toolTipText")); // NOI18N

        etBSNum.setColumns(3);
        etBSNum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        etBSNum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        etBSNum.setText(bundle.getString("RSIPRules.etBSNum.text")); // NOI18N

        etNumber1.setColumns(2);
        etNumber1.setForeground(java.awt.Color.red);
        etNumber1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        etNumber1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        etNumber1.setComponentPopupMenu(jPopupMenu1);
        etNumber1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        etNumber2.setColumns(2);
        etNumber2.setForeground(java.awt.Color.red);
        etNumber2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        etNumber2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        etNumber2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        etNumber3.setColumns(3);
        etNumber3.setForeground(java.awt.Color.red);
        etNumber3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        etNumber3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        etNumber3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        etNumber4.setColumns(3);
        etNumber4.setForeground(java.awt.Color.red);
        etNumber4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        etNumber4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        etNumber4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCalcIP)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnFind)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(tvCalcEqu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(spinnerBS_IPN_selector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etFirstIPNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etSecondIPNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etBSNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerEqu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {etBSNum, etFirstIPNum, etSecondIPNum});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(etFirstIPNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(etSecondIPNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerBS_IPN_selector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etBSNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinnerEqu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btCalcIP)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(etNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(etNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(etNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(etNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnFind)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tvCalcEqu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spinnerBS_IPN_selectorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_spinnerBS_IPN_selectorItemStateChanged
        // TODO add your handling code here:
//        selectedItem = evt.getItem().toString();
//        //Log.d(TAG, "selectedItem:  " + selectedItem);
//        ComboBoxModel aModel = new ComboBoxModel ();
//        switch (selectedItem) {
//                    case "BS Number":
//                        spinnerEqu.setModel(aModel);
//                        break;
//                    case "IPN Number":                        
//                        break;
//                }
    }//GEN-LAST:event_spinnerBS_IPN_selectorItemStateChanged

    private void spinnerBS_IPN_selectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spinnerBS_IPN_selectorActionPerformed
        // TODO add your handling code here:
        JComboBox box = (JComboBox) evt.getSource();
        selectedItem = box.getSelectedIndex();
        //Log.d(TAG, "selectedItem: " + selectedItem);
        switch (selectedItem) {
            case 0://                        
                spinnerEqu.setModel(new javax.swing.DefaultComboBoxModel<>(arrEquipment));
                break;
            case 1:
                spinnerEqu.setModel(new javax.swing.DefaultComboBoxModel<>(ipnList));
                break;
        }

    }//GEN-LAST:event_spinnerBS_IPN_selectorActionPerformed

    private void btCalcIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcIPActionPerformed
        // TODO add your handling code here:
        findIP();        
    }//GEN-LAST:event_btCalcIPActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        findEqu();
    }//GEN-LAST:event_btnFindActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void jMenuItemCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCopyActionPerformed
        // TODO add your handling code here:

        //Log.d(TAG, "Source: " + evt.getClass().getCanonicalName());

    }//GEN-LAST:event_jMenuItemCopyActionPerformed

    private void jMenuItemCopyIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCopyIPActionPerformed
        // TODO add your handling code here:
        StringBuilder ipStringBuilder = new StringBuilder (etNumber1.getText());
        ipStringBuilder.append("."); //NOI18N
        ipStringBuilder.append(etNumber2.getText());
        ipStringBuilder.append("."); //NOI18N
        ipStringBuilder.append(etNumber3.getText());
        ipStringBuilder.append("."); //NOI18N
        ipStringBuilder.append(etNumber4.getText());
        copyToClipboard (ipStringBuilder.toString());
        //Log.d(TAG, "В буфер обмена помещен IP адрес: " + ipStringBuilder);
    }//GEN-LAST:event_jMenuItemCopyIPActionPerformed

    private void jMenuItemPasteIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPasteIPActionPerformed
        // TODO add your handling code here:
        String ipString = pasteFromClipboard().trim();        
        String [] ipStringArray = ipString.split("\\.");// Здесь "\\." потому что "." означает не точку, а любой символ         //NOI18N
        if (ipStringArray.length != 4) {
            javax.swing.JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("WRONG IP-ADDRESS"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (String currentIP : ipStringArray) {
            if (!isNumber(currentIP)) {
                javax.swing.JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("WRONG IP-ADDRESS"), java.util.ResourceBundle.getBundle("r_s_ip_rules/RSIPRules").getString("ERROR"), JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        etNumber1.setText(ipStringArray[0]);
        etNumber2.setText(ipStringArray[1]);
        etNumber3.setText(ipStringArray[2]);
        etNumber4.setText(ipStringArray[3]);
    }//GEN-LAST:event_jMenuItemPasteIPActionPerformed

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
                if ("Windows Classic".equals(info.getName())) { //NOI18N
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RSIPRules.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                RSIPRules myApp = new RSIPRules();
                myApp.setLocationRelativeTo(null);
                myApp.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCalcIP;
    private javax.swing.JButton btnFind;
    private javax.swing.JFormattedTextField etBSNum;
    private javax.swing.JFormattedTextField etFirstIPNum;
    private javax.swing.JFormattedTextField etNumber1;
    private javax.swing.JFormattedTextField etNumber2;
    private javax.swing.JFormattedTextField etNumber3;
    private javax.swing.JFormattedTextField etNumber4;
    private javax.swing.JFormattedTextField etSecondIPNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItemCopy;
    private javax.swing.JMenuItem jMenuItemCopyIP;
    private javax.swing.JMenuItem jMenuItemPaste;
    private javax.swing.JMenuItem jMenuItemPasteIP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JComboBox<String> spinnerBS_IPN_selector;
    private javax.swing.JComboBox<String> spinnerEqu;
    private javax.swing.JLabel tvCalcEqu;
    // End of variables declaration//GEN-END:variables
}
