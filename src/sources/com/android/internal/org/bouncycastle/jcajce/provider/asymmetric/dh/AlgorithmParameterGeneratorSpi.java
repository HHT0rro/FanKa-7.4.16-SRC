package com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.dh;

import com.android.internal.org.bouncycastle.crypto.CryptoServicesRegistrar;
import com.android.internal.org.bouncycastle.crypto.generators.DHParametersGenerator;
import com.android.internal.org.bouncycastle.crypto.params.DHParameters;
import com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.BaseAlgorithmParameterGeneratorSpi;
import com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AlgorithmParameterGeneratorSpi extends BaseAlgorithmParameterGeneratorSpi {
    protected SecureRandom random;
    protected int strength = 2048;

    /* renamed from: l, reason: collision with root package name */
    private int f9234l = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int strength, SecureRandom random) {
        this.strength = strength;
        this.random = random;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(AlgorithmParameterSpec genParamSpec, SecureRandom random) throws InvalidAlgorithmParameterException {
        if (!(genParamSpec instanceof DHGenParameterSpec)) {
            throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
        }
        DHGenParameterSpec spec = (DHGenParameterSpec) genParamSpec;
        this.strength = spec.getPrimeSize();
        this.f9234l = spec.getExponentSize();
        this.random = random;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.AlgorithmParameterGeneratorSpi
    public AlgorithmParameters engineGenerateParameters() {
        DHParametersGenerator pGen = new DHParametersGenerator();
        int certainty = PrimeCertaintyCalculator.getDefaultCertainty(this.strength);
        pGen.init(this.strength, certainty, CryptoServicesRegistrar.getSecureRandom(this.random));
        DHParameters p10 = pGen.generateParameters();
        try {
            AlgorithmParameters params = createParametersInstance("DH");
            params.init(new DHParameterSpec(p10.getP(), p10.getG(), this.f9234l));
            return params;
        } catch (Exception e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }
}
