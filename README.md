# Tutorial APAP

## Authors

* **Iqfal Fazrial Pramudya** - *1906353920* - *A*

### Tutorial 6
### 1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?
Otentikasi adalah sebuah proses untuk melakukan identifikasi pengguna, sedangkan otorisasi adalah proses untuk menentukan pengguna apakah memiliki izin untuk melakukan suatu tugas tertentu atau tidak. Pada lab kali ini, contoh otentikasi adalah login, sedangkan otorisasi adalah ketika suatu user dengan role tertentu dapat mengakses suatu halaman atau fitur yang ada.

### 2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya
BCryptPasswordEncoder adalah suatu algoritma untuk melakukan hashing pada password, sehingga password yang dimasukkan nantinya akan dirubah dalam bentuk hashcode, Bcrypt sendiri dapat menghasilkan hashcode yang berbeda meskipun input yang dimasukkan sama.

### 3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?
Sebaiknya penyimpanan password menggunakan hashing, karena hasing melakukan konversi password kedalam hashcode secara permanen, sedangkan encryption code yang dihasilkan dapat dilakukan decode dan encode.

### 4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
UUID adalah sebuah kumpulan karakter yang dibuat secara acak untuk menghasilkan suatu data yang unik. UUID berguna untuk menghasilkan unique key pada sebuah table.

### 5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?
UserDetailsServiceImpl digunakan dan harus ada karena untuk mengambil informasi mengenai data pengguna dan melalukan autentikasi pengguna, karena class UserRoleServiceImpl yang dibuat belum dapat melakukan autentikasi pengguna, sehingga harus ada class UserDetailsServiceImpl tersebut.

##referensi:
https://id-laravel.com/post/menggunakan-uuid-di-php-laravel/
https://www.meego.id/2019/03/membuat-unique-key-dengan-uuid-mysql.html
https://www.terraform.io/docs/language/functions/uuid.html
https://www.akakom.ac.id/site/news/124/autentikasi-dan-otorisasi-user-menggunakan-framework-yii
https://www.clickssl.net/blog/difference-between-hashing-vs-encryption
https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/crypto/bcrypt/BCryptPasswordEncoder.html

### Tutorial 5
### 1. Apa itu Postman? Apa kegunaannya?
Postman merupakan sebuah aplikasi yang digunakan untuk melakukan testing REST API, serta membuat & memodifikasi API. Selain itu, Postman juga dapat digunakan untuk melakukan visualisasi dari request response.

### 2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty
@JsonIgnoreProperties merupakan sebuah anotasi pada tingkat class yang digunakan untuk mengabaikan sebuah logical properties yang spesifik.
 Sedangkan @JsonProperty adalah sebuah anotasi yang berguna untuk memberikan nama untuk sebuah properti pada JSON.

### 3. Apa kegunaan atribut WebClient?
WebClient merupakan sebuah modul dari Spring Web Reactive berguna sebagai interface pada sebuah web request yang berfungsi 
untuk melakukan komunikasi dengan server HTTP.

### 4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
ResponseEntity merupakan sebuah extension dari HttpEntity yang merepresentasikan secara keseluruhan sebuah HTTP response, seperti status code, headers
dan body. Selain itu, ResponseEntity juga dapat digunakan untuk melakukan konfigurasi HTTP response. Sedangkan BindingResult adalah sebuah interface
yang berguna untuk menyimpan hasil validasi dari sebuah error yang terjadi.

##Referensi:
http://www.davismol.net/2015/03/10/jackson-json-difference-between-jsonignore-and-jsonignoreproperties-annotations/ 
https://www.baeldung.com/jackson-annotations
https://antares.id/id/postman.html
https://www.techgeeknext.com/spring-boot/webflux/spring-boot-webclient-example
https://www.baeldung.com/spring-5-webclient
https://www.baeldung.com/spring-response-entity
https://technicalsand.com/using-responseentity-in-spring/
https://zetcode.com/spring/bindingresult/
https://blog.postman.com/10-postman-features-everyone-should-know/

### Tutorial 4
### 1. Jelaskan perbedaan th:include dan th:replace!
th:replace berguna untuk mengganti tag yang digunakan saat ini dengan tag yang mendefinisikan fragmen. Sedangkan th:include digunakan untuk memasukkan atau menempatkan fragmen kedalam tag yang ada.

### 2. Jelaskan apa fungsi dari th:object!
th:object berguna untuk menentukan object yang akan digunakan dalam formulir yang nantinya akan dikirimkan.

