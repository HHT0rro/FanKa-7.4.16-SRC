package jdk.net;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SocketFlow {
    private static final int ALREADY_CREATED_VALUE = 5;
    public static final int HIGH_PRIORITY = 2;
    private static final int IN_PROGRESS_VALUE = 6;
    public static final int NORMAL_PRIORITY = 1;
    private static final int NOT_CONNECTED_VALUE = 3;
    private static final int NOT_SUPPORTED_VALUE = 4;
    private static final int NO_PERMISSION_VALUE = 2;
    private static final int NO_STATUS_VALUE = 0;
    private static final int OK_VALUE = 1;
    private static final int OTHER_VALUE = 7;
    public static final int UNSET = -1;
    private int priority = 1;
    private long bandwidth = -1;
    private Status status = Status.NO_STATUS;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum Status {
        NO_STATUS(0),
        OK(1),
        NO_PERMISSION(2),
        NOT_CONNECTED(3),
        NOT_SUPPORTED(4),
        ALREADY_CREATED(5),
        IN_PROGRESS(6),
        OTHER(7);

        private final int value;

        Status(int value) {
            this.value = value;
        }

        static Status from(int value) {
            Status status = NO_STATUS;
            if (value == status.value) {
                return status;
            }
            Status status2 = OK;
            if (value == status2.value) {
                return status2;
            }
            Status status3 = NO_PERMISSION;
            if (value == status3.value) {
                return status3;
            }
            Status status4 = NOT_CONNECTED;
            if (value == status4.value) {
                return status4;
            }
            Status status5 = NOT_SUPPORTED;
            if (value == status5.value) {
                return status5;
            }
            Status status6 = ALREADY_CREATED;
            if (value == status6.value) {
                return status6;
            }
            Status status7 = IN_PROGRESS;
            if (value == status7.value) {
                return status7;
            }
            Status status8 = OTHER;
            if (value == status8.value) {
                return status8;
            }
            throw new InternalError("Unknown value: " + value);
        }
    }

    public static SocketFlow create() {
        return new SocketFlow();
    }

    private SocketFlow() {
    }

    public SocketFlow priority(int priority) {
        if (priority != 1 && priority != 2) {
            throw new IllegalArgumentException("invalid priority :" + priority);
        }
        this.priority = priority;
        return this;
    }

    public SocketFlow bandwidth(long bandwidth) {
        if (bandwidth < 0) {
            throw new IllegalArgumentException("invalid bandwidth: " + bandwidth);
        }
        this.bandwidth = bandwidth;
        return this;
    }

    public int priority() {
        return this.priority;
    }

    public long bandwidth() {
        return this.bandwidth;
    }

    public Status status() {
        return this.status;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void status(int status) {
        this.status = Status.from(status);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(super.toString());
        sb2.append(" [ priority=").append(priority()).append(", bandwidth=").append(bandwidth()).append(", status=").append((Object) status()).append(" ]");
        return sb2.toString();
    }
}
