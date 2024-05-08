package com.tencent.mm.opensdk.channel.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    public static byte[] a(String str, int i10, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i10);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return com.tencent.mm.opensdk.utils.b.c(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}
