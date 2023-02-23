package cn.leafoct.emoji;

import android.content.Context;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 所有emoji的List
 * 原本是写死在文件中的, 该类负责初始化, 将文件中的emoji写入List(内存)中
 * 其中recent这个list用于保存最近使用过的表情, 暂时还没有做这个功能, 日后心情好再做
 */
public class EmojiList {
    public static List<EmojiItem> smile_emotions,
            people_body,
            animal_nature,
            food_drink,
            activities,
            travel_places,
            objects,
            symbols,
            flags,
            recent;

    public static void init(Context context) {
        List<String> emojis = null;
        smile_emotions = new ArrayList<>();
        people_body = new ArrayList<>();
        animal_nature = new ArrayList<>();
        food_drink = new ArrayList<>();
        activities = new ArrayList<>();
        travel_places = new ArrayList<>();
        objects = new ArrayList<>();
        symbols = new ArrayList<>();
        flags = new ArrayList<>();
        recent = new ArrayList<>();
        try {
            emojis = IOUtils.readLines(context.getResources().openRawResource(R.raw.smile_emotion), StandardCharsets.UTF_8);
            addToList(emojis, smile_emotions);
            emojis = IOUtils.readLines(context.getResources().openRawResource(R.raw.people_body), StandardCharsets.UTF_8);
            addToList(emojis, people_body);
            emojis = IOUtils.readLines(context.getResources().openRawResource(R.raw.animals_nature), StandardCharsets.UTF_8);
            addToList(emojis, animal_nature);
            emojis = IOUtils.readLines(context.getResources().openRawResource(R.raw.food_drink), StandardCharsets.UTF_8);
            addToList(emojis, food_drink);
            emojis = IOUtils.readLines(context.getResources().openRawResource(R.raw.activities), StandardCharsets.UTF_8);
            addToList(emojis, activities);
            emojis = IOUtils.readLines(context.getResources().openRawResource(R.raw.travel_places), StandardCharsets.UTF_8);
            addToList(emojis, travel_places);
            emojis = IOUtils.readLines(context.getResources().openRawResource(R.raw.objects), StandardCharsets.UTF_8);
            addToList(emojis, objects);
            emojis = IOUtils.readLines(context.getResources().openRawResource(R.raw.symbols), StandardCharsets.UTF_8);
            addToList(emojis, symbols);
            emojis = IOUtils.readLines(context.getResources().openRawResource(R.raw.flags), StandardCharsets.UTF_8);
            addToList(emojis, flags);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToList(List<String> emojis, List<EmojiItem> emoji_list) {
        for (String s : emojis) {
            emoji_list.add(new EmojiItem(s));
        }
    }
}