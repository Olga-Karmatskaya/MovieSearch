package com.example.moviesearch.data

import com.example.moviesearch.R
import com.example.moviesearch.domain.Film

class MainRepository {
   val filmsDataBase = listOf(
        Film("The Batman", R.drawable.batman, "When a sadistic serial killer begins murdering key political figures in Gotham, Batman is forced to investigate the city's hidden corruption and question his family's involvement."),
        Film("Dune", R.drawable.dune, "A noble family becomes embroiled in a war for control over the galaxy's most valuable asset while its heir becomes troubled by visions of a dark future."),
        Film("Forrest Gump", R.drawable.forrest_gump, "The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart."),
        Film("Home alone", R.drawable.home_alone, "An eight-year-old troublemaker must protect his house from a pair of burglars when he is accidentally left home alone by his family during Christmas vacation."),
        Film("Matrix", R.drawable.matrix, "Return to a world of two realities: one, everyday life; the other, what lies behind it. To find out if his reality is a construct, to truly know himself, Mr. Anderson will have to choose to follow the white rabbit once more."),
        Film("Parasite", R.drawable.parasite, "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan."),
        Film("Star Wars", R.drawable.star_wars, "Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee and two droids to save the galaxy from the Empire's world-destroying battle station, while also attempting to rescue Princess Leia from the mysterious Darth Vader."),
    )
}