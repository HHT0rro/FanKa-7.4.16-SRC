package com.android.internal.org.bouncycastle.jce.provider;

import com.android.internal.org.bouncycastle.crypto.CryptoServicesRegistrar;
import com.android.internal.org.bouncycastle.crypto.params.DHParameters;
import com.android.internal.org.bouncycastle.crypto.params.DSAParameters;
import com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.android.internal.org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.android.internal.org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import com.android.internal.org.bouncycastle.jcajce.provider.config.ProviderConfigurationPermission;
import com.android.internal.org.bouncycastle.jcajce.spec.DHDomainParameterSpec;
import com.android.internal.org.bouncycastle.jce.spec.ECParameterSpec;
import java.security.Permission;
import java.security.spec.DSAParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.DHParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class BouncyCastleProviderConfiguration implements ProviderConfiguration {
    private volatile Object dhDefaultParams;
    private volatile ECParameterSpec ecImplicitCaParams;
    private static Permission BC_EC_LOCAL_PERMISSION = new ProviderConfigurationPermission("BC", ConfigurableProvider.THREAD_LOCAL_EC_IMPLICITLY_CA);
    private static Permission BC_EC_PERMISSION = new ProviderConfigurationPermission("BC", ConfigurableProvider.EC_IMPLICITLY_CA);
    private static Permission BC_DH_LOCAL_PERMISSION = new ProviderConfigurationPermission("BC", ConfigurableProvider.THREAD_LOCAL_DH_DEFAULT_PARAMS);
    private static Permission BC_DH_PERMISSION = new ProviderConfigurationPermission("BC", ConfigurableProvider.DH_DEFAULT_PARAMS);
    private static Permission BC_EC_CURVE_PERMISSION = new ProviderConfigurationPermission("BC", ConfigurableProvider.ACCEPTABLE_EC_CURVES);
    private static Permission BC_ADDITIONAL_EC_CURVE_PERMISSION = new ProviderConfigurationPermission("BC", ConfigurableProvider.ADDITIONAL_EC_PARAMETERS);
    private ThreadLocal ecThreadSpec = new ThreadLocal();
    private ThreadLocal dhThreadSpec = new ThreadLocal();
    private volatile Set acceptableNamedCurves = new HashSet();
    private volatile Map additionalECParameters = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setParameter(String parameterName, Object parameter) {
        ECParameterSpec curveSpec;
        SecurityManager securityManager = System.getSecurityManager();
        if (parameterName.equals(ConfigurableProvider.THREAD_LOCAL_EC_IMPLICITLY_CA)) {
            if (securityManager != null) {
                securityManager.checkPermission(BC_EC_LOCAL_PERMISSION);
            }
            if ((parameter instanceof ECParameterSpec) || parameter == null) {
                curveSpec = (ECParameterSpec) parameter;
            } else {
                curveSpec = EC5Util.convertSpec((java.security.spec.ECParameterSpec) parameter);
            }
            if (curveSpec == null) {
                this.ecThreadSpec.remove();
                return;
            } else {
                this.ecThreadSpec.set(curveSpec);
                return;
            }
        }
        if (parameterName.equals(ConfigurableProvider.EC_IMPLICITLY_CA)) {
            if (securityManager != null) {
                securityManager.checkPermission(BC_EC_PERMISSION);
            }
            if ((parameter instanceof ECParameterSpec) || parameter == null) {
                this.ecImplicitCaParams = (ECParameterSpec) parameter;
                return;
            } else {
                this.ecImplicitCaParams = EC5Util.convertSpec((java.security.spec.ECParameterSpec) parameter);
                return;
            }
        }
        if (parameterName.equals(ConfigurableProvider.THREAD_LOCAL_DH_DEFAULT_PARAMS)) {
            if (securityManager != null) {
                securityManager.checkPermission(BC_DH_LOCAL_PERMISSION);
            }
            if (!(parameter instanceof DHParameterSpec) && !(parameter instanceof DHParameterSpec[]) && parameter != null) {
                throw new IllegalArgumentException("not a valid DHParameterSpec");
            }
            if (parameter != null) {
                this.dhThreadSpec.set(parameter);
                return;
            } else {
                this.dhThreadSpec.remove();
                return;
            }
        }
        if (parameterName.equals(ConfigurableProvider.DH_DEFAULT_PARAMS)) {
            if (securityManager != null) {
                securityManager.checkPermission(BC_DH_PERMISSION);
            }
            if ((parameter instanceof DHParameterSpec) || (parameter instanceof DHParameterSpec[]) || parameter == null) {
                this.dhDefaultParams = parameter;
                return;
            }
            throw new IllegalArgumentException("not a valid DHParameterSpec or DHParameterSpec[]");
        }
        if (parameterName.equals(ConfigurableProvider.ACCEPTABLE_EC_CURVES)) {
            if (securityManager != null) {
                securityManager.checkPermission(BC_EC_CURVE_PERMISSION);
            }
            this.acceptableNamedCurves = (Set) parameter;
        } else if (parameterName.equals(ConfigurableProvider.ADDITIONAL_EC_PARAMETERS)) {
            if (securityManager != null) {
                securityManager.checkPermission(BC_ADDITIONAL_EC_CURVE_PERMISSION);
            }
            this.additionalECParameters = (Map) parameter;
        }
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public ECParameterSpec getEcImplicitlyCa() {
        ECParameterSpec spec = (ECParameterSpec) this.ecThreadSpec.get();
        if (spec != null) {
            return spec;
        }
        return this.ecImplicitCaParams;
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public DHParameterSpec getDHDefaultParameters(int keySize) {
        Object params = this.dhThreadSpec.get();
        if (params == null) {
            params = this.dhDefaultParams;
        }
        if (params instanceof DHParameterSpec) {
            DHParameterSpec spec = (DHParameterSpec) params;
            if (spec.getP().bitLength() == keySize) {
                return spec;
            }
        } else if (params instanceof DHParameterSpec[]) {
            DHParameterSpec[] specs = (DHParameterSpec[]) params;
            for (int i10 = 0; i10 != specs.length; i10++) {
                if (specs[i10].getP().bitLength() == keySize) {
                    return specs[i10];
                }
            }
        }
        DHParameters dhParams = (DHParameters) CryptoServicesRegistrar.getSizedProperty(CryptoServicesRegistrar.Property.DH_DEFAULT_PARAMS, keySize);
        if (dhParams != null) {
            return new DHDomainParameterSpec(dhParams);
        }
        return null;
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public DSAParameterSpec getDSADefaultParameters(int keySize) {
        DSAParameters dsaParams = (DSAParameters) CryptoServicesRegistrar.getSizedProperty(CryptoServicesRegistrar.Property.DSA_DEFAULT_PARAMS, keySize);
        if (dsaParams != null) {
            return new DSAParameterSpec(dsaParams.getP(), dsaParams.getQ(), dsaParams.getG());
        }
        return null;
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public Set getAcceptableNamedCurves() {
        return Collections.unmodifiableSet(this.acceptableNamedCurves);
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public Map getAdditionalECParameters() {
        return Collections.unmodifiableMap(this.additionalECParameters);
    }
}
