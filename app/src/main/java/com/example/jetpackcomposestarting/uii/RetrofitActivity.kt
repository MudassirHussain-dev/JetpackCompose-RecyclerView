package com.example.jetpackcomposestarting.uii

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposestarting.data.retrofit.Post
import com.example.jetpackcomposestarting.data.retrofit.state.ApiState
import com.example.jetpackcomposestarting.data.retrofit.viewmodel.MainViewModel
import com.example.jetpackcomposestarting.ui.theme.JetPackComposeStartingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RetrofitActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeStartingTheme {
                Surface(color = MaterialTheme.colors.background) {
                    GetData(mainViewModel = mainViewModel)
                }

            }
        }
    }

    @Composable
    fun EachRow(post: Post) {
        Card(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp).fillMaxWidth(),
            elevation = 2.dp, shape = RoundedCornerShape(4.dp)
        ) {
            Text(
                text = post.body,
                modifier = Modifier.padding(10.dp).fillMaxWidth(),
                fontStyle = FontStyle.Italic
            )
        }
    }

    @Composable
    fun GetData(mainViewModel: MainViewModel) {
        when (val result = mainViewModel.response.value) {
            is ApiState.Success-> {
                LazyColumn{
                    items(result.data) { it ->
                        EachRow(post = it)

                    }
                }
            }
            is ApiState.Failure -> {
                Text(text = "${result.msg}")
            }
            is ApiState.Loading -> {
                CircularProgressIndicator()
            }
            is ApiState.Empty -> {
            }
        }
    }
}

