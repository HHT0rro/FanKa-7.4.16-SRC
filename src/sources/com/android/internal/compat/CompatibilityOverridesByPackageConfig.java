package com.android.internal.compat;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class CompatibilityOverridesByPackageConfig implements Parcelable {
    public static final Parcelable.Creator<CompatibilityOverridesByPackageConfig> CREATOR = new Parcelable.Creator<CompatibilityOverridesByPackageConfig>() { // from class: com.android.internal.compat.CompatibilityOverridesByPackageConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CompatibilityOverridesByPackageConfig createFromParcel(Parcel in) {
            return new CompatibilityOverridesByPackageConfig(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CompatibilityOverridesByPackageConfig[] newArray(int size) {
            return new CompatibilityOverridesByPackageConfig[size];
        }
    };
    public final Map<String, CompatibilityOverrideConfig> packageNameToOverrides;

    public CompatibilityOverridesByPackageConfig(Map<String, CompatibilityOverrideConfig> packageNameToOverrides) {
        this.packageNameToOverrides = packageNameToOverrides;
    }

    private CompatibilityOverridesByPackageConfig(Parcel in) {
        int keyCount = in.readInt();
        this.packageNameToOverrides = new HashMap();
        for (int i10 = 0; i10 < keyCount; i10++) {
            String key = in.readString();
            this.packageNameToOverrides.put(key, CompatibilityOverrideConfig.CREATOR.createFromParcel(in));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.packageNameToOverrides.size());
        for (String key : this.packageNameToOverrides.h()) {
            dest.writeString(key);
            this.packageNameToOverrides.get(key).writeToParcel(dest, 0);
        }
    }
}
