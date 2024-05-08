package io.perfmark;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Impl {
    private static final long NO_LINK_ID = Long.MIN_VALUE;
    public static final long NO_TAG_ID = Long.MIN_VALUE;
    public static final String NO_TAG_NAME = "";
    public static final Tag NO_TAG = new Tag("", Long.MIN_VALUE);
    public static final Link NO_LINK = new Link(Long.MIN_VALUE);

    public Impl(Tag tag) {
        if (tag != NO_TAG) {
            throw new AssertionError((Object) "nope");
        }
    }

    public static Link packLink(long j10) {
        return new Link(j10);
    }

    public static Tag packTag(String str, long j10) {
        return new Tag(str, j10);
    }

    public static long unpackLinkId(Link link) {
        return link.linkId;
    }

    public static long unpackTagId(Tag tag) {
        return tag.tagId;
    }

    public static String unpackTagName(Tag tag) {
        return tag.tagName;
    }

    public void attachTag(Tag tag) {
    }

    public void attachTag(String str, long j10) {
    }

    public void attachTag(String str, long j10, long j11) {
    }

    public <T> void attachTag(String str, T t2, StringFunction<? super T> stringFunction) {
    }

    public void attachTag(String str, String str2) {
    }

    public Tag createTag(String str, long j10) {
        return NO_TAG;
    }

    public void event(String str) {
    }

    public void event(String str, Tag tag) {
    }

    public void event(String str, String str2) {
    }

    public void linkIn(Link link) {
    }

    public Link linkOut() {
        return NO_LINK;
    }

    public void setEnabled(boolean z10) {
    }

    public <T> void startTask(T t2, StringFunction<? super T> stringFunction) {
    }

    public void startTask(String str) {
    }

    public void startTask(String str, Tag tag) {
    }

    public void startTask(String str, String str2) {
    }

    public void stopTask() {
    }

    public void stopTask(String str) {
    }

    public void stopTask(String str, Tag tag) {
    }

    public void stopTask(String str, String str2) {
    }
}
