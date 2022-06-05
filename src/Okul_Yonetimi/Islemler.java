package Okul_Yonetimi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.ls.LSOutput;

public class Islemler {

    private List<Kisi> ogrenciListesi= new ArrayList<>();
    private List<Kisi> ogretmenListesi= new ArrayList<>();
    private String kisiTuru;
    
    
    
    
    public void anaMenu() {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("=======================");
    	System.out.println("OGRETMEN VE OGRENCI PANELI");
    	System.out.println("===========================");
    	System.out.println(" 1-OGRENCI ISLEMLER");
    	System.out.println(" 2-OGRETMEN ISLEMLERI");
    	System.out.println(" Q-CIKIS");
    	String secim= scan.next().toUpperCase();
    	
    	
    	if (secim.equals("Q")) {
			cikis();
		} else if(secim.equals("1")) {
			kisiTuru= "OGRENCI";
			islem();
		}else if(secim.equals("2")) {
			kisiTuru= "OGRETMEN";
			islem();
		}else {
			System.out.println("Yanlis Giris Yaptiniz.");
			anaMenu();
		}
    	
    }

	private void islem() {
		Scanner scan = new Scanner(System.in);
    	System.out.println("==========ISLEMLER=============");
    	System.out.println(" 1-EKLEME");
    	System.out.println(" 2-ARAMA");
    	System.out.println(" 3-LISTELEME");
    	System.out.println(" 4-SILME");
    	System.out.println(" 5-ANA MENU");
    	System.out.println(" Q-CIKIS");
    	System.out.println(" SECIMINIZ");
    	String tercih = scan.next().toUpperCase();
    	
		switch(tercih) {
		case "1": ekle();
				  break;
		case "2": arama();
		  break;
		case "3": listele();
		  break;
		case "4": silme();
		  break;
		case "5": anaMenu();
		  break;
		case "Q": cikis();
		  break;
		default:System.out.println("HATALI ISLEM YAPTINIZ......");
		islem();
		break;
		}
	}

	private void arama() {
		Scanner scan = new Scanner(System.in);
		System.out.println("aramak istediginiz kimlikNo giriniz");
		String kNo=scan.next();
		System.out.println("----- "+kisiTuru+" BILGILERI ------");
		System.out.println(" S.NO "+"    kimlikNo  "+" Ad-Soyad  ");
		if (kisiTuru.equals("OGRENCI")) {
			kisiAra(kNo, ogrenciListesi);
		}else {
			kisiAra(kNo, ogretmenListesi);
		}
		islem();
		
	}

	private void kisiAra(String kNo, List<Kisi> liste) {
		int count=1;
		
		for (Kisi x : liste) {
			if (x.getKimlikNo().equals(kNo)) {
				System.out.println(" "+count+" \t"+x.getKimlikNo()+" "+x.getAdSoyad());
				count++;
				return;
			}else {
				System.out.println("ARADIGINIZ KISI BULUNAMADI");
			
			}
			
		}
		
	}

	private void silme() {
		Scanner scan = new Scanner(System.in);
		
		
			System.out.println("SILMEK ISTEDIGINIZ KIMLIK-NO YU GIRINIZ");
			String kNo=scan.next();
			if (kisiTuru.equals("OGRENCI")) {
				kisiSil(kNo, ogrenciListesi);
			}else {
				kisiSil(kNo, ogretmenListesi);
			}
			
		
		
		islem();
		
	}

	private void kisiSil(String kNo, List<Kisi> liste) {
		int count=0;
		int temp;
		String flag="yok";
		for (Kisi x : liste) {
			count++;
			if (x.getKimlikNo().equals(kNo)) {
				System.out.println("ASAGIDAKI "+kisiTuru+" BASARI ILE SILINMISTIR");
					System.out.println(" "+x.getAdSoyad()+" "+x.getKimlikNo());
					flag="var";		
			}
		}
		
		if (flag.equals("var")) {
			temp=count;
			
			
		}else {
			System.out.println("KISI BULUNAMAMISTIR");
		}
		
		islem();
	}

	private void listele() {
		List<Kisi> liste;
		
		if (kisiTuru.equals("OGRENCI")) {
			liste=ogrenciListesi;
		} else {
			liste=ogretmenListesi;
		}
		
		for (Kisi x : liste) {
			System.out.println(x);
		}
		
	}

	private void ekle() {
		Scanner scan = new Scanner(System.in);
		System.out.println("----- "+kisiTuru+" EKLEME SAYFASI------");
		System.out.println("AD-SOYAD GIRINIZ");
		String adSoyad=scan.nextLine();
		System.out.println("KIMLIK NO GIRINIZ");
		String kimlikNo=scan.next();
		System.out.println("YASINIZI GIRINIZ");
		int yas=scan.nextInt();
		
		if (kisiTuru.equals("OGRENCI")) {
			System.out.println("NUMARANIZI GIRINIZ");
			String numara=scan.next();
			System.out.println("SINIFINIZI GIRINIZ");
			String sinif=scan.next();
			Ogrenci ogr= new Ogrenci(adSoyad, kimlikNo, yas, numara, sinif);
			ogrenciListesi.add(ogr);
			islem();
		} else {
			System.out.println("SICIL NO GIRINIZ");
			String sicilNo=scan.next();
			System.out.println("BOLUM GIRINIZ");
			String bolum=scan.next();
			Ogrenci ogrtm= new Ogrenci(adSoyad, kimlikNo, yas, bolum, sicilNo);
			ogretmenListesi.add(ogrtm);
			
			islem();
		}
		
	}

	private void cikis() {
		System.out.println("Programi Kullandiginiz Icin Tesekkkur Ederiz");
		
	}
	 public void testKisiOlustur() {
	        Ogrenci ogr1 = new Ogrenci ("Ahmet Can", "12345678",14,"123","9A");
	        Ogrenci ogr2 = new Ogrenci ("Mustafa Yilmaz", "456889012",13,"456","8b");
	        Ogrenci ogr3 = new Ogrenci ("Ayse Canan", "987654321",15,"567","12c");

	        Ogretmen ogrt1 = new Ogretmen ("Selim Kaya", "4561236789",40,"MEKATRONIK","O1234");
	        Ogretmen ogrt2 = new Ogretmen ("Melis Ozturk", "123490855",25,"BIYOLOJI","O456");

	        ogrenciListesi.add(ogr1);
	        ogrenciListesi.add(ogr2);
	        ogrenciListesi.add(ogr3);
	        ogretmenListesi.add(ogrt1);
	        ogretmenListesi.add(ogrt2);
	    }

}
