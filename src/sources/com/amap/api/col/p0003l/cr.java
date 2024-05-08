package com.amap.api.col.p0003l;

import android.content.Context;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: CustomStyleRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cr extends fb<String, a> {

    /* renamed from: f, reason: collision with root package name */
    private String f5231f;

    /* renamed from: g, reason: collision with root package name */
    private String f5232g;

    /* renamed from: h, reason: collision with root package name */
    private String f5233h;

    /* renamed from: i, reason: collision with root package name */
    private final String f5234i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5235j;

    /* renamed from: k, reason: collision with root package name */
    private String f5236k;

    /* compiled from: CustomStyleRequest.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f5237a;

        /* renamed from: b, reason: collision with root package name */
        public int f5238b = -1;

        /* renamed from: c, reason: collision with root package name */
        public String f5239c = null;

        /* renamed from: d, reason: collision with root package name */
        public boolean f5240d = false;
    }

    public cr(Context context, String str) {
        super(context, str);
        this.f5232g = "1.0";
        this.f5233h = "0";
        this.f5234i = "lastModified";
        this.f5235j = false;
        this.f5236k = null;
        ((fb) this).f5702d = "/map/styles";
        ((fb) this).f5703e = true;
    }

    @Override // com.amap.api.col.p0003l.fb
    public final /* bridge */ /* synthetic */ a a(String str) throws fa {
        return null;
    }

    public final void b(String str) {
        this.f5236k = str;
    }

    @Override // com.amap.api.col.p0003l.fb
    public final String c() {
        return null;
    }

    public final void c(String str) {
        this.f5231f = str;
    }

    public final void d(String str) {
        this.f5233h = str;
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getIPV6URL() {
        return dx.a(getURL());
    }

    @Override // com.amap.api.col.p0003l.db, com.amap.api.col.p0003l.id
    public final Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", fj.f(((fb) this).f5701c));
        if (!this.f5235j) {
            hashtable.put("output", "bin");
        } else {
            hashtable.put(ALBiometricsKeys.KEY_SDK_TYPE, this.f5236k);
        }
        hashtable.put("styleid", this.f5231f);
        hashtable.put("protocol", this.f5232g);
        hashtable.put("ispublic", "1");
        hashtable.put("lastModified", this.f5233h);
        String a10 = fl.a();
        String a11 = fl.a(((fb) this).f5701c, a10, fv.b(hashtable));
        hashtable.put("ts", a10);
        hashtable.put("scode", a11);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.fb, com.amap.api.col.p0003l.id
    public final Map<String, String> getRequestHead() {
        fu a10 = dx.a();
        String b4 = a10 != null ? a10.b() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", w.f6964c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", b4, "3dmap"));
        hashtable.put("x-INFO", fl.a(((fb) this).f5701c));
        hashtable.put("key", fj.f(((fb) this).f5701c));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getURL() {
        return "http://restsdk.amap.com/v4" + ((fb) this).f5702d;
    }

    @Override // com.amap.api.col.p0003l.id
    public final boolean isSupportIPV6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003l.fb
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a a(ie ieVar) throws fa {
        List<String> list;
        if (ieVar == null) {
            return null;
        }
        a a10 = a(ieVar.f6444a);
        a10.f5240d = a10.f5237a != null;
        Map<String, List<String>> map = ieVar.f6445b;
        if (map == null || !map.containsKey("lastModified") || (list = ieVar.f6445b.get("lastModified")) == null || list.size() <= 0) {
            return a10;
        }
        a10.f5239c = list.get(0);
        return a10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003l.fb
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a a(byte[] bArr) throws fa {
        a aVar = new a();
        aVar.f5237a = bArr;
        if (this.f5235j && bArr != null) {
            if (bArr.length == 0) {
                aVar.f5237a = null;
            } else if (bArr.length <= 1024) {
                try {
                    if (new String(bArr, "utf-8").contains("errcode")) {
                        aVar.f5237a = null;
                    }
                } catch (Exception e2) {
                    gy.b(e2, "CustomStyleRequest", "loadData");
                }
            }
        }
        return aVar;
    }

    public cr(Context context, String str, boolean z10) {
        super(context, str);
        this.f5232g = "1.0";
        this.f5233h = "0";
        this.f5234i = "lastModified";
        this.f5236k = null;
        this.f5235j = z10;
        if (z10) {
            ((fb) this).f5702d = "/sdk/map/styles";
            this.isPostFlag = false;
        } else {
            ((fb) this).f5702d = "/map/styles";
        }
        ((fb) this).f5703e = true;
    }
}
