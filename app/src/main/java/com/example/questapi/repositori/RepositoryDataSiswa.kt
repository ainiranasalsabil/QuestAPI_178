package com.example.questapi.repositori

import com.example.questapi.modeldata.DataSiswa

interface RepositoryDataSiswa{
    suspend fun getDataSiswa() : List<DataSiswa>
    suspend fun getDataSiswa(dataSiswa: DataSiswa) :retrofit2.Response<Void>
}
class JaringanRepositorySiswa (
    private val serviceApiSiswa: ServiceApiSiswa
)
