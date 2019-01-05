package eagle.com.newsapp.articlelist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import eagle.com.newsapp.R;
import eagle.com.newsapp.adapter.RecyclerViewClickListener;
import eagle.com.newsapp.articledetail.ArticleDetailActivity;
import eagle.com.newsapp.adapter.ArticleAdapter;
import eagle.com.newsapp.constant.ApiConstant;
import eagle.com.newsapp.model.Articles;

public class MainActivity extends AppCompatActivity implements ArticleContract.View  {
    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView articleRecyclerView;


    private ArticleContract.Presenter articlePresenter;

    private ProgressDialog progressBar;

    private RecyclerViewClickListener listener;

    private List<Articles> articlesList;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressBar = new ProgressDialog(this);
        tvMessage = findViewById(R.id.tv_message);
        articleRecyclerView = findViewById(R.id.article_recyclerView);
        articleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this,ArticleDetailActivity.class);
                intent.putExtra("Article",articlesList.get(position));
                startActivity(intent);

            }
        };
        if (ApiConstant.API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }
        articlePresenter = new ArticlePresenter(this,new ArticleInteractorImpl(),getResources());
        articlePresenter.getData();
    }



    @Override
    public void showProgressBar() {
        progressBar.setCancelable(true);
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.show();
    }

    @Override
    public void hideProgressBar() {
        progressBar.dismiss();
    }

    @Override
    public void setArticleList(List<Articles> articles) {
        articlesList = articles;
        articleRecyclerView.setAdapter(new ArticleAdapter(articles, R.layout.list_item_artilce, getApplicationContext(),listener));
    }

    @Override
    public void setMessage(String message) {
        tvMessage.setText(message);
    }


}
