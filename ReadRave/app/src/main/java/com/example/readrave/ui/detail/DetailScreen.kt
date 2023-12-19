package com.example.readrave.ui.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.readrave.R
import com.example.readrave.ViewModelFactory
import com.example.readrave.data.Repository

//@Composable
//fun DetailScreen(
//    bookId: Long,
//    viewModel: DetailBookViewModel = viewModel(factory = ViewModelFactory(Repository())),
//    navigateBack: () -> Unit,
//){
//    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
//        when (uiState) {
//            is UiState.Loading -> {
//                viewModel.getPlayerById(playerId)
//            }
//            is UiState.Success -> {
//                val data = uiState.data
//                if (data != null) {
//                    DetailContent(
//                        data.photoUrl,
//                        data.name,
//                        data.description,
//                        onBackClick = navigateBack,
//                    )
//                }
//            }
//            is UiState.Error -> {}
//        }
//    }
//
//}

@Composable
fun DetailContent(
    @DrawableRes image: Int,
    name: String,
    description: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Box {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .height(500.dp)
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
            )
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.back),
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onBackClick() }
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify,
            )
        }
    }
}