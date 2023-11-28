import java.util.Scanner;
public class InventarisTest {

    public static void main(String[] args) {
    // sistem Log in
    Scanner sc = new Scanner(System.in);
    boolean logIn = false;
    int pilihan;
    String gudang1[][] = new String[15][4];
    String gudang2[][] = new String[15][4];
    String gudang3[][] = new String[15][4];
    String barang;
    String[] riwayat = new String[20];
    String username = "Nama user";
    int indeksRiwayat = 0;

    while (true) {
        
        // sistem log in
        while (logIn == false) {
            System.out.println("----------------------------");
            System.out.println("| SELAMAT DATANG DI SISTEM |");
            System.out.println("|    INVENTARIS GUDANG     |");
            System.out.println("----------------------------");
            System.out.print("Masukkan username: ");
            username = sc.nextLine();
            System.out.print("Masukkan password: ");
            String password = sc.nextLine(); 
            if ((username.equals("Admin1") || username.equals("Admin2") || username.equals("Admin3")) && password.equals("12345")) {
                System.out.println("Log in berhasil");
                logIn = true;
            }else {
                System.out.println("Log in gagal");        
            }
        }
    // menu utama
    while (logIn == true) {
        System.out.println("-------------------------");
        System.out.println("|   Sistem Inventaris   |");
        System.out.println("-------------------------");
        System.out.println("| 1. Tambahkan barang   |");
        System.out.println("| 2. Lihat Gudang       |");
        System.out.println("| 3. Ambil barang       |");
        System.out.println("| 4. Update barang      |");
        System.out.println("| 5. Pelaporan          |");
        System.out.println("| 6. Log Out            |");
        System.out.println("| 7. Keluar             |");
        System.out.println("-------------------------");
        System.out.print("      Pilih menu: ");
        pilihan = sc.nextInt();
        switch (pilihan) {
            // sistem menambah barang
            case 1:
            System.out.println("--------------------------");
            System.out.println("| SISTEM TAMBAHKAN BARANG |");
            System.out.println("--------------------------");
            System.out.print("Masukkan nama barang: ");
            sc.nextLine();
            barang = sc.nextLine();
            int angkaAcak = (int) (Math.random() * 100000) + 1;
            System.out.println("Kode unik barang: "+angkaAcak);
            System.out.print("Pilih nomer gudang (1,2,3): ");
            int pilihanGudang = sc.nextInt();
            riwayat[indeksRiwayat] = "Menambahkan " + barang + " ke Gudang " + pilihanGudang + "Oleh " + username;
            indeksRiwayat++;
            switch (pilihanGudang) {
                case 1:
                    for (int i = 0; i < gudang1.length; i++) {
                        if (gudang1[i][0] != null) {
                            continue;
                        }
                        gudang1[i][0] = barang;
                        gudang1[i][1] = String.valueOf(angkaAcak);
                        break;
                    }
                    break;
                    case 2:
                    for (int i = 0; i < gudang2.length; i++) {
                        if (gudang2[i][0] != null) {
                            continue;
                        }
                        gudang2[i][0] = barang;
                        gudang2[i][1] = String.valueOf(angkaAcak);
                        break;
                    }
                    break;
                    case 3:
                    for (int i = 0; i < gudang3.length; i++) {
                        if (gudang3[i][0] != null) {
                            continue;
                        }
                        gudang3[i][0] = barang;
                        gudang3[i][1] = String.valueOf(angkaAcak);
                        break;
                    }
                    default:
                    System.out.println("Masukan tidak valid");
                    break;
            }break;
            // sistem lihat gudang
            case 2:
            System.out.println("-----------------------");
            System.out.println("| SISTEM LIHAT GUDANG |");
            System.out.println("-----------------------");
            System.out.print("Gudang 1: ");
            for (int i = 0; i < gudang1.length; i++) {
                System.out.print(gudang1[i][0] + ", ");
            }
            System.out.print("\nGudang 2: ");
            for (int i = 0; i < gudang2.length; i++) {
                System.out.print(gudang2[i][0] + ", ");
            }
            System.out.print("\nGudang 3: ");
            for (int i = 0; i < gudang3.length; i++) {
                System.out.print(gudang3[i][0] + ", ");
            }System.out.print("\n");
            break;
            
            default:
            System.out.println("Pilihan tidak valid");
            break;

            // sistem ambil barang
            case 3:
            System.out.println("-----------------------");
            System.out.println("| SISTEM AMBIL BARANG |");
            System.out.println("-----------------------");
            System.out.print("Pilih nomer gudang yang ingin dikosongkan (1,2,3): ");
            int BarangGudang = sc.nextInt();

            System.out.println("Barang di Gudang " + BarangGudang + ":");
            switch (BarangGudang) {
                case 1:
                for (int i = 0; i < gudang1.length; i++) {
                        if (gudang1[i][0]!=null) {
                            System.out.print(gudang1[i][0] + ": ");
                            System.out.print(gudang1[i][1]);
                            System.out.println();
                        }
                    }
                System.out.println();
                String hapusBarang1 = null;
                System.out.println("Masukkan kode unik barang : ");
                int kodeUnik = sc.nextInt();

                boolean barangDitemukan = false;
                for (int i = 0; i < gudang1.length; i++) {
                    if (gudang1[i][0] != null && gudang1[i][1].equals(String.valueOf(kodeUnik))) {
                    barangDitemukan = true;
                    gudang1 [i][0] = hapusBarang1;
                    break;
                    }
                }

                if (!barangDitemukan) {
                System.out.println("Barang dengan nama atau kode unik yang dimasukkan tidak ditemukan di Gudang 1.");
                } else {
                System.out.print("Barang berhasil terhapus!");
                System.out.println();

                for (int i = 0; i < gudang1.length; i++) {
                    if (gudang1[i][0] != null && gudang1[i][1].equals(String.valueOf(kodeUnik))) {
                        gudang1[i][0] = null;
                        gudang1[i][1] = null;
                        gudang1[i][2] = null;
                        gudang1[i][3] = null;
                    }
                }
                riwayat[indeksRiwayat] = "Menghapus " + hapusBarang1 + " dari Gudang 1" + "oleh" + username;
                indeksRiwayat++;
                } break;

                case 2:
                for (int i = 0; i < gudang2.length; i++) {
                        if (gudang2[i][0]!=null) {
                            System.out.print(gudang2[i][0] + ": ");
                            System.out.print(gudang2[i][1]);
                            System.out.println();
                        }
                    }
                System.out.println();
                String hapusBarang2 = null;
                sc.nextLine();
                System.out.println("Masukkan kode unik barang : ");
                kodeUnik = sc.nextInt();

                barangDitemukan = false;
                for (int i = 0; i < gudang2.length; i++) {
                    if (gudang2[i][0] != null && gudang2[i][1].equals(String.valueOf(kodeUnik))) {
                    barangDitemukan = true;
                    gudang2 [i][0] = hapusBarang2;
                    break;
                    }
                }

                if (!barangDitemukan) {
                System.out.println("Barang dengan nama atau kode unik yang dimasukkan tidak ditemukan di Gudang 2.");
                } else {
                System.out.print("Barang berhasil terhapus!");
                System.out.println();

                for (int i = 0; i < gudang2.length; i++) {
                    if (gudang2[i][0] != null && gudang2[i][1].equals(String.valueOf(kodeUnik))) {
                        gudang2[i][0] = null;
                        gudang2[i][1] = null;
                        gudang2[i][2] = null;
                        gudang2[i][3] = null;
                    }
                }
                riwayat[indeksRiwayat] = "Menghapus " + hapusBarang2 + " dari Gudang 2" + "oleh " + username;
                indeksRiwayat++;
                } break;
                case 3:
                for (int i = 0; i < gudang2.length; i++) {
                        if (gudang3[i][0]!=null) {
                            System.out.print(gudang3[i][0] + ": ");
                            System.out.print(gudang3[i][1]);
                            System.out.println();
                        }
                    }
                System.out.println();
                
                sc.nextLine();
                String hapusBarang3 = null;
                System.out.println("Masukkan kode unik barang : ");
                kodeUnik = sc.nextInt();
                
                barangDitemukan = false;
                for (int i = 0; i < gudang3.length; i++) {
                    if (gudang3[i][0] != null && gudang3[i][1].equals(String.valueOf(kodeUnik))) {
                    barangDitemukan = true;
                    gudang3 [i][0] = hapusBarang3;
                    break;
                    }
                }

                if (!barangDitemukan) {
                System.out.println("Barang dengan nama atau kode unik yang dimasukkan tidak ditemukan di Gudang 3.");
                } else {
                System.out.print("Barang berhasil terhapus!");
                System.out.println();

                for (int i = 0; i < gudang3.length; i++) {
                    if (gudang3[i][0] != null && gudang3[i][1].equals(String.valueOf(kodeUnik))) {
                        gudang3[i][0] = null;
                        gudang3[i][1] = null;
                        gudang3[i][2] = null;
                        gudang3[i][3] = null;
                    }
                }
                riwayat[indeksRiwayat] = "Menghapus " + hapusBarang3 + " dari Gudang 3" + "oleh" + username;
                indeksRiwayat++;
                } break;

            } break;
                
            // sistem Update Barang
            case 4:
            System.out.println("-----------------------");
            System.out.println("| SISTEM UPDATE BARANG |");
            System.out.println("-----------------------");
            System.out.print("Pilih gudang (1,2,3): ");
            int pilGudang = sc.nextInt();
            System.out.println("Barang di Gudang " + pilGudang + ":");
            switch (pilGudang) {
                case 1:
                for (int i = 0; i < gudang1.length; i++) {
                    if (gudang1[i][0]!=null) {
                    System.out.print(gudang1[i][0] + ", ");
                    }
                }
                System.out.println();
                sc.nextLine();
                System.out.print("Masukkan nama barang yang ingin di update: ");
                String barangLama = sc.nextLine();
                for (int i = 0; i < gudang1.length; i++) {
                    if (gudang1[i][0]!= null && gudang1[i][0].equals(barangLama)) {
                    System.out.print("Silahkan update nama barang: ");
                    gudang1[i][0] = sc.nextLine();
                    System.out.print("Silahkan Update kondisi barang (Rusak/Baik): ");
                    gudang1[i][1] = sc.nextLine();
                    System.out.print("Silahkan Update deskripsi barang: ");
                    gudang1[i][2] = sc.nextLine();
                    System.out.print("Silahkan Masukkan nama user anda: ");
                    gudang1[i][3] = sc.nextLine();
                    System.out.println("Barang Berhasil di Update");
                    riwayat[indeksRiwayat] = "Mengupdate " + barangLama + " dari Gudang 1";
                    indeksRiwayat++;
                    break;
                    }
                }break;

                case 2:
                for (int i = 0; i < gudang2.length; i++) {
                    if (gudang2[i][0]!=null) {
                    System.out.print(gudang2[i][0] + ", ");
                    }
                }
                System.out.println();
                sc.nextLine();
                System.out.print("Masukkan nama barang yang ingin di update: ");
                barangLama = sc.nextLine();
                for (int i = 0; i < gudang2.length; i++) {
                    if (gudang2[i][0]!= null && gudang2[i][0].equals(barangLama)) {
                    System.out.print("Silahkan update nama barang: ");
                    gudang2[i][0] = sc.nextLine();
                    System.out.print("Silahkan Update kondisi barang (Rusak/Baik): ");
                    gudang2[i][2] = sc.nextLine();
                    System.out.print("Silahkan Update deskripsi barang: ");
                    gudang2[i][3] = sc.nextLine();
                    System.out.println("Barang Berhasil di Update");
                    riwayat[indeksRiwayat] = "Mengupdate " + barangLama + " dari Gudang 2";
                    indeksRiwayat++;
                    break;
                    }
                }break;

                case 3:
                for (int i = 0; i < gudang3.length; i++) {
                    if (gudang3[i][0]!=null) {
                    System.out.print(gudang3[i][0] + ", ");
                    }
                }
                System.out.println();
                sc.nextLine();
                System.out.print("Masukkan nama barang yang ingin di update: ");
                barangLama = sc.nextLine();
                for (int i = 0; i < gudang3.length; i++) {
                    if (gudang3[i][0]!= null && gudang3[i][0].equals(barangLama)) {
                    System.out.print("Silahkan update nama barang: ");
                    gudang3[i][0] = sc.nextLine();
                    System.out.print("Silahkan Update kondisi barang (Rusak/Baik): ");
                    gudang3[i][1] = sc.nextLine();
                    System.out.print("Silahkan Update deskripsi barang: ");
                    gudang3[i][2] = sc.nextLine();
                    System.out.print("Silahkan Masukkan nama user anda: ");
                    gudang3[i][3] = sc.nextLine();
                    System.out.println("Barang Berhasil di Update");
                    riwayat[indeksRiwayat] = "Mengupdate " + barangLama + " dari Gudang 3";
                    indeksRiwayat++;
                    break;
                    }
                }break;
        
                default:
                System.out.println("Barang Tidak Ditemukan");
                break;
                }break;

                case 5:
                System.out.println("-----------------------");
                System.out.println("|      PELAPORAN      |");
                System.out.println("-----------------------");
                System.out.println("1. Cek kondisi barang");
                System.out.println("2. Riwayat");
                System.out.println("3. Cari barang");
                System.out.print("Pilih Menu: ");
                int pilihan2 = sc.nextInt();
                switch (pilihan2) {
                        case 1:
                            break;
                        case 2:
                        System.out.println("-----------------------");
                        System.out.println("|       RIWAYAT       |");
                        System.out.println("-----------------------");
                        for (int i = 0; i < indeksRiwayat; i++) {
                            System.out.println(riwayat[i]);
                        } 
                        break;
                    

                        case 3:
                        
                        // sistem untuk memilih metode pencarian. bisa berupa nama barang atau kode unik
                        System.out.println("--------------------------------");
                        System.out.println("|       SISTEM PENCARIAN       |");
                        System.out.println("--------------------------------");
                        System.out.println("Pilih metode pencarian");
                        System.out.println("1. Berdasarkan nama");
                        System.out.println("2. Berdasarkan kode unik");
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
                            System.out.println("Masukkan keyword (kode unik barang): ");
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

                    case 6:
                    logIn = false;
                    sc.nextLine();
                    break;
                    
                    // sistem untuk keluar
                    case 7:
                    System.exit(0);
                    break;
                }
            }
        }  
    }
}