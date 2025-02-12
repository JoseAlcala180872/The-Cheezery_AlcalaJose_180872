package alcala.jose.thecheezery

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductosActivity : AppCompatActivity() {
    var coldDrinks=ArrayList<Product>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        agregarProlductos()
        var listView: ListView=findViewById(R.id.listView)

        var adaptador: AdaptadorProductos= AdaptadorProductos(this,coldDrinks)

        listView.adapter=adaptador


    }

    fun agregarProlductos(){
        coldDrinks.add(Product("Caramel Frap", R.drawable.caramel_frap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.0))
        coldDrinks.add(Product("Chocolate Frap",R.drawable.chocolate_frap,"Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.0))
        coldDrinks.add(Product("Cold Brew",R.drawable.coldbrew,"Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.0))
        coldDrinks.add(Product("Matcha Latte",R.drawable.matcha,"Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.0))
        coldDrinks.add(Product("Oreo Milkshake",R.drawable.oreomilkshake,"Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.0))
        coldDrinks.add(Product("Peanut Milkshake",R.drawable.peanutmilkshake,"Vanilla ice cream, mixed with peanut butter and chocolate.", 7.0))


        /*
        hotDrinks.add(Product(“Hot chocolate”, R.drawable.hotchocolate, “Heated drink consisting of shaved chocolate, topped with marshmallows.”, 5))
        hotDrinks.add(Product(“Espresso”, R.drawable.espresso, “Full-flavored, concentrated form of coffee.”, 4))
        hotDrinks.add(Product(“Chai Latte”, R.drawable.chailatte, “Spiced tea concentrate with milk”, 6))
        hotDrinks.add(Product(“Capuccino”, R.drawable.capuccino, “A cappuccino is an espresso-based coffee drink, prepared with steamed foam.”, 7))
        hotDrinks.add(Product(“American coffee”, R.drawable.americano, “Espresso with hot water”, 2))*/

    }

    class AdaptadorProductos:BaseAdapter{
        var productos=ArrayList<Product>()
        var contexto: Context?=null

        constructor(contexto: Context, productos: ArrayList<Product>){
            this.productos=productos
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = productos[position]
            var inflador=LayoutInflater.from(contexto)
            var vista=inflador.inflate(R.layout.producto_view, null)

            var imagen:ImageView=vista.findViewById(R.id.productoImg)
            var nombre:TextView=vista.findViewById(R.id.productoNombre)
            var descripcion:TextView=vista.findViewById(R.id.productoDescripcion)
            var precio:TextView=vista.findViewById(R.id.productoPrecio)

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            descripcion.setText(prod.description)
            precio.setText("$${prod.price}")

            return vista
        }
    }

}