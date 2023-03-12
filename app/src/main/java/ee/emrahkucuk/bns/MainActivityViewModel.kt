package ee.emrahkucuk.bns

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val mainDataRepository: MainDataRepository
) : ViewModel() {

    fun getMostViewedArticles() {
        viewModelScope.launch {
            mainDataRepository.getMostViewedArticles()
        }
    }
}