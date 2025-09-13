import java.util.Scanner;

public class Tugaspemdas1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //menampilkan menu
        System.out.println("Menu:");
        System.out.println("1. Menghitung luas dan keliling persegi panjang");
        System.out.println("2. Menghitung luas dan keliling lingkaran");
        System.out.println("3. Menghitung luas dan keliling segitiga");
        System.out.print("Masukkan pilihan (1/2/3): ");

        //memasukkan pilihaan
        int pilihan = input.nextInt();

        switch (pilihan) {

            case 1:

            //memasukkan panjang dan lebar
            System.out.print("masukkan panjang: ");
            int panjang = input.nextInt();
            System.out.print("masukkan lebar: ");
            int lebar = input.nextInt();

            // melakukan perhitungan
            int luas= panjang * lebar;
            int keliling = 2 * (panjang + lebar);
            // manampilkan output
            System.out.printf("%-10s: %s\n","luas persegi panjang", luas);
            System.out.printf("%-10s: %s\n","keliling persegi panjang" ,keliling);
            break;


            case 2:
            //memasukkan pilihan lingkaran
            System.out.println("1. menggunakan jari-jari");
            System.out.println("2. menggunakan diameter");
            System.out.print("masukkan pilihan: ");
            int pilihanlingkaran = input.nextInt();

            //jika menggunakan jari jari
            if (pilihanlingkaran == 1){
                    System.out.print("masukkan jari-jari:");
                    // menghitung keliling dan luas lingkaran
                    double r = input.nextDouble();
                    double kelilinglingkaran = 2 * Math.PI * r;
                    double luaslingkaran = (Math.PI * r * r);
                    // menampilkan output
                    System.out.printf("%-10s: %.2f\n", "keliling lingkaran=", kelilinglingkaran);
                    System.out.printf("%-10s: %.2f\n", "luas lingkaran=", luaslingkaran);

            }

            //jika menggunakan diameter
            else if (pilihanlingkaran == 2){
                System.out.print("masukkan diameter:");
                // menghitung keliling dan luas lingkaran
                double d = input.nextDouble();
                double kelilinglingkaran = Math.PI * d;
                double luaslingkaran = (Math.PI * d * d) / 4;
                // menampilkan output
                System.out.printf("%-10s: %.2f\n", "keliling lingkaran=", kelilinglingkaran);
                System.out.printf("%-10s: %.2f\n", "luas lingkaran=", luaslingkaran);

            } 
            //jika pilihan tidak tersedia
            else{
                System.out.println("pilihan tidak tersedia");
            }
            break;

            case 3:

            //memasukkan alas, tinggi, dan sisi miring
            System.out.print("masukkan alas: ");
            int alas = input.nextInt();
            System.out.print("masukkan tinggi: ");
            int tinggi = input.nextInt();
            System.out.print("masukkan sisi miring: ");
            int sisimiring = input.nextInt();
            // melakukan perhitungan
            int luassegitiga = (alas * tinggi) / 2;
            int kelilingsegitiga = alas + tinggi + sisimiring;
            // menampilkan output
            System.out.printf("%-10s: %s\n", "luas segitiga", luassegitiga );
            System.out.printf("%-10s: %s\n", "keliling segitiga", kelilingsegitiga );
            break;


        }
        //menutup scanner
        input.close();
    }
    
}
