package com.android.internal.location.altitude;

import android.view.View;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Arrays;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class S2CellIdUtils {
    private static final int INVERT_MASK = 2;
    private static final int I_SHIFT = 33;
    private static final long J_MASK = 2147483647L;
    private static final int J_SHIFT = 2;
    private static final int LEAF_MASK = 1;
    private static final int LOOKUP_BITS = 4;
    private static final int LOOKUP_MASK = 15;
    public static final int MAX_LEVEL = 30;
    private static final int MAX_SIZE = 1073741824;
    private static final int NUM_FACES = 6;
    private static final double ONE_OVER_MAX_SIZE = 9.313225746154785E-10d;
    private static final int POS_BITS = 61;
    private static final int SWAP_MASK = 1;
    private static final int[] LOOKUP_POS = new int[1024];
    private static final int[] LOOKUP_IJ = new int[1024];
    private static final int[] POS_TO_ORIENTATION = {1, 0, 0, 3};
    private static final int[][] POS_TO_IJ = {new int[]{0, 1, 3, 2}, new int[]{0, 2, 3, 1}, new int[]{3, 2, 0, 1}, new int[]{3, 1, 0, 2}};
    private static final double UV_LIMIT = calculateUvLimit();
    private static final UvTransform[] UV_TRANSFORMS = createUvTransforms();
    private static final XyzTransform[] XYZ_TRANSFORMS = createXyzTransforms();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface UvTransform {
        double xyzToU(double d10, double d11, double d12);

        double xyzToV(double d10, double d11, double d12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface XyzTransform {
        double uvToX(double d10, double d11);

        double uvToY(double d10, double d11);

        double uvToZ(double d10, double d11);
    }

    static {
        initLookupCells();
    }

    private S2CellIdUtils() {
    }

    public static long fromLatLngDegrees(double latDegrees, double lngDegrees) {
        return fromLatLngRadians(Math.toRadians(latDegrees), Math.toRadians(lngDegrees));
    }

    public static long getParent(long s2CellId, int level) {
        long newLsb = getLowestOnBitForLevel(level);
        return ((-newLsb) & s2CellId) | newLsb;
    }

    public static void getEdgeNeighbors(long s2CellId, long[] neighbors) {
        int level = getLevel(s2CellId);
        int size = levelToSizeIj(level);
        int face = getFace(s2CellId);
        long ijo = toIjo(s2CellId);
        int i10 = ijoToI(ijo);
        int j10 = ijoToJ(ijo);
        int iPlusSize = i10 + size;
        int iMinusSize = i10 - size;
        int jPlusSize = j10 + size;
        int jMinusSize = j10 - size;
        boolean iPlusSizeLtMax = iPlusSize < 1073741824;
        boolean iMinusSizeGteZero = iMinusSize >= 0;
        boolean jPlusSizeLtMax = jPlusSize < 1073741824;
        boolean jMinusSizeGteZero = jMinusSize >= 0;
        int index = 0 + 1;
        neighbors[0] = getParent(fromFijSame(face, i10, jMinusSize, jMinusSizeGteZero), level);
        int index2 = index + 1;
        neighbors[index] = getParent(fromFijSame(face, iPlusSize, j10, iPlusSizeLtMax), level);
        int index3 = index2 + 1;
        neighbors[index2] = getParent(fromFijSame(face, i10, jPlusSize, jPlusSizeLtMax), level);
        neighbors[index3] = getParent(fromFijSame(face, iMinusSize, j10, iMinusSizeGteZero), level);
        Arrays.fill(neighbors, index3 + 1, neighbors.length, 0L);
    }

    public static int getI(long s2CellId) {
        return ijoToI(toIjo(s2CellId));
    }

    public static int getJ(long s2CellId) {
        return ijoToJ(toIjo(s2CellId));
    }

    private static long fromLatLngRadians(double latRadians, double lngRadians) {
        double cosLat = Math.cos(latRadians);
        double x10 = Math.cos(lngRadians) * cosLat;
        double y10 = Math.sin(lngRadians) * cosLat;
        double z10 = Math.sin(latRadians);
        return fromXyz(x10, y10, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getLevel(long s2CellId) {
        if (isLeaf(s2CellId)) {
            return 30;
        }
        return 30 - (Long.numberOfTrailingZeros(s2CellId) >> 1);
    }

    static long getLowestOnBit(long s2CellId) {
        return (-s2CellId) & s2CellId;
    }

    static long getLowestOnBitForLevel(int level) {
        return 1 << ((30 - level) * 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getTraversalStart(long s2CellId, int level) {
        return (s2CellId - getLowestOnBit(s2CellId)) + getLowestOnBitForLevel(level);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getTraversalNext(long s2CellId) {
        return (getLowestOnBit(s2CellId) << 1) + s2CellId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getToken(long s2CellId) {
        if (s2CellId == 0) {
            return "X";
        }
        String hex = Long.toHexString(s2CellId).toLowerCase(Locale.US);
        String padded = padStart(hex);
        return padded.replaceAll("0*$", "");
    }

    private static String padStart(String string) {
        if (string.length() >= 16) {
            return string;
        }
        return "0".repeat(16 - string.length()) + string;
    }

    private static long fromXyz(double x10, double y10, double z10) {
        int face = xyzToFace(x10, y10, z10);
        UvTransform uvTransform = UV_TRANSFORMS[face];
        double u10 = uvTransform.xyzToU(x10, y10, z10);
        double v2 = uvTransform.xyzToV(x10, y10, z10);
        return fromFuv(face, u10, v2);
    }

    private static long fromFuv(int face, double u10, double v2) {
        int i10 = uToI(u10);
        int j10 = vToJ(v2);
        return fromFij(face, i10, j10);
    }

    private static long fromFij(int face, int i10, int j10) {
        int bits = face & 1;
        long msb = face << 28;
        for (int k10 = 7; k10 >= 4; k10--) {
            int bits2 = lookupBits(i10, j10, k10, bits);
            msb = updateBits(msb, k10, bits2);
            bits = maskBits(bits2);
        }
        long lsb = 0;
        for (int k11 = 3; k11 >= 0; k11--) {
            int bits3 = lookupBits(i10, j10, k11, bits);
            lsb = updateBits(lsb, k11, bits3);
            bits = maskBits(bits3);
        }
        return (((msb << 32) + lsb) << 1) + 1;
    }

    private static long fromFijWrap(int face, int i10, int j10) {
        double u10 = iToU(i10);
        double v2 = jToV(j10);
        XyzTransform xyzTransform = XYZ_TRANSFORMS[face];
        double x10 = xyzTransform.uvToX(u10, v2);
        double y10 = xyzTransform.uvToY(u10, v2);
        double z10 = xyzTransform.uvToZ(u10, v2);
        int newFace = xyzToFace(x10, y10, z10);
        UvTransform uvTransform = UV_TRANSFORMS[newFace];
        double newU = uvTransform.xyzToU(x10, y10, z10);
        double newV = uvTransform.xyzToV(x10, y10, z10);
        int newI = uShiftIntoI(newU);
        int newJ = vShiftIntoJ(newV);
        return fromFij(newFace, newI, newJ);
    }

    private static long fromFijSame(int face, int i10, int j10, boolean isSameFace) {
        if (isSameFace) {
            return fromFij(face, i10, j10);
        }
        return fromFijWrap(face, i10, j10);
    }

    private static int xyzToFace(double x10, double y10, double z10) {
        double absX = Math.abs(x10);
        double absY = Math.abs(y10);
        double absZ = Math.abs(z10);
        return absX > absY ? absX > absZ ? x10 < ShadowDrawableWrapper.COS_45 ? 3 : 0 : z10 < ShadowDrawableWrapper.COS_45 ? 5 : 2 : absY > absZ ? y10 < ShadowDrawableWrapper.COS_45 ? 4 : 1 : z10 < ShadowDrawableWrapper.COS_45 ? 5 : 2;
    }

    private static int uToI(double u10) {
        double s2;
        if (u10 >= ShadowDrawableWrapper.COS_45) {
            s2 = Math.sqrt((3.0d * u10) + 1.0d) * 0.5d;
        } else {
            s2 = 1.0d - (Math.sqrt(1.0d - (3.0d * u10)) * 0.5d);
        }
        return Math.max(0, Math.min(View.LAST_APP_AUTOFILL_ID, (int) Math.round((1.073741824E9d * s2) - 0.5d)));
    }

    private static int vToJ(double v2) {
        return uToI(v2);
    }

    private static int lookupBits(int i10, int j10, int k10, int bits) {
        return LOOKUP_POS[bits + (((i10 >> (k10 * 4)) & 15) << 6) + (((j10 >> (k10 * 4)) & 15) << 2)];
    }

    private static long updateBits(long sb2, int k10, int bits) {
        return ((bits >> 2) << (((k10 & 3) * 2) * 4)) | sb2;
    }

    private static int maskBits(int bits) {
        return bits & 3;
    }

    private static int getFace(long s2CellId) {
        return (int) (s2CellId >>> 61);
    }

    private static boolean isLeaf(long s2CellId) {
        return (((int) s2CellId) & 1) != 0;
    }

    private static double iToU(int i10) {
        int satI = Math.max(-1, Math.min(1073741824, i10));
        double d10 = UV_LIMIT;
        return Math.max(-d10, Math.min(d10, (((satI << 1) + 1) - 1073741824) * ONE_OVER_MAX_SIZE));
    }

    private static double jToV(int j10) {
        return iToU(j10);
    }

    private static long toIjo(long s2CellId) {
        int face = getFace(s2CellId);
        int bits = face & 1;
        int i10 = 0;
        int j10 = 0;
        int k10 = 7;
        while (k10 >= 0) {
            int nbits = k10 == 7 ? 2 : 4;
            int bits2 = LOOKUP_IJ[bits + ((((int) (s2CellId >>> (((k10 * 2) * 4) + 1))) & ((1 << (nbits * 2)) - 1)) << 2)];
            i10 += (bits2 >> 6) << (k10 * 4);
            j10 += ((bits2 >> 2) & 15) << (k10 * 4);
            bits = bits2 & 3;
            k10--;
        }
        int orientation = (getLowestOnBit(s2CellId) & 1229782938247303440L) != 0 ? bits ^ 1 : bits;
        return (i10 << 33) | (j10 << 2) | orientation;
    }

    private static int ijoToI(long ijo) {
        return (int) (ijo >>> 33);
    }

    private static int ijoToJ(long ijo) {
        return (int) ((ijo >>> 2) & 2147483647L);
    }

    private static int uShiftIntoI(double u10) {
        double s2 = (1.0d + u10) * 0.5d;
        return Math.max(0, Math.min(View.LAST_APP_AUTOFILL_ID, (int) Math.round((1.073741824E9d * s2) - 0.5d)));
    }

    private static int vShiftIntoJ(double v2) {
        return uShiftIntoI(v2);
    }

    private static int levelToSizeIj(int level) {
        return 1 << (30 - level);
    }

    private static void initLookupCells() {
        initLookupCell(0, 0, 0, 0, 0, 0);
        initLookupCell(0, 0, 0, 1, 0, 1);
        initLookupCell(0, 0, 0, 2, 0, 2);
        initLookupCell(0, 0, 0, 3, 0, 3);
    }

    private static void initLookupCell(int level, int i10, int j10, int origOrientation, int pos, int orientation) {
        if (level == 4) {
            int ij = (i10 << 4) + j10;
            LOOKUP_POS[(ij << 2) + origOrientation] = (pos << 2) + orientation;
            LOOKUP_IJ[(pos << 2) + origOrientation] = (ij << 2) + orientation;
            return;
        }
        int level2 = level + 1;
        int i11 = i10 << 1;
        int j11 = j10 << 1;
        int pos2 = pos << 2;
        for (int subPos = 0; subPos < 4; subPos++) {
            int ij2 = POS_TO_IJ[orientation][subPos];
            int orientationMask = POS_TO_ORIENTATION[subPos];
            initLookupCell(level2, i11 + (ij2 >>> 1), j11 + (ij2 & 1), origOrientation, pos2 + subPos, orientation ^ orientationMask);
        }
    }

    private static double calculateUvLimit() {
        double machEps = 1.0d;
        do {
            machEps /= 2.0d;
        } while ((machEps / 2.0d) + 1.0d != 1.0d);
        return 1.0d + machEps;
    }

    private static UvTransform[] createUvTransforms() {
        UvTransform[] uvTransforms = {new UvTransform() { // from class: com.android.internal.location.altitude.S2CellIdUtils.1
            @Override // com.android.internal.location.altitude.S2CellIdUtils.UvTransform
            public double xyzToU(double x10, double y10, double z10) {
                return y10 / x10;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.UvTransform
            public double xyzToV(double x10, double y10, double z10) {
                return z10 / x10;
            }
        }, new UvTransform() { // from class: com.android.internal.location.altitude.S2CellIdUtils.2
            @Override // com.android.internal.location.altitude.S2CellIdUtils.UvTransform
            public double xyzToU(double x10, double y10, double z10) {
                return (-x10) / y10;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.UvTransform
            public double xyzToV(double x10, double y10, double z10) {
                return z10 / y10;
            }
        }, new UvTransform() { // from class: com.android.internal.location.altitude.S2CellIdUtils.3
            @Override // com.android.internal.location.altitude.S2CellIdUtils.UvTransform
            public double xyzToU(double x10, double y10, double z10) {
                return (-x10) / z10;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.UvTransform
            public double xyzToV(double x10, double y10, double z10) {
                return (-y10) / z10;
            }
        }, new UvTransform() { // from class: com.android.internal.location.altitude.S2CellIdUtils.4
            @Override // com.android.internal.location.altitude.S2CellIdUtils.UvTransform
            public double xyzToU(double x10, double y10, double z10) {
                return z10 / x10;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.UvTransform
            public double xyzToV(double x10, double y10, double z10) {
                return y10 / x10;
            }
        }, new UvTransform() { // from class: com.android.internal.location.altitude.S2CellIdUtils.5
            @Override // com.android.internal.location.altitude.S2CellIdUtils.UvTransform
            public double xyzToU(double x10, double y10, double z10) {
                return z10 / y10;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.UvTransform
            public double xyzToV(double x10, double y10, double z10) {
                return (-x10) / y10;
            }
        }, new UvTransform() { // from class: com.android.internal.location.altitude.S2CellIdUtils.6
            @Override // com.android.internal.location.altitude.S2CellIdUtils.UvTransform
            public double xyzToU(double x10, double y10, double z10) {
                return (-y10) / z10;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.UvTransform
            public double xyzToV(double x10, double y10, double z10) {
                return (-x10) / z10;
            }
        }};
        return uvTransforms;
    }

    private static XyzTransform[] createXyzTransforms() {
        XyzTransform[] xyzTransforms = {new XyzTransform() { // from class: com.android.internal.location.altitude.S2CellIdUtils.7
            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToX(double u10, double v2) {
                return 1.0d;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToY(double u10, double v2) {
                return u10;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToZ(double u10, double v2) {
                return v2;
            }
        }, new XyzTransform() { // from class: com.android.internal.location.altitude.S2CellIdUtils.8
            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToX(double u10, double v2) {
                return -u10;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToY(double u10, double v2) {
                return 1.0d;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToZ(double u10, double v2) {
                return v2;
            }
        }, new XyzTransform() { // from class: com.android.internal.location.altitude.S2CellIdUtils.9
            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToX(double u10, double v2) {
                return -u10;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToY(double u10, double v2) {
                return -v2;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToZ(double u10, double v2) {
                return 1.0d;
            }
        }, new XyzTransform() { // from class: com.android.internal.location.altitude.S2CellIdUtils.10
            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToX(double u10, double v2) {
                return -1.0d;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToY(double u10, double v2) {
                return -v2;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToZ(double u10, double v2) {
                return -u10;
            }
        }, new XyzTransform() { // from class: com.android.internal.location.altitude.S2CellIdUtils.11
            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToX(double u10, double v2) {
                return v2;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToY(double u10, double v2) {
                return -1.0d;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToZ(double u10, double v2) {
                return -u10;
            }
        }, new XyzTransform() { // from class: com.android.internal.location.altitude.S2CellIdUtils.12
            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToX(double u10, double v2) {
                return v2;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToY(double u10, double v2) {
                return u10;
            }

            @Override // com.android.internal.location.altitude.S2CellIdUtils.XyzTransform
            public double uvToZ(double u10, double v2) {
                return -1.0d;
            }
        }};
        return xyzTransforms;
    }
}
