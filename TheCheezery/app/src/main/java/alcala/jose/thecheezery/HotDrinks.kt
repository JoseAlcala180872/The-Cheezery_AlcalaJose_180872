package alcala.jose.thecheezery

import alcala.jose.thecheezery.ProductosActivity.AdaptadorProductos
import alcala.jose.thecheezery.R.id.listView
import alcala.jose.thecheezery.R.id.listViewHot
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HotDrinks : AppCompatActivity() {
    var hotDrinks = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hot_drinks)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        agregarProlductos()
        var listView: ListView =findViewById(listViewHot)
        var adaptador: AdaptadorProductos = AdaptadorProductos(this,hotDrinks)
        listView.adapter=adaptador
    }

    fun agregarProlductos(){
        hotDrinks.add(Product("Latte", R.drawable.latte,"Coffee drink made with espresso and steamed milk", 6.0))
        hotDrinks.add(Product("Hot chocolate", R.drawable.hotchocolate,"Heated drink consisting of shaved chocolate, topped with marshmallows.",5.0))
        hotDrinks.add(Product("Espresso", R.drawable.espresso,"Full-flavored, concentrated form of coffee.", 4.0))
        hotDrinks.add(Product("Chai Latte", R.drawable.chailatte,"Spiced tea concentrate with milk", 6.0))
        hotDrinks.add(Product("Capuccino", R.drawable.capuccino,"A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.0))
        hotDrinks.add(Product("American coffee", R.drawable.americano,"Espresso with hot water", 2.0))
    }
}