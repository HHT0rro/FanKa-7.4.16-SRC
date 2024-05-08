package b6;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b6.a;
import com.alibaba.security.biometrics.service.build.ah;
import com.android.internal.os.PowerProfile;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.j0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.huawei.appgallery.agd.common.utils.StringUtils;

/* compiled from: RtspMediaTrack.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final h f1352a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f1353b;

    public p(a aVar, Uri uri) {
        com.google.android.exoplayer2.util.a.a(aVar.f1279i.containsKey("control"));
        this.f1352a = b(aVar);
        this.f1353b = a(uri, (String) j0.j(aVar.f1279i.get("control")));
    }

    public static Uri a(Uri uri, String str) {
        Uri parse = Uri.parse(str);
        return parse.isAbsolute() ? parse : str.equals(StringUtils.NO_PRINT_CODE) ? uri : uri.buildUpon().appendEncodedPath(str).build();
    }

    @VisibleForTesting
    public static h b(a aVar) {
        int i10;
        char c4;
        Format.b bVar = new Format.b();
        int i11 = aVar.f1275e;
        if (i11 > 0) {
            bVar.G(i11);
        }
        a.c cVar = aVar.f1280j;
        int i12 = cVar.f1290a;
        String a10 = h.a(cVar.f1291b);
        bVar.e0(a10);
        int i13 = aVar.f1280j.f1292c;
        if (PowerProfile.POWER_AUDIO.equals(aVar.f1271a)) {
            i10 = d(aVar.f1280j.f1293d, a10);
            bVar.f0(i13).H(i10);
        } else {
            i10 = -1;
        }
        ImmutableMap<String, String> a11 = aVar.a();
        int hashCode = a10.hashCode();
        if (hashCode == -53558318) {
            if (a10.equals("audio/mp4a-latm")) {
                c4 = 0;
            }
            c4 = 65535;
        } else if (hashCode != 187078296) {
            if (hashCode == 1331836730 && a10.equals(ah.f2598d)) {
                c4 = 1;
            }
            c4 = 65535;
        } else {
            if (a10.equals("audio/ac3")) {
                c4 = 2;
            }
            c4 = 65535;
        }
        if (c4 == 0) {
            com.google.android.exoplayer2.util.a.a(i10 != -1);
            com.google.android.exoplayer2.util.a.a(!a11.isEmpty());
            e(bVar, a11, i10, i13);
        } else if (c4 == 1) {
            com.google.android.exoplayer2.util.a.a(!a11.isEmpty());
            f(bVar, a11);
        }
        com.google.android.exoplayer2.util.a.a(i13 > 0);
        com.google.android.exoplayer2.util.a.a(i12 >= 96);
        return new h(bVar.E(), i12, i13, a11);
    }

    public static byte[] c(String str) {
        byte[] decode = Base64.decode(str, 0);
        int length = decode.length;
        byte[] bArr = NalUnitUtil.f22925a;
        byte[] bArr2 = new byte[length + bArr.length];
        System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, bArr.length);
        System.arraycopy((Object) decode, 0, (Object) bArr2, bArr.length, decode.length);
        return bArr2;
    }

    public static int d(int i10, String str) {
        return i10 != -1 ? i10 : str.equals("audio/ac3") ? 6 : 1;
    }

    public static void e(Format.b bVar, ImmutableMap<String, String> immutableMap, int i10, int i11) {
        com.google.android.exoplayer2.util.a.a(immutableMap.containsKey("profile-level-id"));
        String valueOf = String.valueOf((String) com.google.android.exoplayer2.util.a.e(immutableMap.get("profile-level-id")));
        bVar.I(valueOf.length() != 0 ? "mp4a.40.".concat(valueOf) : new String("mp4a.40."));
        bVar.T(ImmutableList.of(x4.a.a(i11, i10)));
    }

    public static void f(Format.b bVar, ImmutableMap<String, String> immutableMap) {
        com.google.android.exoplayer2.util.a.a(immutableMap.containsKey("sprop-parameter-sets"));
        String[] M0 = j0.M0((String) com.google.android.exoplayer2.util.a.e(immutableMap.get("sprop-parameter-sets")), ",");
        com.google.android.exoplayer2.util.a.a(M0.length == 2);
        ImmutableList of = ImmutableList.of(c(M0[0]), c(M0[1]));
        bVar.T(of);
        byte[] bArr = of.get(0);
        NalUnitUtil.SpsData i10 = NalUnitUtil.i(bArr, NalUnitUtil.f22925a.length, bArr.length);
        bVar.a0(i10.pixelWidthAspectRatio);
        bVar.Q(i10.height);
        bVar.j0(i10.width);
        String str = immutableMap.get("profile-level-id");
        if (str != null) {
            bVar.I(str.length() != 0 ? "avc1.".concat(str) : new String("avc1."));
        } else {
            bVar.I(com.google.android.exoplayer2.util.c.a(i10.profileIdc, i10.constraintsFlagsAndReservedZero2Bits, i10.levelIdc));
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        return this.f1352a.equals(pVar.f1352a) && this.f1353b.equals(pVar.f1353b);
    }

    public int hashCode() {
        return ((217 + this.f1352a.hashCode()) * 31) + this.f1353b.hashCode();
    }
}