### 3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
$ merupakan variable expressions, digunakan untuk memilih variabel yang sudah didefinisikan. Sedangkan * merupakan selection expressions yang memiliki kegunaan yang hampir sama dengan variable expressions, perbedaanya adalah * digunakan ketika menggunakan th:object. 

## Referensi:
https://www.baeldung.com/thymeleaf-in-spring-mvc
https://www.sinaungoding.com/yuk-belajar-web-menggunakan-spring-boot2/
https://www.thymeleaf.org/doc/articles/standarddialect5minutes.html

## Tutorial 3
### 1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model(@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
@AllArgsConstructor berguna untuk membuat constructor dengan satu parameter secara otomatis. @NoArgsConstructor untuk membuat constructor tanpa parameter secara otomatis. @Setter untuk membuat method set default secara otomatis. @Getter untuk membuat method get secara otomatis. @Entity untuk menentukan bahwa class merupakan sebuah entitas. @Table untuk menentukan nama tabel dalam database.

### 2.  Pada class CabangDB, terdapat method findByNoCabang, apakah kegunaan dari methodtersebut?
Method tersebut berguna untuk mencari data cabang yang ada pada database berdasarkan nomor cabang.

### 3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn
@JoinTable berfungsi untuk membuat table baru dengan cara menggabungkan column-column pada tabel lain sesuai yang kita ingingkan. Sedangkan @JoinColumn berfungsi untuk membuat column yang berfungsi untuk menghubungkan antara dua entitas.

### 4. Pada class PegawaiModel, digunakan anotasi @JoinColumn pada atribut cabang, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan nullable dan penggunaan anotasi @NotNull
name berguna untuk memberikan nama dari column foreign key tersebut. referencedColumnName berguna untuk menentukan column yang direference oleh foreign key column tersebut. nullable untuk menentukan apakah foreign key column tersebut dapat null atau tidak. Nullabel dan @NotNull memiliki perbedaan, yaitu nullable merupakan bagian dari spesifikasi Java Perstistence API, sedangkan @NotNull didefinisikan dalam spesifikasi Bean Validation. Kemudian, pada Nullable method dapat mengembalikkan nilai null, sedangkan @NotNull tidak. Selain itu, Nullable dapat memiliki variabel yang dapat berupa null, sedangkan @NotNull tidak.

### 5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
FetchType.LAZY berfungsi untuk menentukan tidak melakukan load data secara otomatis(perlu memanggil objeknya terlebih dahulu) pada suatu entitas yang saling berelasi. FetchType.EAGER berfungsi untuk menentukan melakukan load data secara otomatis pada suatu entitas yang saling berelasi. CascadeType.ALL menentukan bahwa segala operasi yang dilakukan akan berpengaruh kepada entitas tersebut.

##Referensi:
https://auth0.com/blog/a-complete-guide-to-lombok/
https://www.sinaungoding.com/relasi-one-to-one-hibernate-anotasi/
https://docs.oracle.com/javaee/6/api/javax/persistence/JoinColumn.html
https://docs.oracle.com/javaee/7/api/javax/persistence/package-summary.html
https://thorben-janssen.com/hibernate-tips-whats-the-difference-between-column-nullable-false-and-notnull/
https://www.jetbrains.com/help/idea/nullable-and-notnull-annotations.html#nullable

## Tutorial 2
### Pertanyaan 1: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut setelah menjalankan program: http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
Terjadi whitelabel error, karena pada saat mengakses link tersebut pada controller merereturn sebuah string yang berupa file HTML, tetapi file HTML tersebut belum dibuat pada folder templates.

### Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja@Autowired tersebut dalam konteks service dan controller yang telah kamu buat
@Autowired merupakan implementasi dari konsep Dependency Injection. @Autowired berguna untuk menggantika setter dan injection pada constructor, sehingga field yang terdapat anotasi @Autowired dapat diisi secara otomatis oleh spring sesuai dengan yang dibutuhkan. Dengan begitu dapat membuat lebih hemat penulisan kode. 

### Pertanyaan 3: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut:http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
Terjadi whitelabel error karena parameter yang diberikan tidak lengkap, parameter noTelepon tidak ada pada link tersebut, sedangkan parameter tersebut pada controller diwajibkan untuk diisi.

