package eagle.com.newsapp.articledetail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import eagle.com.newsapp.model.Articles;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class ArticleDetailPresenterTest {

    @InjectMocks
    private ArticleDetailPresenter presenter;
    @Mock
    private ArticleDetailContract.View view;
    @Mock
    private Articles articleItem;

    @Before
    public void setUp()  {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetData() {
        presenter.getData(articleItem);
        verify(view).setData(articleItem);

    }
}