package retrofit2;

import java.io.IOException;
import okhttp3.Request;

/* compiled from: Call.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface b<T> extends Cloneable {
    void b(d<T> dVar);

    void cancel();

    /* renamed from: clone */
    b<T> mo3754clone();

    Response<T> execute() throws IOException;

    boolean isCanceled();

    Request request();
}
