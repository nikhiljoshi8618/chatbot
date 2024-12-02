package com.example.chatbot

import android.inputmethodservice.Keyboard.Row
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.chatbot.ui.theme.MessageModel


@Composable
fun chatpage(modifier: Modifier=Modifier,viewModel: chatviewmodel){
    Text(text = "ChatPage")
    Column (
        modifier=modifier
    ){
        appheader()
        MessageList(modifier = Modifier.weight(1f), messageList = viewModel.messsageList)
        msginput(onMessageSend = {
            viewModel.sendMessage(it)
        })
    }
}


@Composable
fun MessageList(modifier: Modifier=Modifier,messageList: List<MessageModel>){
                LazyColumn(modifier=modifier,
                    reverseLayout = true) {
                    items(messageList.reversed()){
                        Text(text = it.message)
                        
                    }
                } 
}

@Composable
fun appheader(modifier: Modifier=Modifier){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
    ){
        Text(modifier=Modifier.padding(16.dp),
            text="Chatbot",
            color = Color.White,
            fontSize = 22.sp)
    }
}

@Composable
fun msginput(onMessageSend : (String)->Unit){
    var message by remember {
        mutableStateOf("")
    }
    Row (
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically


    ){
        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value =message , onValueChange ={
            message=it
        } )
        IconButton(onClick = { onMessageSend(message)
            message=""
        }) {
            Icon(imageVector = Icons.Default.Send, contentDescription = "send")
        }
    }
}

