package cn.leafoct.emoji.ui.AnimalNature;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.leafoct.emoji.EmojiAdapter;
import cn.leafoct.emoji.EmojiItem;
import cn.leafoct.emoji.EmojiList;
import cn.leafoct.emoji.databinding.FragmentAnimalNatureBinding;

public class AnimalNatureFragment extends Fragment {

    private FragmentAnimalNatureBinding binding;
    private List<EmojiItem> emoji_list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAnimalNatureBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        emoji_list= EmojiList.animal_nature;
        RecyclerView recyclerView = binding.animalNatureRecyclerview;
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