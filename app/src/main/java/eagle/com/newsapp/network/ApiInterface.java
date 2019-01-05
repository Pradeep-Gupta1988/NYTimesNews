package eagle.com.newsapp.network;

import eagle.com.newsapp.model.ArticleResponce;
import eagle.com.newsapp.model.Articles;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("mostviewed/all-sections/{period}.json")
    Call<ArticleResponce> getTopArticles(@Path("period") String period, @Query("api_key") String apiKey);

}
