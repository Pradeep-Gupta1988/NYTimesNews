package eagle.com.newsapp.articledetail;


import eagle.com.newsapp.model.Articles;

public class ArticleDetailContract {

    public interface Presenter{
         void getData(Articles articleItem);
    }

    public interface View {
         void setData(Articles articleItem);
    }
}
