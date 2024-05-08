package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class am {
    private static am B = null;
    private static final String Code = "hiad_sp_properties_cache_sdk";
    private static final String I = "PropertiesCache";
    private static final String V = "cache_data";
    private static final byte[] Z = new byte[0];
    private SharedPreferences C;
    private a F;
    private final byte[] S = new byte[0];

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class a implements Cloneable {

        @com.huawei.openalliance.ad.annotations.b
        public String B;

        @com.huawei.openalliance.ad.annotations.b
        public Integer C;

        @com.huawei.openalliance.ad.annotations.b
        public String Code;

        @com.huawei.openalliance.ad.annotations.b
        public String D;

        @com.huawei.openalliance.ad.annotations.b
        public String F;

        @com.huawei.openalliance.ad.annotations.b
        public String I;

        @com.huawei.openalliance.ad.annotations.b
        public String L;

        @com.huawei.openalliance.ad.annotations.b
        public Boolean S;

        @com.huawei.openalliance.ad.annotations.b
        public Boolean V;

        @com.huawei.openalliance.ad.annotations.b
        public Boolean Z;

        /* renamed from: a, reason: collision with root package name */
        @com.huawei.openalliance.ad.annotations.b
        public Integer f32582a;

        /* renamed from: b, reason: collision with root package name */
        @com.huawei.openalliance.ad.annotations.b
        public Integer f32583b;

        @com.huawei.openalliance.ad.annotations.b
        public a() {
        }

        /* renamed from: Code, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.Code = this.Code;
            aVar.V = this.V;
            aVar.I = this.I;
            aVar.Z = this.Z;
            aVar.B = this.B;
            aVar.C = this.C;
            aVar.S = this.S;
            aVar.F = this.F;
            aVar.D = this.D;
            aVar.L = this.L;
            aVar.f32582a = this.f32582a;
            aVar.f32583b = this.f32583b;
            return aVar;
        }
    }

    private am(Context context) {
        this.C = context.getSharedPreferences(Code, 0);
    }

    public static am Code(Context context) {
        am amVar;
        synchronized (Z) {
            if (B == null) {
                B = new am(context);
            }
            amVar = B;
        }
        return amVar;
    }

    private void Code(a aVar) {
        if (aVar == null) {
            return;
        }
        final a clone = aVar.clone();
        f.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.am.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = am.this.C.edit();
                edit.putString(am.V, z.V(clone));
                edit.apply();
            }
        });
    }

    private void d() {
        if (this.F == null) {
            a aVar = null;
            String string = this.C.getString(V, null);
            if (string != null && string.length() > 0) {
                aVar = (a) z.V(string, a.class, new Class[0]);
            }
            if (aVar == null) {
                aVar = new a();
            }
            this.F = aVar;
        }
    }

    public Boolean B() {
        synchronized (this.S) {
            d();
            Boolean bool = this.F.Z;
            if (bool != null) {
                return bool;
            }
            return null;
        }
    }

    public void B(boolean z10) {
        synchronized (this.S) {
            d();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.L = String.valueOf(z10);
            Code(this.F);
        }
    }

    public String C() {
        String str;
        synchronized (this.S) {
            d();
            str = this.F.B;
        }
        return str;
    }

    public void Code() {
        synchronized (this.S) {
            d();
        }
    }

    public void Code(int i10) {
        synchronized (this.S) {
            d();
            this.F.C = Integer.valueOf(i10);
            Code(this.F);
        }
    }

    public void Code(Boolean bool) {
        synchronized (this.S) {
            d();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.S = bool;
            Code(aVar);
        }
    }

    public void Code(Integer num) {
        synchronized (this.S) {
            d();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.f32582a = num;
            Code(aVar);
        }
    }

    public void Code(String str) {
        synchronized (this.S) {
            d();
            a aVar = this.F;
            aVar.I = str;
            Code(aVar);
        }
    }

    public void Code(boolean z10) {
        synchronized (this.S) {
            d();
            this.F.V = Boolean.valueOf(z10);
            Code(this.F);
        }
    }

    public String D() {
        synchronized (this.S) {
            d();
            a aVar = this.F;
            if (aVar == null) {
                return "";
            }
            return aVar.F;
        }
    }

    public Boolean F() {
        synchronized (this.S) {
            d();
            a aVar = this.F;
            if (aVar == null) {
                return null;
            }
            return aVar.S;
        }
    }

    public String I() {
        synchronized (this.S) {
            d();
            String str = this.F.I;
            if (str != null) {
                return str;
            }
            return null;
        }
    }

    public void I(String str) {
        synchronized (this.S) {
            d();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.F = str;
            Code(aVar);
        }
    }

    public void I(boolean z10) {
        synchronized (this.S) {
            d();
            this.F.Z = Boolean.valueOf(z10);
            Code(this.F);
        }
    }

    public String L() {
        synchronized (this.S) {
            d();
            a aVar = this.F;
            if (aVar == null) {
                return null;
            }
            String str = aVar.D;
            if (str != null) {
                return str;
            }
            return null;
        }
    }

    public Integer S() {
        synchronized (this.S) {
            d();
            Integer num = this.F.C;
            if (num != null) {
                return num;
            }
            return null;
        }
    }

    public void V(Integer num) {
        synchronized (this.S) {
            d();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.f32583b = num;
            Code(aVar);
        }
    }

    public void V(String str) {
        synchronized (this.S) {
            d();
            a aVar = this.F;
            aVar.B = str;
            Code(aVar);
        }
    }

    public void V(boolean z10) {
        synchronized (this.S) {
            d();
            this.F.Code = String.valueOf(z10);
            Code(this.F);
        }
    }

    public boolean V() {
        synchronized (this.S) {
            d();
            Boolean bool = this.F.V;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
    }

    public String Z() {
        String str;
        synchronized (this.S) {
            d();
            str = this.F.Code;
        }
        return str;
    }

    public void Z(boolean z10) {
        synchronized (this.S) {
            d();
            a aVar = this.F;
            if (aVar == null) {
                return;
            }
            aVar.D = String.valueOf(z10);
            Code(this.F);
        }
    }

    public String a() {
        synchronized (this.S) {
            d();
            a aVar = this.F;
            if (aVar == null) {
                return null;
            }
            String str = aVar.L;
            if (str != null) {
                return str;
            }
            return null;
        }
    }

    public Integer b() {
        synchronized (this.S) {
            d();
            a aVar = this.F;
            if (aVar == null) {
                return null;
            }
            return aVar.f32582a;
        }
    }

    public Integer c() {
        synchronized (this.S) {
            d();
            a aVar = this.F;
            if (aVar == null) {
                return null;
            }
            Integer num = aVar.f32583b;
            if (num != null) {
                return num;
            }
            return null;
        }
    }
}
