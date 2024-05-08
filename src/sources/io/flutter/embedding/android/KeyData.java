package io.flutter.embedding.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class KeyData {
    private static final int BYTES_PER_FIELD = 8;
    public static final String CHANNEL = "flutter/keydata";
    private static final int FIELD_COUNT = 6;
    private static final String TAG = "KeyData";

    @Nullable
    public String character;
    public DeviceType deviceType;
    public long logicalKey;
    public long physicalKey;
    public boolean synthesized;
    public long timestamp;
    public Type type;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum DeviceType {
        kKeyboard(0),
        kDirectionalPad(1),
        kGamepad(2),
        kJoystick(3),
        kHdmi(4);

        private final long value;

        DeviceType(long j10) {
            this.value = j10;
        }

        public static DeviceType fromLong(long j10) {
            int i10 = (int) j10;
            if (i10 == 0) {
                return kKeyboard;
            }
            if (i10 == 1) {
                return kDirectionalPad;
            }
            if (i10 == 2) {
                return kGamepad;
            }
            if (i10 == 3) {
                return kJoystick;
            }
            if (i10 == 4) {
                return kHdmi;
            }
            throw new AssertionError((Object) "Unexpected DeviceType value");
        }

        public long getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum Type {
        kDown(0),
        kUp(1),
        kRepeat(2);

        private long value;

        Type(long j10) {
            this.value = j10;
        }

        public static Type fromLong(long j10) {
            int i10 = (int) j10;
            if (i10 == 0) {
                return kDown;
            }
            if (i10 == 1) {
                return kUp;
            }
            if (i10 == 2) {
                return kRepeat;
            }
            throw new AssertionError((Object) "Unexpected Type value");
        }

        public long getValue() {
            return this.value;
        }
    }

    public KeyData() {
    }

    public ByteBuffer toBytes() {
        try {
            String str = this.character;
            byte[] bytes = str == null ? null : str.getBytes("UTF-8");
            int length = bytes == null ? 0 : bytes.length;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(length + 56);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.putLong(length);
            allocateDirect.putLong(this.timestamp);
            allocateDirect.putLong(this.type.getValue());
            allocateDirect.putLong(this.physicalKey);
            allocateDirect.putLong(this.logicalKey);
            allocateDirect.putLong(this.synthesized ? 1L : 0L);
            allocateDirect.putLong(this.deviceType.getValue());
            if (bytes != null) {
                allocateDirect.put(bytes);
            }
            return allocateDirect;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError((Object) "UTF-8 not supported");
        }
    }

    public KeyData(@NonNull ByteBuffer byteBuffer) {
        long j10 = byteBuffer.getLong();
        this.timestamp = byteBuffer.getLong();
        this.type = Type.fromLong(byteBuffer.getLong());
        this.physicalKey = byteBuffer.getLong();
        this.logicalKey = byteBuffer.getLong();
        this.synthesized = byteBuffer.getLong() != 0;
        this.deviceType = DeviceType.fromLong(byteBuffer.getLong());
        if (byteBuffer.remaining() == j10) {
            this.character = null;
            if (j10 != 0) {
                int i10 = (int) j10;
                byte[] bArr = new byte[i10];
                byteBuffer.get(bArr, 0, i10);
                try {
                    this.character = new String(bArr, "UTF-8");
                    return;
                } catch (UnsupportedEncodingException unused) {
                    throw new AssertionError((Object) "UTF-8 unsupported");
                }
            }
            return;
        }
        throw new AssertionError((Object) String.format("Unexpected char length: charSize is %d while buffer has position %d, capacity %d, limit %d", Long.valueOf(j10), Integer.valueOf(byteBuffer.position()), Integer.valueOf(byteBuffer.capacity()), Integer.valueOf(byteBuffer.limit())));
    }
}
