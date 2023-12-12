import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
public class InventarisTest {
    
    static LocalDate tanggal = LocalDate.now();
    static LocalTime waktu = LocalTime.now();
    static Scanner sc = new Scanner(System.in);
    static String gudang1[][] = new String[15][4];
    static String gudang2[][] = new String[15][4];
    static String gudang3[][] = new String[15][4];
    static String[] riwayat = new String[20];
    static String username = "Nama user";
    static int indeksRiwayat = 0;
    static String barang;
    static int jumlah;
    static int angkaAcak;

    public static void main(String[] args) {
    boolean logIn = false;
    int pilihan;
    gudang1[0][0] = "Laptop Lenovo";
    gudang1[0][1] = String.valueOf((int) (Math.random() * 100000) + 1);
    gudang1[0][2] = "Baik";
    gudang1[0][3] = "6";
    gudang1[1][0] = "Laptop Asus";
    gudang1[1][1] = String.valueOf((int) (Math.random() * 100000) + 1);
    gudang1[1][2] = "Baik";
    gudang1[1][3] = "7";
    gudang1[2][0] = "Keyboard Rexus";
    gudang1[2][1] = String.valueOf((int) (Math.random() * 100000) + 1);
    gudang1[2][2] = "Rusak";
    gudang1[2][3] = "9";
    gudang2[0][0] = "Headset Logitech";
    gudang2[0][1] = String.valueOf((int) (Math.random() * 100000) + 1);
    gudang2[0][2] = "Baik";
    gudang2[0][3] = "5";
    gudang2[1][0] = "Headset Rexus";
    gudang2[1][1] = String.valueOf((int) (Math.random() * 100000) + 1);
    gudang2[1][2] = "Baik";
    gudang2[1][3] = "6";
    gudang2[2][0] = "Camera Canon";
    gudang2[2][1] = String.valueOf((int) (Math.random() * 100000) + 1);
    gudang2[2][2] = "Baik";
    gudang2[2][3] = "10";
    gudang3[0][0] = "Headset Xiaomi";
    gudang3[0][1] = String.valueOf((int) (Math.random() * 100000) + 1);
    gudang3[0][2] = "Baik";
    gudang3[0][3] = "9";
    gudang3[1][0] = "Mic Hardwell";
    gudang3[1][1] = String.valueOf((int) (Math.random() * 100000) + 1);
    gudang3[1][2] = "Baik";
    gudang3[1][3] = "7";
    gudang3[2][0] = "Monitor Asus";
    gudang3[2][1] = String.valueOf((int) (Math.random() * 100000) + 1);
    gudang3[2][2] = "Baik";
    gudang3[2][3] = "10";

    while (true) {
        
        // sistem log in
        while (logIn == false) {
            System.out.println("===================================================================================================");
            System.out.println("|                           SELAMAT DATANG DI SISTEM INVENTARIS GUDANG                            |");
            System.out.println("===================================================================================================");
            System.out.print("Masukkan username: ");
            username = sc.nextLine();
            System.out.print("Masukkan password: ");
            String password = sc.nextLine(); 
            if ((username.equals("Admin1") || username.equals("Admin2") || username.equals("Admin3")) && password.equals("12345")) {
                System.out.println("Log in berhasil!");
                logIn = true;
            }else {
                System.out.println("Log in gagal!");        
            }
        }
    // menu utama
    while (logIn == true) {
        System.out.println("===================================================================================================");
        System.out.println("|                                         MENU UTAMA                                              |");
        System.out.println("===================================================================================================");
        System.out.println("|                         1. Tambahkan barang          5. Log Out                                 |");
        System.out.println("|                         2. Ambil Barang              6. Keluar                                  |");
        System.out.println("|                         3. Update Barang             7. Help                                    |");
        System.out.println("|                         4. Pelaporan                                                            |");  
        System.out.println("===================================================================================================");
        System.out.print("      Pilih menu: ");
        pilihan = sc.nextInt();
        switch (pilihan) {
            // sistem menambah barang
            case 1:
            while (true) {
                System.out.println("===================================================================================================");
                System.out.println("|                                       TAMBAHKAN BARANG                                          |");
                System.out.println("===================================================================================================");
                System.out.print("Masukkan nama barang: ");
                sc.nextLine();
                barang = sc.nextLine();
                do {
                    angkaAcak = (int) (Math.random() * 100000) + 1;
    
                    boolean cekkodeUnik = false;
                    for (int i = 0; i < gudang1.length; i++) {
                        if (String.valueOf(angkaAcak) == gudang1[i][2] || String.valueOf(angkaAcak) == gudang2[i][2] || String.valueOf(angkaAcak) == gudang3[i][2]) {
                            cekkodeUnik = true;
                            break;
                        }
                    }
                    if (!cekkodeUnik) {
                        break;
                    }
                } while (true);
                System.out.print("Pilih nomor gudang (1,2,3): ");
                int pilihanGudang = sc.nextInt();
                System.out.print("Masukkan jumlah barang: ");
                sc.nextLine();
                jumlah = sc.nextInt();
                
                riwayat[indeksRiwayat] = "- Menambahkan " + barang + " sebanyak " + jumlah + " ke Gudang " + pilihanGudang + " oleh " + username + "\n  pada tanggal " + tanggal + " di jam " + waktu;
                indeksRiwayat++;
                
                switch (pilihanGudang) {
                    case 1:
                    tambahBarang(gudang1);
                    break;
        
                    case 2:
                        tambahBarang(gudang2);
                        break;
                        
                    case 3:
                        tambahBarang(gudang3);
                        break;
                        
                        default:
                        System.out.println("Masukan tidak valid");
                        break;
                    }
                    
                    System.out.println("-------------------------------------");
                    System.out.println("|    1. Kembali Menambahkan Barang  | ");
                    System.out.println("|    2. Kembali ke Menu Utama       |");
                    System.out.println("-------------------------------------");
                    System.out.print("Silahkan pilih opsi 1 atau 2 : ");
                    int tambahLagi = sc.nextInt();
                    if (tambahLagi != 1) {
                        break;
                    }
                }
                break;

            // sistem ambil barang
            case 2:
            while (true) {
            System.out.println("===================================================================================================");
            System.out.println("|                                       AMBIL BARANG                                              |");
            System.out.println("===================================================================================================");
            System.out.print("Pilih nomer gudang yang ingin dikosongkan (1,2,3): ");
            int BarangGudang = sc.nextInt();
            sc.nextLine();

            switch (BarangGudang) {
                case 1:
                displayGudang(BarangGudang, gudang1);
                ambilBarang(gudang1);
                riwayat[indeksRiwayat] = "- Mengambil " + barang +" sebanyak " + jumlah + " dari Gudang " + BarangGudang + " oleh " + username + "\n  pada tanggal " + tanggal + " di jam " + waktu;
                indeksRiwayat++;
                break;

                case 2:
                displayGudang(BarangGudang, gudang2);
                ambilBarang(gudang2);
                riwayat[indeksRiwayat] = "- Mengambil " + barang +" sebanyak " + jumlah + " dari Gudang " + BarangGudang + " oleh " + username + "\n  pada tanggal " + tanggal + " di jam " + waktu;
                indeksRiwayat++;
                break;

                case 3:
                displayGudang(BarangGudang, gudang3);
                ambilBarang(gudang3);
                riwayat[indeksRiwayat] = "- Mengambil " + barang +" sebanyak " + jumlah + " dari Gudang " + BarangGudang + " oleh " + username + "\n  pada tanggal " + tanggal + " di jam " + waktu;
                indeksRiwayat++;
                break;
            } 
            System.out.println("-------------------------------------");
            System.out.println("|    1. Kembali Mengambil Barang    | ");
            System.out.println("|    2. Kembali ke Menu Utama       |");
            System.out.println("-------------------------------------");
            System.out.print("Silahkan pilih opsi 1 atau 2 : ");
            int ambilLagi = sc.nextInt();
            if (ambilLagi != 1) {
                    break;
            }
        } break;
        
            // sistem Update Barang
            case 3:
            while (true) {
            System.out.println("===================================================================================================");
            System.out.println("|                                       UPDATE BARANG                                             |");
            System.out.println("===================================================================================================");
            System.out.print("Pilih gudang (1,2,3): ");
            int pilGudang = sc.nextInt();
            System.out.println("Barang di Gudang " + pilGudang + ":");
            switch (pilGudang) {
                case 1:
                displayGudang(pilGudang, gudang1);
                updateGudang(1, gudang1);
                break;

                case 2:
                displayGudang(pilGudang, gudang2);
                updateGudang(2, gudang2);
                break;

                case 3:
                displayGudang(pilGudang, gudang3);
                updateGudang(3, gudang3);
                break;
                
                default:
                System.out.println("Input tidak valid");
                break;
                }
                System.out.println("-------------------------------------");
                System.out.println("|    1. Kembali Mengupdate Barang   | ");
                System.out.println("|    2. Kembali ke Menu Utama       |");
                System.out.println("-------------------------------------");
                System.out.print("Silahkan pilih opsi 1 atau 2 : ");
                int ambilLagi = sc.nextInt();
                if (ambilLagi != 1) {
                    break;
                }
            } break;
            
            case 4:
            //sistem pelaporan
            boolean loop = true;
            while (loop == true) {
            System.out.println("===================================================================================================");
            System.out.println("|                                          PELAPORAN                                              |");
            System.out.println("===================================================================================================");
            System.out.println("|                                       1. Lihat Gudang                                           |");
            System.out.println("|                                       2. Riwayat                                                |");
            System.out.println("|                                       3. Cari barang                                            |");
            System.out.println("|                                       4. Kembali ke menu utama                                  |");
            System.out.println("===================================================================================================");
            System.out.print("Pilih Menu: ");
                int pilihan2 = sc.nextInt();
                switch (pilihan2) {
                    //sistem lihat gudang beserta atributnya
                    case 1:
                    System.out.println("===================================================================================================");
                    System.out.println("|                                       LIHAT GUDANG                                              |");
                    System.out.println("===================================================================================================");
                    System.out.print("Pilih gudang (1,2,3): ");
                    int pilhGud = sc.nextInt();
                    switch (pilhGud) {
                        case 1:
                        displayGudang(1, gudang1);
                        break;

                        case 2:
                        displayGudang(2, gudang2);
                        break;

                        case 3:
                        displayGudang(3, gudang3);
                        break;
                        
                    }break;
                    
                    default:
                    System.out.println("Pilihan tidak valid");
                    break;
                    case 2:
                    System.out.println("===================================================================================================");
                    System.out.println("|                                            RIWAYAT                                              |");
                    System.out.println("===================================================================================================");
                    for (int i = 0; i < indeksRiwayat; i++) {
                        System.out.println(riwayat[i]);
                    } 
                    if (riwayat[0] == null) {
                        System.out.println("Masih belum ada aktivitas");
                    }
                        break;
                        
                        
                        case 3:
                        
                        // sistem untuk memilih metode pencarian. bisa berupa nama barang atau kode unik
                        System.out.println("===================================================================================================");
                        System.out.println("|                                        CARI BARANG                                              |");
                        System.out.println("==================================================================================================="); 
                        System.out.println("|                               Pilih metode pencarian :                                          |");
                        System.out.println("|                                 1. Berdasarkan nama                                             |");
                        System.out.println("|                                 2. Berdasarkan kode unik                                        |");
                        System.out.println("===================================================================================================");
                        System.out.print("Pilih metode: ");
                        int metode = sc.nextInt();
                        
                        switch (metode) {
                            
                            // sistem pencarian barang menggunakan nama barang
                            case 1:
                            
                            // pencarian di gudang 1
                            System.out.print("Masukkan keyword (nama barang): ");
                            sc.nextLine();
                            String keywordNamaBarang = sc.nextLine();
                            int number = 1;
                            for (int i = 0; i < gudang1.length; i++) {
                                if (keywordNamaBarang.equalsIgnoreCase(gudang1[i][0])) {
                                    System.out.println(number +". "+  gudang1[i][0] + " Terdapat pada gudang 1 di urutan ke-" + (i+1)+" dengan kode unik " + gudang1[i][1]);
                                    number++;
                                }
                            }
                            
                            // pencarian di gudang 2                            
                            for (int i = 0; i < gudang2.length; i++) {
                                if (keywordNamaBarang.equalsIgnoreCase(gudang2[i][0])) {
                                    System.out.println(number +". "+  gudang2[i][0] + " Terdapat pada gudang 2 di urutan ke-" + (i+1) + " dengan kode unik " + gudang2[i][1]);
                                    number++;
                                }
                            }
                            
                            // pencarian di gudang 3
                            for (int i = 0; i < gudang3.length; i++) {
                                if (keywordNamaBarang.equalsIgnoreCase(gudang3[i][0])) {
                                    System.out.println(number +". "+  gudang3[i][0]  + " Terdapat pada gudang 3 di urutan ke-"+(i+1)+ " dengan kode unik " + gudang3[i][1]);
                                    number++;
                                }
                            }
                            number = 1;
                            break;
                            
                            // sistem pencarian barang menggunakan kode unik
                            case 2:
                            System.out.print("Masukkan keyword (kode unik barang): ");
                            sc.nextLine();
                            String keywordKodeUnik = sc.nextLine();

                            // sistem pencarian di gudang 1
                            for (int i = 0; i < gudang1.length; i++) {
                                if (keywordKodeUnik.equalsIgnoreCase(gudang1[i][1])) {
                                    System.out.println("Barang yang anda cari terdapat di gudang 1 di urutan ke-"+ (i+1));
                                }
                            }
                            // sistem pencarian di gudang 2
                            for (int i = 0; i < gudang2.length; i++) {
                                if (keywordKodeUnik.equalsIgnoreCase(gudang2[i][1])) {
                                    System.out.println("Barang yang anda cari terdapat di gudang 2 di urutan ke-"+ (i+1));
                                }
                            }
                            // sistem pencarian di gudang 3
                            for (int i = 0; i < gudang3.length; i++) {
                                if (keywordKodeUnik.equalsIgnoreCase(gudang3[i][1])) {
                                    System.out.println("Barang yang anda cari terdapat di gudang 3 di urutan ke-"+ (i+1));
                                }
                            }
                            break;
                            
                            default:
                            System.out.println("Pilihan tidak valid");
                            break;
                        }
                        case 4:
                        loop = false;
                        continue;
                        
                    }
                    System.out.println("-------------------------------------");
                    System.out.println("|    1. Kembali ke Menu Pelaporan   | ");
                    System.out.println("|    2. Kembali ke Menu Utama       |");
                    System.out.println("-------------------------------------");
                    System.out.print("Silahkan pilih opsi 1 atau 2 : ");
                    int pelaporanLagi = sc.nextInt();
                    if (pelaporanLagi != 1) {
                        break;
                    }
                }
                break;
                
                case 5:
                    //Sistem kembali ke menu Log In
                    logIn = false;
                    sc.nextLine();
                    break;
                    
                    // sistem untuk keluar
                    case 6:
                    System.exit(0);
                    break;
                    
                    case 7:
                    break;
                }
            }
        }  
    }
    
