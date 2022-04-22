package universitysportscenter;

public class Review {
    String review;
    int reviewRating;

    public Review() {
    }

    public Review(String review, int reviewRating) {
        this.review = review;
        this.reviewRating = reviewRating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(int reviewRating) {
        this.reviewRating = reviewRating;
    }
}
