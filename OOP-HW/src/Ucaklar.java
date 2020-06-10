import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Ucaklar extends javax.swing.JFrame {
    ArrayList<String> ucakListesi;
    public Ucaklar(String title,ArrayList<String> ucakListesi) {
        super(title);
        initComponents();
        this.ucakListesi=ucakListesi;
        ucakListesiGuncelle();
    }

    private void initComponents() {

        ucakEkle = new javax.swing.JButton();
        ucakSil = new javax.swing.JButton();
        ucak = new javax.swing.JTextField();
        messageYeri = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UcakTablosu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        ucakEkle.setText("Ucak Ekle");
        ucakEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ucakEkleActionPerformed(evt);
            }
        });

        ucakSil.setText("Ucak Sil");
        ucakSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ucakSilActionPerformed(evt);
            }
        });

        messageYeri.setForeground(new java.awt.Color(255, 51, 51));

        UcakTablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ucaklar"
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
        UcakTablosu.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(UcakTablosu);
        UcakTablosu.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(messageYeri, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ucakEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ucak, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                            .addComponent(ucakSil, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ucakEkle)
                    .addComponent(ucak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ucakSil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageYeri, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        pack();
    }

    private void ucakEkleActionPerformed(java.awt.event.ActionEvent evt) {
        if(ucak.getText().trim().equals("")){
            messageYeri.setText("Ucak ismi boş olamaz");
            return;
        }
        for (String s : ucakListesi) {
            if(s.equals(ucak.getText().trim())){
                messageYeri.setText("Bu ucak zaten listede");
                return;
            }

        }
        ucakListesi.add(ucak.getText().trim());
        ucakListesiGuncelle();
        messageYeri.setText("");

    }

    private void ucakSilActionPerformed(java.awt.event.ActionEvent evt) {
        int seciliRow = UcakTablosu.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) UcakTablosu.getModel();

        if(seciliRow == -1){
            messageYeri.setText("Bir sehir secin!!");
        }
        else{
            String silinecekSehir = new String();
            silinecekSehir = (String) UcakTablosu.getValueAt(seciliRow, 0);
            int silinecekRow = 0;
            for (String s : ucakListesi) {
                if(s.equals(silinecekSehir)){
                    ucakListesi.remove(s);
                    ucakListesiGuncelle();

                    return;
                }
                silinecekRow++;
            }
            ucakListesiGuncelle();
        }
    }

    
    private void ucakListesiGuncelle(){
        DefaultTableModel model = (DefaultTableModel) UcakTablosu.getModel();
        for (int i = UcakTablosu.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        if(ucakListesi.size()>0){
            for (String s : ucakListesi) {
                Object[] eklenen = {s};
                model.addRow(eklenen);
            }
        }
    }

    private javax.swing.JTable UcakTablosu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel messageYeri;
    private javax.swing.JTextField ucak;
    private javax.swing.JButton ucakEkle;
    private javax.swing.JButton ucakSil;
}
