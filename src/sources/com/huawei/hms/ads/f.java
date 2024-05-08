package com.huawei.hms.ads;

import android.content.Context;
import android.os.IBinder;
import com.huawei.hms.ads.dynamic.DynamicModule;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f {
    private static String B = null;
    private static com.huawei.hms.ads.uiengine.d C = null;
    private static final String Code = "RemoteSdkInitializer";
    private static volatile Context I = null;
    private static final List<String> S;
    private static final String V = "adsuiengine";
    private static IRemoteCreator Z;

    static {
        ArrayList arrayList = new ArrayList();
        S = arrayList;
        arrayList.add(com.huawei.openalliance.ad.constant.u.co);
    }

    public static synchronized IRemoteCreator Code(Context context) {
        Context V2;
        synchronized (f.class) {
            gl.V(Code, "newCreator: ");
            if (Z != null) {
                gl.V(Code, "newCreator: mRemoteCreator != null return");
                return Z;
            }
            try {
                V2 = V(context);
            } catch (Throwable th) {
                gl.Z(Code, "newCreator failed " + th.getLocalizedMessage());
            }
            if (V2 == null) {
                return null;
            }
            IRemoteCreator Code2 = IRemoteCreator.b.Code((IBinder) V2.getClassLoader().loadClass("com.huawei.hms.ads.uiengine.remote.RemoteCreator").newInstance());
            Z = Code2;
            B = Code2.getVersion();
            Z.setGlobalUtil(com.huawei.openalliance.ad.inter.e.Code(context));
            C = Z.getUiEngineUtil();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("newRemoteContext: mRemoteCreator :");
            sb2.append((Object) Z);
            return Z;
        }
    }

    public static synchronized String Code() {
        String str;
        synchronized (f.class) {
            str = B;
        }
        return str;
    }

    private static Integer I(Context context) {
        return Integer.valueOf(S.contains(context.getPackageName()) ? 2 : 1);
    }

    private static Context V(Context context) {
        gl.V(Code, "newRemoteContext: ");
        if (I != null) {
            return I;
        }
        try {
            I = DynamicModule.load(context, I(context), V).getModuleContext();
        } catch (Throwable th) {
            gl.Z(Code, "newRemoteContext failed: " + th.getLocalizedMessage());
        }
        return I;
    }

    public static com.huawei.hms.ads.uiengine.d V() {
        return C;
    }
}
