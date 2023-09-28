import androidx.lifecycle.ViewModel
import com.example.membersgramtest.R
import com.example.membersgramtest.models.MyMemberModel.MyMemberModel
import com.example.membersgramtest.sharedPerf.PreferencesHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MyMemberViewmodel : ViewModel() {
    val TabMyMemberList = MutableStateFlow<List<MyMemberModel>>(emptyList())

    fun createListOfMyMemberTab() {
        val preferencesHelper = PreferencesHelper
        val phoneNumber = preferencesHelper.phoneNumber

        val MyMemberModelItems = mutableListOf<MyMemberModel>()

        MyMemberModelItems.add(
            MyMemberModel.MyMemberHeaderModel(
                R.drawable.person_black_24dp__1_,
                "Borzoe Bastae",
                phoneNumber
            )
        )

        MyMemberModelItems.add(
            MyMemberModel.MyMemberBodyModel(
                R.drawable.payment_black_24dp, "Payments",
                false
            )
        )
        MyMemberModelItems.add(
            MyMemberModel.MyMemberBodyModel(
            R.drawable.ic_support, "Support",
                false
            )
        )
        MyMemberModelItems.add(
            MyMemberModel.MyMemberBodyModel(
                R.drawable.settings_24px, "Settings",
                false
            )
        )
        MyMemberModelItems.add(
            MyMemberModel.MyMemberBodyModel(
                R.drawable.logout_black_24dp, "Log out",
                true
            )
        )

        MyMemberModelItems.add(MyMemberModel.MyMemberFooterModel)

        // Create a coroutine scope and emit the MyMemberModelItems within it
        CoroutineScope(Dispatchers.IO).launch {
            TabMyMemberList.emit(MyMemberModelItems)
        }
    }
}
