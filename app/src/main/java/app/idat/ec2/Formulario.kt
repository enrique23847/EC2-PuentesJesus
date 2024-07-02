package app.idat.ec2

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.text.BasicTextField
@Composable
fun CuestionarioScreen(onBackPressed: () -> Unit) {
    var selectedSkills by remember { mutableStateOf(setOf<String>()) }
    var significance by remember { mutableStateOf("") }
    var payment by remember { mutableStateOf("") }
    var pressure by remember { mutableStateOf(false) }
    var growth by remember { mutableStateOf(false) }

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        item {
            Text("CUESTIONARIO", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))
            Text("1. Marque sus habilidades:")
        }

        items(listOf("Autoconocimiento", "Empatía", "Comunicación asertiva", "Toma de decisiones", "Pensamiento crítico", "Ninguno")) { skill ->
            Row {
                Checkbox(
                    checked = selectedSkills.contains(skill),
                    onCheckedChange = {
                        selectedSkills = if (it) selectedSkills + skill else selectedSkills - skill
                    }
                )
                Text(skill)
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            Text("2. ¿Cuán significativa es tu trabajo?")
        }

        items(listOf("Mucho", "Más o menos", "Poco")) { option ->
            Row {
                RadioButton(
                    selected = significance == option,
                    onClick = { significance = option }
                )
                Text(option)
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            Text("3. ¿Qué tan bien te pagan en el trabajo que haces?")
        }

        items(listOf("Bien", "Regular", "Mal")) { option ->
            Row {
                RadioButton(
                    selected = payment == option,
                    onClick = { payment = option }
                )
                Text(option)
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            Text("4. ¿Trabajas bajo presión?")
            Row {
                RadioButton(
                    selected = pressure,
                    onClick = { pressure = true }
                )
                Text("SI")
                Spacer(modifier = Modifier.width(16.dp))
                RadioButton(
                    selected = !pressure,
                    onClick = { pressure = false }
                )
                Text("NO")
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            Text("5. ¿Tienes oportunidad de crecimiento en tu trabajo?")
            Row {
                RadioButton(
                    selected = growth,
                    onClick = { growth = true }
                )
                Text("SI")
                Spacer(modifier = Modifier.width(16.dp))
                RadioButton(
                    selected = !growth,
                    onClick = { growth = false }
                )
                Text("NO")
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            Button(onClick = onBackPressed, modifier = Modifier.padding(top = 16.dp)) {
                Text("Resolver")
            }
        }
    }
}