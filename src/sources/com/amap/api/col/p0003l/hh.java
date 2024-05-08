package com.amap.api.col.p0003l;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: DBOperation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class hh {

    /* renamed from: d, reason: collision with root package name */
    private static Map<Class<? extends hg>, hg> f6249d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private hk f6250a;

    /* renamed from: b, reason: collision with root package name */
    private SQLiteDatabase f6251b;

    /* renamed from: c, reason: collision with root package name */
    private hg f6252c;

    public hh(Context context, hg hgVar) {
        try {
            this.f6250a = new hk(context.getApplicationContext(), hgVar.b(), hgVar.c(), hgVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f6252c = hgVar;
    }

    public static synchronized hg a(Class<? extends hg> cls) throws IllegalAccessException, InstantiationException {
        hg hgVar;
        synchronized (hh.class) {
            if (f6249d.get(cls) == null) {
                f6249d.put(cls, cls.newInstance());
            }
            hgVar = f6249d.get(cls);
        }
        return hgVar;
    }

    private <T> void b(String str, Object obj) {
        a(str, obj);
    }

    private <T> List<T> c(String str, Class<T> cls) {
        Cursor cursor;
        String str2;
        String str3;
        synchronized (this.f6252c) {
            ArrayList arrayList = new ArrayList();
            hi b4 = b((Class) cls);
            String a10 = a(b4);
            if (this.f6251b == null) {
                this.f6251b = a();
            }
            if (this.f6251b == null || TextUtils.isEmpty(a10) || str == null) {
                return arrayList;
            }
            try {
                cursor = this.f6251b.query(a10, null, str, null, null, null, null);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
            } catch (Throwable th2) {
                th = th2;
                try {
                    gv.a(th, "dbs", "sld");
                    try {
                        SQLiteDatabase sQLiteDatabase = this.f6251b;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                            this.f6251b = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str2 = "dbs";
                        str3 = "sld";
                        gv.a(th, str2, str3);
                        return arrayList;
                    }
                    return arrayList;
                } finally {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable th4) {
                            gv.a(th4, "dbs", "sld");
                        }
                    }
                    try {
                        SQLiteDatabase sQLiteDatabase2 = this.f6251b;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.close();
                            this.f6251b = null;
                            throw th;
                        }
                        throw th;
                    } catch (Throwable th5) {
                        gv.a(th5, "dbs", "sld");
                    }
                }
            }
            if (cursor == null) {
                this.f6251b.close();
                this.f6251b = null;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th6) {
                        gv.a(th6, "dbs", "sld");
                    }
                }
                try {
                    SQLiteDatabase sQLiteDatabase3 = this.f6251b;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                        this.f6251b = null;
                    }
                } catch (Throwable th7) {
                    gv.a(th7, "dbs", "sld");
                }
                return arrayList;
            }
            while (cursor.moveToNext()) {
                arrayList.add(a(cursor, cls, b4));
            }
            try {
                cursor.close();
            } catch (Throwable th8) {
                gv.a(th8, "dbs", "sld");
            }
            try {
                SQLiteDatabase sQLiteDatabase4 = this.f6251b;
                if (sQLiteDatabase4 != null) {
                    sQLiteDatabase4.close();
                    this.f6251b = null;
                }
            } catch (Throwable th9) {
                th = th9;
                str2 = "dbs";
                str3 = "sld";
                gv.a(th, str2, str3);
                return arrayList;
            }
            return arrayList;
        }
    }

    private <T> void b(T t2) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.f6252c) {
            SQLiteDatabase b4 = b();
            this.f6251b = b4;
            if (b4 == null) {
                return;
            }
            try {
                a(b4, t2);
                sQLiteDatabase = this.f6251b;
            } catch (Throwable th) {
                try {
                    gv.a(th, "dbs", "itd");
                    SQLiteDatabase sQLiteDatabase2 = this.f6251b;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                } catch (Throwable th2) {
                    SQLiteDatabase sQLiteDatabase3 = this.f6251b;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                        this.f6251b = null;
                    }
                    throw th2;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.f6251b = null;
            }
        }
    }

    public final <T> void a(String str, Class<T> cls) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.f6252c) {
            String a10 = a(b((Class) cls));
            if (TextUtils.isEmpty(a10)) {
                return;
            }
            SQLiteDatabase b4 = b();
            this.f6251b = b4;
            if (b4 == null) {
                return;
            }
            try {
                b4.delete(a10, str, null);
                sQLiteDatabase = this.f6251b;
            } catch (Throwable th) {
                try {
                    gv.a(th, "dbs", "dld");
                    SQLiteDatabase sQLiteDatabase2 = this.f6251b;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                } catch (Throwable th2) {
                    SQLiteDatabase sQLiteDatabase3 = this.f6251b;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                        this.f6251b = null;
                    }
                    throw th2;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.f6251b = null;
            }
        }
    }

    public final <T> List<T> b(String str, Class<T> cls) {
        return c(str, cls);
    }

    private SQLiteDatabase b() {
        try {
            SQLiteDatabase sQLiteDatabase = this.f6251b;
            if (sQLiteDatabase == null || sQLiteDatabase.isReadOnly()) {
                SQLiteDatabase sQLiteDatabase2 = this.f6251b;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                this.f6251b = this.f6250a.getWritableDatabase();
            }
        } catch (Throwable th) {
            gv.a(th, "dbs", "gwd");
        }
        return this.f6251b;
    }

    private <T> void a(String str, Object obj) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.f6252c) {
            if (obj == null) {
                return;
            }
            hi b4 = b((Class) obj.getClass());
            String a10 = a(b4);
            if (TextUtils.isEmpty(a10)) {
                return;
            }
            ContentValues a11 = a(obj, b4);
            SQLiteDatabase b10 = b();
            this.f6251b = b10;
            if (b10 == null) {
                return;
            }
            try {
                b10.update(a10, a11, str, null);
                sQLiteDatabase = this.f6251b;
            } catch (Throwable th) {
                try {
                    gv.a(th, "dbs", "udd");
                    SQLiteDatabase sQLiteDatabase2 = this.f6251b;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                } catch (Throwable th2) {
                    SQLiteDatabase sQLiteDatabase3 = this.f6251b;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                        this.f6251b = null;
                    }
                    throw th2;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.f6251b = null;
            }
        }
    }

    private static <T> hi b(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(hi.class);
        if (annotation != null) {
            return (hi) annotation;
        }
        return null;
    }

    public final void a(Object obj, String str) {
        synchronized (this.f6252c) {
            List b4 = b(str, (Class) obj.getClass());
            if (b4 != null && b4.size() != 0) {
                b(str, obj);
            }
            a((hh) obj);
        }
    }

    private <T> void a(T t2) {
        b((hh) t2);
    }

    private static <T> void a(SQLiteDatabase sQLiteDatabase, T t2) {
        hi b4 = b((Class) t2.getClass());
        String a10 = a(b4);
        if (TextUtils.isEmpty(a10) || sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.insert(a10, null, a(t2, b4));
    }

    public final <T> void a(List<T> list) {
        String str;
        String str2;
        synchronized (this.f6252c) {
            if (list.size() == 0) {
                return;
            }
            SQLiteDatabase b4 = b();
            this.f6251b = b4;
            if (b4 == null) {
                return;
            }
            try {
                b4.beginTransaction();
                Iterator<T> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    a(this.f6251b, iterator2.next());
                }
                this.f6251b.setTransactionSuccessful();
            } catch (Throwable th) {
                try {
                    gv.a(th, "dbs", "ild");
                    try {
                        if (this.f6251b.inTransaction()) {
                            this.f6251b.endTransaction();
                        }
                    } catch (Throwable th2) {
                        gv.a(th2, "dbs", "ild");
                    }
                    try {
                        this.f6251b.close();
                        this.f6251b = null;
                    } catch (Throwable th3) {
                        th = th3;
                        str = "dbs";
                        str2 = "ild";
                        gv.a(th, str, str2);
                    }
                } finally {
                    try {
                        if (this.f6251b.inTransaction()) {
                            this.f6251b.endTransaction();
                        }
                    } catch (Throwable th4) {
                        gv.a(th4, "dbs", "ild");
                    }
                    try {
                        this.f6251b.close();
                        this.f6251b = null;
                        throw th;
                    } catch (Throwable th5) {
                        gv.a(th5, "dbs", "ild");
                    }
                }
            }
            try {
                this.f6251b.close();
                this.f6251b = null;
            } catch (Throwable th6) {
                th = th6;
                str = "dbs";
                str2 = "ild";
                gv.a(th, str, str2);
            }
        }
    }

    private static <T> T a(Cursor cursor, Class<T> cls, hi hiVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] a10 = a((Class<?>) cls, hiVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : a10) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(hj.class);
            if (annotation != null) {
                hj hjVar = (hj) annotation;
                int b4 = hjVar.b();
                int columnIndex = cursor.getColumnIndex(hjVar.a());
                switch (b4) {
                    case 1:
                        field.set(newInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        break;
                    case 2:
                        field.set(newInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        break;
                    case 3:
                        field.set(newInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        break;
                    case 4:
                        field.set(newInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        break;
                    case 5:
                        field.set(newInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        break;
                    case 6:
                        field.set(newInstance, cursor.getString(columnIndex));
                        break;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        break;
                }
            }
        }
        return newInstance;
    }

    private static void a(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(hj.class);
        if (annotation == null) {
            return;
        }
        hj hjVar = (hj) annotation;
        try {
            switch (hjVar.b()) {
                case 1:
                    contentValues.put(hjVar.a(), Short.valueOf(field.getShort(obj)));
                    return;
                case 2:
                    contentValues.put(hjVar.a(), Integer.valueOf(field.getInt(obj)));
                    return;
                case 3:
                    contentValues.put(hjVar.a(), Float.valueOf(field.getFloat(obj)));
                    return;
                case 4:
                    contentValues.put(hjVar.a(), Double.valueOf(field.getDouble(obj)));
                    return;
                case 5:
                    contentValues.put(hjVar.a(), Long.valueOf(field.getLong(obj)));
                    return;
                case 6:
                    contentValues.put(hjVar.a(), (String) field.get(obj));
                    return;
                case 7:
                    contentValues.put(hjVar.a(), (byte[]) field.get(obj));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    private static ContentValues a(Object obj, hi hiVar) {
        ContentValues contentValues = new ContentValues();
        for (Field field : a(obj.getClass(), hiVar.b())) {
            field.setAccessible(true);
            a(obj, field, contentValues);
        }
        return contentValues;
    }

    private static Field[] a(Class<?> cls, boolean z10) {
        if (cls == null) {
            return null;
        }
        if (z10) {
            return cls.getSuperclass().getDeclaredFields();
        }
        return cls.getDeclaredFields();
    }

    private SQLiteDatabase a() {
        try {
            if (this.f6251b == null) {
                this.f6251b = this.f6250a.getReadableDatabase();
            }
        } catch (Throwable th) {
            gv.a(th, "dbs", "grd");
        }
        return this.f6251b;
    }

    private static <T> String a(hi hiVar) {
        if (hiVar == null) {
            return null;
        }
        return hiVar.a();
    }
}
