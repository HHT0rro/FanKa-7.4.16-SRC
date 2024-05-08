package org.json.alipay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList f52716a;

    public a() {
        this.f52716a = new ArrayList();
    }

    public a(Object obj) {
        this();
        if (!obj.getClass().isArray()) {
            throw new JSONException("JSONArray initial value should be a string or collection or array.");
        }
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f52716a.add(Array.get(obj, i10));
        }
    }

    public a(String str) {
        this(new c(str));
    }

    public a(Collection collection) {
        this.f52716a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public a(c cVar) {
        this();
        char c4;
        ArrayList arrayList;
        Object d10;
        char c10 = cVar.c();
        if (c10 == '[') {
            c4 = ']';
        } else {
            if (c10 != '(') {
                throw cVar.a("A JSONArray text must start with '['");
            }
            c4 = ')';
        }
        if (cVar.c() == ']') {
            return;
        }
        do {
            cVar.a();
            char c11 = cVar.c();
            cVar.a();
            if (c11 == ',') {
                arrayList = this.f52716a;
                d10 = null;
            } else {
                arrayList = this.f52716a;
                d10 = cVar.d();
            }
            arrayList.add(d10);
            char c12 = cVar.c();
            if (c12 != ')') {
                if (c12 != ',' && c12 != ';') {
                    if (c12 != ']') {
                        throw cVar.a("Expected a ',' or ']'");
                    }
                }
            }
            if (c4 == c12) {
                return;
            }
            throw cVar.a("Expected a '" + ((Object) new Character(c4)) + "'");
        } while (cVar.c() != ']');
    }

    private String a(String str) {
        int size = this.f52716a.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(b.a(this.f52716a.get(i10)));
        }
        return stringBuffer.toString();
    }

    public final int a() {
        return this.f52716a.size();
    }

    public final Object a(int i10) {
        Object obj = (i10 < 0 || i10 >= this.f52716a.size()) ? null : this.f52716a.get(i10);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONArray[" + i10 + "] not found.");
    }

    public String toString() {
        try {
            return "[" + a(",") + ']';
        } catch (Exception unused) {
            return null;
        }
    }
}
