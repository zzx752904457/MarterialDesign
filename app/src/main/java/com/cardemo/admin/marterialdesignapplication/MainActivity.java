package com.cardemo.admin.marterialdesignapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private ShareActionProvider mShareActionProvider;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private ViewPager mViewPager;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            // 设置状态栏颜色
            window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg1));
            window.setNavigationBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg1));
        }

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        // toolbar.setLogo(R.drawable.ic_launcher);
        mToolbar.setTitle("主标题");// 标题的文字需在setSupportActionBar之前，不然会无效
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setSubtitle("副标题");
        mToolbar.setSubtitleTextColor(Color.WHITE);
//        mToolbar.setLogo(R.mipmap.ic_launcher);
//        这些通过ActionBar来设置也是一样的，注意要在setSupportActionBar(toolbar);之后，不然就报错了
        setSupportActionBar(mToolbar);
//        getSupportActionBar().setTitle("标题");
//        getSupportActionBar().setSubtitle("副标题");
//        getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        /**
         * 菜单的监听可以在toolbar里设置，也可以像ActionBar那样，通过Activity的onOptionsItemSelected回调方法来处理
         */
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_settings:
                        Toast.makeText(MainActivity.this, "action_settings", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_share:
                        Toast.makeText(MainActivity.this, "action_share", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        /**
         * 设置侧滑按钮
         */
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mPagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mPagerSlidingTabStrip.setViewPager(mViewPager);
        mPagerSlidingTabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                switch (arg0){
                    case 0:
                        mPagerSlidingTabStrip.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.bg1));
                        mToolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.bg1));
                        if (android.os.Build.VERSION.SDK_INT >= 21) {
                            Window window = getWindow();
                            // 很明显，这两货是新API才有的。
                            window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg1));
                            window.setNavigationBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg1));
                        }
                        break;
                    case 1:
                        mPagerSlidingTabStrip.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.bg2));
                        mToolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.bg2));
                        if (android.os.Build.VERSION.SDK_INT >= 21) {
                            Window window = getWindow();
                            // 很明显，这两货是新API才有的。
                            window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg2));
                            window.setNavigationBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg2));
                        }
                        break;
                    case 2:
                        mPagerSlidingTabStrip.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.bg3));
                        mToolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.bg3));
                        if (android.os.Build.VERSION.SDK_INT >= 21) {
                            Window window = getWindow();
                            // 很明显，这两货是新API才有的。
                            window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg3));
                            window.setNavigationBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg3));
                        }
                        break;
                    case 3:
                        mPagerSlidingTabStrip.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.bg4));
                        mToolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.bg4));
                        if (android.os.Build.VERSION.SDK_INT >= 21) {
                            Window window = getWindow();
                            // 很明显，这两货是新API才有的。
                            window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg4));
                            window.setNavigationBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg4));
                        }
                        break;
                    case 4:
                        mPagerSlidingTabStrip.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.bg5));
                        mToolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.bg5));
                        if (android.os.Build.VERSION.SDK_INT >= 21) {
                            Window window = getWindow();
                            // 很明显，这两货是新API才有的。
                            window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg5));
                            window.setNavigationBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg5));
                        }
                        break;
                    case 5:
                        mPagerSlidingTabStrip.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.bg6));
                        mToolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.bg6));
                        if (android.os.Build.VERSION.SDK_INT >= 21) {
                            Window window = getWindow();
                            // 很明显，这两货是新API才有的。
                            window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg6));
                            window.setNavigationBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg6));
                        }
                        break;
                    case 6:
                        mPagerSlidingTabStrip.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.bg7));
                        mToolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.bg7));
                        if (android.os.Build.VERSION.SDK_INT >= 21) {
                            Window window = getWindow();
                            // 很明显，这两货是新API才有的。
                            window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg7));
                            window.setNavigationBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg7));
                        }
                        break;
                    case 7:
                        mPagerSlidingTabStrip.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.bg8));
                        mToolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.bg8));
                        if (android.os.Build.VERSION.SDK_INT >= 21) {
                            Window window = getWindow();
                            // 很明显，这两货是新API才有的。
                            window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg8));
                            window.setNavigationBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg8));
                        }
                        break;

                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        initTabsValue();

    }

    /**
     * mPagerSlidingTabStrip默认值配置
     *
     */
    private void initTabsValue() {
        // 底部游标颜色
        mPagerSlidingTabStrip.setIndicatorColor(Color.WHITE);
        // tab的分割线颜色
        mPagerSlidingTabStrip.setDividerColor(Color.WHITE);
        // tab背景
        mPagerSlidingTabStrip.setBackgroundColor(Color.parseColor("#6633B5E5"));
        // tab底线高度
        mPagerSlidingTabStrip.setUnderlineHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                1, getResources().getDisplayMetrics()));
        // 游标高度
        mPagerSlidingTabStrip.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                2, getResources().getDisplayMetrics()));
        // 选中的文字颜色
        mPagerSlidingTabStrip.setSelectedTextColor(Color.WHITE);
//        // 选中的文字大小
//        mPagerSlidingTabStrip.setSelectedTabTextSize(80);
//        // 正常的字体大小
//        mPagerSlidingTabStrip.setTextSize(30);
        // 正常文字颜色
        mPagerSlidingTabStrip.setTextColor(Color.BLACK);
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = { "分类", "主页", "热门推荐", "热门收藏", "本月热榜", "今日热榜", "专栏", "随机" };

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            return SuperAwesomeCardFragment.newInstance(position);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
		/* ShareActionProvider配置 */
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menu
                .findItem(R.id.action_share));
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        mShareActionProvider.setShareIntent(intent);
        return super.onCreateOptionsMenu(menu);
    }
}
