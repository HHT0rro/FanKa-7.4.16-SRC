package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.internal.v;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ch implements Observer {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10021a = "APKParser";

    /* renamed from: g, reason: collision with root package name */
    private static final String f10022g = "__xadsdk_downloaded__version__";

    /* renamed from: h, reason: collision with root package name */
    private static final String f10023h = "version";

    /* renamed from: b, reason: collision with root package name */
    private Context f10024b;

    /* renamed from: c, reason: collision with root package name */
    private URL f10025c;

    /* renamed from: d, reason: collision with root package name */
    private String f10026d;

    /* renamed from: e, reason: collision with root package name */
    private final bw f10027e;

    /* renamed from: f, reason: collision with root package name */
    private a f10028f;

    /* renamed from: i, reason: collision with root package name */
    private SharedPreferences f10029i;

    /* renamed from: j, reason: collision with root package name */
    private SharedPreferences.OnSharedPreferenceChangeListener f10030j;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a(bw bwVar);

        void b(bw bwVar);
    }

    public ch(Context context, URL url, bw bwVar, a aVar) {
        this.f10025c = null;
        this.f10026d = null;
        this.f10030j = new ci(this);
        this.f10025c = url;
        this.f10027e = bwVar;
        a(context, aVar);
    }

    private void a(Context context, a aVar) {
        this.f10024b = context;
        this.f10028f = aVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences(f10022g, 0);
        this.f10029i = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.f10030j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        v vVar = (v) observable;
        if (vVar.l() == v.a.COMPLETED) {
            this.f10028f.a(new bw(this.f10027e, vVar.g(), Boolean.TRUE));
        }
        if (vVar.l() == v.a.ERROR) {
            this.f10028f.b(new bw(this.f10027e, vVar.g(), Boolean.FALSE));
        }
    }

    public void a(String str, String str2) {
        am amVar = new am(this.f10024b, this.f10026d != null ? new URL(this.f10026d) : this.f10025c, str, str2, false);
        amVar.addObserver(this);
        amVar.a();
        SharedPreferences.Editor edit = this.f10029i.edit();
        edit.putString("version", this.f10027e.toString());
        edit.apply();
    }

    public ch(Context context, String str, bw bwVar, a aVar) {
        this.f10025c = null;
        this.f10026d = null;
        this.f10030j = new ci(this);
        this.f10026d = str;
        this.f10027e = bwVar;
        a(context, aVar);
    }
}
