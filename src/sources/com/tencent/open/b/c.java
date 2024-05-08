package com.tencent.open.b;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.open.log.SLog;
import com.tencent.open.web.security.SecureJsInterface;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c extends b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f45200a;

    /* renamed from: b, reason: collision with root package name */
    private KeyEvent f45201b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.open.web.security.a f45202c;

    public c(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int unicodeChar;
        SLog.d("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + f45200a);
        if (!f45200a) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 4) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyCode == 66) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyCode != 67) {
                if (keyEvent.getUnicodeChar() == 0) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (SecureJsInterface.isPWDEdit && (((unicodeChar = keyEvent.getUnicodeChar()) >= 33 && unicodeChar <= 95) || (unicodeChar >= 97 && unicodeChar <= 125))) {
                    KeyEvent keyEvent2 = new KeyEvent(0, 17);
                    this.f45201b = keyEvent2;
                    return super.dispatchKeyEvent(keyEvent2);
                }
                return super.dispatchKeyEvent(keyEvent);
            }
            com.tencent.open.web.security.a.f45334b = true;
            return super.dispatchKeyEvent(keyEvent);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        SLog.i("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + SecureJsInterface.isPWDEdit);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        SLog.v("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + ((Object) onCreateInputConnection));
        if (onCreateInputConnection != null) {
            f45200a = true;
            com.tencent.open.web.security.a aVar = new com.tencent.open.web.security.a(super.onCreateInputConnection(editorInfo), false);
            this.f45202c = aVar;
            return aVar;
        }
        f45200a = false;
        return onCreateInputConnection;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        int unicodeChar;
        SLog.d("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + f45200a);
        if (!f45200a) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 4) {
                return super.onKeyDown(i10, keyEvent);
            }
            if (keyCode == 66) {
                return super.onKeyDown(i10, keyEvent);
            }
            if (keyCode != 67) {
                if (keyEvent.getUnicodeChar() == 0) {
                    return super.onKeyDown(i10, keyEvent);
                }
                if (SecureJsInterface.isPWDEdit && (((unicodeChar = keyEvent.getUnicodeChar()) >= 33 && unicodeChar <= 95) || (unicodeChar >= 97 && unicodeChar <= 125))) {
                    KeyEvent keyEvent2 = new KeyEvent(0, 17);
                    this.f45201b = keyEvent2;
                    return super.onKeyDown(keyEvent2.getKeyCode(), this.f45201b);
                }
                return super.onKeyDown(i10, keyEvent);
            }
            com.tencent.open.web.security.a.f45334b = true;
            return super.onKeyDown(i10, keyEvent);
        }
        return super.onKeyDown(i10, keyEvent);
    }
}
