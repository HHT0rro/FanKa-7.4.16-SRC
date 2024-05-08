package com.alibaba.wireless.security.open.maldetection;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;

@InterfacePluginInfo(pluginName = "securitybody")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IMalDetect extends IComponent {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface ICallBack {
        void onDetection(int i10, String str, String str2);
    }

    void registerCallBack(ICallBack iCallBack);

    void unregisterCallBack(ICallBack iCallBack);
}
