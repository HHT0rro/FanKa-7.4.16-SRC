package io.flutter.plugin.common;

import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.plugin.common.MethodChannel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ErrorLogResult implements MethodChannel.Result {
    private int level;
    private String tag;

    public ErrorLogResult(String str) {
        this(str, Log.WARN);
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public void error(String str, @Nullable String str2, @Nullable Object obj) {
        String str3;
        if (obj != null) {
            str3 = " details: " + obj;
        } else {
            str3 = "";
        }
        int i10 = this.level;
        if (i10 < Log.WARN) {
            return;
        }
        Log.println(i10, this.tag, str2 + str3);
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public void notImplemented() {
        int i10 = this.level;
        if (i10 < Log.WARN) {
            return;
        }
        Log.println(i10, this.tag, "method not implemented");
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public void success(@Nullable Object obj) {
    }

    public ErrorLogResult(String str, int i10) {
        this.tag = str;
        this.level = i10;
    }
}