    public static void tambahBarang(String[][] gudang) {
            for (int i = 0; i < gudang.length; i++) {
                if (gudang[i][0] != null && gudang[i][0].equalsIgnoreCase(barang)) {
                    int jumlahBarang = Integer.parseInt(gudang[i][3]);
                    jumlahBarang += jumlah;
                    gudang[i][3] = String.valueOf(jumlahBarang);
                    break;
                } else if (gudang[i][0] == null) {
                    System.out.println("Kode unik barang " + angkaAcak);
                    gudang[i][0] = barang;
                    gudang[i][1] = String.valueOf(angkaAcak);
                    gudang[i][2] = "Baik";
                    gudang[i][3] = String.valueOf(jumlah);
                    break;
                }
            }
        }
    
    public static void ambilBarang(String[][] gudang) {
        boolean ambilLagi = true;
        while (ambilLagi) {
            System.out.print("Masukkan kode unik barang: ");
            String unikBarang = sc.nextLine();
            for (int i = 0; i < gudang.length; i++) {
                if (unikBarang!= null && unikBarang.equals(gudang[i][1])) {
                    int jumlahSekarang = Integer.parseInt(gudang[i][3]);
                    if (jumlahSekarang > 0) {
                        System.out.print("Masukkan jumlah yang ingin di ambil: ");
                        jumlah = sc.nextInt();
                        if (jumlah <= jumlahSekarang) {
                            jumlahSekarang -= jumlah;
                            gudang[i][3] = String.valueOf(jumlahSekarang);
                            barang = gudang[i][0];
                            if (jumlahSekarang == 0) {
                                gudang[i][0] = null;
                            }
                            System.out.println("Ambil barang berhasil!");
                        }else {
                            System.out.println("Jumlah melebihi stok barang");
                        }
                    }return;
                }
            }
            System.out.println("Barang tidak ditemukan");
        }
    }

