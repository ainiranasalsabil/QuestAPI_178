package com.example.questapi.view

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.questapi.R
import com.example.questapi.uiconroller.route.DestinasiDetail
import com.example.questapi.viewmodel.provide.PenyediaViewModel
import kotlinx.coroutines.launch
import java.util.function.IntConsumer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailSiswaScreen(
    navigateToEditItem: (Int) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = viewModel (factory = PenyediaViewModel .Factory)
) {
    Scaffold (
        topBar = {
            SiswaTopAppBar(
                title = stringResource(DestinasiDetail.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        },floatingActionButton = {
            val uiState = viewModel.statusUiDetail
            FloatingActionButton (
                onClick = {
                    when (uiState) {
                        is StatusUiDetaail.Success ->
                            navigateToEditItem(uiState.status.id)
                        else -> {}
                    }
                },shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(
                    dimensionResource(id = R.dimen.padding_large)
                )
            ){
                Icon(
                    imageVector = icons.Default.Edit,
                    contentDescription = stringResource(R.string.update)
                )
            }
        }, modifier = modifier
    ) { innerPadding ->
        val coroutineScope = rememberCoroutineScope()
        BodyDetailDataSiswa(
            statusUiDetail = viewModel.statusUiDetail,
            onDelete = {
                coroutineScope.launch {
                    viewModel.hapusSatuSiswa()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        )
    }
}

@Composable
private fun BodyDetailDataSiswa(
    statusUiDetail: StatusUiDetail,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
)