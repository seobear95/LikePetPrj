package com.jeiu.likepetprj

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jeiu.likepetprj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(binding.root)

        val dogItems = listOf(
            DogItem("래드라도", R.drawable.dog_labrador),
            DogItem("말티즈", R.drawable.dog_maltese)  ,
            DogItem("진돗개", R.drawable.dog_jindo),
            DogItem("삽살개", R.drawable.dog_sapsal))

        binding.dogSpinner.adapter = DogSpinnerAdapter(this,
            dogItems )

        //수정 추가
        val selectedDog = binding.dogSpinner.selectedItem as DogItem
        //val dogType = binding.dogSpinner.selectedItem.toString()
        val dogType = selectedDog.name

        binding.friendLevelSeek.setOnSeekBarChangeListener(
            object : android.widget.SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(
                    p0: SeekBar?,
                    progress: Int,
                    p2: Boolean
                ) {
                     binding.friendLevelText.text = "현재 친화도 선택값: $progress"
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                    Toast.makeText(this@MainActivity,"시작",
                        Toast.LENGTH_SHORT).show()
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                    Toast.makeText(this@MainActivity,"끝",
                        Toast.LENGTH_SHORT).show()
                }


            }
        )


        binding.btnNextCat.setOnClickListener {

            var dogName = binding.editDogName.text.toString()
            if(dogName.isEmpty()){
                Toast.makeText(this, "강아지 이름을 입력해주세요",
                     Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }

            if(dogType == "선택없음"){
                Toast.makeText(this, "강아지 종류를 선택해주세요",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var dogWalk = binding.DogCheckWalk.isChecked
            var dogPlay = binding.DogCheckPlay.isChecked
            var dogClean = binding.DogCheckClean.isChecked

            intent = Intent(this, CatActivity::class.java)

            intent.putExtra("dogName", dogName)
            intent.putExtra("dogType", dogType)
            intent.putExtra("dogWalk", dogWalk)
            intent.putExtra("dogPlay", dogPlay)
            intent.putExtra("dogClean", dogClean)

            startActivity(intent)


        }




    }
}