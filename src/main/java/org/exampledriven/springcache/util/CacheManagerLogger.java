
package org.exampledriven.springcache.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class CacheManagerLogger implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CacheManagerLogger.class);

	private final CacheManager cacheManager;

	public CacheManagerLogger(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	@Override
	public void run(String... strings) {

		logger.info("=========================================================");
		logger.info("Using cache manager: " + this.cacheManager.getClass().getName());
		logger.info("Configured cache names are");
		cacheManager.getCacheNames().forEach(cacheName -> logger.info(" - " + cacheName) );
		logger.info("=========================================================");

	}

}
