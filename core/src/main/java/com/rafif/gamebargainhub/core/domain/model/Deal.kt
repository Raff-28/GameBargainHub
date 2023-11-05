package com.rafif.gamebargainhub.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Deal(
    val dealId: String,
    val title: String,
    val storeId: String,
    val salePrice: String,
    val normalPrice: String,
    val isOnSale: String,
    val savings: String,
    val metaCriticScore: String,
    val steamRatingText: String,
    val steamRatingPercent: String,
    val steamRatingCount: String,
    val releaseDate: Int,
    val lastChange: Int,
    val dealRating: String,
    val thumb: String,
    val isFavorite: Boolean,
) : Parcelable