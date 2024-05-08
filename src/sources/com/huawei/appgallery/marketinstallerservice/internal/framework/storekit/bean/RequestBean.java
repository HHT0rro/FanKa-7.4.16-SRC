package com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean;

import android.content.Context;
import android.os.Build;
import ca.a;
import ca.b;
import ca.c;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class RequestBean {
    public static final int CHINA = 0;
    public static final int GLOBAL = 1;

    /* renamed from: a, reason: collision with root package name */
    public Context f27618a;

    /* renamed from: b, reason: collision with root package name */
    public String f27619b;

    @InstallerNetTransmission
    public String brand;

    @InstallerNetTransmission
    private String buildNumber;

    @InstallerNetTransmission
    private String code;

    @InstallerNetTransmission
    private String density;

    @InstallerNetTransmission
    private int deviceType;

    @InstallerNetTransmission
    private int emuiApiLevel;

    @InstallerNetTransmission
    private String emuiVer;

    @InstallerNetTransmission
    private int firmwareVersion;

    @InstallerNetTransmission
    private int international;

    @InstallerNetTransmission
    private String lang;

    @InstallerNetTransmission
    public int magicApiLevel;

    @InstallerNetTransmission
    public String magicVer;

    @InstallerNetTransmission
    private String manufacturer;

    @InstallerNetTransmission
    private String method;

    @InstallerNetTransmission
    private int net;

    @InstallerNetTransmission
    private int odm;

    @InstallerNetTransmission
    private String phoneType;

    @InstallerNetTransmission
    private String sdkVersion;

    @InstallerNetTransmission
    private String subsystem;

    @InstallerNetTransmission
    private int sysBits;

    @InstallerNetTransmission
    private long ts;

    @InstallerNetTransmission
    private String ver;

    public RequestBean() {
        this.code = "0500";
        this.ver = "8.0";
        this.emuiApiLevel = 0;
        this.international = 0;
        this.manufacturer = Build.MANUFACTURER;
        this.odm = 0;
        this.f27619b = "";
        this.brand = Build.BRAND;
    }

    public RequestBean(Context context) {
        this.code = "0500";
        this.ver = "8.0";
        this.emuiApiLevel = 0;
        this.international = 0;
        this.manufacturer = Build.MANUFACTURER;
        this.odm = 0;
        this.f27619b = "";
        this.brand = Build.BRAND;
        this.f27618a = context;
        this.firmwareVersion = a.k();
        this.density = a.h(context);
        this.phoneType = a.i();
        this.buildNumber = a.d();
        this.lang = c.a();
        this.sysBits = a.m();
        this.deviceType = a.a(context);
        this.international = c.b() ? 1 : 0;
        if (a.p()) {
            this.odm = 1;
        }
        this.sdkVersion = "11.5.1.300";
        this.magicVer = a.g();
        this.magicApiLevel = a.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.reflect.Field r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.getName()
            java.lang.Class r1 = r8.getType()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "boolean"
            boolean r1 = r2.equals(r1)
            java.lang.String r0 = ja.a.a(r0, r1)
            java.lang.String r1 = "getValue:Can not find getMethod:"
            r2 = 0
            java.lang.String r3 = "RequestBean"
            if (r0 != 0) goto L34
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r8 = r8.getName()
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            fa.a.c(r3, r8)
            return r2
        L34:
            java.lang.Class r4 = r7.getClass()     // Catch: java.lang.reflect.InvocationTargetException -> L46 java.lang.SecurityException -> L4e java.lang.NoSuchMethodException -> L56
            r5 = 0
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.reflect.InvocationTargetException -> L46 java.lang.SecurityException -> L4e java.lang.NoSuchMethodException -> L56
            java.lang.reflect.Method r0 = r4.getMethod(r0, r6)     // Catch: java.lang.reflect.InvocationTargetException -> L46 java.lang.SecurityException -> L4e java.lang.NoSuchMethodException -> L56
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch: java.lang.reflect.InvocationTargetException -> L46 java.lang.SecurityException -> L4e java.lang.NoSuchMethodException -> L56
            java.lang.Object r8 = r0.invoke(r7, r4)     // Catch: java.lang.reflect.InvocationTargetException -> L46 java.lang.SecurityException -> L4e java.lang.NoSuchMethodException -> L56
            goto L6d
        L46:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getValue:GetMethod can not invocation:"
            goto L5b
        L4e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getValue:GetMethod can not access:"
            goto L5b
        L56:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L5b:
            r0.append(r1)
            java.lang.String r8 = r8.getName()
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            fa.a.c(r3, r8)
            r8 = r2
        L6d:
            boolean r0 = r8 instanceof com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.JsonBean
            if (r0 == 0) goto L78
            com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.JsonBean r8 = (com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.JsonBean) r8
            java.lang.String r8 = r8.toJson()
            return r8
        L78:
            boolean r0 = r8 instanceof java.util.List
            if (r0 == 0) goto L83
            java.util.List r8 = (java.util.List) r8
            java.lang.String r8 = com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.JsonBean.listToJson(r8)
            return r8
        L83:
            boolean r0 = r8 instanceof java.lang.reflect.Array
            if (r0 == 0) goto L8e
            java.lang.reflect.Array r8 = (java.lang.reflect.Array) r8
            java.lang.String r8 = com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.JsonBean.arrayToJson(r8)
            return r8
        L8e:
            boolean r0 = r8 instanceof java.util.Map
            if (r0 == 0) goto L99
            java.util.Map r8 = (java.util.Map) r8
            java.lang.String r8 = com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.JsonBean.mapToJson(r8)
            return r8
        L99:
            if (r8 == 0) goto La0
            java.lang.String r8 = java.lang.String.valueOf(r8)
            return r8
        La0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.RequestBean.a(java.lang.reflect.Field):java.lang.String");
    }

    public Map<String, Field> b() {
        HashMap hashMap = new HashMap();
        for (Field field : ha.a.c(getClass())) {
            if (field.isAnnotationPresent(InstallerNetTransmission.class)) {
                hashMap.put(field.getName(), field);
            }
        }
        return hashMap;
    }

    public void c() {
        this.net = ga.c.d(this.f27618a);
        this.ts = System.currentTimeMillis();
        this.emuiVer = b.e().c();
        this.emuiApiLevel = b.e().a();
    }

    public String genBody() {
        String a10;
        c();
        Map<String, Field> b4 = b();
        int size = b4.size();
        String[] strArr = new String[size];
        b4.h().toArray(strArr);
        Arrays.sort(strArr);
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        do {
            Field field = b4.get(strArr[i10]);
            if (field != null && (a10 = a(field)) != null) {
                String a11 = da.b.a(a10);
                sb2.append(strArr[i10]);
                sb2.append('=');
                sb2.append(a11);
                sb2.append(SymbolValues.CHAR_AND_SYMBOL);
            }
            i10++;
        } while (i10 < size);
        int length = sb2.length();
        if (length > 0) {
            int i11 = length - 1;
            if (sb2.charAt(i11) == '&') {
                sb2.deleteCharAt(i11);
            }
        }
        return sb2.toString();
    }

    public String getBrand() {
        return this.brand;
    }

    public String getBuildNumber() {
        return this.buildNumber;
    }

    public String getCode() {
        return this.code;
    }

    public Context getContext() {
        return this.f27618a;
    }

    public String getDensity() {
        return this.density;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public int getEmuiApiLevel() {
        return this.emuiApiLevel;
    }

    public String getEmuiVer() {
        return this.emuiVer;
    }

    public int getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public int getInternational() {
        return this.international;
    }

    public String getLang() {
        return this.lang;
    }

    public int getMagicApiLevel() {
        return this.magicApiLevel;
    }

    public String getMagicVer() {
        return this.magicVer;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getMethod() {
        return this.method;
    }

    public int getNet() {
        return this.net;
    }

    public int getOdm() {
        return this.odm;
    }

    public String getPhoneType() {
        return this.phoneType;
    }

    public ResponseBean getResponseBean() {
        return new ResponseBean();
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public String getServiceUrl() {
        return this.f27619b;
    }

    public String getSubsystem() {
        return this.subsystem;
    }

    public int getSysBits() {
        return this.sysBits;
    }

    public long getTs() {
        return this.ts;
    }

    public String getVer() {
        return this.ver;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setBuildNumber(String str) {
        this.buildNumber = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setContext(Context context) {
        this.f27618a = context;
    }

    public void setDensity(String str) {
        this.density = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setEmuiApiLevel(int i10) {
        this.emuiApiLevel = i10;
    }

    public void setEmuiVer(String str) {
        this.emuiVer = str;
    }

    public void setFirmwareVersion(int i10) {
        this.firmwareVersion = i10;
    }

    public void setInternational(int i10) {
        this.international = i10;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setMagicApiLevel(int i10) {
        this.magicApiLevel = i10;
    }

    public void setMagicVer(String str) {
        this.magicVer = str;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setNet(int i10) {
        this.net = i10;
    }

    public void setOdm(int i10) {
        this.odm = i10;
    }

    public void setPhoneType(String str) {
        this.phoneType = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public void setServiceUrl(String str) {
        this.f27619b = str;
    }

    public void setSubsystem(String str) {
        this.subsystem = str;
    }

    public void setSysBits(int i10) {
        this.sysBits = i10;
    }

    public void setTs(long j10) {
        this.ts = j10;
    }

    public void setVer(String str) {
        this.ver = str;
    }
}
