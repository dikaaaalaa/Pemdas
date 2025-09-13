import java.util.Scanner;

public class Tugaspemdas3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         // Memasukkan jam kerja
        System.out.print("Masukkan jumlah jam kerja per minggu: ");
        int jamkerja = scanner.nextInt();

        // inisialisasi variabel
        int upahPerJam = 5000;
        int upah, lembur = 0, denda = 0, total;

        // jam kerja maksimal 60 jam
        if (jamkerja > 60) {
            upah = 60 * upahPerJam;
            lembur = (jamkerja - 60) * 6000;
        } 
        else {
            upah = jamkerja * upahPerJam;
        }

        // denda jika jam kerja kurang
        if (jamkerja < 50) {
            denda = (50 - jamkerja) * 1000;
        }

        // Hitung total
        total = upah + lembur - denda;

        // hasil output
        System.out.println("Jam kerja : " + jamkerja);
        System.out.println("Upah      = Rp. " + upah);
        System.out.println("Lembur    = Rp. " + lembur);
        System.out.println("Denda     = Rp. " + denda);
        System.out.println("---------------------");
        System.out.println("Total     = Rp. " + total);

        // Tutup scanner
        scanner.close();


        }



        
    }

