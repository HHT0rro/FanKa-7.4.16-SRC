package com.huawei.appgallery.coreservice.internal.support.parcelable.b;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface c<T> {
    void a(Parcel parcel, Field field, int i10, T t2, int i11, boolean z10);

    void b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map);
}
