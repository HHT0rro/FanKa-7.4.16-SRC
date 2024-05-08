package sun.security.action;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class GetBooleanAction implements PrivilegedAction<Boolean> {
    private String theProp;

    public GetBooleanAction(String theProp) {
        this.theProp = theProp;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.security.PrivilegedAction
    public Boolean run() {
        return Boolean.valueOf(Boolean.getBoolean(this.theProp));
    }

    public static boolean privilegedGetProperty(String theProp) {
        if (System.getSecurityManager() == null) {
            return Boolean.getBoolean(theProp);
        }
        return ((Boolean) AccessController.doPrivileged(new GetBooleanAction(theProp))).booleanValue();
    }
}
