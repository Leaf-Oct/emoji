package cn.leafoct.emoji;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import cn.leafoct.emoji.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
//    该主页基于Android Studio默认模板
//    侧边导航栏
    private AppBarConfiguration mAppBarConfiguration;
//    使用了ViewBinding框架来绑定视图
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        设置页面视图
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        设置顶上标题栏
        setSupportActionBar(binding.appBarMain.toolbar);
//      初始化emoji列表(即将它们从raw文件中写入内存中)
        EmojiList.init(getApplicationContext());
        Toast.makeText(this, "Initilize Completed", Toast.LENGTH_SHORT).show();

//        侧边导航的配置
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        导航项的配置
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_recent, R.id.nav_smile_emotion, R.id.nav_people_body, R.id.nav_animal_nature, R.id.nav_food_drink, R.id.nav_activities, R.id.nav_travel_places, R.id.nav_objects, R.id.nav_symbols, R.id.nav_flags)
                .setOpenableLayout(drawer)
                .build();
//        不同的导航页面
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        绑定
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}