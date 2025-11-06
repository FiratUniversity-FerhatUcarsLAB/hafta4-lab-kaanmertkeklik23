import java.util.Scanner;

public class GeometrikHesap {

    public static void main(String[] args) {
        // 1. PI değerini sabit (final) olarak tanımlama
        final double PI = 3.14159;

        Scanner tarayici = new Scanner(System.in);

        System.out.println("=== GEOMETRIK HESAPLAYICI ===");
        
        // 2. Yarıçapı (double) kullanıcıdan alma
        System.out.print("Dairenin yarıçapını girin (cm): ");
        double yaricap = tarayici.nextDouble();

        tarayici.close();

        // 3. Hesaplamalar
        
        // Dairenin Alanı: π * r²
        double daireAlani = PI * Math.pow(yaricap, 2); 
        
        // Dairenin Çevresi (Sınırları): 2 * π * r
        double daireCevresi = 2 * PI * yaricap;
        
        // Dairenin Çapı: 2 * r
        double daireCapi = 2 * yaricap;
        
        // Kürenin Hacmi: (4/3) * π * r³
        // Not: 4.0/3.0 kullanımı, sonucun double olmasını sağlar.
        double kureHacmi = (4.0 / 3.0) * PI * Math.pow(yaricap, 3);
        
        // Kürenin Yüzey Alanı: 4 * π * r²
        double kureYuzeyAlani = 4 * PI * Math.pow(yaricap, 2);

        // 4. Düzenli ve Anlaşılır Formatlı Çıktı (printf kullanımı)

        System.out.println("\nSONUÇLAR:");
        System.out.println("----------");
        
        // %.2f: 2 ondalık basamak hassasiyeti
        // %-20s: Metni sola hizalar ve minimum 20 karakterlik bir alan ayırır.
        
        System.out.printf("%-20s : %.2f cm²\n", "Daire Alanı", daireAlani);
        System.out.printf("%-20s : %.2f cm\n", "Daire Çevresi", daireCevresi);
        System.out.printf("%-20s : %.2f cm\n", "Daire Çapı", daireCapi);
        System.out.printf("%-20s : %.2f cm³\n", "Küre Hacmi", kureHacmi);
        System.out.printf("%-20s : %.2f cm²\n", "Küre Yüzey Alanı", kureYuzeyAlani);
    }
}
