package androidx.core.net;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ParseException extends RuntimeException {

    @NonNull
    public final String response;

    public ParseException(@NonNull String str) {
        super(str);
        this.response = str;
    }
}
