package com.jd.ad.sdk.jad_lw;

import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_jw implements com.jd.ad.sdk.jad_lw.jad_bo {
    public final jad_hu<jad_an, Object> jad_an = new jad_hu<>();
    public final jad_bo jad_bo = new jad_bo();
    public final Map<Class<?>, NavigableMap<Integer, Integer>> jad_cp = new HashMap();
    public final Map<Class<?>, com.jd.ad.sdk.jad_lw.jad_an<?>> jad_dq = new HashMap();
    public final int jad_er;
    public int jad_fs;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class jad_an implements jad_mz {
        public final jad_bo jad_an;
        public int jad_bo;
        public Class<?> jad_cp;

        public jad_an(jad_bo jad_boVar) {
            this.jad_an = jad_boVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof jad_an)) {
                return false;
            }
            jad_an jad_anVar = (jad_an) obj;
            return this.jad_bo == jad_anVar.jad_bo && this.jad_cp == jad_anVar.jad_cp;
        }

        public int hashCode() {
            int i10 = this.jad_bo * 31;
            Class<?> cls = this.jad_cp;
            return i10 + (cls != null ? cls.hashCode() : 0);
        }

        @Override // com.jd.ad.sdk.jad_lw.jad_mz
        public void jad_an() {
            jad_bo jad_boVar = this.jad_an;
            if (jad_boVar.jad_an.size() < 20) {
                jad_boVar.jad_an.offer(this);
            }
        }

        public String toString() {
            StringBuilder jad_an = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Key{size=");
            jad_an.append(this.jad_bo);
            jad_an.append("array=");
            jad_an.append((Object) this.jad_cp);
            jad_an.append('}');
            return jad_an.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class jad_bo extends jad_dq<jad_an> {
        @Override // com.jd.ad.sdk.jad_lw.jad_dq
        public jad_an jad_an() {
            return new jad_an(this);
        }

        public jad_an jad_an(int i10, Class<?> cls) {
            jad_an jad_bo = jad_bo();
            jad_bo.jad_bo = i10;
            jad_bo.jad_cp = cls;
            return jad_bo;
        }
    }

    public jad_jw(int i10) {
        this.jad_er = i10;
    }

    public final <T> com.jd.ad.sdk.jad_lw.jad_an<T> jad_an(Class<T> cls) {
        com.jd.ad.sdk.jad_lw.jad_an<T> jad_anVar = (com.jd.ad.sdk.jad_lw.jad_an) this.jad_dq.get(cls);
        if (jad_anVar == null) {
            if (cls.equals(int[].class)) {
                jad_anVar = new jad_iv();
            } else {
                if (!cls.equals(byte[].class)) {
                    StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("No array pool found for: ");
                    jad_an2.append(cls.getSimpleName());
                    throw new IllegalArgumentException(jad_an2.toString());
                }
                jad_anVar = new jad_jt();
            }
            this.jad_dq.put(cls, jad_anVar);
        }
        return jad_anVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0023 A[Catch: all -> 0x004d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:7:0x0017, B:12:0x0023, B:16:0x002f, B:17:0x0047, B:22:0x003a), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002f A[Catch: all -> 0x004d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:7:0x0017, B:12:0x0023, B:16:0x002f, B:17:0x0047, B:22:0x003a), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003a A[Catch: all -> 0x004d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:7:0x0017, B:12:0x0023, B:16:0x002f, B:17:0x0047, B:22:0x003a), top: B:2:0x0001 }] */
    @Override // com.jd.ad.sdk.jad_lw.jad_bo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T> T jad_an(int r6, java.lang.Class<T> r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.NavigableMap r0 = r5.jad_bo(r7)     // Catch: java.lang.Throwable -> L4d
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r0 = r0.ceilingKey(r1)     // Catch: java.lang.Throwable -> L4d
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L4d
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L2c
            int r3 = r5.jad_fs     // Catch: java.lang.Throwable -> L4d
            if (r3 == 0) goto L20
            int r4 = r5.jad_er     // Catch: java.lang.Throwable -> L4d
            int r4 = r4 / r3
            r3 = 2
            if (r4 < r3) goto L1e
            goto L20
        L1e:
            r3 = 0
            goto L21
        L20:
            r3 = 1
        L21:
            if (r3 != 0) goto L2d
            int r3 = r0.intValue()     // Catch: java.lang.Throwable -> L4d
            int r4 = r6 * 8
            if (r3 > r4) goto L2c
            goto L2d
        L2c:
            r1 = 0
        L2d:
            if (r1 == 0) goto L3a
            com.jd.ad.sdk.jad_lw.jad_jw$jad_bo r6 = r5.jad_bo     // Catch: java.lang.Throwable -> L4d
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L4d
            com.jd.ad.sdk.jad_lw.jad_jw$jad_an r6 = r6.jad_an(r0, r7)     // Catch: java.lang.Throwable -> L4d
            goto L47
        L3a:
            com.jd.ad.sdk.jad_lw.jad_jw$jad_bo r0 = r5.jad_bo     // Catch: java.lang.Throwable -> L4d
            com.jd.ad.sdk.jad_lw.jad_mz r0 = r0.jad_bo()     // Catch: java.lang.Throwable -> L4d
            com.jd.ad.sdk.jad_lw.jad_jw$jad_an r0 = (com.jd.ad.sdk.jad_lw.jad_jw.jad_an) r0     // Catch: java.lang.Throwable -> L4d
            r0.jad_bo = r6     // Catch: java.lang.Throwable -> L4d
            r0.jad_cp = r7     // Catch: java.lang.Throwable -> L4d
            r6 = r0
        L47:
            java.lang.Object r6 = r5.jad_an(r6, r7)     // Catch: java.lang.Throwable -> L4d
            monitor-exit(r5)
            return r6
        L4d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_lw.jad_jw.jad_an(int, java.lang.Class):java.lang.Object");
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_bo
    public synchronized void jad_an() {
        jad_bo(0);
    }

    public final NavigableMap<Integer, Integer> jad_bo(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.jad_cp.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.jad_cp.put(cls, treeMap);
        return treeMap;
    }

    public final void jad_bo(int i10) {
        while (this.jad_fs > i10) {
            Object jad_an2 = this.jad_an.jad_an();
            com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_an2);
            com.jd.ad.sdk.jad_lw.jad_an jad_an3 = jad_an((Class) jad_an2.getClass());
            this.jad_fs -= jad_an3.jad_bo() * jad_an3.jad_an(jad_an2);
            jad_cp(jad_an3.jad_an(jad_an2), jad_an2.getClass());
            if (Log.isLoggable(jad_an3.jad_an(), 2)) {
                String jad_an4 = jad_an3.jad_an();
                StringBuilder jad_an5 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("evicted: ");
                jad_an5.append(jad_an3.jad_an(jad_an2));
                Logger.v(jad_an4, jad_an5.toString());
            }
        }
    }

    public final void jad_cp(int i10, Class<?> cls) {
        NavigableMap<Integer, Integer> jad_bo2 = jad_bo(cls);
        Integer num = jad_bo2.get(Integer.valueOf(i10));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i10 + ", this: " + ((Object) this));
        }
        int intValue = num.intValue();
        Integer valueOf = Integer.valueOf(i10);
        if (intValue == 1) {
            jad_bo2.remove(valueOf);
        } else {
            jad_bo2.put(valueOf, Integer.valueOf(num.intValue() - 1));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_lw.jad_bo
    public synchronized <T> T jad_bo(int i10, Class<T> cls) {
        jad_an jad_bo2;
        jad_bo2 = this.jad_bo.jad_bo();
        jad_bo2.jad_bo = i10;
        jad_bo2.jad_cp = cls;
        return (T) jad_an(jad_bo2, cls);
    }

    public final <T> T jad_an(jad_an jad_anVar, Class<T> cls) {
        com.jd.ad.sdk.jad_lw.jad_an<T> jad_an2 = jad_an((Class) cls);
        T t2 = (T) this.jad_an.jad_an(jad_anVar);
        if (t2 != null) {
            this.jad_fs -= jad_an2.jad_bo() * jad_an2.jad_an(t2);
            jad_cp(jad_an2.jad_an(t2), cls);
        }
        if (t2 != null) {
            return t2;
        }
        if (Log.isLoggable(jad_an2.jad_an(), 2)) {
            String jad_an3 = jad_an2.jad_an();
            StringBuilder jad_an4 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Allocated ");
            jad_an4.append(jad_anVar.jad_bo);
            jad_an4.append(" bytes");
            Logger.v(jad_an3, jad_an4.toString());
        }
        return jad_an2.newArray(jad_anVar.jad_bo);
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_bo
    public synchronized <T> void jad_an(T t2) {
        Class<?> cls = t2.getClass();
        com.jd.ad.sdk.jad_lw.jad_an<T> jad_an2 = jad_an((Class) cls);
        int jad_an3 = jad_an2.jad_an(t2);
        int jad_bo2 = jad_an2.jad_bo() * jad_an3;
        int i10 = 1;
        if (jad_bo2 <= this.jad_er / 2) {
            jad_an jad_an4 = this.jad_bo.jad_an(jad_an3, cls);
            this.jad_an.jad_an(jad_an4, t2);
            NavigableMap<Integer, Integer> jad_bo3 = jad_bo(cls);
            Integer num = jad_bo3.get(Integer.valueOf(jad_an4.jad_bo));
            Integer valueOf = Integer.valueOf(jad_an4.jad_bo);
            if (num != null) {
                i10 = 1 + num.intValue();
            }
            jad_bo3.put(valueOf, Integer.valueOf(i10));
            this.jad_fs += jad_bo2;
            jad_bo(this.jad_er);
        }
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_bo
    public synchronized void jad_an(int i10) {
        try {
            if (i10 >= 40) {
                synchronized (this) {
                    jad_bo(0);
                }
            } else if (i10 >= 20 || i10 == 15) {
                jad_bo(this.jad_er / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
