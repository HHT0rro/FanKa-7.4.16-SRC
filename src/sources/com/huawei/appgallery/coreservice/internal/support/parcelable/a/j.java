package com.huawei.appgallery.coreservice.internal.support.parcelable.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.appgallery.coreservice.internal.support.parcelable.AutoParcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.b;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.c;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.f;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class j implements c<IInterface> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    public void b(AutoParcelable autoParcelable, Field field, Parcel parcel, int i10, Map<String, String> map) {
        b bVar;
        StringBuilder sb2;
        String message;
        Class<?>[] declaredClasses = field.getType().getDeclaredClasses();
        int length = declaredClasses.length;
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            try {
                field.set(autoParcelable, declaredClasses[i11].getDeclaredMethod("asInterface", IBinder.class).invoke(null, x9.a.c(parcel, i10)));
                z10 = true;
                break;
            } catch (NoSuchMethodException e2) {
                bVar = b.f27602a;
                sb2 = new StringBuilder();
                sb2.append("can not set the interface");
                message = e2.getMessage();
            } catch (Exception e10) {
                bVar = b.f27602a;
                sb2 = new StringBuilder();
                sb2.append("can not set the interface");
                message = e10.getMessage();
            }
            sb2.append(message);
            bVar.d("InterfaceTypeProcess", sb2.toString());
            i11++;
        }
        if (z10) {
            return;
        }
        throw new a("Field has broken interface: " + ((Object) field));
    }

    @Override // com.huawei.appgallery.coreservice.internal.support.parcelable.b.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(Parcel parcel, Field field, int i10, IInterface iInterface, int i11, boolean z10) {
        if (iInterface == null) {
            if (z10) {
                f.b(parcel, i10, 0);
            }
        } else {
            int c4 = f.c(parcel, i10);
            parcel.writeStrongBinder(iInterface.asBinder());
            f.a(parcel, c4);
        }
    }
}
