package eo.diablo.ui.components

import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round
import eo.diablo.ui.theme.KotlinPurple
import eo.diablo.ui.theme.KotlinPurpleBlue
import eo.diablo.ui.theme.KotlinRose

internal fun DrawScope.drawHead() {
    val leftHorn = Path().apply {
        moveTo(center.x, center.y + 50.dp.toPx())
        lineTo(center.x, center.y)
        lineTo(center.x + 25.dp.toPx(), center.y + 50.dp.toPx())
        close()
    }
    drawPath(
        path = leftHorn, brush = Brush.linearGradient(
            colors = listOf(Color.DarkGray, Color.Red, Color.LightGray),
            start = center.plus(Offset(25.dp.toPx(), 50.dp.toPx())),
            end = center.plus(Offset(0F, 50.dp.toPx()))
        )
    )
    val rightHorn = Path().apply {
        moveTo(center.x + 92.dp.toPx(), center.y + 50.dp.toPx())
        lineTo(center.x + 92.dp.toPx(), center.y)
        lineTo(center.x + 67.dp.toPx(), center.y + 50.dp.toPx())
        close()
    }
    drawPath(
        path = rightHorn, brush = Brush.linearGradient(
            colors = listOf(Color.Black, Color.DarkGray, Color.Red),
            start = center.plus(Offset(67.dp.toPx(), 50.dp.toPx())),
            end = center.plus(Offset(92.dp.toPx(), 50.dp.toPx()))
        )
    )
    drawArc(
        brush = Brush.sweepGradient(listOf(Color.Red, Color.Black, Color.Red)),
        startAngle = -180F,
        sweepAngle = 180F,
        topLeft = center.plus(Offset(-50F, 80F)),
        size = Size(400F, 400F),
        useCenter = true
    )
    drawOval(
        color = Color.DarkGray, topLeft = center.plus(Offset(50F, 200F)), size = Size(50F, 30F)
    )
    drawCircle(
        color = Color.Yellow, radius = 15f, center = center.plus(Offset(75F, 215F))
    )
    drawOval(
        color = Color.DarkGray, topLeft = center.plus(Offset(150F, 200F)), size = Size(50F, 30F)
    )
    drawCircle(
        color = Color.Yellow, radius = 15f, center = center.plus(Offset(175F, 215F))
    )
}

internal fun DrawScope.drawHip() {
    drawRoundRect(
        brush = Brush.linearGradient(listOf(Color.Black, Color.Red)),
        topLeft = center.plus(Offset(-50F, 800F)),
        size = Size(400F, 100F),
        cornerRadius = CornerRadius(100F, 50F)
    )
}

internal fun DrawScope.drawLegs() {
    drawRoundRect(
        brush = Brush.linearGradient(listOf(Color.Transparent, Color.Red)),
        topLeft = center.plus(Offset(25F, 830F)),
        size = Size(100F, 300F),
        cornerRadius = CornerRadius(50F, 50F)
    )
    drawRoundRect(
        brush = Brush.linearGradient(listOf(Color.Transparent, Color.Red)),
        topLeft = center.plus(Offset(150F, 830F)),
        size = Size(100F, 300F),
        cornerRadius = CornerRadius(50F, 50F)
    )
}

internal fun DrawScope.drawFront() {
    drawRoundRect(
        brush = Brush.sweepGradient(listOf(Color.Red, Color.Black, Color.Red)),
        topLeft = center.plus(Offset(-50F, 300F)),
        size = Size(400F, 575F),
        cornerRadius = CornerRadius(30F, 30F)
    )
}

internal fun DrawScope.drawArms() {
    drawRoundRect(
        brush = Brush.linearGradient(listOf(Color.Red, Color.DarkGray, Color.Red)),
        topLeft = center.plus(Offset(-200F, 300F)),
        size = Size(100F, 500F),
        cornerRadius = CornerRadius(50F, 50F)
    )
    drawRoundRect(
        brush = Brush.linearGradient(listOf(Color.Red, Color.DarkGray, Color.Red)),
        topLeft = center.plus(Offset(400F, 300F)),
        size = Size(100F, 500F),
        cornerRadius = CornerRadius(50F, 50F)
    )
}

internal fun DrawScope.drawBident(bidentImg: ImageBitmap) {
    val bidentHandleLength = 150.dp.toPx()
    val bidentHandleStart = center.plus(Offset(-112.dp.toPx(), -143.dp.toPx()))
    val bidentHandleEnd = bidentHandleStart.plus(Offset(0F, bidentHandleLength))
    val degrees = -90F


    translate(top = 190.dp.toPx(), left = 45.dp.toPx()) {
        rotate(degrees) {
            drawImage(
                image = bidentImg,
                dstOffset = center.round().plus(IntOffset(bidentImg.width, -bidentImg.height)),
                dstSize = IntSize(60.dp.toPx().toInt(), 60.dp.toPx().toInt()),
                filterQuality = FilterQuality.High,
                blendMode = BlendMode.Darken
            )
        }
        drawLine(
            brush = Brush.verticalGradient(listOf(KotlinRose, KotlinPurple, KotlinPurpleBlue)),
            start = bidentHandleStart,
            end = bidentHandleEnd,
            strokeWidth = 4.dp.toPx()
        )
        drawPoints(
            points = listOf(
                bidentHandleEnd, bidentHandleEnd.copy(
                    x = bidentHandleEnd.x + 8.dp.toPx(), y = bidentHandleEnd.y + 12.dp.toPx()
                ), bidentHandleEnd.copy(y = bidentHandleEnd.y + 24.dp.toPx()), bidentHandleEnd.copy(
                    x = bidentHandleEnd.x - 8.dp.toPx(), y = bidentHandleEnd.y + 12.dp.toPx()
                ), bidentHandleEnd
            ),
            strokeWidth = 4.dp.toPx(),
            pointMode = PointMode.Polygon,
            brush = Brush.radialGradient(
                colors = listOf(KotlinRose, KotlinPurple, KotlinPurpleBlue),
                center = bidentHandleEnd.plus(
                    Offset(0F, 12.dp.toPx())
                )
            )
        )
    }
}