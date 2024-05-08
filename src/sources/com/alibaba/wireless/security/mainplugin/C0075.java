package com.alibaba.wireless.security.mainplugin;

import com.alibaba.wireless.security.framework.IRouterComponent;
import com.taobao.wireless.security.adapter.JNICLibrary;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: com.alibaba.wireless.security.mainplugin.б, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0075 implements IRouterComponent {
    @Override // com.alibaba.wireless.security.framework.IRouterComponent
    public Object doCommand(int i10, Object... objArr) {
        return JNICLibrary.doCommandNative(i10, objArr);
    }
}
