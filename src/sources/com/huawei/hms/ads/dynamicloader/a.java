package com.huawei.hms.ads.dynamicloader;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    private int f29136a;

    /* renamed from: b, reason: collision with root package name */
    private Resources.Theme f29137b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f29138c;

    public a(Context context) {
        super(context);
    }

    private void a() {
        if (this.f29137b == null) {
            this.f29137b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f29137b.setTo(theme);
            }
        }
        this.f29137b.applyStyle(this.f29136a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return super.getSystemService(str);
        }
        if (this.f29138c == null) {
            this.f29138c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f29138c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f29137b;
        if (theme != null) {
            return theme;
        }
        int i10 = this.f29136a;
        int i11 = getApplicationInfo().targetSdkVersion;
        if (i10 == 0) {
            i10 = i11 < 11 ? 16973829 : i11 >= 14 ? i11 < 24 ? 16974120 : 16974143 : 16973931;
        }
        this.f29136a = i10;
        a();
        return this.f29137b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i10) {
        if (this.f29136a != i10) {
            this.f29136a = i10;
            a();
        }
    }
}
