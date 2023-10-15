package com.sametersoyoglu.todoapp.di

import com.sametersoyoglu.todoapp.data.datasource.TaskDataSource
import com.sametersoyoglu.todoapp.data.repo.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideTaskDataSource() : TaskDataSource {
        return TaskDataSource()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(taskDataSource: TaskDataSource) : TaskRepository {
        return TaskRepository(taskDataSource)
        // TaskRepository den nesne oluşturacaksak TaskDataSource ta tanımlı olduğu için TaskDataSource' u da tanımlamamız lazım burda.
    }

}