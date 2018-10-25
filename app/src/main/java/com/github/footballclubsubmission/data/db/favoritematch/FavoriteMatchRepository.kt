package com.github.footballclubsubmission.data.db.favoritematch

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper
import org.jetbrains.anko.db.createTable
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/25/2018
 *  check https://github.com/KeiLazu for more
 */
class FavoriteMatchRepository (context: Context) : ManagedSQLiteOpenHelper(context, "FavoriteTeam.db", null, 1), FavoriteMatchRepo {

    companion object {
        private var instance: FavoriteMatchRepository? = null

        @Synchronized
        fun getInstance(context: Context): FavoriteMatchRepository {
            if (instance == null) {
                instance = FavoriteMatchRepository(context.applicationContext)
            }
            return instance as FavoriteMatchRepository
        }
    }

    override fun onCreate(db: SQLiteDatabase) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}