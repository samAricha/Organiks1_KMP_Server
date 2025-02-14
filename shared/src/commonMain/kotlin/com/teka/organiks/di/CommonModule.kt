package com.teka.organiks.di

import com.teka.organiks.core.data.local.setting.PreferenceManager
import com.teka.organiks.core.data.repository.egg_collections.EggCollectionsRepositoryImpl
import com.teka.organiks.core.data.repository.egg_collections.EggTypeRepositoryImpl
import com.teka.organiks.core.data.repository.settings.SettingsRepositoryImpl
import com.teka.organiks.core.domain.repository.egg_collections.EggCollectionsRepository
import com.teka.organiks.core.domain.repository.egg_collections.EggTypeRepository
import com.teka.organiks.core.domain.repository.settings.SettingsRepository
import com.teka.organiks.database.OrganiksDatabase
import com.teka.organiks.feature.dashborad.DashboardViewModel
import com.teka.organiks.feature.egg_collection.ProductionRecordingViewModel
import com.teka.organiks.feature.egg_dashboard.ProductionHomeViewModel
import com.teka.organiks.feature.onboarding.OnboadingViewModel
import com.teka.organiks.feature.settings.SettingsScreenModel
import com.teka.organiks.main.MainViewModel
import com.teka.organiks.platform.DatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

fun commonModule() = module {
    /**
     * Database
     */

    single<OrganiksDatabase> {
        OrganiksDatabase(
            driver = get<DatabaseDriverFactory>().createDriver(),
            )
    }


    /**
     * Multiplatform-Settings
     */
    single<PreferenceManager> {
        PreferenceManager(settings = get())
    }

    /**
     * Repositories
     */
    single<SettingsRepository> {
        SettingsRepositoryImpl(
            preferenceManager = get(),
        )
    }


    single<EggCollectionsRepository> {
        EggCollectionsRepositoryImpl(
            organiksDatabase = get(),
        )
    }

    single<EggTypeRepository> {
        EggTypeRepositoryImpl(
            organiksDatabase = get(),
        )
    }

    /**
     * ViewModels
     */
    single<SettingsScreenModel> {
        SettingsScreenModel(
            settingsRepository = get(),
        )
    }

    single<MainViewModel> {
        MainViewModel(
            settingsRepository = get(),
        )
    }

    single<OnboadingViewModel> {
        OnboadingViewModel(
            settingsRepository = get(),
        )
    }


    single<ProductionHomeViewModel> {
        ProductionHomeViewModel(
            eggCollectionsRepository = get(),
        )
    }

    single<ProductionRecordingViewModel> {
        ProductionRecordingViewModel(
            eggCollectionsRepository = get(),
            eggTypeRepository = get ()
        )
    }

    single<DashboardViewModel> {
        DashboardViewModel(
            eggCollectionsRepository = get(),
        )
    }

}

expect fun platformModule(): Module
