package com.proud_indian.bottomnav2.presentation.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavItem(
    isSelected: Boolean,
    label: String,
    icon: ImageVector,
    shape: Shape,
    containerColor: Color,
    contentColor: Color,
    enabled: Boolean,
    onItemClick: () -> Unit
) {

    Surface(
        modifier = Modifier.wrapContentSize(),
        color = if (isSelected) containerColor else Color.Transparent,
        contentColor = contentColor,
        shape = shape,
        enabled = enabled,
        onClick = onItemClick
    ) {

        Row(
            modifier = Modifier
                .wrapContentSize()
                .padding(
                    paddingValues = PaddingValues(
                        vertical = 6.dp,
                        horizontal = 12.dp
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
        ) {

            Icon(imageVector = icon, contentDescription = label)

            AnimatedVisibility(
                visible = isSelected
            ) {

                Text(
                    text = label,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}