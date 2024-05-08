package com.tencent.cloud.huiyansdkface.wehttp2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface WeDns {
    List<InetAddress> lookup(String str) throws UnknownHostException;
}
