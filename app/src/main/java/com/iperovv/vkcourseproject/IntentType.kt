package com.iperovv.vkcourseproject

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.net.toUri

//Можно было бы изобразить тут sealed class, но для текущего набора вариаций и enum слегка уже перебор)
enum class IntentType(val buttonText: String) {
    EXPLICIT_OPEN_ACTIVITY_TEXT("Открыть вторую Activity") {
        override fun onButtonClick(context: Context, input: String) {
            try {
                context.startActivity(
                    Intent(
                        context,
                        ShowStringActivity::class.java
                    ).apply {
                        putExtra("INPUT_TEXT", input)
                    }
                )
            } catch (e: Exception) {
                Toast.makeText(context, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        override fun isValid(input: String): Boolean = input.isNotBlank()
    },

    IMPLICIT_CALL_FRIEND("Позвонить другу") {
        override fun onButtonClick(context: Context, input: String) {
            try {
                context.startActivity(
                    Intent(
                        Intent(Intent.ACTION_DIAL, "tel:$input".toUri())
                    )
                )
            } catch (e: Exception) {
                Toast.makeText(context, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        override fun isValid(input: String): Boolean = input.matches(Regex("^\\+?[0-9\\-\\s]+$"))
    },

    SYSTEM_SHARE_TEXT("Поделиться текстом") {
        override fun onButtonClick(context: Context, input: String) {
            try {
                context.startActivity(
                    Intent(
                        Intent(Intent.ACTION_SEND).apply {
                            putExtra(Intent.EXTRA_TEXT, input)
                            type = "text/plain"
                        }
                    )
                )
            } catch (e: Exception) {
                Toast.makeText(context, e.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        override fun isValid(input: String): Boolean = input.isNotBlank()
    };

    abstract fun onButtonClick(context: Context, input: String)
    abstract fun isValid(input: String): Boolean
}