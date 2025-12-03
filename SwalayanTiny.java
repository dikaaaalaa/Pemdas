import java.util.Scanner;

class Pelanggan {
    private String nama;
    private String noPelanggan;     // 10 digit
    private String pin;
    private double saldo;
    private boolean diblokir = false;
    private int salahPIN = 0;

    public Pelanggan(String nama, String noPelanggan, String pin, double saldo) {
        this.nama = nama;
        this.noPelanggan = noPelanggan;
        this.pin = pin;
        this.saldo = saldo;
    }

    public String getJenisRekening() {
        String prefix = noPelanggan.substring(0, 2);
        switch (prefix) {
            case "38": return "silver";
            case "56": return "gold";
            case "74": return "platinum";
            default: return "tidak valid";
        }
    }

    public boolean autentifikasi(String inputPIN) {
        if (diblokir) {
            System.out.println("Akun telah diblokir! Tidak bisa digunakan.");
            return false;
        }

        if (inputPIN.equals(pin)) {
            salahPIN = 0;
            return true;
        } else {
            salahPIN++;
            System.out.println("PIN salah!");

            if (salahPIN == 3) {
                diblokir = true;
                System.out.println("Akun diblokir karena 3x kesalahan PIN!");
            }
            return false;
        }
    }

    public boolean beli(double nominal) {
        if (saldo - nominal < 10000) {
            System.out.println("Transaksi gagal! Saldo akhir tidak boleh kurang dari 10.000.");
            return false;
        }

        saldo -= nominal;

        // Hitung cashback
        double cashback = hitungCashback(nominal);
        saldo += cashback;

        System.out.println("Cashback diterima: Rp " + cashback);
        return true;
    }

    public void topUp(double nominal) {
        saldo += nominal;
        System.out.println("Top up berhasil.");
    }

    private double hitungCashback(double nominal) {
        if (nominal < 1000000) return 0;

        switch (getJenisRekening()) {
            case "silver":
                return nominal * 0.05;

            case "gold":
                return (nominal * 0.07) + (nominal * 0.02);

            case "platinum":
                return (nominal * 0.1) + (nominal * 0.05);

            default:
                return 0;
        }
    }

    public void cekSaldo() {
        System.out.println("Saldo saat ini: Rp " + saldo);
    }
}

public class SwalayanTiny {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Contoh pembuatan akun (data tidak bisa diubah)
        Pelanggan p = new Pelanggan("Dika", "5612345678", "1234567890", 2000000);

        int pilihan;
        do {
            System.out.println("\n=== MENU SWALAYAN TINY ===");
            System.out.println("1. Pembelian");
            System.out.println("2. Top Up");
            System.out.println("3. Cek Saldo");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan PIN: ");
                    String pinBeli = sc.next();
                    if (!p.autentifikasi(pinBeli)) break;

                    System.out.print("Nominal pembelian: ");
                    double beli = sc.nextDouble();
                    p.beli(beli);
                    break;

                case 2:
                    System.out.print("Masukkan PIN: ");
                    String pinTopup = sc.next();
                    if (!p.autentifikasi(pinTopup)) break;

                    System.out.print("Nominal top up: ");
                    double topup = sc.nextDouble();
                    p.topUp(topup);
                    break;

                case 3:
                    p.cekSaldo();
                    break;

                case 0:
                    System.out.println("Keluar...");
                    break;

                default:
                    System.out.println("Pilihan tidak ada!");
            }

        } while (pilihan != 0);

        sc.close();
    }
}
