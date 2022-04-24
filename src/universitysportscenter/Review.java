package universitysportscenter;

/**
 * The type Review.
 */
public class Review {
    /**
     * The Review.
     */
    String review;
    /**
     * The Review rating.
     */
    int reviewRating;

    /**
     * Instantiates a new Review.
     */
    public Review() {
    }

    /**
     * Instantiates a new Review.
     *
     * @param review       the review
     * @param reviewRating the review rating
     */
    public Review(String review, int reviewRating) {
        this.review = review;
        this.reviewRating = reviewRating;
    }

    /**
     * Gets review.
     *
     * @return the review
     */
    public String getReview() {
        return review;
    }

    /**
     * Sets review.
     *
     * @param review the review
     */
    public void setReview(String review) {
        this.review = review;
    }

    /**
     * Gets review rating.
     *
     * @return the review rating
     */
    public int getReviewRating() {
        return reviewRating;
    }

    /**
     * Sets review rating.
     *
     * @param reviewRating the review rating
     */
    public void setReviewRating(int reviewRating) {
        this.reviewRating = reviewRating;
    }
}
