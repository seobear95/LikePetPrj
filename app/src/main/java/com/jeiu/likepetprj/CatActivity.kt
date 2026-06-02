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
import com.jeiu.likepetprj.databinding.ActivityCatBinding

class CatActivity : AppCompatActivity() {
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

        val catItems = listOf<String>(
             "코리안숏헤어",
              "페르시안",
              "샴",
              "랙돌")
        binding.catSpinner.adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item,
            catItems)
        binding.friendLevelSeek.setOnSeekBarChangeListener(
            object : android.widget.SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(
                    seekbar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    binding.friendLevelText.text = "친화도 : $progress"
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                   Toast.makeText(this@CatActivity,
                       "시작",Toast.LENGTH_SHORT).show()
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                    Toast.makeText(this@CatActivity,
                        "끝",Toast.LENGTH_SHORT).show()
                }

            }
        )


        binding.btnResult.setOnClickListener {
            var catName = binding.editCatName.text.toString()
            if(catName.isEmpty()){
                Toast.makeText(this, "고양이 이름을 입력해주세요",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var catType = binding.catSpinner.isSelected
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
        }
    }

}
