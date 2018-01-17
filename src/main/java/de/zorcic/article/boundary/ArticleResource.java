package de.zorcic.article.boundary;

import de.zorcic.article.entity.Article;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("articles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class ArticleResource {

    @Inject
    ArticleService articleService;

    @PUT
    @Path("{articleNumber}")
    public Response editOrCreateArticle(@PathParam("articleNumber") String articleNumber) {
        articleService.editOrCreateArticle(articleNumber);
        return Response.noContent().build();
    }

    @GET
    @Path("{articleNumber}")
    public Response byArticleNumber(@PathParam("articleNumber") String articleNumber) {
        Article a = articleService.findByArticleNumber(articleNumber);
        return Response.ok(a.toJson()).build();
    }

    @GET
    public Response allArticles() {
        JsonArrayBuilder result = Json.createArrayBuilder();
        articleService.allArticles().forEach(article -> result.add(article.toJson()));
        return Response.ok(result.build()).build();
    }

}
