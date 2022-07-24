package com.umc.battles.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

fun visibleView(isVisible: Boolean): Int = if (isVisible) View.VISIBLE else View.GONE