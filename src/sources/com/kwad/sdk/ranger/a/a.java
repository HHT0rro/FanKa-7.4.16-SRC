package com.kwad.sdk.ranger.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public static final String TAG = "Ranger_" + a.class.getSimpleName();

    @NonNull
    public String aNA;
    public b aNB;
    public a aNC;
    public Object aNw;
    public String aNx;
    public String aNy;
    public boolean aNz;

    @KsJson
    /* renamed from: com.kwad.sdk.ranger.a.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0544a extends com.kwad.sdk.core.response.a.a {
        public String aND;
        public String aNE;
        public String aNF;
        public List<String> aNG;
        public List<C0544a> aNH = new ArrayList();
        public Object aNI;
        public List<Object> aNJ;
        public String className;
        public String fieldName;

        private Object KG() {
            Object obj = null;
            try {
            } catch (Exception e2) {
                c.d(a.TAG, Log.getStackTraceString(e2));
            }
            if (TextUtils.isEmpty(this.className)) {
                c.w(a.TAG, "SpecialParam className is null");
                return null;
            }
            obj = s.gw(this.className);
            c.d(a.TAG, "Class.forName(className):" + this.className + " value:" + obj);
            List<C0544a> list = this.aNH;
            if (list != null && !list.isEmpty()) {
                for (C0544a c0544a : this.aNH) {
                    c0544a.aNI = obj;
                    c.d(a.TAG, "param.ob:" + c0544a.aNI);
                    try {
                        s.a(c0544a.aNI, c0544a.fieldName, c0544a.getValue());
                    } catch (Exception e10) {
                        c.d(a.TAG, Log.getStackTraceString(e10));
                    }
                }
            }
            c.d(a.TAG, "return value in special:" + obj);
            return obj;
        }

        private Object KH() {
            if (TextUtils.isEmpty(this.aNF)) {
                return ao(this.aND, this.aNE);
            }
            this.aNJ = new ArrayList();
            Iterator<String> iterator2 = this.aNG.iterator2();
            while (iterator2.hasNext()) {
                Object ao = ao(this.aNF, iterator2.next());
                if (ao != null) {
                    this.aNJ.add(ao);
                }
            }
            return this.aNJ;
        }

        private static Object ao(String str, String str2) {
            Object obj = null;
            try {
                Class<?> cls = Class.forName(str);
                if (cls == Integer.class) {
                    obj = Integer.valueOf(Integer.parseInt(str2));
                } else if (cls == Long.class) {
                    obj = Long.valueOf(Long.parseLong(str2));
                } else if (cls == Float.class) {
                    obj = Float.valueOf(Float.parseFloat(str2));
                } else if (cls == Boolean.class) {
                    obj = Boolean.valueOf(Boolean.parseBoolean(str2));
                } else if (cls == Double.class) {
                    obj = Double.valueOf(Double.parseDouble(str2));
                } else {
                    if (cls != String.class) {
                        str2 = null;
                    }
                    obj = str2;
                }
            } catch (Exception e2) {
                c.w(a.TAG, Log.getStackTraceString(e2));
            }
            return obj;
        }

        public final Object getValue() {
            if (TextUtils.isEmpty(this.aND) && TextUtils.isEmpty(this.aNF)) {
                return KG();
            }
            return KH();
        }
    }

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public boolean aNK;
        public List<C0544a> aNL;
        public Object[] aNM;
        public String name;

        public final boolean KF() {
            if (!TextUtils.isEmpty(this.name)) {
                return false;
            }
            List<C0544a> list = this.aNL;
            return (list == null || list.isEmpty()) && this.aNM == null;
        }

        public final Object[] KI() {
            List<C0544a> list = this.aNL;
            if (list == null || list.isEmpty()) {
                return null;
            }
            Object[] objArr = new Object[this.aNL.size()];
            for (int i10 = 0; i10 < this.aNL.size(); i10++) {
                objArr[i10] = this.aNL.get(i10).getValue();
            }
            return objArr;
        }
    }

    public final boolean KF() {
        if (this.aNw != null || !TextUtils.isEmpty(this.aNx) || !TextUtils.isEmpty(this.aNy) || !TextUtils.isEmpty(this.aNA)) {
            return false;
        }
        b bVar = this.aNB;
        if (bVar != null && !bVar.KF()) {
            return false;
        }
        a aVar = this.aNC;
        return aVar == null || aVar.KF();
    }
}