### Pertanyaan 4: Jika Papa APAP ingin melihat Kebun Safari dengan nama Papa APAP, link apa yang harus diakses?
Untuk dapat melihat nama Papa APA perlu mengetahui ID dari Kebun Safari tersebut, jika mengetahui ID-nya dapat mengakses link:http://localhost:8080/kebun-safari/view/{id} atau http://localhost:8080/kebun-safari?id=<no id> . Sedangkan jika tidak mengetahui ID dari Kebun Safari tersebut, Link yang harus diakses adalah http://localhost:8080/, dari link tersebut dapat dilihat list Kebun Safari yang ada dan dari list tersebut kita dapat melihat nama dari Kebun Safari yang ada.
  
### Pertanyaan 5: Tambahkan 1 contoh Kebun Safari lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/ , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
Ketika mengakses link http://localhost:8080/ yang ditampilkan adalah daftar Kebun Safari yang sudah saya tambahkan. Berikut link gambar terkait: https://drive.google.com/file/d/11olxFYOeid-1qX26EOK_hC9mAxeU2aOH/view?usp=sharing

#### referensi:
  1.https://www.baeldung.com/spring-autowire
  2.https://software.endy.muhardin.com/java/memahami-dependency-injection/
  
### What I have learned today
-Cara membuat model, controller, dan tampilan html dengan menggunakan spring
-Menghubungkan file pada drive lokal ke github
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
Issue tracker sebuah fitur yang berguna untuk mencatat issue jika terjadi sebuah masalah, sehingga kita dapat mengatur dan memprioritaskan masalah yang berkaitan dengan proyek yang ada. Terdapat beberapa masalah yang dapat diselesaikan dengan  Issue Tracker, seperti menangani masalah bug ketika login, mengekspor data, dan masalah mengenai bug lainnya. Dengan menggunakan Issue Tracker kita dapat melakukan pelacakan masalah lebih mudah.

2. Apa perbedaan dari git merge dan git merge --squash?
git merge dapat digunakan untuk menyatukan suatu branch dengan branch lainnya sehingga dapat menghasilkan beberapa merge commit, sedangkan git merge squash penggabungan branch yang hanya menghasilkan satu merge commit.

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?
Terdapat beberapa keunggulan dari menggunakan Version Control System seperti Git. Pertama, dengan adanya Version Control System kita dapat mengetahui perubahan yang terjadi dari source code yang sedang dikerjakan. Kemudian dapat membantu para developer dalam mengerjakan suatu proyek bersama, karena masing-masing developer dapat memiliki branch sendiri. Dengan menggunakan Version Control System, developer dapat memberikan komentar pada source code yang dikerjakan, sehingga memudahkan developer lainnya mengetahui masalah yang dialami developer lain.

### Spring
4. Apa itu library & dependency?
library adalah kumpulan kode dari suatu bahasa pemrograman yang sudah ditulis sebelumnya dan dapat digunakan kembali untuk menyelesaikan tugas-tugas lain dengan menggunakan kode tersebut. Sedangkan dependensi adalah ketergantungan suatu program dengan program lainnya, atau dapat dikatakan program tersebut dapat berjalan jika satu program lainnya bisa dijalankan.

5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
maven adalah program berbasis teks yang berguna otomasi dan manajemen tool yang menyediakan life-cycle framework untuk para developer.
Alasan kita menggunakan maven adalah karena maven dapat menambahkan dependensi yang diperlukan secara otomatis dengan cara membaca file pom, dapat dengan mudah membuat proyek ke war, jar dan sebagainya, dapat mempermudah pengerjaan proyek di environment yang berbeda karena tidak perlu menangani injeksi dependensi, pemrosesan dan sebagainya. Selain maven, kita dapat menggunakan ant, gradle dan masih banyak yang lainnya.

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
dapat digunakan untuk microservices, reactive, cloud, event driven, dan offline processing data.

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
request param digunakan untuk mengakses suatu nilai dari query parameter, sedangkan path variabel digunakan untuk mengakses nilai dari URL path.

### What I did not understand
-masih belum mengerti konsep dari spring boot, karena masih terbiasa dengan django
-masih cukup bingung masalah mengenai git

### referensi:
https://www.javapedia.net/Spring-MVC-Interview-questions/676
https://www.baeldung.com/spring-requestparam-vs-pathvariable
https://www.learntek.org/blog/what-is-maven/
https://idwebhost.com/blog/pengertian-dan-manfaat-git/
https://idcloudhost.com/pengertian-dan-manfaat-git-bagi-developer/
https://www.petanikode.com/java-maven/
https://www.zendesk.com/blog/issue-tracker/
https://docs.github.com/en/issues/tracking-your-work-with-issues/about-issues
https://coderslegacy.com/what-are-dependencies-in-programming/
https://www.idtech.com/blog/what-are-libraries-in-coding
https://spring.io/why-spring
