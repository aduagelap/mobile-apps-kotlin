package org.company.app.components

import android.content.res.Resources
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ez_tenant_kotlin.composeapp.generated.resources.Res
import ez_tenant_kotlin.composeapp.generated.resources.iconbuilding
import ez_tenant_kotlin.composeapp.generated.resources.iconpasshidden
import ez_tenant_kotlin.composeapp.generated.resources.iconpassshow
import ez_tenant_kotlin.composeapp.generated.resources.iconpassword
import ez_tenant_kotlin.composeapp.generated.resources.logo
import kotlinx.coroutines.isActive
import org.jetbrains.compose.resources.painterResource

class Home {
    @Composable
    fun homeScreen(){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .windowInsetsPadding(WindowInsets.safeDrawing)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            var isRotating by remember { mutableStateOf(false) }

            val rotate = remember { Animatable(0f) }
            val target = 360f
            if (isRotating) {
                LaunchedEffect(Unit) {
                    while (isActive) {
                        val remaining = (target - rotate.value) / target
                        rotate.animateTo(target, animationSpec = tween((1_000 * remaining).toInt(), easing = LinearEasing))
                        rotate.snapTo(0f)
                    }
                }
            }

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

            OutlinedTextField(
                modifier = Modifier
                    .padding(10.dp),
                value = project,
                onValueChange = { project = it },
                label = { Text("username") },
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
                    .padding(10.dp),
                value = username,
                onValueChange = { username = it },
                label = { Text("username") },
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
                    .padding(10.dp),
                value = password,
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = { password = it },
                label = { Text("password") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(Res.drawable.iconpassword),
                        contentDescription = "Localized description",
                        Modifier.size(AssistChipDefaults.IconSize)
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) { painterResource(Res.drawable.iconpassword) }
                    Icon(
                        painter = if (passwordVisibility) painterResource(Res.drawable.iconpassshow) else painterResource(Res.drawable.iconpasshidden),
                        contentDescription = "Localized description",
                        Modifier.size(AssistChipDefaults.IconSize),
                    )
                },

            )
        }
    }
}