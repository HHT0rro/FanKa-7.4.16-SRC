package com.alibaba.wireless.security.open.middletier;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;
import java.util.HashMap;

@InterfacePluginInfo(pluginName = "middletier")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ISensorComponent extends IComponent {
    public static final int PROCESS_GET = 3;
    public static final int PROCESS_RESET = 4;
    public static final int PROCESS_START = 1;
    public static final int PROCESS_STOP = 2;

    void init(HashMap<String, Object> hashMap) throws SecException;

    HashMap<String, Object> process(int i10) throws SecException;
}
