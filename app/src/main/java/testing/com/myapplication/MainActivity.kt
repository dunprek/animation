package testing.com.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import android.text.method.TextKeyListener.clear
import android.R.id.edit
import android.content.SharedPreferences
import android.os.Handler
import android.widget.ImageButton
import android.graphics.drawable.StateListDrawable
import android.view.View.GONE


class MainActivity : BaseActivity(), View.OnClickListener {


    var doubleBackToExitPressedOnce = false
    val gridPressed: Boolean = false
    val listPressed: Boolean = false


    //declare list  menu item which is changing with grid item
    private lateinit var list: MenuItem

    //declare grid  menu item which is changing with list item
    private lateinit var grid: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        val tvBlackWhite = findViewById<TextView>(R.id.tv_black_and_white)
        tvBlackWhite.setOnClickListener(this)

        val tvGraphicArt = findViewById<TextView>(R.id.tv_graphic_art)
        tvGraphicArt.setOnClickListener(this)

        val tvCopyCenter = findViewById<TextView>(R.id.tv_copy_center)
        tvCopyCenter.setOnClickListener(this)

        tvBlackWhite.isSelected = false
        tvBlackWhite.isPressed = false
        tvGraphicArt.isSelected = false
        tvGraphicArt.isPressed = false
        tvCopyCenter.isSelected = false
        tvCopyCenter.isPressed = false


        val ibPrinterClose = findViewById<ImageButton>(R.id.ib_printer_close)
        val ibPrinterSearch = findViewById<ImageButton>(R.id.ib_printer_search)
        ibPrinterClose.setOnClickListener(this)
        ibPrinterSearch.setOnClickListener(this)


        //SET DEFAULT STATE FOR LAYOUT SEARCH TO GONE
        layout_test.visibility = View.GONE

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
            R.id.action_grid -> {
                toast("GRID PRESSED")
                list.isVisible = true
                grid.isVisible = false

                return true
            }

            R.id.action_list -> {
                toast("LIST  PRESSED")
                list.isVisible = false
                grid.isVisible = true

                return true
            }

            R.id.action_search -> {
                toast("Search")
                toolbar.visibility = View.GONE
                val slideUp = AnimationUtils.loadAnimation(this, R.anim.frag_slide_out)

                if (layout_test.visibility == View.GONE) {
                    layout_test.visibility = View.VISIBLE
                    layout_test.startAnimation(slideUp)
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


    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        grid = menu.findItem(R.id.action_grid)
        list = menu.findItem(R.id.action_list)
        grid.isVisible = true
        list.isVisible = false
        return true

    }

    private fun toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    override fun onClick(view: View) {
        // clear state
        when (view.id) {
            R.id.tv_black_and_white -> {
                if (tv_black_and_white.isSelected) {
                    tv_black_and_white.isSelected = false
                    tv_black_and_white.setTextColor(resources.getColor(R.color.colorTransparent))

                } else {
                    tv_black_and_white.isSelected = true
                    tv_black_and_white.setTextColor(resources.getColor(R.color.colorWhite))
                }
            }
/////////////////////////////////////////////////////////////
            R.id.tv_colored -> {
                if (tv_colored.isSelected) {
                    tv_colored.isSelected = false
                    tv_colored.setTextColor(resources.getColor(R.color.colorTransparent))

                } else {
                    tv_colored.isSelected = true
                    tv_colored.setTextColor(resources.getColor(R.color.colorWhite))

                }
            }
//////////////////////////////////////////////////////////////
            R.id.tv_graphic_art -> {
                if (tv_graphic_art.isSelected) {
                    tv_graphic_art.isSelected = false
                    tv_graphic_art.setTextColor(resources.getColor(R.color.colorTransparent))

                } else {
                    tv_graphic_art.isSelected = true
                    tv_graphic_art.setTextColor(resources.getColor(R.color.colorWhite))

                }

            }

/////////////////////////////////////////////////////////////
            R.id.tv_copy_center -> {
                if (tv_copy_center.isSelected) {
                    tv_copy_center.isSelected = false
                    tv_copy_center.setTextColor(resources.getColor(R.color.colorTransparent))

                } else {
                    tv_copy_center.isSelected = true
                    tv_copy_center.setTextColor(resources.getColor(R.color.colorWhite))


                }
            }
////////////////////////////////////////////////////////////
            R.id.tv_office_printer -> {
                if (tv_office_printer.isSelected) {
                    tv_office_printer.isSelected = false
                    tv_office_printer.setTextColor(resources.getColor(R.color.colorTransparent))

                } else {
                    tv_office_printer.isSelected = true
                    tv_office_printer.setTextColor(resources.getColor(R.color.colorWhite))
                }
            }
////////////////////////////////////////////////////////////
            R.id.ib_printer_close -> {
                if (toolbar.visibility == View.GONE) {
                    toolbar.visibility = View.VISIBLE
                    layout_test.visibility = View.GONE
                }
            }
        }
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        toast(resources.getString(R.string.app_name))
        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }

}



