package com.mobile.auth.c;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.realidentity.http.BaseHttpManager;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import sun.security.util.SecurityConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        InputStream inputStream2;
        String str3 = "";
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestProperty(SecurityConstants.SOCKET_ACCEPT_ACTION, "*/*");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.addRequestProperty(BaseHttpManager.HTTP_REQ_PROPERTY_CHARSET, "UTF-8");
                if (TextUtils.isEmpty(str2)) {
                    httpURLConnection.connect();
                } else {
                    DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream()));
                    dataOutputStream.write(str2.getBytes("UTF-8"));
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream2 = httpURLConnection.getInputStream();
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb2.append(readLine);
                                sb2.append("\n");
                            } catch (Throwable th) {
                                th = th;
                                Throwable th2 = th;
                                inputStream = inputStream2;
                                th = th2;
                                try {
                                    th.printStackTrace();
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            return str3;
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    return str3;
                                } finally {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                }
                            }
                        }
                        str3 = sb2.toString();
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                    }
                } else {
                    inputStream2 = null;
                    bufferedReader = null;
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e11) {
                        e = e11;
                        e.printStackTrace();
                        return str3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                bufferedReader = null;
            }
            return str3;
        } catch (Throwable th5) {
            try {
                ExceptionProcessor.processException(th5);
                return null;
            } catch (Throwable th6) {
                ExceptionProcessor.processException(th6);
                return null;
            }
        }
    }
}
