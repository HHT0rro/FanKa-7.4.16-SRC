package yb;

import android.database.sqlite.SQLiteProgram;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: SqlCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f54737a;

    /* renamed from: b, reason: collision with root package name */
    public final List<Object> f54738b;

    public d0(String str, List<Object> list) {
        this.f54737a = str;
        this.f54738b = list == null ? new ArrayList<>() : list;
    }

    public static Object f(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof List)) {
            return obj;
        }
        List list = (List) obj;
        byte[] bArr = new byte[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            bArr[i10] = (byte) ((Integer) list.get(i10)).intValue();
        }
        return bArr;
    }

    public void a(SQLiteProgram sQLiteProgram) {
        List<Object> list = this.f54738b;
        if (list != null) {
            int size = list.size();
            int i10 = 0;
            while (i10 < size) {
                Object f10 = f(this.f54738b.get(i10));
                int i11 = i10 + 1;
                if (f10 == null) {
                    sQLiteProgram.bindNull(i11);
                } else if (f10 instanceof byte[]) {
                    sQLiteProgram.bindBlob(i11, (byte[]) f10);
                } else if (f10 instanceof Double) {
                    sQLiteProgram.bindDouble(i11, ((Double) f10).doubleValue());
                } else if (f10 instanceof Integer) {
                    sQLiteProgram.bindLong(i11, ((Integer) f10).intValue());
                } else if (f10 instanceof Long) {
                    sQLiteProgram.bindLong(i11, ((Long) f10).longValue());
                } else if (f10 instanceof String) {
                    sQLiteProgram.bindString(i11, (String) f10);
                } else if (f10 instanceof Boolean) {
                    sQLiteProgram.bindLong(i11, ((Boolean) f10).booleanValue() ? 1L : 0L);
                } else {
                    throw new IllegalArgumentException("Could not bind " + f10 + " from index " + i10 + ": Supported types are null, byte[], double, long, boolean and String");
                }
                i10 = i11;
            }
        }
    }

    public List<Object> b() {
        return this.f54738b;
    }

    public String c() {
        return this.f54737a;
    }

    public Object[] d() {
        return e(this.f54738b);
    }

    public final Object[] e(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<Object> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(f(iterator2.next()));
            }
        }
        return arrayList.toArray(new Object[0]);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        String str = this.f54737a;
        if (str != null) {
            if (!str.equals(d0Var.f54737a)) {
                return false;
            }
        } else if (d0Var.f54737a != null) {
            return false;
        }
        if (this.f54738b.size() != d0Var.f54738b.size()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f54738b.size(); i10++) {
            if ((this.f54738b.get(i10) instanceof byte[]) && (d0Var.f54738b.get(i10) instanceof byte[])) {
                if (!Arrays.equals((byte[]) this.f54738b.get(i10), (byte[]) d0Var.f54738b.get(i10))) {
                    return false;
                }
            } else if (!this.f54738b.get(i10).equals(d0Var.f54738b.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        String str = this.f54737a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f54737a);
        List<Object> list = this.f54738b;
        if (list == null || list.isEmpty()) {
            str = "";
        } else {
            str = " " + ((Object) this.f54738b);
        }
        sb2.append(str);
        return sb2.toString();
    }
}
