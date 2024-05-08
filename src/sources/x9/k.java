package x9;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class k implements com.huawei.appgallery.coreservice.internal.support.parcelable.b.c<Parcelable> {
    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) {
        field.set(autoParcelable, c(parcel, i10, field, map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.os.Parcelable] */
    public final <T extends Parcelable> T c(Parcel parcel, int i10, Field field, Map<String, String> map) {
        int c4 = com.huawei.appgallery.coreservice.internal.support.parcelable.b.d.c(parcel, i10);
        int dataPosition = parcel.dataPosition();
        T t2 = null;
        if (c4 == 0) {
            return null;
        }
        try {
            Parcelable.Creator d10 = com.huawei.appgallery.coreservice.internal.support.parcelable.a.m.d(field, map);
            if (d10 != null) {
                t2 = (Parcelable) d10.createFromParcel(parcel);
            }
        } catch (Exception e2) {
            com.huawei.appgallery.coreservice.internal.support.parcelable.b.b.f27602a.c("ParcelableTypeProcess", "readParcelable failed: " + e2.getMessage());
        }
        parcel.setDataPosition(dataPosition + c4);
        return t2;
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(Parcel parcel, Field field, int i10, Parcelable parcelable, int i11, boolean z10) {
        if (parcelable == null) {
            if (z10) {
                com.huawei.appgallery.coreservice.internal.support.parcelable.b.f.b(parcel, i10, 0);
            }
        } else {
            int c4 = com.huawei.appgallery.coreservice.internal.support.parcelable.b.f.c(parcel, i10);
            parcelable.writeToParcel(parcel, i11);
            com.huawei.appgallery.coreservice.internal.support.parcelable.b.f.a(parcel, c4);
        }
    }
}
