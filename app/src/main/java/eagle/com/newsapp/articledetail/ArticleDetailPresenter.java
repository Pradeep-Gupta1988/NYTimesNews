package eagle.com.newsapp.articledetail;

import eagle.com.newsapp.model.Articles;

public class ArticleDetailPresenter implements ArticleDetailContract.Presenter {


    private ArticleDetailContract.View view;

    public ArticleDetailPresenter(ArticleDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void getData(Articles articleItem) {
        if(articleItem!=null){
            view.setData(articleItem);
        }
    }
}
