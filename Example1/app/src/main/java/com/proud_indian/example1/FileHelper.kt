package com.proud_indian.example1

import android.content.Context
import androidx.compose.runtime.snapshots.SnapshotStateList
import java.io.FileNotFoundException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

const val FILE_NAME = "todoList.dat"

fun writeData(items: SnapshotStateList<String>, context : Context) {
    /*
    * File Output Class -> this class used to save data in a file
    * openFileOutput -> This method create a file and open it in device.
    * ObjectOutputStream -> These two classes are used to create and write data into a new file.
    * Convert the items to ArrayList -> Because Save SnapshotStateList will get the Non-Serializable Exception
    * Write the ArrayList to the File
     */
    val fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)
    val oas = ObjectOutputStream(fos)
    val itemList = ArrayList<String>()
    itemList.addAll(items)
    oas.writeObject(itemList)
    oas.close()
}

fun readData(context: Context) : SnapshotStateList<String> {
    /*
    * openFileInput -> read the file from the device
    * ObjectInputStream -> Read the Data from the File
    * Convert to into ArrayList using casting
     */
    var itemList : ArrayList<String>

    try {
        val fis = context.openFileInput(FILE_NAME)
        val ois = ObjectInputStream(fis)
        itemList = ois.readObject() as ArrayList<String>
    }catch (e : FileNotFoundException){
        itemList = ArrayList()
    }

    val items = SnapshotStateList<String>()
    items.addAll(itemList)

    return items
}