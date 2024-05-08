package com.google.android.gms.internal.vision;

import com.alibaba.security.common.track.model.TrackConstants;
import com.google.android.gms.internal.vision.l4;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class u4<T extends l4> {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f25650a = Logger.getLogger(zzii.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static String f25651b = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    public static <T extends l4> T b(Class<T> cls) {
        String format;
        ClassLoader classLoader = u4.class.getClassLoader();
        if (cls.equals(l4.class)) {
            format = f25651b;
        } else if (cls.getPackage().equals(u4.class.getPackage())) {
            format = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        } else {
            throw new IllegalArgumentException(cls.getName());
        }
        try {
            try {
                try {
                    try {
                        return cls.cast(((u4) Class.forName(format, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).a());
                    } catch (InstantiationException e2) {
                        throw new IllegalStateException(e2);
                    } catch (NoSuchMethodException e10) {
                        throw new IllegalStateException(e10);
                    }
                } catch (InvocationTargetException e11) {
                    throw new IllegalStateException(e11);
                }
            } catch (IllegalAccessException e12) {
                throw new IllegalStateException(e12);
            }
        } catch (ClassNotFoundException unused) {
            Iterator iterator2 = ServiceLoader.load(u4.class, classLoader).iterator2();
            ArrayList arrayList = new ArrayList();
            while (iterator2.hasNext()) {
                try {
                    arrayList.add(cls.cast(((u4) iterator2.next()).a()));
                } catch (ServiceConfigurationError e13) {
                    Logger logger = f25650a;
                    Level level = Level.SEVERE;
                    String simpleName = cls.getSimpleName();
                    logger.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", TrackConstants.Method.LOAD, simpleName.length() != 0 ? "Unable to load ".concat(simpleName) : new String("Unable to load "), (Throwable) e13);
                }
            }
            if (arrayList.size() == 1) {
                return (T) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (T) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e14) {
                throw new IllegalStateException(e14);
            } catch (NoSuchMethodException e15) {
                throw new IllegalStateException(e15);
            } catch (InvocationTargetException e16) {
                throw new IllegalStateException(e16);
            }
        }
    }

    public abstract T a();
}
