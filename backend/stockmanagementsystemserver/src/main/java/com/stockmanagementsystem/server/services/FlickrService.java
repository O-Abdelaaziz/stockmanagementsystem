package com.stockmanagementsystem.server.services;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

/**
 * @Created 22/07/2021 - 11:43
 * @Package com.stockmanagementsystem.server.services
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
public interface FlickrService {
    String savePhoto(InputStream photo,String title) throws FlickrException;
}
