package com.rafif.gamebargainhub.core.utils

import com.rafif.gamebargainhub.core.data.source.local.entity.DealEntity
import com.rafif.gamebargainhub.core.data.source.remote.response_model.DealResponse
import com.rafif.gamebargainhub.core.domain.model.Deal

object DataMapper {
    fun mapResponsesToEntities(input: List<DealResponse>): List<DealEntity> {
        val dealList = ArrayList<DealEntity>()
        input.map {
            val deal = DealEntity(
                dealId = it.dealId,
                title = it.title,
                storeId = it.storeId,
                salePrice = it.salePrice,
                normalPrice = it.normalPrice,
                isOnSale = it.isOnSale,
                savings = it.savings,
                metaCriticScore = it.metaCriticScore,
                steamRatingText = it.steamRatingText ?: "",
                steamRatingPercent = it.steamRatingPercent,
                steamRatingCount = it.steamRatingCount,
                releaseDate = it.releaseDate,
                lastChange = it.lastChange,
                dealRating = it.dealRating,
                thumb = it.thumb,
                isFavorite = false,
            )
            dealList.add(deal)
        }
        return dealList
    }

    fun mapEntitiesToDomain(input: List<DealEntity>): List<Deal> =
        input.map {
            Deal(
                dealId = it.dealId,
                title = it.title,
                storeId = it.storeId,
                salePrice = it.salePrice,
                normalPrice = it.normalPrice,
                isOnSale = it.isOnSale,
                savings = it.savings,
                metaCriticScore = it.metaCriticScore,
                steamRatingText = it.steamRatingText,
                steamRatingPercent = it.steamRatingPercent,
                steamRatingCount = it.steamRatingCount,
                releaseDate = it.releaseDate,
                lastChange = it.lastChange,
                dealRating = it.dealRating,
                thumb = it.thumb,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Deal) = DealEntity(
        dealId = input.dealId,
        title = input.title,
        storeId = input.storeId,
        salePrice = input.salePrice,
        normalPrice = input.normalPrice,
        isOnSale = input.isOnSale,
        savings = input.savings,
        metaCriticScore = input.metaCriticScore,
        steamRatingText = input.steamRatingText,
        steamRatingPercent = input.steamRatingPercent,
        steamRatingCount = input.steamRatingCount,
        releaseDate = input.releaseDate,
        lastChange = input.lastChange,
        dealRating = input.dealRating,
        thumb = input.thumb,
        isFavorite = input.isFavorite
    )
}