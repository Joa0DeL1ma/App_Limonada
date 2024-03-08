package com.example.limonada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.limonada.ui.theme.LimonadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimonadaTheme {
                LimonadaPreview()
            }
        }
    }
}

@Composable
fun LimonadaApp() {
    var atual by remember { mutableIntStateOf(1) }
    var contagem by remember { mutableIntStateOf(1) }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        //horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .size(64.dp)
                .background(Color(color = 0xFFF9E44C))
                .wrapContentSize(Alignment.Center),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            text = stringResource(R.string.limonada)
        )
        Column{
            when (atual) {
                1 -> {
                    LimonadaComBotaoImagemTexto(
                        textId = R.string.step1,
                        imageId = R.drawable.lemon_tree,
                        contentDescriptionId = R.string.tree_description,
                        onImageClick =
                        {
                            atual = 2
                        }
                    )
                }

                2 -> {
                    LimonadaComBotaoImagemTexto(
                        textId = R.string.step2,
                        imageId = R.drawable.lemon_squeeze,
                        contentDescriptionId = R.string.lemon_description,
                        onImageClick =
                        {
                            atual = 2
                            contagem = (1..4).random()
                            if (contagem==4)
                            {
                                atual = 3
                            }
                        }
                    )
                }

                3 -> {
                    LimonadaComBotaoImagemTexto(
                        textId = R.string.step3,
                        imageId = R.drawable.lemon_drink,
                        contentDescriptionId = R.string.drink_description,
                        onImageClick =
                        {
                            atual = 4
                        }
                    )
                }

                4 -> {
                    LimonadaComBotaoImagemTexto(
                        textId = R.string.step4,
                        imageId = R.drawable.lemon_restart,
                        contentDescriptionId = R.string.tree_description,
                        onImageClick =
                        {
                            atual = 1
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LimonadaComBotaoImagemTexto(
    textId: Int,
    imageId: Int,
    contentDescriptionId: Int,
    onImageClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    )
    {
        Button(onClick = onImageClick) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = stringResource(id = contentDescriptionId)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = stringResource(id = textId))
    }

}


@Preview(showBackground = true)
@Composable
fun LimonadaPreview() {
    LimonadaTheme {
        LimonadaApp()
    }
}