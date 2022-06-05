package Yesil_Market_Proje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class YesilMarket {

	static List<String> urunler= new ArrayList<>();
	static List<Double> fiyatlar = new ArrayList<>();
	static List<String> sepet= new ArrayList<>();
	static List<Double> sepetFiyat= new ArrayList<>();
	static List<Double> miktar = new ArrayList<>();
	//public static double toplam=0;
	
	public static void main(String[] args) {
		/* Yeşil Market alış-veriş programı.
		 *
		 * 1. Adım: Ürünler ve fiyatları içeren listeleri oluşturunuz.
		 * 			No 	   Ürün 		  Fiyat
				   ====	 =======	 	=========
					00	 Domates   	 	 2.10 TL
					01	 Patates   	 	 3.20 TL
					02	 Biber     	 	 1.50 TL
					03	 Soğan      	 2.30 TL
					04	 Havuç     	   	 3.10 TL
					05	 Elma      	   	 1.20 TL
					06	 Muz     	 	 1.90 TL
					07	 Çilek 	 		 6.10 TL
					08	 Kavun      	 4.30 TL
					09	 Üzüm      	 	 2.70 TL
					10	 Limon     	 	 0.50 TL
		 * 2. Adım: Kullanıcının ürün nosuna göre listeden ürün seçmesini isteyiniz.
		 * 3. Adım: Kaç kg satın almak istediğini sorunuz.
		 * 4. Adım: Alınacak bu ürünü sepete ekleyiniz ve Sepeti yazdırınız.
		 * 5. Başka bir ürün alıp almak istemediğini sorunuz.
		 * 6. Eğer devam etmek istiyorsa yeniden ürün seçme kısmına yönlendiriniz.
		 * 7. Eğer bitirmek istiyorsa ödeme kısmına geçiniz ve ödem sonrasında programı bitirinzi.
		 */

		urunler.addAll(Arrays.asList("Domates", "Patates", "Biber","Sogan","Patlcn"));
		fiyatlar.addAll(Arrays.asList(2.5, 3.2, 5.21, 1.9, 3.5));
		
		Scanner scan = new Scanner(System.in);
		char x;
		do {
			urunLisstele();
			System.out.println("lutfen almak istediginiz urun numarasini giriniz");
			int urunNo=scan.nextInt();
			System.out.println("lutfen kac kg almak istediginizi giriniz");
			double kg=scan.nextDouble();
			sepeteEkle(urunNo, kg);
			sepetGoruntule();
			System.out.println("devam etmek istiyorsaniz E'ye, Devam etmek istemyorsaniz H'ye basiniz");
			 x=scan.next().toUpperCase().charAt(0);
		} while (x=='E');
		
		odeme();
		
		scan.close();
		
	}



	


	private static void odeme() {
		double toplamx=0;
		double toplamSon=0;
		System.out.println(" No\t Urun \t Fiyat \t kg \t toplam");
		System.out.println(" ===\t ===========\t ======\t=====\t======");
		for (int i = 0; i < sepet.size(); i++) {
		
			System.out.println(" "+(i+1)+"\t"+sepet.get(i)+"\t"+sepetFiyat.get(i)+"\t"+miktar.get(i)+"\t"+sepetFiyat.get(i)*miktar.get(i));
			
		}
		for (int i = 0; i < sepet.size(); i++) {
			toplamx+=sepetFiyat.get(i)*miktar.get(i);
			toplamSon=Math.round(toplamx);
		}
		System.out.println("====================================================");
		System.out.println("Toplam        : "+ toplamSon +" TL");
		
		Scanner scan = new Scanner(System.in);
		
		double toplamPara=0;
		do {
			System.out.println("lutfen para girisi yapiniz....");
			double para=scan.nextDouble();
			toplamPara+=para;
			
			 System.out.println("Kalan miktar :"+(toplamSon-toplamPara+" TL"));
		} while (toplamPara<toplamSon);
		
		if (toplamSon==toplamPara) {
			System.out.println("Odemeniz basariyla yapilmistir");
			System.out.println("==========TESEKKURLER=========");
		}else {
			System.out.println("Odemeniz basariyla yapilmistir");
			System.out.println("Para ustunuz  :   "+(toplamPara-toplamSon+" TL"));
			System.out.println("==========TESEKKURLER=========");	
		
		}
		scan.close();
	}






	private static void sepeteEkle(int urunNo, double kg) {
		sepet.add(urunler.get(urunNo));
		sepetFiyat.add(fiyatlar.get(urunNo));
		miktar.add(kg);
	}






	private static void sepetGoruntule() {
		double toplam=0;
		System.out.println(" No\t Urun \t Fiyat \t kg \t toplam");
		System.out.println(" ===\t ===========\t ======\t=====\t======");
		for (int i = 0; i < sepet.size(); i++) {
		
			System.out.println(" "+(i+1)+"\t"+sepet.get(i)+"\t"+sepetFiyat.get(i)+"\t"+miktar.get(i)+"\t"+sepetFiyat.get(i)*miktar.get(i));
			
		}
		for (int i = 0; i < sepet.size(); i++) {
			toplam+=sepetFiyat.get(i)*miktar.get(i);
		}
		System.out.println("====================================================");
		System.out.println("Toplam        :  "+ toplam +" TL");
	}



	public static void urunLisstele() {
		
		System.out.println(" No\t Urunler \t Fiyatlar");
		System.out.println(" ===\t ===========\t =========");
		
		for (int i = 0; i < urunler.size(); i++) {
			System.out.println(" "+i+"\t"+urunler.get(i)+"\t   \t"+fiyatlar.get(i));
			
		}
		
	}

}
