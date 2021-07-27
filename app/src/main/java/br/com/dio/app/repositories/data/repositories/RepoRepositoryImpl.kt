package br.com.dio.app.repositories.data.repositories

import br.com.dio.app.repositories.core.RemoteException
import br.com.dio.app.repositories.data.services.GitHubServices
import br.com.dio.app.repositories.domain.repositories.RepoRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoryImpl(
    private val services: GitHubServices
) : RepoRepository {
    override suspend fun listRepositories(user: String) = flow {
        try {
            val listRepositories = services.listRepositories(user)
            emit(listRepositories)
        } catch (exception: HttpException) {
            throw RemoteException(exception.message ?: "Não foi possivel fazer a busca no momento")
        }
    }
}
