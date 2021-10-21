package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {

    private  lateinit var arrayAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Array to store the tasks
        val listItems:ArrayList<String> = ArrayList()

        // getting the IDs of the views and buttons
        val myTask = findViewById<EditText>(R.id.editView)
        val createTask = findViewById<Button>(R.id.buttonId)
        val myList = findViewById<ListView>(R.id.lv)

        // Adding the task on clicking Create Button
        createTask.setOnClickListener {
            if(myTask.text.isEmpty()){
                Toast.makeText(this,"Empty Task", Toast.LENGTH_SHORT).show()
            }
            else{
                listItems.add(myTask.text.toString())
                arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems)
                myList.adapter = arrayAdapter
                myTask.text.clear()
            }
        }

        // Clicking the task on the listView the task gets deleted.
        myList.setOnItemClickListener { _, _, position, _ ->
            val deleteItem = arrayAdapter.getItem(position)
            arrayAdapter.remove(deleteItem)
        }


    }

    
}



