package com.huawei.hms.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ip {
    public static final String B = "com.iab.omid.library.huawei.adsession.media.InteractionType";
    public static final String C = "com.iab.omid.library.huawei.adsession.media.MediaEvents";
    public static final String Code = "1";
    public static final String D = "com.iab.omid.library.huawei.adsession.media.VastProperties";
    public static final String F = "com.iab.omid.library.huawei.adsession.media.Position";
    public static final String I = "com.iab.omid.library.huawei.adsession.media";
    public static final String L = "com.iab.omid.library.huawei.adsession.media.InteractionType";
    public static final String S = "com.iab.omid.library.huawei.adsession.media.PlayerState";
    public static final String V = "com.iab.omid.library.huawei.adsession";
    public static final String Z = "com.iab.omid.library.huawei.adsession.video";

    /* renamed from: a, reason: collision with root package name */
    public static final String f29305a = "com.iab.omid.library.huawei.adsession.media.MediaEvents";

    /* renamed from: b, reason: collision with root package name */
    public static final String f29306b = "com.iab.omid.library.huawei.adsession.media.PlayerState";

    /* renamed from: c, reason: collision with root package name */
    public static final String f29307c = "com.iab.omid.library.huawei.adsession.media.Position";

    /* renamed from: d, reason: collision with root package name */
    public static final String f29308d = "com.iab.omid.library.huawei.adsession.media.VastProperties";

    /* renamed from: e, reason: collision with root package name */
    public static final String f29309e = "com.iab.omid.library.huawei.adsession.AdEvents";

    /* renamed from: f, reason: collision with root package name */
    public static final String f29310f = "com.iab.omid.library.huawei.adsession.AdSession";

    /* renamed from: g, reason: collision with root package name */
    public static final String f29311g = "com.iab.omid.library.huawei.adsession.AdSessionConfiguration";

    /* renamed from: h, reason: collision with root package name */
    public static final String f29312h = "com.iab.omid.library.huawei.publisher.AdSessionStatePublisher";

    /* renamed from: i, reason: collision with root package name */
    public static final String f29313i = "com.iab.omid.library.huawei.adsession.AdSessionContext";

    /* renamed from: j, reason: collision with root package name */
    public static final String f29314j = "com.iab.omid.library.huawei.adsession.AdSessionContextType";

    /* renamed from: k, reason: collision with root package name */
    public static final String f29315k = "com.iab.omid.library.huawei.adsession.CreativeType";

    /* renamed from: l, reason: collision with root package name */
    public static final String f29316l = "com.iab.omid.library.huawei.adsession.ErrorType";

    /* renamed from: m, reason: collision with root package name */
    public static final String f29317m = "com.iab.omid.library.huawei.adsession.FriendlyObstructionPurpose";

    /* renamed from: n, reason: collision with root package name */
    public static final String f29318n = "com.iab.omid.library.huawei.adsession.ImpressionType";

    /* renamed from: o, reason: collision with root package name */
    public static final String f29319o = "com.iab.omid.library.huawei.adsession.Owner";

    /* renamed from: p, reason: collision with root package name */
    public static final String f29320p = "com.iab.omid.library.huawei.adsession.Partner";

    /* renamed from: q, reason: collision with root package name */
    public static final String f29321q = "com.iab.omid.library.huawei.adsession.VerificationScriptResource";

    /* renamed from: r, reason: collision with root package name */
    private static final String f29322r = "OMSDKCheckUtil";

    public static boolean Code(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    public static boolean Code(Context context, List<String> list) {
        PackageManager packageManager = context.getPackageManager();
        try {
            Iterator<String> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                packageManager.getPackageInfo(iterator2.next(), 1);
            }
            return true;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    public static boolean Code(String str) {
        try {
            Class.forName(str);
            gl.V(f29322r, str);
            return true;
        } catch (ClassNotFoundException unused) {
            gl.V(f29322r, str + " is not avaliable");
            return false;
        }
    }

    public static boolean Code(List<String> list) {
        try {
            Iterator<String> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                Class.forName(iterator2.next());
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
