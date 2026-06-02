package com.jeiu.likepetprj

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class DogSpinnerAdapter (
    context : Context,
    private val dogList : List<DogItem>
) : ArrayAdapter<DogItem>( context, 0,dogList ){
    // 현재 선택된 화면
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var view = createView(position, convertView, parent)

        // 닫힌 Spinner 화면은 현재 선택된 항목이므로 selected=true
        view.isSelected = true
        view.setBackgroundResource(R.drawable.choice_card)
        view.refreshDrawableState()


        return view
    }
    // 펼쳤을 때 목록화면
    override fun getDropDownView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {

        var view = createView(position, convertView, parent)

        // 닫힌 Spinner 화면은 현재 선택된 항목이므로 selected=true
        view.isSelected = false
        view.setBackgroundResource(R.drawable.choice_card_selector)
        view.refreshDrawableState()

        return view
    }

    private fun createView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(
            R.layout.spinner_item ,
            parent, false
        )
        val imageView = view.findViewById<ImageView>(R.id.imgDog)
        val textView = view.findViewById<TextView>(R.id.txtDogName)
        val currentDog = dogList[position]
        imageView.setImageResource(currentDog.imageResId)
        textView.text = currentDog.name
        view.isSelected = false

        return view
        // val name = userName ?: "손님"   (엘비스연산자)
        // userName 변수의 값이 있으면 그대로 쓰고, 없으면 오른쪽값 사용.

    }
}