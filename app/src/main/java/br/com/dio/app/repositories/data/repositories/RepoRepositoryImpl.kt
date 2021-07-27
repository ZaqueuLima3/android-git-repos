package br.com.dio.app.repositories.data.repositories

import br.com.dio.app.repositories.data.services.GitHubServices
import br.com.dio.app.repositories.domain.repositories.RepoRepository
import kotlinx.coroutines.flow.flow

class RepoRepositoryImpl(
    private val services: GitHubServices
) : RepoRepository {
    override suspend fun listRepositories(user: String) = flow {
        val listRepositories = services.listRepositories(user)
        emit(listRepositories)
    }
}
