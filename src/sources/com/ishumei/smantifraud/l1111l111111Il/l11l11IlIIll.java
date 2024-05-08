package com.ishumei.smantifraud.l1111l111111Il;

import android.text.TextUtils;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l11l11IlIIll implements Runnable {
    private static String l1111l111111Il = "sm-async-thread";
    private static final String l111l11111I1l = "POST";
    private static final int l111l11111Il = 3;
    private static Executor l111l11111lIl = new ThreadPoolExecutor(0, 4, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(20), new ThreadFactory() { // from class: com.ishumei.smantifraud.l1111l111111Il.l11l11IlIIll.1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "sm-async-thread");
        }
    }, new ThreadPoolExecutor.DiscardOldestPolicy());
    private static final int[] l111l1111l1Il = {2000, 5000, 15000, 30000};
    private String l111l1111lI1l;
    private l111l11111Il l111l1111lIl;
    private String l111l1111llIl;
    private int l11l1111lIIl;

    private l11l11IlIIll(String str, String str2, l111l11111Il l111l11111il) {
        this.l111l1111lI1l = str;
        this.l111l1111llIl = str2;
        this.l111l1111lIl = l111l11111il;
    }

    public static void l1111l111111Il(String str, String str2, l111l11111Il l111l11111il) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || l111l11111il == null || !l111l11111il.l111l1111lI1l()) {
            return;
        }
        l111l11111lIl.execute(new l11l11IlIIll(str, str2, l111l11111il));
    }

    @Override // java.lang.Runnable
    public final void run() {
        InputStream inputStream;
        OutputStream outputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        try {
            JSONObject jSONObject = new JSONObject(this.l111l1111llIl);
            jSONObject.put("retry", 1);
            String jSONObject2 = jSONObject.toString();
            while (!com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l111l1111l1Il) {
                HttpURLConnection httpURLConnection = null;
                r3 = null;
                r3 = null;
                InputStream inputStream4 = null;
                HttpURLConnection httpURLConnection2 = null;
                HttpURLConnection httpURLConnection3 = null;
                try {
                    Thread.sleep(this.l11l1111lIIl >= 3 ? l111l1111l1Il[3] : l111l1111l1Il[r5 % 3]);
                } catch (InterruptedException unused) {
                    inputStream3 = null;
                    outputStream = null;
                } catch (Exception unused2) {
                    inputStream2 = null;
                    outputStream = null;
                } catch (Throwable th) {
                    th = th;
                    inputStream = null;
                    outputStream = null;
                }
                if (this.l111l1111lIl.l111l11111lIl() >= 0 && this.l11l1111lIIl > this.l111l1111lIl.l111l11111lIl()) {
                    this.l11l1111lIIl++;
                    return;
                }
                HttpURLConnection httpURLConnection4 = (HttpURLConnection) new URL(this.l111l1111lI1l).openConnection();
                try {
                    httpURLConnection4.setDoInput(true);
                    httpURLConnection4.setDoOutput(true);
                    httpURLConnection4.setUseCaches(false);
                    httpURLConnection4.setInstanceFollowRedirects(true);
                    httpURLConnection4.setRequestMethod("POST");
                    httpURLConnection4.setRequestProperty("Content-Type", "application/octet-stream");
                    httpURLConnection4.setRequestProperty(HttpHeaders.HEAD_KEY_CONNECTION, "Close");
                    httpURLConnection4.setConnectTimeout(30000);
                    httpURLConnection4.setReadTimeout(30000);
                    httpURLConnection4.setFixedLengthStreamingMode(jSONObject2.getBytes().length);
                    httpURLConnection4.connect();
                    outputStream = httpURLConnection4.getOutputStream();
                    try {
                        outputStream.write(jSONObject2.getBytes());
                        outputStream.flush();
                        if (httpURLConnection4.getResponseCode() != 200) {
                            this.l11l1111lIIl++;
                            try {
                                httpURLConnection4.disconnect();
                                outputStream.close();
                            } catch (Exception unused3) {
                            }
                        } else {
                            inputStream4 = httpURLConnection4.getInputStream();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream4));
                            StringBuilder sb2 = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                } else {
                                    sb2.append(readLine);
                                }
                            }
                            JSONObject jSONObject3 = new JSONObject(sb2.toString());
                            if (jSONObject3.optInt("code") == 1902) {
                                this.l11l1111lIIl++;
                                try {
                                    httpURLConnection4.disconnect();
                                    outputStream.close();
                                    if (inputStream4 != null) {
                                        inputStream4.close();
                                        return;
                                    }
                                    return;
                                } catch (Exception unused4) {
                                    return;
                                }
                            }
                            if (jSONObject3.has("detail")) {
                                JSONObject optJSONObject = jSONObject3.optJSONObject("detail");
                                if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.optString("deviceId"))) {
                                    com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.l1111l111111Il().l1111l111111Il(optJSONObject.optString("deviceId"), true);
                                    this.l11l1111lIIl++;
                                    try {
                                        httpURLConnection4.disconnect();
                                        outputStream.close();
                                        if (inputStream4 != null) {
                                            inputStream4.close();
                                            return;
                                        }
                                        return;
                                    } catch (Exception unused5) {
                                        return;
                                    }
                                }
                                this.l11l1111lIIl++;
                                httpURLConnection4.disconnect();
                                outputStream.close();
                                if (inputStream4 != null) {
                                }
                            } else {
                                this.l11l1111lIIl++;
                                httpURLConnection4.disconnect();
                                outputStream.close();
                                if (inputStream4 != null) {
                                }
                            }
                            inputStream4.close();
                        }
                    } catch (InterruptedException unused6) {
                        inputStream3 = inputStream4;
                        httpURLConnection2 = httpURLConnection4;
                        this.l11l1111lIIl++;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream3 != null) {
                            inputStream3.close();
                            return;
                        }
                        return;
                    } catch (Exception unused7) {
                        inputStream2 = inputStream4;
                        httpURLConnection3 = httpURLConnection4;
                        this.l11l1111lIIl++;
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream4;
                        httpURLConnection = httpURLConnection4;
                        this.l11l1111lIIl++;
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused8) {
                                throw th;
                            }
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (InterruptedException unused9) {
                    inputStream3 = null;
                    outputStream = null;
                } catch (Exception unused10) {
                    outputStream = null;
                    httpURLConnection3 = httpURLConnection4;
                    inputStream2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    outputStream = null;
                }
            }
        } catch (Exception unused11) {
        }
    }
}
