package com.example.nilkanthmedical

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserComposable() {

    val userviewmodel : UserViewModel = viewModel()
    val userlist = userviewmodel.users.collectAsState().value

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Row(modifier = Modifier, horizontalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Medical Page")
        }
        Row(modifier = Modifier, horizontalArrangement = Arrangement.Center){
            Text(text = userlist.get(0).name , fontSize = 24.sp, fontWeight = FontWeight.W100)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Please Enter your Mobile Number to Login/Sign Up")
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(value = userlist[0].phone, onValueChange = {}, label = { Text("") })
        Spacer(modifier = Modifier.height(4.dp))
    }
}