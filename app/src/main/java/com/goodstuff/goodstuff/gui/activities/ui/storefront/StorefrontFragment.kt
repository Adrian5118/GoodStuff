package com.goodstuff.goodstuff.gui.activities.ui.storefront

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.goodstuff.goodstuff.databinding.FragmentStorefrontBinding
import com.goodstuff.goodstuff.lib.Product
import com.goodstuff.goodstuff.lib.ProductAdapter

class StorefrontFragment : Fragment() {

    private var _binding: FragmentStorefrontBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val storefrontViewModel =
            ViewModelProvider(this).get(StorefrontViewModel::class.java)

        _binding = FragmentStorefrontBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView: RecyclerView = binding.productRecyclerView
        val recyclerDataArrayList: ArrayList<Product> = arrayListOf<Product>()

        val adapter: ProductAdapter = ProductAdapter(recyclerDataArrayList, {(product) -> });

        val layoutManager: GridLayoutManager = GridLayoutManager(activity, 3);

        storefrontViewModel.products.observe(viewLifecycleOwner) {
            recyclerDataArrayList.addAll(it)
        }

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}