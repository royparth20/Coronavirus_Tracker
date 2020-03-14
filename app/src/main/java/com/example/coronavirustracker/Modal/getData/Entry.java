
package com.example.coronavirustracker.Modal.getData;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entry {

    @SerializedName("id")
    @Expose
    private Id_ id;
    @SerializedName("updated")
    @Expose
    private Updated_ updated;
    @SerializedName("category")
    @Expose
    private List<Category_> category = null;
    @SerializedName("title")
    @Expose
    private Title_ title;
    @SerializedName("content")
    @Expose
    private Content content;
    @SerializedName("link")
    @Expose
    private List<Link_> link = null;
    @SerializedName("gsx$country")
    @Expose
    private Gsx$country gsx$country;
    @SerializedName("gsx$confirmedcases")
    @Expose
    private Gsx$confirmedcases gsx$confirmedcases;
    @SerializedName("gsx$reporteddeaths")
    @Expose
    private Gsx$reporteddeaths gsx$reporteddeaths;

    public Id_ getId() {
        return id;
    }

    public void setId(Id_ id) {
        this.id = id;
    }

    public Updated_ getUpdated() {
        return updated;
    }

    public void setUpdated(Updated_ updated) {
        this.updated = updated;
    }

    public List<Category_> getCategory() {
        return category;
    }

    public void setCategory(List<Category_> category) {
        this.category = category;
    }

    public Title_ getTitle() {
        return title;
    }

    public void setTitle(Title_ title) {
        this.title = title;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public List<Link_> getLink() {
        return link;
    }

    public void setLink(List<Link_> link) {
        this.link = link;
    }

    public Gsx$country getGsx$country() {
        return gsx$country;
    }

    public void setGsx$country(Gsx$country gsx$country) {
        this.gsx$country = gsx$country;
    }

    public Gsx$confirmedcases getGsx$confirmedcases() {
        return gsx$confirmedcases;
    }

    public void setGsx$confirmedcases(Gsx$confirmedcases gsx$confirmedcases) {
        this.gsx$confirmedcases = gsx$confirmedcases;
    }

    public Gsx$reporteddeaths getGsx$reporteddeaths() {
        return gsx$reporteddeaths;
    }

    public void setGsx$reporteddeaths(Gsx$reporteddeaths gsx$reporteddeaths) {
        this.gsx$reporteddeaths = gsx$reporteddeaths;
    }

}
