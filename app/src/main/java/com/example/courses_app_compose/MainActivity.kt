package com.example.courses_app_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses_app_compose.data.DataSource
import com.example.courses_app_compose.model.Topic
import com.example.courses_app_compose.ui.theme.Courses_App_ComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Courses_App_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopicGrid()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun TopicCard(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(10)
    ) {
        Row {
            Box {
                Image(
                    painter = painterResource(topic.imageRes),
                    contentDescription = stringResource(topic.name),
                    modifier = Modifier
                        .size(height = 68.dp, width = 68.dp)
                        .height(194.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Column {
                Text(
                    text = stringResource(topic.name),
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 16.dp,
                            bottom = 8.dp
                        ),
                    style = MaterialTheme.typography.h6
                )

                Row {
                    Icon(painter = painterResource(R.drawable.ic_grain), contentDescription = null)

                    Text(
                        text = stringResource(topic.availableCourse),
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        }
    }
}

@Composable
fun TopicGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(DataSource.topics) { topic ->
            TopicCard(topic)
        }
    }
}

@Preview
@Composable
fun TopicPreview(){
    Courses_App_ComposeTheme {
        val topic = Topic(R.string.crafts,313,R.drawable.ic_grain)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopicCard(topic = topic)
        }

    }
}