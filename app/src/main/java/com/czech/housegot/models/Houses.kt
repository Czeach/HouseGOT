package com.czech.housegot.models

import android.graphics.Color
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "houses")
data class Houses(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val url: String?,
    val name: String?,
    val region: String?,
    val coatOfArms: String?,
    val words: String?,
    val titles: List<String?>?,
    val seats: List<String?>?,
    val currentLord: String?,
    val heir: String?,
    val overlord: String?,
    val founded: String?,
    val founder: String?,
    val diedOut: String?,
    val ancestralWeapons: List<String?>?,
    val cadetBranches: List<String?>?,
    val swornMembers: List<String?>?,
    var page: Int,
)