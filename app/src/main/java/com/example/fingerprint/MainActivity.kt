package com.example.fingerprint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(BiometricHelper.isBiometricAvailable(this)) {

            //Tres partes para a biometria
            // PromptInfo
            // BiometricPrompt
            // Executor que é quem executa de fato

            val executor = ContextCompat.getMainExecutor(this)
            val bio = BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    val s =""
                    super.onAuthenticationSucceeded(result)
                }
            })

            val info = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Titulo")
                .setSubtitle("SubTitle")
                .setDescription("Descrição")
                .setNegativeButtonText("Cancelar")
                .build()

            bio.authenticate(info)

        }
    }
}