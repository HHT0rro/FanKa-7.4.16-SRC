package com.android.internal.content;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.PatternMatcher;
import android.os.UserHandle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IPackageMonitorExt {
    public static final int OVERRIDE_METHOD_BEGIN_PACKAGE_CHANGES = 1;
    public static final int OVERRIDE_METHOD_FINISH_PACKAGES_CHANGES = 20;
    public static final int OVERRIDE_METHOD_HANDLE_FORCE_STOP = 12;
    public static final int OVERRIDE_METHOD_HANDLE_USER_STOP = 14;
    public static final int OVERRIDE_METHOD_PACKAGES_AVAILABLE = 15;
    public static final int OVERRIDE_METHOD_PACKAGES_SUSPENDED = 17;
    public static final int OVERRIDE_METHOD_PACKAGES_UNAVAILABLE = 16;
    public static final int OVERRIDE_METHOD_PACKAGES_UNSUSPENDED = 18;
    public static final int OVERRIDE_METHOD_PACKAGE_ADDED = 2;
    public static final int OVERRIDE_METHOD_PACKAGE_APPEARED = 4;
    public static final int OVERRIDE_METHOD_PACKAGE_CHANGED = 10;
    public static final int OVERRIDE_METHOD_PACKAGE_DATA_CLEARED = 11;
    public static final int OVERRIDE_METHOD_PACKAGE_DISAPPEARED = 9;
    public static final int OVERRIDE_METHOD_PACKAGE_MODIFIED = 5;
    public static final int OVERRIDE_METHOD_PACKAGE_REMOVED = 7;
    public static final int OVERRIDE_METHOD_PACKAGE_REMOVED_ALL_USERS = 8;
    public static final int OVERRIDE_METHOD_PACKAGE_UPDATE_FINISHED = 3;
    public static final int OVERRIDE_METHOD_PACKAGE_UPDATE_STARTED = 6;
    public static final int OVERRIDE_METHOD_SOME_PACKAGES_CHANGED = 19;
    public static final int OVERRIDE_METHOD_UID_REMOVED = 13;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface OverrideMethod {
    }

    default void init(Context context) {
    }

    default void register(Context context, Looper thread, UserHandle user, boolean externalStorage, int[] callbackMethods) {
    }

    default void register(Context context, Looper thread, UserHandle user, boolean externalStorage, int[] callbackMethods, PatternMatcher ssp) {
    }

    default void register(Context context, UserHandle user, boolean externalStorage, Handler handler, int[] callbackMethods) {
    }

    default void register(Context context, UserHandle user, boolean externalStorage, Handler handler, int[] callbackMethods, PatternMatcher ssp) {
    }
}
