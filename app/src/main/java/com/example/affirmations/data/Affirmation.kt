package com.example.affirmations.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.affirmations.R

data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)

class Datasource {
    fun loadAffirmations(): List<Affirmation> {
        return listOf(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
            Affirmation(R.string.affirmation3, R.drawable.image3),
            Affirmation(R.string.affirmation4, R.drawable.image4),
            Affirmation(R.string.affirmation5, R.drawable.image5),
            Affirmation(R.string.affirmation6, R.drawable.image6),
            Affirmation(R.string.affirmation7, R.drawable.image7),
            Affirmation(R.string.affirmation8, R.drawable.image8),
            Affirmation(R.string.affirmation9, R.drawable.image9),
            Affirmation(R.string.affirmation10, R.drawable.image10)
        )
    }
}

/*
class Datasource {
    fun getLocalizedAffirmations(): List<Affirmation> {
        val currentLanguage = Locale.getDefault().language

        return when (currentLanguage) {
            "ar" -> listOf(
                Affirmation("أنا قوي.", R.drawable.image1),
                Affirmation("أؤمن بنفسي.", R.drawable.image2),
                Affirmation("كل يوم هو فرصة جديدة للنمو وتصبح نسخة أفضل من نفسي.", R.drawable.image3),
                Affirmation("كل تحد في حياتي هو فرصة للتعلم.", R.drawable.image4),
                Affirmation("لدي الكثير لأكون ممتنًا له.", R.drawable.image5),
                Affirmation("الأشياء الجيدة تأتي دائمًا إلى حياتي.", R.drawable.image6),
                Affirmation("فرص جديدة تنتظرني في كل منعطف.", R.drawable.image7),
                Affirmation("لدي الشجاعة لأتبع قلبي.", R.drawable.image8),
                Affirmation("الأشياء ستتكشف في الوقت المناسب.", R.drawable.image9),
                Affirmation("سأكون حاضرًا في كل اللحظات التي يجلبها هذا اليوم.", R.drawable.image10)
            )
            else -> listOf(
                Affirmation("I am strong.", R.drawable.image1),
                Affirmation("I believe in myself.", R.drawable.image2),
                Affirmation("Each day is a new opportunity to grow and be a better version of myself.", R.drawable.image3),
                Affirmation("Every challenge in my life is an opportunity to learn from.", R.drawable.image4),
                Affirmation("I have so much to be grateful for.", R.drawable.image5),
                Affirmation("Good things are always coming into my life.", R.drawable.image6),
                Affirmation("New opportunities await me at every turn.", R.drawable.image7),
                Affirmation("I have the courage to follow my heart.", R.drawable.image8),
                Affirmation("Things will unfold at precisely the right time.", R.drawable.image9),
                Affirmation("I will be present in all the moments that this day brings.", R.drawable.image10)
            )
        }
    }
}*/
