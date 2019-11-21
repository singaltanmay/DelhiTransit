package com.example.delhitransit.Activities

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat
import com.example.delhitransit.R



class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }

    class AppSettingsFragment : PreferenceFragmentCompat(), Preference.OnPreferenceChangeListener {

        private var staticDBPrefs: SharedPreferences? = null

        private var routesInitializedToggle: SwitchPreferenceCompat? = null
        private var stopsInitializedToggle: SwitchPreferenceCompat? = null
        private var tripsInitializedToggle: SwitchPreferenceCompat? = null
        private var stopTimesInitializedToggle: SwitchPreferenceCompat? = null

        private var routes_key: String = ""
        private var stops_key: String = ""
        private var trips_key: String = ""
        private var stop_times_key: String = ""


        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.preferences_app, rootKey)
            initPrefs()

        }

        fun initPrefs() {

            routes_key = getString(R.string.routes_initialized_key)
            stops_key = getString(R.string.stops_initialized_key)
            trips_key = getString(R.string.trips_initialized_key)
            stop_times_key = getString(R.string.stop_times_initialized_key)

            // Get SharedPreferences that stores the state of the Database
            staticDBPrefs = context?.getSharedPreferences(AppService.DATABASE_SHARED_PREF_KEY, Context.MODE_PRIVATE)

            routesInitializedToggle = findPreference(routes_key)
            stopsInitializedToggle = findPreference(stops_key)
            tripsInitializedToggle = findPreference(trips_key)
            stopTimesInitializedToggle = findPreference(stop_times_key)

            routesInitializedToggle?.isChecked = staticDBPrefs?.getBoolean(routes_key, false)!!
            stopsInitializedToggle?.isChecked = staticDBPrefs?.getBoolean(stops_key, false)!!
            tripsInitializedToggle?.isChecked = staticDBPrefs?.getBoolean(trips_key, false)!!
            stopTimesInitializedToggle?.isChecked = staticDBPrefs?.getBoolean(stop_times_key, false)!!

            routesInitializedToggle?.onPreferenceChangeListener = this
            stopsInitializedToggle?.onPreferenceChangeListener = this
            tripsInitializedToggle?.onPreferenceChangeListener = this
            stopTimesInitializedToggle?.onPreferenceChangeListener = this

        }

        override fun onPreferenceChange(preference: Preference?, newValue: Any?): Boolean {

            if (preference != null) {

                val service = AppService.getInstance()

                when (preference) {
                    routesInitializedToggle -> {
                        val editor = staticDBPrefs?.edit()
                        val b = newValue as Boolean
                        editor?.putBoolean(routes_key, b)
                        editor?.apply()
                        service.modifyDatabaseTable(routes_key, if (b) AppService.TABLE_OPS_INIT else AppService.TABLE_OPS_DROP)
                    }
                    stopsInitializedToggle -> {
                        val editor = staticDBPrefs?.edit()
                        val b = newValue as Boolean
                        editor?.putBoolean(stops_key, b)
                        editor?.apply()
                        service.modifyDatabaseTable(stops_key, if (b) AppService.TABLE_OPS_INIT else AppService.TABLE_OPS_DROP)
                    }
                    tripsInitializedToggle -> {
                        val editor = staticDBPrefs?.edit()
                        val b = newValue as Boolean
                        editor?.putBoolean(trips_key, b)
                        editor?.apply()
                        service.modifyDatabaseTable(trips_key, if (b) AppService.TABLE_OPS_INIT else AppService.TABLE_OPS_DROP)
                    }
                    stopTimesInitializedToggle -> {
                        val editor = staticDBPrefs?.edit()
                        val b = newValue as Boolean
                        editor?.putBoolean(stop_times_key, b)
                        editor?.apply()
                        service.modifyDatabaseTable(stop_times_key, if (b) AppService.TABLE_OPS_INIT else AppService.TABLE_OPS_DROP)
                    }
                }
            }

            return true
        }
    }

}
