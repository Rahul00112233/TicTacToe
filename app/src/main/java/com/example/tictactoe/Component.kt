package com.example.tictactoe

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoardBase(){
    Canvas(modifier = Modifier
        .size(350.dp)
        .padding(10.dp)
    ) {
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*1/3, y = 0f),
            end = Offset(x = size.width*1/3, y = size.height)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*2/3, y = 0f),
            end = Offset(x = size.width*2/3, y = size.height)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height*1/3),
            end = Offset(x = size.width, y = size.height*1/3)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height*2/3),
            end = Offset(x = size.width, y = size.height*2/3)
        )
    }
}

@Composable
fun Cross(){
    Canvas(
        modifier = Modifier
            .size(80.dp)
            .padding(10.dp)
    ) {
        drawLine(
            color = Color.Cyan,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = size.height)
        )
        drawLine(
            color = Color.Cyan,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width, y = 0f),
            end = Offset(x = 0f, y = size.height)
        )

    }
}

@Composable
fun Circle(){
    Canvas(
        modifier = Modifier
            .size(80.dp)
            .padding(10.dp)
    ) {
        drawCircle(
            color = Color.Cyan,
            style = Stroke(width = 20f)
        )
    }
}

@Composable
fun winVerticalLine1(){
    Canvas(modifier = Modifier
        .size(350.dp)
        .padding(all = 5.dp)) {
        drawLine(
            start = Offset(x = size.width*1/6, y = 0f),
            end = Offset(x = size.width*1/6, y = size.height),
            color = Color.Red,
            cap = StrokeCap.Round,
            strokeWidth = 10f
        )
    }
}

@Composable
fun winVerticalLine2(){
    Canvas(modifier = Modifier
        .size(350.dp)
        .padding(all = 5.dp)) {
        drawLine(
            start = Offset(x = size.width*3/6, y = 0f),
            end = Offset(x = size.width*3/6, y = size.height),
            color = Color.Red,
            cap = StrokeCap.Round,
            strokeWidth = 10f
        )
    }
}

@Composable
fun winVerticalLine3(){
    Canvas(modifier = Modifier
        .size(350.dp)
        .padding(all = 5.dp)) {
        drawLine(
            start = Offset(x = size.width*5/6, y = 0f),
            end = Offset(x = size.width*5/6, y = size.height),
            color = Color.Red,
            cap = StrokeCap.Round,
            strokeWidth = 10f
        )
    }
}

@Composable
fun winHorizontalLine1(){
    Canvas(modifier = Modifier
        .size(350.dp)
        .padding(all = 5.dp)) {
        drawLine(
            start = Offset(x = 0f, y = size.height*1/6),
            end = Offset(x = size.width, y = size.height*1/6),
            color = Color.Red,
            cap = StrokeCap.Round,
            strokeWidth = 10f
        )
    }
}

@Composable
fun winHorizontalLine2(){
    Canvas(modifier = Modifier
        .size(350.dp)
        .padding(all = 5.dp)) {
        drawLine(
            start = Offset(x = 0f, y = size.height*3/6),
            end = Offset(x = size.width, y = size.height*3/6),
            color = Color.Red,
            cap = StrokeCap.Round,
            strokeWidth = 10f
        )
    }
}

@Composable
fun winHorizontalLine3(){
    Canvas(modifier = Modifier
        .size(350.dp)
        .padding(all = 5.dp)) {
        drawLine(
            start = Offset(x = 0f, y = size.height*5/6),
            end = Offset(x = size.width, y = size.height*5/6),
            color = Color.Red,
            cap = StrokeCap.Round,
            strokeWidth = 10f
        )
    }
}

@Composable
fun winDiagonal1(){
    Canvas(
        modifier = Modifier
            .size(350.dp)
            .padding(all = 5.dp)
    ) {
        drawLine(
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = size.height),
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            color = Color.Red
        )
    }
}

@Composable
fun winDiagonal2(){
    Canvas(
        modifier = Modifier
            .size(350.dp)
            .padding(all = 5.dp)
    ) {
        drawLine(
            start = Offset(x = size.width, y = 0f),
            end = Offset(x = 0f, y = size.height),
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            color = Color.Red
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Previews(){
    winHorizontalLine1()
    winHorizontalLine2()
    winHorizontalLine3()
}