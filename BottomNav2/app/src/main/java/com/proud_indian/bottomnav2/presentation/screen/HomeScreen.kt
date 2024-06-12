package com.proud_indian.bottomnav2.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.proud_indian.bottomnav2.R
import com.proud_indian.bottomnav2.presentation.activities.home.MainViewModel
import com.proud_indian.bottomnav2.presentation.theme.BottomNav2Theme
import com.proud_indian.bottomnav2.presentation.theme.GreenJC

@Composable
fun HomeScreen(mainViewModel: MainViewModel) {
    Box(modifier = Modifier.fillMaxSize()){
        Dashboard()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(modifier: Modifier = Modifier) {
    Column(
        Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout {
            val (redBorder) = createRefs()
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .constrainAs(redBorder) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .background(GreenJC)
            )
            Row (
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 24.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Column (
                    modifier = Modifier
                        .height(60.dp)
                        .padding(start = 8.dp)
                        .weight(0.7f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ){
                    Text(text = "Hi Ranga",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                }
                Image(painter = painterResource(id = R.drawable.profile_white), contentDescription = null,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .clickable { }
                )
            }
        }
        var searchText by rememberSaveable {
            mutableStateOf("")
        }

        var showClearIcon = true

        TextField(
            value = searchText,
            onValueChange = { onQueryChanged ->
                searchText = onQueryChanged
                if (onQueryChanged.isNotEmpty()) {
                    // Perform search
                }
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    tint = MaterialTheme.colorScheme.background,
                    contentDescription = "Search icon"
                )
            },
            trailingIcon = {
                if (showClearIcon) {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Rounded.Clear,
                            tint = MaterialTheme.colorScheme.onBackground,
                            contentDescription = "Clear icon"
                        )
                    }
                }
            },
            maxLines = 1,
            colors = TextFieldDefaults.colors(
                focusedPlaceholderColor = Color.Transparent,
                unfocusedLabelColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent),
            placeholder = { Text(text = "Search Todo") },
            textStyle = MaterialTheme.typography.titleMedium,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, end = 12.dp, start = 12.dp)
                .shadow(3.dp, shape = RoundedCornerShape(50.dp))
                .background(color = MaterialTheme.colorScheme.background, shape = RectangleShape)
        )

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, end = 24.dp, start = 24.dp)
                .shadow(5.dp, shape = RoundedCornerShape(25.dp))
                .height(150.dp)
                .background(color = GreenJC)
        ) {
            val (bannerImage, flatText, freeText, couponText) = createRefs()

            Image(
                modifier = Modifier.constrainAs(bannerImage)
                { 
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
            }, painter = painterResource(id = R.drawable.todo_icon),
                contentDescription = null)
            Text(text = "FLAT 50% OFF",
                fontSize = 28.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .constrainAs(flatText) {
                        top.linkTo(parent.top)
                        end.linkTo(bannerImage.start)
                        start.linkTo(parent.start)
                    }
            )
            Text(text = "Free Deliver + 10% Cashback",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.constrainAs(freeText){
                    top.linkTo(flatText.bottom)
                    end.linkTo(flatText.end)
                    start.linkTo(flatText.start)
                })
            Text(text = "Coupon: FOOD50",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .constrainAs(couponText) {
                        top.linkTo(freeText.bottom)
                        end.linkTo(freeText.end)
                        start.linkTo(freeText.start)
                    })
        }
        Text(text = "CATEGORIES",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 16.dp))

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp))
        {
            Column (modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.settings), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp))
                Text(text = "Settings",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black)
            }

            Column (modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.settings), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp))
                Text(text = "Settings",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black)
            }

            Column (modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.settings), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp))
                Text(text = "Settings",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black)
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp))
        {
            Column (modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.settings), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp))
                Text(text = "Settings",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black)
            }

            Column (modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.settings), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp))
                Text(text = "Settings",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black)
            }

            Column (modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.settings), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp))
                Text(text = "Settings",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black)
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp))
        {
            Column (modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.settings), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp))
                Text(text = "Settings",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black)
            }

            Column (modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.settings), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp))
                Text(text = "Settings",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black)
            }

            Column (modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.settings), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp))
                Text(text = "Settings",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black)
            }
        }
    }
}