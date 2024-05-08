package com.jd.ad.sdk.jad_kv;

import com.jd.ad.sdk.jad_kv.jad_hu;
import com.jd.ad.sdk.jad_kv.jad_mz;
import com.jd.ad.sdk.jad_oz.jad_na;
import com.jd.ad.sdk.jad_oz.jad_re;
import com.jd.ad.sdk.jad_wh.jad_fs;
import com.jd.ad.sdk.jad_zk.jad_er;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_jt<Transcode> {
    public final List<jad_na.jad_an<?>> jad_an = new ArrayList();
    public final List<com.jd.ad.sdk.jad_hs.jad_hu> jad_bo = new ArrayList();
    public com.jd.ad.sdk.jad_ep.jad_er jad_cp;
    public Object jad_dq;
    public int jad_er;
    public int jad_fs;
    public jad_hu.jad_er jad_hu;
    public com.jd.ad.sdk.jad_hs.jad_jw jad_iv;
    public Class<?> jad_jt;
    public Map<Class<?>, com.jd.ad.sdk.jad_hs.jad_na<?>> jad_jw;
    public Class<Transcode> jad_kx;
    public boolean jad_ly;
    public boolean jad_mz;
    public com.jd.ad.sdk.jad_hs.jad_hu jad_na;
    public com.jd.ad.sdk.jad_ep.jad_jt jad_ob;
    public jad_ly jad_pc;
    public boolean jad_qd;
    public boolean jad_re;

    /* JADX WARN: Multi-variable type inference failed */
    public <Data> jad_vi<Data, ?, Transcode> jad_an(Class<Data> cls) {
        jad_vi<Data, ?, Transcode> jad_viVar;
        ArrayList arrayList;
        com.jd.ad.sdk.jad_wh.jad_er jad_erVar;
        com.jd.ad.sdk.jad_wh.jad_er jad_erVar2;
        com.jd.ad.sdk.jad_ep.jad_hu jad_huVar = this.jad_cp.jad_bo;
        Class<?> cls2 = this.jad_jt;
        Class<Transcode> cls3 = this.jad_kx;
        com.jd.ad.sdk.jad_zk.jad_cp jad_cpVar = jad_huVar.jad_iv;
        com.jd.ad.sdk.jad_gp.jad_jw andSet = jad_cpVar.jad_bo.getAndSet(null);
        if (andSet == null) {
            andSet = new com.jd.ad.sdk.jad_gp.jad_jw();
        }
        andSet.jad_an = cls;
        andSet.jad_bo = cls2;
        andSet.jad_cp = cls3;
        synchronized (jad_cpVar.jad_an) {
            jad_viVar = (jad_vi) jad_cpVar.jad_an.get(andSet);
        }
        jad_cpVar.jad_bo.set(andSet);
        jad_huVar.jad_iv.getClass();
        if (com.jd.ad.sdk.jad_zk.jad_cp.jad_cp.equals(jad_viVar)) {
            return null;
        }
        if (jad_viVar != null) {
            return jad_viVar;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator2 = ((ArrayList) jad_huVar.jad_cp.jad_an(cls, cls2)).iterator2();
        while (iterator2.hasNext()) {
            Class<?> cls4 = (Class) iterator2.next();
            Iterator iterator22 = ((ArrayList) jad_huVar.jad_fs.jad_an(cls4, cls3)).iterator2();
            while (iterator22.hasNext()) {
                Class cls5 = (Class) iterator22.next();
                com.jd.ad.sdk.jad_zk.jad_er jad_erVar3 = jad_huVar.jad_cp;
                synchronized (jad_erVar3) {
                    arrayList = new ArrayList();
                    Iterator<String> iterator23 = jad_erVar3.jad_an.iterator2();
                    while (iterator23.hasNext()) {
                        List<jad_er.jad_an<?, ?>> list = jad_erVar3.jad_bo.get(iterator23.next());
                        if (list != null) {
                            for (jad_er.jad_an<?, ?> jad_anVar : list) {
                                if (jad_anVar.jad_an.isAssignableFrom(cls) && cls4.isAssignableFrom(jad_anVar.jad_bo)) {
                                    arrayList.add(jad_anVar.jad_cp);
                                }
                            }
                        }
                    }
                }
                com.jd.ad.sdk.jad_wh.jad_fs jad_fsVar = jad_huVar.jad_fs;
                synchronized (jad_fsVar) {
                    if (!cls5.isAssignableFrom(cls4)) {
                        for (jad_fs.jad_an<?, ?> jad_anVar2 : jad_fsVar.jad_an) {
                            if (jad_anVar2.jad_an.isAssignableFrom(cls4) && cls5.isAssignableFrom(jad_anVar2.jad_bo)) {
                                jad_erVar = jad_anVar2.jad_cp;
                            }
                        }
                        throw new IllegalArgumentException("No transcoder registered to transcode from " + ((Object) cls4) + " to " + ((Object) cls5));
                    }
                    jad_erVar = com.jd.ad.sdk.jad_wh.jad_jt.jad_an;
                    jad_erVar2 = jad_erVar;
                }
                arrayList2.add(new jad_kx(cls, cls4, cls5, arrayList, jad_erVar2, jad_huVar.jad_jw));
            }
        }
        jad_vi<Data, ?, Transcode> jad_viVar2 = arrayList2.isEmpty() ? null : new jad_vi<>(cls, cls2, cls3, arrayList2, jad_huVar.jad_jw);
        com.jd.ad.sdk.jad_zk.jad_cp jad_cpVar2 = jad_huVar.jad_iv;
        synchronized (jad_cpVar2.jad_an) {
            jad_cpVar2.jad_an.put(new com.jd.ad.sdk.jad_gp.jad_jw(cls, cls2, cls3), jad_viVar2 != null ? jad_viVar2 : com.jd.ad.sdk.jad_zk.jad_cp.jad_cp);
        }
        return jad_viVar2;
    }

    public List<com.jd.ad.sdk.jad_hs.jad_hu> jad_an() {
        if (!this.jad_mz) {
            this.jad_mz = true;
            this.jad_bo.clear();
            List<jad_na.jad_an<?>> jad_cp = jad_cp();
            int size = jad_cp.size();
            for (int i10 = 0; i10 < size; i10++) {
                jad_na.jad_an<?> jad_anVar = jad_cp.get(i10);
                if (!this.jad_bo.contains(jad_anVar.jad_an)) {
                    this.jad_bo.add(jad_anVar.jad_an);
                }
                for (int i11 = 0; i11 < jad_anVar.jad_bo.size(); i11++) {
                    if (!this.jad_bo.contains(jad_anVar.jad_bo.get(i11))) {
                        this.jad_bo.add(jad_anVar.jad_bo.get(i11));
                    }
                }
            }
        }
        return this.jad_bo;
    }

    public <Z> com.jd.ad.sdk.jad_hs.jad_na<Z> jad_bo(Class<Z> cls) {
        com.jd.ad.sdk.jad_hs.jad_na<Z> jad_naVar = (com.jd.ad.sdk.jad_hs.jad_na) this.jad_jw.get(cls);
        if (jad_naVar == null) {
            Iterator<Map.Entry<Class<?>, com.jd.ad.sdk.jad_hs.jad_na<?>>> iterator2 = this.jad_jw.entrySet().iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, com.jd.ad.sdk.jad_hs.jad_na<?>> next = iterator2.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    jad_naVar = (com.jd.ad.sdk.jad_hs.jad_na) next.getValue();
                    break;
                }
            }
        }
        if (jad_naVar != null) {
            return jad_naVar;
        }
        if (!this.jad_jw.isEmpty() || !this.jad_qd) {
            return (com.jd.ad.sdk.jad_qb.jad_bo) com.jd.ad.sdk.jad_qb.jad_bo.jad_bo;
        }
        throw new IllegalArgumentException("Missing transformation for " + ((Object) cls) + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    public com.jd.ad.sdk.jad_mx.jad_an jad_bo() {
        return ((jad_mz.jad_cp) this.jad_hu).jad_an();
    }

    public List<jad_na.jad_an<?>> jad_cp() {
        if (!this.jad_ly) {
            this.jad_ly = true;
            this.jad_an.clear();
            List jad_an = this.jad_cp.jad_bo.jad_an((com.jd.ad.sdk.jad_ep.jad_hu) this.jad_dq);
            int size = jad_an.size();
            for (int i10 = 0; i10 < size; i10++) {
                jad_na.jad_an<?> jad_an2 = ((com.jd.ad.sdk.jad_oz.jad_na) jad_an.get(i10)).jad_an(this.jad_dq, this.jad_er, this.jad_fs, this.jad_iv);
                if (jad_an2 != null) {
                    this.jad_an.add(jad_an2);
                }
            }
        }
        return this.jad_an;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean jad_cp(Class<?> cls) {
        return jad_an((Class) cls) != null;
    }

    public List<Class<?>> jad_dq() {
        List<Class<?>> list;
        ArrayList arrayList;
        com.jd.ad.sdk.jad_ep.jad_hu jad_huVar = this.jad_cp.jad_bo;
        Class<?> cls = this.jad_dq.getClass();
        Class<?> cls2 = this.jad_jt;
        Class<Transcode> cls3 = this.jad_kx;
        com.jd.ad.sdk.jad_zk.jad_dq jad_dqVar = jad_huVar.jad_hu;
        com.jd.ad.sdk.jad_gp.jad_jw andSet = jad_dqVar.jad_an.getAndSet(null);
        if (andSet == null) {
            andSet = new com.jd.ad.sdk.jad_gp.jad_jw(cls, cls2, cls3);
        } else {
            andSet.jad_an = cls;
            andSet.jad_bo = cls2;
            andSet.jad_cp = cls3;
        }
        synchronized (jad_dqVar.jad_bo) {
            list = jad_dqVar.jad_bo.get(andSet);
        }
        jad_dqVar.jad_an.set(andSet);
        List<Class<?>> list2 = list;
        if (list == null) {
            ArrayList arrayList2 = new ArrayList();
            com.jd.ad.sdk.jad_oz.jad_pc jad_pcVar = jad_huVar.jad_an;
            synchronized (jad_pcVar) {
                com.jd.ad.sdk.jad_oz.jad_re jad_reVar = jad_pcVar.jad_an;
                synchronized (jad_reVar) {
                    arrayList = new ArrayList();
                    for (jad_re.jad_bo<?, ?> jad_boVar : jad_reVar.jad_an) {
                        if (!arrayList.contains(jad_boVar.jad_bo) && jad_boVar.jad_an.isAssignableFrom(cls)) {
                            arrayList.add(jad_boVar.jad_bo);
                        }
                    }
                }
            }
            Iterator iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                Iterator iterator22 = ((ArrayList) jad_huVar.jad_cp.jad_an((Class) iterator2.next(), cls2)).iterator2();
                while (iterator22.hasNext()) {
                    Class cls4 = (Class) iterator22.next();
                    if (!((ArrayList) jad_huVar.jad_fs.jad_an(cls4, cls3)).isEmpty() && !arrayList2.contains(cls4)) {
                        arrayList2.add(cls4);
                    }
                }
            }
            com.jd.ad.sdk.jad_zk.jad_dq jad_dqVar2 = jad_huVar.jad_hu;
            List<Class<?>> unmodifiableList = Collections.unmodifiableList(arrayList2);
            synchronized (jad_dqVar2.jad_bo) {
                jad_dqVar2.jad_bo.put(new com.jd.ad.sdk.jad_gp.jad_jw(cls, cls2, cls3), unmodifiableList);
            }
            list2 = arrayList2;
        }
        return list2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        r1 = (com.jd.ad.sdk.jad_hs.jad_dq<X>) r3.jad_bo;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <X> com.jd.ad.sdk.jad_hs.jad_dq<X> jad_an(X r6) {
        /*
            r5 = this;
            com.jd.ad.sdk.jad_ep.jad_er r0 = r5.jad_cp
            com.jd.ad.sdk.jad_ep.jad_hu r0 = r0.jad_bo
            com.jd.ad.sdk.jad_zk.jad_an r0 = r0.jad_bo
            java.lang.Class r1 = r6.getClass()
            monitor-enter(r0)
            java.util.List<com.jd.ad.sdk.jad_zk.jad_an$jad_an<?>> r2 = r0.jad_an     // Catch: java.lang.Throwable -> L37
            java.util.Iterator r2 = r2.iterator2()     // Catch: java.lang.Throwable -> L37
        L11:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L37
            if (r3 == 0) goto L28
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L37
            com.jd.ad.sdk.jad_zk.jad_an$jad_an r3 = (com.jd.ad.sdk.jad_zk.jad_an.C0396jad_an) r3     // Catch: java.lang.Throwable -> L37
            java.lang.Class<T> r4 = r3.jad_an     // Catch: java.lang.Throwable -> L37
            boolean r4 = r4.isAssignableFrom(r1)     // Catch: java.lang.Throwable -> L37
            if (r4 == 0) goto L11
            com.jd.ad.sdk.jad_hs.jad_dq<T> r1 = r3.jad_bo     // Catch: java.lang.Throwable -> L37
            goto L29
        L28:
            r1 = 0
        L29:
            monitor-exit(r0)
            if (r1 == 0) goto L2d
            return r1
        L2d:
            com.jd.ad.sdk.jad_ep.jad_hu$jad_er r0 = new com.jd.ad.sdk.jad_ep.jad_hu$jad_er
            java.lang.Class r6 = r6.getClass()
            r0.<init>(r6)
            throw r0
        L37:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_kv.jad_jt.jad_an(java.lang.Object):com.jd.ad.sdk.jad_hs.jad_dq");
    }

    public boolean jad_an(jad_xk<?> jad_xkVar) {
        return this.jad_cp.jad_bo.jad_dq.jad_an(jad_xkVar.jad_cp()) != null;
    }
}
