package me.brisson.todoapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // In case the user tries to add an already existing to do, the old one get replaced
    suspend fun insertTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Query("SELECT * FROM todo WHERE id = :id")
    suspend fun getTodoById(id: Int) : Todo?

    @Query("SELECT * FROM todo")
    fun getTodos(): Flow<List<Todo>>
}