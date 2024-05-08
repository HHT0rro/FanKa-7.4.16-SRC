package e6;

import com.google.android.exoplayer2.Format;

/* compiled from: SubtitleDecoderFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f48921a = new a();

    /* compiled from: SubtitleDecoderFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements g {
        @Override // e6.g
        public boolean a(Format format) {
            String str = format.f19544m;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str);
        }

        @Override // e6.g
        public f b(Format format) {
            String str = format.f19544m;
            if (str != null) {
                char c4 = 65535;
                switch (str.hashCode()) {
                    case -1351681404:
                        if (str.equals("application/dvbsubs")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case -1248334819:
                        if (str.equals("application/pgs")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case -1026075066:
                        if (str.equals("application/x-mp4-vtt")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case -1004728940:
                        if (str.equals("text/vtt")) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 691401887:
                        if (str.equals("application/x-quicktime-tx3g")) {
                            c4 = 4;
                            break;
                        }
                        break;
                    case 822864842:
                        if (str.equals("text/x-ssa")) {
                            c4 = 5;
                            break;
                        }
                        break;
                    case 930165504:
                        if (str.equals("application/x-mp4-cea-608")) {
                            c4 = 6;
                            break;
                        }
                        break;
                    case 1566015601:
                        if (str.equals("application/cea-608")) {
                            c4 = 7;
                            break;
                        }
                        break;
                    case 1566016562:
                        if (str.equals("application/cea-708")) {
                            c4 = '\b';
                            break;
                        }
                        break;
                    case 1668750253:
                        if (str.equals("application/x-subrip")) {
                            c4 = '\t';
                            break;
                        }
                        break;
                    case 1693976202:
                        if (str.equals("application/ttml+xml")) {
                            c4 = '\n';
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        return new com.google.android.exoplayer2.text.dvb.a(format.f19546o);
                    case 1:
                        return new g6.a();
                    case 2:
                        return new m6.a();
                    case 3:
                        return new m6.h();
                    case 4:
                        return new l6.a(format.f19546o);
                    case 5:
                        return new i6.a(format.f19546o);
                    case 6:
                    case 7:
                        return new f6.a(str, format.E, 16000L);
                    case '\b':
                        return new f6.c(format.E, format.f19546o);
                    case '\t':
                        return new j6.a();
                    case '\n':
                        return new k6.c();
                }
            }
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(valueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
        }
    }

    boolean a(Format format);

    f b(Format format);
}
