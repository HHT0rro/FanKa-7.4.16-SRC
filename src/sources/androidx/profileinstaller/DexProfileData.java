package androidx.profileinstaller;

import androidx.annotation.NonNull;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DexProfileData {

    @NonNull
    public final String apkName;
    public int classSetSize;

    @NonNull
    public int[] classes;
    public final long dexChecksum;

    @NonNull
    public final String dexName;
    public final int hotMethodRegionSize;
    public long mTypeIdCount;

    @NonNull
    public final TreeMap<Integer, Integer> methods;
    public final int numMethodIds;

    public DexProfileData(@NonNull String str, @NonNull String str2, long j10, long j11, int i10, int i11, int i12, @NonNull int[] iArr, @NonNull TreeMap<Integer, Integer> treeMap) {
        this.apkName = str;
        this.dexName = str2;
        this.dexChecksum = j10;
        this.mTypeIdCount = j11;
        this.classSetSize = i10;
        this.hotMethodRegionSize = i11;
        this.numMethodIds = i12;
        this.classes = iArr;
        this.methods = treeMap;
    }
}
