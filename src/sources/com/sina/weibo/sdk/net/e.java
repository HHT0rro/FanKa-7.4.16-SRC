package com.sina.weibo.sdk.net;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e implements d {

    /* renamed from: i, reason: collision with root package name */
    private String f38344i;

    /* renamed from: j, reason: collision with root package name */
    private Bundle f38345j = new Bundle();

    /* renamed from: k, reason: collision with root package name */
    private Bundle f38346k = new Bundle();

    /* renamed from: l, reason: collision with root package name */
    private Map f38347l = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private Map<String, byte[]> f38348m = new HashMap();

    /* renamed from: n, reason: collision with root package name */
    private int f38349n;

    /* renamed from: o, reason: collision with root package name */
    private int f38350o;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {

        /* renamed from: i, reason: collision with root package name */
        public String f38351i;

        /* renamed from: j, reason: collision with root package name */
        public Bundle f38352j = new Bundle();

        /* renamed from: k, reason: collision with root package name */
        public Bundle f38353k = new Bundle();

        /* renamed from: l, reason: collision with root package name */
        public Map f38354l = new HashMap();

        /* renamed from: m, reason: collision with root package name */
        public Map<String, byte[]> f38355m = new HashMap();

        /* renamed from: n, reason: collision with root package name */
        public int f38356n = 30000;

        /* renamed from: o, reason: collision with root package name */
        public int f38357o = 60000;

        public final a a(String str, Object obj) {
            a(this.f38352j, str, obj);
            return this;
        }

        public final a b(String str, Object obj) {
            a(this.f38353k, str, obj);
            return this;
        }

        public final e h() {
            return new e(this);
        }

        private void a(Bundle bundle, String str, Object obj) {
            if (obj != null) {
                if (obj instanceof String) {
                    bundle.putString(str, String.valueOf(obj));
                    return;
                }
                if (obj instanceof Integer) {
                    bundle.putInt(str, ((Integer) obj).intValue());
                    return;
                }
                if (obj instanceof Short) {
                    bundle.putShort(str, ((Short) obj).shortValue());
                    return;
                }
                if (obj instanceof Character) {
                    bundle.putChar(str, ((Character) obj).charValue());
                    return;
                }
                if (obj instanceof Byte) {
                    bundle.putByte(str, ((Byte) obj).byteValue());
                    return;
                }
                if (obj instanceof Long) {
                    bundle.putLong(str, ((Long) obj).longValue());
                    return;
                }
                if (obj instanceof Float) {
                    bundle.putFloat(str, ((Float) obj).floatValue());
                    return;
                }
                if (obj instanceof Double) {
                    bundle.putDouble(str, ((Double) obj).doubleValue());
                    return;
                }
                if (obj instanceof Boolean) {
                    bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof byte[]) {
                    this.f38355m.put(str, (byte[]) obj);
                } else {
                    if (obj instanceof Serializable) {
                        bundle.putSerializable(str, (Serializable) obj);
                        return;
                    }
                    throw new IllegalArgumentException("Unsupported params type!");
                }
            }
        }
    }

    public e(a aVar) {
        this.f38344i = aVar.f38351i;
        this.f38345j.putAll(aVar.f38352j);
        this.f38346k.putAll(aVar.f38353k);
        this.f38347l.putAll(aVar.f38354l);
        this.f38348m.putAll(aVar.f38355m);
        this.f38349n = aVar.f38356n;
        this.f38350o = aVar.f38357o;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final Bundle g() {
        return this.f38346k;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final int getConnectTimeout() {
        return this.f38349n;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final Bundle getParams() {
        return this.f38345j;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final int getReadTimeout() {
        return this.f38350o;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final String getUrl() {
        return this.f38344i;
    }
}
