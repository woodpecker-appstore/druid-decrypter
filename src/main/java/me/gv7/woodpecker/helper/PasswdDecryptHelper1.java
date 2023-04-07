package me.gv7.woodpecker.helper;

import com.alibaba.druid.filter.config.ConfigTools;
import me.gv7.woodpecker.plugin.IArg;
import me.gv7.woodpecker.plugin.IArgsUsageBinder;
import me.gv7.woodpecker.plugin.IHelper;
import me.gv7.woodpecker.plugin.IResultOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PasswdDecryptHelper1 implements IHelper {
    public PasswdDecryptHelper1() {
    }

    public String getHelperTabCaption() {
        return "Druid before 1.0.16";
    }

    public IArgsUsageBinder getHelperCutomArgs() {
        IArgsUsageBinder argsUsageBinder = DruidPasswdDcrypter.pluginHelper.createArgsUsageBinder();
        List<IArg> args = new ArrayList();
        IArg argPassword = DruidPasswdDcrypter.pluginHelper.createArg();
        argPassword.setName("encrypt_password");
        argPassword.setDefaultValue("hbZoFfr14R2yGuWJwbUtYdXjF40Df5sXbHSJYzGECsK0p1W4bmrM64SJKU0rmWo+yjUSrtU1Drb+0eGhQT3Xlg==");
        argPassword.setDescription("解密key");
        argPassword.setRequired(true);
        args.add(argPassword);
        argsUsageBinder.setArgsList(args);
        return argsUsageBinder;
    }

    public void doHelp(Map<String, Object> customArgs, IResultOutput iResultOutput) throws Throwable {
        String password = (String)customArgs.get("encrypt_password");
        try {
            String content = ConfigTools.decrypt(password);
            iResultOutput.successPrintln("Decryt result:");
            iResultOutput.rawPrintln("\n" + content + "\n");
        } catch (Exception var6) {
            iResultOutput.errorPrintln(DruidPasswdDcrypter.pluginHelper.getThrowableInfo(var6));
        }
    }
}
