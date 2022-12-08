package com.imd.buscapatas.util;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.azure.storage.blob.models.BlobHttpHeaders;
import com.azure.storage.blob.models.BlobRequestConditions;
import com.azure.storage.blob.options.BlobParallelUploadOptions;

@Service
public class AzureConfig {
	
	private String constr = "AccountName=buspatas;"
			+ "AccountKey=<Senha>;"
			+ "EndpointSuffix=core.windows.net;"
			+ "DefaultEndpointsProtocol=https;";
	
	private String nomeContainer = "buscapatas";
	
	public void enviarArquivo(MultipartFile arquivo, String nomeArquivo) {
		BlobContainerClient container = new BlobContainerClientBuilder()
				.connectionString(constr)
				.containerName(nomeContainer)
				.buildClient();
		
		BlobClient blob = container.getBlobClient(nomeArquivo);
		
		BlobHttpHeaders jsonHeaders = new BlobHttpHeaders().setContentType("image/png");
		
	    BinaryData data;
		try {
			data = BinaryData.fromStream(arquivo.getInputStream(), arquivo.getSize());
			BlobParallelUploadOptions options = new BlobParallelUploadOptions(data)
		            .setRequestConditions(new BlobRequestConditions()).setHeaders(jsonHeaders);
		    
		    blob.uploadWithResponse(options, null, Context.NONE);
		} catch (IOException e) {
			e.printStackTrace();
		}   
	}
    
}
