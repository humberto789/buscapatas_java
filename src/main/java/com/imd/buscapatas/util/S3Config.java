package com.imd.buscapatas.util;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {
	
	private String accesskey = "AKIAULNS3MMFEXD5BOMJ";
	
	private String secret = "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";
	
	private String region = "sa-east-1";
	
	@Bean
	public AmazonS3 s3() {
		AWSCredentials awsCredentials = new BasicAWSCredentials(accesskey, secret);
		
		return AmazonS3ClientBuilder.standard().withRegion(region).withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
	}
}
