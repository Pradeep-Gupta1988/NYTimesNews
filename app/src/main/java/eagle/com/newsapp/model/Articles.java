package eagle.com.newsapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Articles implements Serializable {

    @SerializedName("title")
    private String title;
    @SerializedName("byline")
    private String byline;
    @SerializedName("type")
    private String type;
    @SerializedName("published_date")
    private String publishedDate;
    @SerializedName("source")
    private String source;
    @SerializedName("abstract")
    private String abstract_title;

    public Articles(String title, String byLine, String type, String publishDate,
                 String source, String abstract_title) {
        this.title = title;
        this.byline = byLine;
        this.type = type;
        this.publishedDate = publishDate;
        this.source = source;
        this.abstract_title = abstract_title;

    }

    public String getTitle() {
        return title;
    }

    public String getByline() {
        return byline;
    }

    public String getType() {
        return type;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getAbstract_title() {
        return abstract_title;
    }

    public String getSource() {
        return source;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setAbstract_title(String abstract_title) {
        this.abstract_title = abstract_title;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

