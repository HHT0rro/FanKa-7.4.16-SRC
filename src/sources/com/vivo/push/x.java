package com.vivo.push;

import android.net.Uri;

/* compiled from: PushConstants.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f46459a = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/config");

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f46460b = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/permission");

    /* renamed from: c, reason: collision with root package name */
    public static final Uri f46461c = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/clientState");

    /* renamed from: d, reason: collision with root package name */
    public static final Uri f46462d = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");

    /* renamed from: e, reason: collision with root package name */
    public static final Uri f46463e = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/agreePrivacyStatement");

    /* renamed from: f, reason: collision with root package name */
    public static final Uri f46464f = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/queryAppState");

    public static String a(int i10) {
        switch (i10) {
            case 2002:
                return "method_alias_bind";
            case 2003:
                return "method_alias_unbind";
            case 2004:
                return "method_tag_bind";
            case 2005:
                return "method_tag_unbind";
            case 2006:
                return "method_sdk_bind";
            case 2007:
                return "method_sdk_unbind";
            case 2008:
                return "method_stop";
            default:
                return null;
        }
    }
}
