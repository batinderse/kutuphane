package org.boston.libraries;

import java.util.Scanner;

public class Kutuphane {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library();  
        CirculationStats stats = new CirculationStats(); 

        int secim;

        do {
            System.out.println("\n===== KÜTÜPHANE MENÜ =====");
            System.out.println("1) Kitapları yükle");
            System.out.println("2) Kitapları listele");
            System.out.println("3) Ara (Başlık)");
            System.out.println("4) Ara (Başlık + yıl)");
            System.out.println("5) Ara (Koşula göre - Ortalama puan)");
            System.out.println("6) Sırala (Ortalama puana göre artan)");
            System.out.println("7) Puan Dizisi: Kopya Al (Elle / clone)");
            System.out.println("8) Puan Dizisi: İçerik Eşitliği Testi");
            System.out.println("9) İstatistik: Yıl/Çeyrek Toplamları (2D)");
            System.out.println("0) Çıkış");
            System.out.print("Seçiminiz: ");
            secim = input.nextInt();

            switch (secim) {
                case 1:
                    library.ornekVeriYukle();
                    break;

                case 2:
                    library.kitaplariListele();
                    break;

                case 3:
                    input.nextLine();
                    System.out.print("Aranacak başlık: ");
                    String baslik = input.nextLine();
                    library.ara(baslik);
                    break;

                case 4:
                    input.nextLine();
                    System.out.print("Başlık: ");
                    String b = input.nextLine();
                    System.out.print("Yıl: ");
                    int yil = input.nextInt();
                    library.ara(b, yil);
                    break;

                case 5:
                    System.out.print("Eşik ortalama puan: ");
                    double esik = input.nextDouble();
                    library.ara(esik);
                    break;

                case 6:
                    library.selectionSort();
                    break;

                case 7:
                    library.kopyaTesti();
                    break;

                case 8:
                    library.esitlikTesti();
                    break;

                case 9:
                    stats.testVerisiYukle();
                    stats.yillikOzet();
                    break;

                case 0:
                    System.out.println("Program kapanıyor...");
                    break;

                default:
                    System.out.println("Geçersiz seçim..Tekrar deneyin..");
            }

        } while (secim != 0);

        input.close();
    }
}
