package org.boston.libraries;

import java.util.Arrays;

public class Library {
    private Book[] envanter; 

    
    public Library() {
        envanter = new Book[0]; // başlangıçta boş
    }

    
    public void ornekVeriYukle() {
        envanter = new Book[] {
            new Book("Simyacı", "Paulo Coelho", 1988, new int[] {5, 5, 5, 5}, new String[]{"macera", "felsefe"}),
            new Book("Kürk Mantolu Madonna", "Sabahattin Ali", 1943, new int[] {5, 5, 4, 5}, new String[]{"klasik", "aşk"}),
            new Book("1984", "George Orwell", 1949, new int[] {1, 5, 5, 4}, new String[]{"distopya"}),
            new Book("Hayvan Çiftliği", "George Orwell", 1945, new int[] {2, 4, 5, 4}, new String[]{"siyasi"})
        };
        System.out.println("Örnek kitaplar yüklendi (" + envanter.length + " kitap).");
    }

    
    public void kitaplariListele() {
        if (envanter.length == 0) {
            System.out.println("Kitap bulunmuyor.");
            return;
        }
        for (int i = 0; i < envanter.length; i++) {
            System.out.print((i + 1) + ". ");
            envanter[i].yazdir();
        }
    }

    public void ara(String baslik) {
        boolean bulundu = false;
        for (Book b : envanter) {
            if (b.getBaslik().equalsIgnoreCase(baslik)) {
                b.yazdir();
                bulundu = true;
            }
        }
        if (!bulundu) System.out.println("Kitap bulunamadı.");
    }

    
    public void ara(String baslik, int yil) {
        boolean bulundu = false;
        for (Book b : envanter) {
            if (b.getBaslik().equalsIgnoreCase(baslik) && b.getYil() == yil) {
                b.yazdir();
                bulundu = true;
            }
        }
        if (!bulundu) System.out.println("Eşleşen kitap yok.");
    }

    
    public void ara(double esik) {
        boolean bulundu = false;
        for (Book b : envanter) {
            if (b.getOrtalamaPuan() >= esik) {
                b.yazdir();
                bulundu = true;
            }
        }
        if (!bulundu) System.out.println("Bu eşiği geçen kitap yok.");
    }

    
    public void selectionSort() {
        for (int i = 0; i < envanter.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < envanter.length; j++) {
                if (envanter[j].getOrtalamaPuan() < envanter[minIndex].getOrtalamaPuan()) {
                    minIndex = j;
                }
            }
            
            Book temp = envanter[i];
            envanter[i] = envanter[minIndex];
            envanter[minIndex] = temp;
        }
        System.out.println("Kitaplar ortalama puana göre sıralandı.");
        if (envanter.length > 0) {
            System.out.print("En düşük: ");
            envanter[0].yazdir();
            System.out.print("Ortadaki: ");
            envanter[envanter.length / 2].yazdir();
            System.out.print("En yüksek: ");
            envanter[envanter.length - 1].yazdir();
        }
    }

    
    public void kopyaTesti() {
        if (envanter.length < 1) {
            System.out.println("Önce kitap yükleyin.");
            return;
        }

        Book ilk = envanter[0];
        int[] elle = Book.elleKopya(new int[]{5, 4, 3});
        int[] clone = elle.clone();

        System.out.println("Elle kopya ve clone oluşturuldu.");
        System.out.println("Alias kontrolü: " + (elle == clone ? "Aynı referans" : "Farklı referans (güvenli kopya)"));
    }

    
    public void esitlikTesti() {
        if (envanter.length < 2) {
            System.out.println("⚠En az 2 kitap gerekli.");
            return;
        }
        boolean esit = envanter[0].puanlarEsit(envanter[1]);
        System.out.println(esit ? "Puan dizileri eşit." : "Puan dizileri farklı.");
    }

    
    public Library derinKopya() {
        Library kopya = new Library();
        kopya.envanter = new Book[envanter.length];
        for (int i = 0; i < envanter.length; i++) {
            kopya.envanter[i] = envanter[i].clone();
        }
        return kopya;
    }

    
    public boolean icerikEsit(Library diger) {
        if (this.envanter.length != diger.envanter.length) return false;
        for (int i = 0; i < envanter.length; i++) {
            if (!Book.dizilerEsit(this.envanter[i].clone().clone().puanlar, diger.envanter[i].clone().puanlar)) {
                return false;
            }
        }
        return true;
    }
}
