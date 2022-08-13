package com.umc.battles.ui.common.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.umc.battles.R
import com.umc.battles.databinding.HomeButtonCustomBinding

class CustomHomeButton(
    context: Context,
    attrs: AttributeSet?
) : ConstraintLayout(context, attrs) {

    private val binding: HomeButtonCustomBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.home_button_custom,
            this,
            true
        )

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.CustomHomeButton)
        with(binding) {

            tvBtnName.text = a.getString(R.styleable.CustomHomeButton_buttonName).toString()
            ivBtnIcon.setImageDrawable(a.getDrawable(R.styleable.CustomHomeButton_buttonIcon))
            layoutBackground.background =
                a.getDrawable(R.styleable.CustomHomeButton_buttonBackground)
        }
        a.recycle()
    }
}