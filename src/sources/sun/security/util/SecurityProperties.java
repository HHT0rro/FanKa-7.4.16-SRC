package sun.security.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Security;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SecurityProperties {
    public static final boolean INCLUDE_JAR_NAME_IN_EXCEPTIONS = includedInExceptions("jar");

    public static String privilegedGetOverridable(final String propName) {
        if (System.getSecurityManager() == null) {
            return getOverridableProperty(propName);
        }
        return (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: sun.security.util.SecurityProperties$$ExternalSyntheticLambda0
            @Override // java.security.PrivilegedAction
            public final Object run() {
                String overridableProperty;
                overridableProperty = SecurityProperties.getOverridableProperty(String.this);
                return overridableProperty;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getOverridableProperty(String propName) {
        String val = System.getProperty(propName);
        if (val == null) {
            return Security.getProperty(propName);
        }
        return val;
    }

    public static boolean includedInExceptions(String refName) {
        String val = privilegedGetOverridable("jdk.includeInExceptions");
        if (val == null) {
            return false;
        }
        String[] tokens = val.split(",");
        for (String token : tokens) {
            if (token.trim().equalsIgnoreCase(refName)) {
                return true;
            }
        }
        return false;
    }
}
