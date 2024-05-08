package sun.security.action;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class GetIntegerAction implements PrivilegedAction<Integer> {
    private boolean defaultSet;
    private int defaultVal;
    private String theProp;

    public GetIntegerAction(String theProp) {
        this.theProp = theProp;
    }

    public GetIntegerAction(String theProp, int defaultVal) {
        this.theProp = theProp;
        this.defaultVal = defaultVal;
        this.defaultSet = true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.security.PrivilegedAction
    public Integer run() {
        Integer value = Integer.getInteger(this.theProp);
        if (value == null && this.defaultSet) {
            return Integer.valueOf(this.defaultVal);
        }
        return value;
    }

    public static Integer privilegedGetProperty(String theProp) {
        if (System.getSecurityManager() == null) {
            return Integer.getInteger(theProp);
        }
        return (Integer) AccessController.doPrivileged(new GetIntegerAction(theProp));
    }

    public static Integer privilegedGetProperty(String theProp, int defaultVal) {
        Integer value;
        if (System.getSecurityManager() == null) {
            value = Integer.getInteger(theProp);
        } else {
            value = (Integer) AccessController.doPrivileged(new GetIntegerAction(theProp));
        }
        return Integer.valueOf(value != null ? value.intValue() : defaultVal);
    }
}
