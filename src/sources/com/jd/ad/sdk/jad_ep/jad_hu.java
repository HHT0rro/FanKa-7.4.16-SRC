package com.jd.ad.sdk.jad_ep;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.jd.ad.sdk.jad_hs.jad_mz;
import com.jd.ad.sdk.jad_it.jad_er;
import com.jd.ad.sdk.jad_oz.jad_na;
import com.jd.ad.sdk.jad_oz.jad_ob;
import com.jd.ad.sdk.jad_oz.jad_pc;
import com.jd.ad.sdk.jad_oz.jad_re;
import com.jd.ad.sdk.jad_wh.jad_fs;
import com.jd.ad.sdk.jad_zk.jad_an;
import com.jd.ad.sdk.jad_zk.jad_er;
import com.jd.ad.sdk.jad_zk.jad_fs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_hu {
    public final jad_pc jad_an;
    public final com.jd.ad.sdk.jad_zk.jad_an jad_bo;
    public final com.jd.ad.sdk.jad_zk.jad_er jad_cp;
    public final com.jd.ad.sdk.jad_zk.jad_fs jad_dq;
    public final com.jd.ad.sdk.jad_it.jad_fs jad_er;
    public final com.jd.ad.sdk.jad_wh.jad_fs jad_fs;
    public final com.jd.ad.sdk.jad_zk.jad_dq jad_hu = new com.jd.ad.sdk.jad_zk.jad_dq();
    public final com.jd.ad.sdk.jad_zk.jad_cp jad_iv = new com.jd.ad.sdk.jad_zk.jad_cp();
    public final com.jd.ad.sdk.jad_zk.jad_bo jad_jt;
    public final Pools.Pool<List<Throwable>> jad_jw;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_an extends RuntimeException {
        public jad_an(@NonNull String str) {
            super(str);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class jad_bo extends jad_an {
        public jad_bo() {
            super("Failed to find image header parser.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_cp extends jad_an {
        public jad_cp(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + ((Object) cls) + " and data: " + ((Object) cls2));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public jad_cp(@androidx.annotation.NonNull java.lang.Object r2) {
            /*
                r1 = this;
                java.lang.String r0 = "Failed to find any ModelLoaders registered for model class: "
                java.lang.StringBuilder r0 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an(r0)
                java.lang.Class r2 = r2.getClass()
                r0.append(r2)
                java.lang.String r2 = r0.toString()
                r1.<init>(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ep.jad_hu.jad_cp.<init>(java.lang.Object):void");
        }

        public <M> jad_cp(@NonNull M m10, @NonNull List<jad_na<M, ?>> list) {
            super("Found ModelLoaders for model class: " + ((Object) list) + ", but none that handle this specific model instance: " + ((Object) m10));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_dq extends jad_an {
        public jad_dq(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + ((Object) cls) + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_er extends jad_an {
        public jad_er(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + ((Object) cls));
        }
    }

    public jad_hu() {
        Pools.Pool<List<Throwable>> jad_an2 = com.jd.ad.sdk.jad_hq.jad_an.jad_an();
        this.jad_jw = jad_an2;
        this.jad_an = new jad_pc(jad_an2);
        this.jad_bo = new com.jd.ad.sdk.jad_zk.jad_an();
        this.jad_cp = new com.jd.ad.sdk.jad_zk.jad_er();
        this.jad_dq = new com.jd.ad.sdk.jad_zk.jad_fs();
        this.jad_er = new com.jd.ad.sdk.jad_it.jad_fs();
        this.jad_fs = new com.jd.ad.sdk.jad_wh.jad_fs();
        this.jad_jt = new com.jd.ad.sdk.jad_zk.jad_bo();
        jad_an(Arrays.asList("Animation", Registry.BUCKET_BITMAP, Registry.BUCKET_BITMAP_DRAWABLE));
    }

    @NonNull
    public <Data> jad_hu jad_an(@NonNull Class<Data> cls, @NonNull com.jd.ad.sdk.jad_hs.jad_dq<Data> jad_dqVar) {
        com.jd.ad.sdk.jad_zk.jad_an jad_anVar = this.jad_bo;
        synchronized (jad_anVar) {
            jad_anVar.jad_an.add(new jad_an.C0396jad_an<>(cls, jad_dqVar));
        }
        return this;
    }

    @NonNull
    public <Data, TResource> jad_hu jad_an(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.jd.ad.sdk.jad_hs.jad_ly<Data, TResource> jad_lyVar) {
        jad_an("legacy_append", cls, cls2, jad_lyVar);
        return this;
    }

    @NonNull
    public <X> com.jd.ad.sdk.jad_it.jad_er<X> jad_bo(@NonNull X x10) {
        com.jd.ad.sdk.jad_it.jad_er<X> jad_erVar;
        com.jd.ad.sdk.jad_it.jad_fs jad_fsVar = this.jad_er;
        synchronized (jad_fsVar) {
            if (x10 != null) {
                jad_er.jad_an<?> jad_anVar = jad_fsVar.jad_an.get(x10.getClass());
                if (jad_anVar == null) {
                    Iterator<jad_er.jad_an<?>> iterator2 = jad_fsVar.jad_an.values().iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            break;
                        }
                        jad_er.jad_an<?> next = iterator2.next();
                        if (next.jad_an().isAssignableFrom(x10.getClass())) {
                            jad_anVar = next;
                            break;
                        }
                    }
                }
                if (jad_anVar == null) {
                    jad_anVar = com.jd.ad.sdk.jad_it.jad_fs.jad_bo;
                }
                jad_erVar = (com.jd.ad.sdk.jad_it.jad_er<X>) jad_anVar.jad_an(x10);
            } else {
                throw new NullPointerException("Argument must not be null");
            }
        }
        return jad_erVar;
    }

    @NonNull
    public <TResource> jad_hu jad_an(@NonNull Class<TResource> cls, @NonNull jad_mz<TResource> jad_mzVar) {
        com.jd.ad.sdk.jad_zk.jad_fs jad_fsVar = this.jad_dq;
        synchronized (jad_fsVar) {
            jad_fsVar.jad_an.add(new jad_fs.jad_an<>(cls, jad_mzVar));
        }
        return this;
    }

    @NonNull
    public <Model, Data> jad_hu jad_an(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull jad_ob<Model, Data> jad_obVar) {
        jad_pc jad_pcVar = this.jad_an;
        synchronized (jad_pcVar) {
            jad_re jad_reVar = jad_pcVar.jad_an;
            synchronized (jad_reVar) {
                jad_re.jad_bo<?, ?> jad_boVar = new jad_re.jad_bo<>(cls, cls2, jad_obVar);
                List<jad_re.jad_bo<?, ?>> list = jad_reVar.jad_an;
                list.add(list.size(), jad_boVar);
            }
            jad_pcVar.jad_bo.jad_an.clear();
        }
        return this;
    }

    @NonNull
    public <Data, TResource> jad_hu jad_an(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.jd.ad.sdk.jad_hs.jad_ly<Data, TResource> jad_lyVar) {
        List<jad_er.jad_an<?, ?>> list;
        com.jd.ad.sdk.jad_zk.jad_er jad_erVar = this.jad_cp;
        synchronized (jad_erVar) {
            synchronized (jad_erVar) {
                if (!jad_erVar.jad_an.contains(str)) {
                    jad_erVar.jad_an.add(str);
                }
                list = jad_erVar.jad_bo.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    jad_erVar.jad_bo.put(str, list);
                }
            }
            return this;
        }
        list.add(new jad_er.jad_an<>(cls, cls2, jad_lyVar));
        return this;
    }

    @NonNull
    public List<com.jd.ad.sdk.jad_hs.jad_fs> jad_an() {
        List<com.jd.ad.sdk.jad_hs.jad_fs> list;
        com.jd.ad.sdk.jad_zk.jad_bo jad_boVar = this.jad_jt;
        synchronized (jad_boVar) {
            list = jad_boVar.jad_an;
        }
        if (list.isEmpty()) {
            throw new jad_bo();
        }
        return list;
    }

    @NonNull
    public <Model> List<jad_na<Model, ?>> jad_an(@NonNull Model model) {
        List<jad_na<?, ?>> list;
        ArrayList arrayList;
        jad_pc jad_pcVar = this.jad_an;
        jad_pcVar.getClass();
        Class<?> cls = model.getClass();
        synchronized (jad_pcVar) {
            jad_pc.jad_an.C0386jad_an<?> c0386jad_an = jad_pcVar.jad_bo.jad_an.get(cls);
            list = c0386jad_an == null ? null : c0386jad_an.jad_an;
            if (list == null) {
                jad_re jad_reVar = jad_pcVar.jad_an;
                synchronized (jad_reVar) {
                    try {
                        arrayList = new ArrayList();
                        for (jad_re.jad_bo<?, ?> jad_boVar : jad_reVar.jad_an) {
                            if (!jad_reVar.jad_cp.contains(jad_boVar) && jad_boVar.jad_an.isAssignableFrom(cls)) {
                                jad_reVar.jad_cp.add(jad_boVar);
                                arrayList.add((jad_na) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_boVar.jad_cp.jad_an(jad_reVar)));
                                jad_reVar.jad_cp.remove(jad_boVar);
                            }
                        }
                    } finally {
                    }
                }
                list = Collections.unmodifiableList(arrayList);
                if (jad_pcVar.jad_bo.jad_an.put(cls, new jad_pc.jad_an.C0386jad_an<>(list)) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + ((Object) cls));
                }
            }
        }
        if (list.isEmpty()) {
            throw new jad_cp(model);
        }
        int size = list.size();
        List<jad_na<Model, ?>> emptyList = Collections.emptyList();
        boolean z10 = true;
        for (int i10 = 0; i10 < size; i10++) {
            jad_na<?, ?> jad_naVar = list.get(i10);
            if (jad_naVar.jad_an(model)) {
                if (z10) {
                    emptyList = new ArrayList<>(size - i10);
                    z10 = false;
                }
                emptyList.add(jad_naVar);
            }
        }
        if (emptyList.isEmpty()) {
            throw new jad_cp(model, (List<jad_na<Model, ?>>) list);
        }
        return emptyList;
    }

    @NonNull
    public jad_hu jad_an(@NonNull com.jd.ad.sdk.jad_hs.jad_fs jad_fsVar) {
        com.jd.ad.sdk.jad_zk.jad_bo jad_boVar = this.jad_jt;
        synchronized (jad_boVar) {
            jad_boVar.jad_an.add(jad_fsVar);
        }
        return this;
    }

    @NonNull
    public jad_hu jad_an(@NonNull jad_er.jad_an<?> jad_anVar) {
        com.jd.ad.sdk.jad_it.jad_fs jad_fsVar = this.jad_er;
        synchronized (jad_fsVar) {
            jad_fsVar.jad_an.put(jad_anVar.jad_an(), jad_anVar);
        }
        return this;
    }

    @NonNull
    public <TResource, Transcode> jad_hu jad_an(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull com.jd.ad.sdk.jad_wh.jad_er<TResource, Transcode> jad_erVar) {
        com.jd.ad.sdk.jad_wh.jad_fs jad_fsVar = this.jad_fs;
        synchronized (jad_fsVar) {
            jad_fsVar.jad_an.add(new jad_fs.jad_an<>(cls, cls2, jad_erVar));
        }
        return this;
    }

    @NonNull
    public final jad_hu jad_an(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next());
        }
        arrayList.add("legacy_append");
        com.jd.ad.sdk.jad_zk.jad_er jad_erVar = this.jad_cp;
        synchronized (jad_erVar) {
            ArrayList arrayList2 = new ArrayList(jad_erVar.jad_an);
            jad_erVar.jad_an.clear();
            Iterator iterator22 = arrayList.iterator2();
            while (iterator22.hasNext()) {
                jad_erVar.jad_an.add((String) iterator22.next());
            }
            Iterator iterator23 = arrayList2.iterator2();
            while (iterator23.hasNext()) {
                String str = (String) iterator23.next();
                if (!arrayList.contains(str)) {
                    jad_erVar.jad_an.add(str);
                }
            }
        }
        return this;
    }
}
