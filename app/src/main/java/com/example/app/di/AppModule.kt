package com.example.app.di

import android.content.Context
import com.example.core.di.ApplicationScope
import com.example.data.db.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class AppModule(
    private val context: Context
) {

    @ApplicationScope
    @Provides
    fun provideContext(): Context = context

    @ApplicationScope
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.get(context)
    }
}