package io.grpc;

import com.google.common.base.o;
import java.util.concurrent.atomic.AtomicLong;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InternalLogId {
    private static final AtomicLong idAlloc = new AtomicLong();
    private final String details;

    /* renamed from: id, reason: collision with root package name */
    private final long f50046id;
    private final String typeName;

    public InternalLogId(String str, String str2, long j10) {
        o.s(str, "typeName");
        o.e(!str.isEmpty(), "empty type");
        this.typeName = str;
        this.details = str2;
        this.f50046id = j10;
    }

    public static InternalLogId allocate(Class<?> cls, String str) {
        return allocate(getClassName(cls), str);
    }

    private static String getClassName(Class<?> cls) {
        String simpleName = ((Class) o.s(cls, "type")).getSimpleName();
        return !simpleName.isEmpty() ? simpleName : cls.getName().substring(cls.getPackage().getName().length() + 1);
    }

    public static long getNextId() {
        return idAlloc.incrementAndGet();
    }

    public String getDetails() {
        return this.details;
    }

    public long getId() {
        return this.f50046id;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public String shortName() {
        return this.typeName + "<" + this.f50046id + ">";
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(shortName());
        if (this.details != null) {
            sb2.append(": (");
            sb2.append(this.details);
            sb2.append(')');
        }
        return sb2.toString();
    }

    public static InternalLogId allocate(String str, String str2) {
        return new InternalLogId(str, str2, getNextId());
    }
}
