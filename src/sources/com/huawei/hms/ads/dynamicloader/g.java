package com.huawei.hms.ads.dynamicloader;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.dynamicloader.versionstrategy.VersionStrategyFactory;
import com.huawei.hms.ads.uiengineloader.aa;
import com.huawei.hms.ads.uiengineloader.ac;
import com.huawei.hms.ads.uiengineloader.ah;
import com.huawei.hms.ads.uiengineloader.q;
import com.huawei.hms.ads.uiengineloader.t;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class g extends IDynamicLoader.Stub {

    /* renamed from: b, reason: collision with root package name */
    public static String f29162b = null;

    /* renamed from: c, reason: collision with root package name */
    private static final String f29163c = "DynamicLoader";

    /* renamed from: d, reason: collision with root package name */
    private static final String f29164d = "version_strategy_type";

    private static IObjectWrapper a(Context context, Bundle bundle) throws RemoteException {
        String string = bundle.getString("module_name");
        f29162b = bundle.getString("loader_path");
        int i10 = bundle.getInt("version_strategy_type");
        String string2 = bundle.getString("loader_version_type", b.f29144f);
        aa.b("DynamicLoader", "the moduleName is:" + string + ", versionStrategyType:" + i10 + " loaderVersionType : " + string2);
        try {
            ah versionPolicy = VersionStrategyFactory.getVersionPolicy(i10);
            if (versionPolicy == null) {
                aa.c("DynamicLoader", "Invalid version policy.");
                return ac.a((Object) null);
            }
            q a10 = versionPolicy.a(context, bundle);
            if (a10 == null) {
                throw new RemoteException("Get loading strategy failed.");
            }
            t a11 = a10.a(context, string);
            if (a11 != null) {
                a11.f29487f = string2;
                return ac.a(a10.a(context, a11));
            }
            aa.b("DynamicLoader", "moduleInfo is null");
            throw new RemoteException("Null moduleInfo.");
        } catch (j e2) {
            aa.c("DynamicLoader", "LoaderException:" + e2.getMessage());
            Bundle bundle2 = e2.f29169a;
            if (bundle2 != null) {
                aa.c("DynamicLoader", "Get bundle from LoaderException.");
                return ac.a(bundle2);
            }
            throw new RemoteException("Load failed:" + e2.getMessage());
        } catch (Exception e10) {
            aa.c("DynamicLoader", "Other exception." + e10.getClass().getSimpleName());
            throw new RemoteException("Load dynamic module failed.");
        }
    }

    @Override // com.huawei.hms.ads.dynamic.IDynamicLoader
    public final IObjectWrapper load(IObjectWrapper iObjectWrapper, String str, int i10, IObjectWrapper iObjectWrapper2) throws RemoteException {
        if (iObjectWrapper == null) {
            aa.c("DynamicLoader", "The context is null.");
            return ac.a((Object) null);
        }
        Context context = (Context) ac.a(iObjectWrapper);
        Object a10 = ac.a(iObjectWrapper2);
        if (!(a10 instanceof Bundle)) {
            aa.c("DynamicLoader", "The moduleInfo type is not Bundle.");
            return ac.a((Object) null);
        }
        Bundle bundle = (Bundle) a10;
        int i11 = bundle.getInt("version_strategy_type", 0);
        aa.b("DynamicLoader", "versionType=".concat(String.valueOf(i11)));
        if (i11 != 0) {
            return a(context, bundle);
        }
        h.a(context);
        return ac.a(h.a(context, bundle));
    }
}
