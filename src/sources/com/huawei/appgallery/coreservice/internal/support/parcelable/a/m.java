package com.huawei.appgallery.coreservice.internal.support.parcelable.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.b;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.c;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.d;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.f;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class m implements c<Parcelable[]> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static Parcelable.Creator c(Class cls) {
        try {
            return (Parcelable.Creator) cls.getDeclaredField("CREATOR").get(null);
        } catch (IllegalAccessException unused) {
            throw new a(((Object) cls) + " IllegalAccessException");
        } catch (IllegalArgumentException unused2) {
            throw new a(((Object) cls) + " IllegalArgumentException");
        } catch (NoSuchFieldException unused3) {
            throw new a(((Object) cls) + " is an Parcelable without CREATOR");
        }
    }

    public static Parcelable.Creator d(Field field, Map<String, String> map) {
        String str;
        Class<?> type = field.getType();
        if (type.isArray()) {
            type = type.getComponentType();
        }
        if (type == null || !Parcelable.class.isAssignableFrom(type)) {
            return null;
        }
        String name = field.getName();
        if (map != null && map.get(name) != null && (str = map.get(name)) != null) {
            try {
                type = Class.forName(str);
            } catch (ClassNotFoundException unused) {
                b.f27602a.c("ParcelableArrayTypeProcess", "error clazz:" + str);
                return null;
            }
        }
        return c(type);
    }

    public static <T extends Parcelable> void e(Parcel parcel, T t2, int i10) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t2.writeToParcel(parcel, i10);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) {
        field.set(autoParcelable, g(parcel, i10, field));
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void a(Parcel parcel, Field field, int i10, Parcelable[] parcelableArr, int i11, boolean z10) {
        if (parcelableArr == null) {
            if (z10) {
                f.b(parcel, i10, 0);
                return;
            }
            return;
        }
        int c4 = f.c(parcel, i10);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                e(parcel, parcelable, i11);
            }
        }
        f.a(parcel, c4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v6, types: [android.os.Parcelable[]] */
    public final <T extends Parcelable> T[] g(Parcel parcel, int i10, Field field) {
        int c4 = d.c(parcel, i10);
        int dataPosition = parcel.dataPosition();
        T[] tArr = null;
        if (c4 == 0) {
            return null;
        }
        try {
            Parcelable.Creator d10 = d(field, null);
            if (d10 != null) {
                tArr = (Parcelable[]) parcel.createTypedArray(d10);
            }
        } catch (Exception e2) {
            b.f27602a.d("ParcelableArrayTypeProcess", "error readParcelableArray:" + e2.getMessage());
        }
        parcel.setDataPosition(dataPosition + c4);
        return tArr;
    }
}
