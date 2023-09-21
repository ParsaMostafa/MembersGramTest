import android.content.Context
import android.content.SharedPreferences

object Prefnumber {
    private const val PREFS_NAME = "MyAppPreferences"
    private const val PHONE_NUMBER_KEY = "phoneNumber"

    fun savePhoneNumber(context: Context, phoneNumber: String) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(PHONE_NUMBER_KEY, phoneNumber)
        editor.apply()
    }

    fun getPhoneNumber(context: Context): String? {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getString(PHONE_NUMBER_KEY, null)
    }
}
