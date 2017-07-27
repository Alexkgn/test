package com.alexkgn.listapp.ui.main;

import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexkgn.listapp.R;
import com.alexkgn.listapp.data.Picture;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alex on 23.07.2017.
 */

public class PicturesAdapter extends RecyclerView.Adapter<PicturesAdapter.Holder> {

    private List<Picture> mPictures;
    private Callbacks mCallback;

    public interface Callbacks {
        void onPictureClick(final int pictureId);
    }

    public PicturesAdapter(List<Picture> pictures, Callbacks callback) {
        if (pictures != null) {
            this.mPictures = pictures;
        } else {
            this.mPictures = new ArrayList<>();
        }
        this.mCallback = callback;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_picture, null));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        final Picture picture = mPictures.get(position);
        holder.bindContent(picture);
    }

    @Override
    public int getItemCount() {
        return mPictures.size();
    }

    public void updateListPictures(@Nonnull List<Picture> pictures) {
        this.mPictures = pictures;
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.root_cardView)
        CardView mRootCardView;

        @BindView(R.id.picture)
        ImageView mPicture;

        @BindView(R.id.title)
        TextView mTitleTextView;

        @BindView(R.id.description)
        TextView mDescriptionTextView;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindContent(final Picture picture) {
            this.mRootCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mCallback != null) {
                        mCallback.onPictureClick(picture.getId());
                    }
                }
            });
            this.mPicture.setImageBitmap(
                    BitmapFactory.decodeByteArray(picture.getPicture(), 0, picture.getPicture().length));
            this.mTitleTextView.setText(picture.getTitle());
            this.mDescriptionTextView.setText(picture.getDescription());
        }
    }
}
