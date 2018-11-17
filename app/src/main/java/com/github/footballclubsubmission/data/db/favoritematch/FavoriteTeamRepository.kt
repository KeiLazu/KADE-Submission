package com.github.footballclubsubmission.data.db.favoritematch

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/17/2018
 *  check https://github.com/KeiLazu for more
 */
class FavoriteTeamRepository(context: Context) : ManagedSQLiteOpenHelper(context, "FavoriteTeam.db", null, 2) {

    companion object {
        private var instance: FavoriteTeamRepository? = null

        @Synchronized
        fun getInstance(context: Context): FavoriteTeamRepository {
            if (instance == null) {
                instance = FavoriteTeamRepository(context.applicationContext)
            }
            return instance as FavoriteTeamRepository
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(
            FavoriteTeamModel.TABLE_FAV_TEAM, true,
            FavoriteTeamModel.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            FavoriteTeamModel.TEAM_BADGE to TEXT,
            FavoriteTeamModel.TEAM_NAME to TEXT,
            FavoriteTeamModel.TEAM_ID to INTEGER
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(FavoriteTeamModel.TABLE_FAV_TEAM, true)
    }

}

val Context.teamDb: FavoriteTeamRepository
    get() = FavoriteTeamRepository.getInstance(applicationContext)