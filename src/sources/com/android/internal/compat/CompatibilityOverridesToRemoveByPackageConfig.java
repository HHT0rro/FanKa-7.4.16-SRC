package com.android.internal.compat;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class CompatibilityOverridesToRemoveByPackageConfig implements Parcelable {
    public static final Parcelable.Creator<CompatibilityOverridesToRemoveByPackageConfig> CREATOR = new Parcelable.Creator<CompatibilityOverridesToRemoveByPackageConfig>() { // from class: com.android.internal.compat.CompatibilityOverridesToRemoveByPackageConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CompatibilityOverridesToRemoveByPackageConfig createFromParcel(Parcel in) {
            return new CompatibilityOverridesToRemoveByPackageConfig(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CompatibilityOverridesToRemoveByPackageConfig[] newArray(int size) {
            return new CompatibilityOverridesToRemoveByPackageConfig[size];
        }
    };
    public final Map<String, CompatibilityOverridesToRemoveConfig> packageNameToOverridesToRemove;

    public CompatibilityOverridesToRemoveByPackageConfig(Map<String, CompatibilityOverridesToRemoveConfig> packageNameToOverridesToRemove) {
        this.packageNameToOverridesToRemove = packageNameToOverridesToRemove;
    }

    private CompatibilityOverridesToRemoveByPackageConfig(Parcel in) {
        int keyCount = in.readInt();
        this.packageNameToOverridesToRemove = new HashMap();
        for (int i10 = 0; i10 < keyCount; i10++) {
            String key = in.readString();
            this.packageNameToOverridesToRemove.put(key, CompatibilityOverridesToRemoveConfig.CREATOR.createFromParcel(in));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.packageNameToOverridesToRemove.size());
        for (String key : this.packageNameToOverridesToRemove.h()) {
            dest.writeString(key);
            this.packageNameToOverridesToRemove.get(key).writeToParcel(dest, 0);
        }
    }
}
