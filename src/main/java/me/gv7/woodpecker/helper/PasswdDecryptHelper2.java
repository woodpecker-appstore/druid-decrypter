package me.gv7.woodpecker.helper;

import com.alibaba.druid.filter.config.ConfigTools;
import me.gv7.woodpecker.plugin.IArg;
import me.gv7.woodpecker.plugin.IArgsUsageBinder;
import me.gv7.woodpecker.plugin.IHelper;
import me.gv7.woodpecker.plugin.IResultOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PasswdDecryptHelper2 implements IHelper {

    public String getHelperTabCaption() {
        return "Druid after 1.0.16";
    }

    public IArgsUsageBinder getHelperCutomArgs() {
        IArgsUsageBinder argsUsageBinder = DruidPasswdDcrypter.pluginHelper.createArgsUsageBinder();
        List<IArg> args = new ArrayList();
        IArg argKey = DruidPasswdDcrypter.pluginHelper.createArg();
        argKey.setName("public_key");
        argKey.setDefaultValue("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKUAMHrATatXwODDAcHxfIcG6diYsw0l0Qfj/NJivHXMVs5JRYf4vao2nEXB+BxA3gHO0er3KiGpz2ieQjPgSF8CAwEAAQ==");
        argKey.setDescription("解密key");
        argKey.setRequired(true);
        args.add(argKey);
        IArg argStr = DruidPasswdDcrypter.pluginHelper.createArg();
        argStr.setName("encrypt_password");
        argStr.setDefaultValue("Q+zSOJytnRLmFHxB9YdFXlMnJj2y60r0Z11OFTRTOYQ/4kzKDWIU6AtFUv+DeVLuitKPGXGIkmalAXaoApOlzw==");
        argStr.setDescription("要解密的密文,比如password");
        argStr.setRequired(true);
        args.add(argStr);
        argsUsageBinder.setArgsList(args);
        return argsUsageBinder;
    }

    public void doHelp(Map<String, Object> customArgs, IResultOutput iResultOutput) throws Throwable {
        String key = (String)customArgs.get("public_key");
        String str = (String)customArgs.get("encrypt_password");

        try {
            String content = ConfigTools.decrypt(key, str);
            iResultOutput.successPrintln("Decryt result:");
            iResultOutput.rawPrintln("\n" + content + "\n");
        } catch (Exception var6) {
            iResultOutput.errorPrintln(DruidPasswdDcrypter.pluginHelper.getThrowableInfo(var6));
        }
    }
}
