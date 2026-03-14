package com.iperovv.vkcourseproject.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.iperovv.vkcourseproject.R

// Define your font families
val VKSansDisplay = FontFamily(
    Font(R.font.vk_sans_display__regular),
    Font(R.font.vk_sans_display__medium, FontWeight.Medium),
    Font(R.font.vk_sans_display__demi_bold, FontWeight.Bold),
    Font(R.font.vk_sans_display__bold, FontWeight.Bold),
)

val RuStoreTypography = Typography(
    // Заголовок 1
    displayLarge = TextStyle(
        fontFamily = VKSansDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 140.sp,
        lineHeight = 154.sp, // 110% от 140
        letterSpacing = 0.sp
    ),
    // Заголовок 2
    displayMedium = TextStyle(
        fontFamily = VKSansDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 120.sp,
        lineHeight = 132.sp, // 110% от 120
        letterSpacing = 0.sp
    ),
    // Заголовок 3
    displaySmall = TextStyle(
        fontFamily = VKSansDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 96.sp,
        lineHeight = 106.sp, // 110% от 96
        letterSpacing = 0.sp
    ),

    // Параграф 1 (64px)
    headlineLarge = TextStyle(
        fontFamily = VKSansDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 64.sp,
        lineHeight = 77.sp, // 120% от 64
        letterSpacing = 0.sp
    ),
    // Параграф 2 (40px)
    headlineMedium = TextStyle(
        fontFamily = VKSansDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
        lineHeight = 48.sp, // 120% от 40
        letterSpacing = 0.sp
    ),
    // Параграф 3 (28px)
    headlineSmall = TextStyle(
        fontFamily = VKSansDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 34.sp, // ~121% (120% от 28 = 33.6, округлено до 34)
        letterSpacing = 0.sp
    ),

    // Параграф 4 (20px)
    bodyLarge = TextStyle(
        fontFamily = VKSansDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 25.sp, // 125% от 20
        letterSpacing = 0.sp
    ),
    // Параграф 5 (16px)
    bodyMedium = TextStyle(
        fontFamily = VKSansDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 21.sp, // 130% от 16
        letterSpacing = 0.sp
    ),

    bodySmall = TextStyle(
        fontFamily = VKSansDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.2.sp
    ),
    labelLarge = TextStyle(
        fontFamily = VKSansDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = VKSansDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.2.sp
    ),
    labelSmall = TextStyle(
        fontFamily = VKSansDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.3.sp
    )
)
