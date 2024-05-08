package com.huawei.hianalytics.core.transport.net;

import android.content.Context;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.transport.ITransportHandler;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import xa.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HttpTransportHandler implements ITransportHandler {
    public static final int DEF_CODE = -108;
    public static final int HOST_ERROR = -104;
    public static final String TAG = "HttpTransportHandler";
    public String[] collectURLs;
    public HttpURLConnection connection;
    public Context context;
    public Map<String, String> headers;
    public byte[] reportData = new byte[0];

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    private void closeConnection() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    private void createConnection(String str) {
        this.connection = (HttpURLConnection) new URL(str).openConnection();
        setHttpsConn();
        this.connection.setRequestMethod("POST");
        this.connection.setConnectTimeout(15000);
        this.connection.setReadTimeout(15000);
        this.connection.setDoOutput(true);
        this.connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        this.connection.setRequestProperty("Conntent-Length", String.valueOf(this.reportData.length));
        this.connection.setRequestProperty(HttpHeaders.HEAD_KEY_CONNECTION, "close");
        Map<String, String> map = this.headers;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : this.headers.entrySet()) {
            String key = entry.getKey();
            if (key != null && !key.isEmpty()) {
                this.connection.setRequestProperty(key, URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue(), "UTF-8"));
            }
        }
    }

    private Response post(String str) {
        Throwable th;
        OutputStream outputStream;
        BufferedOutputStream bufferedOutputStream;
        Throwable th2;
        try {
            createConnection(str);
            outputStream = this.connection.getOutputStream();
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(outputStream);
        } catch (Throwable th4) {
            th = th4;
            Throwable th5 = th;
            bufferedOutputStream = null;
            th2 = th5;
            com.huawei.hianalytics.core.transport.net.a.a(bufferedOutputStream);
            com.huawei.hianalytics.core.transport.net.a.a(outputStream);
            closeConnection();
            throw th2;
        }
        try {
            bufferedOutputStream.write(this.reportData);
            bufferedOutputStream.flush();
            Response response = new Response(this.connection.getResponseCode(), readResponse());
            com.huawei.hianalytics.core.transport.net.a.a(bufferedOutputStream);
            com.huawei.hianalytics.core.transport.net.a.a(outputStream);
            closeConnection();
            return response;
        } catch (Throwable th6) {
            th2 = th6;
            com.huawei.hianalytics.core.transport.net.a.a(bufferedOutputStream);
            com.huawei.hianalytics.core.transport.net.a.a(outputStream);
            closeConnection();
            throw th2;
        }
    }

    private String readResponse() {
        InputStream inputStream;
        InputStream inputStream2;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            inputStream = this.connection.getInputStream();
        } catch (IOException e2) {
            e = e2;
            inputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream2.write(bArr, 0, read);
                    } else {
                        String byteArrayOutputStream3 = byteArrayOutputStream2.toString("UTF-8");
                        com.huawei.hianalytics.core.transport.net.a.a(byteArrayOutputStream2);
                        com.huawei.hianalytics.core.transport.net.a.a(inputStream);
                        return byteArrayOutputStream3;
                    }
                }
            } catch (IOException e10) {
                e = e10;
                byteArrayOutputStream = byteArrayOutputStream2;
                inputStream2 = inputStream;
                try {
                    HiLog.e(TAG, "IOException: " + e.getMessage());
                    com.huawei.hianalytics.core.transport.net.a.a(byteArrayOutputStream);
                    com.huawei.hianalytics.core.transport.net.a.a(inputStream2);
                    return "";
                } catch (Throwable th3) {
                    InputStream inputStream3 = inputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    th = th3;
                    inputStream = inputStream3;
                    ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream4;
                    com.huawei.hianalytics.core.transport.net.a.a(byteArrayOutputStream);
                    com.huawei.hianalytics.core.transport.net.a.a(inputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                ByteArrayOutputStream byteArrayOutputStream42 = byteArrayOutputStream2;
                th = th;
                byteArrayOutputStream = byteArrayOutputStream42;
                com.huawei.hianalytics.core.transport.net.a.a(byteArrayOutputStream);
                com.huawei.hianalytics.core.transport.net.a.a(inputStream);
                throw th;
            }
        } catch (IOException e11) {
            inputStream2 = inputStream;
            e = e11;
        } catch (Throwable th5) {
            th = th5;
            com.huawei.hianalytics.core.transport.net.a.a(byteArrayOutputStream);
            com.huawei.hianalytics.core.transport.net.a.a(inputStream);
            throw th;
        }
    }

    private void setHttpsConn() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            b bVar = null;
            try {
                bVar = b.b(this.context);
            } catch (IOException unused) {
                HiLog.e(TAG, "getSocketFactory(): IO Exception!");
            } catch (IllegalAccessException unused2) {
                HiLog.e(TAG, "getSocketFactory(): IllegalAccessException!");
            } catch (KeyStoreException unused3) {
                HiLog.e(TAG, "getSocketFactory(): Key Store exception");
            } catch (NoSuchAlgorithmException unused4) {
                HiLog.e(TAG, "getSocketFactory(): Algorithm Exception!");
            } catch (GeneralSecurityException unused5) {
                HiLog.e(TAG, "getSocketFactory(): General Security Exception");
            }
            if (bVar != null) {
                httpsURLConnection.setSSLSocketFactory(bVar);
                httpsURLConnection.setHostnameVerifier(b.f54584j);
                return;
            }
            throw new a("No ssl socket factory set");
        }
    }

    @Override // com.huawei.hianalytics.core.transport.ITransportHandler
    public Response execute() {
        String[] strArr = this.collectURLs;
        if (strArr != null && strArr.length != 0) {
            byte[] bArr = this.reportData;
            if (bArr != null && bArr.length != 0) {
                int i10 = 0;
                Response post = post(strArr[0]);
                while (post.getHttpCode() == -104) {
                    String[] strArr2 = this.collectURLs;
                    if (i10 >= strArr2.length) {
                        break;
                    }
                    i10++;
                    post = post(strArr2[i10]);
                }
                return post;
            }
            HiLog.e(TAG, "report data is empty");
            return new Response(DEF_CODE, "");
        }
        throw new UnknownHostException("collectUrls is empty");
    }

    @Override // com.huawei.hianalytics.core.transport.ITransportHandler
    public void execute(com.huawei.hianalytics.core.transport.a aVar) {
    }

    @Override // com.huawei.hianalytics.core.transport.ITransportHandler
    public Response executePublicKey() {
        String[] strArr = this.collectURLs;
        if (strArr != null && strArr.length != 0) {
            int i10 = 0;
            Response post = post(strArr[0]);
            while (post.getHttpCode() == -104) {
                String[] strArr2 = this.collectURLs;
                if (i10 >= strArr2.length) {
                    break;
                }
                i10++;
                post = post(strArr2[i10]);
            }
            return post;
        }
        throw new UnknownHostException("collectUrls is empty");
    }

    @Override // com.huawei.hianalytics.core.transport.ITransportHandler
    public void setHttpHeaders(Map<String, String> map) {
        this.headers = map;
    }

    @Override // com.huawei.hianalytics.core.transport.ITransportHandler
    public void setReportData(String str) {
    }

    @Override // com.huawei.hianalytics.core.transport.ITransportHandler
    public void setReportData(byte[] bArr) {
        this.reportData = bArr != null ? (byte[]) bArr.clone() : new byte[0];
    }

    @Override // com.huawei.hianalytics.core.transport.ITransportHandler
    public void setSSLConfig(Context context, ITransportHandler.Protocols protocols, String str, boolean z10) {
        this.context = context;
    }

    @Override // com.huawei.hianalytics.core.transport.ITransportHandler
    public void setUrls(String[] strArr) {
        this.collectURLs = strArr != null ? (String[]) strArr.clone() : null;
    }
}
