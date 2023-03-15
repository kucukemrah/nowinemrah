package ee.emrahkucuk.bns

import javax.inject.Inject

class RealArticlesDataRepository @Inject constructor(
    private val network: RetrofitNetwork
) : ArticlesDataRepository {

    override suspend fun getMostViewedArticles(): MostViewedArticlesNetworkResponse {
        return network.getMostViewedArticles()
    }
}