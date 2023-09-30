package ru.bz.mobile.navigationdrawingapi25

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var navigationDrawingLayout: DrawerLayout
    private lateinit var navigationDrawingView: NavigationView
    private lateinit var navigationDrawingToggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationDrawingLayout = findViewById(R.id.navigation_drawing_layout)
        navigationDrawingView = findViewById(R.id.navigation_drawing_view)
        navigationDrawingToggle = ActionBarDrawerToggle(this, navigationDrawingLayout,R.string.open_navigation_drawer, R.string.close_navigation_drawing)
        navigationDrawingLayout.addDrawerListener(navigationDrawingToggle)
        navigationDrawingToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationDrawingView.setNavigationItemSelectedListener(this)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (navigationDrawingToggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (navigationDrawingLayout.isDrawerOpen(GravityCompat.START)){
            navigationDrawingLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        when (item.itemId) {

            R.id.home -> {
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
            }

            R.id.settings -> {
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
            }
        }

        navigationDrawingLayout.closeDrawer(GravityCompat.START)
        return true
    }
}