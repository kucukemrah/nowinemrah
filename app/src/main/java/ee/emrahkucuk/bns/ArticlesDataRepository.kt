package ee.emrahkucuk.bns

interface ArticlesDataRepository {
    suspend fun getMostViewedArticles(): MostViewedArticlesNetworkResponse
}