    public static void displayGudang (int nomer, String[][] gudang) {
                        System.out.println("=============================================================================================");
                        System.out.println("|                                    LIST BARANG GUDANG "+nomer+"                                   |");
                        System.out.println("============================================================================================="); 
                        System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n","Nama","Kode","Kondisi","Jumlah");
                        System.out.println("=============================================================================================");
                        for (int i = 0; i < gudang.length; i++) {
                            if (gudang[i][0] != null) {
                                System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n",gudang[i][0],gudang[i][1],gudang[i][2],gudang[i][3]);
                            }
                        }
                        System.out.print("Klik enter untuk melanjutkan");
                        sc.nextLine();
                        sc.nextLine();
    }

    public static void updateGudang (int angka, String[][] gudang) {
                System.out.println();
                sc.nextLine();
                System.out.print("Masukkan kode unik barang yang ingin di update: ");
                String barangLama = sc.nextLine();
                for (int i = 0; i < gudang.length; i++) {
                    if (gudang[i][1]!= null && gudang[i][1].equals(barangLama)) {
                        System.out.println("===================================================================================================");
                        System.out.println("|                                    MENU UPDATE BARANG                                           |");
                        System.out.println("===================================================================================================");
                        System.out.println("|                                    1. Nama Barang                                               |");
                        System.out.println("|                                    2. Kondisi Barang                                            |");
                        System.out.println("|                                    3. Jumlah Barang                                             |");
                        System.out.println("===================================================================================================");
                        System.out.print("Masukkan nomor menu untuk update barang (1,2,3): ");
                        String menuUpdate = sc.nextLine();
                        if (menuUpdate.equals("1")) {
                            System.out.print("Masukkan nama kategori barang yang baru: ");
                            gudang[i][0] = sc.nextLine();
                            System.out.println("Barang Berhasil di Update");
                            riwayat[indeksRiwayat] = "- Mengupdate Nama Barang " + gudang[i][0] + " dengan kode unik " + barangLama + " di Gudang "+ angka +" oleh " + username + "\n  pada tanggal " + tanggal + " di jam " + waktu;
                            indeksRiwayat++;
                        }else if (menuUpdate.equals("2")) {
                            System.out.print("Masukkan kondisi barang sekarang (Baik/Rusak): ");
                            gudang[i][2] = sc.nextLine();
                            System.out.println("Barang Berhasil di Update");
                            riwayat[indeksRiwayat] = "- Mengupdate Kondisi Barang " + gudang[i][0] + " dengan kode unik " + barangLama + " di Gudang "+ angka +" oleh " + username + "\n  pada tanggal " + tanggal + " di jam " + waktu;
                            indeksRiwayat++;
                        }else if (menuUpdate.equals("3")) {
                            System.out.print("Masukkan jumlah barang yang baru: ");
                            gudang[i][3] = sc.nextLine();
                            System.out.println("Barang Berhasil di Update");
                            riwayat[indeksRiwayat] = "- Mengupdate Jumlah Barang " + gudang[i][0] + " dengan kode unik " + barangLama + " di Gudang " + angka + " oleh " + username + "\n  pada tanggal " + tanggal + " di jam " + waktu;
                            indeksRiwayat++;
                        }else
                        System.out.println("Input tidak valid");
                        break;
                    }
                }
    }
}