package osbel.paylistfix;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Log;


public class SettingFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener, Preference.OnPreferenceChangeListener {

    private static final String TAG = "SettingFragment";
    private CheckBoxPreference checkbox;

    public static SettingFragment newInstance(String param1, String param2) {
        SettingFragment fragment = new SettingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferencefragment);
        checkbox = (CheckBoxPreference) findPreference("checkbox_preference");
//        checkbox.setOnPreferenceClickListener(this);
        checkbox.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        if (preference == checkbox) {
            Log.v(TAG, "Checkbox.isCheck =" + checkbox.isChecked());
        }
        return false;
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (preference == checkbox) {
            Log.v(TAG, "Checkbox.isCheck =" + checkbox.isChecked() + " newValue = " + newValue);
            checkbox.setChecked((Boolean) newValue);
        }
        return false;
    }
}
