# Tutorial APAP

## Authors

* **Iqfal Fazrial Pramudya** - *1906353920* - *A*
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
