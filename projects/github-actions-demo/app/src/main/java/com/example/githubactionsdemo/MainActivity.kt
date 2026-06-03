package com.example.githubactionsdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.githubactionsdemo.ui.theme.GithubActionsDemoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            GithubActionsDemoTheme(darkTheme = false) {

                MainScreen()

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text(text = "GitHub Actions Demo")

                },
                colors = TopAppBarDefaults.topAppBarColors(

                    containerColor = Color(0xFF6F52B5),
                    titleContentColor = Color.White

                )
            )
        }

    ) { innerPadding ->

        Box(

            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),

            contentAlignment = Alignment.Center

        ) {

            Column {
                Text(
                    text = "Hello ${BuildConfig.ENVIRONMENT}!"
                )
                Text(
                    text = "URL: ${BuildConfig.BASE_URL}"
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {

    GithubActionsDemoTheme(darkTheme = false) {

        MainScreen()

    }
}