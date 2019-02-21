package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Friend> friends = new ArrayList<>();
        friends.add(new Friend("Arya", "Arya is the younger daughter and third child of Lord Eddard Stark and his wife Lady Catelyn Stark. She is tomboyish, headstrong, feisty, independent, disdains traditional female pursuits, and is often mistaken for a boy. She wields a smallsword named Needle, a gift from her half-brother, Jon Snow, and is trained in the Braavosi style of sword fighting by Syrio Forel.", getResources().getIdentifier("drawable/arya", "drawable", getPackageName())));
        friends.add(new Friend("Cersei", " Cersei Lannister, Queen of the Seven Kingdoms of Westeros, is the wife of King Robert Baratheon. Her father arranged the marriage after his attempt to betroth her to Prince Rhaegar Targaryen, as she wanted, failed.", getResources().getIdentifier("drawable/cersei", "drawable", getPackageName())));
        friends.add(new Friend("Daenerys", "Daenerys is one of the last two surviving members (along with her older brother, Viserys) of the House Targaryen, who, until fourteen years before the events of the first novel, had ruled Westeros from the Iron Throne for nearly three hundred years.", getResources().getIdentifier("drawable/daenerys", "drawable", getPackageName())));
        friends.add(new Friend("Jaime", "Jaime is a knight of the Kingsguard and a member of House Lannister, one of the wealthiest and most powerful families in the fictional kingdom of Westeros. Although he first appears to be unscrupulous and immoral, he later proves to be far more complex, honorable and sympathetic.", getResources().getIdentifier("drawable/jaime", "drawable", getPackageName())));
        friends.add(new Friend("Jon", "Jon is introduced as the illegitimate son of Ned Stark, the honorable lord of Winterfell, an ancient fortress in the North of the fictional continent of Westeros. Knowing his prospects are limited by his status, Jon joins the Night's Watch, who guard the far northern borders from the wildlings who live beyond The Wall. As the rest of the Starks face grave adversity, Jon finds himself honor bound to remain with the Watch.", getResources().getIdentifier("drawable/jon", "drawable", getPackageName())));
        friends.add(new Friend("Jorah", "Jorah is a mercenary knight in exile and the disgraced former lord of Bear Island, and only son of Jeor Mormont, the honourable lord commander of the Nights Watch of the kingdom of Westeros.", getResources().getIdentifier("drawable/jorah", "drawable", getPackageName())));
        friends.add(new Friend("Margaery", "Margaery Tyrell is the only daughter of Alerie Hightower and Mace Tyrell, the Lord of Highgarden in the Reach. Her older brothers are the heir Willas, Garlan and Loras the Knight of Flowers, who is a member of the Kingsguard.", getResources().getIdentifier("drawable/margaery", "drawable", getPackageName())));
        friends.add(new Friend("Melisandre", "lso known as \"The Red Woman\", Melisandre is a shadowbinder and a priestess of R'hllor in service to Stannis Baratheon. Originally a slave from Asshai called Melony, she is chosen by the Red Temple and recruited as a red priestess, and as a result has prophetic powers that give her partial knowledge of future events.", getResources().getIdentifier("drawable/melisandre", "drawable", getPackageName())));
        friends.add(new Friend("Sansa", "Sansa Stark is the second child and elder daughter of Eddard Stark and Catelyn Stark. She was born and raised in Winterfell, until leaving with her father and sister at the beginning of the series.", getResources().getIdentifier("drawable/sansa", "drawable", getPackageName())));
        friends.add(new Friend("Tyrion", "Tyrion Lannister's bio", getResources().getIdentifier("drawable/tyrion", "drawable", getPackageName())));

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView gv = findViewById(R.id.grid);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new GridItemClickListener());
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);

        }
    }

}
