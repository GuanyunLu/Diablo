package eo.diablo.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import eo.diablo.R
import eo.diablo.ui.components.drawArms
import eo.diablo.ui.components.drawBident
import eo.diablo.ui.components.drawFront
import eo.diablo.ui.components.drawHead
import eo.diablo.ui.components.drawHip
import eo.diablo.ui.components.drawLegs
import eo.diablo.ui.theme.DiabloTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Diablo() {
    val bidentImg = ImageBitmap.imageResource(id = R.drawable.kotlin_full_color_logo_mark_rgb)
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.Black, Color.DarkGray, Color.LightGray, Color.Transparent
                    )
                )
            ), contentDescription = "An Android devil holding a Kotlin bident"
    ) {
        drawBident(bidentImg)
        drawArms()
        drawFront()
        drawLegs()
        drawHip()
        drawHead()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiabloTheme {
        Diablo()
    }
}