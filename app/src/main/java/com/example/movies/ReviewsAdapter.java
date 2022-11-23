package com.example.movies;

import static com.example.movies.R.color.green_light;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewsViewHolder> {

    private List<Review> reviews = new ArrayList<>();

    private static final String TYPE_POSITIVE = "Позитивный";
    private static final String TYPE_NEUTRAL = "Нейтральный";

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
        (R.layout.review_item, parent, false);
        return new ReviewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewsViewHolder holder, int position) {
        Review review = reviews.get(position);
        holder.textViewAuthor.setText(review.getAuthor());
        holder.textViewReview.setText(review.getReview());

        String type = review.getType();
        int colorReviewId = R.color.light_red;
        switch (type){
            case TYPE_POSITIVE:
                colorReviewId = R.color.light_green;
                break;
            case TYPE_NEUTRAL:
                colorReviewId = R.color.orange;
                break;
        }

        int color = ContextCompat.getColor(holder.itemView.getContext(), colorReviewId);
        holder.constraintLayoutContainer.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    static class ReviewsViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewAuthor;
        private final TextView textViewReview;
        private ConstraintLayout constraintLayoutContainer;

        public ReviewsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewReview = itemView.findViewById(R.id.textViewReview);
            constraintLayoutContainer = itemView.findViewById(R.id.constraintLayoutContainer);

        }
    }
}
