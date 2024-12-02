package com.example.chatbot

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatbot.ui.theme.MessageModel
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch

data class MessageModel(val message: String, val role: String)
class chatviewmodel: ViewModel() {

    val messsageList by lazy {
        mutableStateListOf<MessageModel>()
    }
    val generativeModel: GenerativeModel = GenerativeModel(
        modelName = "gemini-1.5-flash",
        apiKey = "AIzaSyC9M98iQiF8w6rpewvYNEnYIvyskhcfsDY"
    )






    fun sendMessage(question : String){
       viewModelScope.launch {
           val chat=generativeModel.startChat()
           messsageList.add(MessageModel(question,"user"))
           val response=chat.sendMessage(question)
           messsageList.add(MessageModel(response.text.toString(),"model"))

       }
    }
}