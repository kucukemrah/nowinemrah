package ee.emrahkucuk.bns

import javax.inject.Inject

class RealMainDataRepository @Inject constructor(
    private val network: RetrofitNetwork
) : MainDataRepository {

    override suspend fun getMostViewedArticles(): MostViewedArticlesNetworkResponse {
        return network.getMostViewedArticles()
    }
}