public class OgrenciBilgi {

    public static void main(String[] args) {
        // 1. Tarayıcı (Scanner) sınıfı ile kullanıcıdan veri alma
        Scanner tarayici = new Scanner(System.in);

        // Değişken tanımlamalar ve kullanıcıdan veri alma
        
        // a. Ad (String)
        System.out.print("Öğrencinin Adını Girin: ");
        String ad = tarayici.nextLine();

        // b. Soyad (String)
        System.out.print("Öğrencinin Soyadını Girin: ");
        String soyad = tarayici.nextLine();

        // c. Öğrenci Numarası (int)
        System.out.print("Öğrenci Numarasını Girin (Örn: 12345): ");
        int ogrenciNo = tarayici.nextInt();

        // d. Yaş (int)
        System.out.print("Yaşını Girin: ");
        int yas = tarayici.nextInt();

        // e. Genel Not Ortalaması - GPA (double)
        System.out.print("Genel Not Ortalamasını (GPA) Girin (Örn: 3,45): ");
        double gpa = tarayici.nextDouble();
        
        // Tarayıcıyı kapatmak iyi bir alışkanlıktır.
        tarayici.close();

        // 2. Çıktı Formatı
        
        // GPA'ya göre Durum belirleme (Basit bir kontrol)
        String durum;
        if (gpa >= 2.00) {
            durum = "Başarılı Öğrenci";
        } else {
            durum = "Şartlı Geçiş/Başarısız";
        }

        // printf() ile formatlı ve düzenli çıktı
        System.out.println("\n=== OGRENCI BILGI SISTEMI ===");
        
        // %s: String, %d: int, %.2f: double (2 ondalık basamak hassasiyetinde)
        System.out.printf("Ad Soyad: %s %s\n", ad, soyad);
        System.out.printf("Öğrenci No: %d\n", ogrenciNo);
        System.out.printf("Yaş: %d\n", yas);
        System.out.printf("GPA: %.2f\n", gpa); // GPA'yı 2 ondalık basamakla gösteriyoruz
        System.out.printf("Durum: %s\n", durum);
        System.out.println("===============================");
    }
}

}
