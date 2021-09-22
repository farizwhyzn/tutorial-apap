# Tutorial APAP
## Authors
* **Fariz Wahyuzan Dwitilas** - *1906399511* - *A*

=======
## Tutorial 2
1. Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut setelah menjalankan program: http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
Kebun berhasil ditambahkan karena semua request parameter terdapat valuenya.!

2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat.
Dependency injection. Cara kerjanya adalah Spring akan mencari class yang cocok dengan property pada applicationContext dan melakukan injection secara otomatis.

3. Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut: http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
Terjadi error karena link di atas tidak memiliki parameter NoTelepon, sedangkan parameter NoTelepon adalah required = true.

4. Jika Papa APAP ingin melihat Kebun Safari dengan nama Papa APAP, link apa yang harus diakses?
localhost:8000/kebun-safari?id=1

5.  Tambahkan 1 contoh Kebun Safari lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/, apa yang akan ditampilkan? Sertakan juga
bukti screenshotmu.
[SS1](https://user-images.githubusercontent.com/90312743/133470068-6a2ba0b5-ba9a-4830-9213-70f609a3c301.jpg)
[SS2](https://user-images.githubusercontent.com/90312743/133470135-f46e3c75-64ba-4ce2-ae00-a63d83ff3fff.jpg)



=======
## Tutorial 1
### What I have learned today
(Masukkan pertanyaan yang diikuti jawaban di setiap nomor, contoh seperti dibawah. Anda
juga boleh menambahkan catatan apapun di bagian ini)
Saya belajar mengenai penggunaan Issue Tracker, cara membuat branch dan checkout, dan cara melakukan setup Spring Boot menggunakan Maven pada VSCode.
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
Issue Tracker adalah tab github yang digunakan untuk mencatat atau membuat issue baru jika terdapat suatu masalah. Masalah yang dapat diselesaikan dengan Issue Tracker diantaranya adalah bug report hingga customer question.
2. Apa perbedaan dari git merge dan git merge --squash? Perbedaan antara keduanya terdapat pada commit history. Tidak seperti git merge yang menyimpan semua commit history, git merge squash menggabungkan commit history menjadi satu.
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
suatu aplikasi? Version Control System dapat mengerjakan sebuah proyek dengan tim/kolaborasi secara bersama-sama dalam satu waktu dan menyimpan seluruh log history dari commit.
### Spring
4. Apa itu library & dependency? Library adalah kumpulan kode yang dapat kita reuse, dependency adalah keadaan dimana kode yang kita tulis bergantung dengan kode lain.
5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven? Maven adalah sebuah library, dependency manager. Kita menggunakan Maven agar lebih mudah dalam mengerjakan dan me-manage suatu project. Alternatif dari Maven salah satunya adalah Gradle.
6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
framework? Selain untuk pengembangan web, Spring framework juga dapat mengembangkan semua aplikasi yang Java-based.
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable? RequestParam digunakan untuk mengambil query parameter, sedangkan PathVariable digunakan untuk mengambil langsung data dari URI. RequestParam sebaiknya digunakan jika data yang dipassing dalam bentuk query parameter, sedangkan PathVariable lebih baik digunakan saat URL tersebut mengandung values saja.
### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya harus belajar APAP?
- [ ] Apa perbedaan Spring Boot menggunakan Maven dan menggunakan Gradle?
