package com.example.utspemmob1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val nama = findViewById<EditText>(R.id.editTextNamaLengkap)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val username = findViewById<EditText>(R.id.editTextUsername)
        val password = findViewById<EditText>(R.id.editTextPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val namaStr = nama.text.toString().trim()
            val emailStr = email.text.toString().trim()
            val usernameStr = username.text.toString().trim()
            val passwordStr = password.text.toString().trim()

            Log.d("RegisterEvent", "Tombol Register ditekan")
            Toast.makeText(this, "Mendaftarkan akun...", Toast.LENGTH_SHORT).show()

            if (namaStr.isEmpty() || emailStr.isEmpty() || usernameStr.isEmpty() || passwordStr.isEmpty()) {
                Toast.makeText(this, "Harap lengkapi semua data terlebih dahulu!", Toast.LENGTH_SHORT).show()
                Log.d("RegisterEvent", "Data tidak lengkap")
            } else {
                val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("username", usernameStr)
                editor.putString("password", passwordStr)
                editor.apply()

                Log.d("RegisterEvent", "Registrasi berhasil untuk username: $usernameStr")
                Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}