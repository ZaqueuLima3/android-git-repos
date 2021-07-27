package br.com.dio.app.repositories.domain.di

import br.com.dio.app.repositories.domain.usecases.ListUserRepositoriesUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {
    fun load() {
        loadKoinModules(useCasesModule())
    }

    private fun useCasesModule(): Module {
        return module {
            factory {
                ListUserRepositoriesUseCase(
                    repository = get()
                )
            }
        }
    }
}
