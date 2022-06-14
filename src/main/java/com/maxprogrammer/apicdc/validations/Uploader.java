package com.maxprogrammer.apicdc.validations;

import org.springframework.web.multipart.MultipartFile;

@FunctionalInterface
public interface Uploader {

    public String upload(MultipartFile file);
}