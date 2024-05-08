package java.security;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AuthProvider extends Provider {
    public abstract void login(Subject subject, CallbackHandler callbackHandler) throws LoginException;

    public abstract void logout() throws LoginException;

    public abstract void setCallbackHandler(CallbackHandler callbackHandler);

    protected AuthProvider(String name, double version, String info) {
        super("", ShadowDrawableWrapper.COS_45, "");
    }
}
