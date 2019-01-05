package eagle.com.newsapp.articlelist;

import java.util.List;

import eagle.com.newsapp.constant.ApiConstant;
import eagle.com.newsapp.model.ArticleResponce;
import eagle.com.newsapp.model.Articles;
import eagle.com.newsapp.network.ApiClient;
import eagle.com.newsapp.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleInteractorImpl implements ArticleContract.DataSource {
    @Override
    public void getArticleList(final ArticleContract.DataSource.OnResponseRecived onResponseRecived) {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<ArticleResponce> call = apiService.getTopArticles("7",ApiConstant.API_KEY);
        call.enqueue(new Callback<ArticleResponce>() {
            @Override
            public void onResponse(Call<ArticleResponce> call, Response<ArticleResponce> response) {
                onResponseRecived.onSuccess(response.body().getResults());
            }

            @Override
            public void onFailure(Call<ArticleResponce>call, Throwable t) {
                // Log error here since request failed
                onResponseRecived.onFailure(t);
            }
        });
    }
}
