import java.util.Scanner;
public class pemilihan2Tugas23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;
        String gudang1 = "Kosong"; 
        String gudang2 = "Kosong";
        String barang;
        System.out.println("Sistem inventaris");
        System.out.println("1. Tambahkan barang");
        System.out.println("2. Lihat barang");
        System.out.print("Pilih menu: ");
        pilihan = sc.nextInt();
        switch (pilihan) {
            case 1:
                System.out.print("Masukkan barang: ");
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
                }
                break;
        
            case 2:
                System.out.println("Inventaris");
                System.out.println("Gudang 1 : "+gudang1);
                System.out.println("Gudang 2 : "+gudang2);
                break;
            default:
                System.out.println("Pilihan tidak valid");
                break;
        }
    }
}
