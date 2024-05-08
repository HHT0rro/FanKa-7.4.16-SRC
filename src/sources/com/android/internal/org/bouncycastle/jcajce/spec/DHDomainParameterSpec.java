package com.android.internal.org.bouncycastle.jcajce.spec;

import com.android.internal.org.bouncycastle.crypto.params.DHParameters;
import com.android.internal.org.bouncycastle.crypto.params.DHValidationParameters;
import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DHDomainParameterSpec extends DHParameterSpec {

    /* renamed from: j, reason: collision with root package name */
    private final BigInteger f9247j;

    /* renamed from: m, reason: collision with root package name */
    private final int f9248m;

    /* renamed from: q, reason: collision with root package name */
    private final BigInteger f9249q;
    private DHValidationParameters validationParameters;

    public DHDomainParameterSpec(DHParameters domainParameters) {
        this(domainParameters.getP(), domainParameters.getQ(), domainParameters.getG(), domainParameters.getJ(), domainParameters.getM(), domainParameters.getL());
        this.validationParameters = domainParameters.getValidationParameters();
    }

    public DHDomainParameterSpec(BigInteger p10, BigInteger q10, BigInteger g3) {
        this(p10, q10, g3, null, 0);
    }

    public DHDomainParameterSpec(BigInteger p10, BigInteger q10, BigInteger g3, int l10) {
        this(p10, q10, g3, null, l10);
    }

    public DHDomainParameterSpec(BigInteger p10, BigInteger q10, BigInteger g3, BigInteger j10, int l10) {
        this(p10, q10, g3, j10, 0, l10);
    }

    public DHDomainParameterSpec(BigInteger p10, BigInteger q10, BigInteger g3, BigInteger j10, int m10, int l10) {
        super(p10, g3, l10);
        this.f9249q = q10;
        this.f9247j = j10;
        this.f9248m = m10;
    }

    public BigInteger getQ() {
        return this.f9249q;
    }

    public BigInteger getJ() {
        return this.f9247j;
    }

    public int getM() {
        return this.f9248m;
    }

    public DHParameters getDomainParameters() {
        return new DHParameters(getP(), getG(), this.f9249q, this.f9248m, getL(), this.f9247j, this.validationParameters);
    }
}
