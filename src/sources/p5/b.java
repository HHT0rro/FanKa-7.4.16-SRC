package p5;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* compiled from: EventMessageEncoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f52858a;

    /* renamed from: b, reason: collision with root package name */
    public final DataOutputStream f52859b;

    public b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f52858a = byteArrayOutputStream;
        this.f52859b = new DataOutputStream(byteArrayOutputStream);
    }

    public static void b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(EventMessage eventMessage) {
        this.f52858a.reset();
        try {
            b(this.f52859b, eventMessage.schemeIdUri);
            String str = eventMessage.value;
            if (str == null) {
                str = "";
            }
            b(this.f52859b, str);
            this.f52859b.writeLong(eventMessage.durationMs);
            this.f52859b.writeLong(eventMessage.f20860id);
            this.f52859b.write(eventMessage.messageData);
            this.f52859b.flush();
            return this.f52858a.toByteArray();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
