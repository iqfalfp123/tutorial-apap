package apap.tutorial.kebunsafari.model;

public class KebunSafariModel {
    private String idKebunSafari;
    private String namaKebunSafari;
    private String alamat;
    private String noTelepon;

    public KebunSafariModel(String idKebunSafari, String namaKebunSafari, String alamat, String noTelepon){
        this.idKebunSafari = idKebunSafari;
        this.namaKebunSafari = namaKebunSafari;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
    }
    /**
     * @return String return the idKebunSafari
     */
    public String getIdKebunSafari() {
        return idKebunSafari;
    }

    /**
     * @param idKebunSafari the idKebunSafari to set
     */
    public void setIdKebunSafari(String idKebunSafari) {
        this.idKebunSafari = idKebunSafari;
    }

    /**
     * @return String return the namaKebunSafari
     */
    public String getNamaKebunSafari() {
        return namaKebunSafari;
    }

    /**
     * @param namaKebunSafari the namaKebunSafari to set
     */
    public void setNamaKebunSafari(String namaKebunSafari) {
        this.namaKebunSafari = namaKebunSafari;
    }

    /**
     * @return String return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return String return the noTelepon
     */
    public String getNoTelepon() {
        return noTelepon;
    }

    /**
     * @param noTelepon the noTelepon to set
     */
    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

}
