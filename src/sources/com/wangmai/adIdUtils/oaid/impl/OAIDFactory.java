package com.wangmai.adIdUtils.oaid.impl;

import android.app.Application;
import android.content.Context;
import com.wangmai.adIdUtils.oaid.IOAID;
import com.wangmai.adIdUtils.oaid.OAIDLog;
import com.wangmai.adIdUtils.oaid.OAIDRom;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class OAIDFactory {
    public static IOAID ioaid;

    public static IOAID create(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        IOAID ioaid2 = ioaid;
        if (ioaid2 != null) {
            return ioaid2;
        }
        IOAID createManufacturerImpl = createManufacturerImpl(context);
        ioaid = createManufacturerImpl;
        if (createManufacturerImpl != null && createManufacturerImpl.supported()) {
            OAIDLog.print("Manufacturer interface has been found: " + ioaid.getClass().getName());
            return ioaid;
        }
        IOAID createMsaImpl = createMsaImpl(context);
        ioaid = createMsaImpl;
        if (createMsaImpl != null && createMsaImpl.supported()) {
            OAIDLog.print("Msa interface has been found: " + ioaid.getClass().getName());
            return ioaid;
        }
        return new DefaultImpl();
    }

    public static IOAID createManufacturerImpl(Context context) {
        if (!OAIDRom.isLenovo() && !OAIDRom.isMotolora()) {
            if (OAIDRom.isMeizu()) {
                return new MeizuImpl(context);
            }
            if (OAIDRom.isNubia()) {
                return new NubiaImpl(context);
            }
            if (!OAIDRom.isXiaomi() && !OAIDRom.isMiui() && !OAIDRom.isBlackShark()) {
                if (OAIDRom.isSamsung()) {
                    return new SamsungImpl(context);
                }
                if (OAIDRom.isVivo()) {
                    return new VivoImpl(context);
                }
                if (OAIDRom.isASUS()) {
                    return new AsusImpl(context);
                }
                if (!OAIDRom.isHuawei() && !OAIDRom.isEmui()) {
                    if (!OAIDRom.isOppo() && !OAIDRom.isOnePlus()) {
                        if (OAIDRom.isCoolpad(context)) {
                            return new CoolpadImpl(context);
                        }
                        if (OAIDRom.isCoosea()) {
                            return new CooseaImpl(context);
                        }
                        if (OAIDRom.isFreeme()) {
                            return new FreemeImpl(context);
                        }
                        return null;
                    }
                    return new OppoImpl(context);
                }
                return new HuaweiImpl(context);
            }
            return new XiaomiImpl(context);
        }
        return new LenovoImpl(context);
    }

    public static IOAID createMsaImpl(Context context) {
        MsaImpl msaImpl = new MsaImpl(context);
        if (!msaImpl.supported()) {
            return null;
        }
        OAIDLog.print("Mobile Security Alliance has been found: " + MsaImpl.class.getName());
        return msaImpl;
    }

    public static IOAID createUniversalImpl(Context context) {
        MsaImpl msaImpl = new MsaImpl(context);
        if (msaImpl.supported()) {
            OAIDLog.print("Mobile Security Alliance has been found: " + MsaImpl.class.getName());
            return msaImpl;
        }
        GmsImpl gmsImpl = new GmsImpl(context);
        if (gmsImpl.supported()) {
            OAIDLog.print("Google Play Service has been found: " + GmsImpl.class.getName());
            return gmsImpl;
        }
        DefaultImpl defaultImpl = new DefaultImpl();
        OAIDLog.print("OAID/AAID was not supported: " + DefaultImpl.class.getName());
        return defaultImpl;
    }
}
