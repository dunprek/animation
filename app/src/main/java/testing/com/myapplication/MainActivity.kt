package testing.com.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // slide-up animation
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                toast("Settings")
                return true
            }
            R.id.action_search -> {
                toast("Search")
                toolbar.visibility = View.GONE
                val slideUp = AnimationUtils.loadAnimation(this, R.anim.frag_slide_out)

                if (layout_test.getVisibility() == View.GONE) {
                    layout_test.setVisibility(View.VISIBLE);
                    layout_test.startAnimation(slideUp);
                }
//                if(isPressed) layout_testing.visibility = View.VISIBLE
                return true

            }
            R.id.action_clip -> {
                toast("Clip")
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

}


