package org.boston.libraries;

public class CirculationStats {
    private int[][] kullanimlar;

   
    public CirculationStats() {
        kullanimlar = new int[0][0];
    }

    public void testVerisiYukle() {
        
        kullanimlar = new int[][] {
            {120, 135, 150, 110},  // 2022
            {160, 175, 180, 155},  // 2023
            {190, 210, 220, 205}   // 2024
        };
        System.out.println("Örnek istatistik verisi yüklendi (" + kullanimlar.length + " yıl).");
    }

   
    public int yilToplami(int yilIndeksi) {
        if (yilIndeksi < 0 || yilIndeksi >= kullanimlar.length) {
            System.out.println("Geçersiz yıl indeksi!");
            return 0;
        }
        int toplam = 0;
        for (int i = 0; i < kullanimlar[yilIndeksi].length; i++) {
            toplam += kullanimlar[yilIndeksi][i];
        }
        return toplam;
    }

    
    public void enYogunCeyrek() {
        int max = Integer.MIN_VALUE;
        int yil = -1, ceyrek = -1;
        for (int i = 0; i < kullanimlar.length; i++) {
            for (int j = 0; j < kullanimlar[i].length; j++) {
                if (kullanimlar[i][j] > max) {
                    max = kullanimlar[i][j];
                    yil = i;
                    ceyrek = j;
                }
            }
        }
        System.out.println("En yoğun çeyrek: Yıl " + (2022 + yil) + 
                           ", " + (ceyrek + 1) + ". çeyrek (" + max + " kullanım)");
    }

    
    public void yillikOzet() {
        if (kullanimlar.length == 0) {
            System.out.println("Veri yok,önce testVerisiYukle() çağırın.");
            return;
        }

        System.out.println("\n==== YILLIK KULLANIM ÖZETİ ====");
        for (int i = 0; i < kullanimlar.length; i++) {
            int toplam = yilToplami(i);
            System.out.println((2022 + i) + " yılı toplam: " + toplam);
        }
        enYogunCeyrek();
    }
}
