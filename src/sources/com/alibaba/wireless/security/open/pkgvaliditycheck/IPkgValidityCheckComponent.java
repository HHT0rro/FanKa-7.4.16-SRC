package com.alibaba.wireless.security.open.pkgvaliditycheck;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;

@InterfacePluginInfo(pluginName = "misc")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IPkgValidityCheckComponent extends IComponent {
    int checkEnvAndFiles(String... strArr) throws SecException;
}
