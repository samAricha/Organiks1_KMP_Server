package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AccompanistLibraryAccessors laccForAccompanistLibraryAccessors = new AccompanistLibraryAccessors(owner);
    private final AnnotationLibraryAccessors laccForAnnotationLibraryAccessors = new AnnotationLibraryAccessors(owner);
    private final ComponentsLibraryAccessors laccForComponentsLibraryAccessors = new ComponentsLibraryAccessors(owner);
    private final ComposeLibraryAccessors laccForComposeLibraryAccessors = new ComposeLibraryAccessors(owner);
    private final CoreLibraryAccessors laccForCoreLibraryAccessors = new CoreLibraryAccessors(owner);
    private final KoalaplotLibraryAccessors laccForKoalaplotLibraryAccessors = new KoalaplotLibraryAccessors(owner);
    private final KoinLibraryAccessors laccForKoinLibraryAccessors = new KoinLibraryAccessors(owner);
    private final KotlinXLibraryAccessors laccForKotlinXLibraryAccessors = new KotlinXLibraryAccessors(owner);
    private final KotlinxLibraryAccessors$1 laccForKotlinxLibraryAccessors$1 = new KotlinxLibraryAccessors$1(owner);
    private final KtorLibraryAccessors laccForKtorLibraryAccessors = new KtorLibraryAccessors(owner);
    private final LifecycleLibraryAccessors laccForLifecycleLibraryAccessors = new LifecycleLibraryAccessors(owner);
    private final Material3LibraryAccessors laccForMaterial3LibraryAccessors = new Material3LibraryAccessors(owner);
    private final MultiplatformSettingsLibraryAccessors laccForMultiplatformSettingsLibraryAccessors = new MultiplatformSettingsLibraryAccessors(owner);
    private final PrimitiveLibraryAccessors laccForPrimitiveLibraryAccessors = new PrimitiveLibraryAccessors(owner);
    private final SqlDelightLibraryAccessors laccForSqlDelightLibraryAccessors = new SqlDelightLibraryAccessors(owner);
    private final VoyagerLibraryAccessors laccForVoyagerLibraryAccessors = new VoyagerLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for jna (net.java.dev.jna:jna)
     * with versionRef 'jna'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJna() {
            return create("jna");
    }

        /**
         * Creates a dependency provider for logback (ch.qos.logback:logback-classic)
     * with versionRef 'logback'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLogback() {
            return create("logback");
    }

        /**
         * Creates a dependency provider for napier (io.github.aakira:napier)
     * with versionRef 'napier'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getNapier() {
            return create("napier");
    }

        /**
         * Creates a dependency provider for stdlib (org.jetbrains.kotlin:kotlin-stdlib)
     * with versionRef 'kotlin'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getStdlib() {
            return create("stdlib");
    }

        /**
         * Creates a dependency provider for toast4j (de.mobanisto:toast4j)
     * with versionRef 'toast4j'.
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getToast4j() {
            return create("toast4j");
    }

    /**
     * Returns the group of libraries at accompanist
     */
    public AccompanistLibraryAccessors getAccompanist() {
        return laccForAccompanistLibraryAccessors;
    }

    /**
     * Returns the group of libraries at annotation
     */
    public AnnotationLibraryAccessors getAnnotation() {
        return laccForAnnotationLibraryAccessors;
    }

    /**
     * Returns the group of libraries at components
     */
    public ComponentsLibraryAccessors getComponents() {
        return laccForComponentsLibraryAccessors;
    }

    /**
     * Returns the group of libraries at compose
     */
    public ComposeLibraryAccessors getCompose() {
        return laccForComposeLibraryAccessors;
    }

    /**
     * Returns the group of libraries at core
     */
    public CoreLibraryAccessors getCore() {
        return laccForCoreLibraryAccessors;
    }

    /**
     * Returns the group of libraries at koalaplot
     */
    public KoalaplotLibraryAccessors getKoalaplot() {
        return laccForKoalaplotLibraryAccessors;
    }

    /**
     * Returns the group of libraries at koin
     */
    public KoinLibraryAccessors getKoin() {
        return laccForKoinLibraryAccessors;
    }

    /**
     * Returns the group of libraries at kotlinX
     */
    public KotlinXLibraryAccessors getKotlinX() {
        return laccForKotlinXLibraryAccessors;
    }

    /**
     * Returns the group of libraries at kotlinx
     */
    public KotlinxLibraryAccessors$1 getKotlinx() {
        return laccForKotlinxLibraryAccessors$1;
    }

    /**
     * Returns the group of libraries at ktor
     */
    public KtorLibraryAccessors getKtor() {
        return laccForKtorLibraryAccessors;
    }

    /**
     * Returns the group of libraries at lifecycle
     */
    public LifecycleLibraryAccessors getLifecycle() {
        return laccForLifecycleLibraryAccessors;
    }

    /**
     * Returns the group of libraries at material3
     */
    public Material3LibraryAccessors getMaterial3() {
        return laccForMaterial3LibraryAccessors;
    }

    /**
     * Returns the group of libraries at multiplatformSettings
     */
    public MultiplatformSettingsLibraryAccessors getMultiplatformSettings() {
        return laccForMultiplatformSettingsLibraryAccessors;
    }

    /**
     * Returns the group of libraries at primitive
     */
    public PrimitiveLibraryAccessors getPrimitive() {
        return laccForPrimitiveLibraryAccessors;
    }

    /**
     * Returns the group of libraries at sqlDelight
     */
    public SqlDelightLibraryAccessors getSqlDelight() {
        return laccForSqlDelightLibraryAccessors;
    }

    /**
     * Returns the group of libraries at voyager
     */
    public VoyagerLibraryAccessors getVoyager() {
        return laccForVoyagerLibraryAccessors;
    }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class AccompanistLibraryAccessors extends SubDependencyFactory {

        public AccompanistLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for systemUIController (com.google.accompanist:accompanist-systemuicontroller)
         * with versionRef 'accompanist.systemUIController'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSystemUIController() {
                return create("accompanist.systemUIController");
        }

    }

    public static class AnnotationLibraryAccessors extends SubDependencyFactory {

        public AnnotationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jvm (androidx.annotation:annotation-jvm)
         * with versionRef 'annotationJvm'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJvm() {
                return create("annotation.jvm");
        }

    }

    public static class ComponentsLibraryAccessors extends SubDependencyFactory {

        public ComponentsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for resources (org.jetbrains.compose.components:components-resources)
         * with versionRef 'componentsResources'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getResources() {
                return create("components.resources");
        }

    }

    public static class ComposeLibraryAccessors extends SubDependencyFactory {

        public ComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for activity (androidx.activity:activity-compose)
         * with versionRef 'compose.activity'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getActivity() {
                return create("compose.activity");
        }

    }

    public static class CoreLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final CoreLibraryLibraryAccessors laccForCoreLibraryLibraryAccessors = new CoreLibraryLibraryAccessors(owner);

        public CoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (androidx.core:core)
         * with versionRef 'core'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("core");
        }

        /**
         * Returns the group of libraries at core.library
         */
        public CoreLibraryLibraryAccessors getLibrary() {
            return laccForCoreLibraryLibraryAccessors;
        }

    }

    public static class CoreLibraryLibraryAccessors extends SubDependencyFactory {

        public CoreLibraryLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for desugaring (com.android.tools:desugar_jdk_libs)
         * with versionRef 'core.library.desugaring'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDesugaring() {
                return create("core.library.desugaring");
        }

    }

    public static class KoalaplotLibraryAccessors extends SubDependencyFactory {

        public KoalaplotLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (io.github.koalaplot:koalaplot-core)
         * with versionRef 'koalaplotCore'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("koalaplot.core");
        }

    }

    public static class KoinLibraryAccessors extends SubDependencyFactory {

        public KoinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (io.insert-koin:koin-android)
         * with versionRef 'koinAndroid'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() {
                return create("koin.android");
        }

            /**
             * Creates a dependency provider for compose (io.insert-koin:koin-compose)
         * with versionRef 'koin.compose'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() {
                return create("koin.compose");
        }

            /**
             * Creates a dependency provider for core (io.insert-koin:koin-core)
         * with versionRef 'koinCore'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("koin.core");
        }

    }

    public static class KotlinXLibraryAccessors extends SubDependencyFactory {

        public KotlinXLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for dateTime (org.jetbrains.kotlinx:kotlinx-datetime)
         * with versionRef 'kotlinxDateTime'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDateTime() {
                return create("kotlinX.dateTime");
        }

            /**
             * Creates a dependency provider for serializationJson (org.jetbrains.kotlinx:kotlinx-serialization-core)
         * with versionRef 'kotlinxSerializationJson'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSerializationJson() {
                return create("kotlinX.serializationJson");
        }

    }

    public static class KotlinxLibraryAccessors$1 extends SubDependencyFactory {
        private final KotlinxCoroutinesLibraryAccessors laccForKotlinxCoroutinesLibraryAccessors = new KotlinxCoroutinesLibraryAccessors(owner);

        public KotlinxLibraryAccessors$1(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at kotlinx.coroutines
         */
        public KotlinxCoroutinesLibraryAccessors getCoroutines() {
            return laccForKotlinxCoroutinesLibraryAccessors;
        }

    }

    public static class KotlinxCoroutinesLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public KotlinxCoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for coroutines (org.jetbrains.kotlinx:kotlinx-coroutines-core)
         * with versionRef 'kotlinx.coroutines'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("kotlinx.coroutines");
        }

            /**
             * Creates a dependency provider for swing (org.jetbrains.kotlinx:kotlinx-coroutines-swing)
         * with versionRef 'kotlinxCoroutinesSwing'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSwing() {
                return create("kotlinx.coroutines.swing");
        }

    }

    public static class KtorLibraryAccessors extends SubDependencyFactory {
        private final KtorClientLibraryAccessors laccForKtorClientLibraryAccessors = new KtorClientLibraryAccessors(owner);
        private final KtorSerializationLibraryAccessors laccForKtorSerializationLibraryAccessors = new KtorSerializationLibraryAccessors(owner);
        private final KtorServerLibraryAccessors laccForKtorServerLibraryAccessors = new KtorServerLibraryAccessors(owner);

        public KtorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at ktor.client
         */
        public KtorClientLibraryAccessors getClient() {
            return laccForKtorClientLibraryAccessors;
        }

        /**
         * Returns the group of libraries at ktor.serialization
         */
        public KtorSerializationLibraryAccessors getSerialization() {
            return laccForKtorSerializationLibraryAccessors;
        }

        /**
         * Returns the group of libraries at ktor.server
         */
        public KtorServerLibraryAccessors getServer() {
            return laccForKtorServerLibraryAccessors;
        }

    }

    public static class KtorClientLibraryAccessors extends SubDependencyFactory {
        private final KtorClientContentLibraryAccessors laccForKtorClientContentLibraryAccessors = new KtorClientContentLibraryAccessors(owner);

        public KtorClientLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (io.ktor:ktor-client-android)
         * with versionRef 'ktor'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() {
                return create("ktor.client.android");
        }

            /**
             * Creates a dependency provider for core (io.ktor:ktor-client-core)
         * with versionRef 'ktor'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("ktor.client.core");
        }

            /**
             * Creates a dependency provider for java (io.ktor:ktor-client-java)
         * with versionRef 'ktor'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJava() {
                return create("ktor.client.java");
        }

            /**
             * Creates a dependency provider for json (io.ktor:ktor-client-json)
         * with versionRef 'ktor'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJson() {
                return create("ktor.client.json");
        }

            /**
             * Creates a dependency provider for logging (io.ktor:ktor-client-logging)
         * with versionRef 'ktor'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLogging() {
                return create("ktor.client.logging");
        }

            /**
             * Creates a dependency provider for serialization (io.ktor:ktor-client-serialization)
         * with versionRef 'ktor'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSerialization() {
                return create("ktor.client.serialization");
        }

        /**
         * Returns the group of libraries at ktor.client.content
         */
        public KtorClientContentLibraryAccessors getContent() {
            return laccForKtorClientContentLibraryAccessors;
        }

    }

    public static class KtorClientContentLibraryAccessors extends SubDependencyFactory {

        public KtorClientContentLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for negotiation (io.ktor:ktor-client-content-negotiation)
         * with versionRef 'ktor'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getNegotiation() {
                return create("ktor.client.content.negotiation");
        }

    }

    public static class KtorSerializationLibraryAccessors extends SubDependencyFactory {
        private final KtorSerializationKotlinxLibraryAccessors laccForKtorSerializationKotlinxLibraryAccessors = new KtorSerializationKotlinxLibraryAccessors(owner);

        public KtorSerializationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at ktor.serialization.kotlinx
         */
        public KtorSerializationKotlinxLibraryAccessors getKotlinx() {
            return laccForKtorSerializationKotlinxLibraryAccessors;
        }

    }

    public static class KtorSerializationKotlinxLibraryAccessors extends SubDependencyFactory {

        public KtorSerializationKotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for json (io.ktor:ktor-serialization-kotlinx-json)
         * with versionRef 'ktor'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJson() {
                return create("ktor.serialization.kotlinx.json");
        }

    }

    public static class KtorServerLibraryAccessors extends SubDependencyFactory {

        public KtorServerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (io.ktor:ktor-server-core-jvm)
         * with versionRef 'ktor'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("ktor.server.core");
        }

            /**
             * Creates a dependency provider for netty (io.ktor:ktor-server-netty-jvm)
         * with versionRef 'ktor'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getNetty() {
                return create("ktor.server.netty");
        }

    }

    public static class LifecycleLibraryAccessors extends SubDependencyFactory {

        public LifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for common (androidx.lifecycle:lifecycle-common)
         * with version '2.6.2'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCommon() {
                return create("lifecycle.common");
        }

    }

    public static class Material3LibraryAccessors extends SubDependencyFactory {
        private final Material3WindowLibraryAccessors laccForMaterial3WindowLibraryAccessors = new Material3WindowLibraryAccessors(owner);

        public Material3LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at material3.window
         */
        public Material3WindowLibraryAccessors getWindow() {
            return laccForMaterial3WindowLibraryAccessors;
        }

    }

    public static class Material3WindowLibraryAccessors extends SubDependencyFactory {
        private final Material3WindowSizeLibraryAccessors laccForMaterial3WindowSizeLibraryAccessors = new Material3WindowSizeLibraryAccessors(owner);

        public Material3WindowLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at material3.window.size
         */
        public Material3WindowSizeLibraryAccessors getSize() {
            return laccForMaterial3WindowSizeLibraryAccessors;
        }

    }

    public static class Material3WindowSizeLibraryAccessors extends SubDependencyFactory {

        public Material3WindowSizeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for multiplatform (dev.chrisbanes.material3:material3-window-size-class-multiplatform)
         * with versionRef 'material3WindowSizeClassMultiplatform'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMultiplatform() {
                return create("material3.window.size.multiplatform");
        }

    }

    public static class MultiplatformSettingsLibraryAccessors extends SubDependencyFactory {

        public MultiplatformSettingsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for coroutines (com.russhwolf:multiplatform-settings-coroutines)
         * with versionRef 'multiplatformSettings'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCoroutines() {
                return create("multiplatformSettings.coroutines");
        }

            /**
             * Creates a dependency provider for noArg (com.russhwolf:multiplatform-settings-no-arg)
         * with versionRef 'multiplatformSettings'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getNoArg() {
                return create("multiplatformSettings.noArg");
        }

    }

    public static class PrimitiveLibraryAccessors extends SubDependencyFactory {

        public PrimitiveLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for adapters (app.cash.sqldelight:primitive-adapters)
         * with versionRef 'sqlDelight'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAdapters() {
                return create("primitive.adapters");
        }

    }

    public static class SqlDelightLibraryAccessors extends SubDependencyFactory {
        private final SqlDelightDriverLibraryAccessors laccForSqlDelightDriverLibraryAccessors = new SqlDelightDriverLibraryAccessors(owner);

        public SqlDelightLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for JVM (app.cash.sqldelight:sqlite-driver)
         * with versionRef 'sqlDelight'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJVM() {
                return create("sqlDelight.JVM");
        }

            /**
             * Creates a dependency provider for android (app.cash.sqldelight:android-driver)
         * with versionRef 'sqlDelight'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() {
                return create("sqlDelight.android");
        }

            /**
             * Creates a dependency provider for coroutine (app.cash.sqldelight:coroutines-extensions)
         * with versionRef 'sqlDelight'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCoroutine() {
                return create("sqlDelight.coroutine");
        }

            /**
             * Creates a dependency provider for native (app.cash.sqldelight:native-driver)
         * with versionRef 'sqlDelight'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getNative() {
                return create("sqlDelight.native");
        }

            /**
             * Creates a dependency provider for runtime (app.cash.sqldelight:runtime)
         * with versionRef 'sqlDelight'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRuntime() {
                return create("sqlDelight.runtime");
        }

        /**
         * Returns the group of libraries at sqlDelight.driver
         */
        public SqlDelightDriverLibraryAccessors getDriver() {
            return laccForSqlDelightDriverLibraryAccessors;
        }

    }

    public static class SqlDelightDriverLibraryAccessors extends SubDependencyFactory {

        public SqlDelightDriverLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for sqljs (app.cash.sqldelight:sqljs-driver)
         * with version '2.0.0-alpha05'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSqljs() {
                return create("sqlDelight.driver.sqljs");
        }

    }

    public static class VoyagerLibraryAccessors extends SubDependencyFactory {

        public VoyagerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for bottomSheetNavigator (cafe.adriel.voyager:voyager-bottom-sheet-navigator)
         * with versionRef 'voyager'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBottomSheetNavigator() {
                return create("voyager.bottomSheetNavigator");
        }

            /**
             * Creates a dependency provider for navigator (cafe.adriel.voyager:voyager-navigator)
         * with versionRef 'voyager'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getNavigator() {
                return create("voyager.navigator");
        }

            /**
             * Creates a dependency provider for tabNavigator (cafe.adriel.voyager:voyager-tab-navigator)
         * with versionRef 'voyager'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTabNavigator() {
                return create("voyager.tabNavigator");
        }

            /**
             * Creates a dependency provider for transitions (cafe.adriel.voyager:voyager-transitions)
         * with versionRef 'voyager'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTransitions() {
                return create("voyager.transitions");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final AccompanistVersionAccessors vaccForAccompanistVersionAccessors = new AccompanistVersionAccessors(providers, config);
        private final ComposeVersionAccessors vaccForComposeVersionAccessors = new ComposeVersionAccessors(providers, config);
        private final CoreVersionAccessors vaccForCoreVersionAccessors = new CoreVersionAccessors(providers, config);
        private final KoinVersionAccessors vaccForKoinVersionAccessors = new KoinVersionAccessors(providers, config);
        private final KotlinxVersionAccessors vaccForKotlinxVersionAccessors = new KotlinxVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: annotationJvm (1.7.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAnnotationJvm() { return getVersion("annotationJvm"); }

            /**
             * Returns the version associated to this alias: componentsResources (1.5.11)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getComponentsResources() { return getVersion("componentsResources"); }

            /**
             * Returns the version associated to this alias: gradle (8.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGradle() { return getVersion("gradle"); }

            /**
             * Returns the version associated to this alias: jna (5.13.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJna() { return getVersion("jna"); }

            /**
             * Returns the version associated to this alias: koalaplotCore (0.4.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKoalaplotCore() { return getVersion("koalaplotCore"); }

            /**
             * Returns the version associated to this alias: koinAndroid (3.5.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKoinAndroid() { return getVersion("koinAndroid"); }

            /**
             * Returns the version associated to this alias: koinCore (3.5.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKoinCore() { return getVersion("koinCore"); }

            /**
             * Returns the version associated to this alias: kotlin (1.9.21)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlin() { return getVersion("kotlin"); }

            /**
             * Returns the version associated to this alias: kotlinxCoroutinesSwing (1.7.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlinxCoroutinesSwing() { return getVersion("kotlinxCoroutinesSwing"); }

            /**
             * Returns the version associated to this alias: kotlinxDateTime (0.5.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlinxDateTime() { return getVersion("kotlinxDateTime"); }

            /**
             * Returns the version associated to this alias: kotlinxSerializationJson (1.6.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlinxSerializationJson() { return getVersion("kotlinxSerializationJson"); }

            /**
             * Returns the version associated to this alias: ktor (2.3.7)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKtor() { return getVersion("ktor"); }

            /**
             * Returns the version associated to this alias: logback (1.4.14)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLogback() { return getVersion("logback"); }

            /**
             * Returns the version associated to this alias: material3WindowSizeClassMultiplatform (0.3.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMaterial3WindowSizeClassMultiplatform() { return getVersion("material3WindowSizeClassMultiplatform"); }

            /**
             * Returns the version associated to this alias: multiplatformSettings (1.1.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMultiplatformSettings() { return getVersion("multiplatformSettings"); }

            /**
             * Returns the version associated to this alias: napier (2.6.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getNapier() { return getVersion("napier"); }

            /**
             * Returns the version associated to this alias: spotless (5.17.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSpotless() { return getVersion("spotless"); }

            /**
             * Returns the version associated to this alias: sqlDelight (2.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSqlDelight() { return getVersion("sqlDelight"); }

            /**
             * Returns the version associated to this alias: toast4j (0.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getToast4j() { return getVersion("toast4j"); }

            /**
             * Returns the version associated to this alias: voyager (1.0.0-rc10)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getVoyager() { return getVersion("voyager"); }

        /**
         * Returns the group of versions at versions.accompanist
         */
        public AccompanistVersionAccessors getAccompanist() {
            return vaccForAccompanistVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.compose
         */
        public ComposeVersionAccessors getCompose() {
            return vaccForComposeVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.core
         */
        public CoreVersionAccessors getCore() {
            return vaccForCoreVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.koin
         */
        public KoinVersionAccessors getKoin() {
            return vaccForKoinVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.kotlinx
         */
        public KotlinxVersionAccessors getKotlinx() {
            return vaccForKotlinxVersionAccessors;
        }

    }

    public static class AccompanistVersionAccessors extends VersionFactory  {

        public AccompanistVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: accompanist.systemUIController (0.32.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSystemUIController() { return getVersion("accompanist.systemUIController"); }

    }

    public static class ComposeVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public ComposeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: compose (1.5.11)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("compose"); }

            /**
             * Returns the version associated to this alias: compose.activity (1.8.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getActivity() { return getVersion("compose.activity"); }

    }

    public static class CoreVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        private final CoreLibraryVersionAccessors vaccForCoreLibraryVersionAccessors = new CoreLibraryVersionAccessors(providers, config);
        public CoreVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: core (1.12.0)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("core"); }

        /**
         * Returns the group of versions at versions.core.library
         */
        public CoreLibraryVersionAccessors getLibrary() {
            return vaccForCoreLibraryVersionAccessors;
        }

    }

    public static class CoreLibraryVersionAccessors extends VersionFactory  {

        public CoreLibraryVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: core.library.desugaring (2.0.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDesugaring() { return getVersion("core.library.desugaring"); }

    }

    public static class KoinVersionAccessors extends VersionFactory  {

        public KoinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: koin.compose (1.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCompose() { return getVersion("koin.compose"); }

    }

    public static class KotlinxVersionAccessors extends VersionFactory  {

        public KotlinxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: kotlinx.coroutines (1.8.0-RC)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCoroutines() { return getVersion("kotlinx.coroutines"); }

    }

    public static class BundleAccessors extends BundleFactory {
        private final KtorBundleAccessors baccForKtorBundleAccessors = new KtorBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

        /**
         * Returns the group of bundles at bundles.ktor
         */
        public KtorBundleAccessors getKtor() {
            return baccForKtorBundleAccessors;
        }

    }

    public static class KtorBundleAccessors extends BundleFactory {

        public KtorBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

            /**
             * Creates a dependency bundle provider for ktor.common which is an aggregate for the following dependencies:
             * <ul>
             *    <li>io.ktor:ktor-client-core</li>
             *    <li>io.ktor:ktor-client-json</li>
             *    <li>io.ktor:ktor-client-logging</li>
             *    <li>io.ktor:ktor-client-serialization</li>
             *    <li>io.ktor:ktor-client-content-negotiation</li>
             *    <li>io.ktor:ktor-serialization-kotlinx-json</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getCommon() {
                return createBundle("ktor.common");
            }

    }

    public static class PluginAccessors extends PluginFactory {
        private final AndroidPluginAccessors paccForAndroidPluginAccessors = new AndroidPluginAccessors(providers, config);
        private final ComposePluginAccessors paccForComposePluginAccessors = new ComposePluginAccessors(providers, config);
        private final KotlinXPluginAccessors paccForKotlinXPluginAccessors = new KotlinXPluginAccessors(providers, config);
        private final SqlDelightPluginAccessors paccForSqlDelightPluginAccessors = new SqlDelightPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for jvm to the plugin id 'org.jetbrains.kotlin.jvm'
             * with versionRef 'kotlin'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getJvm() { return createPlugin("jvm"); }

            /**
             * Creates a plugin provider for ktor to the plugin id 'io.ktor.plugin'
             * with versionRef 'ktor'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getKtor() { return createPlugin("ktor"); }

            /**
             * Creates a plugin provider for multiplatform to the plugin id 'org.jetbrains.kotlin.multiplatform'
             * with versionRef 'kotlin'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getMultiplatform() { return createPlugin("multiplatform"); }

            /**
             * Creates a plugin provider for spotless to the plugin id 'com.diffplug.spotless'
             * with versionRef 'spotless'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getSpotless() { return createPlugin("spotless"); }

        /**
         * Returns the group of plugins at plugins.android
         */
        public AndroidPluginAccessors getAndroid() {
            return paccForAndroidPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.compose
         */
        public ComposePluginAccessors getCompose() {
            return paccForComposePluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.kotlinX
         */
        public KotlinXPluginAccessors getKotlinX() {
            return paccForKotlinXPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.sqlDelight
         */
        public SqlDelightPluginAccessors getSqlDelight() {
            return paccForSqlDelightPluginAccessors;
        }

    }

    public static class AndroidPluginAccessors extends PluginFactory {

        public AndroidPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for android.application to the plugin id 'com.android.application'
             * with versionRef 'gradle'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getApplication() { return createPlugin("android.application"); }

            /**
             * Creates a plugin provider for android.kotlin to the plugin id 'org.jetbrains.kotlin.android'
             * with versionRef 'kotlin'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getKotlin() { return createPlugin("android.kotlin"); }

            /**
             * Creates a plugin provider for android.library to the plugin id 'com.android.library'
             * with versionRef 'gradle'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getLibrary() { return createPlugin("android.library"); }

    }

    public static class ComposePluginAccessors extends PluginFactory {

        public ComposePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for compose.multiplatform to the plugin id 'org.jetbrains.compose'
             * with versionRef 'compose'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getMultiplatform() { return createPlugin("compose.multiplatform"); }

    }

    public static class KotlinXPluginAccessors extends PluginFactory {
        private final KotlinXSerializationPluginAccessors paccForKotlinXSerializationPluginAccessors = new KotlinXSerializationPluginAccessors(providers, config);

        public KotlinXPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.kotlinX.serialization
         */
        public KotlinXSerializationPluginAccessors getSerialization() {
            return paccForKotlinXSerializationPluginAccessors;
        }

    }

    public static class KotlinXSerializationPluginAccessors extends PluginFactory {

        public KotlinXSerializationPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for kotlinX.serialization.plugin to the plugin id 'org.jetbrains.kotlin.plugin.serialization'
             * with versionRef 'kotlin'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getPlugin() { return createPlugin("kotlinX.serialization.plugin"); }

    }

    public static class SqlDelightPluginAccessors extends PluginFactory {

        public SqlDelightPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for sqlDelight.plugin to the plugin id 'app.cash.sqldelight'
             * with versionRef 'sqlDelight'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getPlugin() { return createPlugin("sqlDelight.plugin"); }

    }

}
