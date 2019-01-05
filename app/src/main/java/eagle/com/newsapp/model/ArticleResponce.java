package eagle.com.newsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleResponce {
    @SerializedName("status")
    private String status;
    @SerializedName("results")
    private List<Articles> results;
    @SerializedName("num_results")
    private int num_results;
    @SerializedName("copyright")
    private String copyright;

    public String getStatus() {
        return status;
    }

    public List<Articles> getResults() {
        return results;
    }

    public int getNum_results() {
        return num_results;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResults(List<Articles> results) {
        this.results = results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}
