package com.example.delhitransit.database

import android.net.Uri

object BaseContract {
    // Refers to particular application
    val CONTENT_AUTHORITY = "com.example.delhitransit"
    val BASE_CONTENT_URI = Uri.parse("content://$CONTENT_AUTHORITY")

}
