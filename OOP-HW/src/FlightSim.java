import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class FlightSim extends javax.swing.JFrame implements ActionListener{

    public static ArrayList<String> sehirListesi;
    public static ArrayList<String> ucakListesi;
    public static ArrayList<ucus_bilgileri> ucusListesi;
    public static gunler sistemGunu = gunler.Pazartesi;
    Timer timer = new Timer(1000,this);
    public static String saat = new String("0900");
    
    public static void main(String args[]) {
        sehirListesi = new ArrayList<String>();
        ucakListesi = new ArrayList<String>();
        ucusListesi = new ArrayList<ucus_bilgileri>(); 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlightSim("OOP_HW: Flight Simulator").setVisible(true);
            }
        });
    }
    
    public FlightSim(String title) {
        super(title);
        initComponents();
        sehirListesi.add("New York");
        sehirListesi.add("Sydney");
        sehirListesi.add("Paris");
        sehirListesi.add("Tokyo");
        sehirListesi.add("Istanbul");
        ucakListesi.add("Airbus A300");
        ucakListesi.add("Boeing 717");
        ucus_bilgileri u = new ucus_bilgileri("Sirada", "Istanbul", "Paris", "Pazartesi", "0900", "1200", "000001", "Boeing 717", "Turkish Airlines", 0);
        ucusListesi.add(u);
        u = new ucus_bilgileri("Sirada", "Istanbul", "New York", "Sali", "1200", "1800", "000002", "Airbus A300", "Turkish Airlines", 0);
        ucusListesi.add(u);
        u = new ucus_bilgileri("Sirada", "Sydney", "New York", "Pazartesi", "0200", "1800", "000003", "Airbus A300", "American Airlines", 0);
        ucusListesi.add(u);
        u = new ucus_bilgileri("Sirada", "Tokyo", "Istanbul", "Persembe", "1830", "2230", "000004", "Boeing 717", "Turkish Airlines", 0);
        ucusListesi.add(u);
        u = new ucus_bilgileri("Sirada", "Tokyo", "New York", "Cuma", "0630", "1930", "000005", "Airbus A300", "Japan Airlines", 0);
        ucusListesi.add(u);
        u = new ucus_bilgileri("Sirada", "Tokyo", "Paris", "Cumartesi", "1230", "2330", "000006", "Boeing 717", "Air France", 0);
        ucusListesi.add(u);
        u = new ucus_bilgileri("Sirada", "New York", "Tokyo", "Pazar", "0900", "2200", "000007", "Airbus A300", "American Airlines", 0);
        ucusListesi.add(u);
        u = new ucus_bilgileri("Sirada", "Paris", "Istanbul", "Pazar", "2000", "2300", "000008", "Airbus A300", "Turkish Airlines", 0);
        ucusListesi.add(u);
        u = new ucus_bilgileri("Sirada", "Paris", "Sydney", "Sali", "0200", "2350", "000009", "Boeing 717", "Qantas", 0);
        ucusListesi.add(u);
        u = new ucus_bilgileri("Sirada", "New York", "Istanbul", "Cuma", "1300", "1900", "000010", "Boeing 717", "American Airlines", 0);
        ucusListesi.add(u);
    }
                      
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        aktifUcuslar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        beklenenUcuslar = new javax.swing.JTable();
        systemDate = new javax.swing.JLabel();
        systemClock = new javax.swing.JLabel();
        controlTower = new javax.swing.JButton();
        timeSimulator = new javax.swing.JButton();
        messageYeri = new javax.swing.JLabel();
        zamanDurdur = new javax.swing.JButton();
        zamanBaslat = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();
        Sehirler = new javax.swing.JMenuItem();
        ucakEkle = new javax.swing.JMenuItem();
        ucuslariDuzenle = new javax.swing.JMenuItem();
        Aktar = new javax.swing.JMenu();
        Export = new javax.swing.JMenuItem();
        Import = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        aktifUcuslar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Durum", "Baslangic", "Hedef", "Gun", "Firma", "Ucak", "Kalkis saati", "Inis saati", "Ucus No", "Rotar", "Kalan Sure"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(aktifUcuslar);

        jLabel1.setText("Aktif Ucuslar");

        beklenenUcuslar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Durum", "Baslangýc", "Hedef", "Gun", "Firma", "Ucak", "Kalkis saati", "Inis Saati", "Ucus No", "Rotar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(beklenenUcuslar);

        systemDate.setText("Gun:");

        systemClock.setText("Saat:");

        controlTower.setText("Kontrol Kuleleri");
        controlTower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlTowerActionPerformed(evt);
            }
        });

        timeSimulator.setText("Sistem Saatini Simule Et");
        timeSimulator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeSimulatorActionPerformed(evt);
            }
        });

        messageYeri.setForeground(new java.awt.Color(255, 51, 51));
        messageYeri.setText("Lutfen sistem saati ekleyin!");

        zamanDurdur.setText("Duraklat");
        zamanDurdur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zamanDurdurActionPerformed(evt);
            }
        });

        zamanBaslat.setText("Baslat");
        zamanBaslat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zamanBaslatActionPerformed(evt);
            }
        });

        Menu.setText("Menu");

        Sehirler.setText("Sehir Listesi");
        Sehirler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SehirlerActionPerformed(evt);
            }
        });
        Menu.add(Sehirler);

        ucakEkle.setText("Ucak Listesi");
        ucakEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ucakEkleActionPerformed(evt);
            }
        });
        Menu.add(ucakEkle);

        ucuslariDuzenle.setText("Ucuslari Duzenle");
        ucuslariDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ucuslariDuzenleActionPerformed(evt);
            }
        });
        Menu.add(ucuslariDuzenle);

        jMenuBar1.add(Menu);

        Aktar.setText("Ice/Dýsa Aktar");

        Export.setText("Verileri Dýsa Aktar");
        Export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportActionPerformed(evt);
            }
        });
        Aktar.add(Export);

        Import.setText("Verileri Ice Aktar");
        Import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportActionPerformed(evt);
            }
        });
        Aktar.add(Import);

        jMenuBar1.add(Aktar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(controlTower, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(timeSimulator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(systemClock, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(systemDate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(zamanDurdur, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                            .addComponent(zamanBaslat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(messageYeri, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeSimulator)
                    .addComponent(systemDate)
                    .addComponent(zamanBaslat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(controlTower)
                    .addComponent(systemClock)
                    .addComponent(zamanDurdur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(messageYeri))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }                 

    private void SehirlerActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Sehirler sehirler = new Sehirler("Sehirler",sehirListesi);
        sehirler.setVisible(true);
        sehirler.requestFocus();
        sehirler.setFocusable(true);
        sehirler.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }                                        

    private void ImportActionPerformed(java.awt.event.ActionEvent evt) {                                       
        JFileChooser fc = new JFileChooser();
        if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
        	sehirListesi.removeAll(sehirListesi);
        	ucakListesi.removeAll(ucakListesi);
        	ucusListesi.removeAll(ucusListesi);
            File file = fc.getSelectedFile();
            try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))){
                int sehirSayisi;
                int ucakSayisi;
                int ucusSayisi;
                sehirSayisi = scanner.nextInt();
                ucakSayisi = scanner.nextInt();
                ucusSayisi = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < sehirSayisi; i++) {
                    String s = new String();
                    s = scanner.nextLine();
                    sehirListesi.add(s);
                }
                for (int i = 0; i < ucakSayisi; i++) {
                    ucakListesi.add(scanner.nextLine());
                }
                for (int i = 0; i < ucusSayisi; i++) {
                    ucus_bilgileri u = new ucus_bilgileri(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),scanner.nextInt());
                    scanner.nextLine();
                    ucusListesi.add(u);
                }
                sistemGunu = gunler.valueOf(scanner.nextLine());
                saat = scanner.nextLine();
                zamanGuncelle();
            } catch (FileNotFoundException ex) {
                messageYeri.setText("Dosya bulunamadi");
            }
        }
    }                                      

    private void ucuslariDuzenleActionPerformed(java.awt.event.ActionEvent evt) {                                                
        if(sehirListesi.size() < 2 || ucakListesi.size() == 0 ){
            JOptionPane.showMessageDialog(null, "En az 2 sehir ve 1 ucak modeli eklemelisiniz.", "Hata", JOptionPane.PLAIN_MESSAGE);
        return;
        }
        UcusDuzenle ucus = new UcusDuzenle("Ucuslari Duzenle",sehirListesi,ucakListesi,ucusListesi);
        ucus.setVisible(true);
        ucus.requestFocus();
        ucus.setFocusable(true);
        this.setFocusable(false);
        ucus.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }                                               

    private void ucakEkleActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Ucaklar ucaklar = new Ucaklar("Ucaklar",ucakListesi);
        ucaklar.setVisible(true);
        ucaklar.requestFocus();
        ucaklar.setFocusable(true);
        ucaklar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }                                        

    private void timeSimulatorActionPerformed(java.awt.event.ActionEvent evt) {                                              
        systemTime systemZamani = new systemTime("God Mode");
        systemZamani.setVisible(true);
        systemZamani.requestFocus();
        systemZamani.setFocusable(true);
        systemZamani.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }                                             

    private void zamanBaslatActionPerformed(java.awt.event.ActionEvent evt) {                                            
        timer.start();
        messageYeri.setText("");
    }                                           

    private void zamanDurdurActionPerformed(java.awt.event.ActionEvent evt) {                                            
        timer.stop();
    }                                           

    private void controlTowerActionPerformed(java.awt.event.ActionEvent evt) {                                             
        controlTowers controlTower = new controlTowers("Kontrol Kuleleri",ucusListesi,sehirListesi);
        controlTower.setVisible(true);
        controlTower.requestFocus();
        controlTower.setFocusable(true);
        controlTower.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }                                            

    private void ExportActionPerformed(java.awt.event.ActionEvent evt) {                                       
        JFileChooser fc = new JFileChooser();
        if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            try(FileWriter writer = new FileWriter(fc.getSelectedFile().getPath())){
                int sehirSayisi=sehirListesi.size();
                int ucakSayisi=ucakListesi.size();
                int ucusSayisi=ucusListesi.size();
                writer.write(sehirSayisi + System.lineSeparator());
                writer.write(ucakSayisi + System.lineSeparator());
                writer.write(ucusSayisi + System.lineSeparator()); 
                for (String s : sehirListesi) {
                    writer.write(s + System.lineSeparator());
                }
                for (String s : ucakListesi) {
                    writer.write(s + System.lineSeparator());
                }
                for (ucus_bilgileri u : ucusListesi) {
                    writer.write(u.getDurum() + System.lineSeparator() + u.getKonum() + System.lineSeparator() + u.getHedef() + System.lineSeparator() + u.getGun() + System.lineSeparator() + u.getKalkis_saati() + System.lineSeparator() + u.getInis_saati() + System.lineSeparator() + u.getUcus_no() + System.lineSeparator() + u.getUcak() + System.lineSeparator() + u.getFirma_adi() + System.lineSeparator() + u.getRotar() + System.lineSeparator());
                }
                writer.write(sistemGunu + System.lineSeparator());
                writer.write(saat + System.lineSeparator());
            } catch (IOException ex) {
                Logger.getLogger(FlightSim.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void setSystemClock(String s) {
        systemClock.setText(s);
    }
    public static void setSystemDate(String s) {
        systemDate.setText(s);
    }
    
    private javax.swing.JMenu Aktar;
    private javax.swing.JMenuItem Export;
    private javax.swing.JMenuItem Import;
    private javax.swing.JMenu Menu;
    private javax.swing.JMenuItem Sehirler;
    private javax.swing.JTable aktifUcuslar;
    private javax.swing.JTable beklenenUcuslar;
    private javax.swing.JButton controlTower;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel messageYeri;
    private static javax.swing.JLabel systemClock;
    private static javax.swing.JLabel systemDate;
    private javax.swing.JButton timeSimulator;
    private javax.swing.JMenuItem ucakEkle;
    private javax.swing.JMenuItem ucuslariDuzenle;
    private javax.swing.JButton zamanBaslat;
    private javax.swing.JButton zamanDurdur;               

    @Override
    public void actionPerformed(ActionEvent e) {
        zamanGuncelle();
        ucuslarýGoruntule();
    }
    
    public static void zamanGuncelle(){
        String guncelsaat = "Saat: ";
        if(Integer.valueOf(saat) % 100 >= 60){
            saat = String.valueOf(Integer.valueOf(saat) + 40);
        }
        if(Integer.valueOf(saat) >= 2400){
            saat = String.valueOf(Integer.valueOf(saat) - 2400);
            sistemGunu = gunler.values()[(sistemGunu.ordinal()+1)%7];
        }
        if(Integer.valueOf(saat)/1000==0){
            guncelsaat += "0";
        }
        guncelsaat += String.valueOf(Integer.valueOf(saat)/100);
        guncelsaat += ":";
        
        if((Integer.valueOf(saat)%100)/10 ==0){
            guncelsaat += "0";
        }
        guncelsaat += String.valueOf(Integer.valueOf(saat)%100);
        systemDate.setText("Gun:  " + sistemGunu);
        systemClock.setText(guncelsaat);
        saat = String.valueOf(Integer.valueOf(saat) + 1);
    }
    public void ucuslarýGoruntule(){
        DefaultTableModel beklenen = (DefaultTableModel)beklenenUcuslar.getModel();
        DefaultTableModel aktif = (DefaultTableModel)aktifUcuslar.getModel();
        gunler g;
        for (int i = beklenenUcuslar.getRowCount() - 1; i >= 0; i--) {
            beklenen.removeRow(i);
        }
        for (int i = aktifUcuslar.getRowCount() - 1; i >= 0; i--) {
            aktif.removeRow(i);
        }
        for (ucus_bilgileri ucus : ucusListesi) {
            g =  gunler.valueOf(ucus.getGun());
            Object[] e = {ucus.getDurum(),ucus.getKonum(),ucus.getHedef(),ucus.getGun(),ucus.getFirma_adi(),ucus.getUcak(),
                ucus.getKalkis_saati(),ucus.getInis_saati(),ucus.getUcus_no(),ucus.getRotar()};
            if(ucus.getDurum().equals("Beklemede")){
                ucus.setRotar(ucus.getRotar()+1);
                Object[] a = {ucus.getDurum(),ucus.getKonum(),ucus.getHedef(),ucus.getGun(),ucus.getFirma_adi(),ucus.getUcak(),
                    ucus.getKalkis_saati(),ucus.getInis_saati(),ucus.getUcus_no(),ucus.getRotar(),
                    Integer.toString((Integer.parseInt(ucus.getInis_saati())/100*60+Integer.parseInt(ucus.getInis_saati())%100) 
                            - (Integer.parseInt(saat)/100*60 + Integer.parseInt(saat)%100) + ucus.getRotar() )};
                aktif.addRow(a);
            }
            else if(ucus.getDurum().equals("Iptal")){
                Object[] a = {ucus.getDurum(),ucus.getKonum(),ucus.getHedef(),ucus.getGun(),ucus.getFirma_adi(),ucus.getUcak(),
                    ucus.getKalkis_saati(),ucus.getInis_saati(),ucus.getUcus_no(),ucus.getRotar()};
                beklenen.addRow(a);
            }
            else{
                if(g.ordinal() > sistemGunu.ordinal()){
                    ucus.setDurum("Sirada");
                    beklenen.addRow(e);
                }
                else if(g.ordinal() == sistemGunu.ordinal()){
                    if(Integer.parseInt(ucus.getKalkis_saati()) <= Integer.parseInt(saat) && Integer.parseInt(ucus.getInis_saati()) + ucus.getRotar() > Integer.parseInt(saat)){
                        ucus.setDurum("Aktif");
                        Object[] a = {ucus.getDurum(),ucus.getKonum(),ucus.getHedef(),ucus.getGun(),ucus.getFirma_adi(),ucus.getUcak(),
                    ucus.getKalkis_saati(),ucus.getInis_saati(),ucus.getUcus_no(),ucus.getRotar(),
                    Integer.toString((Integer.parseInt(ucus.getInis_saati())/100*60+Integer.parseInt(ucus.getInis_saati())%100) 
                            - (Integer.parseInt(saat)/100*60 + Integer.parseInt(saat)%100) + ucus.getRotar() )};
                        aktif.addRow(a);
                    }
                    else if(Integer.parseInt(ucus.getKalkis_saati()) > Integer.parseInt(saat)){
                        ucus.setDurum("Sirada");
                        beklenen.addRow(e);
                    }
                    else{
                        ucus.setDurum("Sonlandi");
                        aktif.addRow(e);
                    }
                }
                else if(g.ordinal() < sistemGunu.ordinal()){
                    ucus.setDurum("Sonlandi");
                    aktif.addRow(e); 
                }
            }
        }
    }
}