package com.prs.artist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ArtistApiApplication
{
	private static ConfigurableApplicationContext ctx = null;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(ArtistApiApplication.class, args);
	}

	public static void shutdown() 
	{
		int exitCode = SpringApplication.exit(ctx, () -> 1);
        System.exit(exitCode);
	}
	
}