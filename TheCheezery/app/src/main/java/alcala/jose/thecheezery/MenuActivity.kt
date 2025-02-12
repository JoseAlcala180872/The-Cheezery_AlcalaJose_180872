package alcala.jose.thecheezery

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btnCold:Button=findViewById(R.id.button_cold_drinks)
        var btnHot:Button=findViewById(R.id.button_hot_drinks)
        var btnSalties:Button=findViewById(R.id.button_salties)
        var btnSweets:Button=findViewById(R.id.button_sweets)

        btnCold.setOnClickListener {
            var intent:Intent= Intent(this, ProductosActivity::class.java)
            startActivity(intent)
        }

        btnHot.setOnClickListener {
            var intent:Intent=Intent(this, HotDrinks::class.java)
            startActivity(intent)
        }

        btnSalties.setOnClickListener {
            var intent:Intent=Intent(this, SaltiesActivity::class.java)
            startActivity(intent)
        }

        btnSweets.setOnClickListener {
            var intent:Intent=Intent(this, SweetsActivity::class.java)
            startActivity(intent)
        }
    }
}