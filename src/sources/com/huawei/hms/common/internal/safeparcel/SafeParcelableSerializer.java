package com.huawei.hms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class SafeParcelableSerializer {
    public static <S extends SafeParcelable> S deserializeFromBytes(byte[] bArr, Parcelable.Creator<S> creator) {
        Preconditions.checkNotNull(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        S createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    public static <S extends SafeParcelable> S deserializeFromIntentExtra(Intent intent, String str, Parcelable.Creator<S> creator) {
        byte[] byteArrayExtra;
        if (intent == null || (byteArrayExtra = intent.getByteArrayExtra(str)) == null) {
            return null;
        }
        return (S) deserializeFromBytes(byteArrayExtra, creator);
    }

    public static <S extends SafeParcelable> S deserializeFromString(String str, Parcelable.Creator<S> creator) {
        return (S) deserializeFromBytes(Base64Utils.decodeUrlSafe(str), creator);
    }

    public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromBundle(Bundle bundle, String str, Parcelable.Creator<S> creator) {
        ArrayList arrayList;
        if (bundle == null || (arrayList = (ArrayList) bundle.getSerializable(str)) == null) {
            return null;
        }
        ViewGroup.ChildListForAutoFillOrContentCapture childListForAutoFillOrContentCapture = (ArrayList<S>) new ArrayList(arrayList.size());
        Iterator iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            childListForAutoFillOrContentCapture.add(deserializeFromBytes((byte[]) iterator2.next(), creator));
        }
        return childListForAutoFillOrContentCapture;
    }

    public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromIntentExtra(Intent intent, String str, Parcelable.Creator<S> creator) {
        ArrayList arrayList;
        if (intent == null || (arrayList = (ArrayList) intent.getSerializableExtra(str)) == null) {
            return null;
        }
        ViewGroup.ChildListForAutoFillOrContentCapture childListForAutoFillOrContentCapture = (ArrayList<S>) new ArrayList(arrayList.size());
        Iterator iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            childListForAutoFillOrContentCapture.add(deserializeFromBytes((byte[]) iterator2.next(), creator));
        }
        return childListForAutoFillOrContentCapture;
    }

    public static <S extends SafeParcelable> void serializeIterableToBundle(Iterable<S> iterable, Bundle bundle, String str) {
        if (iterable == null || bundle == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<S> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(serializeToBytes(iterator2.next()));
        }
        bundle.putSerializable(str, arrayList);
    }

    public static <S extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<S> iterable, Intent intent, String str) {
        if (iterable == null || intent == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<S> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(serializeToBytes(iterator2.next()));
        }
        intent.putExtra(str, arrayList);
    }

    public static <S extends SafeParcelable> byte[] serializeToBytes(S s2) {
        Parcel obtain = Parcel.obtain();
        if (s2 != null) {
            s2.writeToParcel(obtain, 0);
        }
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static <S extends SafeParcelable> void serializeToIntentExtra(S s2, Intent intent, String str) {
        if (s2 == null || intent == null) {
            return;
        }
        intent.putExtra(str, serializeToBytes(s2));
    }

    public static <S extends SafeParcelable> String serializeToString(S s2) {
        return Base64Utils.encodeUrlSafe(serializeToBytes(s2));
    }
}
