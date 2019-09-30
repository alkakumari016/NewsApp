package com.example.newsapp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsVH> {

    private Context context;
    private List<Article> list;

    public NewsAdapter(Context context, List<Article> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.news_layout,parent,false);
        return (new NewsVH(view));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsVH holder, int position) {
        Article article=list.get(position);
        holder.mTvtitle.setText(article.getmTitle());
        holder.mTvcontent.setText(article.getmDescription());

        RequestOptions requestOptions=new RequestOptions();
        requestOptions.placeholder((R.drawable.loading));
        requestOptions.error((R.drawable.loading));

        Glide.with(context).load(article.getmUrlToImage()).apply(requestOptions).into(holder.mImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NewsVH extends RecyclerView.ViewHolder {
        private TextView mTvtitle,mTvcontent;
        private ImageView mImg;
        public NewsVH(@NonNull View itemView) {
            super(itemView);
            mTvtitle=itemView.findViewById(R.id.tv_title);
            mTvcontent=itemView.findViewById(R.id.tv_des);
            mImg=itemView.findViewById(R.id.img_view);
        }
    }
}
