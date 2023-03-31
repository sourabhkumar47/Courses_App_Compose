package com.example.courses_app_compose

import android.content.ClipData.Item
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    Greeting("Android")
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
            Box{
                Image(
                    painter = painterResource(topic.imageRes),
                    contentDescription = stringResource(topic.name),
                    modifier = Modifier
                        .height(194.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Column {
                Text(
                    text = stringResource(topic.name),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.h6
                )

                Row {
                    Icon(painter = painterResource(R.drawable.ic_grain), contentDescription = null )

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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Courses_App_ComposeTheme {
        Greeting("Android")
    }
}