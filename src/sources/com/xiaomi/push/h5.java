package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class h5 implements l5 {

    /* renamed from: a, reason: collision with root package name */
    public String f47381a;

    /* renamed from: b, reason: collision with root package name */
    public String f47382b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f47383c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f47384d;

    /* renamed from: e, reason: collision with root package name */
    public String f47385e;

    /* renamed from: f, reason: collision with root package name */
    public List<h5> f47386f;

    public h5(String str, String str2, String[] strArr, String[] strArr2) {
        this.f47386f = null;
        this.f47381a = str;
        this.f47382b = str2;
        this.f47383c = strArr;
        this.f47384d = strArr2;
    }

    public h5(String str, String str2, String[] strArr, String[] strArr2, String str3, List<h5> list) {
        this.f47381a = str;
        this.f47382b = str2;
        this.f47383c = strArr;
        this.f47384d = strArr2;
        this.f47385e = str3;
        this.f47386f = list;
    }

    public static h5 c(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i10 = 0;
        for (String str : keySet) {
            strArr[i10] = str;
            strArr2[i10] = bundle2.getString(str);
            i10++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(c((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new h5(string, string2, strArr, strArr2, string3, arrayList);
    }

    public static Parcelable[] h(List<h5> list) {
        return i((h5[]) list.toArray(new h5[list.size()]));
    }

    public static Parcelable[] i(h5[] h5VarArr) {
        if (h5VarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[h5VarArr.length];
        for (int i10 = 0; i10 < h5VarArr.length; i10++) {
            parcelableArr[i10] = h5VarArr[i10].b();
        }
        return parcelableArr;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f47381a);
        bundle.putString("ext_ns", this.f47382b);
        bundle.putString("ext_text", this.f47385e);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f47383c;
        if (strArr != null && strArr.length > 0) {
            int i10 = 0;
            while (true) {
                String[] strArr2 = this.f47383c;
                if (i10 >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i10], this.f47384d[i10]);
                i10++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<h5> list = this.f47386f;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", h(this.f47386f));
        }
        return bundle;
    }

    public Parcelable b() {
        return a();
    }

    @Override // com.xiaomi.push.l5
    public String d() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<");
        sb2.append(this.f47381a);
        if (!TextUtils.isEmpty(this.f47382b)) {
            sb2.append(" ");
            sb2.append("xmlns=");
            sb2.append("\"");
            sb2.append(this.f47382b);
            sb2.append("\"");
        }
        String[] strArr = this.f47383c;
        if (strArr != null && strArr.length > 0) {
            for (int i10 = 0; i10 < this.f47383c.length; i10++) {
                if (!TextUtils.isEmpty(this.f47384d[i10])) {
                    sb2.append(" ");
                    sb2.append(this.f47383c[i10]);
                    sb2.append("=\"");
                    sb2.append(u5.b(this.f47384d[i10]));
                    sb2.append("\"");
                }
            }
        }
        if (TextUtils.isEmpty(this.f47385e)) {
            List<h5> list = this.f47386f;
            if (list == null || list.size() <= 0) {
                sb2.append("/>");
                return sb2.toString();
            }
            sb2.append(">");
            Iterator<h5> iterator2 = this.f47386f.iterator2();
            while (iterator2.hasNext()) {
                sb2.append(iterator2.next().d());
            }
        } else {
            sb2.append(">");
            sb2.append(this.f47385e);
        }
        sb2.append("</");
        sb2.append(this.f47381a);
        sb2.append(">");
        return sb2.toString();
    }

    public String e() {
        return this.f47381a;
    }

    public String f(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.f47383c == null) {
            return null;
        }
        int i10 = 0;
        while (true) {
            String[] strArr = this.f47383c;
            if (i10 >= strArr.length) {
                return null;
            }
            if (str.equals(strArr[i10])) {
                return this.f47384d[i10];
            }
            i10++;
        }
    }

    public void g(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = u5.b(str);
        }
        this.f47385e = str;
    }

    public String j() {
        return this.f47382b;
    }

    public String k() {
        return !TextUtils.isEmpty(this.f47385e) ? u5.e(this.f47385e) : this.f47385e;
    }

    public String toString() {
        return d();
    }
}
