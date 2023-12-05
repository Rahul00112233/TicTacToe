package com.example.tictactoe

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GameScreen(
    viewModel: GameViewModel,

    modifier:Modifier = Modifier
){
    val state = viewModel.state

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Player X : ${state.crossPlayerCount}", fontSize = 16.sp)
            Text(text = "Draw : ${state.drawCount}", fontSize = 16.sp)
            Text(text = "Player O : ${state.circlePlayerCount}", fontSize = 16.sp)
        }
        
        Text(
            text = "TIC-TAC-TOE",
            fontSize = 50.sp,
            textAlign = TextAlign.Center
        )
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(20.dp)
                )
                .clip(shape = RoundedCornerShape(20.dp))
                .background(color = Color.DarkGray),
            contentAlignment = Alignment.Center
        ){
            BoardBase()
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .aspectRatio(1f),
                columns = GridCells.Fixed(3)

            ){
                viewModel.boardItems.forEach { (cellNo, boardCellValue) ->
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .clickable(
                                    interactionSource = MutableInteractionSource(),
                                    indication = null
                                ) {
                                    viewModel.onAction(UserActions.BoardTapped(cellNo = cellNo))
                                },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AnimatedVisibility(
                                visible = viewModel.boardItems[cellNo] != BoardCellValue.NONE,
                                enter = scaleIn(tween(100))
                            ) {
                                if (boardCellValue == BoardCellValue.CROSS){
                                    Cross()
                                }else if (boardCellValue == BoardCellValue.CIRCLE){
                                    Circle()
                                }
                            }


                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AnimatedVisibility(visible = state.hasWon, enter = fadeIn(tween(1000))) {
                    DrawVictoryLine(state = state)
                }
            }
        }
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(state.hintText, fontSize = 16.sp)

            Button(onClick = {
                viewModel.onAction(UserActions.playAgainButtonClicked)
            }) {
                Text(text = "Play Again", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun DrawVictoryLine(
    state: GameState
){
    when(state.victoryType){
        VictoryType.HORIZONTAL1 -> winHorizontalLine1()
        VictoryType.HORIZONTAL2 -> winHorizontalLine2()
        VictoryType.HORIZONTAL3 -> winHorizontalLine3()
        VictoryType.VERTICAL1 -> winVerticalLine1()
        VictoryType.VERTICAL2 -> winVerticalLine2()
        VictoryType.VERTICAL3 -> winVerticalLine3()
        VictoryType.DIAGONAL1 -> winDiagonal1()
        VictoryType.DIAGONAL2 -> winDiagonal2()
        VictoryType.NONE -> {}
    }
}

