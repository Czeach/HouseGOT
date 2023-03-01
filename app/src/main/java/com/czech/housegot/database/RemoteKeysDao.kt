package com.czech.housegot.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.czech.housegot.models.RemoteKeys
import kotlinx.coroutines.flow.Flow

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeys>)

    @Query("Select * From remote_keys Where id = :id")
    fun getRemoteKeyById(id: Int): Flow<RemoteKeys?>

    @Query("Delete From remote_keys")
    suspend fun deleteRemoteKeys()
}