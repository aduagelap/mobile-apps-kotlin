package org.company.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ez_tenant_kotlin.composeapp.generated.resources.Res
import ez_tenant_kotlin.composeapp.generated.resources.iconbuilding
import ez_tenant_kotlin.composeapp.generated.resources.iconpasshidden
import ez_tenant_kotlin.composeapp.generated.resources.iconpassshow
import ez_tenant_kotlin.composeapp.generated.resources.iconpassword
import ez_tenant_kotlin.composeapp.generated.resources.logo
import moe.tlaster.precompose.navigation.Navigator
import org.jetbrains.compose.resources.painterResource

class DialogLogin() {
    @Composable
    fun LoginScreen(navigator: Navigator) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .windowInsetsPadding(WindowInsets.safeDrawing),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(
                    modifier = Modifier
                        .size(250.dp)
                        .padding(16.dp),
                    painter = painterResource(Res.drawable.logo),
                    contentDescription = null
                )

                var project by remember { mutableStateOf("") }
                var username by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var passwordVisibility: Boolean by remember { mutableStateOf(false) }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp)
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .blur(30.dp, 30.dp),
                        value = project,
                        onValueChange = { project = it },
                        label = { Text("Project") },
                        shape = RoundedCornerShape(10.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(Res.drawable.iconbuilding),
                                contentDescription = "Localized description",
                                Modifier.size(InputChipDefaults.AvatarSize)
                            )
                        },
                    )

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = username,
                        onValueChange = { username = it },
                        label = { Text("Username") },
                        shape = RoundedCornerShape(10.dp),
                        leadingIcon = {
                            Icon(
                                Icons.Filled.Person,
                                contentDescription = "Localized description",
                                Modifier.size(InputChipDefaults.AvatarSize)
                            )
                        },
                    )

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = password,
                        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        shape = RoundedCornerShape(10.dp),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(Res.drawable.iconpassword),
                                contentDescription = "Localized description",
                                Modifier.size(AssistChipDefaults.IconSize)
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility = !passwordVisibility
                            }) { painterResource(Res.drawable.iconpassword) }
                            Icon(
                                painter = if (passwordVisibility) painterResource(Res.drawable.iconpassshow) else painterResource(
                                    Res.drawable.iconpasshidden
                                ),
                                contentDescription = "Localized description",
                                Modifier.size(AssistChipDefaults.IconSize),
                            )
                        },
                    )

                    Text(
                        text = ("Forgot Password"),
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 5.dp, 0.dp, 5.dp)
                    )
                }


                Button(
                    onClick = { navigator.navigate("/home") },
                    colors = ButtonDefaults.buttonColors(Color(0xff00a2ff)),
                ) {
                    Text("Login")
                }
            }
        }
    }
}