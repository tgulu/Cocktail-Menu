package com.example.cocktail_menu.DI

//import com.example.artmuseumapp.rest.ArtAPI
//import com.example.artmuseumapp.rest.ArtRepoImplementation
//import com.example.artmuseumapp.rest.ArtRepository
//import com.example.artmuseumapp.viewmodel.ArtViewModel
import com.example.cocktail_menu.rest.DrinkRepoImplementation
import com.example.cocktail_menu.rest.DrinkRepository
import com.example.cocktail_menu.rest.DrinksAPI
import com.example.cocktail_menu.viewmodel.DrinkViewModel
import com.google.gson.Gson
import io.reactivex.schedulers.Schedulers.single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit



val NetworkModule = module {

    fun providesGson(): Gson = Gson()

    fun providesLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    fun providesNetworkService(gson: Gson, okHttpClient: OkHttpClient): DrinksAPI =
        Retrofit.Builder().baseUrl(DrinksAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient).build()
            .create(DrinksAPI::class.java)

    fun provideDrinkRepo(drinkerAPI: DrinksAPI):DrinkRepository =
        DrinkRepoImplementation(drinkerAPI)

    single { providesLoggingInterceptor()}
    single { providesOkHttpClient(get()) }
    single { providesNetworkService(get(), get()) }
    single { provideDrinkRepo(get()) }
    single { providesGson() }

}

val viewModelModule = module{

    viewModel { DrinkViewModel(get())}
}