package com.example.pizzago.di

import android.content.Context
import androidx.room.Room
import com.example.pizzago.core.CheckInternetConnection
import com.example.pizzago.core.CheckInternetConnectionImpl
import com.example.pizzago.data.datasource.locale.LocalDataSource
import com.example.pizzago.data.datasource.locale.LocaleDateSourceImpl
import com.example.pizzago.data.datasource.locale.room.LocalDatabase
import com.example.pizzago.data.datasource.network.NetworkDataSource
import com.example.pizzago.data.datasource.network.NetworkDataSourceImpl
import com.example.pizzago.data.datasource.network.api.MealApi
import com.example.pizzago.data.repository.MealRepositoryImpl
import com.example.pizzago.domain.repository.MealRepository
import com.example.pizzago.domain.usecase.GetCategoriesUseCase
import com.example.pizzago.domain.usecase.GetMealsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SingletonModule {

	@Provides
	@Singleton
	fun provideRetrofit(): Retrofit {
		return Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl("https://themealdb.com/api/json/v1/1/")
			.build()
	}

	@Provides
	@Singleton
	fun provideMealApi(retrofit: Retrofit): MealApi {
		return retrofit.create(MealApi::class.java)
	}

	@Provides
	@Singleton
	fun provideNetworkDataSource(api: MealApi): NetworkDataSource {
		return NetworkDataSourceImpl(api)
	}

	@Provides
	@Singleton
	fun provideCheckInternetConnection(@ApplicationContext context: Context): CheckInternetConnection {
		return CheckInternetConnectionImpl(context)
	}

	@Provides
	@Singleton
	fun provideMealRepository(
		networkDataSource: NetworkDataSource,
		localDataSource: LocalDataSource,
		checkInternetConnection: CheckInternetConnection
	): MealRepository {
		return MealRepositoryImpl(networkDataSource, localDataSource, checkInternetConnection)
	}

	@Provides
	@Singleton
	fun provideSignInUseCase(repository: MealRepository): GetCategoriesUseCase {
		return GetCategoriesUseCase(repository)
	}

	@Provides
	@Singleton
	fun provideGetPaymentListUseCase(repository: MealRepository): GetMealsUseCase {
		return GetMealsUseCase(repository)
	}

	@Provides
	@Singleton
	fun provideRoomFactory(@ApplicationContext context: Context): LocalDatabase {
		return Room.databaseBuilder(context, LocalDatabase::class.java, "room_database.db")
			.build()
	}

	@Provides
	@Singleton
	fun provideLocalDataSource(localDb: LocalDatabase): LocalDataSource {
		return LocaleDateSourceImpl(localDb.getMealDao(), localDb.getCategoriesDao())
	}
}