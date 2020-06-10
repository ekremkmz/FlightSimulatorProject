public class systemTime extends javax.swing.JFrame {

    public systemTime(String title) {
        super(title);
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        saat = new javax.swing.JTextField();
        apply = new javax.swing.JButton();
        gunCombo = new javax.swing.JComboBox<>();
        messageYeri = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Saat:");

        jLabel2.setText("Tarih:");

        saat.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        saat.setText("0900");
        

        apply.setText("Ayarla");
        apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyActionPerformed(evt);
            }
        });

        gunCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pazartesi", "Sali", "Carsamba", "Persembe", "Cuma", "Cumartesi", "Pazar" }));

        messageYeri.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageYeri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(apply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gunCombo, 0, 252, Short.MAX_VALUE)
                            .addComponent(saat))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(saat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(gunCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageYeri, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apply)
                .addContainerGap())
        );

        pack();
    }
    
    private void applyActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            if(Integer.parseInt(saat.getText())%100 >= 60||Integer.parseInt(saat.getText())>=2400 || Integer.parseInt(saat.getText()) < 0 ){
                messageYeri.setText("Hatali saat girdisi!!!");
                return;
            }
        }
        catch(Exception e){
                messageYeri.setText("Hatali saat girdisi!!!");
                return;
            }
        FlightSim.saat = saat.getText();
        FlightSim.sistemGunu = gunler.valueOf(gunCombo.getSelectedItem().toString());
        FlightSim.zamanGuncelle();
    }

    private javax.swing.JButton apply;
    private javax.swing.JComboBox<String> gunCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel messageYeri;
    private javax.swing.JTextField saat;
}
