package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapters.AdapterClickListener
import com.example.myapplication.adapters.ListAdapter
import com.example.myapplication.adapters.PaginationScrollListener
import com.example.myapplication.model.ApiListResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

const val POSITION = "position"
@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel: HomeViewModel by activityViewModels()
    var isLastPage: Boolean = false
    var isLoading: Boolean = false

    private val listAdapter by lazy {
        ListAdapter(object : AdapterClickListener {
            override fun onItemClick(position: Int, value: String) {

                homeViewModel.selectedPositon = position

                NavHostFragment.findNavController(this@HomeFragment)
                    .navigate(R.id.action_details_fragment,Bundle().apply {
                        this.putInt(POSITION, position)
                    })
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        callListApi()
        oberservers()

        rv_list.adapter = listAdapter
    }

    private fun callListApi(){
        homeViewModel.fetchList()
    }

    private fun oberservers(){

        homeViewModel.listResponseData.observe(requireActivity(), Observer {

//            Toast.makeText(requireContext(),"Success",Toast.LENGTH_LONG).show()
            homeViewModel.apiList.addAll(it.result)
            listAdapter.setDataList(homeViewModel.apiList)
        })

        homeViewModel.errorValue.observe(requireActivity(), Observer {

            Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()
        })
    }

}