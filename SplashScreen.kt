package com.example.utspemmob1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    private lateinit var logoImage: ImageView
    private lateinit var loadingText: TextView
    private var dotCount = 0
    private val handler = Handler()
    private lateinit var dotRunnable: Runnable

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        logoImage = findViewById(R.id.logoImage)
        loadingText = findViewById(R.id.loadingText)

        // Logo animation: naik sedikit
        val translateAnim = TranslateAnimation(0f, 0f, 30f, 0f).apply {
            duration = 800
            interpolator = DecelerateInterpolator()
            fillAfter = true
        }

        logoImage.startAnimation(translateAnim)

        // Setelah delay, munculkan text dengan animasi pop-up
        Handler().postDelayed({
            val scaleAnim = ScaleAnimation(
                0f, 1f, 0f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
            ).apply {
                duration = 500
                interpolator = OvershootInterpolator()
                fillAfter = true
            }

            loadingText.visibility = TextView.VISIBLE
            loadingText.startAnimation(scaleAnim)

            // Animasi titik berjalan (...)
            dotRunnable = object : Runnable {
                override fun run() {
                    dotCount = (dotCount + 1) % 4
                    val dots = ".".repeat(dotCount)
                    loadingText.text = "Tunggu sejenak$dots"
                    handler.postDelayed(this, 500)
                }
            }
            handler.post(dotRunnable)

        }, 1000) // delay 1 detik setelah animasi logo
        Handler(Looper.getMainLooper()).postDelayed({
            goToMainActivity()
        }, 3000L)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(dotRunnable)
    }

    private fun goToMainActivity(){
        Intent (this, MainActivity::class.java).also{
            startActivity(it)
            finish()
        }
    }
}