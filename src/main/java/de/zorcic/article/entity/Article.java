package de.zorcic.article.entity;

import java.util.Calendar;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Article {

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
