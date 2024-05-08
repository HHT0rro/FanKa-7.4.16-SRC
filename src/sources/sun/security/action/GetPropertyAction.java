package sun.security.action;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Properties;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class GetPropertyAction implements PrivilegedAction<String> {
    private String defaultVal;
    private String theProp;

    public GetPropertyAction(String theProp) {
        this.theProp = theProp;
    }

    public GetPropertyAction(String theProp, String defaultVal) {
        this.theProp = theProp;
        this.defaultVal = defaultVal;
    }

    @Override // java.security.PrivilegedAction
    public String run() {
        String value = System.getProperty(this.theProp);
        return value == null ? this.defaultVal : value;
    }

    public static String privilegedGetProperty(String theProp) {
        if (System.getSecurityManager() == null) {
            return System.getProperty(theProp);
        }
        return (String) AccessController.doPrivileged(new GetPropertyAction(theProp));
    }

    public static String privilegedGetProperty(String theProp, String defaultVal) {
        if (System.getSecurityManager() == null) {
            return System.getProperty(theProp, defaultVal);
        }
        return (String) AccessController.doPrivileged(new GetPropertyAction(theProp, defaultVal));
    }

    public static Properties privilegedGetProperties() {
        if (System.getSecurityManager() == null) {
            return System.getProperties();
        }
        return (Properties) AccessController.doPrivileged(new PrivilegedAction<Properties>() { // from class: sun.security.action.GetPropertyAction.1
            @Override // java.security.PrivilegedAction
            public Properties run() {
                return System.getProperties();
            }
        });
    }
}
