package project00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KisuuhenkanProject {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void lineMethod() {
        System.out.println("+-----------------------------------------+");
    }

    public int getBaseConversionOption(String[] pilihan) throws IOException {
        for (int i = 0; i < pilihan.length; i++) {
            System.out.println((i + 1) + ". DARI " + pilihan[i] + " ->");
        }
        System.out.print("PILIHAN:-> ");
        String input = br.readLine();

        // ✅ FIX: null check untuk EOF (Ctrl+D)
        if (input == null) return -1;

        try {
            int pilihanInt = Integer.parseInt(input.trim());
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

    public void startConversion() {
        String[] menuUtama = {"2", "8", "10", "16"};

        // ✅ TIP: welcome banner
        lineMethod();
        System.out.println("   KISUUHENKAN PROJECT - 基数変換プログラム   ");
        System.out.println("   Number Base Converter  |  Java Console App  ");

        try {
            while (true) {
                lineMethod();
                System.out.println("PILIH SISTEM ANGKA AWAL (1~4):");
                int pilihanAwal = getBaseConversionOption(menuUtama);
                if (pilihanAwal == -1) continue;

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

                System.out.print("MASUKKAN ANGKA (BASIS " + menuUtama[pilihanAwal - 1] + "): ");
                String angka = br.readLine();

                // ✅ FIX: null check + trim + uppercase untuk input hex
                if (angka == null) break;
                angka = angka.trim().toUpperCase();

                try {
                    int desimal = Integer.parseInt(angka, Integer.parseInt(menuUtama[pilihanAwal - 1]));
                    int targetBase = Integer.parseInt(pilihanLanjutan[pilihanTujuan - 1]);

                    String hasil = switch (targetBase) {
                        case 2  -> Integer.toBinaryString(desimal);
                        case 8  -> Integer.toOctalString(desimal);
                        case 10 -> Integer.toString(desimal);
                        case 16 -> Integer.toHexString(desimal).toUpperCase();
                        default -> "Format tidak dikenali.";
                    };

                    lineMethod();
                    System.out.println("HASIL KONVERSI: " + hasil);

                } catch (NumberFormatException e) {
                    lineMethod();
                    System.out.println("INPUT TIDAK VALID UNTUK BASIS " + menuUtama[pilihanAwal - 1]);
                }

                lineMethod();
                System.out.print("LANJUT? (Y/N): ");
                String lanjut = br.readLine();

                // ✅ FIX: null check untuk EOF
                if (lanjut == null || !lanjut.trim().equalsIgnoreCase("Y")) {
                    lineMethod();
                    System.out.println("PROGRAM SELESAI. ありがとうございました！");
                    lineMethod();
                    break;
                }
            }
        // ✅ FIX: IOException ditangani di sini, bukan dilempar ke main
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        KisuuhenkanProject app = new KisuuhenkanProject();
        app.startConversion();
    }
}
