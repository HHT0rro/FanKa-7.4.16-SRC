package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;

/* compiled from: DefaultNotifyLayoutAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class m implements BaseNotifyLayoutAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Resources f46432a;

    /* renamed from: b, reason: collision with root package name */
    private String f46433b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.f46432a.getIdentifier("push_notify", "layout", this.f46433b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        Resources resources;
        String str;
        String str2;
        if (n.f46437d) {
            resources = this.f46432a;
            str = this.f46433b;
            str2 = "notify_icon_rom30";
        } else if (n.f46436c) {
            resources = this.f46432a;
            str = this.f46433b;
            str2 = "notify_icon_rom20";
        } else {
            resources = this.f46432a;
            str = this.f46433b;
            str2 = "notify_icon";
        }
        return resources.getIdentifier(str2, "id", str);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int i10;
        try {
            i10 = ((Integer) ag.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            i10 = 0;
        }
        if (i10 > 0) {
            return this.f46432a.getColor(i10);
        }
        boolean z10 = n.f46437d;
        if (z10) {
            return -1;
        }
        if (!n.f46436c) {
            return -16777216;
        }
        if (z10) {
            return Color.parseColor("#ff999999");
        }
        return -1;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.f46433b = context.getPackageName();
        this.f46432a = context.getResources();
    }
}
