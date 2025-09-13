import java.util.Scanner;

public class Tugaspemdas2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //menghitung IMT
        System.out.println("menghitung Indeks massa tubuh (IMT)");
        //memasukkan berat dan tinggi
        System.out.print("masukkan berat badan (kg): ");
        double berat = input.nextDouble();
        System.out.print("masukkan tinggi badan (m): ");
        // menghitung dengan rumus IMT
        double tinggi = input.nextDouble();
        double imt = berat / (tinggi * tinggi);
        
        //menampilkan output
        System.out.printf("Indeks massa tubuh (IMT) = %.2f\n", imt);

        //menentukan keterangan berdasarkan nilai IMT
        if (imt <= 18.5){
            System.out.println("keterangan: kurus");
        }
        else if (imt < 18.5 & imt <= 25){
            System.out.println("keterangan: normal");
        }
        else if (imt < 25 & imt <= 30){
            System.out.println("keterangan: gemuk");
        }
        else if(imt > 30){
            System.out.println("keterangan: kegemukan");

        }
        //menutup scanner
   input.close();
    } 
}
