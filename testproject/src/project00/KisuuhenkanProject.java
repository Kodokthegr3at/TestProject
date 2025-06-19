package project00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KisuuhenkanProject {

    // Garis pemisah
    static void lineMethod() {
        System.out.println("+-----------------------------------------+");
    }

    // Menampilkan pilihan konversi basis
    public int getBaseConversionOption(String[] pilihan) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < pilihan.length; i++) {
            System.out.println((i + 1) + ". DARI " + pilihan[i] + " ->");
        }

        System.out.print("PILIHAN:-> ");
        String input = br.readLine();

        try {
            int pilihanInt = Integer.parseInt(input);
            if (pilihanInt < 1 || pilihanInt > pilihan.length) {
            	lineMethod();
                System.out.println("PILIHAN DI LUAR JANGKAUAN. COBA LAGI.");
                return -1;
            }
            return pilihanInt;
        } catch (NumberFormatException e) {
        	lineMethod();
            System.out.println("MASUKKAN ANGKA, BUKAN HURUF.");
            return -1;
        }
    }

    public void startConversion() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] menuUtama = {"2", "8", "10", "16"};

        while (true) {
            lineMethod();
            System.out.println("PILIH SISTEM ANGKA AWAL (1~4):");
            int pilihanAwal = getBaseConversionOption(menuUtama);

            if (pilihanAwal == -1) continue;

            // Tentukan pilihan lanjutan tergantung basis awal
            String[] pilihanLanjutan = switch (pilihanAwal) {
                case 1 -> new String[]{"8", "10", "16"};
                case 2 -> new String[]{"2", "10", "16"};
                case 3 -> new String[]{"2", "8", "16"};
                case 4 -> new String[]{"2", "8", "10"};
                default -> new String[]{};
            };

            System.out.println("PILIH KONVERSI KE BASIS:");
            int pilihanTujuan = getBaseConversionOption(pilihanLanjutan);
            if (pilihanTujuan == -1) continue;

            // Minta input angka
            System.out.print("MASUKKAN ANGKA DENGAN BASIS " + menuUtama[pilihanAwal - 1] + ": ");
            String angka = br.readLine();

            try {
                int desimal = Integer.parseInt(angka, Integer.parseInt(menuUtama[pilihanAwal - 1]));
                int targetBase = Integer.parseInt(pilihanLanjutan[pilihanTujuan - 1]);

                String hasil = switch (targetBase) {
                    case 2 -> Integer.toBinaryString(desimal);
                    case 8 -> Integer.toOctalString(desimal);
                    case 10 -> Integer.toString(desimal);
                    case 16 -> Integer.toHexString(desimal).toUpperCase();
                    default -> "Format tidak dikenali.";
                };

                System.out.println("HASIL KONVERSI: " + hasil);
            } catch (NumberFormatException e) {
                System.out.println("INPUT TIDAK VALID UNTUK BASIS " + menuUtama[pilihanAwal - 1]);
            }

            // Tanya lanjut atau keluar
            System.out.print("LANJUT? (Y/N): ");
            String lanjut = br.readLine();
            if (!lanjut.equalsIgnoreCase("Y")) {
                System.out.println("PROGRAM SELESAI.");
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        KisuuhenkanProject app = new KisuuhenkanProject();
        app.startConversion();
    }
}
