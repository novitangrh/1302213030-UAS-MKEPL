package com.example.belanjaan;

import java.util.HashMap;
import java.util.Map;

public class Belanjaan {
    private Map<String, Integer> items;
    private Map<String, String> categories;
    private int totalHarga;
    private Map<String, Integer> discounts;
    private boolean hasDiscount;

    public Belanjaan() {
        items = new HashMap<>();
        categories = new HashMap<>();
        totalHarga = 0;
        discounts = new HashMap<>();
        hasDiscount = false;
    }

    public void tambahItem(String nama, int harga, String kategori) {
        if (items.containsKey(nama)) {
            System.out.println("Item sudah ada di keranjang. Menambahkan harga item.");
            items.put(nama, items.get(nama) + harga);
        } else {
            items.put(nama, harga);
            categories.put(nama, kategori);
        }
        totalHarga += harga;
    }

    public void tambahDiskon(String nama, int diskon) {
        if (items.containsKey(nama)) {
            discounts.put(nama, diskon);
            hasDiscount = true;
        } else {
            System.out.println("Item tidak ditemukan untuk diskon.");
        }
    }

    public void hapusItem(String nama) {
        if (items.containsKey(nama)) {
            totalHarga -= items.get(nama);
            items.remove(nama);
            categories.remove(nama);
            if (discounts.containsKey(nama)) {
                discounts.remove(nama);
            }
        } else {
            System.out.println("Item tidak ditemukan di keranjang.");
        }
    }

    public int dapatkanTotalHarga() {
        if (hasDiscount) {
            int totalDiskon = 0;
            for (Map.Entry<String, Integer> entry : discounts.entrySet()) {
                totalDiskon += entry.getValue();
            }
            return totalHarga - totalDiskon;
        }
        return totalHarga;
    }

    public void reset() {
        items.clear();
        categories.clear();
        discounts.clear();
        totalHarga = 0;
        hasDiscount = false;
    }

    public void tampilkanItem() {
        System.out.println("Daftar Belanjaan:");
        for (Map.Entry<String, Integer> item : items.entrySet()) {
            String kategori = categories.get(item.getKey());
            System.out.println(item.getKey() + " (" + kategori + "): " + item.getValue());
        }
    }

    public void tampilkanDiskon() {
        if (hasDiscount) {
            System.out.println("Daftar Diskon:");
            for (Map.Entry<String, Integer> discount : discounts.entrySet()) {
                System.out.println(discount.getKey() + ": " + discount.getValue());
            }
        } else {
            System.out.println("Tidak ada diskon yang diterapkan.");
        }
    }

    public void tampilkanTotalDenganDiskon() {
        System.out.println("Total Harga (Dengan Diskon): " + dapatkanTotalHarga());
    }
}