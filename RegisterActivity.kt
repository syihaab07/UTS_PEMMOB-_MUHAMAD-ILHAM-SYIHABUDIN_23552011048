//Menentukan nama paket tempat kelas RegisterActivity berada (untuk manajemen proyek Android)
package com.example.utspemmob1

//Mengimpor berbagai kelas yang diperlukan
//Intent: Untuk berpindah antar Activity
import android.content.Intent
//Bundle: Menyimpan data saat activity dibuat
import android.os.Bundle
//Log: Untuk mencetak pesan debug ke Logcat
import android.util.Log
//Button, EditText: Komponen antarmuka pengguna
import android.widget.Button
import android.widget.EditText
//Toast: Menampilkan notifikasi sementara di layar
import android.widget.Toast
//AppCompatActivity: Kelas dasar untuk activity
import androidx.appcompat.app.AppCompatActivity

//Mendeklarasikan kelas RegisterActivity sebagai turunan dari AppCompatActivity
class RegisterActivity : AppCompatActivity() {
    //onCreate dipanggil saat activity ini pertama kali dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        //Memanggil fungsi onCreate dari superclass agar proses default tetap berjalan.
        super.onCreate(savedInstanceState)
        //Menentukan layout XML (activity_register.xml) yang akan digunakan untuk tampilan activity ini
        setContentView(R.layout.activity_register)

        //Menghubungkan elemen UI dari layout ke variabel Kotlin agar bisa digunakan
        val nama = findViewById<EditText>(R.id.editTextNamaLengkap)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val username = findViewById<EditText>(R.id.editTextUsername)
        val password = findViewById<EditText>(R.id.editTextPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        //Menentukan aksi ketika tombol "Register" ditekan
        btnRegister.setOnClickListener {
            //Mengambil dan mengolah isi dari semua input (EditText) menjadi String, serta menghapus spasi di awal/akhir
            val namaStr = nama.text.toString().trim()
            val emailStr = email.text.toString().trim()
            val usernameStr = username.text.toString().trim()
            val passwordStr = password.text.toString().trim()
            
            //Menulis log ke Logcat dengan tag "RegisterEvent"
            Log.d("RegisterEvent", "Tombol Register ditekan")
            //Menampilkan notifikasi bahwa proses pendaftaran sedang berjalan
            Toast.makeText(this, "Mendaftarkan akun...", Toast.LENGTH_SHORT).show()

            //Mengecek apakah ada field yang kosong
            if (namaStr.isEmpty() || emailStr.isEmpty() || usernameStr.isEmpty() || passwordStr.isEmpty()) {
                //Menampilkan pesan jika data belum lengkap dan mencatat log-nya
                Toast.makeText(this, "Harap lengkapi semua data terlebih dahulu!", Toast.LENGTH_SHORT).show()
                Log.d("RegisterEvent", "Data tidak lengkap")
                //Menyimpan username dan password ke SharedPreferences bernama "UserPrefs" agar bisa digunakan saat login nanti
            } else {
                val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("username", usernameStr)
                editor.putString("password", passwordStr)
                editor.apply()

                //Menampilkan pesan sukses dan mencatat log jika registrasi berhasil
                Log.d("RegisterEvent", "Registrasi berhasil untuk username: $usernameStr")
                Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()

                //Membuat dan menjalankan Intent untuk berpindah ke LoginActivity, lalu menutup halaman register agar tidak bisa kembali ke sini dengan tombol "back"
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
