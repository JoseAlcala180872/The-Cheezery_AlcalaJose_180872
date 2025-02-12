package alcala.jose.thecheezery

import alcala.jose.thecheezery.ProductosActivity.AdaptadorProductos
import alcala.jose.thecheezery.R.id.listViewHot
import alcala.jose.thecheezery.R.id.listViewSalties
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SaltiesActivity : AppCompatActivity() {
    var salties = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_salties)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        agregarProlductos()
        var listView: ListView =findViewById(listViewSalties)
        var adaptador: AdaptadorProductos = AdaptadorProductos(this,salties)
        listView.adapter=adaptador
    }
    fun agregarProlductos(){
        salties.add(Product("Chicken crepes", R.drawable.chickencrepes,"Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6.0))
        salties.add(Product("Club Sandwich", R.drawable.clubsandwich,"A delicious sandwich served with french fries.", 5.0))
        salties.add(Product("Panini", R.drawable.hampanini,"Sandwich made with Italian bread  served warmed by grilling.", 4.0))
        salties.add(Product("Philly cheese steak", R.drawable.phillycheesesteak,"Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6.0))
        salties.add(Product("Nachos", R.drawable.nachos,"Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.", 7.0))
    }
}