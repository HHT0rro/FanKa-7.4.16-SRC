package com.alibaba.wireless.security.framework;

import com.alibaba.wireless.security.open.SecException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ISGPluginManager {
    <T> T getInterface(Class<T> cls) throws SecException;

    String getMainPluginName();

    ISGPluginInfo getPluginInfo(String str) throws SecException;

    IRouterComponent getRouter();
}
