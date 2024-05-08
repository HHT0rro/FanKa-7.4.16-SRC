package com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111Il;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class l111l1111lI1l<T> implements Comparable<l111l1111lI1l<T>> {
    private static final String l1111l111111Il = "UTF-8";
    private final int l111l11111I1l;
    private final String l111l11111Il;
    private final l11l1111Il.l1111l111111Il l111l11111lIl;
    private final String l111l1111l1Il;
    private final Object l111l1111lI1l;
    private boolean l111l1111lIl;
    private final int l111l1111llIl;
    private l111l11111lIl l111l11IlIlIl;
    private Integer l11l1111I11l;
    private l111l1111lIl l11l1111I1l;
    private boolean l11l1111I1ll;
    private boolean l11l1111Il;
    private boolean l11l1111Il1l;
    private boolean l11l1111Ill;
    private l11l1111lIIl.l1111l111111Il l11l1111lIIl;
    private l11l1111I1l l11l111l11Il;
    private Object l11l111l1lll;
    private boolean l11l11IlIIll;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface l1111l111111Il {
        public static final int l1111l111111Il = -1;
        public static final int l111l11111I1l = 1;
        public static final int l111l11111Il = 2;
        public static final int l111l11111lIl = 0;
        public static final int l111l1111l1Il = 3;
        public static final int l111l1111lI1l = 5;
        public static final int l111l1111lIl = 6;
        public static final int l111l1111llIl = 4;
        public static final int l11l1111lIIl = 7;

        String l111l11111lIl();

        void l111l11111lIl(String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum l111l11111I1l {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface l111l11111lIl {
        void l1111l111111Il();

        void l111l11111lIl();
    }

    public l111l1111lI1l(int i10, String str, String str2, l11l1111lIIl.l1111l111111Il l1111l111111il) {
        Uri parse;
        String host;
        this.l111l11111lIl = l11l1111Il.l1111l111111Il.l1111l111111Il ? new l11l1111Il.l1111l111111Il() : null;
        this.l111l1111lI1l = new Object();
        this.l11l1111I1ll = true;
        int i11 = 0;
        this.l11l1111Il = false;
        this.l11l1111Il1l = false;
        this.l11l1111Ill = false;
        this.l11l11IlIIll = false;
        this.l111l11111I1l = i10;
        this.l111l11111Il = str;
        this.l111l1111l1Il = str2;
        this.l11l1111lIIl = l1111l111111il;
        this.l11l111l11Il = new com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il();
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (host = parse.getHost()) != null) {
            i11 = host.hashCode();
        }
        this.l111l1111llIl = i11;
    }

    @Deprecated
    private l111l1111lI1l(String str, String str2, l11l1111lIIl.l1111l111111Il l1111l111111il) {
        this(-1, str, str2, l1111l111111il);
    }

    private void l1111l111111Il(l111l11111lIl l111l11111lil) {
        synchronized (this.l111l1111lI1l) {
            this.l111l11IlIlIl = l111l11111lil;
        }
    }

    private static byte[] l1111l111111Il(Map<String, String> map, String str) {
        StringBuilder sb2 = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
                sb2.append(URLEncoder.encode(entry.getKey(), str));
                sb2.append('=');
                sb2.append(URLEncoder.encode(entry.getValue(), str));
                sb2.append(SymbolValues.CHAR_AND_SYMBOL);
            }
            return sb2.toString().getBytes(str);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Encoding not supported: " + str, e2);
        }
    }

    private static int l111l11111I1l(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private l111l1111lI1l<?> l111l11111I1l(boolean z10) {
        this.l11l1111Ill = z10;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private l111l1111lI1l<?> l111l11111Il(boolean z10) {
        this.l11l11IlIIll = z10;
        return this;
    }

    private int l111l11111lIl(l111l1111lI1l<T> l111l1111li1l) {
        l111l11111I1l l111l11111i1l = l111l11111I1l.NORMAL;
        return this.l11l1111I11l.intValue() - l111l1111li1l.l11l1111I11l.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private l111l1111lI1l<?> l111l11111lIl(Object obj) {
        this.l11l111l1lll = obj;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private l111l1111lI1l<?> l111l11111lIl(boolean z10) {
        this.l11l1111I1ll = z10;
        return this;
    }

    private static l11l1111I1ll l111l11111lIl(l11l1111I1ll l11l1111i1ll) {
        return l11l1111i1ll;
    }

    private static l111l11111I1l l111l111llIl() {
        return l111l11111I1l.NORMAL;
    }

    private int l111l11IlIlIl() {
        Integer num = this.l11l1111I11l;
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    private String l11l111l1I1l() {
        String str = this.l111l11111Il;
        int i10 = this.l111l11111I1l;
        if (i10 == 0 || i10 == -1) {
            return str;
        }
        return Integer.toString(i10) + '-' + str;
    }

    @Deprecated
    private Map<String, String> l11l111l1Il() {
        return null;
    }

    private l11l1111lIIl.l1111l111111Il l11l111l1lll() {
        l11l1111lIIl.l1111l111111Il l1111l111111il;
        synchronized (this.l111l1111lI1l) {
            l1111l111111il = this.l11l1111lIIl;
        }
        return l1111l111111il;
    }

    private boolean l11l111lI1l() {
        boolean z10;
        synchronized (this.l111l1111lI1l) {
            z10 = this.l11l1111Il1l;
        }
        return z10;
    }

    @Deprecated
    private String l11l111ll11l() {
        return "UTF-8";
    }

    private static Map<String, String> l11l111ll1Il() {
        return null;
    }

    private boolean l11l111llI1l() {
        return this.l11l11IlIIll;
    }

    private static String l11l111lll() {
        return "UTF-8";
    }

    private boolean l11l111lllIl() {
        return this.l11l1111Ill;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        l111l11111I1l l111l11111i1l = l111l11111I1l.NORMAL;
        return this.l11l1111I11l.intValue() - ((l111l1111lI1l) obj).l11l1111I11l.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final l111l1111lI1l<?> l1111l111111Il(l111l1111lIl l111l1111lil) {
        this.l11l1111I1l = l111l1111lil;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final l111l1111lI1l<?> l1111l111111Il(l11l1111I1l l11l1111i1l) {
        this.l11l111l11Il = l11l1111i1l;
        return this;
    }

    public abstract l11l1111lIIl<T> l1111l111111Il(l111l1111llIl l111l1111llil);

    public final void l1111l111111Il(int i10) {
        l111l1111lIl l111l1111lil = this.l11l1111I1l;
        if (l111l1111lil != null) {
            l111l1111lil.l1111l111111Il(this, i10);
        }
    }

    public final void l1111l111111Il(l11l1111I1ll l11l1111i1ll) {
        l11l1111lIIl.l1111l111111Il l1111l111111il;
        synchronized (this.l111l1111lI1l) {
            l1111l111111il = this.l11l1111lIIl;
        }
        if (l1111l111111il != null) {
            l1111l111111il.l1111l111111Il(l11l1111i1ll);
        }
    }

    public final void l1111l111111Il(l11l1111lIIl<?> l11l1111liil) {
        synchronized (this.l111l1111lI1l) {
        }
    }

    public abstract void l1111l111111Il(T t2);

    public final void l1111l111111Il(String str) {
        if (l11l1111Il.l1111l111111Il.l1111l111111Il) {
            this.l111l11111lIl.l1111l111111Il(str, Thread.currentThread().getId());
        }
    }

    public final void l1111l111111Il(boolean z10) {
        this.l111l1111lIl = z10;
    }

    public byte[] l1111l111111Il() {
        return null;
    }

    public final int l111l11111I1l() {
        return this.l111l11111I1l;
    }

    public final Object l111l11111Il() {
        return this.l11l111l1lll;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final l111l1111lI1l<?> l111l11111lIl(int i10) {
        this.l11l1111I11l = Integer.valueOf(i10);
        return this;
    }

    public Map<String, String> l111l11111lIl() {
        return Collections.emptyMap();
    }

    public final void l111l11111lIl(final String str) {
        l111l1111lIl l111l1111lil = this.l11l1111I1l;
        if (l111l1111lil != null) {
            l111l1111lil.l111l11111lIl(this);
        }
        if (l11l1111Il.l1111l111111Il.l1111l111111Il) {
            final long id2 = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        l111l1111lI1l.this.l111l11111lIl.l1111l111111Il(str, id2);
                        l111l1111lI1l.this.l111l11111lIl.l1111l111111Il(l111l1111lI1l.this.toString());
                    }
                });
            } else {
                this.l111l11111lIl.l1111l111111Il(str, id2);
                this.l111l11111lIl.l1111l111111Il(toString());
            }
        }
    }

    public final int l111l1111l1Il() {
        return this.l111l1111llIl;
    }

    public final String l111l1111lI1l() {
        return this.l111l11111Il;
    }

    public final String l111l1111lIl() {
        return this.l111l1111l1Il;
    }

    public final boolean l111l1111llIl() {
        return this.l111l1111lIl;
    }

    public final boolean l11l1111I11l() {
        boolean z10;
        synchronized (this.l111l1111lI1l) {
            z10 = this.l11l1111Il;
        }
        return z10;
    }

    @Deprecated
    public String l11l1111I1l() {
        return l11l1111Il();
    }

    @Deprecated
    public byte[] l11l1111I1ll() {
        return null;
    }

    public String l11l1111Il() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    public final int l11l1111Il1l() {
        return this.l11l111l11Il.l1111l111111Il();
    }

    public final l11l1111I1l l11l1111Ill() {
        return this.l11l111l11Il;
    }

    public void l11l1111lIIl() {
        synchronized (this.l111l1111lI1l) {
            this.l11l1111Il = true;
            this.l11l1111lIIl = null;
        }
    }

    public final void l11l111l11Il() {
        synchronized (this.l111l1111lI1l) {
        }
    }

    public final void l11l11IlIIll() {
        synchronized (this.l111l1111lI1l) {
            this.l11l1111Il1l = true;
        }
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(this.l111l1111llIl);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(l11l1111I11l() ? "[X] " : "[ ] ");
        sb2.append(this.l111l11111Il);
        sb2.append(" ");
        sb2.append(str);
        sb2.append(" ");
        sb2.append((Object) l111l11111I1l.NORMAL);
        sb2.append(" ");
        sb2.append((Object) this.l11l1111I11l);
        return sb2.toString();
    }
}
