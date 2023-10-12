package com.rafif.gamebargainhub.core.data.source

import com.rafif.gamebargainhub.core.data.source.local.LocalDataSource
import com.rafif.gamebargainhub.core.data.source.remote.RemoteDataSource
import com.rafif.gamebargainhub.core.data.source.remote.network.ApiResponse
import com.rafif.gamebargainhub.core.data.source.remote.response_model.DealResponse
import com.rafif.gamebargainhub.core.domain.model.Deal
import com.rafif.gamebargainhub.core.domain.repository.DealRepository
import com.rafif.gamebargainhub.core.utils.AppExecutors
import com.rafif.gamebargainhub.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DealRepositoryImpl private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
) : DealRepository {
    companion object {
        @Volatile
        private var instance: DealRepositoryImpl? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors,
        ): DealRepositoryImpl =
            instance ?: synchronized(this) {
                instance ?: DealRepositoryImpl(remoteData, localData, appExecutors)
            }
    }

    override fun getAllDeal(): Flow<Resource<List<Deal>>> =
        object: NetworkBoundResource<List<Deal>, List<DealResponse>>() {
            override fun loadFromDB(): Flow<List<Deal>> {
                return localDataSource.getAllDeal().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Deal>?): Boolean =
                data.isNullOrEmpty()
//                true

            override suspend fun createCall(): Flow<ApiResponse<List<DealResponse>>> =
                remoteDataSource.getAllDeal()

            override suspend fun saveCallResult(data: List<DealResponse>) {
                val dealList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertDeal(dealList)
            }
        }.asFlow()

    override fun getFavoriteDeal(): Flow<List<Deal>> {
        return localDataSource.getFavoriteDeal().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteDeal(deal: Deal, state: Boolean) {
        val dealEntity = DataMapper.mapDomainToEntity(deal)
        appExecutors.diskIO().execute { localDataSource.setFavoriteDeal(dealEntity, state) }
    }
}