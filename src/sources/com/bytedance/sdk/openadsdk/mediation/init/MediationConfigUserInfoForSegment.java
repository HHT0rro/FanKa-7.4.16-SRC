package com.bytedance.sdk.openadsdk.mediation.init;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationConfigUserInfoForSegment implements Serializable {
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_UNKNOWN = "unknown";

    /* renamed from: hc, reason: collision with root package name */
    private Map<String, String> f11350hc;
    public final String TAG = "TTMediationSDK";

    /* renamed from: m, reason: collision with root package name */
    private String f11352m = "";
    private String dk = "";
    private String ej = "";

    /* renamed from: l, reason: collision with root package name */
    private int f11351l = 0;
    private String np = "";

    /* renamed from: n, reason: collision with root package name */
    private String f11353n = "";

    public static boolean checkValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b1, code lost:
    
        if (r7 == null) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L4
            return r0
        L4:
            r1 = 0
            if (r7 == 0) goto Lbd
            java.lang.Class r2 = r6.getClass()
            java.lang.Class r3 = r7.getClass()
            if (r2 == r3) goto L13
            goto Lbd
        L13:
            com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment r7 = (com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment) r7
            int r2 = r6.getAge()
            int r3 = r7.getAge()
            if (r2 != r3) goto L67
            java.lang.String r2 = r6.getUserValueGroup()
            java.lang.String r3 = r7.getUserValueGroup()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.getUserId()
            java.lang.String r3 = r7.getUserId()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.getChannel()
            java.lang.String r3 = r7.getChannel()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.getSubChannel()
            java.lang.String r3 = r7.getSubChannel()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            java.lang.String r2 = r6.getGender()
            java.lang.String r3 = r7.getGender()
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L67
            r2 = 1
            goto L68
        L67:
            r2 = 0
        L68:
            java.util.Map r7 = r7.getCustomInfos()
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.f11350hc
            if (r3 == 0) goto Laf
            if (r7 == 0) goto Laf
            int r3 = r3.size()
            int r4 = r7.size()
            if (r3 == r4) goto L7d
            goto Lb5
        L7d:
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.f11350hc
            java.util.Set r3 = r3.h()
            java.util.Iterator r3 = r3.iterator2()
        L87:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto Lb3
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L9a
            goto L87
        L9a:
            java.util.Map<java.lang.String, java.lang.String> r5 = r6.f11350hc
            java.lang.Object r5 = r5.get(r4)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.Object r4 = r7.get(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 != 0) goto L87
            goto Lb5
        Laf:
            if (r3 != 0) goto Lb5
            if (r7 != 0) goto Lb5
        Lb3:
            r7 = 1
            goto Lb6
        Lb5:
            r7 = 0
        Lb6:
            if (r2 == 0) goto Lbb
            if (r7 == 0) goto Lbb
            goto Lbc
        Lbb:
            r0 = 0
        Lbc:
            return r0
        Lbd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment.equals(java.lang.Object):boolean");
    }

    public int getAge() {
        return this.f11351l;
    }

    @Nullable
    public String getChannel() {
        return this.dk;
    }

    @Nullable
    public Map<String, String> getCustomInfos() {
        return this.f11350hc;
    }

    @Nullable
    public String getGender() {
        return this.np;
    }

    @Nullable
    public String getSubChannel() {
        return this.ej;
    }

    @Nullable
    public String getUserId() {
        return this.f11352m;
    }

    @Nullable
    public String getUserValueGroup() {
        return this.f11353n;
    }

    public void setAge(int i10) {
        this.f11351l = i10;
    }

    public void setChannel(String str) {
        if (checkValid(str)) {
            this.dk = str;
        }
    }

    public void setCustomInfos(Map<String, String> map) {
        this.f11350hc = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!checkValid(entry.getKey())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("流量分组");
                    sb2.append(entry.getKey());
                    sb2.append("字段存在不合法输入");
                } else if (!checkValid(entry.getValue())) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("流量分组");
                    sb3.append(entry.getKey());
                    sb3.append("字段的值");
                    sb3.append(entry.getValue());
                    sb3.append("存在不合法输入");
                } else {
                    this.f11350hc.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public void setGender(String str) {
        if (checkValid(str)) {
            this.np = str;
        }
    }

    public void setSubChannel(String str) {
        if (checkValid(str)) {
            this.ej = str;
        }
    }

    public void setUserId(String str) {
        if (checkValid(str)) {
            this.f11352m = str;
        }
    }

    public void setUserValueGroup(String str) {
        if (checkValid(str)) {
            this.f11353n = str;
        }
    }
}
