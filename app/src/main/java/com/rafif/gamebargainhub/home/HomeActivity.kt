package com.rafif.gamebargainhub.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafif.gamebargainhub.R
import com.rafif.gamebargainhub.core.data.source.Resource
import com.rafif.gamebargainhub.core.ui.DealsAdapter
import com.rafif.gamebargainhub.databinding.ActivityHomeBinding
import com.rafif.gamebargainhub.detail_deal.DetailDealActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Game Deals"

        val dealsAdapter = DealsAdapter()
        dealsAdapter.onItemClick = { selectedDeal ->
            val intent = Intent(this, DetailDealActivity::class.java)
            intent.putExtra(DetailDealActivity.EXTRA_DATA, selectedDeal)
            startActivity(intent)
        }

        homeViewModel.deals.observe(this) { deals ->
            if (deals != null) {
                when (deals) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        dealsAdapter.setData(deals.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.viewError.root.visibility = View.VISIBLE
                        binding.viewError.tvError.text =
                            deals.message ?: getString(R.string.something_wrong)
                    }
                }
            }
        }

        with(binding.rvDeals) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = dealsAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_favorite -> {
                val uri = Uri.parse("gamebargainhub://favorite")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
                return super.onOptionsItemSelected(item)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}