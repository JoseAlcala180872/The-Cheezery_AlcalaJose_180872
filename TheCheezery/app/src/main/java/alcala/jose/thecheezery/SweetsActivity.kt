package alcala.jose.thecheezery

import alcala.jose.thecheezery.ProductosActivity.AdaptadorProductos
import alcala.jose.thecheezery.R.id.listViewSalties
import alcala.jose.thecheezery.R.id.listViewSweets
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SweetsActivity : AppCompatActivity() {
    var sweets = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sweets)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        agregarProlductos()
        var listView: ListView =findViewById(listViewSweets)
        var adaptador: AdaptadorProductos = AdaptadorProductos(this,sweets)
        listView.adapter=adaptador
    }
    fun agregarProlductos(){
        sweets.add(Product("Blueberry cake", R.drawable.blueberrycake,"Vanilla cake flavor, topped with cheese topping and blueberries.", 6.0))
        sweets.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake,"Chocolate cupcakes topped with butter cream and cherries", 3.0))
        sweets.add(Product("Lemon tartalette", R.drawable.lemontartalette,"Pastry shell with a lemon flavored filling", 4.0))
        sweets.add(Product("Red Velvet cake", R.drawable.redvelvetcake,"Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6.0))
        sweets.add(Product("Cherry cheesecake", R.drawable.strawberrycheesecake,"This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7.0))
        sweets.add(Product("Tiramisu", R.drawable.tiramisu,"Coffee-flavored Italian dessert", 6.0))
    }
}