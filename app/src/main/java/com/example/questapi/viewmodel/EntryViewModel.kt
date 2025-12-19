package com.example.questapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.questapi.modeldata.DetailSiswa
import com.example.questapi.modeldata.UIStateSiswa
import com.example.questapi.repositori.RepositoryDataSiswa

class EntryViewModel(
    private val repositoryDataSiswa: RepositoryDataSiswa
) : ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private fun validasiInput(
        uiState: DetailSiswa = uiStateSiswa.detailSiswa
    ): Boolean {
        return uiState.nama.isNotBlank()
                && uiState.alamat.isNotBlank()
                && uiState.telpon.isNotBlank()
                && uiState.telpon.all { it.isDigit() }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UIStateSiswa(
            detailSiswa= detailSiswa,
            isEntryValid = validasiInput(detailSiswa)
        )
    }

