package antoniocappiello.com.viewpagerwithcustomscroller;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.LinearInterpolator;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private static final int SCROLL_DURATION = 600; // time in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager mPager = (ViewPager) findViewById(R.id.pager); // The pager widget which allows swiping horizontally
        setCustomScrollerToViewPager(mPager);

        PagerAdapter mAdapter = new DemoPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);

    }

    private void setCustomScrollerToViewPager(ViewPager mPager) {
        try {
            CustomScroller customScroller = new CustomScroller(this, new LinearInterpolator(), SCROLL_DURATION);
            Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            mScroller.set(mPager, customScroller);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
