package com.example.my_app
import coil.compose.AsyncImage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.my_app.ui.theme.My_appTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text

//modifier changes how the composable looks or behave
//composable are functions that builds UI in jetpack compose
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            My_appTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Column {
                       // Add_Image()
                   
                        Box {
                            AsyncImage(
                                model = "https://mlo1wbhvgmgt.i.optimole.com/w:1536/h:864/q:mauto/g:sm/f:best/https://pethero.co.za/wp-content/uploads/2026/02/Indoor-Cats-Blog-Banner.png",
                                contentDescription = "cat", modifier = Modifier.size(2uu00.dp)
                            )
                            Column {
                                Text("This is an online image")
                            }
                        }

//                                Greeting(
//                                    name = "Reshma",
//                                    modifier = Modifier.padding(innerPadding)
                    //}
                }
            }
        }

//                    Greeting(name="lala",
//                        modifier = Modifier.padding(paddingValues = innerPadding))
//                    Multiline(name="rosa",
//                        modifier = Modifier.padding(paddingValues = innerPadding))
    }
}






@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "This is $name",
            modifier = modifier ///first modifier is the type and the next modifier is the value that means there exists no modification
        )
        Row {
            Text(
                text = "This is $name \t",
                modifier = modifier)
            Text( text = "This is rr",
                modifier = modifier
            )

        }
        Row{
            Text(
                text = "\t\t this is lala",
                modifier = modifier
            )
        }
    }
}
@Composable
fun Multiline(name: String, modifier: Modifier = Modifier) {
    Column{
    Text(
        text = "This is $name",
        modifier = modifier
    )

    Text(
        text = "This is rr",
        modifier = modifier.background(Color.Cyan)
    )
    }
}

@Composable
fun Add_Image() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "This is a computerr",

        )
        Text(text= "this is computer")

        Image(
            painter = painterResource(id = R.drawable.butterfly),
            contentDescription = "This is a butterfly",

        )
        Text(text= "this is butterfly")
    }
}


///basically to preview only on the desktop
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    My_appTheme {
        Greeting("Kotlin")
    }
}