package com.jeiu.likepetprj

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jeiu.likepetprj.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val catName = intent.getStringExtra("catName")
        val catType = intent.getStringExtra("catType")
        val catPlay = intent.getBooleanExtra("catPlay", false)
        val catClean = intent.getBooleanExtra("catClean", false)
        val catEat = intent.getBooleanExtra("catEat", false)

        val dogName = intent.getStringExtra("dogName")
        val dogType = intent.getStringExtra("dogType")
        val dogWalk = intent.getBooleanExtra("dogWalk", false)
        val dogPlay = intent.getBooleanExtra("dogPlay", false)
        val dogClean = intent.getBooleanExtra("dogClean", false)

        binding.imgDog.setImageResource( getDogImage(dogType))
        binding.imgCat.setImageResource( getCatImage(catType))

        binding.txtResult.text="""
             애완견 : $dogName ($dogType)
             매일 산책 하기 : ${if (dogWalk) "가능" else "불가능"}
             매일 목욕 하기 : ${if (dogClean) "가능" else "불가능"}
             매일 놀아주기 : ${if (dogPlay) "가능" else "불가능"}

            애완묘 : $catName ($catType)
            매일 놀기 : ${if (catPlay) "가능" else "불가능"}
            매일 간식 주기 : ${if (catEat) "가능" else "불가능"}
            매일 씻어 주기 : ${if (catClean) "가능" else "불가능"}
    오늘부터 $dogName 와 $catName 를 함께 키우기 시작합니다!""".trimIndent()


        binding.btnFinish.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun getCatImage(catType: String?): Int = when(catType){
        "코리안숏헤어" -> R.drawable.cat_korean
        "페르시안" -> R.drawable.cat_persian
        "샴" -> R.drawable.cat_siamese
        "랙돌" -> R.drawable.cat_ragdoll
        else -> R.drawable.cat_korean
    }

    private fun getDogImage(dogType: String?): Int =when(dogType){
        "레브라도" -> R.drawable.dog_labrador
        "말티즈" -> R.drawable.dog_maltese
        "진돗개" -> R.drawable.dog_jindo
        "삽살개" -> R.drawable.dog_sapsal
        else -> R.drawable.dog_labrador
    }
}