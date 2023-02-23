package cn.leafoct.emoji.ui.PeopleBody;

import android.os.Bundle;

import androidx.annotation.NonNull;
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
import cn.leafoct.emoji.databinding.FragmentPeopleBodyBinding;


public class PeopleBodyFragment extends Fragment {
    private FragmentPeopleBodyBinding binding;
    private List<EmojiItem> emoji_list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPeopleBodyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        emoji_list= EmojiList.people_body;
        RecyclerView recyclerView = binding.peopleBodyRecyclerview;
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 5);
        recyclerView.setLayoutManager(layoutManager);
        EmojiAdapter adapter = new EmojiAdapter(emoji_list);
        recyclerView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}