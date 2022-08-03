package com.rubypaper.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class LoggingService implements ApplicationRunner {

	private Logger LOGGER = LoggerFactory.getLogger(LoggingService.class);
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// 다양한 레벨 별 로그를 출력한다.
		LOGGER.trace("TRACE 레벨의 로그");
		LOGGER.debug("DEBUG 레벨의 로그");
		LOGGER.info("INFO 레벨의 로그");
		LOGGER.warn("WARN 레벨의 로그");
		LOGGER.error("ERROR 레벨의 로그");
	}

}
