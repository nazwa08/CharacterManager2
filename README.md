# Character Manager — TP3 (Java Visual SIH-6406)

## Deskripsi
Character Manager adalah program berbasis Java yang dibuat untuk mengelola data karakter menggunakan konsep Object-Oriented Programming (OOP). Program ini menerapkan encapsulation, constructor, enum, getter dan setter, serta fitur pengaturan level, HP, attack, dan mana karakter. Program juga memiliki method `isAlive()` untuk memeriksa apakah karakter masih hidup.

## Screenshot Output Program

Berikut adalah screenshot hasil program yang menampilkan data karakter, demo level up, mana, dan hasil pemeriksaan `isAlive()`.

![Screenshot Output Character Manager](tp3.png)

## Struktur Folder Project

```text
javavisual-tp03-[NIM]/
├── README.md
├── screenshots/
│   └── output.png
└── CharacterManager/
    └── src/
        ├── Main.java
        └── com/
            └── unpri/
                └── charactermanager/
                    └── model/
                        ├── Character.java
                        └── CharacterType.java
```

## Identitas Mahasiswa

- **Nama Lengkap:** [Nazwa Haqqi Nasution]
- **NIM:** [253303621233]
- **Link Google Docs Bagian
- :https://1drv.ms/w/c/4c356e610a8583e8/IQAcDgvfKxUSRZ38z01dYsNrAVDUGcBMpsj7cI1MxwJqp9A?e=rvmlqY

_____________________________________________________________________________________________________________________________

# Character Manager Sprint #2 — TP5

## 1. Identitas Tugas

