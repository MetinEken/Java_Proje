package Okul_Yonetimi;

public class Ogretmen extends Kisi{

   private String bolum;
   private String sicilNo;

    public Ogretmen(String adSoyad, String kimlikNo, int yas, String bolum, String sicilNo) {
        super(adSoyad, kimlikNo,yas);
        this.bolum = bolum;
        this.sicilNo = sicilNo;
}
}