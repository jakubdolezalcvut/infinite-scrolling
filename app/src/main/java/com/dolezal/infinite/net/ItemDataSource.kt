package com.dolezal.infinite.net

import androidx.paging.DataSource
import com.dolezal.infinite.data.Item

abstract class ItemDataSourceFactory : DataSource.Factory<Int, Item>()