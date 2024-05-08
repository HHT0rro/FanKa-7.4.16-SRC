package com.alibaba.wireless.security.mainplugin;

import com.alibaba.wireless.security.open.atlasencrypt.IAtlasEncryptComponent;
import com.alibaba.wireless.security.open.datacollection.IDataCollectionComponent;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import com.alibaba.wireless.security.open.opensdk.IOpenSDKComponent;
import com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import p001.p002.p003.p004.p005.p006.C0847;
import p001.p002.p003.p004.p005.p008.C0849;
import p001.p002.p003.p004.p005.p009.C0850;
import p001.p002.p003.p004.p005.p010.C0851;
import p001.p002.p003.p004.p005.p011.C0852;
import p001.p002.p003.p004.p005.p012.C0855;
import p001.p002.p003.p004.p005.p013.C0856;
import p001.p002.p003.p004.p005.p014.C0857;
import p001.p002.p003.p004.p005.p015.C0858;
import p001.p002.p003.p004.p005.p016.C0859;
import p001.p002.p003.p004.p005.p017.C0860;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: com.alibaba.wireless.security.mainplugin.в, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0076 {
    /* renamed from: а, reason: contains not printable characters */
    public static Object m1924(Class cls, InvocationHandler invocationHandler) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler);
    }

    /* renamed from: а, reason: contains not printable characters */
    public void m1925(HashMap<Class, Object> hashMap, SecurityGuardMainPlugin securityGuardMainPlugin) {
        Object m3883;
        hashMap.put(IAtlasEncryptComponent.class, new C0847(securityGuardMainPlugin));
        hashMap.put(IDataCollectionComponent.class, new C0849(securityGuardMainPlugin));
        hashMap.put(IDynamicDataEncryptComponent.class, new C0850(securityGuardMainPlugin));
        hashMap.put(IDynamicDataStoreComponent.class, new C0851(securityGuardMainPlugin));
        hashMap.put(IOpenSDKComponent.class, new C0860(securityGuardMainPlugin));
        hashMap.put(ISecureSignatureComponent.class, new C0856(securityGuardMainPlugin));
        hashMap.put(IStaticDataEncryptComponent.class, new C0857(securityGuardMainPlugin));
        hashMap.put(IStaticDataStoreComponent.class, new C0858(securityGuardMainPlugin));
        hashMap.put(IStaticKeyEncryptComponent.class, new C0859(securityGuardMainPlugin));
        hashMap.put(ISafeTokenComponent.class, new C0855(securityGuardMainPlugin));
        try {
            Class<?> cls = Class.forName("com.alibaba.wireless.security.open.litevm.ILiteVMComponent");
            if (cls == null || (m3883 = C0852.m3883(cls, securityGuardMainPlugin)) == null) {
                return;
            }
            hashMap.put(cls, m3883);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x007c. Please report as an issue. */
    /* renamed from: а, reason: contains not printable characters */
    public void m1926(HashMap<Class, Object> hashMap, String str, SecurityGuardMainPlugin securityGuardMainPlugin) {
        char c4;
        Class cls;
        Object c0847;
        Object m3883;
        switch (str.hashCode()) {
            case -2107806319:
                if (str.equals("com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent")) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case -1726912853:
                if (str.equals("com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case -319873839:
                if (str.equals("com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent")) {
                    c4 = '\t';
                    break;
                }
                c4 = 65535;
                break;
            case -308669071:
                if (str.equals("com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case -202074525:
                if (str.equals("com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case 1282550417:
                if (str.equals("com.alibaba.wireless.security.open.opensdk.IOpenSDKComponent")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case 1441811571:
                if (str.equals("com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent")) {
                    c4 = '\b';
                    break;
                }
                c4 = 65535;
                break;
            case 1464630417:
                if (str.equals("com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent")) {
                    c4 = 7;
                    break;
                }
                c4 = 65535;
                break;
            case 1852512071:
                if (str.equals("com.alibaba.wireless.security.open.atlasencrypt.IAtlasEncryptComponent")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case 1868651473:
                if (str.equals("com.alibaba.wireless.security.open.litevm.ILiteVMComponent")) {
                    c4 = '\n';
                    break;
                }
                c4 = 65535;
                break;
            case 2038834859:
                if (str.equals("com.alibaba.wireless.security.open.datacollection.IDataCollectionComponent")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
                cls = IAtlasEncryptComponent.class;
                c0847 = new C0847(securityGuardMainPlugin);
                hashMap.put(cls, c0847);
                return;
            case 1:
                cls = IDataCollectionComponent.class;
                c0847 = new C0849(securityGuardMainPlugin);
                hashMap.put(cls, c0847);
                return;
            case 2:
                cls = IDynamicDataEncryptComponent.class;
                c0847 = new C0850(securityGuardMainPlugin);
                hashMap.put(cls, c0847);
                return;
            case 3:
                cls = IDynamicDataStoreComponent.class;
                c0847 = new C0851(securityGuardMainPlugin);
                hashMap.put(cls, c0847);
                return;
            case 4:
                cls = IOpenSDKComponent.class;
                c0847 = new C0860(securityGuardMainPlugin);
                hashMap.put(cls, c0847);
                return;
            case 5:
                cls = ISecureSignatureComponent.class;
                c0847 = new C0856(securityGuardMainPlugin);
                hashMap.put(cls, c0847);
                return;
            case 6:
                cls = IStaticDataEncryptComponent.class;
                c0847 = new C0857(securityGuardMainPlugin);
                hashMap.put(cls, c0847);
                return;
            case 7:
                cls = IStaticDataStoreComponent.class;
                c0847 = new C0858(securityGuardMainPlugin);
                hashMap.put(cls, c0847);
                return;
            case '\b':
                cls = IStaticKeyEncryptComponent.class;
                c0847 = new C0859(securityGuardMainPlugin);
                hashMap.put(cls, c0847);
                return;
            case '\t':
                cls = ISafeTokenComponent.class;
                c0847 = new C0855(securityGuardMainPlugin);
                hashMap.put(cls, c0847);
                return;
            case '\n':
                try {
                    Class<?> cls2 = Class.forName("com.alibaba.wireless.security.open.litevm.ILiteVMComponent");
                    if (cls2 == null || (m3883 = C0852.m3883(cls2, securityGuardMainPlugin)) == null) {
                        return;
                    }
                    hashMap.put(cls2, m3883);
                    return;
                } catch (Exception unused) {
                    return;
                }
            default:
                return;
        }
    }
}
