package nl.deschepers.laraveltinker.settings

import com.google.gson.JsonObject
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.project.Project
import com.intellij.util.xmlb.XmlSerializerUtil

@Service(Service.Level.PROJECT)
@State(
    name = "nl.deschepers.laraveltinker.settings.AppSettingsState",
    storages = [Storage("laravel-tinker.xml")]
)
class ProjectSettingsState : PersistentStateComponent<ProjectSettingsState> {
    var laravelRoot = ""
    var vendorRoot = ""
    var composerFilename = "composer.json"
    var terminateApp = false

    companion object {
        fun getInstance(project: Project): ProjectSettingsState {
            return project.getService(ProjectSettingsState::class.java)
        }
    }

    override fun getState(): ProjectSettingsState {
        return this
    }

    override fun loadState(state: ProjectSettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }

    fun parseJson(): JsonObject {
        val settingsObject = JsonObject()

        if (this.vendorRoot.isEmpty()) {
            this.vendorRoot = this.laravelRoot
        }

        if (this.composerFilename.isEmpty()) {
            this.composerFilename = "composer.json"
        }

        settingsObject.addProperty("laravelRoot", this.laravelRoot)
        settingsObject.addProperty("vendorRoot", this.vendorRoot)
        settingsObject.addProperty("composerFilename", this.composerFilename)
        settingsObject.addProperty("terminateApp", this.terminateApp)
        return settingsObject
    }
}
