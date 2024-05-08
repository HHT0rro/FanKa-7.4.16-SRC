package io.microshow.rxffmpeg;

import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class RxFFmpegCommandList extends ArrayList<String> {
    public RxFFmpegCommandList() {
        add("ffmpeg");
        add("-y");
    }

    public RxFFmpegCommandList append(String str) {
        add(str);
        return this;
    }

    public String[] build() {
        String[] strArr = new String[size()];
        for (int i10 = 0; i10 < size(); i10++) {
            strArr[i10] = get(i10);
        }
        return strArr;
    }

    public RxFFmpegCommandList clearCommands() {
        clear();
        return this;
    }

    public String[] build(boolean z10) {
        String[] build = build();
        if (z10) {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < build.length; i10++) {
                sb2.append(build[i10]);
                if (i10 < build.length - 1) {
                    sb2.append(" ");
                }
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("cmd: ");
            sb3.append(sb2.toString());
        }
        return build;
    }
}
