package com.example.membersgramtest.utillity



object CryptUtil {

    private const val PASSWORD = "#GV^%^SUR&T*#Y*4"
    private val key = CryptLib.SHA256(PASSWORD, 32)

    fun encrypt(string: String): String {
        val crypt = CryptLib()
        return crypt.encrypt(string, key, PASSWORD).replace("\n", "")
    }

    fun decrypt(string: String): String {
        val crypt = CryptLib()
        return crypt.decrypt(string, key, PASSWORD)
    }

}