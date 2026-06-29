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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import android.content.Context
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.my_app.ui.theme.My_appTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.util.fastCbrt

//modifier changes how the composable looks or behave
//composable are functions that builds UI in jetpack compose
//composable functions cant be called through button onClick function
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        DiaryScreen()

        }

    }
}

@Composable
fun DiaryScreen() {
    @Composable
    fun DiaryScreen() {

        var showCreate by remember { mutableStateOf(false) }
        var showView by remember { mutableStateOf(true) }

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        showCreate = true
                        showView = false
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Entry"
                    )
                }
            }
        ) { padding ->

            Column(
                modifier = Modifier.padding(padding)
            ) {

                if (showView) {
                    View()
                }

                if (showCreate) {
                    Create()
                }

            }
        }
    }
        val context = LocalContext.current
        Button(
            onClick = {

                context.deleteFile("diary.txt")
            }
        ) {
            Text("Delete All Entries")
        }

    }
}


@Composable
fun View(){
    val context = LocalContext.current
    var diaryContent by remember{
        mutableStateOf("")
    }
    LaunchedEffect(Unit) { diaryContent = try { context.openFileInput("diary.txt") .bufferedReader() .readText() } catch (e: Exception) { "" } }
    if(diaryContent.isEmpty())
        Text("empty")
    else{
    Text(diaryContent)}
}

@Composable
fun Create() {
    // adds a TextField
    val context = LocalContext.current //gives access to the resources of android such as database files

    var entryText by remember { //a variable that stores the text entered by the user
        //remember remembers the value from previous UI updates (recompositions) instead of creating a fresh empty value every time.
        mutableStateOf("")  //creates a state object, initial value is an empty string, when the value isnt empty string or when the value changes ui is automatically updated

    }
    Column {
        TextField( ///a component that allows user to type text
            value = entryText,  //the text is displayed from the textfield in which the value is got by the entryText
            onValueChange = { //runs everytime the value is added or deleted
                entryText = it //stores whatever the user have typed
            })
  ///save button
        //after writing the entry, when clicked on the button the entry is saved in "diary.txt", the text box is emptied for new journal entry
        Button(
            onClick = {
                context.openFileOutput("diary.txt", Context.MODE_APPEND).use { outputStream -> //.use opens and close file automatically  
                    //outputStream is the connection to the file
                    outputStream.write((entryText + "\n").toByteArray()) //data flows from entryText -> toByteArray()->outputStream->diary.txt
                }
             entryText ="" //clears the text field
            }) {
            Text("Save")
        }

    }
}


///basically to preview only on the desktop
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    My_appTheme {
//        Greeting("Kotlin")
//    }
//}
