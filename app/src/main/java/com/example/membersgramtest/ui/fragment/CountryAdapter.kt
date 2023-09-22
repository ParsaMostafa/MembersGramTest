package com.example.membersgramtest.ui.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CountryAdapter(context: Context, private val countries: List<Country>) : BaseAdapter() {
    private val inflater = LayoutInflater.from(context)
    private var filteredCountries: List<Country> = countries

    override fun getCount(): Int = filteredCountries.size
    override fun getItem(position: Int): Any = filteredCountries[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        val country = getItem(position) as Country
        (view as TextView).text = country.formattedName
        return view
    }

    fun filter(constraint: CharSequence?) {
        filteredCountries = if (constraint.isNullOrEmpty()) {
            countries
        } else {
            countries.filter { it.contains(constraint) }
        }
        notifyDataSetChanged()
    }
}
