package com.google.android.exoplayer2.extractor.mp4;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.huawei.openalliance.ad.constant.bb;
import sun.util.locale.LanguageTag;

/* compiled from: MetadataUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final String[] f20184a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    @Nullable
    public static CommentFrame a(int i10, ParsableByteArray parsableByteArray) {
        int n10 = parsableByteArray.n();
        if (parsableByteArray.n() == 1684108385) {
            parsableByteArray.Q(8);
            String y10 = parsableByteArray.y(n10 - 16);
            return new CommentFrame(LanguageTag.UNDETERMINED, y10, y10);
        }
        String valueOf = String.valueOf(a.a(i10));
        com.google.android.exoplayer2.util.m.h("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
        return null;
    }

    @Nullable
    public static ApicFrame b(ParsableByteArray parsableByteArray) {
        int n10 = parsableByteArray.n();
        if (parsableByteArray.n() == 1684108385) {
            int b4 = a.b(parsableByteArray.n());
            String str = b4 == 13 ? bb.V : b4 == 14 ? bb.Z : null;
            if (str == null) {
                StringBuilder sb2 = new StringBuilder(41);
                sb2.append("Unrecognized cover art flags: ");
                sb2.append(b4);
                com.google.android.exoplayer2.util.m.h("MetadataUtil", sb2.toString());
                return null;
            }
            parsableByteArray.Q(4);
            int i10 = n10 - 16;
            byte[] bArr = new byte[i10];
            parsableByteArray.j(bArr, 0, i10);
            return new ApicFrame(str, null, 3, bArr);
        }
        com.google.android.exoplayer2.util.m.h("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    @Nullable
    public static Metadata.Entry c(ParsableByteArray parsableByteArray) {
        int e2 = parsableByteArray.e() + parsableByteArray.n();
        int n10 = parsableByteArray.n();
        int i10 = (n10 >> 24) & 255;
        try {
            if (i10 == 169 || i10 == 253) {
                int i11 = 16777215 & n10;
                if (i11 == 6516084) {
                    return a(n10, parsableByteArray);
                }
                if (i11 == 7233901 || i11 == 7631467) {
                    return h(n10, "TIT2", parsableByteArray);
                }
                if (i11 == 6516589 || i11 == 7828084) {
                    return h(n10, "TCOM", parsableByteArray);
                }
                if (i11 == 6578553) {
                    return h(n10, "TDRC", parsableByteArray);
                }
                if (i11 == 4280916) {
                    return h(n10, "TPE1", parsableByteArray);
                }
                if (i11 == 7630703) {
                    return h(n10, "TSSE", parsableByteArray);
                }
                if (i11 == 6384738) {
                    return h(n10, "TALB", parsableByteArray);
                }
                if (i11 == 7108978) {
                    return h(n10, "USLT", parsableByteArray);
                }
                if (i11 == 6776174) {
                    return h(n10, "TCON", parsableByteArray);
                }
                if (i11 == 6779504) {
                    return h(n10, "TIT1", parsableByteArray);
                }
            } else {
                if (n10 == 1735291493) {
                    return g(parsableByteArray);
                }
                if (n10 == 1684632427) {
                    return d(n10, "TPOS", parsableByteArray);
                }
                if (n10 == 1953655662) {
                    return d(n10, "TRCK", parsableByteArray);
                }
                if (n10 == 1953329263) {
                    return i(n10, "TBPM", parsableByteArray, true, false);
                }
                if (n10 == 1668311404) {
                    return i(n10, "TCMP", parsableByteArray, true, true);
                }
                if (n10 == 1668249202) {
                    return b(parsableByteArray);
                }
                if (n10 == 1631670868) {
                    return h(n10, "TPE2", parsableByteArray);
                }
                if (n10 == 1936682605) {
                    return h(n10, "TSOT", parsableByteArray);
                }
                if (n10 == 1936679276) {
                    return h(n10, "TSO2", parsableByteArray);
                }
                if (n10 == 1936679282) {
                    return h(n10, "TSOA", parsableByteArray);
                }
                if (n10 == 1936679265) {
                    return h(n10, "TSOP", parsableByteArray);
                }
                if (n10 == 1936679791) {
                    return h(n10, "TSOC", parsableByteArray);
                }
                if (n10 == 1920233063) {
                    return i(n10, "ITUNESADVISORY", parsableByteArray, false, false);
                }
                if (n10 == 1885823344) {
                    return i(n10, "ITUNESGAPLESS", parsableByteArray, false, true);
                }
                if (n10 == 1936683886) {
                    return h(n10, "TVSHOWSORT", parsableByteArray);
                }
                if (n10 == 1953919848) {
                    return h(n10, "TVSHOW", parsableByteArray);
                }
                if (n10 == 757935405) {
                    return e(parsableByteArray, e2);
                }
            }
            String valueOf = String.valueOf(a.a(n10));
            com.google.android.exoplayer2.util.m.b("MetadataUtil", valueOf.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf) : new String("Skipped unknown metadata entry: "));
            return null;
        } finally {
            parsableByteArray.P(e2);
        }
    }

    @Nullable
    public static TextInformationFrame d(int i10, String str, ParsableByteArray parsableByteArray) {
        int n10 = parsableByteArray.n();
        if (parsableByteArray.n() == 1684108385 && n10 >= 22) {
            parsableByteArray.Q(10);
            int J = parsableByteArray.J();
            if (J > 0) {
                StringBuilder sb2 = new StringBuilder(11);
                sb2.append(J);
                String sb3 = sb2.toString();
                int J2 = parsableByteArray.J();
                if (J2 > 0) {
                    String valueOf = String.valueOf(sb3);
                    StringBuilder sb4 = new StringBuilder(valueOf.length() + 12);
                    sb4.append(valueOf);
                    sb4.append("/");
                    sb4.append(J2);
                    sb3 = sb4.toString();
                }
                return new TextInformationFrame(str, null, sb3);
            }
        }
        String valueOf2 = String.valueOf(a.a(i10));
        com.google.android.exoplayer2.util.m.h("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    @Nullable
    public static Id3Frame e(ParsableByteArray parsableByteArray, int i10) {
        String str = null;
        String str2 = null;
        int i11 = -1;
        int i12 = -1;
        while (parsableByteArray.e() < i10) {
            int e2 = parsableByteArray.e();
            int n10 = parsableByteArray.n();
            int n11 = parsableByteArray.n();
            parsableByteArray.Q(4);
            if (n11 == 1835360622) {
                str = parsableByteArray.y(n10 - 12);
            } else if (n11 == 1851878757) {
                str2 = parsableByteArray.y(n10 - 12);
            } else {
                if (n11 == 1684108385) {
                    i11 = e2;
                    i12 = n10;
                }
                parsableByteArray.Q(n10 - 12);
            }
        }
        if (str == null || str2 == null || i11 == -1) {
            return null;
        }
        parsableByteArray.P(i11);
        parsableByteArray.Q(16);
        return new InternalFrame(str, str2, parsableByteArray.y(i12 - 16));
    }

    @Nullable
    public static MdtaMetadataEntry f(ParsableByteArray parsableByteArray, int i10, String str) {
        while (true) {
            int e2 = parsableByteArray.e();
            if (e2 >= i10) {
                return null;
            }
            int n10 = parsableByteArray.n();
            if (parsableByteArray.n() == 1684108385) {
                int n11 = parsableByteArray.n();
                int n12 = parsableByteArray.n();
                int i11 = n10 - 16;
                byte[] bArr = new byte[i11];
                parsableByteArray.j(bArr, 0, i11);
                return new MdtaMetadataEntry(str, bArr, n12, n11);
            }
            parsableByteArray.P(e2 + n10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.exoplayer2.metadata.id3.TextInformationFrame g(com.google.android.exoplayer2.util.ParsableByteArray r3) {
        /*
            int r3 = j(r3)
            r0 = 0
            if (r3 <= 0) goto L11
            java.lang.String[] r1 = com.google.android.exoplayer2.extractor.mp4.g.f20184a
            int r2 = r1.length
            if (r3 > r2) goto L11
            int r3 = r3 + (-1)
            r3 = r1[r3]
            goto L12
        L11:
            r3 = r0
        L12:
            if (r3 == 0) goto L1c
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            return r1
        L1c:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            com.google.android.exoplayer2.util.m.h(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.g.g(com.google.android.exoplayer2.util.ParsableByteArray):com.google.android.exoplayer2.metadata.id3.TextInformationFrame");
    }

    @Nullable
    public static TextInformationFrame h(int i10, String str, ParsableByteArray parsableByteArray) {
        int n10 = parsableByteArray.n();
        if (parsableByteArray.n() == 1684108385) {
            parsableByteArray.Q(8);
            return new TextInformationFrame(str, null, parsableByteArray.y(n10 - 16));
        }
        String valueOf = String.valueOf(a.a(i10));
        com.google.android.exoplayer2.util.m.h("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    @Nullable
    public static Id3Frame i(int i10, String str, ParsableByteArray parsableByteArray, boolean z10, boolean z11) {
        int j10 = j(parsableByteArray);
        if (z11) {
            j10 = Math.min(1, j10);
        }
        if (j10 >= 0) {
            if (z10) {
                return new TextInformationFrame(str, null, Integer.toString(j10));
            }
            return new CommentFrame(LanguageTag.UNDETERMINED, str, Integer.toString(j10));
        }
        String valueOf = String.valueOf(a.a(i10));
        com.google.android.exoplayer2.util.m.h("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }

    public static int j(ParsableByteArray parsableByteArray) {
        parsableByteArray.Q(4);
        if (parsableByteArray.n() == 1684108385) {
            parsableByteArray.Q(8);
            return parsableByteArray.D();
        }
        com.google.android.exoplayer2.util.m.h("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void k(int i10, d5.l lVar, Format.b bVar) {
        if (i10 == 1 && lVar.a()) {
            bVar.M(lVar.f48639a).N(lVar.f48640b);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
    
        if (r6 != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void l(int r5, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata r6, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata r7, com.google.android.exoplayer2.Format.b r8, com.google.android.exoplayer2.metadata.Metadata... r9) {
        /*
            com.google.android.exoplayer2.metadata.Metadata r0 = new com.google.android.exoplayer2.metadata.Metadata
            r1 = 0
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r2 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r1]
            r0.<init>(r2)
            r2 = 1
            if (r5 != r2) goto Le
            if (r6 == 0) goto L3c
            goto L3d
        Le:
            r6 = 2
            if (r5 != r6) goto L3c
            if (r7 == 0) goto L3c
            r5 = 0
        L14:
            int r6 = r7.d()
            if (r5 >= r6) goto L3c
            com.google.android.exoplayer2.metadata.Metadata$Entry r6 = r7.c(r5)
            boolean r3 = r6 instanceof com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry
            if (r3 == 0) goto L39
            com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry r6 = (com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry) r6
            java.lang.String r3 = r6.f20918b
            java.lang.String r4 = "com.android.capture.fps"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L39
            com.google.android.exoplayer2.metadata.Metadata r5 = new com.google.android.exoplayer2.metadata.Metadata
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r7 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r2]
            r7[r1] = r6
            r5.<init>(r7)
            r6 = r5
            goto L3d
        L39:
            int r5 = r5 + 1
            goto L14
        L3c:
            r6 = r0
        L3d:
            int r5 = r9.length
        L3e:
            if (r1 >= r5) goto L49
            r7 = r9[r1]
            com.google.android.exoplayer2.metadata.Metadata r6 = r6.b(r7)
            int r1 = r1 + 1
            goto L3e
        L49:
            int r5 = r6.d()
            if (r5 <= 0) goto L52
            r8.X(r6)
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.g.l(int, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.Format$b, com.google.android.exoplayer2.metadata.Metadata[]):void");
    }
}
