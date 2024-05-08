package com.jd.ad.sdk.jad_oz;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_jw implements jad_hu {
    public final Map<String, List<jad_iv>> jad_bo;
    public volatile Map<String, String> jad_cp;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class jad_an {
        public static final Map<String, List<jad_iv>> jad_bo;
        public Map<String, List<jad_iv>> jad_an = jad_bo;

        static {
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder sb2 = new StringBuilder(property.length());
                for (int i10 = 0; i10 < length; i10++) {
                    char charAt = property.charAt(i10);
                    if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                        charAt = '?';
                    }
                    sb2.append(charAt);
                }
                property = sb2.toString();
            }
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(property)) {
                hashMap.put("User-Agent", Collections.singletonList(new jad_bo(property)));
            }
            jad_bo = Collections.unmodifiableMap(hashMap);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class jad_bo implements jad_iv {

        @NonNull
        public final String jad_an;

        public jad_bo(@NonNull String str) {
            this.jad_an = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof jad_bo) {
                return this.jad_an.equals(((jad_bo) obj).jad_an);
            }
            return false;
        }

        public int hashCode() {
            return this.jad_an.hashCode();
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_iv
        public String jad_an() {
            return this.jad_an;
        }

        public String toString() {
            StringBuilder jad_an = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("StringHeaderFactory{value='");
            jad_an.append(this.jad_an);
            jad_an.append('\'');
            jad_an.append('}');
            return jad_an.toString();
        }
    }

    public jad_jw(Map<String, List<jad_iv>> map) {
        this.jad_bo = Collections.unmodifiableMap(map);
    }

    public boolean equals(Object obj) {
        if (obj instanceof jad_jw) {
            return this.jad_bo.equals(((jad_jw) obj).jad_bo);
        }
        return false;
    }

    public int hashCode() {
        return this.jad_bo.hashCode();
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_hu
    public Map<String, String> jad_an() {
        if (this.jad_cp == null) {
            synchronized (this) {
                if (this.jad_cp == null) {
                    this.jad_cp = Collections.unmodifiableMap(jad_bo());
                }
            }
        }
        return this.jad_cp;
    }

    public final Map<String, String> jad_bo() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<jad_iv>> entry : this.jad_bo.entrySet()) {
            List<jad_iv> value = entry.getValue();
            StringBuilder sb2 = new StringBuilder();
            int size = value.size();
            for (int i10 = 0; i10 < size; i10++) {
                String jad_an2 = value.get(i10).jad_an();
                if (!TextUtils.isEmpty(jad_an2)) {
                    sb2.append(jad_an2);
                    if (i10 != value.size() - 1) {
                        sb2.append(',');
                    }
                }
            }
            String sb3 = sb2.toString();
            if (!TextUtils.isEmpty(sb3)) {
                hashMap.put(entry.getKey(), sb3);
            }
        }
        return hashMap;
    }

    public String toString() {
        StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("LazyHeaders{headers=");
        jad_an2.append((Object) this.jad_bo);
        jad_an2.append('}');
        return jad_an2.toString();
    }
}
