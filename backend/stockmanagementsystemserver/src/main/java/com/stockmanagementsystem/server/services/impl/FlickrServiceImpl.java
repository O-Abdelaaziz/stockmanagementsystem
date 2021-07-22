package com.stockmanagementsystem.server.services.impl;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.stockmanagementsystem.server.services.FlickrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;

/**
 * @Created 22/07/2021 - 11:45
 * @Package com.stockmanagementsystem.server.services.impl
 * @Project stockmanagementsystemserver
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@Service
@Slf4j
@Transactional
public class FlickrServiceImpl implements FlickrService {

    @Value("${flickr.api.key}")
    private String apiKey;
    @Value("${flickr.api.secret}")
    private String apiSecret;

    @Value("${flickr.app.key}")
    private String appKey;
    @Value("${flickr.app.secret}")
    private String appSecret;

    @Autowired
    private Flickr flickr;

    @Override
    public String savePhoto(InputStream photo, String title) throws FlickrException {
        UploadMetaData uploadMetaData=new UploadMetaData();
        uploadMetaData.setTitle(title);

        String photoId=flickr.getUploader().upload(photo,uploadMetaData);
        String photoUrl=flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
        return photoUrl;
    }
}
