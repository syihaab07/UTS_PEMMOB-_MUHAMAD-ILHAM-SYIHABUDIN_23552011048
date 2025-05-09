//Menentukan nama paket tempat kelas NewsPortalDashboardActivity berada (untuk manajemen proyek Android)
package com.example.utspemmob1

//Mengimpor berbagai komponen Android dan AndroidX yang diperlukan
//SuppressLint: Untuk menonaktifkan peringatan tertentu dari Android Lint
import android.annotation.SuppressLint
//Bundle: Menyimpan data saat onCreate dipanggil
import android.os.Bundle
//AppCompatActivity: Kelas dasar activity modern Android
import androidx.appcompat.app.AppCompatActivity
//GridLayoutManager dan LinearLayoutManager: Untuk mengatur tata letak item dalam RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
//RecyclerView: Komponen UI untuk menampilkan daftar scrollable yang efisien
import androidx.recyclerview.widget.RecyclerView
//R.id.recycler_view: Referensi ID dari RecyclerView dalam layout XML
import com.example.utspemmob1.R.id.recycler_view

//Mendeklarasikan kelas activity bernama NewsPortalDashboardActivity
class NewsPortalDashboardActivity : AppCompatActivity() {
    
    //Mendeklarasikan variabel binding bertipe AdapterList (kemungkinan kesalahan penamaan—ini bukan view binding, 
    //tetapi mungkin niatnya untuk menyimpan adapter). Namun, variabel ini tidak digunakan di bawah, sehingga bisa dihapus jika tidak dipakai
    private lateinit var binding: AdapterList

    //Menonaktifkan peringatan lint tentang ID yang tidak ditemukan (meskipun ini seharusnya tidak diperlukan jika layout dan ID benar)
    @SuppressLint("MissingInflatedId")
    //onCreate dipanggil saat activity dibuat pertama kali
    override fun onCreate(savedInstanceState: Bundle?) {
        //uper.onCreate memanggil implementasi default dari superclass
        super.onCreate(savedInstanceState)
        //Mengatur file layout XML activity_news_portal_dashboard.xml sebagai tampilan utama activity ini
        setContentView(R.layout.activity_news_portal_dashboard)
        //Menghubungkan RecyclerView dari layout dengan ID recycler_view ke variabel recyclerView
        val recyclerView = findViewById<RecyclerView>(recycler_view)
        //Mengatur tata letak daftar agar vertikal (seperti daftar biasa, satu kolom ke bawah)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //Baris komentar: bisa digunakan sebagai alternatif untuk menampilkan daftar dalam grid dua kolom
        //recyclerView.layoutManager = GridLayoutManager(this,2)

        //Mengoptimalkan performa RecyclerView jika ukurannya tidak berubah karena ukuran item tetap
        recyclerView.setHasFixedSize(true)
        //Membuat daftar statis itemList yang berisi 3 berita/artikel, masing-masing berupa objek ItemList
        val itemList = listOf(

            //Setiap ItemList berisi judul artikel, deskripsi/konten singkat, dan URL gambar (kemungkinan akan ditampilkan di RecyclerView)
            ItemList("Pentingnya Minum Air Putih Cukup Setiap Hari", "Air putih memegang peran penting dalam menjaga kesehatan tubuh. Sekitar 60% dari berat badan manusia terdiri dari air, yang berfungsi untuk mengatur suhu tubuh, melarutkan mineral dan nutrisi, serta membantu proses pencernaan. Kurangnya asupan air bisa menyebabkan dehidrasi, yang ditandai dengan kelelahan, sakit kepala, dan kesulitan berkonsentrasi. Untuk menjaga keseimbangan cairan tubuh, disarankan minum sekitar 8 gelas air setiap hari atau lebih tergantung aktivitas fisik dan suhu lingkungan. Membiasakan minum air putih sebelum haus datang adalah langkah sederhana namun efektif untuk menjaga kesehatan",
                "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2021/06/29025916/air-putih.jpg"),
            ItemList("Manfaat Berolahraga Rutin untuk Kesehatan Mental", "Olahraga tidak hanya baik untuk tubuh, tetapi juga sangat bermanfaat bagi kesehatan mental. Aktivitas fisik seperti berjalan kaki, jogging, atau yoga dapat merangsang produksi endorfin, hormon yang membuat seseorang merasa bahagia. Selain itu, olahraga juga membantu mengurangi gejala stres, kecemasan, dan depresi. Rutin berolahraga setidaknya 30 menit per hari, 3–5 kali seminggu, dapat meningkatkan kualitas tidur dan rasa percaya diri. Dengan berolahraga secara teratur, tubuh menjadi lebih bugar dan pikiran menjadi lebih tenang dan fokus",
                "https://res.cloudinary.com/dk0z4ums3/image/upload/v1614664554/attached_image/beragam-manfaat-olahraga-0-alodokter.jpg"),
            ItemList("Pola Makan Sehat untuk Meningkatkan Daya Tahan Tubuh", "Daya tahan tubuh yang kuat sangat penting untuk melawan infeksi dan penyakit. Salah satu cara untuk menjaganya adalah dengan menerapkan pola makan sehat. Makanan bergizi seperti buah-buahan, sayuran, biji-bijian utuh, protein tanpa lemak, dan lemak sehat memberikan nutrisi penting bagi sistem imun. Vitamin C dari jeruk, vitamin D dari ikan, dan zinc dari kacang-kacangan adalah contoh nutrisi yang memperkuat daya tahan tubuh. Hindari makanan cepat saji, tinggi gula, dan terlalu banyak garam karena dapat melemahkan sistem kekebalan. Kombinasikan pola makan sehat dengan tidur cukup dan olahraga untuk hasil maksimal",
                "https://asset-2.tstatic.net/health/foto/bank/images/pola-makan-sehat-3.jpg")
        )
        //Membuat adapter (AdapterList) dan mengisi datanya dengan itemList
        val adapter = AdapterList(itemList)
        
        //Menghubungkan adapter dengan RecyclerView agar data ditampilkan
        recyclerView.adapter = adapter
        }
    }
