package cn.leafoct.emoji;

import java.util.List;
import java.util.Locale;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 抄自「第亿行代码」的RecyclerView的使用方式
 */
public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.ViewHolder> {

    private boolean is_chinese = false;
    private List<EmojiItem> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.emoji_item, parent, false);
        final ViewHolder holder = new ViewHolder(v);
        holder.emoji_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = holder.getAdapterPosition();
                EmojiItem e = list.get(index);
                ClipboardManager clipboard = (ClipboardManager) parent.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText(null, e.emoji);
                clipboard.setPrimaryClip(clipData);
                Toast.makeText(parent.getContext(), "copy~", Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EmojiItem emoji = list.get(position);
        holder.emoji_char.setText(emoji.emoji);
        if (is_chinese) {
            holder.emoji_explanation.setText(emoji.meaning_cn);
        } else {
            holder.emoji_explanation.setText(emoji.meaning_en);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView emoji_char, emoji_explanation;
        View emoji_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            emoji_view = itemView;
            emoji_char = itemView.findViewById(R.id.emoji_char);
            emoji_explanation = itemView.findViewById(R.id.emoji_explanation);
        }
    }

    public EmojiAdapter(List<EmojiItem> list) {
        this.list = list;
        String language = Locale.getDefault().getLanguage();
        if (language.startsWith("zh")) {
            is_chinese = true;
        }
    }


}
