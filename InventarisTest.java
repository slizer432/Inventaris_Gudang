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
        System.out.println("|                            1. Lihat Gudang                                                      |");
        System.out.println("|                            2. Riwayat                                                           |");
        System.out.println("|                            3. Cari Barang                                                       |");
        System.out.println("===================================================================================================");
        System.out.print("      Pilih menu: ");
        pilihan = sc.nextInt();
        switch (pilihan) {
            // sistem menambah barang
            case 1:
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
            System.out.print("Pilih nomer gudang (1,2,3): ");
            int pilihanGudang = sc.nextInt();
            System.out.print("Masukkan jumlah barang: ");
            sc.nextLine();
            jumlah = sc.nextInt();
            riwayat[indeksRiwayat] = "Menambahkan " + barang +" sebanyak " + jumlah + " ke Gudang " + pilihanGudang + " oleh " + username + " pada tanggal " + tanggal + " di jam " + waktu;
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
                
                } break;

            // sistem ambil barang
            case 2:
            System.out.println("===================================================================================================");
            System.out.println("|                                       AMBIL BARANG                                              |");
            System.out.println("===================================================================================================");
            System.out.print("Pilih nomer gudang yang ingin dikosongkan (1,2,3): ");
            int BarangGudang = sc.nextInt();
            sc.nextLine();
            System.out.println("Barang di Gudang " + BarangGudang + ":");
            switch (BarangGudang) {
                case 1:
                ambilBarang(gudang1);
                break;

                case 2:
                ambilBarang(gudang2);
                break;

                case 3:
                ambilBarang(gudang3);
                break;

        }break;
        
        // sistem Update Barang
        case 3:
        System.out.println("===================================================================================================");
        System.out.println("|                                       UPDATE BARANG                                             |");
        System.out.println("===================================================================================================");
        System.out.print("Pilih gudang (1,2,3): ");
        int pilGudang = sc.nextInt();
        System.out.println("Barang di Gudang " + pilGudang + ":");
        switch (pilGudang) {
            case 1:
            for (int i = 0; i < gudang1.length; i++) {
                if (gudang1[i][0]!=null) {
                    System.out.print(gudang1[i][0] + ": ");
                    System.out.print(gudang1[i][1]);
                    System.out.println();
                }
            }
            System.out.println();
            sc.nextLine();
                System.out.print("Masukkan kode unik barang yang ingin di update: ");
                String barangLama = sc.nextLine();
                for (int i = 0; i < gudang1.length; i++) {
                    if (gudang1[i][1]!= null && gudang1[i][1].equals(barangLama)) {
                        System.out.println("===================================================================================================");
                        System.out.println("|                                    MENU UPDATE BARANG                                           |");
                        System.out.println("===================================================================================================");
                        System.out.println("|                                    1. Nama Barang                                               |");
                        System.out.println("|                                    2. Kondisi Barang                                            |");
                        System.out.println("|                                    3. Deskripsi Barang                                          |");
                        System.out.println("===================================================================================================");
                        System.out.print("Masukkan nomor menu untuk update barang (1,2,3): ");
                        String menuUpdate = sc.nextLine();
                        if (menuUpdate.equals("1")) {
                            System.out.print("Masukkan nama barang yang baru: ");
                            gudang1[i][0] = sc.nextLine();
                            System.out.println("Barang Berhasil di Update");
                        }else if (menuUpdate.equals("2")) {
                            System.out.print("Masukkan kondisi barang sekarang (Baik/Rusak): ");
                            gudang1[i][2] = sc.nextLine();
                            System.out.println("Barang Berhasil di Update");
                        }else if (menuUpdate.equals("3")) {
                            System.out.print("Masukkan deskripsi barang yang baru: ");
                            gudang1[i][3] = sc.nextLine();
                            System.out.println("Barang Berhasil di Update");
                        }else
                        System.out.println("Input tidak valid");
                        break;
                    }
                }break;
                
                case 2:
                for (int i = 0; i < gudang2.length; i++) {
                    if (gudang2[i][0]!=null) {
                        System.out.print(gudang2[i][0] + ": ");
                        System.out.print(gudang2[i][1]);
                        System.out.println();
                    }
                }
                System.out.println();
                sc.nextLine();
                System.out.print("Masukkan kode unik barang yang ingin di update: ");
                barangLama = sc.nextLine();
                for (int i = 0; i < gudang2.length; i++) {
                    if (gudang2[i][1]!= null && gudang2[i][1].equals(barangLama)) {
                        System.out.println("===================================================================================================");
                        System.out.println("|                                    MENU UPDATE BARANG                                           |");
                        System.out.println("===================================================================================================");
                        System.out.println("|                                    1. Nama Barang                                               |");
                        System.out.println("|                                    2. Kondisi Barang                                            |");
                        System.out.println("|                                    3. Deskripsi Barang                                          |");
                        System.out.println("===================================================================================================");
                        System.out.print("Masukkan nomor menu untuk update barang (1,2,3): ");
                        String menuUpdate = sc.nextLine();
                        if (menuUpdate.equals("1")) {
                            System.out.print("Masukkan nama barang yang baru: ");
                            gudang2[i][0] = sc.nextLine();
                            System.out.println("Barang Berhasil di Update");
                        }else if (menuUpdate.equals("2")) {
                            System.out.print("Masukkan kondisi barang sekarang (Baik/Rusak): ");
                            gudang2[i][2] = sc.nextLine();
                            System.out.println("Barang Berhasil di Update");
                        }else if (menuUpdate.equals("3")) {
                            System.out.print("Masukkan deskripsi barang yang baru: ");
                            gudang2[i][3] = sc.nextLine();
                            System.out.println("Barang Berhasil di Update");
                        }else
                        System.out.println("Input tidak valid");
                        break;
                    }
                }break;
                
                case 3:
                for (int i = 0; i < gudang3.length; i++) {
                    if (gudang3[i][0]!=null) {
                        System.out.print(gudang3[i][0] + ": ");
                        System.out.print(gudang3[i][1]);
                    }
                }
                System.out.println();
                sc.nextLine();
                System.out.print("Masukkan kode unik barang yang ingin di update: ");
                barangLama = sc.nextLine();
                for (int i = 0; i < gudang3.length; i++) {
                    if (gudang3[i][1]!= null && gudang3[i][1].equals(barangLama)) {
                        System.out.println("===================================================================================================");
                        System.out.println("|                                    MENU UPDATE BARANG                                           |");
                        System.out.println("===================================================================================================");
                        System.out.println("|                                    1. Nama Barang                                               |");
                        System.out.println("|                                    2. Kondisi Barang                                            |");
                        System.out.println("|                                    3. Deskripsi Barang                                          |");
                        System.out.println("===================================================================================================");
                        System.out.print("Masukkan nomor menu untuk update barang (1,2,3): ");
                        String menuUpdate = sc.nextLine();
                        if (menuUpdate.equals("1")) {
                            System.out.print("Masukkan nama barang yang baru: ");
                            gudang3[i][0] = sc.nextLine();
                            System.out.println("Barang Berhasil di Update");
                        }else if (menuUpdate.equals("2")) {
                            System.out.print("Masukkan kondisi barang sekarang (Baik/Rusak): ");
                            gudang3[i][2] = sc.nextLine();
                            System.out.println("Barang Berhasil di Update");
                        }else if (menuUpdate.equals("3")) {
                            System.out.print("Masukkan deskripsi barang yang baru: ");
                            gudang3[i][3] = sc.nextLine();
                            System.out.println("Barang Berhasil di Update");
                        }else
                        System.out.println("Input tidak valid");
                        break;
                    }
                }break;
                
                default:
                System.out.println("Barang Tidak Ditemukan");
                break;
            }break;
            
            case 4:
            //sistem pelaporan
            System.out.println("===================================================================================================");
            System.out.println("|                                          PELAPORAN                                              |");
            System.out.println("===================================================================================================");
            System.out.println("|                                       1. Lihat Gudang                                           |");
            System.out.println("|                                       2. Riwayat                                                |");
            System.out.println("|                                       3. Cari barang                                            |");
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
                        System.out.println("=============================================================");
                        System.out.println("|                    LIST BARANG GUDANG 1                   |");
                        System.out.println("=============================================================");
                        System.out.printf("| %-12s | %-12s | %-12s | %-12s |\n","Nama","Kode","Kondisi","Deskripsi");
                        System.out.println("=============================================================");
                        for (int i = 0; i < gudang1.length; i++) {
                            if (gudang1[i][0] != null) {
                                System.out.printf("| %-12s | %-12s | %-12s | %-12s |\n",gudang1[i][0],gudang1[i][1],gudang1[i][2],gudang1[i][3]);
                            }
                        }
                        System.out.print("Ketik apapun untuk kembali ke menu: ");
                        String kembali = sc.nextLine();
                        sc.nextLine();
                        if (kembali.equalsIgnoreCase("")) {
                            break;
                        }
                        case 2:
                        System.out.println("=============================================================");
                        System.out.println("|                    LIST BARANG GUDANG 2                   |");
                        System.out.println("=============================================================");
                        System.out.printf("| %-12s | %-12s | %-12s | %-12s |\n","Nama","Kode","Kondisi","Deskripsi");
                        System.out.println("=============================================================");
                        for (int i = 0; i < gudang2.length; i++) {
                            if (gudang2[i][0] != null) {
                                System.out.printf("| %-12s | %-12s | %-12s | %-12s |\n",gudang2[i][0],gudang2[i][1],gudang2[i][2],gudang2[i][3]);
                            }
                        }
                        System.out.print("Ketik apapun untuk kembali ke menu: ");
                        kembali = sc.nextLine();
                        sc.nextLine();
                        if (kembali.equalsIgnoreCase("")) {
                            break;
                        }
                        case 3:
                        System.out.println("=============================================================");
                        System.out.println("|                    LIST BARANG GUDANG 3                   |");
                        System.out.println("=============================================================");
                        System.out.printf("| %-12s | %-12s | %-12s | %-12s |\n","Nama","Kode","Kondisi","Deskripsi");
                        System.out.println("=============================================================");
                        for (int i = 0; i < gudang3.length; i++) {
                            if (gudang3[i][0] != null) {
                                System.out.printf("| %-12s | %-12s | %-12s | %-12s |\n",gudang3[i][0],gudang3[i][1],gudang3[i][2],gudang3[i][3]);
                            }
                        }
                        System.out.print("Ketik apapun untuk kembali ke menu: ");
                        kembali = sc.nextLine();
                        sc.nextLine();
                        if (kembali.equalsIgnoreCase("")) {
                            break;
                        }
                        
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
        boolean tambahLagi = true;

        while (tambahLagi) {
            for (int i = 0; i < gudang.length; i++) {
                if (gudang[i][0] != null && gudang[i][0].equalsIgnoreCase(barang)) {
                    int jumlahBarang = Integer.parseInt(gudang[i][3]);
                    jumlahBarang += jumlah;
                    gudang[i][3] = String.valueOf(jumlahBarang);
                    break;
                } else if (gudang[i][0] == null) {
                    System.out.println("Kode unik barang: " + angkaAcak);
                    gudang[i][0] = barang;
                    gudang[i][1] = String.valueOf(angkaAcak);
                    gudang[i][2] = "Baik";
                    gudang[i][3] = String.valueOf(jumlah);
                    break;
                }
            }

            System.out.println("Barang berhasil ditambahkan!");
            System.out.print("Apakah anda ingin menambahkan barang lagi? (y/n): ");
            sc.nextLine(); 
            String jawaban = sc.nextLine();

            if (jawaban.equalsIgnoreCase("y")) {
                tambahLagi = true;
            } else {
                tambahLagi = false;
            }
        }
    }
    public static void ambilBarang(String[][] gudang) {
        boolean ambilLagi = true;
        while (ambilLagi) {
            for (int i = 0; i < gudang.length; i++) {
                if (gudang[i][0] != null) {
                    System.out.print(gudang[i][0] + "\t: ");
                    System.out.print(gudang[i][1]);
                    System.out.print("\tJumlah: " + gudang[i][3]);
                    System.out.println();
                }
            }
            System.out.println();
            System.out.print("Masukkan kode unik barang: ");
            String unikBarang = sc.nextLine();
            for (int i = 0; i < gudang.length; i++) {
                if (unikBarang!= null && unikBarang.equals(gudang[i][1])) {
                    int jumlahSekarang = Integer.parseInt(gudang[i][3]);
                    if (jumlahSekarang > 0) {
                        System.out.print("Masukkan jumlah yang ingin di ambil: ");
                        int kurangJumlah = sc.nextInt();
                        if (kurangJumlah <= jumlahSekarang) {
                            jumlahSekarang -= kurangJumlah;
                            gudang[i][3] = String.valueOf(jumlahSekarang);
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
}