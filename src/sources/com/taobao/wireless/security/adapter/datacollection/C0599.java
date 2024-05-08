package com.taobao.wireless.security.adapter.datacollection;

import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.taobao.wireless.security.adapter.common.SPUtility2;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: com.taobao.wireless.security.adapter.datacollection.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0599 {

    /* renamed from: б, reason: contains not printable characters */
    private static final Object f225 = new Object();

    /* renamed from: в, reason: contains not printable characters */
    private static volatile C0599 f226;

    /* renamed from: а, reason: contains not printable characters */
    private ISecurityGuardPlugin f227;

    private C0599(ISecurityGuardPlugin iSecurityGuardPlugin) {
        this.f227 = iSecurityGuardPlugin;
        DeviceInfoCapturer.initialize(iSecurityGuardPlugin, this);
    }

    /* renamed from: а, reason: contains not printable characters */
    public static C0599 m2892(ISecurityGuardPlugin iSecurityGuardPlugin) {
        if (f226 == null) {
            synchronized (C0599.class) {
                if (f226 == null) {
                    f226 = new C0599(iSecurityGuardPlugin);
                }
            }
        }
        return f226;
    }

    /* renamed from: б, reason: contains not printable characters */
    private void m2893() {
        this.f227.getRouter().doCommand(10901, new Object[0]);
    }

    /* renamed from: а, reason: contains not printable characters */
    public String m2894() {
        String readFromSPUnified;
        synchronized (f225) {
            readFromSPUnified = SPUtility2.readFromSPUnified("DataCollectionData", "key_nick", "");
        }
        return readFromSPUnified;
    }

    /* renamed from: а, reason: contains not printable characters */
    public String m2895(int i10) {
        return null;
    }

    /* renamed from: а, reason: contains not printable characters */
    public boolean m2896(String str) {
        synchronized (f225) {
            if (str == null) {
                str = "";
            }
            String m2894 = m2894();
            if (str.equals(m2894) || !SPUtility2.saveToSPUnified("DataCollectionData", "key_nick", str, true)) {
                return false;
            }
            if (m2894 != null && m2894.length() != 0) {
                m2893();
            }
            return true;
        }
    }
}
