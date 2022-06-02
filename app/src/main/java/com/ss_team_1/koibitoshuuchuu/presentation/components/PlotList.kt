package com.ss_team_1.koibitoshuuchuu.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ss_team_1.koibitoshuuchuu.domain.use_case.plot.Plot

@Composable
fun PlotList(
    onClick: () -> Unit,
    plotTitleList: List<Plot>
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .width(344.dp)
            .height(364.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
    )
    {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(13.dp),
            modifier = Modifier
                .width(296.dp)
                .height(316.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = plotTitleList) { item ->
                PlotButton(
                    modifier = Modifier.align(Alignment.Center),
                    onClick = onClick,
                    lock = item.lock,
                    haveRead = item.haveRead,
                    id = plotTitleList.indexOf(item) + 1,
                    title = item.title
                )
            }
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun PlotListPreview() {
    PlotList(
        onClick = {},
        plotTitleList =
        listOf(
            Plot("第一個故事", false, true),
            Plot("不是第二個故事", false, true),
            Plot("可能是第三個故事", false, true),
            Plot("跳過第四個故事", false, true),
            Plot("懶得寫第五個故事", false),
            Plot("沒有第六個故事", false),
            Plot("不是最後一個故事"),
            Plot("是最後一個故事"),
        )
    )
}