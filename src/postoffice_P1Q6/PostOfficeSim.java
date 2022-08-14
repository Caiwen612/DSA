package postoffice_P1Q6;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * PostOfficeSim.java A client program that uses 
 *    - the List ADT to store the collection of audio clips for the numbers
 *      0 to 9, and also the word "Counter"
 *    - the Queue ADT to store the customer objects that represent the customers
 *      waiting to be served at the post office.
 *    - the List ADT to store the customer objects that have been served. This
 *      list is used to generate the analysis report.
 *
 * @author Kat Tan
 * @version 2.0
 */
public class PostOfficeSim extends javax.swing.JFrame {
    private JTextField[] jtfDisplayRowArr = new JTextField[4];
    private String callString = " --> Counter ";
    private CounterListener counterListener = new CounterListener();
    private static int nextNumber = 1001;
    private int currentNo = nextNumber - 1;
    private ArrayList<AudioClip> audioClips = new ArrayList<AudioClip>();
    private Queue<Customer> q = new ArrayBlockingQueue<Customer>(100);
    private ArrayList<Customer> serviceList = new ArrayList<Customer>();
    private String counterStr = "Counter ";
    private int counterNoIndex = counterStr.length();

    //Create 5 counter
    private Queue<Customer> counter1 = new LinkedList<Customer>();
    private Queue<Customer> counter2 = new LinkedList<Customer>();
    private Queue<Customer> counter3 = new LinkedList<Customer>();
    private Queue<Customer> counter4 = new LinkedList<Customer>();
    private Queue<Customer> counter5 = new LinkedList<Customer>();

    /**
     * Creates new form PostOfficeSim
     */
    public PostOfficeSim() {
        initComponents();
        initializeAudio();
        initializeDisplay();
    }

    private void initializeDisplay() {
        jtfDisplayRowArr[0] = jtfRow1;
        jtfDisplayRowArr[1] = jtfRow2;
        jtfDisplayRowArr[2] = jtfRow3;
        jtfDisplayRowArr[3] = jtfRow4;
    }

    private void initializeAudio() {
        for (int i = 0; i <= 9; ++i) {
            String url = "sounds/" + i + ".wav";
            audioClips.add(Applet.newAudioClip(this.getClass().getResource(url)));
        }
        String url = "sounds/counter.wav";
        audioClips.add(Applet.newAudioClip(this.getClass().getResource(url)));
    }

    private void announceNumber(Customer s) {
        int sleepTime = 700;
        String numStr = String.valueOf(s.getSeqNo());
        try {
            for (int i = 0; i < numStr.length(); ++i) {
                Thread.sleep(sleepTime);
                int num = numStr.charAt(i) - '0';
                audioClips.get(num).play();
            }

            Thread.sleep(sleepTime);
            audioClips.get(audioClips.size() - 1).play();
            Thread.sleep(sleepTime);
            audioClips.get(s.getCounter()).play();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void updateDisplay(Customer s) {
        for (int i = jtfDisplayRowArr.length - 1; i > 0; i--) {
            jtfDisplayRowArr[i].setText(jtfDisplayRowArr[i - 1].getText());
        }
        jtfDisplayRowArr[0].setText(s.getSeqNo() + callString + s.getCounter());
        currentNo++;
    }

    private class CounterListener implements ActionListener {

        //TODO: Press counter button to release customer
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "Counter 1":
                    System.out.println("Counter 1 button has been pressed");
                    Customer customer1 = counter1.remove();
                    //Set end times for customer.
                    customer1.setServeTime(new GregorianCalendar());
                    //add finisher customer to service list for display result.
                    serviceList.add(customer1);
                    //put next customer into this counter.
                    checkQueue();
                    break;
                case "Counter 2":
                    System.out.println("Counter 2 button has been pressed");
                    Customer customer2 = counter2.remove();
                    customer2.setServeTime(new GregorianCalendar());
                    serviceList.add(customer2);
                    checkQueue();
                    break;
                case "Counter 3":
                    System.out.println("Counter 3 button has been pressed");
                    Customer customer3 = counter3.remove();
                    customer3.setServeTime(new GregorianCalendar());
                    serviceList.add(customer3);
                    checkQueue();
                    break;
                case "Counter 4":
                    System.out.println("Counter 4 button has been pressed");
                    Customer customer4 = counter4.remove();
                    customer4.setServeTime(new GregorianCalendar());
                    serviceList.add(customer4);
                    checkQueue();
                    break;
                case "Counter 5":
                    System.out.println("Counter 5 button has been pressed");
                    Customer customer5 = counter5.remove();
                    customer5.setServeTime(new GregorianCalendar());
                    serviceList.add(customer5);
                    checkQueue();
                    break;
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbtCounter1 = new javax.swing.JButton();
        jbtCounter2 = new javax.swing.JButton();
        jbtCounter3 = new javax.swing.JButton();
        jbtCounter4 = new javax.swing.JButton();
        jbtReport = new javax.swing.JButton();
        jbtCounter5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jbtTakeNumber = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jtfRow1 = new javax.swing.JTextField();
        jtfRow2 = new javax.swing.JTextField();
        jtfRow4 = new javax.swing.JTextField();
        jtfRow3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaSlip = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Post Office Simulation");

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Staff UI");

        jbtCounter1.setBackground(new java.awt.Color(153, 255, 255));
        jbtCounter1.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        jbtCounter1.setText("Counter 1");
        jbtCounter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCounter1ActionPerformed(evt);
            }
        });

