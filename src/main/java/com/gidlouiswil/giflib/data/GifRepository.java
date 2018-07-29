package com.gidlouiswil.giflib.data;

import com.gidlouiswil.giflib.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository
{
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", LocalDate.of(2018,2,13), "Kyo Kusanagi", false, 1),
            new Gif("ben-and-mike", LocalDate.of(2018,10,30), "Iori Yagami", true, 2),
            new Gif("book-dominos", LocalDate.of(2018,9,15), "Sie Kensou", false, 3),
            new Gif("compiler-bot", LocalDate.of(2018,2,13), "Terry Bogard", true, 1),
            new Gif("cowboy-coder", LocalDate.of(2018,2,13), "Rugal Bernstein", false, 2),
            new Gif("infinite-andrew", LocalDate.of(2018,8,23), "Ryo Sakazaki", true, 3)
    );

    public Gif findByName(String name)
    {
        for (Gif gif : ALL_GIFS)
        {
            if (gif.getName().equals(name))
                return gif;
        }
        return null;
    }

    public List<Gif> getAllGifs()
    {
        return ALL_GIFS;
    }

    public  List<Gif> findByCategoryId(int id)
    {
        List<Gif> gifs = new ArrayList<>();
        for (Gif gif : ALL_GIFS)
        {
            if(gif.getCategoryId() == id)
                gifs.add(gif);
        }

        return gifs;
    }
}
