import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class controlTowers extends javax.swing.JFrame {
    ArrayList<ucus_bilgileri> ucusListesi;
    ArrayList<String> sehirListesi;
    public controlTowers(String title,ArrayList<ucus_bilgileri> ucusListesi,ArrayList<String> sehirListesi) {
        super(title);
        initComponents();
        this.ucusListesi = ucusListesi;
        this.sehirListesi = sehirListesi;
        for (String s : sehirListesi) {
            sehirlerCombo.addItem(s);
        }
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sehirlerCombo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        gelenUcuslar = new javax.swing.JTable();
        gecikmeEkle = new javax.swing.JButton();
        gecikmeSuresi = new javax.swing.JTextField();
        ucusuBeklet = new javax.swing.JButton();
        ucusIptal = new javax.swing.JButton();
        messageYeri = new javax.swing.JLabel();
        ucusuAktifle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Kontrol Kulesi:");

        sehirlerCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sehirlerComboActionPerformed(evt);
            }
        });

        gelenUcuslar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Durum", "Baslangic", "Hedef", "Gun", "Firma", "Ucak", "Kalkis saati", "Inis saati", "Ucus No", "Rotar", "Kalan Sure"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(gelenUcuslar);

        gecikmeEkle.setText("Secili Ucusa Gecikme Ekle");
        gecikmeEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gecikmeEkleActionPerformed(evt);
            }
        });

        gecikmeSuresi.setText("10");
        
        ucusuBeklet.setText("Secili Ucusu Beklet");
        ucusuBeklet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ucusuBekletActionPerformed(evt);
            }
        });

        ucusIptal.setText("Secili Ucusu Iptal Et");
        ucusIptal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ucusIptalActionPerformed(evt);
            }
        });

        messageYeri.setForeground(new java.awt.Color(255, 0, 51));

        ucusuAktifle.setText("Secili Ucusu Aktiflestir");
        ucusuAktifle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ucusuAktifleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(messageYeri, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(gecikmeEkle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(118, 118, 118)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(gecikmeSuresi)
                                    .addComponent(sehirlerCombo, 0, 119, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(ucusIptal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ucusuBeklet, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                            .addComponent(ucusuAktifle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sehirlerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ucusuBeklet)
                    .addComponent(ucusIptal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gecikmeEkle)
                    .addComponent(gecikmeSuresi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ucusuAktifle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageYeri, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }

    private void sehirlerComboActionPerformed(java.awt.event.ActionEvent evt) {
        gelenUcuslarGuncelle();
    }

    private void gecikmeEkleActionPerformed(java.awt.event.ActionEvent evt) {
        int seciliRow = gelenUcuslar.getSelectedRow();
        if(seciliRow == -1){
            messageYeri.setText("Bir ucus secin!!");
        }
        else{
            String seciliUcusNo = new String();
            seciliUcusNo = (String) gelenUcuslar.getValueAt(seciliRow, 8);
            for (ucus_bilgileri ucus : ucusListesi) {
                if(ucus.getUcus_no().equals(seciliUcusNo)){
                    try{
                    ucus.setRotar(ucus.getRotar() + Integer.parseInt(gecikmeSuresi.getText()));
                    }
                    catch(Exception e){
                        messageYeri.setText("Gecerli bir gecikme suresi giriniz");
                        return;
                    }
                    gelenUcuslarGuncelle();
                    return;
                }
            }
        }
    }

    private void ucusuBekletActionPerformed(java.awt.event.ActionEvent evt) {
        int seciliRow = gelenUcuslar.getSelectedRow();
        if(seciliRow == -1){
            messageYeri.setText("Bir ucus secin !!");
        }
        else{
            String seciliUcusNo = new String();
            seciliUcusNo = (String) gelenUcuslar.getValueAt(seciliRow, 8);
            for (ucus_bilgileri ucus : ucusListesi) {
                if(ucus.getUcus_no().equals(seciliUcusNo)){
                    if((Integer.parseInt(ucus.getInis_saati())/100*60+Integer.parseInt(ucus.getInis_saati())%100) 
                            - (Integer.parseInt(FlightSim.saat)/100*60 + Integer.parseInt(FlightSim.saat)%100) + ucus.getRotar() > 20 ){
                        messageYeri.setText("Sadece inise 20 dakika kala bekletebilirsiniz !!");
                        return;
                    }
                    ucus.setDurum("Beklemede");
                    gelenUcuslarGuncelle();
                    return;
                }
            }
        }
    }

    private void ucusuAktifleActionPerformed(java.awt.event.ActionEvent evt) {
        int seciliRow = gelenUcuslar.getSelectedRow();
        if(seciliRow == -1){
            messageYeri.setText("Bir ucus secin!!");
        }
        else{
            String seciliUcusNo = new String();
            seciliUcusNo = (String) gelenUcuslar.getValueAt(seciliRow, 8);
            for (ucus_bilgileri ucus : ucusListesi) {
                if(ucus.getUcus_no().equals(seciliUcusNo)){
                    ucus.setDurum("Aktif");
                    gelenUcuslarGuncelle();
                    return;
                }
            }
        }
    }

    private void ucusIptalActionPerformed(java.awt.event.ActionEvent evt) {
        int seciliRow = gelenUcuslar.getSelectedRow();
        if(seciliRow == -1){
            messageYeri.setText("Bir ucus secin!!");
        }
        else{
            String seciliUcusNo = new String();
            seciliUcusNo = (String) gelenUcuslar.getValueAt(seciliRow, 8);
            for (ucus_bilgileri ucus : ucusListesi) {
                if(ucus.getUcus_no().equals(seciliUcusNo)){
                    ucus.setDurum("Iptal");
                    gelenUcuslarGuncelle();
                    return;
                }
            }
        }
    }
    
    private void gelenUcuslarGuncelle(){
        DefaultTableModel model = (DefaultTableModel) gelenUcuslar.getModel();
        model.getDataVector().removeAllElements();
        for (int i = model.getRowCount()-1 ; i >=0 ; i--) {
            model.removeRow(i);
        }
        for (ucus_bilgileri ucus : ucusListesi) {
            if(sehirlerCombo.getSelectedItem().toString().equals(ucus.getHedef())){
                Object[] eklenen = {ucus.getDurum(),ucus.getKonum(),ucus.getHedef(),
                ucus.getGun(),ucus.getFirma_adi(),ucus.getUcak(),
                ucus.getKalkis_saati(),ucus.getInis_saati(),ucus.getUcus_no(),ucus.getRotar()};
                model.addRow(eklenen);
            }
        }
    }

    private javax.swing.JTextField gecikmeSuresi;
    private javax.swing.JButton gecikmeEkle;
    private javax.swing.JTable gelenUcuslar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel messageYeri;
    private javax.swing.JComboBox<String> sehirlerCombo;
    private javax.swing.JButton ucusIptal;
    private javax.swing.JButton ucusuAktifle;
    private javax.swing.JButton ucusuBeklet;
}
