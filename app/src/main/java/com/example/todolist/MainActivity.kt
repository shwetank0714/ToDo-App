package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.iterator


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
        val removeButton = findViewById<Button>(R.id.removebtn)

        // Adding the task on clicking Create Button
        createTask.setOnClickListener {
            if(myTask.text.isEmpty()){
                Toast.makeText(this,"Empty Task", Toast.LENGTH_SHORT).show()
            }
            else{
                listItems.add(myTask.text.toString())
                arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,listItems)
                myList.adapter = arrayAdapter
                myList.choiceMode = ListView.CHOICE_MODE_MULTIPLE
                myTask.text.clear()
            }
        }

        /*---------------------------------------------- PROBLEM FACED BELOW ----------------------------------*/
        // Facing problem in figuring out the method for
        // removing the checked items when click the remove button
        removeButton.setOnClickListener {

            val sparseArray = myList.checkedItemPositions
            val getCount = sparseArray.size()

            for (i in -1..getCount+1){
                if(sparseArray[i]){
                   arrayAdapter.remove(listItems[i])
                    arrayAdapter.notifyDataSetChanged()
                }
            }
        }
        /*--------------------------------------------------------------------------------------------------------*/
    }

    
}




