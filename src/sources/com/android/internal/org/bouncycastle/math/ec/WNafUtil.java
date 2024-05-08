package com.android.internal.org.bouncycastle.math.ec;

import com.android.internal.logging.nano.MetricsProto;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class WNafUtil {
    private static final int[] DEFAULT_WINDOW_SIZE_CUTOFFS = {13, 41, 121, 337, MetricsProto.MetricsEvent.ACTION_APPOP_DENIED_REQUEST_INSTALL_PACKAGES, 2305};
    private static final byte[] EMPTY_BYTES = new byte[0];
    private static final int[] EMPTY_INTS = new int[0];
    private static final ECPoint[] EMPTY_POINTS = new ECPoint[0];
    private static final int MAX_WIDTH = 16;
    public static final String PRECOMP_NAME = "bc_wnaf";

    public static void configureBasepoint(ECPoint p10) {
        ECCurve c4 = p10.getCurve();
        if (c4 == null) {
            return;
        }
        BigInteger n10 = c4.getOrder();
        int bits = n10 == null ? c4.getFieldSize() + 1 : n10.bitLength();
        final int confWidth = Math.min(16, getWindowSize(bits) + 3);
        c4.precompute(p10, PRECOMP_NAME, new PreCompCallback() { // from class: com.android.internal.org.bouncycastle.math.ec.WNafUtil.1
            @Override // com.android.internal.org.bouncycastle.math.ec.PreCompCallback
            public PreCompInfo precompute(PreCompInfo existing) {
                WNafPreCompInfo existingWNaf = existing instanceof WNafPreCompInfo ? (WNafPreCompInfo) existing : null;
                if (existingWNaf != null && existingWNaf.getConfWidth() == confWidth) {
                    existingWNaf.setPromotionCountdown(0);
                    return existingWNaf;
                }
                WNafPreCompInfo result = new WNafPreCompInfo();
                result.setPromotionCountdown(0);
                result.setConfWidth(confWidth);
                if (existingWNaf != null) {
                    result.setPreComp(existingWNaf.getPreComp());
                    result.setPreCompNeg(existingWNaf.getPreCompNeg());
                    result.setTwice(existingWNaf.getTwice());
                    result.setWidth(existingWNaf.getWidth());
                }
                return result;
            }
        });
    }

    public static int[] generateCompactNaf(BigInteger k10) {
        if ((k10.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        }
        if (k10.signum() == 0) {
            return EMPTY_INTS;
        }
        BigInteger _3k = k10.shiftLeft(1).add(k10);
        int bits = _3k.bitLength();
        int[] naf = new int[bits >> 1];
        BigInteger diff = _3k.xor(k10);
        int highBit = bits - 1;
        int length = 0;
        int zeroes = 0;
        int i10 = 1;
        while (i10 < highBit) {
            if (!diff.testBit(i10)) {
                zeroes++;
            } else {
                int digit = k10.testBit(i10) ? -1 : 1;
                naf[length] = (digit << 16) | zeroes;
                i10++;
                zeroes = 1;
                length++;
            }
            i10++;
        }
        int length2 = length + 1;
        naf[length] = 65536 | zeroes;
        if (naf.length > length2) {
            return trim(naf, length2);
        }
        return naf;
    }

    public static int[] generateCompactWindowNaf(int width, BigInteger k10) {
        if (width == 2) {
            return generateCompactNaf(k10);
        }
        if (width < 2 || width > 16) {
            throw new IllegalArgumentException("'width' must be in the range [2, 16]");
        }
        if ((k10.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        }
        if (k10.signum() == 0) {
            return EMPTY_INTS;
        }
        int[] wnaf = new int[(k10.bitLength() / width) + 1];
        int pow2 = 1 << width;
        int mask = pow2 - 1;
        int sign = pow2 >>> 1;
        boolean carry = false;
        int length = 0;
        int pos = 0;
        while (pos <= k10.bitLength()) {
            if (k10.testBit(pos) == carry) {
                pos++;
            } else {
                k10 = k10.shiftRight(pos);
                int digit = k10.intValue() & mask;
                if (carry) {
                    digit++;
                }
                carry = (digit & sign) != 0;
                if (carry) {
                    digit -= pow2;
                }
                int zeroes = length > 0 ? pos - 1 : pos;
                wnaf[length] = (digit << 16) | zeroes;
                pos = width;
                length++;
            }
        }
        if (wnaf.length > length) {
            return trim(wnaf, length);
        }
        return wnaf;
    }

    public static byte[] generateJSF(BigInteger g3, BigInteger h10) {
        int digits = Math.max(g3.bitLength(), h10.bitLength()) + 1;
        byte[] jsf = new byte[digits];
        BigInteger k02 = g3;
        BigInteger k12 = h10;
        int j10 = 0;
        int d02 = 0;
        int d12 = 0;
        int offset = 0;
        while (true) {
            if ((d02 | d12) == 0 && k02.bitLength() <= offset && k12.bitLength() <= offset) {
                break;
            }
            int n02 = ((k02.intValue() >>> offset) + d02) & 7;
            int n12 = ((k12.intValue() >>> offset) + d12) & 7;
            int u02 = n02 & 1;
            if (u02 != 0) {
                u02 -= n02 & 2;
                if (n02 + u02 == 4 && (n12 & 3) == 2) {
                    u02 = -u02;
                }
            }
            int u12 = n12 & 1;
            if (u12 != 0) {
                u12 -= n12 & 2;
                if (n12 + u12 == 4 && (n02 & 3) == 2) {
                    u12 = -u12;
                }
            }
            if ((d02 << 1) == u02 + 1) {
                d02 ^= 1;
            }
            if ((d12 << 1) == u12 + 1) {
                d12 ^= 1;
            }
            offset++;
            if (offset == 30) {
                offset = 0;
                k02 = k02.shiftRight(30);
                k12 = k12.shiftRight(30);
            }
            jsf[j10] = (byte) ((u02 << 4) | (u12 & 15));
            j10++;
        }
        if (jsf.length > j10) {
            return trim(jsf, j10);
        }
        return jsf;
    }

    public static byte[] generateNaf(BigInteger k10) {
        if (k10.signum() == 0) {
            return EMPTY_BYTES;
        }
        BigInteger _3k = k10.shiftLeft(1).add(k10);
        int digits = _3k.bitLength() - 1;
        byte[] naf = new byte[digits];
        BigInteger diff = _3k.xor(k10);
        int i10 = 1;
        while (i10 < digits) {
            if (diff.testBit(i10)) {
                naf[i10 - 1] = (byte) (k10.testBit(i10) ? -1 : 1);
                i10++;
            }
            i10++;
        }
        int i11 = digits - 1;
        naf[i11] = 1;
        return naf;
    }

    public static byte[] generateWindowNaf(int width, BigInteger k10) {
        if (width == 2) {
            return generateNaf(k10);
        }
        if (width < 2 || width > 8) {
            throw new IllegalArgumentException("'width' must be in the range [2, 8]");
        }
        if (k10.signum() == 0) {
            return EMPTY_BYTES;
        }
        byte[] wnaf = new byte[k10.bitLength() + 1];
        int pow2 = 1 << width;
        int mask = pow2 - 1;
        int sign = pow2 >>> 1;
        boolean carry = false;
        int length = 0;
        int pos = 0;
        while (pos <= k10.bitLength()) {
            if (k10.testBit(pos) == carry) {
                pos++;
            } else {
                k10 = k10.shiftRight(pos);
                int digit = k10.intValue() & mask;
                if (carry) {
                    digit++;
                }
                carry = (digit & sign) != 0;
                if (carry) {
                    digit -= pow2;
                }
                int length2 = length + (length > 0 ? pos - 1 : pos);
                wnaf[length2] = (byte) digit;
                pos = width;
                length = length2 + 1;
            }
        }
        if (wnaf.length > length) {
            return trim(wnaf, length);
        }
        return wnaf;
    }

    public static int getNafWeight(BigInteger k10) {
        if (k10.signum() == 0) {
            return 0;
        }
        BigInteger _3k = k10.shiftLeft(1).add(k10);
        BigInteger diff = _3k.xor(k10);
        return diff.bitCount();
    }

    public static WNafPreCompInfo getWNafPreCompInfo(ECPoint p10) {
        return getWNafPreCompInfo(p10.getCurve().getPreCompInfo(p10, PRECOMP_NAME));
    }

    public static WNafPreCompInfo getWNafPreCompInfo(PreCompInfo preCompInfo) {
        if (preCompInfo instanceof WNafPreCompInfo) {
            return (WNafPreCompInfo) preCompInfo;
        }
        return null;
    }

    public static int getWindowSize(int bits) {
        return getWindowSize(bits, DEFAULT_WINDOW_SIZE_CUTOFFS, 16);
    }

    public static int getWindowSize(int bits, int maxWidth) {
        return getWindowSize(bits, DEFAULT_WINDOW_SIZE_CUTOFFS, maxWidth);
    }

    public static int getWindowSize(int bits, int[] windowSizeCutoffs) {
        return getWindowSize(bits, windowSizeCutoffs, 16);
    }

    public static int getWindowSize(int bits, int[] windowSizeCutoffs, int maxWidth) {
        int w3 = 0;
        while (w3 < windowSizeCutoffs.length && bits >= windowSizeCutoffs[w3]) {
            w3++;
        }
        return Math.max(2, Math.min(maxWidth, w3 + 2));
    }

    public static WNafPreCompInfo precompute(final ECPoint p10, final int minWidth, final boolean includeNegated) {
        final ECCurve c4 = p10.getCurve();
        return (WNafPreCompInfo) c4.precompute(p10, PRECOMP_NAME, new PreCompCallback() { // from class: com.android.internal.org.bouncycastle.math.ec.WNafUtil.2
            @Override // com.android.internal.org.bouncycastle.math.ec.PreCompCallback
            public PreCompInfo precompute(PreCompInfo existing) {
                int pos;
                WNafPreCompInfo existingWNaf = existing instanceof WNafPreCompInfo ? (WNafPreCompInfo) existing : null;
                int width = Math.max(2, Math.min(16, minWidth));
                if (checkExisting(existingWNaf, width, 1 << (width - 2), includeNegated)) {
                    existingWNaf.decrementPromotionCountdown();
                    return existingWNaf;
                }
                WNafPreCompInfo result = new WNafPreCompInfo();
                ECPoint[] preComp = null;
                ECPoint[] preCompNeg = null;
                ECPoint twiceP = null;
                if (existingWNaf != null) {
                    int promotionCountdown = existingWNaf.decrementPromotionCountdown();
                    result.setPromotionCountdown(promotionCountdown);
                    int confWidth = existingWNaf.getConfWidth();
                    result.setConfWidth(confWidth);
                    preComp = existingWNaf.getPreComp();
                    preCompNeg = existingWNaf.getPreCompNeg();
                    twiceP = existingWNaf.getTwice();
                }
                int promotionCountdown2 = result.getConfWidth();
                int width2 = Math.min(16, Math.max(promotionCountdown2, width));
                int reqPreCompLen = 1 << (width2 - 2);
                int iniPreCompLen = 0;
                if (preComp == null) {
                    preComp = WNafUtil.EMPTY_POINTS;
                } else {
                    iniPreCompLen = preComp.length;
                }
                if (iniPreCompLen < reqPreCompLen) {
                    preComp = WNafUtil.resizeTable(preComp, reqPreCompLen);
                    if (reqPreCompLen == 1) {
                        preComp[0] = p10.normalize();
                    } else {
                        int curPreCompLen = iniPreCompLen;
                        if (curPreCompLen == 0) {
                            preComp[0] = p10;
                            curPreCompLen = 1;
                        }
                        ECFieldElement iso = null;
                        if (reqPreCompLen == 2) {
                            preComp[1] = p10.threeTimes();
                        } else {
                            ECPoint isoTwiceP = twiceP;
                            ECPoint last = preComp[curPreCompLen - 1];
                            if (isoTwiceP == null) {
                                isoTwiceP = preComp[0].twice();
                                twiceP = isoTwiceP;
                                if (!twiceP.isInfinity() && ECAlgorithms.isFpCurve(c4) && c4.getFieldSize() >= 64) {
                                    switch (c4.getCoordinateSystem()) {
                                        case 2:
                                        case 3:
                                        case 4:
                                            iso = twiceP.getZCoord(0);
                                            isoTwiceP = c4.createPoint(twiceP.getXCoord().toBigInteger(), twiceP.getYCoord().toBigInteger());
                                            ECFieldElement iso2 = iso.square();
                                            ECFieldElement iso3 = iso2.multiply(iso);
                                            last = last.scaleX(iso2).scaleY(iso3);
                                            if (iniPreCompLen == 0) {
                                                preComp[0] = last;
                                                break;
                                            }
                                            break;
                                    }
                                }
                            }
                            while (curPreCompLen < reqPreCompLen) {
                                ECPoint add = last.add(isoTwiceP);
                                last = add;
                                preComp[curPreCompLen] = add;
                                curPreCompLen++;
                            }
                        }
                        c4.normalizeAll(preComp, iniPreCompLen, reqPreCompLen - iniPreCompLen, iso);
                    }
                }
                if (includeNegated) {
                    if (preCompNeg == null) {
                        pos = 0;
                        preCompNeg = new ECPoint[reqPreCompLen];
                    } else {
                        pos = preCompNeg.length;
                        if (pos < reqPreCompLen) {
                            preCompNeg = WNafUtil.resizeTable(preCompNeg, reqPreCompLen);
                        }
                    }
                    while (pos < reqPreCompLen) {
                        preCompNeg[pos] = preComp[pos].negate();
                        pos++;
                    }
                }
                result.setPreComp(preComp);
                result.setPreCompNeg(preCompNeg);
                result.setTwice(twiceP);
                result.setWidth(width2);
                return result;
            }

            private boolean checkExisting(WNafPreCompInfo existingWNaf, int width, int reqPreCompLen, boolean includeNegated2) {
                return existingWNaf != null && existingWNaf.getWidth() >= Math.max(existingWNaf.getConfWidth(), width) && checkTable(existingWNaf.getPreComp(), reqPreCompLen) && (!includeNegated2 || checkTable(existingWNaf.getPreCompNeg(), reqPreCompLen));
            }

            private boolean checkTable(ECPoint[] table, int reqLen) {
                return table != null && table.length >= reqLen;
            }
        });
    }

    public static WNafPreCompInfo precomputeWithPointMap(ECPoint p10, final ECPointMap pointMap, final WNafPreCompInfo fromWNaf, final boolean includeNegated) {
        ECCurve c4 = p10.getCurve();
        return (WNafPreCompInfo) c4.precompute(p10, PRECOMP_NAME, new PreCompCallback() { // from class: com.android.internal.org.bouncycastle.math.ec.WNafUtil.3
            @Override // com.android.internal.org.bouncycastle.math.ec.PreCompCallback
            public PreCompInfo precompute(PreCompInfo existing) {
                WNafPreCompInfo existingWNaf = existing instanceof WNafPreCompInfo ? (WNafPreCompInfo) existing : null;
                int width = WNafPreCompInfo.this.getWidth();
                int reqPreCompLen = WNafPreCompInfo.this.getPreComp().length;
                if (checkExisting(existingWNaf, width, reqPreCompLen, includeNegated)) {
                    existingWNaf.decrementPromotionCountdown();
                    return existingWNaf;
                }
                WNafPreCompInfo result = new WNafPreCompInfo();
                result.setPromotionCountdown(WNafPreCompInfo.this.getPromotionCountdown());
                ECPoint twiceFrom = WNafPreCompInfo.this.getTwice();
                if (twiceFrom != null) {
                    ECPoint twice = pointMap.map(twiceFrom);
                    result.setTwice(twice);
                }
                ECPoint[] preCompFrom = WNafPreCompInfo.this.getPreComp();
                ECPoint[] preComp = new ECPoint[preCompFrom.length];
                for (int i10 = 0; i10 < preCompFrom.length; i10++) {
                    preComp[i10] = pointMap.map(preCompFrom[i10]);
                }
                result.setPreComp(preComp);
                result.setWidth(width);
                if (includeNegated) {
                    ECPoint[] preCompNeg = new ECPoint[preComp.length];
                    for (int i11 = 0; i11 < preCompNeg.length; i11++) {
                        preCompNeg[i11] = preComp[i11].negate();
                    }
                    result.setPreCompNeg(preCompNeg);
                }
                return result;
            }

            private boolean checkExisting(WNafPreCompInfo existingWNaf, int width, int reqPreCompLen, boolean includeNegated2) {
                return existingWNaf != null && existingWNaf.getWidth() >= width && checkTable(existingWNaf.getPreComp(), reqPreCompLen) && (!includeNegated2 || checkTable(existingWNaf.getPreCompNeg(), reqPreCompLen));
            }

            private boolean checkTable(ECPoint[] table, int reqLen) {
                return table != null && table.length >= reqLen;
            }
        });
    }

    private static byte[] trim(byte[] a10, int length) {
        byte[] result = new byte[length];
        System.arraycopy((Object) a10, 0, (Object) result, 0, result.length);
        return result;
    }

    private static int[] trim(int[] a10, int length) {
        int[] result = new int[length];
        System.arraycopy((Object) a10, 0, (Object) result, 0, result.length);
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ECPoint[] resizeTable(ECPoint[] a10, int length) {
        ECPoint[] result = new ECPoint[length];
        System.arraycopy(a10, 0, result, 0, a10.length);
        return result;
    }
}
