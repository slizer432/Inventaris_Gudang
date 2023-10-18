import java.util.Scanner;

public class InventarisTest2 {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean logIn = false;
    int pilihan;
    String gudang1 = "Kosong"; 
    String gudang2 = "Kosong";
    String barang;
    while (logIn == false) {
        System.out.println("Masukkan username");
        String username = sc.nextLine();
        System.out.println("Masukkan password");
        String password = sc.nextLine(); 
        if (username.equalsIgnoreCase("Admin") && password.equals("12345")) {
            System.out.println("Log in berhasil");
            logIn = true;
        }else {
            System.out.println("Log in gagal");        
        }
    }
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
        System.out.println("| 7. Riwayat sistem     |");
        System.out.println("-------------------------");
        System.out.print("      Pilih menu: ");
        pilihan = sc.nextInt();
        switch (pilihan) {
            case 1:
            System.out.print("Masukkan nama barang: ");
            sc.nextLine();
            barang = sc.nextLine();
            System.out.print("Pilih nomer gudang (1,2): ");
            int pilihanGudang = sc.nextInt();
            switch (pilihanGudang) {
                case 1:
                    gudang1 = barang;
                    break;
                case 2:
                    gudang2 = barang;
                    break;
                default:
                    System.out.println("Masukan tidak valid");
                break;
            }break;

            case 2:
            System.out.println("Inventaris");
            System.out.println("Gudang 1 : " + gudang1);
            System.out.println("Gudang 2 : " + gudang2);
            break;
                
            default:
            System.out.println("Pilihan tidak valid");
            break;

            case 3:
            System.out.println("Masukkan nama barang: ");
            sc.nextLine();
            barang = sc.nextLine();
            System.out.print("Pilih nomer gudang (1,2): ");
            int pilihanG = sc.nextInt();
            switch (pilihanG) {
                case 1:
                    gudang1 = "Kosong";
                    break;
                case 2:
                    gudang2 = "Kosong";
                    break;
                default:
                    System.out.println("Masukan tidak valid");
                break;
            }    

        }
        
      }
    }
  }