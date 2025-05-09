//Mendefinisikan paket (package) tempat file ini berada. Berguna untuk mengelompokkan file dalam struktur aplikasi
package com.example.utspemmob1

//Mengimpor kelas-kelas yang diperlukan
//Intent: Untuk berpindah activity
import android.content.Intent
//Bundle: Untuk menyimpan data saat activity dibuat
import android.os.Bundle
//AppCompatActivity: Kelas dasar untuk activity
import androidx.appcompat.app.AppCompatActivity
//Button: Untuk menggunakan tombol di UI
import android.widget.Button

//Mendeklarasikan class MainActivity, yang merupakan activity utama, dan mewarisi AppCompatActivity
class MainActivity : AppCompatActivity() {

    //Override (menimpa) fungsi onCreate(), yaitu fungsi yang dipanggil saat activity pertama kali dibuat
    override fun onCreate(savedInstanceState: Bundle?) {

        //Memanggil versi onCreate() dari superclass (AppCompatActivity) agar fungsi dasarnya tetap berjalan
        super.onCreate(savedInstanceState)
        
        //Mengatur tampilan/layout activity ini dengan XML activity_main.xml
        setContentView(R.layout.activity_main)

        //Menghubungkan tombol-tombol dari layout XML (loginButton dan registerButton) ke variabel di Kotlin supaya bisa digunakan dalam kode
        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerButton = findViewById<Button>(R.id.registerButton)

        //Menentukan aksi ketika tombol Login ditekan
        loginButton.setOnClickListener {
            //Membuat Intent untuk berpindah dari MainActivity ke LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            //Menjalankan LoginActivity dengan Intent tadi
            startActivity(intent)
        }

        //Sama seperti loginButton, tetapi digunakan untuk berpindah ke RegisterActivity saat tombol Register ditekan
        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        
        //Menutup fungsi onCreate() dan class MainActivity
    }
}
