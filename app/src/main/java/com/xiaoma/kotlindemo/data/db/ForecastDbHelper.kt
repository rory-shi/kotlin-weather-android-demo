package com.xiaoma.kotlindemo.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.xiaoma.kotlindemo.ui.App
import org.jetbrains.anko.db.*

/**
 * Created by shixinghua on 09/06/2017.
 */

class ForeacstDbHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx,
        ForeacstDbHelper.DB_NAME, null, ForeacstDbHelper.DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(CityForecastTable.NAME, true,
                CityForecastTable.ID to INTEGER + PRIMARY_KEY,
                CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to TEXT)
        db.createTable(DayForecastTable.Name, true,
                DayForecastTable.ID to INTEGER )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        val instance by lazy { ForeacstDbHelper }
    }
}