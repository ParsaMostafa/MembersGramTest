package com.example.membersgramtest.ui.fragment
import MyMemberViewmodel
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.membersgramtest.R
import com.example.membersgramtest.adaptor.AdaptorMyMembers
import com.example.membersgramtest.models.MyMemberModel.MyMemberModel
import com.example.membersgramtest.ui.layout.FragmentMyMemberLayOut

class MyMemberFragment :  Fragment() {

    lateinit var fragmentMyMemberLayOut: FragmentMyMemberLayOut

    private val viewModel: MyMemberViewmodel by viewModels()
    private val adapter = AdaptorMyMembers()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMyMemberLayOut = FragmentMyMemberLayOut(requireContext())
        return fragmentMyMemberLayOut
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up RecyclerView with the adapter
        fragmentMyMemberLayOut.recyclerViewMyMembers.layoutManager = LinearLayoutManager(requireContext())
        fragmentMyMemberLayOut.recyclerViewMyMembers.adapter = adapter

        // تنظیم OnClickListener برای Adapter
        adapter.onItemClick = { selectedItem ->
            Log.d("Cyberwolf", selectedItem.toString())
            when (selectedItem) {
                is MyMemberModel.MyMemberBodyModel -> {
                    // بر اساس selectedItem.title یا هر مشخصه دیگری می‌توانید ناوبری را انجام دهید

                    when (selectedItem.title) {
                        "Payments" -> {

                            val transaction = requireActivity().supportFragmentManager.beginTransaction()
                            transaction.replace(R.id.nav_host_fragment, PaymentFragment())
                            transaction.addToBackStack("MyMemberFragment" ) // Add to back stack
                            transaction.commit()

                        }
                        "Support" -> {
                            // انجام ناوبری مرتبط با Support
                            // مثال:
                            //  Navigation.findNavController(view).navigate(R.id.supportFragment)
                        }

                    }
                }
                // اگر نیاز به انجام عملیاتی برای دیگر آیتم‌ها دارید، مشابها برای آن‌ها نیز عمل کنید.

                else -> {}
            }
        }

        // Observe the data from the view model
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.TabMyMemberList.collect { memberList ->
                Log.d("CyberWolf", memberList.toString())
                // Update the UI with the new data
                adapter.submitList(memberList)
            }
        }

        // Trigger the data creation in the view model
        viewModel.createListOfMyMemberTab()
    }
}
