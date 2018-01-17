package de.zorcic.article.boundary;

import de.zorcic.article.entity.Article;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class ArticleService {

    @Inject
    EntityManager em;

    public void editOrCreateArticle(String articleNumber) {
        em.merge(new Article(articleNumber));
    }

    public List<Article> allArticles() {
        return em.createNamedQuery(Article.findAll, Article.class).getResultList();
    }

}
