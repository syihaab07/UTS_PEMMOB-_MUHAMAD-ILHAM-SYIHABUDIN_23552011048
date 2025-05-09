package com.example.utspemmob1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.utspemmob1.R.id.recycler_view

class NewsPortalDashboardActivity : AppCompatActivity() {
    private lateinit var binding: AdapterList
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_portal_dashboard)
        val recyclerView = findViewById<RecyclerView>(recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.setHasFixedSize(true)
        val itemList = listOf(
            ItemList("Pentingnya Minum Air Putih Cukup Setiap Hari", "Air putih memegang peran penting dalam menjaga kesehatan tubuh. Sekitar 60% dari berat badan manusia terdiri dari air, yang berfungsi untuk mengatur suhu tubuh, melarutkan mineral dan nutrisi, serta membantu proses pencernaan. Kurangnya asupan air bisa menyebabkan dehidrasi, yang ditandai dengan kelelahan, sakit kepala, dan kesulitan berkonsentrasi. Untuk menjaga keseimbangan cairan tubuh, disarankan minum sekitar 8 gelas air setiap hari atau lebih tergantung aktivitas fisik dan suhu lingkungan. Membiasakan minum air putih sebelum haus datang adalah langkah sederhana namun efektif untuk menjaga kesehatan",
                "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2021/06/29025916/air-putih.jpg"),
            ItemList("Manfaat Berolahraga Rutin untuk Kesehatan Mental", "Olahraga tidak hanya baik untuk tubuh, tetapi juga sangat bermanfaat bagi kesehatan mental. Aktivitas fisik seperti berjalan kaki, jogging, atau yoga dapat merangsang produksi endorfin, hormon yang membuat seseorang merasa bahagia. Selain itu, olahraga juga membantu mengurangi gejala stres, kecemasan, dan depresi. Rutin berolahraga setidaknya 30 menit per hari, 3–5 kali seminggu, dapat meningkatkan kualitas tidur dan rasa percaya diri. Dengan berolahraga secara teratur, tubuh menjadi lebih bugar dan pikiran menjadi lebih tenang dan fokus",
                "https://res.cloudinary.com/dk0z4ums3/image/upload/v1614664554/attached_image/beragam-manfaat-olahraga-0-alodokter.jpg"),
            ItemList("Pola Makan Sehat untuk Meningkatkan Daya Tahan Tubuh", "Daya tahan tubuh yang kuat sangat penting untuk melawan infeksi dan penyakit. Salah satu cara untuk menjaganya adalah dengan menerapkan pola makan sehat. Makanan bergizi seperti buah-buahan, sayuran, biji-bijian utuh, protein tanpa lemak, dan lemak sehat memberikan nutrisi penting bagi sistem imun. Vitamin C dari jeruk, vitamin D dari ikan, dan zinc dari kacang-kacangan adalah contoh nutrisi yang memperkuat daya tahan tubuh. Hindari makanan cepat saji, tinggi gula, dan terlalu banyak garam karena dapat melemahkan sistem kekebalan. Kombinasikan pola makan sehat dengan tidur cukup dan olahraga untuk hasil maksimal",
                "https://asset-2.tstatic.net/health/foto/bank/images/pola-makan-sehat-3.jpg")
        )
        val adapter = AdapterList(itemList)
        recyclerView.adapter = adapter
        }
    }
