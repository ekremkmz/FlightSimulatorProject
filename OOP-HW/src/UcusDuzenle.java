import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class UcusDuzenle extends javax.swing.JFrame {
    
    ArrayList<String> sehirListesi ;
    ArrayList<String> ucakListesi ;
    ArrayList<ucus_bilgileri> ucusListesi;
    public UcusDuzenle(String title,ArrayList<String> sehirListesi,ArrayList<String> ucakListesi,ArrayList<ucus_bilgileri> ucusListesi) throws HeadlessException {    
        super(title);
        initComponents();
        this.sehirListesi = sehirListesi;
        for (String s : sehirListesi) {
            konumCombo.addItem(s);
        }
        this.ucakListesi = ucakListesi;
        for (String s : ucakListesi) {
            ucakCombo.addItem(s);
        }
        this.ucusListesi = ucusListesi;
        ucusListesiGuncelle();
    }

    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        konumCombo = new javax.swing.JComboBox<>();
        hedefCombo = new javax.swing.JComboBox<>();
        ucakCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Firma = new javax.swing.JTextField();
        kalkisSaati = new javax.swing.JTextField();
        inisSaati = new javax.swing.JTextField();
        ucusNo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        UcusTablosu = new javax.swing.JTable();
        add = new javax.swing.JButton();
        messageYeri = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        gunCombo = new javax.swing.JComboBox<>();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        konumCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konumComboActionPerformed(evt);
            }
        });

        jLabel1.setText("Baslangic:");

        jLabel2.setText("Hedef:");

        jLabel3.setText("Gun:");

        jLabel5.setText("Firma:");

        jLabel6.setText("Kalkis Saati:");

        jLabel7.setText("Inis Saati:");

        jLabel9.setText("Ucak:");

        jLabel8.setText("Ucus No:");

        Firma.setText("Turkish Airlines");

        kalkisSaati.setText("0900");

        inisSaati.setText("1200");

        ucusNo.setText("000001");

        UcusTablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Durum", "Baslangıc", "Hedef", "Gun", "Firma", "Ucak", "Kalkis saati", "Inis Saati", "Ucus No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(UcusTablosu);

        add.setText("Ucus Ekle");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        messageYeri.setForeground(new java.awt.Color(255, 0, 51));

        delete.setText("Ucus Sil");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        gunCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pazartesi", "Sali", "Carsamba", "Persembe", "Cuma", "Cumartesi", "Pazar" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(konumCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(hedefCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gunCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(messageYeri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Firma, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(ucakCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(kalkisSaati, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(inisSaati, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(ucusNo)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(konumCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hedefCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Firma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kalkisSaati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inisSaati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ucusNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ucakCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gunCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(messageYeri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(delete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void konumComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konumComboActionPerformed
        hedefCombo.removeAllItems();
        for (String s : sehirListesi) {
            if(!konumCombo.getSelectedItem().equals(s)){
                hedefCombo.addItem(s);
            }
        }    
    }

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
        if(Firma.getText().trim().equals("")){
            messageYeri.setText("Firma ismi bos olamaz");
            return;
        }
        if(inisSaati.getText().trim().equals("")){
            messageYeri.setText("Inis saati bos olamaz");
            return;
        }
        if(kalkisSaati.getText().trim().equals("")){
            messageYeri.setText("Kalkis saati bos olamaz");
            return;
        }
        try{
            if(Integer.parseInt(kalkisSaati.getText())>=2400 || Integer.parseInt(inisSaati.getText())>=2400 
                       ||Integer.parseInt(kalkisSaati.getText())< 0 || Integer.parseInt(inisSaati.getText())< 0){
                messageYeri.setText("Hatalı saat girdisi!!!");
                return;
            }
            if(Integer.parseInt(kalkisSaati.getText()) > Integer.parseInt(inisSaati.getText())){
               
                messageYeri.setText("Inis saati kalkis saatinden erken olamaz");
                return;
            } 
        }
        catch(Exception e){
            messageYeri.setText("Hatalı saat girdisi!!!");
            return;
        }
        
        if(ucusNo.getText().trim().equals("")){
            messageYeri.setText("Ucus no bos olamaz");
            return;
        }
        for(ucus_bilgileri ucus : ucusListesi) {
            if(ucus.getUcus_no().trim().equals(ucusNo.getText())){
                messageYeri.setText("Varolan bir ucus no secemezsiniz.");
                return;
            }
            
        }
        ucus_bilgileri e = new ucus_bilgileri("Eklendi",konumCombo.getSelectedItem()
                .toString(),hedefCombo.getSelectedItem().toString(),gunCombo.getSelectedItem().toString(),
                kalkisSaati.getText(),inisSaati.getText(),ucusNo.getText().trim(),ucakCombo.getSelectedItem().toString(),Firma.getText(),0);
        ucusListesi.add(e);
        ucusListesiGuncelle();
        messageYeri.setText("");
    }

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int seciliRow = UcusTablosu.getSelectedRow();
        if(seciliRow == -1){
            messageYeri.setText("Bir ucus secin!!");
        }
        else{
            String silinecekNo = new String();
            silinecekNo = (String) UcusTablosu.getValueAt(seciliRow, 8);
            for (ucus_bilgileri ucus : ucusListesi) {
                if(ucus.getUcus_no().equals(silinecekNo)){
                    ucusListesi.remove(ucus);
                    ucusListesiGuncelle();
                    return;
                }
            }
            ucusListesiGuncelle();
        }
    }

    private void ucusListesiGuncelle(){
        DefaultTableModel model = (DefaultTableModel) UcusTablosu.getModel();
        for (int i = UcusTablosu.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (ucus_bilgileri ucus : ucusListesi) {
            Object[] eklenen = {ucus.getDurum(),ucus.getKonum(),ucus.getHedef(),
                ucus.getGun(),ucus.getFirma_adi(),ucus.getUcak(),
                ucus.getKalkis_saati(),ucus.getInis_saati(),ucus.getUcus_no()};
            model.addRow(eklenen);
        }
    }
    
    private javax.swing.JTextField Firma;
    private javax.swing.JTable UcusTablosu;
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox<String> gunCombo;
    private javax.swing.JComboBox<String> hedefCombo;
    private javax.swing.JTextField inisSaati;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kalkisSaati;
    private javax.swing.JComboBox<String> konumCombo;
    private javax.swing.JLabel messageYeri;
    private javax.swing.JComboBox<String> ucakCombo;
    private javax.swing.JTextField ucusNo;
}
