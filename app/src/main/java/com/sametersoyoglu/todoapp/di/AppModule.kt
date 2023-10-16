package com.sametersoyoglu.todoapp.di

import android.content.Context
import androidx.room.Room
import com.sametersoyoglu.todoapp.data.datasource.TaskDataSource
import com.sametersoyoglu.todoapp.data.repo.TaskRepository
import com.sametersoyoglu.todoapp.room.TaskDao
import com.sametersoyoglu.todoapp.room.TaskDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideTaskDataSource(taskDao: TaskDao) : TaskDataSource {
        return TaskDataSource(taskDao)
    }

    @Provides
    @Singleton
    fun provideTaskRepository(taskDataSource: TaskDataSource) : TaskRepository {
        return TaskRepository(taskDataSource)
        // TaskRepository den nesne oluşturacaksak TaskDataSource ta tanımlı olduğu için TaskDataSource' u da tanımlamamız lazım burda.
    }

    @Provides
    @Singleton
    fun provideTaskDao(@ApplicationContext context: Context) : TaskDao {
        val dataBase = Room.databaseBuilder(context,TaskDataBase::class.java,"todoapp.sqlite")
            .createFromAsset("todoapp.sqlite").build()
        return dataBase.getTaskDao()
    }
}