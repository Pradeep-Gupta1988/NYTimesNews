package eagle.com.newsapp.articlelist;

import android.content.res.Resources;

import java.util.List;

import eagle.com.newsapp.R;
import eagle.com.newsapp.constant.ApiConstant;
import eagle.com.newsapp.model.ArticleResponce;
import eagle.com.newsapp.model.Articles;
import eagle.com.newsapp.network.ApiClient;
import eagle.com.newsapp.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticlePresenter implements ArticleContract.Presenter {

    private final ArticleContract.DataSource dataSource;
    private ArticleContract.View articleView;
    private Resources resources;

    public ArticlePresenter(ArticleContract.View articleView, ArticleContract.DataSource dataSource, Resources resources) {
        this.articleView = articleView;
        this.dataSource=dataSource;
        this.resources=resources;
    }


    @Override
    public void getData() {
        articleView.showProgressBar();
        dataSource.getArticleList(new ArticleContract.DataSource.OnResponseRecived() {
            @Override
            public void onSuccess(List<Articles> articles) {
                articleView.hideProgressBar();
                if(articles!=null && articles.size()>0){
                    articleView.setArticleList(articles);
                }else{
                    articleView.setMessage(resources.getString(R.string.no_data_found));
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                articleView.hideProgressBar();
                articleView.setMessage(resources.getString(R.string.something_went_wrong));
            }
        });

    }
}
