package com.jd.ad.sdk.jad_lw;

import androidx.annotation.Nullable;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.jd.ad.sdk.jad_lw.jad_mz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_hu<K extends jad_mz, V> {
    public final jad_an<K, V> jad_an = new jad_an<>();
    public final Map<K, jad_an<K, V>> jad_bo = new HashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_an<K, V> {
        public final K jad_an;
        public List<V> jad_bo;
        public jad_an<K, V> jad_cp;
        public jad_an<K, V> jad_dq;

        public jad_an() {
            this(null);
        }

        public jad_an(K k10) {
            this.jad_dq = this;
            this.jad_cp = this;
            this.jad_an = k10;
        }

        @Nullable
        public V jad_an() {
            List<V> list = this.jad_bo;
            int size = list != null ? list.size() : 0;
            if (size > 0) {
                return this.jad_bo.remove(size - 1);
            }
            return null;
        }
    }

    @Nullable
    public V jad_an(K k10) {
        jad_an<K, V> jad_anVar = this.jad_bo.get(k10);
        if (jad_anVar == null) {
            jad_anVar = new jad_an<>(k10);
            this.jad_bo.put(k10, jad_anVar);
        } else {
            k10.jad_an();
        }
        jad_an<K, V> jad_anVar2 = jad_anVar.jad_dq;
        jad_anVar2.jad_cp = jad_anVar.jad_cp;
        jad_anVar.jad_cp.jad_dq = jad_anVar2;
        jad_an<K, V> jad_anVar3 = this.jad_an;
        jad_anVar.jad_dq = jad_anVar3;
        jad_an<K, V> jad_anVar4 = jad_anVar3.jad_cp;
        jad_anVar.jad_cp = jad_anVar4;
        jad_anVar4.jad_dq = jad_anVar;
        jad_anVar.jad_dq.jad_cp = jad_anVar;
        return jad_anVar.jad_an();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("GroupedLinkedMap( ");
        boolean z10 = false;
        for (jad_an jad_anVar = this.jad_an.jad_cp; !jad_anVar.equals(this.jad_an); jad_anVar = jad_anVar.jad_cp) {
            z10 = true;
            sb2.append('{');
            sb2.append(jad_anVar.jad_an);
            sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
            List<V> list = jad_anVar.jad_bo;
            sb2.append(list != null ? list.size() : 0);
            sb2.append("}, ");
        }
        if (z10) {
            sb2.delete(sb2.length() - 2, sb2.length());
        }
        sb2.append(" )");
        return sb2.toString();
    }

    public void jad_an(K k10, V v2) {
        jad_an<K, V> jad_anVar = this.jad_bo.get(k10);
        if (jad_anVar == null) {
            jad_anVar = new jad_an<>(k10);
            jad_an<K, V> jad_anVar2 = jad_anVar.jad_dq;
            jad_anVar2.jad_cp = jad_anVar.jad_cp;
            jad_anVar.jad_cp.jad_dq = jad_anVar2;
            jad_an<K, V> jad_anVar3 = this.jad_an;
            jad_anVar.jad_dq = jad_anVar3.jad_dq;
            jad_anVar.jad_cp = jad_anVar3;
            jad_anVar3.jad_dq = jad_anVar;
            jad_anVar.jad_dq.jad_cp = jad_anVar;
            this.jad_bo.put(k10, jad_anVar);
        } else {
            k10.jad_an();
        }
        if (jad_anVar.jad_bo == null) {
            jad_anVar.jad_bo = new ArrayList();
        }
        jad_anVar.jad_bo.add(v2);
    }

    @Nullable
    public V jad_an() {
        for (jad_an jad_anVar = this.jad_an.jad_dq; !jad_anVar.equals(this.jad_an); jad_anVar = jad_anVar.jad_dq) {
            V v2 = (V) jad_anVar.jad_an();
            if (v2 != null) {
                return v2;
            }
            jad_an<K, V> jad_anVar2 = jad_anVar.jad_dq;
            jad_anVar2.jad_cp = jad_anVar.jad_cp;
            jad_anVar.jad_cp.jad_dq = jad_anVar2;
            this.jad_bo.remove(jad_anVar.jad_an);
            ((jad_mz) jad_anVar.jad_an).jad_an();
        }
        return null;
    }
}
