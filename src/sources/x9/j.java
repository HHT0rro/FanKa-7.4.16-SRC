package x9;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class j implements com.huawei.appgallery.coreservice.internal.support.parcelable.b.c<Long> {
    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) {
        field.set(autoParcelable, Long.valueOf(c(parcel, i10)));
    }

    public final long c(Parcel parcel, int i10) {
        com.huawei.appgallery.coreservice.internal.support.parcelable.b.d.d(parcel, i10, 8);
        return parcel.readLong();
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(Parcel parcel, Field field, int i10, Long l10, int i11, boolean z10) {
        if (l10 == null) {
            return;
        }
        com.huawei.appgallery.coreservice.internal.support.parcelable.b.f.b(parcel, i10, 8);
        parcel.writeLong(l10.longValue());
    }
}