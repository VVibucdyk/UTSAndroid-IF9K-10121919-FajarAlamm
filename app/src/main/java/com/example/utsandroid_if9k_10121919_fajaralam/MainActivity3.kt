package com.example.utsandroid_if9k_10121919_fajaralam

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.utsandroid_if9k_10121919_fajaralam.ui.theme.UTSAndroidIF9K10121919FajarAlamTheme

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BerhasilDisimpan()
        }
    }
}

@Preview(showBackground = true, name = "Berhasil Disimpan")
@Composable
fun BerhasilDisimpan(text:String = "Terima kasih, laporan Anda membantu kami dalam melakukan penanganan kasus secara tepat.", description:String = "Berhasil Disimpan") {
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .padding(32.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.berhasil),
            contentDescription = "My Image",
            modifier = Modifier,
            contentScale = ContentScale.Crop
        )
        Text(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            text = description
        )
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
        )

        ButtonOk("Ok")

    }
}


@Preview(showBackground = true, name = "Button OK")
@Composable
fun ButtonOk(label: String = "Selanjutnya") {
    val context = LocalContext.current
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color("#16A75C".toColorInt()),
            contentColor = Color.White
        ),
        onClick = {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    ) {
        Text(text = label)
    }
}