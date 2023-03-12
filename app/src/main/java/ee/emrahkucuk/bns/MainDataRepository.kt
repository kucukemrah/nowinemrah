package ee.emrahkucuk.bns

interface MainDataRepository {
    suspend fun getMostViewedArticles(): MostViewedArticlesNetworkResponse
}