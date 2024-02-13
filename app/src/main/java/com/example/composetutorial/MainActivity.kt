package com.example.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme { // To use the material theme created for this project
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(Message(author = "Android", body = "Jetpack Compose"))
                }
            }
        }
    }

    @Composable
    fun MessageCard(message: Message) {
        /**
         * @Column organize elements vertically
         * @Row organize elements horizontally
         * @Box organize elements by stack
         * @modifier can change the size, appearance, design and add interactions like click listeners
         */
        Row(modifier = Modifier.padding(all = 8.dp)) {

            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    .size(40.dp) // Set image size to 40dp
                    .clip(CircleShape) // Clip image to be shaped as a circle
                    .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
                )
            // Add horizontal space betwen the image and the column
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = message.author,
                    // Change the default color for the secondary variant in the theme
                    color = MaterialTheme.colorScheme.secondary,
                    // Change the typography)
                    style = MaterialTheme.typography.headlineSmall
                )
                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(4.dp))
                // Add a shape using Surface
                Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                    Text(
                        text = message.body,
                        modifier = Modifier.padding(all = 4.dp), // padding around the text
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

            }
        }

    }

    @Preview(name = "Light mode") // Show the preview in light mode
    @Preview( // Show the preview in dark mode
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark mode"
    )
    @Composable
    fun PreviewMessageCard() {
        ComposeTutorialTheme {
            Surface {
                MessageCard(Message(author = "Colleague", body = "Hey, take a look at Jetpack Compose, it's great!"))
            }
        }
    }


}

// Data class that contains the title and description
data class Message(val author: String, val body: String)