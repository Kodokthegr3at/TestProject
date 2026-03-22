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

---

## 🛠️ Tech Stack / 使用技術 / Teknologi

| Component | Detail |
|-----------|--------|
| Language | Java (Core) |
| Input | `BufferedReader` + `InputStreamReader` |
| Conversion | `Integer.parseInt()` with radix |
| Error Handling | `try-catch` block |
| Build | Manual `javac` / IDE (IntelliJ / Eclipse) |

---

## ⚙️ How It Works / 動作の仕組み / Cara Kerja

### 🔄 Conversion Flow / 変換フロー / Alur Konversi

```
┌─────────────────────────────────────────────────────┐
│                   USER STARTS APP                    │
└────────────────────────┬────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────┐
│           STEP 1: Select SOURCE Base                 │
│                                                      │
│    1. DARI 2  (Binary / 2進数 / Biner)               │
│    2. DARI 8  (Octal / 8進数 / Oktal)                │
│    3. DARI 10 (Decimal / 10進数 / Desimal)           │
│    4. DARI 16 (Hex / 16進数 / Heksadesimal)          │
└────────────────────────┬────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────┐
│           STEP 2: Select TARGET Base                 │
│     (options shown dynamically, source excluded)     │
└────────────────────────┬────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────┐
│           STEP 3: Input Number                       │
│     User enters a number in the selected base        │
└────────────────────────┬────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────┐
│           STEP 4: Convert to DECIMAL first           │
│     int desimal = Integer.parseInt(angka, base);     │
└────────────────────────┬────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────┐
│           STEP 5: Convert to TARGET Base             │
│     Integer.toBinaryString(desimal)  → Base 2        │
│     Integer.toOctalString(desimal)   → Base 8        │
│     String.valueOf(desimal)          → Base 10       │
│     Integer.toHexString(desimal)     → Base 16       │
└────────────────────────┬────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────┐
│           STEP 6: Display Result                     │
│         HASIL KONVERSI: [result]                     │
└────────────────────────┬────────────────────────────┘
                         │
                         ▼
              Continue? ──► Loop back to STEP 1
              Exit?     ──► Program ends
```

---

## 💻 Core Code / コアコード / Kode Utama

### Input Handling

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

System.out.println("Pilih basis asal:");
System.out.println("1. DARI 2  -> (Binary)");
System.out.println("2. DARI 8  -> (Octal)");
System.out.println("3. DARI 10 -> (Decimal)");
System.out.println("4. DARI 16 -> (Hexadecimal)");

String pilihan = br.readLine();
```

### Conversion Logic

```java
// Step 1: Convert any base → Decimal first
int desimal = Integer.parseInt(angka, base);
//                             ↑      ↑
//                         input    radix (2/8/10/16)

// Step 2: Convert Decimal → Target base
String hasil;
switch (targetBase) {
    case 2:
        hasil = Integer.toBinaryString(desimal);
        break;
    case 8:
        hasil = Integer.toOctalString(desimal);
        break;
    case 10:
        hasil = String.valueOf(desimal);
        break;
    case 16:
        hasil = Integer.toHexString(desimal).toUpperCase();
        break;
    default:
        hasil = "Error";
}

System.out.println("HASIL KONVERSI: " + hasil);
```

### Error Handling

```java
try {
    int desimal = Integer.parseInt(angka, base);
    // ... conversion logic
} catch (NumberFormatException e) {
    System.out.println("⚠ Input tidak valid untuk basis " + base);
    System.out.println("   Pastikan angka sesuai dengan basis yang dipilih.");
} catch (Exception e) {
    System.out.println("⚠ Terjadi kesalahan: " + e.getMessage());
}
```

---

## 📌 Example / 使用例 / Contoh Penggunaan

### Example 1 — Decimal → Binary

```
=== KISUUHENKAN PROJECT ===

Pilih basis asal:
1. DARI 2
2. DARI 8
3. DARI 10
4. DARI 16
> 3

Pilih basis tujuan:
1. KE 2
2. KE 8
3. KE 16
> 1

Masukkan angka (basis 10): 10

HASIL KONVERSI: 1010
```

### Example 2 — Hexadecimal → Decimal

```
Pilih basis asal:
> 4  (Hex)

Pilih basis tujuan:
> 3  (Decimal)

Masukkan angka (basis 16): FF

HASIL KONVERSI: 255
```

### Example 3 — Invalid Input

```
Masukkan angka (basis 2): 999

⚠ Input tidak valid untuk basis 2
   Pastikan angka sesuai dengan basis yang dipilih.
```

---

## 🔢 Conversion Reference Table / 変換参照表 / Tabel Referensi Konversi

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
- Understanding how number systems work internally (binary, octal, decimal, hex)
- Using Java built-in conversion methods (`Integer.parseInt`, `Integer.toBinaryString`, etc.)
- Applying `try-catch` for robust input validation
- Designing a clean CLI-based interactive application
- The importance of using decimal as an **intermediate pivot** for all base conversions

### 🇯🇵 日本語
- 数値システム（2進数・8進数・10進数・16進数）の内部的な仕組みの理解
- Javaの組み込み変換メソッド（`Integer.parseInt`、`Integer.toBinaryString` など）の活用
- 堅牢な入力バリデーションのための `try-catch` の適用
- クリーンなCLIベースの対話型アプリケーションの設計
- すべての基数変換において10進数を**中間ピボット**として使う重要性

### 🇮🇩 Bahasa Indonesia
- Memahami cara kerja sistem bilangan secara internal (biner, oktal, desimal, heksadesimal)
- Menggunakan metode konversi bawaan Java (`Integer.parseInt`, `Integer.toBinaryString`, dll.)
- Menerapkan `try-catch` untuk validasi input yang kuat
- Merancang aplikasi CLI interaktif yang bersih
- Pentingnya menggunakan desimal sebagai **pivot perantara** untuk semua konversi basis

---

## ⚠️ Error Handling Coverage / エラー処理 / Penanganan Error

| Error Type | Cause | Handling |
|------------|-------|----------|
| `NumberFormatException` | Input char invalid for base (e.g. `9` in binary) | Catch + warning message |
| Non-numeric input | Letters entered for numeric field | Catch + prompt retry |
| Out-of-range menu | Menu number outside valid options | Validation + re-prompt |
| Empty input | User presses Enter without typing | Null/empty check |

---

## 🚀 How to Run / 実行方法 / Cara Menjalankan

```bash
# 1. Clone the repository
git clone https://github.com/Kodokthegr3at/KisuuhenkanProject.git
cd KisuuhenkanProject

# 2. Compile
javac KisuuhenkanProject.java

# 3. Run
java KisuuhenkanProject
```

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
