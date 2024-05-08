package x9;

import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d implements com.huawei.appgallery.coreservice.internal.support.parcelable.b.c<byte[]> {
    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) {
        field.set(autoParcelable, d(parcel, i10));
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(Parcel parcel, Field field, int i10, byte[] bArr, int i11, boolean z10) {
        if (bArr == null) {
            if (z10) {
                com.huawei.appgallery.coreservice.internal.support.parcelable.b.f.b(parcel, i10, 0);
            }
        } else {
            int c4 = com.huawei.appgallery.coreservice.internal.support.parcelable.b.f.c(parcel, i10);
            parcel.writeByteArray(bArr);
            com.huawei.appgallery.coreservice.internal.support.parcelable.b.f.a(parcel, c4);
        }
    }

    public final byte[] d(Parcel parcel, int i10) {
        int c4 = com.huawei.appgallery.coreservice.internal.support.parcelable.b.d.c(parcel, i10);
        int dataPosition = parcel.dataPosition();
        byte[] bArr = new byte[0];
        if (c4 == 0) {
            return bArr;
        }
        try {
            bArr = parcel.createByteArray();
        } catch (Exception e2) {
            com.huawei.appgallery.coreservice.internal.support.parcelable.b.b.f27602a.d("ByteArrayTypeProcess", "error readByteArray:" + e2.getMessage());
        }
        parcel.setDataPosition(dataPosition + c4);
        return bArr;
    }
}
