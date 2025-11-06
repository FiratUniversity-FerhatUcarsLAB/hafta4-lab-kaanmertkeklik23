import java.util.Scanner;
import java.time.LocalDate; // Sistem tarihini almak için

public class MaasHesap {

    public static void main(String[] args) {
        // 1. Sabit (final) Kesinti Oranlarını tanımlama (Ondalık değer olarak)
        final double SGK_ORAN = 0.14;       // %14
        final double GELIR_VERGISI_ORAN = 0.15; // %15
        final double DAMGA_VERGISI_ORAN = 0.00759; // %0.759
        final int AYLIK_CALISMA_SAATI_ORT = 160;
        final double MESAI_CARPANI = 1.5;
        final int IS_GUNU = 22; // Günlük net kazanç için

        Scanner tarayici = new Scanner(System.in);
        
        System.out.println("=== MAAS HESAPLAMA SISTEMI ===");
        
        // 2. Kullanıcıdan Bilgileri Alma
        System.out.print("Çalışanın Adı ve Soyadını Girin: ");
        String adSoyad = tarayici.nextLine();

        System.out.print("Aylık Brüt Maaşı Girin (TL): ");
        double brutMaas = tarayici.nextDouble();

        System.out.print("Haftalık Çalışma Saatini Girin: ");
        int haftalikCalismaSaati = tarayici.nextInt();
        
        System.out.print("Mesai Saati Sayısını Girin: ");
        int mesaiSaati = tarayici.nextInt();

        tarayici.close();
        
        // 3. Hesaplamalar
        
        // a. Mesai Ücreti
        double saatlikBrutUcret = brutMaas / AYLIK_CALISMA_SAATI_ORT;
        double mesaiUcreti = saatlikBrutUcret * mesaiSaati * MESAI_CARPANI;
        
        // b. Toplam Gelir
        double toplamGelir = brutMaas + mesaiUcreti;

        // c. Kesintiler
        double sgkKesintisi = toplamGelir * SGK_ORAN;
        double gelirVergisiKesintisi = toplamGelir * GELIR_VERGISI_ORAN;
        double damgaVergisiKesintisi = toplamGelir * DAMGA_VERGISI_ORAN;
        
        // d. Toplam Kesinti
        double toplamKesinti = sgkKesintisi + gelirVergisiKesintisi + damgaVergisiKesintisi;
        
        // e. Net Maaş
        double netMaas = toplamGelir - toplamKesinti;
        
        // f. İstatistikler
        // Haftalık saat x 4 hafta yaklaşık olarak aylık toplam çalışma saati
        double aylikToplamCalismaSaati = haftalikCalismaSaati * 4 + mesaiSaati;
        double kesintiOrani = (toplamKesinti / toplamGelir) * 100;
        double saatlikNetKazanc = netMaas / aylikToplamCalismaSaati;
        double gunlukNetKazanc = netMaas / IS_GUNU; 

        // 4. Profesyonel Bordro Formatı (printf ile hizalama)
        
        System.out.println("\n====================================");
        System.out.println("         MAAŞ BORDROSU");
        System.out.println("====================================");
        System.out.printf("Çalışan: %s\n", adSoyad);
        System.out.printf("Tarih: %s\n\n", LocalDate.now()); // Sistem Tarihini kullandık.

        // GELIRLER Kısmı
        System.out.println("GELİRLER:");
        // %-25s: 25 karakter sola hizalı metin | %12.2f: 12 karakter sağa hizalı, 2 ondalık basamaklı sayı
        System.out.printf("  %-25s : %12.2f TL\n", "Brüt Maaş", brutMaas);
        System.out.printf("  %-25s : %12.2f TL\n", "Mesai Ücreti (" + mesaiSaati + " saat)", mesaiUcreti);
        System.out.println("  --------------------------------------");
        System.out.printf("  %-25s : %12.2f TL\n\n", "TOPLAM GELİR", toplamGelir);
        
        // KESİNTİLER Kısmı
        System.out.println("KESİNTİLER:");
        // %1.1f: 1 ondalık basamaklı yüzde değeri
        System.out.printf("  %-25s : %12.2f TL\n", "SGK Kesintisi (14.0%)", sgkKesintisi);
        System.out.printf("  %-25s : %12.2f TL\n", "Gelir Vergisi (15.0%)", gelirVergisiKesintisi);
        System.out.printf("  %-25s : %12.2f TL\n", "Damga Vergisi (0.8%)", damgaVergisiKesintisi);
        System.out.println("  --------------------------------------");
        System.out.printf("  %-25s : %12.2f TL\n\n", "TOPLAM KESİNTİ", toplamKesinti);

        // NET MAAŞ
        System.out.printf("** %-25s : %12.2f TL **\n\n", "NET MAAŞ", netMaas);

        // İSTATİSTİKLER Kısmı
        System.out.println("İSTATİSTİKLER:");
        // %-25s: Sola hizalı metin | %6.1f: 6 karakter sağa hizalı, 1 ondalık basamaklı yüzde
        System.out.printf("  %-25s : %6.1f%%\n", "Kesinti Oranı", kesintiOrani);
        System.out.printf("  %-25s : %7.2f TL/saat\n", "Saatlik Net Kazanç", saatlikNetKazanc);
        System.out.printf("  %-25s : %7.2f TL/gün\n", "Günlük Net Kazanç", gunlukNetKazanc);
        System.out.println("====================================");
    }
}

