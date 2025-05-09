//mendefinisikan paket tempat file berada dalam struktur proyek
package com.example.utspemmob1

//mengimpor kelas dan fungsi yang dibutuhkan untuk menjalankan SplashScreen, seperti animasi, tampilan gambar, teks, Handler, dan AppCompatActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//mendefinisikakn kelas SplashScreen ynag mewarisi AppCompatActivity yang membuatnya menjadi activity android
class SplashScreen : AppCompatActivity() {

    //Deklarasi variabel untuk komponen UI ImageView dan TextView, diinisialisasi nanti dengan findViewById
    private lateinit var logoImage: ImageView
    private lateinit var loadingText: TextView

    //Menyimpan jumlah titik (.) yang akan ditampilkan dalam animasi teks
    private var dotCount = 0

    //Membuat handler untuk menjalankan tugas secara periodik atau dengan delay
    private val handler = Handler()

    //Deklarasi variabel Runnable untuk animasi teks titik berjalan, diinisialisasi setelah teks muncul
    private lateinit var dotRunnable: Runnable

    //Mengabaikan peringatan Lint tentang ID yang tidak ditemukan saat inflate layout (meskipun sebenarnya lebih baik periksa ID dengan benar)
    @SuppressLint("MissingInflatedId")
    
    //Override method onCreate, titik masuk saat activity dibuat
    override fun onCreate(savedInstanceState: Bundle?) {

        //Memanggil implementasi onCreate dari superclass
        super.onCreate(savedInstanceState)

        //Menghubungkan file layout activity_splash_screen.xml ke activity ini
        setContentView(R.layout.activity_splash_screen)

        //Menghubungkan ID UI dari XML ke variabel Kotlin
        logoImage = findViewById(R.id.logoImage)
        loadingText = findViewById(R.id.loadingText)

        // Membuat animasi perpindahan (translate) logo dari bawah ke atas dengan interpolator pelambatan dan efek akhir tetap
        val translateAnim = TranslateAnimation(0f, 0f, 30f, 0f).apply {
            duration = 800
            interpolator = DecelerateInterpolator()
            fillAfter = true
        }

        //Menjalankan animasi translate pada logo
        logoImage.startAnimation(translateAnim)

        // Menjalankan blok kode dengan delay 1 detik
        Handler().postDelayed({

            //Membuat animasi zoom (scale) dengan efek "pop-up" untuk teks, dimulai dari ukuran 0 ke 1, pusat di tengah
            val scaleAnim = ScaleAnimation(
                0f, 1f, 0f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
            ).apply {
                duration = 500
                interpolator = OvershootInterpolator()
                fillAfter = true
            }

            //Menampilkan teks loading
            loadingText.visibility = TextView.VISIBLE
            
            //Menjalankan animasi scale pada teks
            loadingText.startAnimation(scaleAnim)

            // Membuat runnable yang akan menampilkan titik (...) pada teks Tunggu sejenak, berganti setiap 500 ms
            dotRunnable = object : Runnable {
                override fun run() {
                    dotCount = (dotCount + 1) % 4
                    val dots = ".".repeat(dotCount)
                    loadingText.text = "Tunggu sejenak$dots"
                    handler.postDelayed(this, 500)
                }
            }

            //Menjalankan dotRunnable pertama kali
            handler.post(dotRunnable)

            // Penutup dari postDelayed, animasi teks mulai setelah 1 detik
        }, 1000) 

        //Setelah 3 detik, memanggil fungsi goToMainActivity() untuk berpindah ke MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            goToMainActivity()
        }, 3000L)
    }

    //Menghapus Runnable saat activity dihancurkan agar tidak berjalan terus di background
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(dotRunnable)
    }

    //Fungsi untuk pindah dari SplashScreen ke MainActivity dan menutup activity saat ini
    private fun goToMainActivity(){
        Intent (this, MainActivity::class.java).also{
            startActivity(it)
            finish()
        }
    }
}
