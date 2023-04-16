package com.example.carretmarket.util

object AdapterManager {
    val TAG: String = "로그"
    fun <T> addItem(itemList: MutableList<T>, item: T) {
        itemList.add(item)
    }

    fun <T> clearItem(items: MutableList<T>) {
        items.clear()
    }

    fun <T> addItems(itemList: MutableList<T>, items: MutableList<T>) {
        for (item in items) {
            itemList.add(item)
        }
    }
}