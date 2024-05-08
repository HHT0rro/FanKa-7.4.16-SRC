package com.wangmai.okhttp.utils;

import android.text.TextUtils;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.model.HttpHeaders;
import com.wangmai.okhttp.model.HttpParams;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HttpUtils {
    public static Request.Builder appendHeaders(Request.Builder builder, HttpHeaders httpHeaders) {
        if (httpHeaders.headersMap.isEmpty()) {
            return builder;
        }
        Headers.Builder builder2 = new Headers.Builder();
        try {
            for (Map.Entry<String, String> entry : httpHeaders.headersMap.entrySet()) {
                builder2.add(entry.getKey(), entry.getValue());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        builder.headers(builder2.build());
        return builder;
    }

    public static <T> T checkNotNull(T t2, String str) {
        Objects.requireNonNull(t2, str);
        return t2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032 A[Catch: UnsupportedEncodingException -> 0x0076, TryCatch #0 {UnsupportedEncodingException -> 0x0076, blocks: (B:2:0x0000, B:6:0x0014, B:9:0x001b, B:10:0x0024, B:11:0x002c, B:13:0x0032, B:14:0x0042, B:16:0x0048, B:19:0x0069, B:23:0x0021), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String createUrlFromParams(java.lang.String r6, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.io.UnsupportedEncodingException -> L76
            r0.<init>()     // Catch: java.io.UnsupportedEncodingException -> L76
            r0.append(r6)     // Catch: java.io.UnsupportedEncodingException -> L76
            r1 = 38
            int r1 = r6.indexOf(r1)     // Catch: java.io.UnsupportedEncodingException -> L76
            java.lang.String r2 = "&"
            if (r1 > 0) goto L21
            r1 = 63
            int r1 = r6.indexOf(r1)     // Catch: java.io.UnsupportedEncodingException -> L76
            if (r1 <= 0) goto L1b
            goto L21
        L1b:
            java.lang.String r1 = "?"
            r0.append(r1)     // Catch: java.io.UnsupportedEncodingException -> L76
            goto L24
        L21:
            r0.append(r2)     // Catch: java.io.UnsupportedEncodingException -> L76
        L24:
            java.util.Set r7 = r7.entrySet()     // Catch: java.io.UnsupportedEncodingException -> L76
            java.util.Iterator r7 = r7.iterator2()     // Catch: java.io.UnsupportedEncodingException -> L76
        L2c:
            boolean r1 = r7.hasNext()     // Catch: java.io.UnsupportedEncodingException -> L76
            if (r1 == 0) goto L69
            java.lang.Object r1 = r7.next()     // Catch: java.io.UnsupportedEncodingException -> L76
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.io.UnsupportedEncodingException -> L76
            java.lang.Object r3 = r1.getValue()     // Catch: java.io.UnsupportedEncodingException -> L76
            java.util.List r3 = (java.util.List) r3     // Catch: java.io.UnsupportedEncodingException -> L76
            java.util.Iterator r3 = r3.iterator2()     // Catch: java.io.UnsupportedEncodingException -> L76
        L42:
            boolean r4 = r3.hasNext()     // Catch: java.io.UnsupportedEncodingException -> L76
            if (r4 == 0) goto L2c
            java.lang.Object r4 = r3.next()     // Catch: java.io.UnsupportedEncodingException -> L76
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.io.UnsupportedEncodingException -> L76
            java.lang.String r5 = "UTF-8"
            java.lang.String r4 = java.net.URLEncoder.encode(r4, r5)     // Catch: java.io.UnsupportedEncodingException -> L76
            java.lang.Object r5 = r1.getKey()     // Catch: java.io.UnsupportedEncodingException -> L76
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.io.UnsupportedEncodingException -> L76
            r0.append(r5)     // Catch: java.io.UnsupportedEncodingException -> L76
            java.lang.String r5 = "="
            r0.append(r5)     // Catch: java.io.UnsupportedEncodingException -> L76
            r0.append(r4)     // Catch: java.io.UnsupportedEncodingException -> L76
            r0.append(r2)     // Catch: java.io.UnsupportedEncodingException -> L76
            goto L42
        L69:
            int r7 = r0.length()     // Catch: java.io.UnsupportedEncodingException -> L76
            int r7 = r7 + (-1)
            r0.deleteCharAt(r7)     // Catch: java.io.UnsupportedEncodingException -> L76
            java.lang.String r6 = r0.toString()     // Catch: java.io.UnsupportedEncodingException -> L76
        L76:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.okhttp.utils.HttpUtils.createUrlFromParams(java.lang.String, java.util.Map):java.lang.String");
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public static RequestBody generateMultipartRequestBody(HttpParams httpParams, boolean z10) {
        if (httpParams.fileParamsMap.isEmpty() && !z10) {
            FormBody.Builder builder = new FormBody.Builder();
            for (String str : httpParams.urlParamsMap.h()) {
                Iterator<String> iterator2 = httpParams.urlParamsMap.get(str).iterator2();
                while (iterator2.hasNext()) {
                    builder.addEncoded(str, iterator2.next());
                }
            }
            return builder.build();
        }
        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (!httpParams.urlParamsMap.isEmpty()) {
            for (Map.Entry<String, List<String>> entry : httpParams.urlParamsMap.entrySet()) {
                Iterator<String> iterator22 = entry.getValue().iterator2();
                while (iterator22.hasNext()) {
                    type.addFormDataPart(entry.getKey(), iterator22.next());
                }
            }
        }
        for (Map.Entry<String, List<HttpParams.FileWrapper>> entry2 : httpParams.fileParamsMap.entrySet()) {
            for (HttpParams.FileWrapper fileWrapper : entry2.getValue()) {
                type.addFormDataPart(entry2.getKey(), fileWrapper.fileName, RequestBody.create(fileWrapper.contentType, fileWrapper.file));
            }
        }
        return type.build();
    }

    public static String getHeaderFileName(Response response) {
        String header = response.header("Content-Disposition");
        if (header == null) {
            return null;
        }
        String replaceAll = header.replaceAll("\"", "");
        int indexOf = replaceAll.indexOf("filename=");
        if (indexOf != -1) {
            return replaceAll.substring(indexOf + 9, replaceAll.length());
        }
        int indexOf2 = replaceAll.indexOf("filename*=");
        if (indexOf2 == -1) {
            return null;
        }
        String substring = replaceAll.substring(indexOf2 + 10, replaceAll.length());
        return substring.startsWith("UTF-8''") ? substring.substring(7, substring.length()) : substring;
    }

    public static String getNetFileName(Response response, String str) {
        String headerFileName = getHeaderFileName(response);
        if (TextUtils.isEmpty(headerFileName)) {
            headerFileName = getUrlFileName(str);
        }
        if (TextUtils.isEmpty(headerFileName)) {
            headerFileName = "unknownfile_" + System.currentTimeMillis();
        }
        try {
            return URLDecoder.decode(headerFileName, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return headerFileName;
        }
    }

    public static String getUrlFileName(String str) {
        int indexOf;
        String[] split = str.split("/");
        for (String str2 : split) {
            if (str2.contains(SymbolValues.QUESTION_EN_SYMBOL) && (indexOf = str2.indexOf(SymbolValues.QUESTION_EN_SYMBOL)) != -1) {
                return str2.substring(0, indexOf);
            }
        }
        if (split.length > 0) {
            return split[split.length - 1];
        }
        return null;
    }

    public static MediaType guessMimeType(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str.replace("#", ""));
        if (contentTypeFor == null) {
            return HttpParams.MEDIA_TYPE_STREAM;
        }
        return MediaType.parse(contentTypeFor);
    }

    public static void runOnUiThread(Runnable runnable) {
        OkHttp.getInstance().getDelivery().post(runnable);
    }
}
