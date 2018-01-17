package de.zorcic.article.dao;

import de.zorcic.article.entity.Article;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public abstract class ArticleRepository extends AbstractEntityRepository<Article, Long> {

    public abstract Article findByArticleNumber(String articleNumber);

    public void editOrCreateArticle(String articleNumber) {
        save(new Article(articleNumber));
    }

}
