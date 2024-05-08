package com.alibaba.wireless.security.jaq.securitybody;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.jaq.JAQException;
import com.alibaba.wireless.security.open.IComponent;
import java.util.HashMap;

@InterfacePluginInfo(pluginName = "securitybody")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IJAQVerificationComponent extends IComponent {
    String doJAQVerfificationSync(HashMap<String, String> hashMap, int i10) throws JAQException;
}
