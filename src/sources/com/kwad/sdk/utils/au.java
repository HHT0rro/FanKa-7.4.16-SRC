package com.kwad.sdk.utils;

import android.location.Location;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class au {
    private static boolean Mg() {
        if (!com.kwad.framework.a.a.f36635md.booleanValue()) {
            return false;
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    public static boolean Mh() {
        KsCustomController ksCustomController;
        if (Mg()) {
            return true;
        }
        try {
            SdkConfig KP = ServiceProvider.KP();
            if (KP != null && (ksCustomController = KP.ksCustomController) != null) {
                if (!ksCustomController.canReadLocation()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static Location Mi() {
        KsCustomController ksCustomController;
        try {
            SdkConfig KP = ServiceProvider.KP();
            if (KP == null || (ksCustomController = KP.ksCustomController) == null) {
                return null;
            }
            return ksCustomController.getLocation();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String Mj() {
        KsCustomController ksCustomController;
        try {
            SdkConfig KP = ServiceProvider.KP();
            return (KP == null || (ksCustomController = KP.ksCustomController) == null) ? "" : ksCustomController.getImei();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] Mk() {
        KsCustomController ksCustomController;
        try {
            SdkConfig KP = ServiceProvider.KP();
            if (KP != null && (ksCustomController = KP.ksCustomController) != null) {
                return ksCustomController.getImeis();
            }
        } catch (Throwable unused) {
        }
        return new String[]{"", ""};
    }

    public static String Ml() {
        KsCustomController ksCustomController;
        try {
            SdkConfig KP = ServiceProvider.KP();
            return (KP == null || (ksCustomController = KP.ksCustomController) == null) ? "" : ksCustomController.getAndroidId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean Mm() {
        KsCustomController ksCustomController;
        if (Mg()) {
            return true;
        }
        try {
            SdkConfig KP = ServiceProvider.KP();
            if (KP != null && (ksCustomController = KP.ksCustomController) != null) {
                if (!ksCustomController.canUseMacAddress()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String Mn() {
        KsCustomController ksCustomController;
        try {
            SdkConfig KP = ServiceProvider.KP();
            return (KP == null || (ksCustomController = KP.ksCustomController) == null) ? "" : ksCustomController.getMacAddress();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean Mo() {
        KsCustomController ksCustomController;
        if (Mg()) {
            return true;
        }
        try {
            SdkConfig KP = ServiceProvider.KP();
            if (KP != null && (ksCustomController = KP.ksCustomController) != null) {
                if (!ksCustomController.canUseOaid()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String Mp() {
        KsCustomController ksCustomController;
        try {
            SdkConfig KP = ServiceProvider.KP();
            return (KP == null || (ksCustomController = KP.ksCustomController) == null) ? "" : ksCustomController.getOaid();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean Mq() {
        KsCustomController ksCustomController;
        if (Mg()) {
            return true;
        }
        try {
            SdkConfig KP = ServiceProvider.KP();
            if (KP != null && (ksCustomController = KP.ksCustomController) != null) {
                if (!ksCustomController.canUseNetworkState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean Mr() {
        KsCustomController ksCustomController;
        if (Mg()) {
            return true;
        }
        try {
            SdkConfig KP = ServiceProvider.KP();
            if (KP != null && (ksCustomController = KP.ksCustomController) != null) {
                if (!ksCustomController.canUseStoragePermission()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean Ms() {
        KsCustomController ksCustomController;
        if (Mg()) {
            return true;
        }
        try {
            SdkConfig KP = ServiceProvider.KP();
            if (KP != null && (ksCustomController = KP.ksCustomController) != null) {
                if (!ksCustomController.canReadInstalledPackages()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static List<String> Mt() {
        KsCustomController ksCustomController;
        try {
            SdkConfig KP = ServiceProvider.KP();
            if (KP != null && (ksCustomController = KP.ksCustomController) != null) {
                return ksCustomController.getInstalledPackages();
            }
        } catch (Throwable unused) {
        }
        return new ArrayList();
    }

    public static boolean usePhoneStateDisable() {
        KsCustomController ksCustomController;
        if (Mg()) {
            return true;
        }
        try {
            SdkConfig KP = ServiceProvider.KP();
            if (KP != null && (ksCustomController = KP.ksCustomController) != null) {
                if (!ksCustomController.canUsePhoneState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
