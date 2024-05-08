package x9;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.EnableAutoParcel;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c implements com.huawei.appgallery.coreservice.internal.support.parcelable.b.c<Bundle> {
    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) {
        Class subClass = ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).subClass();
        if (subClass == null || !Parcelable.class.isAssignableFrom(subClass) || ((EnableAutoParcel) field.getAnnotation(EnableAutoParcel.class)).useClassLoader()) {
            subClass = field.getDeclaringClass();
        }
        field.set(autoParcelable, c(parcel, i10, com.huawei.appgallery.coreservice.internal.support.parcelable.b.e.b(subClass)));
    }

    public final Bundle c(Parcel parcel, int i10, ClassLoader classLoader) {
        int c4 = com.huawei.appgallery.coreservice.internal.support.parcelable.b.d.c(parcel, i10);
        int dataPosition = parcel.dataPosition();
        Bundle bundle = null;
        if (c4 == 0) {
            return null;
        }
        try {
            bundle = parcel.readBundle(classLoader);
        } catch (Exception e2) {
            com.huawei.appgallery.coreservice.internal.support.parcelable.b.b.f27602a.d("BundleTypeProcess", "error readBundle:" + e2.getMessage());
        }
        parcel.setDataPosition(dataPosition + c4);
        return bundle;
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(Parcel parcel, Field field, int i10, Bundle bundle, int i11, boolean z10) {
        if (bundle == null) {
            if (z10) {
                com.huawei.appgallery.coreservice.internal.support.parcelable.b.f.b(parcel, i10, 0);
            }
        } else {
            int c4 = com.huawei.appgallery.coreservice.internal.support.parcelable.b.f.c(parcel, i10);
            parcel.writeBundle(bundle);
            com.huawei.appgallery.coreservice.internal.support.parcelable.b.f.a(parcel, c4);
        }
    }
}
