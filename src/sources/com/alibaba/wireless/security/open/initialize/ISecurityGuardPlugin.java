package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import com.alibaba.wireless.security.framework.IRouterComponent;
import com.alibaba.wireless.security.framework.ISGPluginInfo;
import com.alibaba.wireless.security.open.SecException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ISecurityGuardPlugin {
    Context getContext();

    <T> T getInterface(Class<T> cls);

    IRouterComponent getRouter();

    ISGPluginInfo getSGPluginInfo();

    IRouterComponent onPluginLoaded(Context context, IRouterComponent iRouterComponent, ISGPluginInfo iSGPluginInfo, String str, Object... objArr) throws SecException;
}
