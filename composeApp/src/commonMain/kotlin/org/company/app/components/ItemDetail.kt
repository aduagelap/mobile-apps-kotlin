package org.company.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import ez_tenant_kotlin.composeapp.generated.resources.Res
import ez_tenant_kotlin.composeapp.generated.resources.iconstar
import moe.tlaster.precompose.navigation.Navigator
import org.jetbrains.compose.resources.painterResource


class ItemDetail {
    @Composable
    fun ItemDetailScreen(navigator: Navigator) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .windowInsetsPadding(WindowInsets.safeDrawing),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                ) {
                    Text(
                        text = "text",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(Color(0xff47b9ff)),
                        style = LocalTextStyle.current.merge(
                            TextStyle(
                                lineHeight = 2.5.em,
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                ),
                                lineHeightStyle = LineHeightStyle(
                                    alignment = LineHeightStyle.Alignment.Center,
                                    trim = LineHeightStyle.Trim.None
                                )
                            )
                        )
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Red),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(0.5f)
                                .background(Color.Cyan)
                        ) {
                            Text(
                                "Item Detail",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .weight(0.5f)
                                .background(Color.Gray)
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.End),
                                painter = painterResource(Res.drawable.iconstar),
                                contentDescription = null
                            )
                        }
                    }
                }

                Button(
                    onClick = { navigator.navigate("/login") },
                    colors = ButtonDefaults.buttonColors(Color(0xff00a2ff)),
                ) {
                    Text("Home")
                }
            }
        }
    }
}