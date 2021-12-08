package duran_guerrero.rutilio.rickymorty

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickymorty.R
import com.squareup.picasso.Picasso


class PersonajeAdapter(ctx: Context, listaPersonajes: List<Personaje>): RecyclerView.Adapter<PersonajeAdapter.PersonajesVH>() {
    lateinit var ctx:Context
    lateinit var personajesList:List<Personaje>

    init {
        this.ctx = ctx
        this.personajesList = listaPersonajes
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajesVH {
        val vistaPersonaje = LayoutInflater.from(ctx).inflate(R.layout.card_personaje,parent,false)
        val viewHolderPersonaje = PersonajesVH(vistaPersonaje)
        vistaPersonaje.tag = viewHolderPersonaje
        return viewHolderPersonaje
    }

    override fun onBindViewHolder(holder: PersonajesVH, position: Int) {
        holder.tvNom.text = personajesList[position].nombre
        holder.tvLocacion.text = personajesList[position].UltimaLocacion
        Picasso.get()
            .load(personajesList[position].imagen)
            .into(holder.ivImagen);
    }

    override fun getItemCount(): Int {
        return this.personajesList!!.size
    }

    class PersonajesVH(vistaIndividual: View):RecyclerView.ViewHolder(vistaIndividual){
        lateinit var ivImagen:ImageView
        lateinit var tvNom:TextView
        lateinit var tvLocacion:TextView

        init {
            ivImagen = vistaIndividual.findViewById(R.id.ivFoto)
            tvNom = vistaIndividual.findViewById(R.id.tvNombre)
            tvLocacion = vistaIndividual.findViewById(R.id.tvLocacion)
        }
    }
}