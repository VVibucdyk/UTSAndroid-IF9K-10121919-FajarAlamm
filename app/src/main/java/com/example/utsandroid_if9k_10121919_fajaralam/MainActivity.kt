//NIM : 10121919
//Nama : Fajar Alam
package com.example.utsandroid_if9k_10121919_fajaralam


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.core.graphics.toColorInt
import com.example.utsandroid_if9k_10121919_fajaralam.ui.theme.UTSAndroidIF9K10121919FajarAlamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TitlePengisianData()
        }
    }
}

@Preview(showBackground = true, name = "Title Pengisian Data")
@Composable
fun TitlePengisianData() {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }
    var jenisTes by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var pilihan by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Form Pengisian Data",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color("#FFF9E1".toColorInt()), RoundedCornerShape(16.dp))
        ){
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Info"
                )
                Text(text = "Form berikut ini bertujuan untuk memberikan informasi kepada pusat agar dapat mudah dilaporkan")
            }
        }

        JenisTes("Jenis Tes", listOf("Rapid Antigen", "PCR"), jenisTes, {jenisTes = it})
        TextInput("NIK", text1, {text1 = it})
        TextInput("Nama", text2, {text2 = it})
        TextInput("Tanggal lahir", text3, {text3 = it})
        JenisTes("Gender", listOf("Laki - Laki", "Perempuan"), gender, {gender = it})
        JenisTes("Hubungan Dengan Anda", listOf("Orangtua", "Anak", "Suami/Istri"), pilihan, {pilihan = it})
        TermCondition()
        ButtonPrimary("Selanjutnya", {
            val options = listOf(text1, text2, text3, jenisTes, gender, pilihan)
            val intent = Intent(context, MainActivity2::class.java).apply {
                putStringArrayListExtra("EXTRA_OPTIONS", ArrayList(options))
            }
            context.startActivity(intent)
        })

    }

}

@Composable
fun JenisTes(
    text: String = "Default",
    listPil: List<String> = listOf("Default", "default"),
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Column {
        Text(text = text)
        listPil.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(1.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(text = text)
            }
        }
    }
}

@Composable
fun TextInput(
    label: String = "Default",
    text: String,
    onTextChange: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = label)
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            placeholder = { Text(text = "Masukkan $label") },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview(showBackground = true, name = "Terms Condition")
@Composable
fun TermCondition(label: String = "Dengan ini saya menyetujui bahwa data yang saya isikan adalah benar") {
    var checked by remember { mutableStateOf(true) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
        Text(text = label)
    }
}

@Composable
fun ButtonPrimary(label: String = "Selanjutnya", onClick: () -> Unit) {
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
