package androidx.profileinstaller;

import androidx.annotation.RestrictTo;
import com.huawei.openalliance.ad.constant.u;
import java.util.Arrays;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ProfileVersion {
    public static final int MAX_SUPPORTED_SDK = 33;
    public static final int MIN_SUPPORTED_SDK = 24;
    public static final byte[] V015_S = {48, 49, 53, 0};
    public static final byte[] V010_P = {48, 49, 48, 0};
    public static final byte[] V009_O_MR1 = {48, 48, 57, 0};
    public static final byte[] V005_O = {48, 48, 53, 0};
    public static final byte[] V001_N = {48, 48, 49, 0};
    public static final byte[] METADATA_V001_N = {48, 48, 49, 0};
    public static final byte[] METADATA_V002 = {48, 48, 50, 0};

    private ProfileVersion() {
    }

    public static String dexKeySeparator(byte[] bArr) {
        return (Arrays.equals(bArr, V001_N) || Arrays.equals(bArr, V005_O)) ? u.bD : "!";
    }
}
