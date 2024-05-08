package com.amap.api.col.p0003l;

import android.content.Context;
import java.util.Hashtable;
import java.util.Map;

/* compiled from: AuthRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class s extends fb<String, a> {

    /* renamed from: f, reason: collision with root package name */
    private boolean f6915f;

    /* renamed from: g, reason: collision with root package name */
    private int[] f6916g;

    /* compiled from: AuthRequest.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public String f6918b;

        /* renamed from: c, reason: collision with root package name */
        public String f6919c;

        /* renamed from: a, reason: collision with root package name */
        public int f6917a = -1;

        /* renamed from: d, reason: collision with root package name */
        public boolean f6920d = false;
    }

    public s(Context context, String str) {
        super(context, str);
        this.f6916g = new int[]{10000, 0, 10018, 10019, 10020, 10021, 10022, 10023};
        ((fb) this).f5702d = "/feedback";
        this.isPostFlag = false;
        this.f6915f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        r1.f6920d = true;
     */
    @Override // com.amap.api.col.p0003l.fb
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.amap.api.col.3l.s.a a(java.lang.String r6) throws com.amap.api.col.p0003l.fa {
        /*
            r5 = this;
            java.lang.String r0 = "errcode"
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L41
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L41
            r6 = -1
            boolean r2 = r1.has(r0)     // Catch: java.lang.Throwable -> L41
            java.lang.String r3 = ""
            if (r2 == 0) goto L21
            int r6 = r1.optInt(r0)     // Catch: java.lang.Throwable -> L41
            java.lang.String r0 = "errmsg"
            java.lang.String r3 = r1.optString(r0)     // Catch: java.lang.Throwable -> L41
            java.lang.String r0 = "errdetail"
            java.lang.String r0 = r1.optString(r0)     // Catch: java.lang.Throwable -> L41
            goto L22
        L21:
            r0 = r3
        L22:
            com.amap.api.col.3l.s$a r1 = new com.amap.api.col.3l.s$a     // Catch: java.lang.Throwable -> L41
            r1.<init>()     // Catch: java.lang.Throwable -> L41
            r1.f6917a = r6     // Catch: java.lang.Throwable -> L41
            r1.f6918b = r3     // Catch: java.lang.Throwable -> L41
            r1.f6919c = r0     // Catch: java.lang.Throwable -> L41
            r0 = 0
            r1.f6920d = r0     // Catch: java.lang.Throwable -> L41
            int[] r2 = r5.f6916g     // Catch: java.lang.Throwable -> L41
            int r3 = r2.length     // Catch: java.lang.Throwable -> L41
        L33:
            if (r0 >= r3) goto L40
            r4 = r2[r0]     // Catch: java.lang.Throwable -> L41
            if (r4 != r6) goto L3d
            r6 = 1
            r1.f6920d = r6     // Catch: java.lang.Throwable -> L41
            goto L40
        L3d:
            int r0 = r0 + 1
            goto L33
        L40:
            return r1
        L41:
            r6 = move-exception
            r6.printStackTrace()
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.s.a(java.lang.String):com.amap.api.col.3l.s$a");
    }

    @Override // com.amap.api.col.p0003l.fb
    public final String c() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getIPV6URL() {
        return dx.a(getURL());
    }

    @Override // com.amap.api.col.p0003l.db, com.amap.api.col.p0003l.id
    public final Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", fj.f(((fb) this).f5701c));
        if (this.f6915f) {
            hashtable.put("pname", "3dmap");
        }
        String a10 = fl.a();
        String a11 = fl.a(((fb) this).f5701c, a10, fv.b(hashtable));
        hashtable.put("ts", a10);
        hashtable.put("scode", a11);
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
}
