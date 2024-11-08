package com.example.fruitties.android

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.fruitties.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DirectBootReceiver : BroadcastReceiver() {
    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_LOCKED_BOOT_COMPLETED) {
            val deviceProtectedContext = context.createDeviceProtectedStorageContext()
            val userEncryptedContext = context
//            val file = File(userEncryptedContext.filesDir, "cart.json") // try to write on encrypted storage during direct boot. see what crash happens
//            // Append a message to the file indicating screen state change
//            val message = "{\"items\":[]}"
//            file.appendText(message)
            mainViewModel.removeAllFromCart()
        }
    }
}
