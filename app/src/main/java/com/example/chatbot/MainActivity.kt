package com.example.chatbot

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.chatbot.ui.theme.ChatbotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val chatviewmodel=ViewModelProvider(this)[chatviewmodel::class.java]
        setContent {
            ChatbotTheme {
                // A surface container using the 'background' color from the theme

                Scaffold (modifier = Modifier.fillMaxSize()) { innerpadding ->
                    chatpage(modifier = Modifier.padding(innerpadding),chatviewmodel )
                }
                }

            }
        }
    }


