package com.example.questapi.repositori

import com.example.questapi.apiservice.ServiceApiSiswa
import com.example.questapi.modeldata.DataSiswa
import retrofit2.Response

interface RepositoryDataSiswa{
    suspend fun getDataSiswa() : List<DataSiswa>
    suspend fun postDataSiswa(dataSiswa: DataSiswa) :retrofit2.Response<Void>
    suspend fun getSatuSiswa(idSiswa: Int): DataSiswa
    suspend fun  editStatusSiswa()

}
class JaringanRepositorySiswa (
    private val serviceApiSiswa: ServiceApiSiswa
): RepositoryDataSiswa{
    override suspend fun getDataSiswa() : List<DataSiswa> = serviceApiSiswa.getSiswa()
    override suspend fun postDataSiswa(dataSiswa: DataSiswa) :retrofit2.Response<Void> = serviceApiSiswa.postSiswa(dataSiswa)
    override suspend fun getSatuSiswa(idSiswa: Int): DataSiswa =
        serviceApiSiswa.getSiswa().first { it.id == idSiswa }
    override suspend fun editStatusSiswa() {
        // belum ada implementasi edit
    }
}