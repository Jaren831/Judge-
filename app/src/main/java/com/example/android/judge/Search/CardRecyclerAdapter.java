package com.example.android.judge.Search;

import android.content.Context;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.judge.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import javax.security.auth.Subject;

/**
 * Created by jaren on 4/30/2017.
 */

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.CardViewHolder>{

    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardCard;
        TextView cardName;
        TextView cardMana;
        ImageView cardImage;

        CardViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            cardCard = (CardView) itemView.findViewById(R.id.card_card);
            cardName = (TextView) itemView.findViewById(R.id.card_name_item);
            cardMana = (TextView) itemView.findViewById(R.id.card_mana_item);
            cardImage = (ImageView) itemView.findViewById(R.id.card_image_item);
        }

        @Override
        public void onClick(View v) {
            // The user may not set a click listener for list items, in which case our listener
            // will be null, so we need to check for this
            if (mOnEntryClickListener != null) {
                mOnEntryClickListener.onEntryClick(v, getLayoutPosition());
            }
        }
    }

    private Context mContext;
    private ArrayList<Card> mCardArray;

    public CardRecyclerAdapter(Context context, ArrayList<Card> cardArray) {
        mContext = context;
        mCardArray = cardArray;
    }

    @Override
    public int getItemCount() {
        return mCardArray.size();
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Card currentCard = mCardArray.get(position);


        holder.cardName.setText(currentCard.getName());
        Picasso.with(mContext).load(currentCard.getImage()).into(holder.cardImage);
        holder.cardMana.setText(currentCard.getMana());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    private OnEntryClickListener mOnEntryClickListener;

    public interface OnEntryClickListener {
        void onEntryClick(View view, int position);
    }

    public void setOnEntryClickListener(OnEntryClickListener onEntryClickListener) {
        mOnEntryClickListener = onEntryClickListener;
    }
}