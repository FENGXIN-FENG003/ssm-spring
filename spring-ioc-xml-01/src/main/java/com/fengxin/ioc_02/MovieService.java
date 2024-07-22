package com.fengxin.ioc_02;

/**
 * @author FENGXIN
 * @date 2024/7/22
 **/
public class MovieService {
    private Movie movie;
    private String movieName;
    
    public void setMovieName (String movieName) {
        this.movieName = movieName;
    }
    
    public void setMovie (Movie movie) {
        this.movie = movie;
    }
}
