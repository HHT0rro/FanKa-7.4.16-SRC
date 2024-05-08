package com.alibaba.wireless.security.jaq.avmp;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.jaq.JAQException;

@InterfacePluginInfo(pluginName = "middletier")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IJAQAVMPSignComponent {
    public static final int JAQ_SIGNTYPE_HMACSHA1 = 1;
    public static final int JAQ_SIGNTYPE_MWUA = 0;

    byte[] avmpSign(int i10, byte[] bArr) throws JAQException;

    boolean initialize() throws JAQException;

    boolean uninitialize() throws JAQException;
}
