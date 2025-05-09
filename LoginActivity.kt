package com.example.utspemmob1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editUsername = findViewById<EditText>(R.id.editTextUsername)
        val editPassword = findViewById<EditText>(R.id.editTextPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val inputUsername = editUsername.text.toString().trim()
            val inputPassword = editPassword.text.toString().trim()

            val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            val savedUsername = sharedPref.getString("username", "")
            val savedPassword = sharedPref.getString("password", "")

            Log.d("LoginEvent", "Tombol Login ditekan")

            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(
                    this,
                    "Username dan Password tidak boleh kosong!",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d("LoginEvent", "Data kosong")
            } else if (inputUsername == savedUsername && inputPassword == savedPassword) {
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
                Log.d("LoginEvent", "Login sukses untuk user: $inputUsername")

                // Arahkan ke dashboard
                val intent = Intent(this, NewsPortalDashboardActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(
                    this,
                    "Username atau Password salah! Silakan ulangi.",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d("LoginEvent", "Login gagal")
            }
        }
    }
}

