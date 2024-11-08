/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.fruitties.android

import android.os.Bundle
import android.content.IntentFilter
import android.content.Intent
import android.content.BroadcastReceiver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat.registerReceiver
import com.example.fruitties.android.ui.ListScreen
import java.io.File

class MainActivity : ComponentActivity() {
    private lateinit var directBootReceiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val fileToDelete = File(createDeviceProtectedStorageContext().filesDir, "cart.json") // Path to the file in device storage
//
//        if (fileToDelete.exists()) {
//            if (fileToDelete.delete()) {
//                // File deleted successfully
//                println("File deleted: ${fileToDelete.absolutePath}")
//            } else {
//                // Failed to delete the file
//                println("Failed to delete file: ${fileToDelete.absolutePath}")
//            }
//        } else {
//            // File does not exist
//            println("File does not exist: ${fileToDelete.absolutePath}")
//        }
        directBootReceiver = DirectBootReceiver()
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ListScreen()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // Register the receiver when the activity resumes
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_LOCKED_BOOT_COMPLETED)
        }
        registerReceiver(directBootReceiver, filter)
    }

    override fun onPause() {
        super.onPause()
//        // Unregister the receiver when the activity pauses
//        unregisterReceiver(screenOnOffReceiver)
    }
}
