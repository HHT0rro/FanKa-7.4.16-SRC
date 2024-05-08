package com.android.internal.org.bouncycastle.jcajce.provider.config;

import com.android.internal.org.bouncycastle.util.Strings;
import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ProviderConfigurationPermission extends BasicPermission {
    private static final int ACCEPTABLE_EC_CURVES = 16;
    private static final String ACCEPTABLE_EC_CURVES_STR = "acceptableeccurves";
    private static final int ADDITIONAL_EC_PARAMETERS = 32;
    private static final String ADDITIONAL_EC_PARAMETERS_STR = "additionalecparameters";
    private static final int ALL = 63;
    private static final String ALL_STR = "all";
    private static final int DH_DEFAULT_PARAMS = 8;
    private static final String DH_DEFAULT_PARAMS_STR = "dhdefaultparams";
    private static final int EC_IMPLICITLY_CA = 2;
    private static final String EC_IMPLICITLY_CA_STR = "ecimplicitlyca";
    private static final int THREAD_LOCAL_DH_DEFAULT_PARAMS = 4;
    private static final String THREAD_LOCAL_DH_DEFAULT_PARAMS_STR = "threadlocaldhdefaultparams";
    private static final int THREAD_LOCAL_EC_IMPLICITLY_CA = 1;
    private static final String THREAD_LOCAL_EC_IMPLICITLY_CA_STR = "threadlocalecimplicitlyca";
    private final String actions;
    private final int permissionMask;

    public ProviderConfigurationPermission(String name) {
        super(name);
        this.actions = "all";
        this.permissionMask = 63;
    }

    public ProviderConfigurationPermission(String name, String actions) {
        super(name, actions);
        this.actions = actions;
        this.permissionMask = calculateMask(actions);
    }

    private int calculateMask(String actions) {
        StringTokenizer tok = new StringTokenizer(Strings.toLowerCase(actions), " ,");
        int mask = 0;
        while (tok.hasMoreTokens()) {
            String s2 = tok.nextToken();
            if (s2.equals(THREAD_LOCAL_EC_IMPLICITLY_CA_STR)) {
                mask |= 1;
            } else if (s2.equals(EC_IMPLICITLY_CA_STR)) {
                mask |= 2;
            } else if (s2.equals(THREAD_LOCAL_DH_DEFAULT_PARAMS_STR)) {
                mask |= 4;
            } else if (s2.equals(DH_DEFAULT_PARAMS_STR)) {
                mask |= 8;
            } else if (s2.equals(ACCEPTABLE_EC_CURVES_STR)) {
                mask |= 16;
            } else if (s2.equals(ADDITIONAL_EC_PARAMETERS_STR)) {
                mask |= 32;
            } else if (s2.equals("all")) {
                mask |= 63;
            }
        }
        if (mask == 0) {
            throw new IllegalArgumentException("unknown permissions passed to mask");
        }
        return mask;
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public String getActions() {
        return this.actions;
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public boolean implies(Permission permission) {
        if (!(permission instanceof ProviderConfigurationPermission) || !getName().equals(permission.getName())) {
            return false;
        }
        ProviderConfigurationPermission other = (ProviderConfigurationPermission) permission;
        int i10 = this.permissionMask;
        int i11 = other.permissionMask;
        return (i10 & i11) == i11;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProviderConfigurationPermission)) {
            return false;
        }
        ProviderConfigurationPermission other = (ProviderConfigurationPermission) obj;
        return this.permissionMask == other.permissionMask && getName().equals(other.getName());
    }

    public int hashCode() {
        return getName().hashCode() + this.permissionMask;
    }
}
