package com.google.common.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/* compiled from: BigIntegerMath.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final BigInteger f26683a = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);

    /* renamed from: b, reason: collision with root package name */
    public static final double f26684b = Math.log(10.0d);

    /* renamed from: c, reason: collision with root package name */
    public static final double f26685c = Math.log(2.0d);

    public static BigInteger a(BigInteger bigInteger, BigInteger bigInteger2, RoundingMode roundingMode) {
        return new BigDecimal(bigInteger).divide(new BigDecimal(bigInteger2), 0, roundingMode).toBigIntegerExact();
    }
}
