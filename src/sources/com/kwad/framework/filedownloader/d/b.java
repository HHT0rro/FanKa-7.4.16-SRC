package com.kwad.framework.filedownloader.d;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.utils.ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.kwad.framework.filedownloader.d.b.1
        private static b b(Parcel parcel) {
            return new b(parcel);
        }

        private static b[] bC(int i10) {
            return new b[i10];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b[] newArray(int i10) {
            return bC(i10);
        }
    };
    private HashMap<String, List<String>> ahD;

    public b() {
    }

    public final void bm(String str) {
        HashMap<String, List<String>> hashMap = this.ahD;
        if (hashMap == null) {
            return;
        }
        hashMap.remove(str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return this.ahD.toString();
    }

    public final HashMap<String, List<String>> wk() {
        return this.ahD;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeMap(this.ahD);
    }

    public final void x(String str, String str2) {
        ap.gH(str);
        ap.gH(str2);
        if (this.ahD == null) {
            this.ahD = new HashMap<>();
        }
        List<String> list = this.ahD.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.ahD.put(str, list);
        }
        if (list.contains(str2)) {
            return;
        }
        list.add(str2);
    }

    public b(Parcel parcel) {
        this.ahD = parcel.readHashMap(String.class.getClassLoader());
    }
}
