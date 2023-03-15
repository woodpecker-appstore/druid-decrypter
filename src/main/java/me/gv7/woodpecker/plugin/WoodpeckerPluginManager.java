package me.gv7.woodpecker.plugin;

import me.gv7.woodpecker.helper.DruidPasswdDcrypter;

public class WoodpeckerPluginManager implements IPluginManager {
    public void registerPluginManagerCallbacks(IPluginManagerCallbacks iPluginManagerCallbacks) {
        DruidPasswdDcrypter echoTextConverter = new DruidPasswdDcrypter();
        iPluginManagerCallbacks.registerHelperPlugin(echoTextConverter);
    }
}
