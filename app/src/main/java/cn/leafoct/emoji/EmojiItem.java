package cn.leafoct.emoji;

public class EmojiItem {
    public String emoji;
    public String meaning_cn, meaning_en;

    public EmojiItem(String emoji, String meaning_cn, String meaning_en) {
        this.emoji = emoji;
        this.meaning_cn = meaning_cn;
        this.meaning_en = meaning_en;
    }

    public EmojiItem(String emoji){
        this(emoji, "", "");
    }
}
