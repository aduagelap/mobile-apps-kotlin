package org.company.app.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import ez_tenant_kotlin.composeapp.generated.resources.IndieFlower_Regular
import ez_tenant_kotlin.composeapp.generated.resources.Res
import ez_tenant_kotlin.composeapp.generated.resources.cyclone
import ez_tenant_kotlin.composeapp.generated.resources.ic_cyclone
import ez_tenant_kotlin.composeapp.generated.resources.ic_dark_mode
import ez_tenant_kotlin.composeapp.generated.resources.ic_light_mode
import ez_tenant_kotlin.composeapp.generated.resources.ic_rotate_right
import ez_tenant_kotlin.composeapp.generated.resources.open_github
import ez_tenant_kotlin.composeapp.generated.resources.run
import ez_tenant_kotlin.composeapp.generated.resources.stop
import ez_tenant_kotlin.composeapp.generated.resources.theme
import ez_tenant_kotlin.composeapp.generated.resources.theme2
import kotlinx.coroutines.isActive
import org.company.app.theme.LocalThemeIsDark
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

class Default {
    @Composable
    fun homeScreen(){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeDrawing)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(Res.string.cyclone),
            )

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
                    .padding(16.dp)
                    .run { rotate(rotate.value) },
                imageVector = vectorResource(Res.drawable.ic_cyclone),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                contentDescription = null
            )

            ElevatedButton(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .widthIn(min = 200.dp),
                onClick = { isRotating = !isRotating },
                content = {
                    Icon(vectorResource(Res.drawable.ic_rotate_right), contentDescription = null)
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text(
                        stringResource(if (isRotating) Res.string.stop else Res.string.run)
                    )
                }
            )

            var isDark by LocalThemeIsDark.current
            println(isDark)
            val icon = remember(isDark) {
                if (isDark) Res.drawable.ic_light_mode
                else Res.drawable.ic_dark_mode
            }

            ElevatedButton(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).widthIn(min = 200.dp),
                onClick = { isDark = !isDark },
                content = {
                    Icon(vectorResource(icon), contentDescription = null)
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text(stringResource(Res.string.theme2))
                }
            )

            val uriHandler = LocalUriHandler.current
            TextButton(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).widthIn(min = 200.dp),
                onClick = { println("clicked") },
            ) {
                Text(stringResource(Res.string.open_github))
            }
        }
    }
}