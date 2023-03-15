package me.gv7.woodpecker.helper;

import me.gv7.woodpecker.plugin.*;

import java.util.ArrayList;
import java.util.List;

public class DruidPasswdDcrypter implements IHelperPlugin {
    public static IHelperPluginCallbacks callbacks;
    public static IPluginHelper pluginHelper;

    public DruidPasswdDcrypter() {
    }

    public void HelperPluginMain(IHelperPluginCallbacks iHelperPluginCallbacks) {
        callbacks = iHelperPluginCallbacks;
        pluginHelper = callbacks.getPluginHelper();
        callbacks.setHelperPluginName("druid password Decrypt");
        callbacks.setHelperPluginVersion("0.1.0");
        callbacks.setHelperPluginAutor("cike，woodpecker-org");
        callbacks.setHelperPluginDescription("解密druid加密的数据库链接字符串");
        List<IHelper> helperList = new ArrayList();
        helperList.add(new PasswdDecryptHelper1());
        helperList.add(new PasswdDecryptHelper2());
        callbacks.registerHelper(helperList);
    }
}
