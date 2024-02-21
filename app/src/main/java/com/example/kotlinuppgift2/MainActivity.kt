package com.example.kotlinuppgift2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinuppgift2.ui.theme.KotlinUppgift2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinUppgift2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListScreen()
                }
            }
        }
    }
}

@Composable
fun ListScreen() {
    val listItems = remember {
        mutableStateListOf<String>()
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
            .padding(horizontal = 10.dp, vertical = 8.dp)
        ) {
            Spacer(modifier = Modifier.padding(horizontal = 20.dp))

            Button(onClick = { listItems.add("X") }, modifier = Modifier.weight(1f)) {
                Text("X")

            }

            Spacer(modifier = Modifier.padding(horizontal = 10.dp))

            Button(onClick = { listItems.add("Y") }, modifier = Modifier.weight(1f)) {
                Text("Y")


            }

            Spacer(modifier = Modifier.padding(horizontal = 20.dp))

            }

            LazyColumn {
                items(listItems.size) { index ->
                    ListRow(text = listItems[index])
            }
        }

            Button(
                onClick = { listItems.clear() },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
        ) {
                Text("Reset")
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinUppgift2Theme {
        ListScreen()
    }
}