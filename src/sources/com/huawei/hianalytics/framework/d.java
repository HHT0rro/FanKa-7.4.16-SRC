package com.huawei.hianalytics.framework;

import com.huawei.hianalytics.framework.config.DeviceAttributeCollector;
import com.huawei.hianalytics.framework.config.EvtHeaderAttributeCollector;
import com.huawei.hianalytics.framework.config.RomAttributeCollector;
import java.nio.charset.Charset;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d {

    /* renamed from: g, reason: collision with root package name */
    public static final Charset f28767g = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public DeviceAttributeCollector f28768a;

    /* renamed from: b, reason: collision with root package name */
    public EvtHeaderAttributeCollector f28769b;

    /* renamed from: c, reason: collision with root package name */
    public RomAttributeCollector f28770c;

    /* renamed from: d, reason: collision with root package name */
    public String f28771d;

    /* renamed from: e, reason: collision with root package name */
    public String f28772e;

    /* renamed from: f, reason: collision with root package name */
    public String f28773f;

    public d(DeviceAttributeCollector deviceAttributeCollector, EvtHeaderAttributeCollector evtHeaderAttributeCollector, RomAttributeCollector romAttributeCollector, String str, String str2, String str3) {
        this.f28768a = deviceAttributeCollector;
        this.f28769b = evtHeaderAttributeCollector;
        this.f28770c = romAttributeCollector;
        this.f28773f = str;
        this.f28771d = str2;
        this.f28772e = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject a(java.util.List<com.huawei.hianalytics.core.storage.Event> r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.framework.d.a(java.util.List, boolean):org.json.JSONObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject a(com.huawei.hianalytics.core.storage.Event r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "UploadEvtModel"
            r1 = 0
            if (r7 != 0) goto L11
            java.lang.String r7 = "debug Not have actionEvent to send，TAG: "
            java.lang.StringBuilder r7 = e9.a.b(r7)
            java.lang.String r8 = r6.f28771d
            e9.a.e(r7, r8, r0)
            return r1
        L11:
            com.huawei.hianalytics.framework.config.EvtHeaderAttributeCollector r2 = r6.f28769b
            if (r2 == 0) goto Lcf
            com.huawei.hianalytics.framework.config.DeviceAttributeCollector r2 = r6.f28768a
            if (r2 == 0) goto Lcf
            com.huawei.hianalytics.framework.config.RomAttributeCollector r2 = r6.f28770c
            if (r2 != 0) goto L1f
            goto Lcf
        L1f:
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            if (r2 != 0) goto L4c
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L37
            r2.<init>(r8)     // Catch: org.json.JSONException -> L37
            java.lang.String r8 = "headerEx"
            org.json.JSONObject r8 = r2.getJSONObject(r8)     // Catch: org.json.JSONException -> L37
            java.lang.String r3 = "commonEx"
            org.json.JSONObject r2 = r2.getJSONObject(r3)     // Catch: org.json.JSONException -> L38
            goto L4e
        L37:
            r8 = r1
        L38:
            java.lang.String r2 = "evtExConfig is error : nc_common data，TAG: "
            java.lang.StringBuilder r2 = e9.a.b(r2)
            java.lang.String r3 = r6.f28771d
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.huawei.hianalytics.core.log.HiLog.e(r0, r2)
            r2 = r1
            goto L4e
        L4c:
            r8 = r1
            r2 = r8
        L4e:
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            com.huawei.hianalytics.framework.config.EvtHeaderAttributeCollector r4 = r6.f28769b
            r5 = 1
            org.json.JSONObject r8 = r4.doCollector(r8, r5)
            if (r8 != 0) goto L62
            java.lang.String r7 = "debug headerJson is null"
            com.huawei.hianalytics.core.log.HiLog.sw(r0, r7)
            return r1
        L62:
            java.lang.String r4 = "header"
            r3.put(r4, r8)
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            com.huawei.hianalytics.framework.config.DeviceAttributeCollector r4 = r6.f28768a
            org.json.JSONObject r2 = r4.doCollector(r2)
            com.huawei.hianalytics.framework.config.RomAttributeCollector r4 = r6.f28770c
            org.json.JSONObject r4 = r4.doCollector()
            java.lang.String r5 = "properties"
            r2.put(r5, r4)
            java.lang.String r4 = "events_common"
            r8.put(r4, r2)
            org.json.JSONArray r2 = new org.json.JSONArray
            r2.<init>()
            java.lang.String r4 = r7.getContent()
            r7.setContent(r4)
            org.json.JSONObject r7 = r7.toJson()
            if (r7 == 0) goto L97
            r2.put(r7)
        L97:
            int r7 = r2.length()
            if (r7 != 0) goto Lb0
            java.lang.String r7 = "debug send data is empty，TAG: "
            java.lang.StringBuilder r7 = e9.a.b(r7)
            java.lang.String r8 = r6.f28771d
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.huawei.hianalytics.core.log.HiLog.si(r0, r7)
            return r1
        Lb0:
            java.lang.String r7 = "events"
            r8.put(r7, r2)
            java.lang.String r7 = r8.toString()
            java.nio.charset.Charset r8 = com.huawei.hianalytics.framework.d.f28767g
            byte[] r7 = r7.getBytes(r8)
            byte[] r7 = com.huawei.hianalytics.framework.h.a(r7)
            java.lang.String r8 = r6.f28773f
            java.lang.String r7 = com.huawei.hianalytics.core.crypto.AesCipher.encryptCbc(r7, r8)
            java.lang.String r8 = "event"
            r3.put(r8, r7)
            return r3
        Lcf:
            java.lang.String r7 = "debug one attributeModel is null，TAG: "
            java.lang.StringBuilder r7 = e9.a.b(r7)
            java.lang.String r8 = r6.f28771d
            e9.a.e(r7, r8, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.framework.d.a(com.huawei.hianalytics.core.storage.Event, java.lang.String):org.json.JSONObject");
    }
}
