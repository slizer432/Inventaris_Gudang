import java.util.Scanner;

public class InventarisTest {

    public static void main(String[] args) {
    // sistem Log in
    Scanner sc = new Scanner(System.in);
    boolean logIn = false;
    int pilihan;
    String gudang1 = "Kosong"; 
    String gudang2 = "Kosong";
    String gudang3 = "Kosong";
    String statusBarang1 = "Kosong";
    String statusBarang2 = "Kosong";
    String statusBarang3 = "Kosong";
    String barang;
    while (logIn == false) {
        System.out.print("Masukkan username: ");
        String username = sc.nextLine();
        System.out.print("Masukkan password: ");
        String password = sc.nextLine(); 
        if (username.equalsIgnoreCase("Admin") && password.equals("12345")) {
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
                    gudang1 = barang;
                    break;
                case 2:
                    gudang2 = barang;
                    break;
                case 3:
                    gudang3 = barang;
                default:
                    System.out.println("Masukan tidak valid");
                break;
            }break;
            // sistem lihat gudang
            case 2:
            System.out.println("Inventaris");
            System.out.println("Gudang 1 : " + gudang1);
            System.out.println("Gudang 2 : " + gudang2);
            System.out.println("Gudang 3 : " + gudang3);
            break;
                
            default:
            System.out.println("Pilihan tidak valid");
            break;
            // sistem ambil barang
            case 3:
            System.out.print("Pilih nomer gudang yang ingin dikosongkan (1,2,3): ");
            int pilihanG = sc.nextInt();
            switch (pilihanG) {
                case 1:
                    gudang1 = "Kosong";
                    break;
                case 2:
                    gudang2 = "Kosong";
                    break;
                case 3:
                    gudang3 = "Kosong";
                    break;
                default:
                    System.out.println("Masukan tidak valid");
                    break;
            }break;
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
            System.exit(0);
        }
        
      }
    }
  }