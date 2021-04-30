package com.example.testone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    List<UserModel> cardlist;
    OnItemClickListener listener;

    public MyAdapter(List<UserModel> cardlist , OnItemClickListener listener){
        this.cardlist = cardlist;
        this.listener =listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_items,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        UserModel card = cardlist.get(position);
        holder.setData(card);
    }

    @Override
    public int getItemCount() {
        return cardlist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name,username, email ,street ,city ,zipcode ,lat ,lon;




        public ViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);
            username = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);
            street = itemView.findViewById(R.id.street);
            city = itemView.findViewById(R.id.city);
            zipcode = itemView.findViewById(R.id.zipcode);
            lat = itemView.findViewById(R.id.lat);
            lon = itemView.findViewById(R.id.lon);

        }

        public void setData(UserModel card) {
            name.setText(card.name.toString());
            username.setText(card.username.toString());
            email.setText(card.email.toString());
            street.setText(card.address.street.toString());
            city.setText(card.address.city.toString());
            zipcode.setText(card.address.zipcode.toString());
            lat.setText(card.address.geo.lat.toString());
            lon.setText(card.address.geo.lng.toString());


                itemView.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {
            int var = getAdapterPosition();
            listener.onItemClick(var);
        }
    }


    interface OnItemClickListener{
        public void onItemClick(int position);
    }




}


/*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_items.view.*


class MyAdapter(var cardlist:List<UserModel>,
private val listener :OnItemClickListener):RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.card_items,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = cardlist[position]

        holder.setData(card)
    }

    override fun getItemCount(): Int {
        return cardlist.size
    }

  inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener{

        fun setData(card:UserModel){
            itemView.name.text = card.name
            itemView.username.text = card.username
            itemView.email.text = card.email
            itemView.street.text = card.address.street
            itemView.city.text = card.address.city
            itemView.zipcode.text = card.address.zipcode
            itemView.lat.text = card.address.geo.lat
            itemView.lon.text = card.address.geo.lng

        }

        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            var vara =adapterPosition

          listener.onItemClick(vara)
        }

    }

    interface OnItemClickListener{
        fun onItemClick(position:Int)
    }

}
 */