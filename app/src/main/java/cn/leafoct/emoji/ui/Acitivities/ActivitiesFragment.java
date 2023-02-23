package cn.leafoct.emoji.ui.Acitivities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.leafoct.emoji.EmojiAdapter;
import cn.leafoct.emoji.EmojiItem;
import cn.leafoct.emoji.EmojiList;
import cn.leafoct.emoji.databinding.FragmentActivitiesBinding;

/**
 *该类以及接下来几个Fragment类, 都是不同页面的内容, 故下面的类不再赘述
 */
public class ActivitiesFragment extends Fragment {

//    viewbinding框架
    private FragmentActivitiesBinding binding;
//    这个页面的所有表情, 引用EmojiList类的成员
    private List<EmojiItem> emoji_list;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentActivitiesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
//        引用EMojiList类之前读好的
        emoji_list= EmojiList.activities;
//        获取recycler view
        RecyclerView recyclerView = binding.activitiesRecyclerview;
//        设置网格布局, 每行5个
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 5);
        recyclerView.setLayoutManager(layoutManager);

        EmojiAdapter adapter = new EmojiAdapter(emoji_list);
        recyclerView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}