package n5;

import com.google.android.exoplayer2.Format;

/* compiled from: MetadataDecoderFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f52127a = new a();

    /* compiled from: MetadataDecoderFactory.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements c {
        @Override // n5.c
        public boolean a(Format format) {
            String str = format.f19544m;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        @Override // n5.c
        public b b(Format format) {
            String str = format.f19544m;
            if (str != null) {
                char c4 = 65535;
                switch (str.hashCode()) {
                    case -1354451219:
                        if (str.equals("application/vnd.dvb.ait")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case -1348231605:
                        if (str.equals("application/x-icy")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case -1248341703:
                        if (str.equals("application/id3")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 1154383568:
                        if (str.equals("application/x-emsg")) {
                            c4 = 3;
                            break;
                        }
                        break;
                    case 1652648887:
                        if (str.equals("application/x-scte35")) {
                            c4 = 4;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        return new o5.a();
                    case 1:
                        return new q5.a();
                    case 2:
                        return new r5.b();
                    case 3:
                        return new p5.a();
                    case 4:
                        return new t5.a();
                }
            }
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(valueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
        }
    }

    boolean a(Format format);

    b b(Format format);
}
