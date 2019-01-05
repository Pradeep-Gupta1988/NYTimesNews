package eagle.com.newsapp.articlelist;

import android.content.res.Resources;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import eagle.com.newsapp.R;
import eagle.com.newsapp.model.ArticleResponce;
import eagle.com.newsapp.model.Articles;
import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArticlePresenterTest {

    @Mock
    private ArticleContract.View view;
    @Mock
    private ArticleContract.DataSource dataSource;
    @Mock
    private Resources resources;
    @InjectMocks
    private ArticlePresenter articlePresenter;
    @Captor
    private ArgumentCaptor< ArticleContract.DataSource.OnResponseRecived> captor;
    @Mock
    private List<Articles> list;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetDataOnSuccessWhenDataFound() {
        when(list.size()).thenReturn(5);
        articlePresenter.getData();
        verify(view).showProgressBar();
        verify(dataSource).getArticleList(captor.capture());
        captor.getValue().onSuccess(list);
        verify(view).hideProgressBar();
        verify(view).setArticleList(list);
    }

    @Test
    public void testGetDataOnSuccessWhenDataNotFound() {
        when(list.size()).thenReturn(0);
        articlePresenter.getData();
        verify(view).showProgressBar();
        verify(dataSource).getArticleList(captor.capture());
        captor.getValue().onSuccess(list);
        verify(view).hideProgressBar();
        verify(view).setMessage(resources.getString(R.string.no_data_found));
    }


    @Test
    public void testGetDataOnError() {
        articlePresenter.getData();
        verify(view).showProgressBar();
        verify(dataSource).getArticleList(captor.capture());
        captor.getValue().onFailure(new Throwable());
        verify(view).hideProgressBar();
        verify(view).setMessage(resources.getString(R.string.something_went_wrong));
    }
}