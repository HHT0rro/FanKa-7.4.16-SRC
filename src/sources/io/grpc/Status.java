package io.grpc;

import com.google.common.base.c;
import com.google.common.base.j;
import com.google.common.base.l;
import com.google.common.base.o;
import com.google.common.base.u;
import io.grpc.Metadata;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Status {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Metadata.Key<Status> CODE_KEY;
    public static final Metadata.Key<String> MESSAGE_KEY;
    private static final Metadata.TrustedAsciiMarshaller<String> STATUS_MESSAGE_MARSHALLER;
    private final Throwable cause;
    private final Code code;
    private final String description;
    private static final String TEST_EQUALS_FAILURE_PROPERTY = "io.grpc.Status.failOnEqualsForTest";
    private static final boolean FAIL_ON_EQUALS_FOR_TEST = Boolean.parseBoolean(System.getProperty(TEST_EQUALS_FAILURE_PROPERTY, "false"));
    private static final List<Status> STATUS_LIST = buildStatusList();
    public static final Status OK = Code.OK.toStatus();
    public static final Status CANCELLED = Code.CANCELLED.toStatus();
    public static final Status UNKNOWN = Code.UNKNOWN.toStatus();
    public static final Status INVALID_ARGUMENT = Code.INVALID_ARGUMENT.toStatus();
    public static final Status DEADLINE_EXCEEDED = Code.DEADLINE_EXCEEDED.toStatus();
    public static final Status NOT_FOUND = Code.NOT_FOUND.toStatus();
    public static final Status ALREADY_EXISTS = Code.ALREADY_EXISTS.toStatus();
    public static final Status PERMISSION_DENIED = Code.PERMISSION_DENIED.toStatus();
    public static final Status UNAUTHENTICATED = Code.UNAUTHENTICATED.toStatus();
    public static final Status RESOURCE_EXHAUSTED = Code.RESOURCE_EXHAUSTED.toStatus();
    public static final Status FAILED_PRECONDITION = Code.FAILED_PRECONDITION.toStatus();
    public static final Status ABORTED = Code.ABORTED.toStatus();
    public static final Status OUT_OF_RANGE = Code.OUT_OF_RANGE.toStatus();
    public static final Status UNIMPLEMENTED = Code.UNIMPLEMENTED.toStatus();
    public static final Status INTERNAL = Code.INTERNAL.toStatus();
    public static final Status UNAVAILABLE = Code.UNAVAILABLE.toStatus();
    public static final Status DATA_LOSS = Code.DATA_LOSS.toStatus();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum Code {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);

        private final int value;
        private final byte[] valueAscii;

        Code(int i10) {
            this.value = i10;
            this.valueAscii = Integer.toString(i10).getBytes(c.f25959a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] valueAscii() {
            return this.valueAscii;
        }

        public Status toStatus() {
            return (Status) Status.STATUS_LIST.get(this.value);
        }

        public int value() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class StatusCodeMarshaller implements Metadata.TrustedAsciiMarshaller<Status> {
        private StatusCodeMarshaller() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public Status parseAsciiString(byte[] bArr) {
            return Status.fromCodeValue(bArr);
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public byte[] toAsciiString(Status status) {
            return status.getCode().valueAscii();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class StatusMessageMarshaller implements Metadata.TrustedAsciiMarshaller<String> {
        private static final byte[] HEX = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

        private StatusMessageMarshaller() {
        }

        private static boolean isEscapingChar(byte b4) {
            return b4 < 32 || b4 >= 126 || b4 == 37;
        }

        private static String parseAsciiStringSlow(byte[] bArr) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
            int i10 = 0;
            while (i10 < bArr.length) {
                if (bArr[i10] == 37 && i10 + 2 < bArr.length) {
                    try {
                        allocate.put((byte) Integer.parseInt(new String(bArr, i10 + 1, 2, c.f25959a), 16));
                        i10 += 3;
                    } catch (NumberFormatException unused) {
                    }
                }
                allocate.put(bArr[i10]);
                i10++;
            }
            return new String(allocate.array(), 0, allocate.position(), c.f25961c);
        }

        private static byte[] toAsciiStringSlow(byte[] bArr, int i10) {
            byte[] bArr2 = new byte[((bArr.length - i10) * 3) + i10];
            if (i10 != 0) {
                System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, i10);
            }
            int i11 = i10;
            while (i10 < bArr.length) {
                byte b4 = bArr[i10];
                if (isEscapingChar(b4)) {
                    bArr2[i11] = 37;
                    byte[] bArr3 = HEX;
                    bArr2[i11 + 1] = bArr3[(b4 >> 4) & 15];
                    bArr2[i11 + 2] = bArr3[b4 & 15];
                    i11 += 3;
                } else {
                    bArr2[i11] = b4;
                    i11++;
                }
                i10++;
            }
            return Arrays.copyOf(bArr2, i11);
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public String parseAsciiString(byte[] bArr) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                byte b4 = bArr[i10];
                if (b4 < 32 || b4 >= 126 || (b4 == 37 && i10 + 2 < bArr.length)) {
                    return parseAsciiStringSlow(bArr);
                }
            }
            return new String(bArr, 0);
        }

        @Override // io.grpc.Metadata.TrustedAsciiMarshaller
        public byte[] toAsciiString(String str) {
            byte[] bytes = str.getBytes(c.f25961c);
            for (int i10 = 0; i10 < bytes.length; i10++) {
                if (isEscapingChar(bytes[i10])) {
                    return toAsciiStringSlow(bytes, i10);
                }
            }
            return bytes;
        }
    }

    static {
        CODE_KEY = Metadata.Key.of("grpc-status", false, (Metadata.TrustedAsciiMarshaller) new StatusCodeMarshaller());
        StatusMessageMarshaller statusMessageMarshaller = new StatusMessageMarshaller();
        STATUS_MESSAGE_MARSHALLER = statusMessageMarshaller;
        MESSAGE_KEY = Metadata.Key.of("grpc-message", false, (Metadata.TrustedAsciiMarshaller) statusMessageMarshaller);
    }

    private Status(Code code) {
        this(code, null, null);
    }

    private static List<Status> buildStatusList() {
        TreeMap treeMap = new TreeMap();
        for (Code code : Code.values()) {
            Status status = (Status) treeMap.put(Integer.valueOf(code.value()), new Status(code));
            if (status != null) {
                throw new IllegalStateException("Code value duplication between " + status.getCode().name() + " & " + code.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    public static String formatThrowableMessage(Status status) {
        if (status.description == null) {
            return status.code.toString();
        }
        return ((Object) status.code) + ": " + status.description;
    }

    public static Status fromCode(Code code) {
        return code.toStatus();
    }

    public static Status fromCodeValue(int i10) {
        if (i10 >= 0) {
            List<Status> list = STATUS_LIST;
            if (i10 <= list.size()) {
                return list.get(i10);
            }
        }
        return UNKNOWN.withDescription("Unknown code " + i10);
    }

    private static Status fromCodeValueSlow(byte[] bArr) {
        int i10;
        int length = bArr.length;
        char c4 = 1;
        if (length != 1) {
            i10 = (length == 2 && bArr[0] >= 48 && bArr[0] <= 57) ? 0 + ((bArr[0] - 48) * 10) : 0;
            return UNKNOWN.withDescription("Unknown code " + new String(bArr, c.f25959a));
        }
        c4 = 0;
        if (bArr[c4] >= 48 && bArr[c4] <= 57) {
            int i11 = i10 + (bArr[c4] - 48);
            List<Status> list = STATUS_LIST;
            if (i11 < list.size()) {
                return list.get(i11);
            }
        }
        return UNKNOWN.withDescription("Unknown code " + new String(bArr, c.f25959a));
    }

    public static Status fromThrowable(Throwable th) {
        for (Throwable th2 = (Throwable) o.s(th, "t"); th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof StatusException) {
                return ((StatusException) th2).getStatus();
            }
            if (th2 instanceof StatusRuntimeException) {
                return ((StatusRuntimeException) th2).getStatus();
            }
        }
        return UNKNOWN.withCause(th);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4683")
    public static Metadata trailersFromThrowable(Throwable th) {
        for (Throwable th2 = (Throwable) o.s(th, "t"); th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof StatusException) {
                return ((StatusException) th2).getTrailers();
            }
            if (th2 instanceof StatusRuntimeException) {
                return ((StatusRuntimeException) th2).getTrailers();
            }
        }
        return null;
    }

    public StatusException asException() {
        return new StatusException(this);
    }

    public StatusRuntimeException asRuntimeException() {
        return new StatusRuntimeException(this);
    }

    public Status augmentDescription(String str) {
        if (str == null) {
            return this;
        }
        if (this.description == null) {
            return new Status(this.code, str, this.cause);
        }
        return new Status(this.code, this.description + "\n" + str, this.cause);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public Code getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isOk() {
        return Code.OK == this.code;
    }

    public String toString() {
        j.b d10 = j.c(this).d("code", this.code.name()).d("description", this.description);
        Throwable th = this.cause;
        Object obj = th;
        if (th != null) {
            obj = u.e(th);
        }
        return d10.d("cause", obj).toString();
    }

    public Status withCause(Throwable th) {
        return l.a(this.cause, th) ? this : new Status(this.code, this.description, th);
    }

    public Status withDescription(String str) {
        return l.a(this.description, str) ? this : new Status(this.code, str, this.cause);
    }

    private Status(Code code, String str, Throwable th) {
        this.code = (Code) o.s(code, "code");
        this.description = str;
        this.cause = th;
    }

    public StatusException asException(Metadata metadata) {
        return new StatusException(this, metadata);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4683")
    public StatusRuntimeException asRuntimeException(Metadata metadata) {
        return new StatusRuntimeException(this, metadata);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status fromCodeValue(byte[] bArr) {
        if (bArr.length == 1 && bArr[0] == 48) {
            return OK;
        }
        return fromCodeValueSlow(bArr);
    }
}
