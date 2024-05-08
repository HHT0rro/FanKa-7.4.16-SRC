package com.alibaba.wireless.security.open.middletier.fc;

import android.content.Context;
import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;
import java.util.HashMap;

@InterfacePluginInfo(pluginName = "middletier")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IFCComponent extends IComponent {
    public static final String KEY_BX_SLEEP = "bx-sleep";
    public static final String KEY_LOGIN_MODULE = "key_login_module";
    public static final String KEY_RESEND_DATA = "key-resend-data";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum ResponseHeaderType {
        KVO,
        KVL
    }

    String getFCPluginVersion() throws SecException;

    boolean needFCProcessOrNot(int i10, HashMap hashMap, ResponseHeaderType responseHeaderType) throws SecException;

    boolean needFCProcessOrNotV2(int i10, String str) throws SecException;

    void processFCContent(int i10, HashMap hashMap, IFCActionCallback iFCActionCallback, ResponseHeaderType responseHeaderType) throws SecException;

    void processFCContentV2(String str, IFCActionCallback iFCActionCallback) throws SecException;

    void setUp(Context context, HashMap hashMap) throws SecException;
}
