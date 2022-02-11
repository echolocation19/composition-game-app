package com.example.compositiongame.presentation.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.compositiongame.R
import com.example.compositiongame.domain.entities.GameResult

interface OnOptionClickListener {
    fun onOptionClick(option: Int)
}

@BindingAdapter("emojiResult")
fun bindEmojiResult(imageView: ImageView, winner: Boolean) {
    val emojiId = getEmojiResId(winner)
    imageView.setImageResource(emojiId)
}

private fun getEmojiResId(winner: Boolean): Int {
    return if (winner)
        R.drawable.ic_smile
    else
        R.drawable.ic_sad
}

@BindingAdapter("requiredAnswers")
fun bindRequiredAnswers(textView: TextView, countAnswers: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_score),
        countAnswers
    )
}

@BindingAdapter("scoreAnswers")
fun bindScoreAnswers(textView: TextView, countOfRightAnswers: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.score_answers),
        countOfRightAnswers
    )
}

@BindingAdapter("requiredPercentage")
fun bindRequiredPercentage(textView: TextView, requiredPercentage: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_percentage),
        requiredPercentage
    )
}

@BindingAdapter("scorePercentage")
fun bindScorePercentage(textView: TextView, gameResult: GameResult) {
    textView.text = String.format(
        textView.context.getString(R.string.score_percentage),
        getPercentOfRightAnswers(gameResult)
    )
}

private fun getPercentOfRightAnswers(gameResult: GameResult): Int {
    return if (gameResult.countOfQuestions == 0)
        0
    else
        (gameResult.countOfRightAnswers / gameResult.countOfQuestions.toDouble() * 100).toInt()
}

@BindingAdapter("tvNumber")
fun bindNumberAsText(textView: TextView, number: Int) {
    textView.text = number.toString()
}

@BindingAdapter("enoughCount")
fun bindEnoughCount(textView: TextView, enoughCount: Boolean) {
    val color = getColorByState(textView.context, enoughCount)
    textView.setTextColor(color)
}

private fun getColorByState(context: Context,goodState: Boolean): Int {
    val colorResId = if (goodState) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_light
    }
    return  ContextCompat.getColor(context, colorResId)
}

@BindingAdapter("enoughPercent")
fun bindEnoughPercent(progressBar: ProgressBar, enoughPercent: Boolean) {
    val color = getColorByState(progressBar.context, enoughPercent)
    progressBar.progressTintList = ColorStateList.valueOf(color)
}

@BindingAdapter("onOptionClickListener")
fun bindOnOptionClickListener(textView: TextView, onOptionClickListener: OnOptionClickListener) {
    textView.setOnClickListener {
        onOptionClickListener.onOptionClick(textView.text.toString().toInt())
    }
}

