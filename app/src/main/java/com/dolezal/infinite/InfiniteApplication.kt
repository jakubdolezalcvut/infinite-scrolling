package com.dolezal.infinite

import android.app.Application
import androidx.paging.PagedList
import com.dolezal.infinite.net.ItemDataSourceFactory
import com.dolezal.infinite.net.NetworkStateModel
import com.dolezal.infinite.net.RetrofitItemDataSourceFactory
import toothpick.Toothpick
import toothpick.config.Module

class InfiniteApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Toothpick.openScope(applicationContext).apply {
            installModules(PagingModule)
        }
    }
}

private object PagingModule : Module() {

    private const val BASE_URL = "http://jsonplaceholder.typicode.com"
    private const val INITIAL_BATCH_SIZE = 20
    private const val LOAD_BATCH_SIZE = 10
    private const val EMPTY_THRESHOLD = 2

    init {
        val pagingConfig = PagedList.Config.Builder()
            .setPageSize(LOAD_BATCH_SIZE)
            .setPrefetchDistance(INITIAL_BATCH_SIZE)
            .setPrefetchDistance(EMPTY_THRESHOLD)
            .setEnablePlaceholders(false)
            .build()

        val networkStateModel = NetworkStateModel()
        val factory = RetrofitItemDataSourceFactory(BASE_URL, networkStateModel)

        bind(PagedList.Config::class.java).toInstance(pagingConfig)
        bind(NetworkStateModel::class.java).toInstance(networkStateModel)
        bind(ItemDataSourceFactory::class.java).toInstance(factory)
    }
}