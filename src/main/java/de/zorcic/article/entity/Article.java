package de.zorcic.article.entity;

import java.util.Calendar;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name = Article.findAll, query = "SELECT a FROM Article a")
    ,@NamedQuery(name = Article.findByArticleNumber, query = "SELECT a FROM Article a WHERE a.articleNumber = :articleNumber")
})
public class Article {

    private static final String PREFIX = "de.zorcic.article.entity.Article.";
    public static final String findAll = PREFIX + "all";
    public static final String findByArticleNumber = PREFIX + "findByArticleNumber";

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String articleNumber;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public Article(String articleNumber) {
        this.articleNumber = articleNumber;
        this.creationDate = Calendar.getInstance().getTime();
    }

    public Article() {

    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("articleNumber", articleNumber)
                .add("creationDate", creationDate.toString())
                .build();
    }
}
