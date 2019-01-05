package eagle.com.newsapp.articledetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import eagle.com.newsapp.R;
import eagle.com.newsapp.model.Articles;

public class ArticleDetailActivity extends AppCompatActivity implements ArticleDetailContract.View {

    private TextView textArticleTitle;

    private TextView textArticleAbstract;

    private ImageView imgArticle;

    private TextView articleDate;

    private TextView articleAuthor;


    private ArticleDetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        initViews();
        presenter=new ArticleDetailPresenter(this);
        presenter.getData((Articles) getIntent().getSerializableExtra("Article"));
    }


    private void initViews() {
        textArticleTitle = (TextView)findViewById(R.id.articleTitle);
        textArticleAbstract = (TextView)findViewById(R.id.articleAbstract);
        articleDate= (TextView)findViewById(R.id.published_date);
        articleAuthor = (TextView) findViewById(R.id.article_author);

    }


    @Override
    public void setData(Articles articleItem) {
        textArticleTitle.setText(articleItem.getTitle());
        textArticleAbstract.setText(articleItem.getAbstract_title());
        articleAuthor.setText(articleItem.getByline());
        articleDate.setText(articleItem.getPublishedDate());
    }
}
