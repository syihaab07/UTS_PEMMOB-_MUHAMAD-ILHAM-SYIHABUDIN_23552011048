//Mendeklarasikan paket tempat file ini berada (bagian dari struktur proyek Android)
package com.example.utspemmob1

//Mengimpor berbagai kelas Android yang digunakan
//SuppressLint: Digunakan untuk mengabaikan peringatan lint (di sini untuk ID layout)
import android.annotation.SuppressLint
//Intent: Untuk berpindah antar activity
import android.content.Intent
//Bundle: Menyimpan data saat pembuatan activity
import android.os.Bundle
//Log: Mencetak log ke Logcat untuk debugging
import android.util.Log
//EditText, Button: Komponen input dan tombol
import android.widget.Button
import android.widget.EditText
//Toast: Menampilkan pesan pop-up kecil di layar
import android.widget.Toast
//AppCompatActivity: Kelas dasar untuk activity
import androidx.appcompat.app.AppCompatActivity

//Mendeklarasikan class LoginActivity sebagai turunan dari AppCompatActivity
class LoginActivity : AppCompatActivity() {
    //@SuppressLint("MissingInflatedId") digunakan untuk mengabaikan peringatan lint jika IDE mengira ID mungkin tidak dikenali
    @SuppressLint("MissingInflatedId")
    //Override fun onCreate, yang dipanggil saat activity dibuat pertama kali
    override fun onCreate(savedInstanceState: Bundle?) {
        //Memanggil metode onCreate() dari AppCompatActivity untuk menjalankan proses dasar pembuatan activity
        super.onCreate(savedInstanceState)
        //Menentukan layout XML yang digunakan oleh activity ini (activity_login.xml)
        setContentView(R.layout.activity_login)

        //Menghubungkan elemen UI dari layout ke variabel di Kotlin agar bisa digunakan dalam kode
        val editUsername = findViewById<EditText>(R.id.editTextUsername)
        val editPassword = findViewById<EditText>(R.id.editTextPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        //Menambahkan aksi ketika tombol Login ditekan
        btnLogin.setOnClickListener {
            //Mengambil input dari EditText dan menghapus spasi kosong di awal/akhir
            val inputUsername = editUsername.text.toString().trim()
            val inputPassword = editPassword.text.toString().trim()

            //Mengakses data SharedPreferences dengan nama "UserPrefs" untuk membaca username & password yang disimpan saat registrasi
            val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            val savedUsername = sharedPref.getString("username", "")
            val savedPassword = sharedPref.getString("password", "")

            //Mencetak log ke Logcat untuk debugging dengan tag "LoginEvent"
            Log.d("LoginEvent", "Tombol Login ditekan")

            //Mengecek apakah field username atau password kosong
            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                //Menampilkan pesan kesalahan jika input kosong dan mencetak log
                Toast.makeText(
                    this,
                    "Username dan Password tidak boleh kosong!",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d("LoginEvent", "Data kosong")
                //Mengecek apakah input cocok dengan data yang tersimpan di SharedPreferences
            } else if (inputUsername == savedUsername && inputPassword == savedPassword) {
                //Menampilkan pesan sukses dan log jika login berhasil
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
                Log.d("LoginEvent", "Login sukses untuk user: $inputUsername")

                // Membuat dan menjalankan intent untuk berpindah ke NewsPortalDashboardActivity, lalu menutup LoginActivity agar tidak bisa kembali dengan tombol "back"
                val intent = Intent(this, NewsPortalDashboardActivity::class.java)
                startActivity(intent)
                finish()
                //Jika login gagal, tampilkan pesan kesalahan dan log-nya
            } else {
                Toast.makeText(
                    this,
                    "Username atau Password salah! Silakan ulangi.",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d("LoginEvent", "Login gagal")
            }
            //Menutup blok kode dari onCreate dan class LoginActivity
        }
    }
}

