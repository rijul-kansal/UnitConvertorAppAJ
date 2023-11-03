package com.example.unitconvertorapp

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconvertorapp.ui.theme.UnitConvertorAppTheme
import androidx.compose.material3.Text as Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConvertorAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    unitConvertor()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun unitConvertor()
{
    var inputValue by remember { mutableStateOf("") }
    var inputDropDownExpanded by remember { mutableStateOf(false) }
    var outputDropDownExpanded by remember { mutableStateOf(false) }
    var inputConversionfactor by remember { mutableStateOf(1.0) }
    var outputConversionfactor by remember { mutableStateOf(1.0) }
    var value1 by remember { mutableStateOf("Meters") }
    var value2 by remember { mutableStateOf("Meters") }
    var result by remember {
        mutableStateOf("")
    }
    fun convert()
    {
        var res=(inputValue.toInt()*inputConversionfactor)/outputConversionfactor
        result=res.toString()
    }

   Column(modifier = Modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally) {

       // Intro Text
       Text(text ="Unit Convertor App", modifier = Modifier.padding(8.dp), color = Color.Blue, fontSize = 32.sp, fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)
       // Spaces
       Spacer(modifier = Modifier.height(16.dp))
       // input
       OutlinedTextField(value = inputValue, onValueChange ={
           inputValue=it
       })
       Spacer(modifier = Modifier.height(16.dp))
       Row{
           // input box
           Box {
              Button(onClick = { inputDropDownExpanded=true }) {
                  Text(text = value1)
                  Icon(Icons.Default.ArrowDropDown, contentDescription = "")
              }
               DropdownMenu(expanded = inputDropDownExpanded, onDismissRequest = { inputDropDownExpanded=false }) {
                    DropdownMenuItem(text = { Text(text = "CentiMeters" ) }, onClick = {
                        value1="CentiMeters"
                        inputConversionfactor= 0.01
                        inputDropDownExpanded=false
                    })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        value1="Meters"
                        inputConversionfactor=1.0
                        inputDropDownExpanded=false
                    })
                    DropdownMenuItem(text = { Text(text = "Kilometers") }, onClick = {
                        value1="KiloMeters"
                        inputConversionfactor=1000.0
                        inputDropDownExpanded=false
                    })
                   }
               }
           Spacer(modifier = Modifier.width(16.dp))
           //outputbox
           Box {
               Button(onClick = { outputDropDownExpanded=true }) {
                   Text(text = value2)
                   Icon(Icons.Default.ArrowDropDown, contentDescription = "")
               }
               DropdownMenu(expanded = outputDropDownExpanded, onDismissRequest = { outputDropDownExpanded=false }) {
                   DropdownMenuItem(text = { Text(text = "CentiMeters" ) }, onClick = {
                       value2="CentiMeters"
                       outputConversionfactor=0.01
                       outputDropDownExpanded=false
                   })
                   DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                       value2="Meters"
                       outputConversionfactor=1.0
                       outputDropDownExpanded=false
                   })
                   DropdownMenuItem(text = { Text(text = "KiloMeters") }, onClick = {
                       value2="KiloMeters"
                       outputConversionfactor=1000.0
                       outputDropDownExpanded=false
                   })
               }
           }
       }
       Spacer(modifier = Modifier.height(16.dp))
       Button(onClick = { convert() }) {
           Text(text = "Calculate")
       }
       Spacer(modifier = Modifier.height(16.dp))
       Text(text = result)
   }
}


@Preview(showBackground = true)
@Composable
fun  unitConvertorPreview() {
    unitConvertor()
}