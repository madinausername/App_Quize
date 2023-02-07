package uz.itschool.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import uz.itschool.myapplication.Model.Test

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var test_list= arrayListOf<Test>()
    var index=0
    lateinit var question:TextView
    lateinit var answer_1:TextView
    lateinit var answer_2:TextView
    lateinit var answer_3:TextView
    lateinit var next_b:Button
    lateinit var linear_layout_question_number:LinearLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        question=findViewById(R.id.text_question)
        answer_1=findViewById(R.id.answer_1)
        answer_2=findViewById(R.id.answer_2)
        answer_3=findViewById(R.id.answer_3)
        next_b=findViewById(R.id.next_button)
        linear_layout_question_number=findViewById(R.id.linear_layout_question_number)


        test_list.add(Test("0000000","0","0","1","1"))
        test_list.add(Test("1111111","2","3","1","2"))
        test_list.add(Test("2222222","3","9","0","3"))
        test_list.add(Test("5315454","1","9","-1","-1"))
        createNumber(test_list.size)
        createTest(index)

        next_b.setOnClickListener {
            if(index<test_list.size-1){
                index++
            }
            createTest(index)

        }
    }




    fun createTest(n:Int){
        var test=test_list[n]
        question.text=test.question
        answer_1.text=test.answer1
        answer_2.text=test.answer2
        answer_3.text=test.answer3
    }

    fun createNumber(n:Int){
        for(i in 0 until n){
            var button=Button(this)
            button.id=i
            button.text="${i+1}"
            button.tag="$i"
            button.setOnClickListener(this)
            linear_layout_question_number.addView(button)


        }



    }

    override fun onClick(p0: View?) {
        var button=findViewById<Button>(p0!!.id)
        index=button.tag.toString().toInt()
        createTest(index)
    }

    fun Check(index_of_massiv:Int, answer_selected:String){

    }
}