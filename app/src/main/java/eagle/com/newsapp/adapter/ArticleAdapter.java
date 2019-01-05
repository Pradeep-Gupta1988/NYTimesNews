package eagle.com.newsapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import eagle.com.newsapp.R;
import eagle.com.newsapp.model.Articles;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private List<Articles> article;
    private int rowLayout;
    private Context context;
    private RecyclerViewClickListener mListener;



    public  class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        LinearLayout moviesLayout;
        TextView articleTitle;
        TextView source;
        TextView articleDescription;
        TextView publishDate;


        public ArticleViewHolder(View v, RecyclerViewClickListener listener ){
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            articleTitle = (TextView) v.findViewById(R.id.title);
            articleDescription = (TextView) v.findViewById(R.id.subtitle);
            source = (TextView) v.findViewById(R.id.source);
            publishDate = (TextView) v.findViewById(R.id.published_date);
            mListener = listener;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    public ArticleAdapter(List<Articles> article, int rowLayout, Context context,RecyclerViewClickListener listener) {
        this.article = article;
        this.rowLayout = rowLayout;
        this.context = context;
        this.mListener = listener;
    }

    @Override
    public ArticleAdapter.ArticleViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ArticleViewHolder(view,mListener);
    }


    @Override
    public void onBindViewHolder(ArticleViewHolder holder, final int position) {
        holder.articleTitle.setText(article.get(position).getTitle());
        holder.source.setText(article.get(position).getSource());
        holder.articleDescription.setText(article.get(position).getByline());
        holder.publishDate.setText(article.get(position).getPublishedDate());
    }

    @Override
    public int getItemCount() {
        return article.size();
    }


}