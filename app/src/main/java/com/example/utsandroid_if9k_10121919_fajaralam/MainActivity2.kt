package com.example.utsandroid_if9k_10121919_fajaralam

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.utsandroid_if9k_10121919_fajaralam.ui.theme.UTSAndroidIF9K10121919FajarAlamTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val options = intent.getStringArrayListExtra("EXTRA_OPTIONS") ?: arrayListOf()

            CekData(options)
        }
    }
}
@Composable
fun CekData(labels: List<String>) {
    val context = LocalContext.current
    Column(

        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .fillMaxHeight()
    ) {
        Text(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            text = "Cek Kembali Isian Data",
        )

        Spacer(modifier = Modifier.weight(1f))

        Column(

            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            labels.forEach { label ->
                ListData(label = label)
            }
            HasilTes(onClick = {
                val intent = Intent(context, MainActivity3::class.java)
                context.startActivity(intent)
            })
            UbahButton(onClick = {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            })
        }
    }
}

@Preview(showBackground = true, name = "List Data")
@Composable
fun ListData(text:String = "default", label:String = "default") {
    Column(

        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            text = text
        )
        Text(
            text = label,
            fontSize = 14.sp,
        )

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(color = Color.Black)
        )

    }
}

@Composable
fun HasilTes(label: String = "Cek Hasil Tes", onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color("#16A75C".toColorInt()),
            contentColor = Color.White
        ),
        onClick = onClick
    ) {
        Text(text = label)
    }
}

@Composable
fun UbahButton(label: String = "Ubah", onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color("#757575".toColorInt())),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color("#FFFFFF".toColorInt()),
            contentColor = Color("#757575".toColorInt())
        ),
        onClick = onClick
    ) {
        Text(text = label)
    }
}

