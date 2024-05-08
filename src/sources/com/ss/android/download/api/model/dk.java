package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk {
    public String dk;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0572dk f38403e;
    public String ej;

    /* renamed from: hc, reason: collision with root package name */
    public Drawable f38404hc;

    /* renamed from: l, reason: collision with root package name */
    public String f38405l;

    /* renamed from: m, reason: collision with root package name */
    public Context f38406m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f38407n;
    public String np;

    /* renamed from: oa, reason: collision with root package name */
    public int f38408oa;

    /* renamed from: w, reason: collision with root package name */
    public View f38409w;

    /* renamed from: com.ss.android.download.api.model.dk$dk, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0572dk {
        void dk(DialogInterface dialogInterface);

        void ej(DialogInterface dialogInterface);

        void m(DialogInterface dialogInterface);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class m {
        public int dk;

        /* renamed from: e, reason: collision with root package name */
        private boolean f38410e;
        private Context ej;

        /* renamed from: hc, reason: collision with root package name */
        private String f38411hc;

        /* renamed from: l, reason: collision with root package name */
        private String f38412l;

        /* renamed from: m, reason: collision with root package name */
        public View f38413m;

        /* renamed from: n, reason: collision with root package name */
        private String f38414n;
        private String np;

        /* renamed from: oa, reason: collision with root package name */
        private InterfaceC0572dk f38415oa;

        /* renamed from: w, reason: collision with root package name */
        private Drawable f38416w;

        public m(Context context) {
            this.ej = context;
        }

        public m dk(String str) {
            this.np = str;
            return this;
        }

        public m ej(String str) {
            this.f38414n = str;
            return this;
        }

        public m l(String str) {
            this.f38411hc = str;
            return this;
        }

        public m m(String str) {
            this.f38412l = str;
            return this;
        }

        public m m(boolean z10) {
            this.f38410e = z10;
            return this;
        }

        public m m(Drawable drawable) {
            this.f38416w = drawable;
            return this;
        }

        public m m(InterfaceC0572dk interfaceC0572dk) {
            this.f38415oa = interfaceC0572dk;
            return this;
        }

        public m m(int i10) {
            this.dk = i10;
            return this;
        }

        public dk m() {
            return new dk(this);
        }
    }

    private dk(m mVar) {
        this.f38407n = true;
        this.f38406m = mVar.ej;
        this.dk = mVar.f38412l;
        this.ej = mVar.np;
        this.f38405l = mVar.f38414n;
        this.np = mVar.f38411hc;
        this.f38407n = mVar.f38410e;
        this.f38404hc = mVar.f38416w;
        this.f38403e = mVar.f38415oa;
        this.f38409w = mVar.f38413m;
        this.f38408oa = mVar.dk;
    }
}
