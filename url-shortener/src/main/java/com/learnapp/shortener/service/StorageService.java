package com.learnapp.shortener.service;

public interface StorageService {

	String getUrl(String hash);

	String saveAndGetHash(String url);

}