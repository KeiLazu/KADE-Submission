package com.github.footballclubsubmission.data.db.favoritematch

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/25/2018
 *  check https://github.com/KeiLazu for more
 */
class FavoriteMatchRepository(context: Context) : ManagedSQLiteOpenHelper(context, "FavoriteTeam.db", null, 1) {

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
        db.createTable(FavoriteMatchModel.TABLE_FAVORITE, true,
            FavoriteMatchModel.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            FavoriteMatchModel.ID_EVENT to TEXT + UNIQUE,
            FavoriteMatchModel.DATE_EVENT to TEXT,
            FavoriteMatchModel.HOME_TEAM_ID to INTEGER,
            FavoriteMatchModel.AWAY_TEAM_ID to INTEGER,
            FavoriteMatchModel.HOME_TEAM to TEXT,
            FavoriteMatchModel.AWAY_TEAM to TEXT,
            FavoriteMatchModel.HOME_SCORE to INTEGER,
            FavoriteMatchModel.AWAY_SCORE to INTEGER,
            FavoriteMatchModel.HOME_GOAL_DETAIL to TEXT,
            FavoriteMatchModel.AWAY_GOAL_DETAIL to TEXT,
            FavoriteMatchModel.HOME_SHOTS to INTEGER,
            FavoriteMatchModel.AWAY_SHOTS to INTEGER,
            FavoriteMatchModel.HOME_LINEUP_GOALKEEPER to TEXT,
            FavoriteMatchModel.AWAY_LINEUP_GOALKEEPER to TEXT,
            FavoriteMatchModel.HOME_LINEUP_DEFENSE to TEXT,
            FavoriteMatchModel.AWAY_LINEUP_DEFENSE to TEXT,
            FavoriteMatchModel.HOME_LINEUP_MIDFIELD to TEXT,
            FavoriteMatchModel.AWAY_LINEUP_MIDFIELD to TEXT,
            FavoriteMatchModel.HOME_LINEUP_FORWARD to TEXT,
            FavoriteMatchModel.AWAY_LINEUP_FORWARD to TEXT,
            FavoriteMatchModel.HOME_LINEUP_SUBS to TEXT,
            FavoriteMatchModel.AWAY_LINEUP_SUBS to TEXT,
            FavoriteMatchModel.HOME_BADGE to TEXT,
            FavoriteMatchModel.AWAY_BADGE to TEXT
            )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(FavoriteMatchModel.TABLE_FAVORITE, true)
    }

}

val Context.matchDb: FavoriteMatchRepository
    get() = FavoriteMatchRepository.getInstance(applicationContext)