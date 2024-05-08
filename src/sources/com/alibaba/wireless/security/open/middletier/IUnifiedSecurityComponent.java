package com.alibaba.wireless.security.open.middletier;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;
import java.util.HashMap;

@InterfacePluginInfo(pluginName = "middletier")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IUnifiedSecurityComponent extends IComponent {
    public static final int ENV_DAILY = 2;
    public static final int ENV_ONLINE = 0;
    public static final int ENV_PRE = 1;

    HashMap<String, String> getSecurityFactors(HashMap<String, Object> hashMap) throws SecException;

    void init(HashMap<String, Object> hashMap) throws SecException;
}
