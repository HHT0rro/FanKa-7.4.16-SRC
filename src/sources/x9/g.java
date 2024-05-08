package x9;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class g implements com.huawei.appgallery.coreservice.internal.support.parcelable.b.c<HashMap> {
    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) {
        field.set(autoParcelable, c(parcel, i10, autoParcelable.getClass().getClassLoader()));
    }

    public final HashMap c(Parcel parcel, int i10, ClassLoader classLoader) {
        int c4 = com.huawei.appgallery.coreservice.internal.support.parcelable.b.d.c(parcel, i10);
        int dataPosition = parcel.dataPosition();
        HashMap hashMap = null;
        if (c4 == 0) {
            return null;
        }
        try {
            hashMap = parcel.readHashMap(classLoader);
        } catch (Exception unused) {
            com.huawei.appgallery.coreservice.internal.support.parcelable.b.b.f27602a.d("HashMapTypeProcess", "can not read map");
        }
        parcel.setDataPosition(dataPosition + c4);
        return hashMap;
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(Parcel parcel, Field field, int i10, HashMap hashMap, int i11, boolean z10) {
        if (hashMap == null) {
            if (z10) {
                com.huawei.appgallery.coreservice.internal.support.parcelable.b.f.b(parcel, i10, 0);
            }
        } else {
            int c4 = com.huawei.appgallery.coreservice.internal.support.parcelable.b.f.c(parcel, i10);
            parcel.writeMap(hashMap);
            com.huawei.appgallery.coreservice.internal.support.parcelable.b.f.a(parcel, c4);
        }
    }
}
