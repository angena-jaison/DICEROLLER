package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroller.R.*
import com.example.diceroller.R.drawable.*
import com.example.diceroller.ui.theme.DICEROLLERTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DICEROLLERTheme {


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DICEROLLER(){
    DICEROLLERWithImageAndButton(modifier= Modifier.fillMaxSize().wrapContentSize(align= Alignment.Center)
    )

}
@Composable
fun DICEROLLERWithImageAndButton(modifier:Modifier=Modifier) {
    var result by remember {
        mutableStateOf(1)
    }
    val imageOfDice = when(result){
        1 -> {
            diceimg1
        }
        2 -> {
            diceimg2
        }
        3 -> diceimg3
        4 -> {
            diceimg4
        }
        5 -> {
            diceimg5
        }
        else -> {
            diceimg6
        }


    }
    Column(
        horizontalAlignment=Alignment.CenterHorizontally,
        modifier=modifier
        ){
        Image(painter = painterResource(id = imageOfDice), contentDescription= null)
        Button(onClick = {
            result = (1..6).random()
        }) {
            Text(text="Roll")
        }
    }
}


