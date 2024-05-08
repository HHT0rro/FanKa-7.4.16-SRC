package com.alibaba.wireless.security.open.securitybody;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;
import java.util.HashMap;

@InterfacePluginInfo(pluginName = "securitybody")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ISecurityBodyComponent extends IComponent {
    boolean enterRiskScene(int i10, HashMap<String, Object> hashMap) throws SecException;

    String getSecurityBodyDataEx(String str, String str2, String str3, HashMap<String, String> hashMap, int i10, int i11) throws SecException;

    String getSecurityBodyDataEx(String str, HashMap<String, String> hashMap, int i10, int i11) throws SecException;

    boolean leaveRiskScene(int i10) throws SecException;
}
