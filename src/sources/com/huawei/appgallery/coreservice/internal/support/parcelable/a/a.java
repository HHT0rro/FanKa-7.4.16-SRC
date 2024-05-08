package com.huawei.appgallery.coreservice.internal.support.parcelable.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.a.m;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.b;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.c;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.d;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.e;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.f;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a implements c<List> {
    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) {
        Class subClass = ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).subClass();
        field.set(autoParcelable, (subClass == null || !Parcelable.class.isAssignableFrom(subClass) || ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).useClassLoader()) ? d(parcel, i10, e.b(subClass)) : c(parcel, i10, subClass));
    }

    public final <T extends Parcelable> ArrayList<T> c(Parcel parcel, int i10, Class cls) {
        b bVar;
        StringBuilder sb2;
        String message;
        int c4 = d.c(parcel, i10);
        int dataPosition = parcel.dataPosition();
        ArrayList<T> arrayList = null;
        if (c4 == 0) {
            return null;
        }
        try {
            Parcelable.Creator c10 = m.c(cls);
            if (c10 != null) {
                arrayList = parcel.createTypedArrayList(c10);
            }
        } catch (m.a e2) {
            bVar = b.f27602a;
            sb2 = new StringBuilder();
            sb2.append("error getCreator:");
            message = e2.getMessage();
            sb2.append(message);
            bVar.d("ListTypeProcess", sb2.toString());
            parcel.setDataPosition(dataPosition + c4);
            return arrayList;
        } catch (Exception e10) {
            bVar = b.f27602a;
            sb2 = new StringBuilder();
            sb2.append("error readParcelableList:");
            message = e10.getMessage();
            sb2.append(message);
            bVar.d("ListTypeProcess", sb2.toString());
            parcel.setDataPosition(dataPosition + c4);
            return arrayList;
        }
        parcel.setDataPosition(dataPosition + c4);
        return arrayList;
    }

    public final ArrayList d(Parcel parcel, int i10, ClassLoader classLoader) {
        int c4 = d.c(parcel, i10);
        int dataPosition = parcel.dataPosition();
        ArrayList arrayList = null;
        if (c4 == 0) {
            return null;
        }
        try {
            arrayList = parcel.readArrayList(classLoader);
        } catch (Exception e2) {
            b.f27602a.d("ListTypeProcess", "error readList:" + e2.getMessage());
        }
        parcel.setDataPosition(dataPosition + c4);
        return arrayList;
    }

    public final <T extends Parcelable> void e(Parcel parcel, int i10, List<T> list, int i11, boolean z10) {
        if (list == null) {
            if (z10) {
                f.b(parcel, i10, 0);
                return;
            }
            return;
        }
        int c4 = f.c(parcel, i10);
        parcel.writeInt(list.size());
        for (T t2 : list) {
            if (t2 == null) {
                parcel.writeInt(0);
            } else {
                m.e(parcel, t2, i11);
            }
        }
        f.a(parcel, c4);
    }

    public final void f(Parcel parcel, int i10, List list, boolean z10) {
        if (list == null) {
            if (z10) {
                f.b(parcel, i10, 0);
            }
        } else {
            int c4 = f.c(parcel, i10);
            parcel.writeList(list);
            f.a(parcel, c4);
        }
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void a(Parcel parcel, Field field, int i10, List list, int i11, boolean z10) {
        Class subClass = ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).subClass();
        if (subClass == null || !Parcelable.class.isAssignableFrom(subClass) || ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).useClassLoader()) {
            f(parcel, i10, list, z10);
        } else {
            e(parcel, i10, list, i11, z10);
        }
    }
}
