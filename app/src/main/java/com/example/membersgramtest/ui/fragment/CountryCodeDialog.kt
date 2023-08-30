package com.example.membersgramtest.ui.fragment
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Filter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import com.example.membersgramtest.R

class CountryCodeDialog(
    context: Context,
    private val countryCodeListener: OnCountryCodeSelectedListener
) : Dialog(context) {

    private lateinit var searchEditText: EditText
    private lateinit var countryListView: ListView
    private var originalCountries: Array<Country> = emptyArray()
    private var filteredCountries: Array<Country> = emptyArray()

    interface OnCountryCodeSelectedListener {
        fun onCountryCodeSelected(countryCode: String)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_country_code)

        searchEditText = findViewById(R.id.searchEditText)
        countryListView = findViewById(R.id.countryListView)

        originalCountries = arrayOf(
            Country("+20", "Egypt"),
            Country("+27", "South Africa"),
            Country("+30", "Greece"),
            Country("+31", "Netherlands"),
            Country("+32", "Belgium"),
            Country("+33", "France"),
            Country("+34", "Spain"),
            Country("+36", "Hungary"),
            Country("+39", "Italy"),
            Country("+40", "Romania"),
            Country("+41", "Switzerland"),
            Country("+43", "Austria"),
            Country("+44", "United Kingdom"),
            Country("+45", "Denmark"),
            Country("+46", "Sweden"),
            Country("+47", "Norway"),
            Country("+48", "Poland"),
            Country("+49", "Germany"),
            Country("+51", "Peru"),
            Country("+52", "Mexico"),
            Country("+53", "Cuba"),
            Country("+54", "Argentina"),
            Country("+55", "Brazil"),
            Country("+56", "Chile"),
            Country("+57", "Colombia"),
            Country("+58", "Venezuela"),
            Country("+60", "Malaysia"),
            Country("+61", "Australia"),
            Country("+62", "Indonesia"),
            Country("+63", "Philippines"),
            Country("+64", "New Zealand"),
            Country("+65", "Singapore"),
            Country("+66", "Thailand"),
            Country("+81", "Japan"),
            Country("+82", "South Korea"),
            Country("+84", "Vietnam"),
            Country("+86", "China"),
            Country("+90", "Turkey"),
            Country("+91", "India"),
            Country("+92", "Pakistan"),
            Country("+93", "Afghanistan"),
            Country("+94", "Sri Lanka"),
            Country("+95", "Myanmar"),
            Country("+98", "Iran"),
            Country("+212", "Morocco"),
            Country("+213", "Algeria"),
            Country("+234", "Nigeria"),
            Country("+254", "Kenya"),
            Country("+255", "Tanzania"),
            Country("+256", "Uganda"),
            Country("+260", "Zambia"),
            Country("+263", "Zimbabwe"),
            Country("+972", "Israel")

        )

        filteredCountries = originalCountries

        val filter = object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filteredList = if (constraint.isNullOrEmpty()) {
                    originalCountries.toList()
                } else {
                    originalCountries.filter { it.countryName.contains(constraint, true) }
                }

                val results = FilterResults()
                results.values = filteredList
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredCountries = results?.values as? Array<Country> ?: emptyArray()
                (countryListView.adapter as? ArrayAdapter<*>)?.notifyDataSetChanged()
            }
        }

        val adapter = CountryAdapter(context, originalCountries.toList())
        countryListView.adapter = adapter

        countryListView.setOnItemClickListener { _, _, position, _ ->
            val countryCode = (adapter.getItem(position) as Country).countryCode
            countryCodeListener.onCountryCodeSelected(countryCode)
            dismiss()
        }

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter(s)
            }
            override fun afterTextChanged(s: Editable?) {}
        })

    }
}


data class Country(val countryCode: String, val countryName: String) {
    val formattedName: String
        get() = "$countryName ($countryCode)"
}

