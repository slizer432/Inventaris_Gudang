import java.util.Scanner;

public class InventarisTest {

    public static void main(String[] args) {
    // sistem Log in
    Scanner sc = new Scanner(System.in);
    boolean logIn = false;
    int pilihan;
    String gudang1[][] = new String[15][5];
    String gudang2[][] = new String[15][5];
    String gudang3[][] = new String[15][5];
    String statusBarang1 = "Kosong";
    String statusBarang2 = "Kosong";
    String statusBarang3 = "Kosong";
    String barang;

    while (true) {
        
        // sistem log in
        while (logIn == false) {
            System.out.print("Masukkan username: ");
            String username = sc.nextLine();
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
    while (true) {
        System.out.println("-------------------------");
        System.out.println("|   Sistem Inventaris   |");
        System.out.println("-------------------------");
        System.out.println("| 1. Tambahkan barang   |");
        System.out.println("| 2. Lihat Gudang       |");
        System.out.println("| 3. Ambil barang       |");
        System.out.println("| 4. Manajemen barang   |");
        System.out.println("| 5. Cek kondisi barang |");
        System.out.println("| 6. Pelaporan          |");
        System.out.println("| 7. Keluar             |");
        System.out.println("-------------------------");
        System.out.print("      Pilih menu: ");
        pilihan = sc.nextInt();
        switch (pilihan) {
            // sistem menambah barang
            case 1:
            System.out.print("Masukkan nama barang: ");
            sc.nextLine();
            barang = sc.nextLine();
            System.out.print("Pilih nomer gudang (1,2,3): ");
            int pilihanGudang = sc.nextInt();
            switch (pilihanGudang) {
                case 1:
                    for (int i = 0; i < gudang1.length; i++) {
                        if (gudang1[i][0] != null) {
                            continue;
                        }
                        gudang1[i][0] = barang;
                        break;
                    }
                    break;
                    case 2:
                    for (int i = 0; i < gudang2.length; i++) {
                        if (gudang1[i][0] != null) {
                            continue;
                        }
                        gudang2[i][0] = barang;
                        break;
                    }
                    break;
                    case 3:
                    for (int i = 0; i < gudang3.length; i++) {
                        if (gudang3[i][0] != null) {
                            continue;
                        }
                        gudang3[i][0] = barang;
                        break;
                    }
                    default:
                    System.out.println("Masukan tidak valid");
                    break;
            }break;
            // sistem lihat gudang
            case 2:
            System.out.println("Inventaris");
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
            System.out.print("Pilih nomer gudang yang ingin dikosongkan (1,2,3): ");
            int BarangGudang = sc.nextInt();

            System.out.println("Barang di Gudang " + BarangGudang + ":");
            switch (BarangGudang) {
                case 1:
                    for (int i = 0; i < gudang1.length; i++) {
                    System.out.print(gudang1[i][0] + ", ");
                } 
                System.out.println();
                System.out.print("Masukkan barang yang akan dihapus dari Gudang 1:");
                sc.nextLine();
                String HapusGudang1 = sc.nextLine();
                
                for (int i = 0; i < gudang1.length; i++) {
                    if (gudang1[i][0] != null && gudang1[i][0].equals(HapusGudang1)) {
                        gudang1[i][0] = null; 
                    }
                }
                break;
                case 2:
                for (int i = 0; i < gudang2.length; i++) {
                    System.out.print(gudang2[i][0] + ", ");
                }
                System.out.println();
                
                System.out.println("Masukkan barang yang akan dihapus dari Gudang 2:");
                sc.nextLine();
                String HapusGudang2 = sc.nextLine();
                for (int i = 0; i < gudang2.length; i++) {
                    if (gudang2[i][0] != null && gudang2[i][0].equals(HapusGudang2)) {
                        gudang2[i][0] = null; 
                    }
                }
                break;
                case 3:
                for (int i = 0; i < gudang3.length; i++) {
                    System.out.print(gudang3[i][0] + ", ");
                }
                System.out.println();
                
                System.out.println("Masukkan barang yang akan dihapus dari Gudang 3:");
                sc.nextLine();
                String HapusGudang3= sc.nextLine();
                for (int i = 0; i < gudang3.length; i++) {
                if (gudang3[i][0] != null && gudang3[i][0].equals(HapusGudang3)) {
                    gudang3[i][0] = null; 
                    }
                }
                break;
            
            } break;
            // sistem manajemen barang
            case 4:
                System.out.print("Pilih barang yang akan di-update (1,2,3): ");
                int pilihanBarang = sc.nextInt();
                sc.nextLine();
                System.out.print("Silakan masukan update kondisi barang: ");
                String update = sc.nextLine();
                switch (pilihanBarang) {
                    case 1:
                    statusBarang1 = update;
                    break;
                    case 2:
                    statusBarang2 = update;
                    break;
                    case 3:
                        statusBarang3 = update;
                        break;
                        default:
                        System.out.println("masukan tidak valid");
                        break;
                        // sistem lihat status barang
                    }
                    case 5:
                    System.out.println("Kondisi barang");
                    System.out.println("Gudang 1: " + statusBarang1);
                    System.out.println("Gudang 2: " + statusBarang2);
                    System.out.println("Gudang 3: " + statusBarang3);
                    break;
                    
                    case 6:
                    
                    
                    // sisten untuk keluar
                    case 7:
                    logIn = false;
                    sc.nextLine();
                    break;
                }
            }
        }  
    }
}