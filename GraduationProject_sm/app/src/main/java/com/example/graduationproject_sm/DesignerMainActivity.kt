package com.example.graduationproject_sm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.graduationproject_sm.fragment.DesignerChattingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.graduationproject_sm.fragment.DesignerHomeFragment
import com.example.graduationproject_sm.fragment.DesignerSettingFragment


class DesignerMainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    lateinit var bottomNavigationView : BottomNavigationView
    lateinit var selectedFragment : Fragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_designer_main)
        title="디자이너 메인 페이지"
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener(this)

        supportFragmentManager.beginTransaction().add(R.id.linearLayout, DesignerHomeFragment()).commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.designer_page_home -> {
                //supportFragmentManager.beginTransaction().replace(R.id.linearLayout , DesignerHomeFragment()).commitAllowingStateLoss()
                selectedFragment = DesignerHomeFragment()
                show(selectedFragment)
            }
            R.id.designer_page_chatting -> {
                //supportFragmentManager.beginTransaction().replace(R.id.linearLayout, DesignerChattingFragment()).commitAllowingStateLoss()
                selectedFragment = DesignerChattingFragment()
                show(selectedFragment)
            }
            R.id.designer_page_setting -> {
                //supportFragmentManager.beginTransaction().replace(R.id.linearLayout, DesignerSettingFragment()).commitAllowingStateLoss()
                selectedFragment = DesignerSettingFragment()
                show(selectedFragment)
            }
        }
        return false
    }

    private fun show(fragment: Fragment) {

        val fragmentManager = supportFragmentManager

        fragmentManager
            .beginTransaction()
            .replace(R.id.linearLayout, fragment)
            .commit()
    }
}