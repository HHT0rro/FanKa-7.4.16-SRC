package com.jd.ad.sdk.jad_sb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_an implements Closeable {

    @NonNull
    public final HttpURLConnection jad_an;

    public jad_an(@NonNull HttpURLConnection httpURLConnection) {
        this.jad_an = httpURLConnection;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.jad_an.disconnect();
    }

    @Nullable
    public String jad_bo() {
        try {
            if (jad_cp()) {
                return null;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to fetch ");
            sb2.append((Object) this.jad_an.getURL());
            sb2.append(". Failed with ");
            sb2.append(this.jad_an.getResponseCode());
            sb2.append("\n");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.jad_an.getErrorStream()));
            StringBuilder sb3 = new StringBuilder();
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb3.append(readLine);
                        sb3.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } finally {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused2) {
                    }
                }
            }
            sb2.append(sb3.toString());
            return sb2.toString();
        } catch (IOException e2) {
            com.jd.ad.sdk.jad_ve.jad_dq.jad_an("get error failed ", e2);
            return e2.getMessage();
        }
    }

    public boolean jad_cp() {
        try {
            return this.jad_an.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }
}
