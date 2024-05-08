package okhttp3.internal.ws;

import java.io.IOException;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import kotlin.text.p;
import okhttp3.Headers;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WebSocketExtensions.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";

    @Nullable
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;

    @Nullable
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    /* compiled from: WebSocketExtensions.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final WebSocketExtensions parse(@NotNull Headers responseHeaders) throws IOException {
            s.i(responseHeaders, "responseHeaders");
            int size = responseHeaders.size();
            boolean z10 = false;
            Integer num = null;
            boolean z11 = false;
            Integer num2 = null;
            boolean z12 = false;
            boolean z13 = false;
            for (int i10 = 0; i10 < size; i10++) {
                if (p.r(responseHeaders.name(i10), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, true)) {
                    String value = responseHeaders.value(i10);
                    int i11 = 0;
                    while (i11 < value.length()) {
                        int delimiterOffset$default = Util.delimiterOffset$default(value, ',', i11, 0, 4, (Object) null);
                        int delimiterOffset = Util.delimiterOffset(value, ';', i11, delimiterOffset$default);
                        String trimSubstring = Util.trimSubstring(value, i11, delimiterOffset);
                        int i12 = delimiterOffset + 1;
                        if (p.r(trimSubstring, "permessage-deflate", true)) {
                            if (z10) {
                                z13 = true;
                            }
                            while (i12 < delimiterOffset$default) {
                                int delimiterOffset2 = Util.delimiterOffset(value, ';', i12, delimiterOffset$default);
                                int delimiterOffset3 = Util.delimiterOffset(value, '=', i12, delimiterOffset2);
                                String trimSubstring2 = Util.trimSubstring(value, i12, delimiterOffset3);
                                String r02 = delimiterOffset3 < delimiterOffset2 ? StringsKt__StringsKt.r0(Util.trimSubstring(value, delimiterOffset3 + 1, delimiterOffset2), "\"") : null;
                                int i13 = delimiterOffset2 + 1;
                                if (p.r(trimSubstring2, "client_max_window_bits", true)) {
                                    if (num != null) {
                                        z13 = true;
                                    }
                                    num = r02 != null ? o.j(r02) : null;
                                    if (num != null) {
                                        i12 = i13;
                                    }
                                    z13 = true;
                                    i12 = i13;
                                } else {
                                    if (p.r(trimSubstring2, "client_no_context_takeover", true)) {
                                        if (z11) {
                                            z13 = true;
                                        }
                                        if (r02 != null) {
                                            z13 = true;
                                        }
                                        z11 = true;
                                    } else if (p.r(trimSubstring2, "server_max_window_bits", true)) {
                                        if (num2 != null) {
                                            z13 = true;
                                        }
                                        num2 = r02 != null ? o.j(r02) : null;
                                        if (num2 != null) {
                                        }
                                        z13 = true;
                                    } else {
                                        if (p.r(trimSubstring2, "server_no_context_takeover", true)) {
                                            if (z12) {
                                                z13 = true;
                                            }
                                            if (r02 != null) {
                                                z13 = true;
                                            }
                                            z12 = true;
                                        }
                                        z13 = true;
                                    }
                                    i12 = i13;
                                }
                            }
                            i11 = i12;
                            z10 = true;
                        } else {
                            i11 = i12;
                            z13 = true;
                        }
                    }
                }
            }
            return new WebSocketExtensions(z10, num, z11, num2, z12, z13);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public WebSocketExtensions(boolean z10, @Nullable Integer num, boolean z11, @Nullable Integer num2, boolean z12, boolean z13) {
        this.perMessageDeflate = z10;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z11;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z12;
        this.unknownValues = z13;
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z10, Integer num, boolean z11, Integer num2, boolean z12, boolean z13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = webSocketExtensions.perMessageDeflate;
        }
        if ((i10 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i10 & 4) != 0) {
            z11 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z14 = z11;
        if ((i10 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i10 & 16) != 0) {
            z12 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z15 = z12;
        if ((i10 & 32) != 0) {
            z13 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z10, num3, z14, num4, z15, z13);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    @Nullable
    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    @Nullable
    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    @NotNull
    public final WebSocketExtensions copy(boolean z10, @Nullable Integer num, boolean z11, @Nullable Integer num2, boolean z12, boolean z13) {
        return new WebSocketExtensions(z10, num, z11, num2, z12, z13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && s.d(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && s.d(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        boolean z10 = this.perMessageDeflate;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        Integer num = this.clientMaxWindowBits;
        int hashCode = (i10 + (num != null ? num.hashCode() : 0)) * 31;
        ?? r22 = this.clientNoContextTakeover;
        int i11 = r22;
        if (r22 != 0) {
            i11 = 1;
        }
        int i12 = (hashCode + i11) * 31;
        Integer num2 = this.serverMaxWindowBits;
        int hashCode2 = (i12 + (num2 != null ? num2.hashCode() : 0)) * 31;
        ?? r23 = this.serverNoContextTakeover;
        int i13 = r23;
        if (r23 != 0) {
            i13 = 1;
        }
        int i14 = (hashCode2 + i13) * 31;
        boolean z11 = this.unknownValues;
        return i14 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final boolean noContextTakeover(boolean z10) {
        if (z10) {
            return this.clientNoContextTakeover;
        }
        return this.serverNoContextTakeover;
    }

    @NotNull
    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + ((Object) this.clientMaxWindowBits) + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + ((Object) this.serverMaxWindowBits) + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ")";
    }

    public /* synthetic */ WebSocketExtensions(boolean z10, Integer num, boolean z11, Integer num2, boolean z12, boolean z13, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? false : z11, (i10 & 8) == 0 ? num2 : null, (i10 & 16) != 0 ? false : z12, (i10 & 32) != 0 ? false : z13);
    }
}
