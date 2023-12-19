package com.example.readrave.ui.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.readrave.R
import com.example.readrave.ViewModelFactory
import com.example.readrave.data.Repository
import com.example.readrave.databinding.ActivitySearchBinding
import com.example.readrave.databinding.ActivitySearchBookBinding
import com.example.readrave.ui.main.MainActivity
import com.example.readrave.ui.main.MainContent
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchBookActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBookBinding

    private val searchViewModel by viewModels<SearchViewModel> {
        ViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val adapter = BookAdapter()
//
//        with(binding) {
//            searchView.setupWithSearchBar(searchBar)
//            searchView
//                .editText
//                .setOnEditorActionListener { textView, actionId, event ->
//                    searchBar.text = searchView.text
//                    searchView.hide()
//                    searchViewModel.search(searchView.text.toString())
//                    searchViewModel.searchResult.observe(this@SearchBookActivity) { books ->
//                        adapter.submitList(books)
//                        binding.recyclerView.adapter = adapter
//                    }
//                    false
//                }
//
//
//        }

        val composeView = ComposeView(this)

        // Set konten Compose ke dalam ComposeView
        composeView.setContent {
            // Panggil Composable untuk konten utama di sini
            MainScreen()
        }

        findViewById<FrameLayout>(R.id.container).addView(composeView)

        clickButton()
    }

    private fun clickButton(){
        val bottomNavView: BottomNavigationView = binding.bottomNavigationView
        bottomNavView.setOnNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.search -> {
                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.bookmark -> {
                    // Tambahkan logika atau intent jika diperlukan
                    true
                }
                R.id.profile -> {
                    // Tambahkan logika atau intent jika diperlukan
                    true
                }
                else -> false
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = viewModel(factory = ViewModelFactory(Repository())),
//    navigateToDetail: (Long) -> Unit,
) {
    val groupedBooks by viewModel.groupedBooks.collectAsState()
    val query by viewModel.query

    Box(modifier = modifier) {
        LazyColumn {
            item {
                SearchBar(
                    query = query,
                    onQueryChange = viewModel::search,
                    modifier = modifier.background(MaterialTheme.colorScheme.background)
                )
            }
            groupedBooks.forEach { (initial, books) ->
                items(books, key = { it.id }) { book ->
                    BooksListItem(
                        name = book.title,
                        description = book.description,
                        photoUrl = book.image,
                        modifier = modifier
                            .padding(horizontal = 8.dp)
//                            .clickable{navigateToDetail(book.id)}
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    androidx.compose.material3.SearchBar(
        query = query,
        onQueryChange = onQueryChange,
        onSearch = {},
        active = false,
        onActiveChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        placeholder = {
            Text(stringResource(R.string.searchbar_hint))
        },
        shape = MaterialTheme.shapes.extraLarge,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .heightIn(min = 48.dp)
    ) {
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MaterialTheme {
       MainScreen(
//            navigateToDetail = {}
        )
    }
}