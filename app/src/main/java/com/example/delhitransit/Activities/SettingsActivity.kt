package com.example.delhitransit.Activities

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.EditTextPreference
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
        private var appPreferences : SharedPreferences? = null

        private var routesInitializedToggle: SwitchPreferenceCompat? = null
        private var stopsInitializedToggle: SwitchPreferenceCompat? = null
        private var tripsInitializedToggle: SwitchPreferenceCompat? = null
        private var stopTimesInitializedToggle: SwitchPreferenceCompat? = null
        private var nearbyStopRadiusEditText : EditTextPreference? = null

        private var routes_key: String = ""
        private var stops_key: String = ""
        private var trips_key: String = ""
        private var stop_times_key: String = ""
        private var nearby_stops_range_key : String = ""


        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.preferences_app, rootKey)

            initDbModifierPrefs()
            initAppPreferencePrefs()

        }

        fun initDbModifierPrefs() {

            routes_key = getString(R.string.routes_initialized_key)
            stops_key = getString(R.string.stops_initialized_key)
            trips_key = getString(R.string.trips_initialized_key)
            stop_times_key = getString(R.string.stop_times_initialized_key)

            // Get SharedPreferences that stores the state of the Database
            staticDBPrefs = context?.getSharedPreferences(getString(R.string.database_shared_pref_key), Context.MODE_PRIVATE)

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

        fun initAppPreferencePrefs(){

            nearby_stops_range_key = getString(R.string.nearby_stops_range_key)

            appPreferences = context?.getSharedPreferences(getString(R.string.app_preferences_shared_pref_key), Context.MODE_PRIVATE)

            nearbyStopRadiusEditText = findPreference(nearby_stops_range_key)

            nearbyStopRadiusEditText?.setDefaultValue(appPreferences?.getString(getString(R.string.nearby_stops_range_key), getString(R.string.nearby_stops_range_default_value)))

        }

        override fun onPreferenceChange(preference: Preference?, newValue: Any?): Boolean {

            if (preference != null) {

                when (preference) {
                    routesInitializedToggle -> {
                        val service = AppService.getInstance()
                        val editor = staticDBPrefs?.edit()
                        val b = newValue as Boolean
                        editor?.putBoolean(routes_key, b)
                        editor?.apply()
                        service.modifyDatabaseTable(routes_key, if (b) AppService.TABLE_OPS_INIT else AppService.TABLE_OPS_DROP)
                    }
                    stopsInitializedToggle -> {
                        val service = AppService.getInstance()
                        val editor = staticDBPrefs?.edit()
                        val b = newValue as Boolean
                        editor?.putBoolean(stops_key, b)
                        editor?.apply()
                        service.modifyDatabaseTable(stops_key, if (b) AppService.TABLE_OPS_INIT else AppService.TABLE_OPS_DROP)
                    }
                    tripsInitializedToggle -> {
                        val service = AppService.getInstance()
                        val editor = staticDBPrefs?.edit()
                        val b = newValue as Boolean
                        editor?.putBoolean(trips_key, b)
                        editor?.apply()
                        service.modifyDatabaseTable(trips_key, if (b) AppService.TABLE_OPS_INIT else AppService.TABLE_OPS_DROP)
                    }
                    stopTimesInitializedToggle -> {
                        val service = AppService.getInstance()
                        val b = newValue as Boolean
                        staticDBPrefs?.edit()?.apply {
                            putBoolean(stop_times_key, b)
                            apply()
                        }

                        service.modifyDatabaseTable(stop_times_key, if (b) AppService.TABLE_OPS_INIT else AppService.TABLE_OPS_DROP)
                    }
                    nearbyStopRadiusEditText -> {
                        appPreferences?.edit()?.apply{
                            putString(getString(R.string.nearby_stops_range_key), newValue as String)
                            apply()
                        }
                    }
                }
            }

            return true
        }
    }

}
