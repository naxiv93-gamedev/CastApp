package ivan.diaz.dominguez.castingapp.ui
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ivan.diaz.dominguez.castingapp.R
import ivan.diaz.dominguez.castingapp.model.api.Post
import kotlinx.android.synthetic.main.actor_item_list.view.*

class ActorListAdapter(): RecyclerView.Adapter<ActorListAdapter.SearchViewHolder>() {
    var actorList: List<Post> = emptyList<Post>()

    fun setData(list: List<Post>){
        actorList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.actor_item_list, parent,false))
    }

    override fun getItemCount(): Int {
        return actorList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val actor = actorList[position]
        holder.itemView.idActor.text = "id: ${actor.id}"
        holder.itemView.nameActor.text = "Name: ${actor.name}"
        holder.itemView.genderActor.text = "Gender: ${actor.gender}"
        holder.itemView.ageActor.text = "Age: ${actor.age}"
        holder.itemView.hairColorActor.text = "Hair Color: ${actor.hair_color}"
        holder.itemView.eyeColorActor.text = "Eye Color: ${actor.eye_color}"
        holder.itemView.checkBox.isChecked = false

        holder.itemView.setOnClickListener {
            it.checkBox.isChecked = !it.checkBox.isChecked
            actorList[position].checked = it.checkBox.isChecked
        }
        holder.itemView.checkBox.setOnClickListener{
            actorList[position].checked = it.checkBox.isChecked
            println(actorList[position].checked)
        }
    }

    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}