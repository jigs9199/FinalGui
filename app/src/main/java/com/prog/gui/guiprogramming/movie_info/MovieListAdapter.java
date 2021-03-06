package com.prog.gui.guiprogramming.movie_info;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.prog.gui.guiprogramming.R;

import java.util.List;

/**
 * MovieListAdapter is a custom ListAdapter, used to set custom layout to ListView
 * ViewHolder pattern is used
 */
public class MovieListAdapter extends BaseAdapter {

    private List<Movie> mRowData;
    private static LayoutInflater layoutInflater;

    /**
     * @param mRowData to set data into ListView
     * @param activity to inflate layout we need
     *                 to use instance of an Activity
     *                 -Pass current activity's this object
     * */
    public MovieListAdapter(List<Movie> mRowData, Activity activity) {
        this.mRowData = mRowData;
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mRowData.size();
    }

    @Override
    public Object getItem(int i) {
        return mRowData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        Movie model = mRowData.get(i);
        if (view == null) {
            view = layoutInflater.inflate(R.layout.movie_row_movie_list, null);
            holder = new ViewHolder();
            holder.tvMovieTitle = view.findViewById(R.id.tvMovieTitle);
            holder.tvReleaseYear = view.findViewById(R.id.tvReleaseYear);
            holder.imgPoster = view.findViewById(R.id.imgPoster);
                view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        String movieTitle = model.getTitle();
        String releaseYear = model.getYear();
        holder.tvMovieTitle.setText(movieTitle);
        holder.tvReleaseYear.setText(releaseYear);
//        new MovieImageLoader(model.getPoster(), holder.imgPoster).execute();
        model.setBitmapTo(holder.imgPoster);
        return view;
    }

    static class ViewHolder{
        TextView tvMovieTitle;
        TextView tvReleaseYear;
        ImageView imgPoster;
    }
}
