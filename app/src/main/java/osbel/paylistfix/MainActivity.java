package osbel.paylistfix;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarFragment;



public class MainActivity extends AppCompatActivity implements Operation.OnFragmentInteractionListener, RestMoney.OnFragmentInteractionListener{

    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomBar(savedInstanceState);
    }
    private void initBottomBar(Bundle savedInstanceState) {
        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.noNavBarGoodness();
        mBottomBar.setFragmentItems(getFragmentManager(), R.id.fragmentContainer,
                new BottomBarFragment(RestMoney.newInstance("",""), R.drawable.ic_friends,"操作"),
                new BottomBarFragment(Operation.newInstance("",""), R.drawable.ic_favorites, "余额"),
                new BottomBarFragment(SettingFragment.newInstance("",""), R.drawable.ic_nearby, "设置")
        );

        // Setting colors for different tabs when there's more than three of them.
        // You can set colors for tabs in three different ways as shown below.
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(1, ContextCompat.getColor(this, R.color.colorPrimary));
        mBottomBar.mapColorForTab(2, ContextCompat.getColor(this, R.color.colorPrimaryDark));
        mBottomBar.setActiveTabColor("#009688");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}