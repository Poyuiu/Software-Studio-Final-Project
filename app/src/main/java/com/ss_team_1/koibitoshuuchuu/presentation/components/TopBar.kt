package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.ui.theme.Secondary

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
    {
        BackButton()
        PauseButton()
    }

}


@Composable
fun TopBar(content: @Composable () -> Unit) {
    androidx.compose.material.Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shape = TopBarShape(),
        color = Secondary,
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            content()
        }
    }

}

class TopBarShape : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            // Draw your custom path here
            path = drawTopBarPath(size = size)
        )
    }
}

private fun drawTopBarPath(size: Size): Path {
    return Path().apply {
        reset()
        // Top left arc
        lineTo(x = size.width, y = 0f)
        // Top right arc
        lineTo(x = size.width, y = size.height)
        // Bottom right arc
        //lineTo(x = 0f, y = size.height)

        cubicTo(
            x1 = 0.664f * size.width,
            y1 = -0.147f * size.height,
            x2 = 0.336f * size.width,
            y2 = -0.147f * size.height,
            x3 = 0f,
            y3 = size.height
        )
        // Bottom left arc
        lineTo(x = 0f, y = 0f)
        close()
    }
}