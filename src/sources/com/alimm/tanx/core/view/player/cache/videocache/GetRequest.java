package com.alimm.tanx.core.view.player.cache.videocache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GetRequest {
    public static final Pattern RANGE_HEADER_PATTERN = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    public static final Pattern URL_PATTERN = Pattern.compile("GET /(.*) HTTP");
    public final boolean partial;
    public final long rangeOffset;
    public final String uri;

    public GetRequest(String str) {
        Preconditions.checkNotNull(str);
        long findRangeOffset = findRangeOffset(str);
        this.rangeOffset = Math.max(0L, findRangeOffset);
        this.partial = findRangeOffset >= 0;
        this.uri = findUri(str);
    }

    private long findRangeOffset(String str) {
        Matcher matcher = RANGE_HEADER_PATTERN.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private String findUri(String str) {
        Matcher matcher = URL_PATTERN.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public static GetRequest read(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                sb2.append(readLine);
                sb2.append('\n');
            } else {
                return new GetRequest(sb2.toString());
            }
        }
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.rangeOffset + ", partial=" + this.partial + ", uri='" + this.uri + "'}";
    }
}
