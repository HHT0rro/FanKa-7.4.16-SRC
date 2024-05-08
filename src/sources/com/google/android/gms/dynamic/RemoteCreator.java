package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.h;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class RemoteCreator<T> {

    /* renamed from: a, reason: collision with root package name */
    public final String f23762a;

    /* renamed from: b, reason: collision with root package name */
    public T f23763b;

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(@RecentlyNonNull String str) {
            super(str);
        }

        public RemoteCreatorException(@RecentlyNonNull String str, @RecentlyNonNull Throwable th) {
            super(str, th);
        }
    }

    public RemoteCreator(@RecentlyNonNull String str) {
        this.f23762a = str;
    }

    @RecentlyNonNull
    public abstract T a(@RecentlyNonNull IBinder iBinder);

    @RecentlyNonNull
    public final T b(@RecentlyNonNull Context context) throws RemoteCreatorException {
        if (this.f23763b == null) {
            h.h(context);
            Context c4 = d.c(context);
            if (c4 != null) {
                try {
                    this.f23763b = a((IBinder) c4.getClassLoader().loadClass(this.f23762a).newInstance());
                } catch (ClassNotFoundException e2) {
                    throw new RemoteCreatorException("Could not load creator class.", e2);
                } catch (IllegalAccessException e10) {
                    throw new RemoteCreatorException("Could not access creator.", e10);
                } catch (InstantiationException e11) {
                    throw new RemoteCreatorException("Could not instantiate creator.", e11);
                }
            } else {
                throw new RemoteCreatorException("Could not get remote context.");
            }
        }
        return this.f23763b;
    }
}
