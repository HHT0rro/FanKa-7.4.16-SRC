package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* compiled from: DefaultNotifyDataAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class l implements BaseNotifyDataAdapter {

    /* renamed from: e, reason: collision with root package name */
    private static int f46426e;

    /* renamed from: f, reason: collision with root package name */
    private static int f46427f;

    /* renamed from: a, reason: collision with root package name */
    private Resources f46428a;

    /* renamed from: b, reason: collision with root package name */
    private String f46429b;

    /* renamed from: c, reason: collision with root package name */
    private String f46430c;

    /* renamed from: d, reason: collision with root package name */
    private String f46431d;

    private static boolean a(int i10) {
        return (i10 == -1 || i10 == 0) ? false : true;
    }

    private static boolean a(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        u.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
        return false;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        if (a(f46426e)) {
            return f46426e;
        }
        String str = this.f46431d;
        int a10 = !a(str) ? -1 : a(str, "_notifyicon");
        f46426e = a10;
        if (a(a10)) {
            return f46426e;
        }
        for (String str2 = this.f46430c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
            int identifier = this.f46428a.getIdentifier("vivo_push_rom" + str2 + "_notifyicon", "drawable", this.f46429b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.f46428a.getIdentifier("vivo_push_notifyicon", "drawable", this.f46429b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        if (a(f46427f)) {
            return f46427f;
        }
        String str = this.f46431d;
        int a10 = !a(str) ? -1 : a(str, "_icon");
        f46427f = a10;
        if (a(a10)) {
            return f46427f;
        }
        for (String str2 = this.f46430c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
            int identifier = this.f46428a.getIdentifier("vivo_push_rom" + str2 + "_icon", "drawable", this.f46429b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.f46428a.getIdentifier("vivo_push_icon", "drawable", this.f46429b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        return 2;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        this.f46429b = context.getPackageName();
        this.f46428a = context.getResources();
        this.f46430c = n.a();
        this.f46431d = Build.VERSION.RELEASE;
    }

    private int a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            if (split != null && split.length > 0) {
                str = split[0];
            }
            try {
                for (int parseInt = Integer.parseInt(str); parseInt > 0; parseInt--) {
                    String str3 = "vivo_push_ard" + parseInt + str2;
                    u.c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(str3)));
                    int identifier = this.f46428a.getIdentifier(str3, "drawable", this.f46429b);
                    if (identifier > 0) {
                        u.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(str3)));
                        return identifier;
                    }
                }
            } catch (Exception e2) {
                u.a("DefaultNotifyDataAdapter", e2);
            }
        }
        return -1;
    }
}
