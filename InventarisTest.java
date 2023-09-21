import java.util.Scanner;
/**
 * Test
 */
public class InventarisTest {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    boolean logIn = false;
    while (logIn == false) {
        System.out.println("Masukkan username");
        String username = input.nextLine();
        System.out.println("Masukkan password");
        String password = input.nextLine(); 
        if (username.equals("Admin") && password.equals("12345")) {
            System.out.println("Log in berhasil");
            logIn = true;
        }else {
            System.out.println("Log in gagal");
        
    }
    }


    }
}