        jbtCounter2.setBackground(new java.awt.Color(153, 255, 255));
        jbtCounter2.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        jbtCounter2.setText("Counter 2");
        jbtCounter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCounter2ActionPerformed(evt);
            }
        });

        jbtCounter3.setBackground(new java.awt.Color(153, 255, 255));
        jbtCounter3.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        jbtCounter3.setText("Counter 3");
        jbtCounter3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCounter3ActionPerformed(evt);
            }
        });

        jbtCounter4.setBackground(new java.awt.Color(153, 255, 255));
        jbtCounter4.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        jbtCounter4.setText("Counter 4");
        jbtCounter4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCounter4ActionPerformed(evt);
            }
        });

        jbtReport.setBackground(new java.awt.Color(153, 255, 255));
        jbtReport.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        jbtReport.setText("Analysis  Report");
        jbtReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtReportActionPerformed(evt);
            }
        });

        jbtCounter5.setBackground(new java.awt.Color(153, 255, 255));
        jbtCounter5.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        jbtCounter5.setText("Counter 5");
        jbtCounter5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCounter5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtCounter1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtCounter2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtCounter3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtCounter4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jbtCounter5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jbtCounter1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtCounter2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtCounter3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtCounter4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtCounter5)
                .addGap(11, 11, 11)
                .addComponent(jbtReport, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Customer UI");

        jbtTakeNumber.setBackground(new java.awt.Color(51, 153, 255));
        jbtTakeNumber.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        jbtTakeNumber.setText("Take a number");
        jbtTakeNumber.setToolTipText("Press this button to get a number.");
        jbtTakeNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtTakeNumberActionPerformed(evt);
            }
        });

        jtfRow1.setEditable(false);
        jtfRow1.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jtfRow1.setForeground(new java.awt.Color(255, 51, 51));
        jtfRow1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfRow1.setText("-----");

        jtfRow2.setEditable(false);
        jtfRow2.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        jtfRow2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfRow2.setText("-----");
        jtfRow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfRow2ActionPerformed(evt);
            }
        });

        jtfRow4.setEditable(false);
        jtfRow4.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        jtfRow4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfRow4.setText("-----");
        jtfRow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfRow4ActionPerformed(evt);
            }
        });

        jtfRow3.setEditable(false);
        jtfRow3.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        jtfRow3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfRow3.setText("-----");
        jtfRow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfRow3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfRow4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfRow3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfRow2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(jtfRow1))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jtfRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfRow2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfRow3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfRow4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtaSlip.setEditable(false);
        jtaSlip.setColumns(20);
        jtaSlip.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        jtaSlip.setForeground(new java.awt.Color(102, 0, 204));
        jtaSlip.setRows(5);
        jScrollPane1.setViewportView(jtaSlip);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jbtTakeNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtTakeNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtReportActionPerformed
        JTextArea jtaReport = new JTextArea(50, 200);
        String str = String.format("%70s\n", "Service Analysis Report");
        str += String.format("%-5s %-10s %-20s %-20s %-15s %-15s\n",
                "No", "Seq. No", "Arr. Time (ms)", "Serve Time(ms)", "Counter", "Waiting Time(s)");


        Font reportFont = new Font("Arial", Font.BOLD, 14);
        jtaReport.setText(str);
        jtaReport.setEditable(false);
        jtaReport.setFont(reportFont);
        JFrame reportFrame = new JFrame();
        reportFrame.add(jtaReport);
        reportFrame.setSize(600, 800);
        reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        reportFrame.setVisible(true);
    }//GEN-LAST:event_jbtReportActionPerformed

    private void jbtCounter5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCounter5ActionPerformed
        counterListener.actionPerformed(evt);
    }//GEN-LAST:event_jbtCounter5ActionPerformed

    //TODO: Display number and assign customer to counter
    private void jbtTakeNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtTakeNumberActionPerformed
        System.out.println("Take a number Button has been press");
        jtaSlip.setText("Your number: " + nextNumber);
        Customer newCustomer = new Customer(nextNumber);
        q.offer(newCustomer);//add customer to queue
        nextNumber++;//increase next number
        //Add customer to counter queue
        checkQueue();

    }//GEN-LAST:event_jbtTakeNumberActionPerformed

    //TODO: Check whether any counter have empty space or not, If got put in customer.
    private void checkQueue(){
        if(counter1.isEmpty() || counter2.isEmpty() || counter3.isEmpty() || counter4.isEmpty() || counter5.isEmpty() ) {
            if (!q.isEmpty()) {
                Customer customer = q.remove();
                if (customer.getCounter() == 0) {
                    if (counter1.isEmpty()) {
                        counter1.add(customer);
                        customer.setCounter(1);
                        announceNumber(customer);
                        updateDisplay(customer);
                    } else if (counter2.isEmpty()) {
                        counter2.add(customer);
                        customer.setCounter(2);
                        announceNumber(customer);
                        updateDisplay(customer);
                    } else if (counter3.isEmpty()) {
                        counter3.add(customer);
                        customer.setCounter(3);
                        announceNumber(customer);
                        updateDisplay(customer);
                    } else if (counter4.isEmpty()) {
                        counter4.add(customer);
                        customer.setCounter(4);
                        announceNumber(customer);
                        updateDisplay(customer);
                    } else if (counter5.isEmpty()) {
                        counter5.add(customer);
                        customer.setCounter(5);
                        announceNumber(customer);
                        updateDisplay(customer);
                    }
                }
            }
        }
    }

    private void jtfRow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfRow2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfRow2ActionPerformed

    private void jtfRow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfRow4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfRow4ActionPerformed

    private void jtfRow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfRow3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfRow3ActionPerformed

    private void jbtCounter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCounter1ActionPerformed
        counterListener.actionPerformed(evt);
    }//GEN-LAST:event_jbtCounter1ActionPerformed

    private void jbtCounter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCounter2ActionPerformed
        counterListener.actionPerformed(evt);
    }//GEN-LAST:event_jbtCounter2ActionPerformed

    private void jbtCounter3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCounter3ActionPerformed
        counterListener.actionPerformed(evt);
    }//GEN-LAST:event_jbtCounter3ActionPerformed

    private void jbtCounter4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCounter4ActionPerformed
        counterListener.actionPerformed(evt);
    }//GEN-LAST:event_jbtCounter4ActionPerformed

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
            java.util.logging.Logger.getLogger(PostOfficeSim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PostOfficeSim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PostOfficeSim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PostOfficeSim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PostOfficeSim().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtCounter1;
    private javax.swing.JButton jbtCounter2;
    private javax.swing.JButton jbtCounter3;
    private javax.swing.JButton jbtCounter4;
    private javax.swing.JButton jbtCounter5;
    private javax.swing.JButton jbtReport;
    private javax.swing.JButton jbtTakeNumber;
    private javax.swing.JTextArea jtaSlip;
    private javax.swing.JTextField jtfRow1;
    private javax.swing.JTextField jtfRow2;
    private javax.swing.JTextField jtfRow3;
    private javax.swing.JTextField jtfRow4;
    // End of variables declaration//GEN-END:variables
}
