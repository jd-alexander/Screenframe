package app.screenframe.di.component

import app.screenframe.di.builder.ActivityBuilder
import app.screenframe.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class),(AppModule::class),(ActivityBuilder::class)])
interface AppComponent{

}
