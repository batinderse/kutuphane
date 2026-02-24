package org.boston.libraries;
import java.util.Arrays;

public class Book implements Cloneable {
    private String baslik;
    private String yazar;
    private int yil;
    int[] puanlar;
    private String[] etiketler;

    
    public Book() {
        this.baslik = "Bilinmeyen";
        this.yazar = "Anonim";
        this.yil = 2000;
        this.puanlar = new int[] { 3, 4, 5 };
        this.etiketler = new String[0];
    }

    
    public Book(String baslik, String yazar, int yil, int[] puanlar, String[] etiketler) {
        this.baslik = baslik;
        this.yazar = yazar;
        this.yil = yil;
       
        this.puanlar = Arrays.copyOf(puanlar, puanlar.length);
        this.etiketler = Arrays.copyOf(etiketler, etiketler.length);
    }

    
    public double ortalamaPuan() {
        int toplam = 0;
        for (int p : puanlar) toplam += p;
        return (double) toplam / puanlar.length;
    }

    
    public void etiketEkle(String yeniEtiket) {
        String[] yeni = Arrays.copyOf(etiketler, etiketler.length + 1);
        yeni[yeni.length - 1] = yeniEtiket;
        etiketler = yeni;
    }

    
    public void etiketCikar(String silinecek) {
        int index = -1;
        for (int i = 0; i < etiketler.length; i++) {
            if (etiketler[i].equalsIgnoreCase(silinecek)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            String[] yeni = new String[etiketler.length - 1];
            for (int i = 0, j = 0; i < etiketler.length; i++) {
                if (i != index) yeni[j++] = etiketler[i];
            }
            etiketler = yeni;
        }
    }

   
    public boolean puanlarEsit(Book diger) {
        if (this.puanlar.length != diger.puanlar.length) return false;
        for (int i = 0; i < puanlar.length; i++) {
            if (puanlar[i] != diger.puanlar[i]) {
                System.out.println("Farklı puan indexi: " + i);
                return false;
            }
        }
        return true;
    }

    
    public static boolean dizilerEsit(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    
    public static int[] elleKopya(int[] kaynak) {
        int[] yeni = new int[kaynak.length];
        for (int i = 0; i < kaynak.length; i++) {
            yeni[i] = kaynak[i];
        }
        return yeni;
    }

   
    @Override
    public Book clone() {
        try {
            Book kopya = (Book) super.clone();
            kopya.puanlar = this.puanlar.clone();
            kopya.etiketler = this.etiketler.clone();
            return kopya;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    
    public void yazdir() {
        System.out.println(baslik + " | " + yazar + " | " + yil +
            " | Ort. Puan: " + String.format("%.2f", ortalamaPuan()));
    }

   
    public String getBaslik() { return baslik; }
    public int getYil() { return yil; }
    public double getOrtalamaPuan() { return ortalamaPuan(); }
}
