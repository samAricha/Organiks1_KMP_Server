package com.teka.organiks.di

import androidx.compose.ui.graphics.painter.Painter
import com.teka.organiks.core.data.adapter.colorAdapter
import com.teka.organiks.core.data.adapter.consumedFocusTimeAdapter
import com.teka.organiks.core.data.adapter.consumedLongBreakTimeAdapter
import com.teka.organiks.core.data.adapter.consumedShortBreakTimeAdapter
import com.teka.organiks.core.data.adapter.currentAdapter
import com.teka.organiks.core.data.adapter.currentCycleAdapter
import com.teka.organiks.core.data.adapter.focusSessionsAdapter
import com.teka.organiks.core.data.adapter.idAdapter
import com.teka.organiks.core.data.local.setting.PreferenceManager
import com.teka.organiks.core.data.repository.egg_collections.EggCollectionsRepositoryImpl
import com.teka.organiks.core.data.repository.egg_collections.EggTypeRepositoryImpl
import com.teka.organiks.core.data.repository.settings.SettingsRepositoryImpl
import com.teka.organiks.core.domain.repository.egg_collections.EggCollectionsRepository
import com.teka.organiks.core.domain.repository.egg_collections.EggTypeRepository
import com.teka.organiks.core.domain.repository.settings.SettingsRepository
import com.teka.organiks.core.domain.repository.tasks.TasksRepository
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
            bloomDatabase = get(),
        )
    }

    single<EggTypeRepository> {
        EggTypeRepositoryImpl(
            bloomDatabase = get(),
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
