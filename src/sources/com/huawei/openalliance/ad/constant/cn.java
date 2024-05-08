package com.huawei.openalliance.ad.constant;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fr;
import com.huawei.hms.ads.gl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class cn {
    private static final String B = "com.huawei.fastapp.dev";
    private static final String[] C;
    private static final String Code = "WhiteListPkgList";
    private static final String D = "com.huawei.browser";
    private static final String[] F;
    private static final String[] I;
    private static final String[] L;
    private static final String S = "com.hihonor.fastapp";
    private static final String V = "com.huawei.appmarket";
    private static final String Z = "com.huawei.fastapp";

    /* renamed from: a, reason: collision with root package name */
    private static final String f32300a = "com.hicloud.browser";

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f32301b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f32302c = "com.android.browser";

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f32303d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f32304e = "com.hihonor.browser";

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f32305f;

    /* renamed from: g, reason: collision with root package name */
    private static final Map<String, List<String>> f32306g;

    /* renamed from: h, reason: collision with root package name */
    private static final String f32307h = "com.petal.litegames";

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f32308i;

    static {
        String[] strArr = {"ffe391e0ea186d0734ed601e4e70e3224b7309d48e2075bac46d8c667eae7212", "3baf59a2e5331c30675fab35ff5fff0d116142d3d4664f1c3cb804068b40614f"};
        I = strArr;
        String[] strArr2 = {"b92825c2bd5d6d6d1e7f39eecd17843b7d9016f611136b75441bc6f4d3f00f05", "59321357AB0A6BACBE3D32665B0084DCBB709B1D234EC684431AAEC5A0F0B8B1"};
        C = strArr2;
        String[] strArr3 = {u.aY};
        F = strArr3;
        String[] strArr4 = {u.f32358ba};
        L = strArr4;
        String[] strArr5 = {u.f32360bc};
        f32301b = strArr5;
        String[] strArr6 = {"bbe2ff269828a0d922498ee87f65afe769c27d62f489d5c19b9cc6c444c80811", "d8a4db56b7ebc39fe5f3004215f0e0decb43b9cfcbe9b2d948383fedd434e7d9", u.f32358ba};
        f32303d = strArr6;
        String[] strArr7 = {"22dcb04cfaa28f382b613794eba4441a8bcb1dbc8576776f1b1e6a457b00d449"};
        f32305f = strArr7;
        HashMap hashMap = new HashMap();
        f32306g = hashMap;
        String[] strArr8 = {"A9436644E0BD71FF512C63839F8AC27114399F36956958688555DFCC63257EDE"};
        f32308i = strArr8;
        hashMap.put(f32304e, Arrays.asList(strArr7));
        hashMap.put("com.android.browser", Arrays.asList(strArr6));
        hashMap.put("com.huawei.browser", Arrays.asList(strArr4));
        hashMap.put("com.huawei.appmarket", Arrays.asList(strArr));
        hashMap.put("com.huawei.hwid", Arrays.asList("b92825c2bd5d6d6d1e7f39eecd17843b7d9016f611136b75441bc6f4d3f00f05"));
        hashMap.put("com.huawei.hwid.tv", Arrays.asList("3517262215d8d3008cbf888750b6418edc4d562ac33ed6874e0d73aba667bc3c"));
        hashMap.put("com.huawei.hms", Arrays.asList("e49d5c2c0e11b3b1b96ca56c6de2a14ec7dab5ccc3b5f300d03e5b4dba44f539"));
        hashMap.put("com.huawei.fastapp", Arrays.asList(strArr2));
        hashMap.put("com.huawei.fastapp.dev", Arrays.asList(strArr2));
        hashMap.put("com.hihonor.fastapp", Arrays.asList(strArr3));
        hashMap.put("com.hicloud.browser", Arrays.asList(strArr5));
        hashMap.put(f32307h, Arrays.asList(strArr8));
    }

    public static boolean Code(Context context, String str, String str2) {
        boolean Code2 = Code(str, str2);
        return !Code2 ? V(context, str, str2) : Code2;
    }

    public static boolean Code(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return Code(f32306g.get(str), str2);
        }
        gl.Z(Code, "inWhiteList invalid input");
        return false;
    }

    private static boolean Code(List<String> list, String str) {
        if (list == null) {
            return false;
        }
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (str.equalsIgnoreCase(iterator2.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean V(Context context, String str, String str2) {
        String str3;
        String Code2 = fr.Code(context).Code();
        if (TextUtils.isEmpty(Code2)) {
            str3 = "inTrustAppList trustAppList is empty";
        } else {
            com.huawei.openalliance.ad.beans.metadata.b bVar = (com.huawei.openalliance.ad.beans.metadata.b) com.huawei.openalliance.ad.utils.z.V(Code2, com.huawei.openalliance.ad.beans.metadata.b.class, new Class[0]);
            if (bVar == null) {
                str3 = "inTrustAppList toObjectNoException is null";
            } else {
                Map<String, List<String>> Code3 = bVar.Code();
                if (Code3 == null) {
                    str3 = "inTrustAppList map is null";
                } else {
                    List<String> list = Code3.get(str);
                    if (list != null) {
                        return Code(list, str2);
                    }
                    str3 = "inTrustAppList signList is null";
                }
            }
        }
        gl.V(Code, str3);
        return false;
    }
}
