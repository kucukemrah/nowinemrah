package ee.emrahkucuk.bns

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsMainDataRepository(
        articlesDataRepository: RealArticlesDataRepository
    ): ArticlesDataRepository
}