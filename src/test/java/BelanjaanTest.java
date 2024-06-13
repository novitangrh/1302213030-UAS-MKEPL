import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.belanjaan.Belanjaan;

public class BelanjaanTest {
    private Belanjaan belanjaan;

    @Before
    public void setUp() {
        belanjaan = new Belanjaan();
    }

    @Test
    public void testTambahItem() {
        belanjaan.tambahItem("Sabun", 10000, "Kebutuhan Rumah Tangga");
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");

        assertEquals(30000, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testTambahItemDuplikat() {
        belanjaan.tambahItem("Sabun", 10000, "Kebutuhan Rumah Tangga");
        belanjaan.tambahItem("Sabun", 5000, "Kebutuhan Rumah Tangga");

        assertEquals(15000, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testTambahItemKategoriBerbeda() {
        belanjaan.tambahItem("Buku", 15000, "Alat Tulis");
        belanjaan.tambahItem("Pensil", 5000, "Alat Tulis");

        assertEquals(20000, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testTambahItemKategoriSama() {
        belanjaan.tambahItem("Sabun", 10000, "Kebutuhan Rumah Tangga");
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");

        assertEquals(30000, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testTambahDiskon() {
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");
        belanjaan.tambahDiskon("Shampo", 5000);

        assertEquals(15000, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testTambahBanyakDiskon() {
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");
        belanjaan.tambahItem("Buku", 15000, "Alat Tulis");
        belanjaan.tambahDiskon("Shampo", 5000);
        belanjaan.tambahDiskon("Buku", 3000);

        assertEquals(27000, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testTambahDiskonItemTidakAda() {
        belanjaan.tambahDiskon("Sabun", 5000);
        assertEquals(0, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testHapusItem() {
        belanjaan.tambahItem("Sabun", 10000, "Kebutuhan Rumah Tangga");
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");
        belanjaan.hapusItem("Sabun");

        assertEquals(20000, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testHapusItemTidakAda() {
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");
        belanjaan.hapusItem("Sabun");

        assertEquals(20000, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testReset() {
        belanjaan.tambahItem("Sabun", 10000, "Kebutuhan Rumah Tangga");
        belanjaan.reset();

        assertEquals(0, belanjaan.dapatkanTotalHarga());
        belanjaan.tampilkanItem();
        belanjaan.tampilkanDiskon();
        assertTrue(true);  // Hanya untuk memastikan tampilkanItem() dan tampilkanDiskon() tidak menghasilkan error
    }

    @Test
    public void testTampilkanItem() {
        belanjaan.tambahItem("Sabun", 10000, "Kebutuhan Rumah Tangga");
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");

        belanjaan.tampilkanItem();
        assertTrue(true);  // Hanya untuk memastikan tampilkanItem() tidak menghasilkan error
    }

    @Test
    public void testTampilkanDiskon() {
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");
        belanjaan.tambahDiskon("Shampo", 5000);

        belanjaan.tampilkanDiskon();
        assertTrue(true);  // Hanya untuk memastikan tampilkanDiskon() tidak menghasilkan error
    }

    @Test
    public void testTampilkanTotalDenganDiskon() {
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");
        belanjaan.tambahDiskon("Shampo", 5000);

        belanjaan.tampilkanTotalDenganDiskon();
        assertTrue(true);  // Hanya untuk memastikan tampilkanTotalDenganDiskon() tidak menghasilkan error
    }

    @Test
    public void testDiskonSetelahHapusItem() {
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");
        belanjaan.tambahDiskon("Shampo", 5000);
        belanjaan.hapusItem("Shampo");

        assertEquals(0, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testTambahItemSetelahDiskon() {
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");
        belanjaan.tambahDiskon("Shampo", 5000);
        belanjaan.tambahItem("Sabun", 10000, "Kebutuhan Rumah Tangga");

        assertEquals(25000, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testHapusItemDenganDiskon() {
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");
        belanjaan.tambahDiskon("Shampo", 5000);
        belanjaan.hapusItem("Shampo");

        assertEquals(0, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testTambahDiskonBerulang() {
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");
        belanjaan.tambahDiskon("Shampo", 5000);
        belanjaan.tambahDiskon("Shampo", 3000);

        assertEquals(17000, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testTambahItemTanpaDiskon() {
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");

        assertEquals(20000, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testTambahItemBeberapaKategori() {
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");
        belanjaan.tambahItem("Buku", 15000, "Alat Tulis");

        assertEquals(35000, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testTambahDanHapusBeberapaItem() {
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");
        belanjaan.tambahItem("Sabun", 10000, "Kebutuhan Rumah Tangga");
        belanjaan.hapusItem("Shampo");
        belanjaan.tambahItem("Buku", 15000, "Alat Tulis");

        assertEquals(25000, belanjaan.dapatkanTotalHarga());
    }
    
    @Test
    public void testGagalTambahItem() {
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");
                assertEquals(15000, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testGagalTambahDiskon() {
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");
        belanjaan.tambahDiskon("Shampo", 5000);
        assertEquals(20000, belanjaan.dapatkanTotalHarga());
    }

    @Test
    public void testGagalHapusItem() {
        belanjaan.tambahItem("Shampo", 20000, "Kebutuhan Rumah Tangga");
        belanjaan.hapusItem("Sabun");
        assertEquals(0, belanjaan.dapatkanTotalHarga());
    }

}
