package com.imd.buscapatas.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;

@Service
public class S3Util {
   
	
	private String bucketName = "buscapatas";
	
	private final AmazonS3 s3;
	
	public S3Util(AmazonS3 s3) {
		this.s3 = s3;
	}
	
	public String saveFile(MultipartFile file, String nomeArquivo) {
		try {
			File fileConvert = convertMultiPartToFile(file, nomeArquivo);
			PutObjectResult putObjectResult = s3.putObject(bucketName, nomeArquivo, fileConvert);
			
			return putObjectResult.getContentMd5();
		} catch(IOException e) {
			throw new RuntimeException();
		}
	}
	
	private File convertMultiPartToFile(MultipartFile file, String nomeArquivo) throws IOException {
		File convFile = new File (nomeArquivo);
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
}