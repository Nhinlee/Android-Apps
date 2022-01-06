package com.nhinlechi.nhin_music_app.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nhinlechi.nhin_music_app.R
import com.nhinlechi.nhin_music_app.ui.general.Space

@Composable
fun HitPlayListItem(imageUrl: String = "", label: String = "") {
    Row(
        Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(shape = RoundedCornerShape(4.dp)),
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
        )
        Row(
            Modifier
                .background(MaterialTheme.colors.primary)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Space(width = 8F)
            Text(
                label,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
            )
        }
    }
}

@Preview
@Composable
fun HitPlayListItemPreview() {
    HitPlayListItem(label = "2022 hit songs preview")
}