package com.example.compositiongame.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// enum implements Serializable by default
@Parcelize
enum class Level: Parcelable {
    TEST, EASY, MEDIUM, HARD
}