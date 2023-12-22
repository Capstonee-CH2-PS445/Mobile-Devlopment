package com.example.readrave.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.readrave.data.api.ApiService
import com.example.readrave.data.response.ListbookItem
import retrofit2.HttpException

class Paging(
    private val apiService: ApiService,
) : PagingSource<Int, ListbookItem>() {
    override fun getRefreshKey(state: PagingState<Int, ListbookItem>): Int? {
        // Menentukan posisi pertama yang akan dimuat ketika refresh
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListbookItem> {
        return try {
            val position = params.key ?: INITIAL_PAGE_INDEX
            val response = apiService.getAllBooks(position, params.loadSize)

            LoadResult.Page(
                data = response.listbook,
                prevKey = if(position == INITIAL_PAGE_INDEX) null else position - 1,
                nextKey = if (response.listbook.isEmpty()) null else position + 1
            )
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

    companion object {
        private const val INITIAL_PAGE_INDEX = 1
    }
}