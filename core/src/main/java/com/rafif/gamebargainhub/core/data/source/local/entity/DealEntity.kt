package com.rafif.gamebargainhub.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deal")
data class DealEntity(
    @PrimaryKey
    @ColumnInfo(name = "dealId")
    var dealId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "storeId")
    var storeId: String,

    @ColumnInfo(name = "salePrice")
    var salePrice: String,

    @ColumnInfo(name = "normalPrice")
    var normalPrice: String,

    @ColumnInfo(name = "isOnSale")
    var isOnSale: String,

    @ColumnInfo(name = "savings")
    var savings: String,

    @ColumnInfo(name = "metaCriticScore")
    var metaCriticScore: String,

    @ColumnInfo(name = "steamRatingText")
    var steamRatingText: String,

    @ColumnInfo(name = "steamRatingPercent")
    var steamRatingPercent: String,

    @ColumnInfo(name = "steamRatingCount")
    var steamRatingCount: String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: Int,

    @ColumnInfo(name = "lastChange")
    var lastChange: Int,

    @ColumnInfo(name = "dealRating")
    var dealRating: String,

    @ColumnInfo(name = "thumb")
    var thumb: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean,
)