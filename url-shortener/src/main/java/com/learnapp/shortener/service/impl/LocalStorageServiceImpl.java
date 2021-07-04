package com.learnapp.shortener.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.learnapp.shortener.helpers.HashHelper;
import com.learnapp.shortener.service.StorageService;

@Service
public class LocalStorageServiceImpl implements StorageService {
	private Map<String, String> hMap = new HashMap<>();
	
	@Override
	public String getUrl(String hash) {
		return hMap.get(hash);
	}
	
	@Override
	public String saveAndGetHash(String url) {
		String hash = HashHelper.getHash(url);
		hMap.put(hash, url);
		return hash;
	}
}
