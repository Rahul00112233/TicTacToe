package com.example.tictactoe

sealed class UserActions {
    object playAgainButtonClicked: UserActions()
    data class BoardTapped(val cellNo: Int): UserActions()
}