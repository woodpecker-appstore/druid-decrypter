import com.alibaba.druid.filter.config.ConfigTools;
import org.junit.Test;

public class DruidPasswordDecryptTest {
    @Test
    public void DruidBefore1016() throws Exception {
        String password = "hbZoFfr14R2yGuWJwbUtYdXjF40Df5sXbHSJYzGECsK0p1W4bmrM64SJKU0rmWo+yjUSrtU1Drb+0eGhQT3Xlg==";
        System.out.println(ConfigTools.decrypt(password));
    }

    @Test
    public void DruidAfter1016() throws Exception {
        String publickey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKUAMHrATatXwODDAcHxfIcG6diYsw0l0Qfj/NJivHXMVs5JRYf4vao2nEXB+BxA3gHO0er3KiGpz2ieQjPgSF8CAwEAAQ==";
        String password = "Q+zSOJytnRLmFHxB9YdFXlMnJj2y60r0Z11OFTRTOYQ/4kzKDWIU6AtFUv+DeVLuitKPGXGIkmalAXaoApOlzw==";
        System.out.println(ConfigTools.decrypt(publickey, password));
    }
}
