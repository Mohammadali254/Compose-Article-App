package com.example.compasablearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compasablearticle.ui.theme.CompasableArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompasableArticleTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                  ComposableArticle()
                }
                }
            }
        }
    }



@Composable
// Composable function that calls the Article card
fun ComposableArticle(){
    ArticleCard(
        title = stringResource(R.string.jetpack_compose_tutorial),
        shortDescription = stringResource(R.string.short_description),
        longDescription = stringResource(R.string.long_description),
        imagePainter = painterResource(R.drawable.bg_compose_background)
    )


}

@Composable
// composable function to define the layout
private fun ArticleCard(
    title: String,
    shortDescription : String,
    longDescription : String,
    imagePainter: Painter,
    modifier: Modifier =Modifier,
    ){
    Column(modifier = modifier) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier.statusBarsPadding() // automatically adds padding around status bar

        )

        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )

        Text(
            text = shortDescription,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = longDescription,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposableArticlePreview() {
    CompasableArticleTheme {
       ComposableArticle()
    }
}