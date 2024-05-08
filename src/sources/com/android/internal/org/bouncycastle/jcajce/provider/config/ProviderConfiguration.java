package com.android.internal.org.bouncycastle.jcajce.provider.config;

import com.android.internal.org.bouncycastle.jce.spec.ECParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.DHParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ProviderConfiguration {
    Set getAcceptableNamedCurves();

    Map getAdditionalECParameters();

    DHParameterSpec getDHDefaultParameters(int i10);

    DSAParameterSpec getDSADefaultParameters(int i10);

    ECParameterSpec getEcImplicitlyCa();
}
