<div align="center">

# 基数変換プログラム
### KisuuhenkanProject

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com)
[![Console App](https://img.shields.io/badge/Console-Application-black?style=for-the-badge&logo=windowsterminal&logoColor=white)](https://github.com/Kodokthegr3at)
[![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Complete-brightgreen?style=for-the-badge)]()

**A Java console application for number base conversion**  
**Javaで作られた基数変換コンソールアプリ**  
**Aplikasi konsol Java untuk konversi sistem bilangan**

📅 June 2025 &nbsp;|&nbsp; 👤 [Kodokthegr3at](https://github.com/Kodokthegr3at)

</div>

---

## 📖 Overview / 概要 / Gambaran Umum

### 🇬🇧 English
**KisuuhenkanProject** is a Java-based console application that performs **number base conversion (基数変換)**. It allows users to interactively convert numbers between four major numeral systems with input validation and continuous operation until the user decides to exit.

### 🇯🇵 日本語
**KisuuhenkanProject** は、Javaで実装された**基数変換**コンソールアプリケーションです。4つの主要な数値システム間で対話的に数値を変換でき、入力バリデーションと継続的な変換ループを備えています。

### 🇮🇩 Bahasa Indonesia
**KisuuhenkanProject** adalah aplikasi konsol berbasis Java yang melakukan **konversi sistem bilangan (基数変換)**. Program ini memungkinkan pengguna mengkonversi angka secara interaktif antara empat sistem bilangan utama dengan validasi input dan perulangan hingga pengguna memilih untuk keluar.

---

## 🔢 Supported Number Systems / 対応する数値システム / Sistem Bilangan yang Didukung

| System | Base | Prefix | Example |
|--------|------|--------|---------|
| **Binary** / バイナリ / Biner | Base 2 | `0b` | `1010` |
| **Octal** / 8進数 / Oktal | Base 8 | `0` | `12` |
| **Decimal** / 10進数 / Desimal | Base 10 | — | `10` |
| **Hexadecimal** / 16進数 / Heksadesimal | Base 16 | `0x` | `A` |

---

## 🎯 Features / 機能 / Fitur

- ✅ **Interactive CLI menu** — 対話型CLIメニュー — Menu CLI interaktif
- ✅ **Multi-directional base conversion** — 多方向の基数変換 — Konversi basis multi-arah
- ✅ **Input validation & error handling** — 入力バリデーション＆エラー処理 — Validasi input & penanganan error
- ✅ **Continuous loop** until user exits — ユーザーが終了するまでループ — Perulangan hingga pengguna keluar
- ✅ **Dynamic target options** — ソース基数に応じた変換先表示 — Pilihan target dinamis sesuai basis sumber
- ✅ **EOF / null input safe** — Ctrl+D / null-safe handling — EOF aman dari NullPointerException

---

## 🛠️ Tech Stack / 使用技術 / Teknologi

| Component | Detail |
|-----------|--------|
| Language | Java 14+ (Core) |
| Input | `BufferedReader` + `InputStreamReader` (single instance) |
| Conversion | `Integer.parseInt()` with radix |
| Error Handling | `try-catch` — `NumberFormatException`, `IOException` |
| Build | `javac` / IntelliJ IDEA / Eclipse |

---

## ⚙️ How It Works / 動作の仕組み / Cara Kerja

### 🔄 Conversion Flow / 変換フロー / Alur Konversi

```
┌─────────────────────────────────────────────────────┐
│                   USER STARTS APP                    │
│           Welcome banner is displayed                │
└────────────────────────┬────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────┐
│           STEP 1: Select SOURCE Base                 │
│                                                      │
│    1. DARI 2  (Binary  / 2進数  / Biner)             │
│    2. DARI 8  (Octal   / 8進数  / Oktal)             │
│    3. DARI 10 (Decimal / 10進数 / Desimal)           │
│    4. DARI 16 (Hex     / 16進数 / Heksadesimal)      │
└────────────────────────┬────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────┐
│           STEP 2: Select TARGET Base                 │
│     (source base excluded from options)              │
└────────────────────────┬────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────┐
│           STEP 3: Input Number                       │
│     Input is trimmed + uppercased automatically      │
│     e.g. "ff" and "FF" both accepted for Base 16     │
└────────────────────────┬────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────┐
│           STEP 4: Convert to DECIMAL (pivot)         │
│   int desimal = Integer.parseInt(angka, sourceBase); │
└────────────────────────┬────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────┐
│           STEP 5: Convert to TARGET Base             │
│   case 2  → Integer.toBinaryString(desimal)          │
│   case 8  → Integer.toOctalString(desimal)           │
│   case 10 → Integer.toString(desimal)                │
│   case 16 → Integer.toHexString(desimal).toUpperCase │
└────────────────────────┬────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────┐
│           STEP 6: Display Result                     │
│         HASIL KONVERSI: [result]                     │
└────────────────────────┬────────────────────────────┘
                         │
                         ▼
              LANJUT? Y ──► Loop back to STEP 1
              LANJUT? N ──► Print goodbye + exit
              EOF/null  ──► Safe exit (no crash)
```

---

## 💻 Full Source Code / フルソースコード / Kode Lengkap

```java
package project00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KisuuhenkanProject {

    // ✅ Single BufferedReader instance shared across all methods
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Separator line
    static void lineMethod() {
        System.out.println("+-----------------------------------------+");
    }

    // Display conversion menu and get user selection
    public int getBaseConversionOption(String[] pilihan) throws IOException {
        for (int i = 0; i < pilihan.length; i++) {
            System.out.println((i + 1) + ". DARI " + pilihan[i] + " ->");
        }
        System.out.print("PILIHAN:-> ");
        String input = br.readLine();

        // ✅ Null check for EOF (Ctrl+D)
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

        // ✅ Welcome banner
        lineMethod();
        System.out.println("   KISUUHENKAN PROJECT - 基数変換プログラム   ");
        System.out.println("   Number Base Converter  |  Java Console App  ");

        try {
            while (true) {
                lineMethod();
                System.out.println("PILIH SISTEM ANGKA AWAL (1~4):");
                int pilihanAwal = getBaseConversionOption(menuUtama);
                if (pilihanAwal == -1) continue;

                // Dynamic target menu — excludes selected source base
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

                // ✅ Null check + trim + uppercase (accepts "ff" and "FF" equally)
                if (angka == null) break;
                angka = angka.trim().toUpperCase();

                try {
                    // Step 1: Convert input → decimal (pivot)
                    int desimal = Integer.parseInt(angka, Integer.parseInt(menuUtama[pilihanAwal - 1]));
                    int targetBase = Integer.parseInt(pilihanLanjutan[pilihanTujuan - 1]);

                    // Step 2: Convert decimal → target base
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

                // ✅ Null check for EOF — exits gracefully without NullPointerException
                if (lanjut == null || !lanjut.trim().equalsIgnoreCase("Y")) {
                    lineMethod();
                    System.out.println("PROGRAM SELESAI. ありがとうございました！");
                    lineMethod();
                    break;
                }
            }

        // ✅ IOException handled here — main() no longer needs throws
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        KisuuhenkanProject app = new KisuuhenkanProject();
        app.startConversion();
    }
}
```

---

## 🐛 Bug Fixes & Improvements / バグ修正と改善 / Perbaikan dari Versi Awal

| # | Issue | Fix Applied |
|---|-------|-------------|
| 1 | `BufferedReader` dibuat 2x (resource leak) | Dijadikan `private final` field — 1 instance untuk semua method |
| 2 | `NullPointerException` saat input EOF (`Ctrl+D`) | `null` check ditambahkan di semua `br.readLine()` |
| 3 | Input hex lowercase `"ff"` tidak diterima | `.trim().toUpperCase()` diterapkan sebelum parsing |
| 4 | `IOException` dilempar ke `main()` | Ditangani dengan `try-catch` di `startConversion()` |
| 5 | Tidak ada welcome banner | Banner ditambahkan di awal program |
| 6 | Output hasil tanpa pemisah | `lineMethod()` ditambahkan sebelum hasil konversi |

---

## 📌 Example Output / 実行例 / Contoh Output

### Example 1 — Decimal → Binary

```
+-----------------------------------------+
   KISUUHENKAN PROJECT - 基数変換プログラム
   Number Base Converter  |  Java Console App
+-----------------------------------------+
PILIH SISTEM ANGKA AWAL (1~4):
1. DARI 2 ->
2. DARI 8 ->
3. DARI 10 ->
4. DARI 16 ->
PILIHAN:-> 3

PILIH KONVERSI KE BASIS:
1. DARI 2 ->
2. DARI 8 ->
3. DARI 16 ->
PILIHAN:-> 1

MASUKKAN ANGKA (BASIS 10): 10
+-----------------------------------------+
HASIL KONVERSI: 1010
+-----------------------------------------+
LANJUT? (Y/N): N
+-----------------------------------------+
PROGRAM SELESAI. ありがとうございました！
+-----------------------------------------+
```

### Example 2 — Hexadecimal → Decimal

```
PILIHAN:-> 4   (Hex)
PILIHAN:-> 3   (Decimal)
MASUKKAN ANGKA (BASIS 16): ff

HASIL KONVERSI: 255
```

### Example 3 — Invalid Input

```
MASUKKAN ANGKA (BASIS 2): 999
+-----------------------------------------+
INPUT TIDAK VALID UNTUK BASIS 2
```

---

## 🔢 Conversion Reference Table / 変換参照表 / Tabel Referensi

| Decimal | Binary | Octal | Hex |
|---------|--------|-------|-----|
| 0 | 0 | 0 | 0 |
| 1 | 1 | 1 | 1 |
| 8 | 1000 | 10 | 8 |
| 10 | 1010 | 12 | A |
| 15 | 1111 | 17 | F |
| 16 | 10000 | 20 | 10 |
| 255 | 11111111 | 377 | FF |
| 256 | 100000000 | 400 | 100 |

---

## 🧠 Key Learning Points / 学習のポイント / Poin Pembelajaran

### 🇬🇧 English
- How number systems work internally (binary, octal, decimal, hex)
- Using Java built-in conversion methods with radix (`Integer.parseInt`, `toBinaryString`, etc.)
- Decimal as an **intermediate pivot** for all base conversions
- `try-catch` for robust input validation
- Importance of **single resource management** (`BufferedReader` as class field)
- Defensive programming: null checks for `readLine()` EOF scenarios

### 🇯🇵 日本語
- 数値システム（2進数・8進数・10進数・16進数）の仕組み
- 基数付きの Java 変換メソッド（`Integer.parseInt`、`toBinaryString` など）の活用
- すべての基数変換における**中間ピボット**としての10進数の重要性
- 堅牢な入力バリデーションのための `try-catch`
- **リソース管理**の重要性（`BufferedReader` をクラスフィールドとして一元管理）
- 防御的プログラミング：`readLine()` の EOF シナリオへの null チェック

### 🇮🇩 Bahasa Indonesia
- Cara kerja sistem bilangan secara internal (biner, oktal, desimal, heksadesimal)
- Penggunaan metode konversi Java dengan radix (`Integer.parseInt`, `toBinaryString`, dll.)
- Desimal sebagai **pivot perantara** untuk semua konversi basis
- `try-catch` untuk validasi input yang robust
- Pentingnya **manajemen resource tunggal** (`BufferedReader` sebagai class field)
- Defensive programming: null check untuk skenario EOF pada `readLine()`

---

## ⚠️ Error Handling Coverage / エラー処理 / Penanganan Error

| Error Type | Cause | Handling |
|------------|-------|----------|
| `NumberFormatException` | Invalid char for base (e.g. `9` in binary) | Caught — warning message shown |
| Non-numeric menu input | Letters entered for menu selection | Caught — re-prompt |
| Out-of-range menu | Number outside valid options | Validated — re-prompt |
| `null` input (EOF) | User presses `Ctrl+D` | `null` check — safe exit |
| `IOException` | Stream read failure | Caught in `startConversion()` |

---

## 🚀 How to Run / 実行方法 / Cara Menjalankan

```bash
# 1. Clone the repository
git clone https://github.com/Kodokthegr3at/KisuuhenkanProject.git
cd KisuuhenkanProject

# 2. Compile (make sure you're one level above the project00 folder)
javac project00/KisuuhenkanProject.java

# 3. Run
java project00.KisuuhenkanProject
```

> ⚠️ **Note:** Because the class uses `package project00;`, the file must be inside a folder named `project00/` and compiled/run from the parent directory.

---

## 📈 Future Improvements / 今後の改善 / Rencana Pengembangan

| Feature | Priority | Status |
|---------|----------|--------|
| GUI version (JavaFX / Swing) | Medium | 📋 Planned |
| Support for negative numbers | Low | 📋 Planned |
| Floating-point conversion | Low | 📋 Planned |
| Conversion history log | Medium | 📋 Planned |
| Custom base input (e.g. Base 3, 5, 7) | High | 📋 Planned |
| Unit tests (JUnit) | Medium | 📋 Planned |

---

## 👤 Author / 作者 / Penulis

<div align="center">

**Kodokthegr3at**

[![GitHub](https://img.shields.io/badge/GitHub-Kodokthegr3at-181717?style=for-the-badge&logo=github)](https://github.com/Kodokthegr3at)

> *"Understanding fundamentals is the key to mastering advanced concepts."*  
> *「基礎を理解することが、高度な概念を習得する鍵である。」*  
> *"Memahami fundamental adalah kunci untuk menguasai konsep tingkat lanjut."*

</div>

---

<div align="center">

**⭐ If this project helped you, please give it a star! ⭐**  
**⭐ このプロジェクトが役に立ったら、スターをつけてください！ ⭐**  
**⭐ Jika project ini bermanfaat, berikan bintang ya! ⭐**

</div>
