public class ucus_bilgileri {
    private String durum;
    private String konum;
    private String hedef;
    private String gun;
    private String kalkis_saati;
    private String inis_saati;
    private String ucus_no;
    private String ucak;
    private String firma_adi;
    private int rotar = 0;

    public ucus_bilgileri(String durum, String konum, String hedef, String gun, String kalkis_saati, String inis_saati, String ucus_no, String ucak, String firma_adi,int rotar) {
        this.durum = durum;
        this.konum = konum;
        this.hedef = hedef;
        this.gun = gun;
        this.kalkis_saati = kalkis_saati;
        this.inis_saati = inis_saati;
        this.ucus_no = ucus_no;
        this.ucak = ucak;
        this.firma_adi = firma_adi;
        this.rotar = rotar;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public String getKonum() {
        return konum;
    }

    public void setKonum(String konum) {
        this.konum = konum;
    }

    public String getHedef() {
        return hedef;
    }

    public void setHedef(String hedef) {
        this.hedef = hedef;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public String getKalkis_saati() {
        return kalkis_saati;
    }

    public void setKalkis_saati(String kalkis_saati) {
        this.kalkis_saati = kalkis_saati;
    }

    public String getInis_saati() {
        return inis_saati;
    }

    public void setInis_saati(String inis_saati) {
        this.inis_saati = inis_saati;
    }

    public String getUcus_no() {
        return ucus_no;
    }

    public void setUcus_no(String ucus_no) {
        this.ucus_no = ucus_no;
    }

    public String getUcak() {
        return ucak;
    }

    public void setUcak(String ucak) {
        this.ucak = ucak;
    }

    public String getFirma_adi() {
        return firma_adi;
    }

    public void setFirma_adi(String firma_adi) {
        this.firma_adi = firma_adi;
    }

    public int getRotar() {
        return rotar;
    }

    public void setRotar(int rotar) {
        this.rotar = rotar;
    }
}
