# Tutorial APAP
## Authors
* **Fariz Wahyuzan Dwitilas** - *1906399511* - *A*

=======
## Tutorial 8 The Last Tutorial
1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian
melakukan langkah - langkah tersebut?
2. Jelaskan fungsi dari async dan await!
async berfungsi untuk mengubah fungsi menjadi asynchronous atau bersifat non-blocking, await  berfungsi untuk menunda eksekusi sebuah kode sampai proses asynchronous berhasil.
3. Masukkan jawaban dari Screenshot yang diperintahkan di halaman 9 pada Component Lifecycle
pada pertanyaan ini.
![1](https://user-images.githubusercontent.com/90312743/144456004-051bc592-26a8-4d7d-955a-efa264ae33f4.jpg)
![2](https://user-images.githubusercontent.com/90312743/144456020-a4c9fab6-dea9-413e-a6a3-60f2c7c822ef.jpg)
![3](https://user-images.githubusercontent.com/90312743/144456028-6c49539d-8677-4b70-a02f-fa6ef64db6a2.jpg)

4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate,
componentDidUpdate, componentWillReceiveProps, componentWillUnmount.
Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja
yang biasanya menggunakan lifecycle method tersebut”.
omponentDidMount: Dipanggil setelah fungsi render dieksekusi, biasanya digunakan untuk manipulasi DOM atau operasi ajax. Seluruh operasi DOM terjadi di fase ini, bukan pada  method render.
ShouldComponentUpdate: Dipanggil sebelum render, memungkinkan untuk mengatur apakah re-rendering diperlukan atau tidak yang salah satunya dapat dilakukan dengan mengakses props dan state yang sekarang. Fungsi harus me-return boolean. Jika fungsi mengembalikan nilai true, component akan dirender ulang, jika false, component tidak dirender ulang. Fungsi ini memiliki 2 parameter, yaitu nextProps dan nextState.
componentDidUpdate: Dipanggil setelah fungsi render, digunakan saat melakukan interaksi dengan environment non-React seperti HTTP Request. Dapat digunakan untuk melakukan operasi DOM setelah data telah diperbarui.
ComponentWillReceiveProps: Dipanggil ketika props telah berubah dan tidak pada saat rendering awal, dapat membandingkan props yang ada dengan yang baru dan memeriksa apakah terdapat perubahan terhadap props tersebut. Memungkinkan perubahan state berdasar pada props yang sekarang dan props baru, tanpa memicu rendering lagi.
componentWillUnmount: Dipanggil ketika komponen telah dibuang dari DOM, dapat digunakan ketika aksi-aksi yang berhubungan dengan pembersihan diperlukan, semisal membuang timer yang sebelumnya didefinisikan di componentDidMount, membatalkan network request dan menghilangkan event listener.

=======
## Tutorial 7
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.
[1.1](https://user-images.githubusercontent.com/90312743/143258669-3ffd146f-fa6d-4283-b8b3-9bffc962a464.jpg)
[1.2](https://user-images.githubusercontent.com/90312743/143258695-ec0cf1b2-6820-49ba-8743-e1a4551cc38a.jpg)
[1.3](https://user-images.githubusercontent.com/90312743/143258726-a59122ce-f5e9-46bf-845d-727e804cdc5d.jpg)
[1.4](https://user-images.githubusercontent.com/90312743/143258757-ee68de63-b5c6-497a-a250-c5bc8b72f550.jpg)
Pada soal nomor 1, untuk membuat item dihapus sesuai dengan yang kita klik, saya melakukan update []cartItems yang berisi semua item pada cart minus item yang akan dihapus, lalu tombol keranjang akan muncul dengan melakukan set .inCart = false.

[2.1](https://user-images.githubusercontent.com/90312743/143260380-976235f2-fde1-41e7-ac70-7e03d3e9b167.png)
[2.2](https://user-images.githubusercontent.com/90312743/143260395-dcecdecf-a757-4ff6-ad47-4495003e8396.png)
[2.3](https://user-images.githubusercontent.com/90312743/143260442-b278bb5c-3aca-453d-8ed1-97b535f3d56c.png)
[2.4](https://user-images.githubusercontent.com/90312743/143260459-635e4298-ff6f-4fd1-9e6d-585683986a4a.png)
Pada nomor 2, update balance dilakukan pada saat melakukan handleAddItemToCart dan handleDeleteItemFromCart, dengan masing-masing mengurangi dan menambah this.state.balance dengan newItem.price.

[3.1](https://user-images.githubusercontent.com/90312743/143260513-0213ee28-a906-4b55-bec0-6f60020c587a.png)
[3.2](https://user-images.githubusercontent.com/90312743/143260543-d09c4215-2693-4108-87a9-f78be4e2ebe1.png)
Pada nomor 3, saya melakukan handling balance setelah tombol dipencet dan handleAddItemToCart dieksekusi, sebelum updateShopItem dieksekusi. Handling dilakukan dengan mengecek apakah this.state.balance dikurangi dengan price item (newItem.price) kurang dari nol. Jika iya, alert akan dikeluarkan. Jika lebih sama dengan nol, state []cartItems akan diupdate dan dilakukan updateShopItem. 


2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?
Props adalah variabel yang berasal dari luar atau parent class, dimana props biasanya digunakan untuk komunikasi data dari parent ke child component, state adalah variabel yang dibuat dalam suatu class, dan tidak dapat di akses dari component lainnya.

3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.
Ya, karena kode yang dihasilkan tidak akan terlalu kompleks/panjang dengan dipecah-pecah menggunakan komponen-komponen tersebut, komponen juga lebih reusable untuk digunakan.

4. Apa perbedaan class component dan functional component?
Functional component: Plain JavaScript function, menerima props sebagai argumen, mereturn react element, tidak menggunakan method render().
Class component: Memerlukan extend react, menggunakan fungsi render() yang mereturn react element.

5. Dalam react, apakah perbedaan component dan element?
Elements merupakan objek yang di-return dari react component. Elements merupakan representasi objek dari sebuah node DOM, sedangkan components adalah sebuah class dengan fungsi render() atau sebuah stateless functional component. Components menerima props sebagai input dan mereturn element tree.

=======
## Tutorial 5
1. Apa itu Postman? Apa kegunaannya? 
Postman adalah aplikasi REST Client untuk melakukan uji coba REST API. Postman memiliki banyak fitur yang membantu dalam proses development API, seperti Collection, Environment, Response, Script Test, Automated Test (Runner), dan Mock Server yang dibuat menggunakan fitur “example response” yang dapat diakses dari internet layaknya API yang sudah di implementasikan dan di deploy ke server.
2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty. @JsonIgnoreProperties merupakan anotasi class yang berguna untuk menandai sebuah property atau attribute class yang ingin di-ignore atau di-exclude dari json class tersebut. @JsonProperty merupakan anotasi class yang digunakan untuk melakukan mapping attribute class dengan JSON key yang diinginkan.
3. Apa kegunaan atribut WebClient?
WebClient adalah sebuah interface yang merepresentasikan entry point utama dari web requests, digunakan untuk menginstansiasi sebuah URL access point serta mengelola request dan response URL tersebut.
4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya? 
ResponseEntity digunakan untuk melakukan konfigurasi terhadap respons HTTP baik status code, header, maupun body-nya. BindingResult adalah objek Spring yang menyimpan hasil validasi, binding, dan errors yang mungkin telah terjadi. BindingResult harus muncul tepat setelah objek model yang divalidasi. Jika tidak, Spring akan mengeluarkan exception.

=======
## Tutorial 4
1. Jelaskan perbedaan th:include dan th:replace! 
th:include akan memasukkan fragment ke dalam sebuah tag html, sedangkan th:replace akan mengganti tag html dengan tag fragment.

2. Jelaskan apa fungsi dari th:object! 
th:object adalah tag yang digunakan untuk menampung sebuah obyek model.

3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
Pada penggunaan th:object, * digunakan untuk menstore object, $ digunakan untuk mengambil sebuah value dari object *. Jika pada suatu penggunaan th:object misal *{menu}, maka dalam membuat th:field tidak perlu lagi menggunakan nama object dari value yang ingin diambil. Contoh: ${menu.namaMenu} menjadi ${namaMenu} dengan penggunaan *.

=======
## Tutorial 3
1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
@AllArgsConstructor: Meng-generate constructor dengan satu parameter untuk setiap field pada class
@NoArgsConstructor : Meng-generate constructor tanpa parameter.
@Setter dan @Getter: Meng-generate default getter dan setter secara otomatis.
@Entity: Menandakan bahwa class merupakan sebuah entitas.
@Table: Menentukan tabel utama dari entitas tersebut.

2. Pada class CabangDB, terdapat method findByNoCabang, apakah kegunaan dari method tersebut?
findByNoCabang digunakan untuk mencari pada database cabang dengan parameter noCabang.

3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn.
@JoinTable menyimpan id dari kedua entity yang di-join ke tabel yang berbeda, @JoinColumn menyimpan id dari entity yang di-join ke sebuah kolom baru pada tabel yang sama.


4. Pada class PegawaiModel, digunakan anotasi @JoinColumn pada atribut cabang, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan nullable dan penggunaan anotasi @NotNull?
name: Nama dari kolom foreign key.
referencedColumnName: Nama kolom yang di-reference oleh kolom foreign key tersebut.
nullable: Menentukan apakah kolom foreign key dapat bernilai null.
@NotNull dan nullable sama-sama akan mendeclare kolom menjadi not-null. Perbedaan terdapat pada tujuan penggunaan dimana @NotNull ditujukan untuk validasi data, sedangkan nullable digunakan untuk mengindikasikan spesifikasi dari database schema.

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER.
FetchType.LAZY: Hanya menginisialisasi dan me-load data dari database yang dipanggil oleh program.
FetchType.EAGER: Menginisialisasi dan me-load semua data yang berhubungan dengan data yang dipanggil oleh program.
CascadeType.ALL: Mempropagasi atau meng-cascade semua operasi (PERSIST, REMOVE, REFRESH, MERGE, DETACH) dari parent entity.


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
