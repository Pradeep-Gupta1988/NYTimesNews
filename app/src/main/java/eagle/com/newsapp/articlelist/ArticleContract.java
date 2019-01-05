package eagle.com.newsapp.articlelist;

import java.util.List;

import eagle.com.newsapp.model.Articles;

public class ArticleContract {

     public interface Presenter{

         void getData();
    }

    public interface View  {

         void showProgressBar();

         void hideProgressBar();

         void setArticleList(List<Articles> articles);

         void setMessage(String message);
    }

    public interface DataSource{
         void getArticleList(ArticleContract.DataSource.OnResponseRecived onResponseRecived);

         interface OnResponseRecived{
             void  onSuccess(List<Articles> articles);
             void onFailure(Throwable throwable);
         }
    }


}
