package okhttp3;

import java.io.IOException;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Protocol.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    public static final Companion Companion = new Companion(null);
    private final String protocol;

    /* compiled from: Protocol.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Protocol get(@NotNull String protocol) throws IOException {
            s.i(protocol, "protocol");
            Protocol protocol2 = Protocol.HTTP_1_0;
            if (!s.d(protocol, protocol2.protocol)) {
                protocol2 = Protocol.HTTP_1_1;
                if (!s.d(protocol, protocol2.protocol)) {
                    protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!s.d(protocol, protocol2.protocol)) {
                        protocol2 = Protocol.HTTP_2;
                        if (!s.d(protocol, protocol2.protocol)) {
                            protocol2 = Protocol.SPDY_3;
                            if (!s.d(protocol, protocol2.protocol)) {
                                protocol2 = Protocol.QUIC;
                                if (!s.d(protocol, protocol2.protocol)) {
                                    throw new IOException("Unexpected protocol: " + protocol);
                                }
                            }
                        }
                    }
                }
            }
            return protocol2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    Protocol(String str) {
        this.protocol = str;
    }

    @NotNull
    public static final Protocol get(@NotNull String str) throws IOException {
        return Companion.get(str);
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.protocol;
    }
}
