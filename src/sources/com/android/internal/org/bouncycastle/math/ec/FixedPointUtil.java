package com.android.internal.org.bouncycastle.math.ec;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class FixedPointUtil {
    public static final String PRECOMP_NAME = "bc_fixed_point";

    public static int getCombSize(ECCurve c4) {
        BigInteger order = c4.getOrder();
        return order == null ? c4.getFieldSize() + 1 : order.bitLength();
    }

    public static FixedPointPreCompInfo getFixedPointPreCompInfo(PreCompInfo preCompInfo) {
        if (preCompInfo instanceof FixedPointPreCompInfo) {
            return (FixedPointPreCompInfo) preCompInfo;
        }
        return null;
    }

    public static FixedPointPreCompInfo precompute(final ECPoint p10) {
        final ECCurve c4 = p10.getCurve();
        return (FixedPointPreCompInfo) c4.precompute(p10, PRECOMP_NAME, new PreCompCallback() { // from class: com.android.internal.org.bouncycastle.math.ec.FixedPointUtil.1
            @Override // com.android.internal.org.bouncycastle.math.ec.PreCompCallback
            public PreCompInfo precompute(PreCompInfo existing) {
                FixedPointPreCompInfo existingFP = existing instanceof FixedPointPreCompInfo ? (FixedPointPreCompInfo) existing : null;
                int bits = FixedPointUtil.getCombSize(ECCurve.this);
                int minWidth = bits > 250 ? 6 : 5;
                int n10 = 1 << minWidth;
                if (!checkExisting(existingFP, n10)) {
                    int d10 = ((bits + minWidth) - 1) / minWidth;
                    ECPoint[] pow2Table = new ECPoint[minWidth + 1];
                    pow2Table[0] = p10;
                    for (int i10 = 1; i10 < minWidth; i10++) {
                        pow2Table[i10] = pow2Table[i10 - 1].timesPow2(d10);
                    }
                    pow2Table[minWidth] = pow2Table[0].subtract(pow2Table[1]);
                    ECCurve.this.normalizeAll(pow2Table);
                    ECPoint[] lookupTable = new ECPoint[n10];
                    lookupTable[0] = pow2Table[0];
                    for (int bit = minWidth - 1; bit >= 0; bit--) {
                        ECPoint pow2 = pow2Table[bit];
                        int step = 1 << bit;
                        for (int i11 = step; i11 < n10; i11 += step << 1) {
                            lookupTable[i11] = lookupTable[i11 - step].add(pow2);
                        }
                    }
                    ECCurve.this.normalizeAll(lookupTable);
                    FixedPointPreCompInfo result = new FixedPointPreCompInfo();
                    result.setLookupTable(ECCurve.this.createCacheSafeLookupTable(lookupTable, 0, lookupTable.length));
                    result.setOffset(pow2Table[minWidth]);
                    result.setWidth(minWidth);
                    return result;
                }
                return existingFP;
            }

            private boolean checkExisting(FixedPointPreCompInfo existingFP, int n10) {
                return existingFP != null && checkTable(existingFP.getLookupTable(), n10);
            }

            private boolean checkTable(ECLookupTable table, int n10) {
                return table != null && table.getSize() >= n10;
            }
        });
    }
}
