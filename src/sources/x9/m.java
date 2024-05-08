package x9;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class m implements com.huawei.appgallery.coreservice.internal.support.parcelable.b.c<List<String>> {
    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) {
        field.set(autoParcelable, c(parcel, i10));
    }

    public final ArrayList<String> c(Parcel parcel, int i10) {
        int c4 = com.huawei.appgallery.coreservice.internal.support.parcelable.b.d.c(parcel, i10);
        int dataPosition = parcel.dataPosition();
        ArrayList<String> arrayList = null;
        if (c4 == 0) {
            return null;
        }
        try {
            arrayList = parcel.createStringArrayList();
        } catch (Exception e2) {
            com.huawei.appgallery.coreservice.internal.support.parcelable.b.b.f27602a.d("StringListProcess", "error readStringList:" + e2.getMessage());
        }
        parcel.setDataPosition(dataPosition + c4);
        return arrayList;
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(Parcel parcel, Field field, int i10, List<String> list, int i11, boolean z10) {
        if (list == null) {
            if (z10) {
                com.huawei.appgallery.coreservice.internal.support.parcelable.b.f.b(parcel, i10, 0);
            }
        } else {
            int c4 = com.huawei.appgallery.coreservice.internal.support.parcelable.b.f.c(parcel, i10);
            parcel.writeStringList(list);
            com.huawei.appgallery.coreservice.internal.support.parcelable.b.f.a(parcel, c4);
        }
    }
}
