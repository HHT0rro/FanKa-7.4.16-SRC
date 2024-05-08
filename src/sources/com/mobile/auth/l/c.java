package com.mobile.auth.l;

import android.net.Network;
import com.huawei.openalliance.ad.constant.bg;
import com.mobile.auth.BuildConfig;
import com.mobile.auth.k.g;
import com.mobile.auth.n.e;
import com.wangmai.okhttp.model.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f37489a;

    /* renamed from: b, reason: collision with root package name */
    private final String f37490b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, String> f37491c;

    /* renamed from: d, reason: collision with root package name */
    private final String f37492d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f37493e;

    /* renamed from: f, reason: collision with root package name */
    private final String f37494f;

    /* renamed from: g, reason: collision with root package name */
    private Network f37495g;

    /* renamed from: h, reason: collision with root package name */
    private long f37496h;

    /* renamed from: i, reason: collision with root package name */
    private final String f37497i;

    /* renamed from: j, reason: collision with root package name */
    private int f37498j;

    /* renamed from: k, reason: collision with root package name */
    private final g f37499k;

    public c(String str, g gVar, String str2, String str3) {
        this(str, null, gVar, str2, str3);
    }

    private c(String str, Map<String, String> map, g gVar, String str2, String str3) {
        this.f37493e = false;
        this.f37490b = str;
        this.f37499k = gVar;
        this.f37491c = map == null ? new HashMap<>() : map;
        this.f37489a = gVar == null ? "" : gVar.b().toString();
        this.f37492d = str2;
        this.f37494f = str3;
        this.f37497i = gVar != null ? gVar.a() : "";
        l();
    }

    private void l() {
        this.f37491c.put(bg.e.Code, BuildConfig.CMCC_SDK_VERSION);
        this.f37491c.put("Content-Type", "application/json");
        this.f37491c.put("CMCC-EncryptType", "STD");
        this.f37491c.put("traceId", this.f37494f);
        this.f37491c.put("appid", this.f37497i);
        this.f37491c.put(HttpHeaders.HEAD_KEY_CONNECTION, "close");
    }

    public String a() {
        return this.f37490b;
    }

    public void a(long j10) {
        this.f37496h = j10;
    }

    public void a(Network network) {
        this.f37495g = network;
    }

    public void a(String str, String str2) {
        this.f37491c.put(str, str2);
    }

    public void a(boolean z10) {
        this.f37493e = z10;
    }

    public boolean b() {
        return this.f37493e;
    }

    public Map<String, String> c() {
        return this.f37491c;
    }

    public String d() {
        return this.f37489a;
    }

    public String e() {
        return this.f37492d;
    }

    public String f() {
        return this.f37494f;
    }

    public boolean g() {
        return !e.a(this.f37494f) || this.f37490b.contains("logReport") || this.f37490b.contains("uniConfig");
    }

    public Network h() {
        return this.f37495g;
    }

    public long i() {
        return this.f37496h;
    }

    public boolean j() {
        int i10 = this.f37498j;
        this.f37498j = i10 + 1;
        return i10 < 2;
    }

    public g k() {
        return this.f37499k;
    }
}
