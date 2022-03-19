package come.example.myviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import come.example.myviewmodel.databinding.ActivityMainBinding
import come.example.myviewmodel.models.StudentModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myModel: StudentModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //myModel = StudentModel()
        myModel = ViewModelProvider(this).get(StudentModel::class.java)

        myModel.id.observe(this, Observer { newValue ->
            binding.tvID.text = newValue
        })

        myModel.name.observe(this, Observer { newValue ->
            binding.tvName.text = newValue
        })

        binding.btnSet.setOnClickListener(){
            myModel.id.value = "W12345"
            myModel.name.value = "Joseph"
        }
//        binding.btnGet.setOnClickListener(){
//            binding.tvID.text = myModel.id
//            binding.tvName.text = myModel.name
//        }
    }
}