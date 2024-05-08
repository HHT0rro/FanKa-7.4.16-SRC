package t7;

import android.os.RemoteException;
import b7.k;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {
    public static RemoteException a(String str) {
        if (k.a()) {
            return new RemoteException(str);
        }
        return new RemoteException();
    }
}
