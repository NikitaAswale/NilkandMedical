package com.example.nilkanthmedical

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nilkanthmedical.ui.theme.Purple40
import com.example.nilkanthmedical.ui.theme.PurpleGrey40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    val userViewModel: UserViewModel = viewModel()
    val userList by userViewModel.users.collectAsState()
    var mobileNumber by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) } // To be used for showing a loader

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F4F8))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Nilkanth Medical Logo",
                modifier = Modifier.height(120.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            if (userList.isNotEmpty()) {
                Text(
                    text = "Welcome, ${userList[0].name}",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Purple40
                )
            } else {
                Text(
                    text = "Welcome to Nilkanth Medical",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Purple40
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Please enter your mobile number to login or sign up",
                fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = mobileNumber,
                onValueChange = { mobileNumber = it },
                label = { Text("Mobile Number") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Purple40,
                    unfocusedBorderColor = Color.LightGray,
                    cursorColor = Purple40
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { /* Handle login logic here */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Purple40)
            ) {
                Text(text = "Continue", fontSize = 18.sp, color = Color.White)
            }
        }
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
} 