package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class p {
    private static String aOL = "";
    private static String aOM = "";
    private static String aON = "";

    private static String a(String str, InputStream inputStream) {
        String gn;
        synchronized (p.class) {
            com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
            oVar.Kh();
            gn = oVar.Kg().gn(str);
            oVar.end();
        }
        return gn;
    }

    public static String dY(int i10) {
        Context KO = ServiceProvider.KO();
        String str = aOL;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        TextUtils.isEmpty("aes_key");
        InputStream inputStream = null;
        try {
            try {
                inputStream = KO.getResources().getAssets().open("ksad_common_encrypt_image.png");
            } catch (Throwable th) {
                new StringBuilder("EncryptUtils getKey get InputStream from loader is null,  e: ").append(th);
            }
            if (inputStream == null) {
                inputStream = KO.getAssets().open("ksad_common_encrypt_image.png");
            }
            String a10 = a("aes_key", inputStream);
            TextUtils.isEmpty(a10);
            aOL = a10;
            return a10;
        } catch (Throwable unused) {
            return "";
        }
    }
}
