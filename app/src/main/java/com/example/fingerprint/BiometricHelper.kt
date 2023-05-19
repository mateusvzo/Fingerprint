package com.example.fingerprint

import android.content.Context
import android.os.Build
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG

class BiometricHelper {

    companion object {

        fun isBiometricAvailable(context: Context): Boolean {
            //Verifica se a versão é menor do que a 23
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                return false
            }

            //Obter o gerenciador
            val biometricManager = BiometricManager.from(context)

            //BIOMETRIC_WEAK ou BIOMETRIC_STRONG = strong restringe mais do que o weak
            when (biometricManager.canAuthenticate(BIOMETRIC_STRONG)) {

                BiometricManager.BIOMETRIC_SUCCESS -> return true

                //dispositivo não possui autenticação biometrica
                BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> return false

                //hardware com defeito, ou indisponivel
                BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> return false

                //não existe nenhuma digital cadastrada
                BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> return false
            }

            return false
        }

    }
}