package com.rafif.gamebargainhub.core.data.source.remote.response_model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class DealResponse(

	@field:SerializedName("gameID")
	val gameID: String,

	@field:SerializedName("metacriticScore")
	val metaCriticScore: String,

	@field:SerializedName("salePrice")
	val salePrice: String,

	@field:SerializedName("releaseDate")
	val releaseDate: Int,

	@field:SerializedName("thumb")
	val thumb: String,

	@field:SerializedName("dealID")
	val dealId: String,

	@field:SerializedName("steamRatingCount")
	val steamRatingCount: String,

	@field:SerializedName("metacriticLink")
	val metacriticLink: String? = null,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("storeID")
	val storeId: String,

	@field:SerializedName("steamAppID")
	val steamAppID: String? = null,

	@field:SerializedName("internalName")
	val internalName: String,

	@field:SerializedName("steamRatingPercent")
	val steamRatingPercent: String,

	@field:SerializedName("dealRating")
	val dealRating: String,

	@field:SerializedName("normalPrice")
	val normalPrice: String,

	@field:SerializedName("lastChange")
	val lastChange: Int,

	@field:SerializedName("savings")
	val savings: String,

	@field:SerializedName("isOnSale")
	val isOnSale: String,

	@field:SerializedName("steamRatingText")
	val steamRatingText: String? = null
)
