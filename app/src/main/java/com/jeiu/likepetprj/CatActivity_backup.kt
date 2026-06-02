package com.jeiu.likepetprj

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jeiu.likepetprj.databinding.ActivityCatBinding

class CatActivity_backup : AppCompatActivity() {
    lateinit var binding: ActivityCatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dogName = intent.getStringExtra("dogName")
        var dogType = intent.getStringExtra("dogType")
        var dogWalk = intent.getBooleanExtra("dogWalk", false)
        var dogPlay = intent.getBooleanExtra("dogPlay", false)
        var dogClean = intent.getBooleanExtra("dogClean", false)



        //binding.radioKorean.isSelected = false
        //binding.radioPersian.isSelected = false
        //binding.radioRagdoll.isSelected = false
        //binding.radioKorean.isSelected = false

       /* binding.catRadioGroup.setOnCheckedChangeListener { _, checkedID ->
            binding.radioKorean.isSelected = false
            binding.radioPersian.isSelected = false
            binding.radioRagdoll.isSelected = false
            binding.radioSiamese.isSelected = false

            when(checkedID){
                R.id.radioKorean -> binding.radioKorean.isSelected = true
                R.id.radioPersian -> binding.radioPersian.isSelected = true
                R.id.radioRagdoll -> binding.radioRagdoll.isSelected =true
                R.id.radioSiamese -> binding.radioSiamese.isSelected = true

            }
        }


        binding.btnResult.setOnClickListener {
            var catName = binding.editCatName.text.toString()
            if(catName.isEmpty()){
                Toast.makeText(this, "고양이 이름을 입력해주세요",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var catType = when(binding.catRadioGroup.checkedRadioButtonId) {
                R.id.radioKorean -> "코리앗숏헤어"
                R.id.radioPersian -> "페르시안"
                R.id.radioRagdoll -> "랙돌"
                R.id.radioSiamese -> "샴"
                else -> "선택없음"
            }

            if(catType == "선택없음"){
                Toast.makeText(this, "고양이 종류를 선택해주세요",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var catPlay = binding.CatCheckPlay.isChecked
            var catClean = binding.CatCheckClean.isChecked
            var catEat = binding.CatCheckEat.isChecked


            intent = Intent(this, ResultActivity::class.java)

            intent.putExtra("catName", catName)
            intent.putExtra("catType", catType)
            intent.putExtra("catPlay", catPlay)
            intent.putExtra("catClean", catClean)
            intent.putExtra("catEat", catEat)
            intent.putExtra("dogName", dogName)
            intent.putExtra("dogType", dogType)
            intent.putExtra("dogWalk", dogWalk)
            intent.putExtra("dogPlay", dogPlay)
            intent.putExtra("dogClean", dogClean)

            startActivity(intent)
        } */
    }

}