- **Nama:** [Nazwa Haqqi Nasution]
- **NIM:** [253303621233]
- **Link Google Docs:** [https://1drv.ms/w/c/4c356e610a8583e8/IQBwBxDYEQ5vT4MfSUDuHigSAbu2bjve80ZZDsvEj7qn9l8?e=3o8X0L]

## 2. Deskripsi Proyek

Character Manager Sprint #2 merupakan program berbasis Java yang digunakan untuk mengelola karakter dalam sebuah game. Program ini menerapkan konsep Object-Oriented Programming (OOP), khususnya class, object, encapsulation, reference, method overriding, dan pengelolaan kumpulan objek.

Program memiliki class `Character` untuk menyimpan informasi karakter, enum `CharacterType` untuk menentukan tipe karakter, serta class `CharacterManager` untuk mengelola daftar karakter. Program diuji melalui `Main.java` untuk memastikan setiap fitur berjalan sesuai kebutuhan.

## 3. Tujuan

Tujuan pembuatan program ini adalah:

1. Memahami penggunaan class dan object dalam Java.
2. Menerapkan encapsulation melalui atribut `private` dan method yang sesuai.
3. Mengimplementasikan `equals()` untuk membandingkan nama karakter.
4. Mengelola karakter menggunakan `CharacterManager`.
5. Mencegah penambahan karakter dengan nama duplikat.
6. Memahami perbedaan referensi objek dan salinan daftar.
7. Menghitung rata-rata level dan mencari karakter berdasarkan tipe.
8. Membuat fitur analitik tambahan untuk mencari karakter dengan attack tertinggi.

## 4. Struktur Folder

```text
CharacterManager2/
├── README.md
├── Screenshot/
│   ├── Cuplikan layar 2026-10-22 162756.png
│   └── Cuplikan layar 2026-10-22 190612.png
└── src/
    ├── Main.java
    └── com/
        └── unpri/
            └── charactermanager/
                └── model/
                    ├── Character.java
                    ├── CharacterType.java
                    └── CharacterManager.java
```

Keterangan:

- `Main.java`: menjalankan program dan menguji fitur-fitur yang dibuat.
- `Character.java`: menyimpan data karakter seperti nama, tipe, level, HP, attack, dan mana.
- `CharacterType.java`: mendefinisikan tipe karakter menggunakan enum.
- `CharacterManager.java`: mengelola daftar karakter dan menyediakan method pencarian serta analitik.
- `README.md`: dokumentasi proyek.
- `Screenshot/`: menyimpan bukti hasil pengujian program.

## 5. Implementasi Fitur

### A. Implementasi Core

**1. `equals()`**

Method `equals()` digunakan untuk membandingkan nama karakter tanpa membedakan huruf besar dan kecil. Contohnya, nama `Arthur` dan `arthur` dianggap sama.

**2. `addCharacter()`**

Method ini menambahkan karakter ke daftar. Jika nama karakter sudah digunakan, penambahan ditolak agar tidak terjadi duplikasi.

**3. `findByName()`**

Method ini mencari karakter berdasarkan nama. Jika karakter ditemukan, objek karakter dikembalikan; jika tidak ditemukan, hasilnya `null`.

**4. `removeCharacter()`**

Method ini menghapus karakter berdasarkan nama dan mengembalikan status keberhasilan penghapusan.

**5. `getTotalCharacters()`**

Method ini mengembalikan jumlah karakter yang tersimpan dalam daftar.

**6. `getAllCharacters()`**

Method ini mengembalikan salinan daftar karakter, bukan daftar internal secara langsung. Dengan demikian, perubahan pada daftar salinan tidak menghapus atau mengubah isi daftar internal `CharacterManager`.

### B. Mini-Challenge

**1. `getAverageLevel()`**

Method ini menghitung rata-rata level seluruh karakter dengan menjumlahkan level dan membaginya dengan jumlah karakter. Jika daftar kosong, method mengembalikan `0` untuk mencegah pembagian dengan nol.

**2. `findByType(CharacterType type)`**

Method ini mencari semua karakter yang memiliki tipe tertentu dan mengembalikan daftar hasil pencarian. Contohnya, pencarian tipe `MAGE` menghasilkan karakter Merlin.

### C. Fitur Analitik Rancangan Sendiri — `findStrongest()`

Fitur tambahan yang dibuat adalah `findStrongest()`, yaitu method untuk mencari karakter dengan nilai attack tertinggi.

Method memeriksa daftar karakter satu per satu, lalu membandingkan nilai attack untuk menentukan karakter terkuat. Jika daftar karakter kosong, method mengembalikan `null`.

Fitur ini menjaga encapsulation karena tidak mengembalikan `ArrayList` internal milik `CharacterManager`. Method hanya mengembalikan satu objek `Character`, sehingga pemanggil dapat mengetahui karakter terkuat tanpa memperoleh akses langsung ke daftar internal.

**Alasan pemilihan fitur:**

Fitur ini berguna untuk mengetahui karakter dengan kekuatan serangan tertinggi. Selain itu, fitur ini melatih penggunaan perulangan, percabangan, perbandingan nilai, dan penanganan kondisi ketika daftar kosong.

## 6. Hasil Pengujian

Pengujian dilakukan menggunakan tiga karakter:

| Nama | Tipe | Level | HP | Attack |
|---|---|---:|---:|---:|
| Arthur | WARRIOR | 1 | 100 | 10 |
| Merlin | MAGE | 3 | 140 | 20 |
| Robin | ARCHER | 2 | 120 | 15 |

Hasil pengujian yang diharapkan:

1. Ketiga karakter berhasil ditambahkan.
2. Nama duplikat `arthur` ditolak karena karakter `Arthur` sudah ada.
3. Perbandingan `Arthur` dan `arthur` menggunakan `equals()` menghasilkan `true`.
4. Pencarian karakter `Merlin` berhasil.
5. Menghapus isi daftar salinan tidak mengubah daftar asli.
6. Rata-rata level ketiga karakter menghasilkan `2.0`.
7. Pencarian tipe `MAGE` menemukan Merlin.
8. Rata-rata level pada daftar kosong menghasilkan `0.0`.
9. Fitur `findStrongest()` menemukan Merlin dengan attack `20`.
10. Fitur `findStrongest()` mengembalikan `null` ketika daftar kosong.
11. Penghapusan Robin berhasil dan jumlah karakter berkurang.

Hasil aktual dapat dilihat pada screenshot output program yang disimpan di folder `Screenshot/`.

## 7. Penjelasan Encapsulation dan Reference

Encapsulation diterapkan dengan menjadikan daftar karakter sebagai atribut `private` di dalam `CharacterManager`. Daftar tersebut tidak dapat diakses langsung dari luar class. Pengelolaan data dilakukan melalui method yang disediakan.

Reference adalah variabel yang merujuk pada objek. Jika dua variabel menunjuk objek yang sama, perubahan melalui salah satu variabel dapat terlihat melalui variabel lainnya. Oleh karena itu, pengembalian daftar salinan melalui `getAllCharacters()` membantu mencegah pemanggil mengubah struktur daftar internal secara langsung.

Konsep tersebut penting agar data karakter tetap terkontrol dan perilaku program lebih mudah diprediksi.

## 8. Cara Menjalankan Program

1. Buka folder `CharacterManager2` menggunakan Visual Studio Code.
2. Pastikan Java sudah terpasang dan ekstensi Java di VS Code berfungsi.
3. Buka file `src/Main.java`.
4. Jalankan method `main()` dengan menekan tombol **Run**.
5. Periksa hasil pengujian pada Terminal.

## 9. Screenshot Hasil Program

![alt text](Tp5.png>)

## 10. Kesimpulan

Program Character Manager Sprint #2 berhasil menggabungkan pengelolaan objek karakter dengan berbagai fitur pencarian dan analitik. Implementasi `equals()` membantu membandingkan nama karakter, sedangkan `CharacterManager` mengelola penambahan, pencarian, dan penghapusan karakter. Mini-challenge menambahkan kemampuan menghitung rata-rata level dan mencari karakter berdasarkan tipe. Fitur `findStrongest()` melengkapi program dengan pencarian karakter yang memiliki attack tertinggi.

Melalui proyek ini, konsep encapsulation dan reference dapat dipahami melalui implementasi dan pengujian langsung. Program juga menunjukkan pentingnya menjaga akses terhadap data internal agar pengelolaan objek lebih aman dan terstruktur.
