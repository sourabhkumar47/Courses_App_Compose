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
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    TopicGrid()
                }
            }
        }
    }
}

@Composable
fun TopicCard(
    topic: Topic, modifier: Modifier = Modifier
) {
    Card(
        elevation = 4.dp, shape = RoundedCornerShape(10)
    ) {
        Row {
            Box {
                Image(
                    painter = painterResource(topic.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(height = 68.dp, width = 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }

            Column {
                Text(
                    text = stringResource(id = topic.name), modifier = Modifier.padding(
                        start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp
                    ), style = MaterialTheme.typography.body2
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Text(
                        text = topic.availableCourse.toString(),
                        modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.caption
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
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        items(DataSource.topics) { topic ->
            TopicCard(topic)
        }
    }
}

@Preview
@Composable
fun TopicPreview() {
    Courses_App_ComposeTheme {
        val topic = Topic(R.string.photography, 321, R.drawable.photography)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopicCard(topic = topic)
        }
    }
}
