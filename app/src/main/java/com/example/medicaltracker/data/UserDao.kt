package com.example.medicaltracker.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.medicaltracker.data.User

@Dao
interface UserDao {
    @Insert(onConflict = REPLACE)
    fun insert(user: User) : Long

    @Update
    fun update(user: User)

    @Query("SELECT * FROM users WHERE userId = :userId")
    fun getUser(userId: Long): LiveData<User>

    @Query("DELETE FROM users")
    fun clear()

    @Query("SELECT * FROM users ORDER BY userId DESC LIMIT 1")
    fun getAnyUser(): User?

    @Query("SELECT * FROM users ORDER BY userId DESC")
    fun getAllUsers(): LiveData<List<User>>
}