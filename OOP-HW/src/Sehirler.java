import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Sehirler extends javax.swing.JFrame {

    ArrayList<String> sehirListesi;
    public Sehirler(String title,ArrayList<String> sehirListesi) throws HeadlessException { 
        super(title);
        initComponents();
        this.sehirListesi = sehirListesi;
        sehirListesiGuncelle();
    }

    private void initComponents() {

        sehirEkle = new javax.swing.JButton();
        sehir = new javax.swing.JTextField();
        sehirSil = new javax.swing.JButton();
        messageYeri = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SehirTablosu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        sehirEkle.setText("Sehir Ekle");
        sehirEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sehirEkleActionPerformed(evt);
            }
        });

        sehirSil.setText("Sehir Sil");
        sehirSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sehirSilActionPerformed(evt);
            }
        });

        messageYeri.setForeground(new java.awt.Color(255, 51, 51));

        SehirTablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sehirler"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SehirTablosu.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(SehirTablosu);
        SehirTablosu.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sehirEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sehir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sehirSil, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(messageYeri, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sehirEkle)
                    .addComponent(sehir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sehirSil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageYeri, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        pack();
    }

    private void sehirEkleActionPerformed(java.awt.event.ActionEvent evt) {
        String e = new String();
        if(sehir.getText().trim().equals("")){
            messageYeri.setText("Sehir ismi bos olamaz");
            return;
        }
        for (String s : sehirListesi) {
            if(s.equals(sehir.getText().trim())){
                messageYeri.setText("Bu sehir zaten listede");
                return;
            }
            
        }
        sehirListesi.add(sehir.getText().trim());
        sehirListesiGuncelle();
        messageYeri.setText("");
        
    }

    private void sehirSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sehirSilActionPerformed
        int seciliRow = SehirTablosu.getSelectedRow();
        if(seciliRow == -1){
            messageYeri.setText("Bir sehir secin!!");
        }
        else{
            String silinecekSehir = new String();
            silinecekSehir = (String) SehirTablosu.getValueAt(seciliRow, 0);
            for (String s : sehirListesi) {
                if(s.equals(silinecekSehir)){
                    sehirListesi.remove(s);
                    sehirListesiGuncelle();
                    return;
                }
            }
            sehirListesiGuncelle();
        }
    }

    private void sehirListesiGuncelle(){
        DefaultTableModel model = (DefaultTableModel) SehirTablosu.getModel();
        for (int i = SehirTablosu.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (String s : sehirListesi) {
            Object[] eklenen = {s};
            model.addRow(eklenen);
        }
    }

    private javax.swing.JTable SehirTablosu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel messageYeri;
    private javax.swing.JTextField sehir;
    private javax.swing.JButton sehirEkle;
    private javax.swing.JButton sehirSil;
}
