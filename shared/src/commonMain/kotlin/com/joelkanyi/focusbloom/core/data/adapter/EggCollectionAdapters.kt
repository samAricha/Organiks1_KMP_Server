package com.joelkanyi.focusbloom.core.data.adapter

import app.cash.sqldelight.ColumnAdapter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

val uuidAdapter = object : ColumnAdapter<String, String> {
    override fun decode(databaseValue: String): String {
        return databaseValue
    }

    override fun encode(value: String): String {
        return value
    }
}

val qtyAdapter = object : ColumnAdapter<String, String> {
    override fun decode(databaseValue: String): String {
        return databaseValue
    }

    override fun encode(value: String): String {
        return value
    }
}

val crackedAdapter = object : ColumnAdapter<String, String> {
    override fun decode(databaseValue: String): String {
        return databaseValue
    }

    override fun encode(value: String): String {
        return value
    }
}

val eggTypeIdAdapter = object : ColumnAdapter<Int, Long> {
    override fun decode(databaseValue: Long): Int {
        return databaseValue.toInt()
    }

    override fun encode(value: Int): Long {
        return value.toLong()
    }
}

val dateAdapter = object : ColumnAdapter<Date, String> {
    override fun decode(databaseValue: String): Date {
        // Convert the date string to a Date object using your desired method
        // Example assumes a simple format, adjust as needed
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(databaseValue)
    }

    override fun encode(value: Date): String {
        // Convert the Date object to a string using your desired method
        // Example assumes a simple format, adjust as needed
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(value)
    }
}

val isBackedUpAdapter = object : ColumnAdapter<Boolean, Long> {
    override fun decode(databaseValue: Long): Boolean {
        return databaseValue.toInt() == 1
    }

    override fun encode(value: Boolean): Long {
        return if (value) 1 else 0
    }
}

val createdAtAdapter = object : ColumnAdapter<Long, Long> {
    override fun decode(databaseValue: Long): Long {
        return databaseValue
    }

    override fun encode(value: Long): Long {
        return value
    }
}
