package com.firmanjabar.submission2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Movie> mData;

    public RecyclerViewAdapter ( Context mContext ) {
        this.mContext = mContext;
    }

    public ArrayList<Movie> getmData () {
        return mData;
    }

    public void setmData ( ArrayList<Movie> mData ) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_view_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Movie movies = getmData().get(i);
        myViewHolder.tvTitle.setText(movies.getTitle());
        myViewHolder.tvYear.setText(movies.getYear());
//        myViewHolder.tvDesc.setText(movies.getDescription());
//        myViewHolder.tvDirect.setText(movies.getDirector());
//        myViewHolder.tvActor.setText(movies.getActor());
        myViewHolder.imgBD.setImageResource(movies.getImgBD());
        Glide
                .with(mContext)
                .load(getmData().get(i).getImgBD())
                .apply(new RequestOptions().override(833, 600))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(myViewHolder.imgBD);
//        myViewHolder.imgActor.setImageResource(movies.getImgActor());
//        myViewHolder.imgBD.setImageResource(movies.getImgBD());
    }

    @Override
    public int getItemCount() {
        return getmData().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle, tvYear, tvDesc, tvDirect, tvActor;
        ImageView imgPoster, imgActor, imgBD;

        public MyViewHolder(View view){
            super(view);

            tvTitle = (TextView) itemView.findViewById(R.id.title);
            tvYear = (TextView) itemView.findViewById(R.id.year);
//            tvDirect = (TextView) itemView.findViewById(R.id.direct);
//            tvDesc = (TextView) itemView.findViewById(R.id.description);
            imgBD = (ImageView) itemView.findViewById(R.id.img_bd);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent intent = new Intent(mContext, MovieDetailsActivity.class);
                    intent.putExtra("movies", mData.get(position));
                    mContext.startActivity(intent);
                }
            });

        }
    }
}
