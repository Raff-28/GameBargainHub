package com.rafif.gamebargainhub.detail_deal

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.rafif.gamebargainhub.core.R
import com.rafif.gamebargainhub.core.domain.model.Deal
import com.rafif.gamebargainhub.core.utils.StringUtils.getStoreName
import com.rafif.gamebargainhub.databinding.ActivityDetailDealBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date

@AndroidEntryPoint
class DetailDealActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailDealBinding
    private val detailDealViewModel: DetailDealViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDealBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailDeal = intent.getParcelableExtra<Deal>(EXTRA_DATA)

        detailDeal?.let {
            supportActionBar?.title = detailDeal.title
            Glide.with(this@DetailDealActivity)
                .load(detailDeal.thumb)
                .into(binding.ivDetailImage)
            with(binding.content) {
                tvSalePrice.text = getString(R.string.item_price, detailDeal.salePrice)
                tvNormalPrice.text = getString(R.string.item_price, detailDeal.normalPrice)
                tvNormalPrice.paintFlags = tvNormalPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                tvSavings.text = getString(R.string.detail_savings, detailDeal.savings.toFloat().toInt().toString())
                val title = if (detailDeal.releaseDate == 0) {
                    detailDeal.title
                } else {
                    getString(R.string.game_deal_with_year, detailDeal.title, extractYearFromUnixTimestamp(detailDeal.releaseDate))
                }
                tvGameDealTitle.text = title
                tvStoreName.text = getStoreName(detailDeal.storeId)
                tvSteamReviewsText.text = if (detailDeal.steamRatingText.isNotEmpty()) {
                    detailDeal.steamRatingText
                } else { "Unavailable" }
                tvSteamReviewsNumber.text = getString(R.string.steam_reviews_number_format,
                    detailDeal.steamRatingPercent, detailDeal.steamRatingCount)
                tvMetacriticScore.text = if (detailDeal.metaCriticScore == "0") {
                    "Unavailable"
                } else { detailDeal.metaCriticScore }

                val dealUrl = "https://www.cheapshark.com/redirect?dealID=${detailDeal.dealId}"
                btnCheckStore.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(dealUrl))
                    startActivity(intent)
                }
            }
            var statusFavorite = detailDeal.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailDealViewModel.setFavoriteDeal(detailDeal, statusFavorite)
                setStatusFavorite(statusFavorite)
            }

        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }

    private fun extractYearFromUnixTimestamp(unixTimestamp: Int): String {
        val sdf = SimpleDateFormat("yyyy")
        val dateTime = Date(unixTimestamp.toLong() * 1000)
        return sdf.format(dateTime)
    }
}