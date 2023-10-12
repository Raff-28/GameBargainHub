package com.rafif.gamebargainhub.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafif.gamebargainhub.MyApplication
import com.rafif.gamebargainhub.core.ui.DealsAdapter
import com.rafif.gamebargainhub.core.ui.ViewModelFactory
import com.rafif.gamebargainhub.databinding.ActivityFavoriteBinding
import com.rafif.gamebargainhub.detail_deal.DetailDealActivity
import javax.inject.Inject

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding

    @Inject
    lateinit var factory: ViewModelFactory
    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Favorite Game Deals"

        val dealsAdapter = DealsAdapter()
        dealsAdapter.onItemClick = { selectedDeal ->
            val intent = Intent(this, DetailDealActivity::class.java)
            intent.putExtra(DetailDealActivity.EXTRA_DATA, selectedDeal)
            startActivity(intent)
        }

        favoriteViewModel.favoriteDeals.observe(this) { deals ->
            dealsAdapter.setData(deals)
            binding.viewEmpty.root.visibility = if (deals.isNotEmpty()) View.GONE else View.VISIBLE
        }

        with(binding.rvDeals) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = dealsAdapter
        }
    }
}