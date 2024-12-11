package com.example.myapplication.di

import com.example.myapplication.data.AccountServiceImpl
import com.example.myapplication.data.AccountService
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class Module {
    @Provides
    @Singleton
    fun provideFirebaseAuth() : FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
    @Provides
    fun provideAuthRepository(impl : AccountServiceImpl) : AccountService{
        return impl
    }
}