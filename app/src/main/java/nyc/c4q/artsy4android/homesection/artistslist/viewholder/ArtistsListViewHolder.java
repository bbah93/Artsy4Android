package nyc.c4q.artsy4android.homesection.artistslist.viewholder;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.View;
        import android.widget.TextView;

        import com.squareup.picasso.Picasso;

        import de.hdodenhof.circleimageview.CircleImageView;
        import nyc.c4q.artsy4android.artistpage.ArtistPageActivity;
        import nyc.c4q.artsy4android.R;
        import nyc.c4q.artsy4android.models.Artist;

        import static nyc.c4q.artsy4android.homesection.artistslist.controller.ArtistsListAdapter.TAG;

public class ArtistsListViewHolder extends RecyclerView.ViewHolder{
    private CircleImageView artistImage;
    private TextView artistName, artistNationality, artistLifeSpan, artistHometown;
    private String artistID;


    public ArtistsListViewHolder(final View itemView) {
        super(itemView);
        artistImage = itemView.findViewById(R.id.artist_profile_img);
        artistName = itemView.findViewById(R.id.artist_name);
        artistNationality = itemView.findViewById(R.id.artistNationality);
        artistLifeSpan = itemView.findViewById(R.id.life_spanTV);
        artistHometown = itemView.findViewById(R.id.hometownTV);
        artistImage.setOnClickListener(v -> {
            //send itemview data
            Bundle itemViewBundle = new Bundle();
            itemViewBundle.putString("ARTIST_NAME", artistName.getText().toString());
            itemViewBundle.putString("ARTIST_NATIONALITY", artistNationality.getText().toString());
            itemViewBundle.putString("ARTIST_HOMETOWN", artistHometown.getText().toString());
            itemViewBundle.putString("ARTIST_ID", artistID);
            Intent intent = new Intent(itemView.getContext(), ArtistPageActivity.class);
            intent.putExtras(itemViewBundle);
           itemView.getContext().startActivity(intent);
        });

    }

    public void onBind(Artist artists) {
        String lifeSpan = artists.getBirthday() + "-" + artists.getDeathday();
        artistName.setText(artists.getName());
        artistNationality.setText(artists.getNationality());
        artistLifeSpan.setText(lifeSpan);
        artistHometown.setText(artists.getHometown());
        artistID = getArtistData(artists);
        //load and set itemView images
        setImages(artists);
        //get artistID

    }

    private void setImages(Artist artist){
        //load and set artist Image
        if(!artist.get_links().getThumbnail().getHref().isEmpty()){
            String artistImage_URL = artist.get_links().getThumbnail().getHref();

            Picasso.get()
                    .load(artistImage_URL)
                    .into(artistImage);
            Log.d(TAG, "Thumbnail Image: " + artistImage_URL);
        }
    }
    private String getArtistData(Artist artist){
        return artist.getId();

    }
}

