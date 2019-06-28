package com.firmanjabar.submission2;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MovieFragment extends Fragment {

    View v;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    String[] title, year, description, director, actor;
    TypedArray imgPoster, imgBD, imgActor;

    public MovieFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_movie, container, false);
        recyclerView = v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        title = getResources().getStringArray(R.array.data_title_movies);
        year = getResources().getStringArray(R.array.data_year_movies);
        description = getResources().getStringArray(R.array.data_description_movies);
        director = getResources().getStringArray(R.array.data_director_movies);
        actor = getResources().getStringArray(R.array.data_actor_movies);
        imgPoster = getResources().obtainTypedArray(R.array.data_poster_movies);
        imgActor = getResources().obtainTypedArray(R.array.data_imgactor_movies);
        imgBD = getResources().obtainTypedArray(R.array.data_bd_movies);

        ArrayList<Movie> mData = new ArrayList<>();

        for (int i = 0; i < title.length; i++) {
            Movie movie = new Movie();
            movie.setImgPoster(imgPoster.getResourceId(i, -1));
            movie.setImgBD(imgBD.getResourceId(i, -1));
            movie.setImgActor(imgActor.getResourceId(i, -1));
            movie.setTitle(title[i]);
            movie.setYear(year[i]);
            movie.setDescription(description[i]);
            movie.setDirector(director[i]);
            movie.setActor(actor[i]);
            mData.add(movie);
        }
        recyclerViewAdapter = new RecyclerViewAdapter(getActivity());
        recyclerViewAdapter.setmData(mData);
        recyclerView.setAdapter(recyclerViewAdapter);

        return v;
    }
}
