package com.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

/*
 * Create an implementation of a Rest API client.
 * Prints out how many records exists for each gender and save this file to s3 bucket
 * API endpoint=> https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda 
 * AWS s3 bucket => interview-digiage
 *
 */

public class TASK4 {
	
	 // Main Function
	 public static void main(String[] args) {
		 
	        // AWS access credentials **Not a good practice to set keys in code, but for testing purposes, defining them anyway**
	        String accessKeyId = "AKIAU7BHLOLBKPZTHAP2";
	        String secretAccessKey = "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";
	        
	        try {
	            // Setting Endpoint URL
	            URI uri = URI.create("https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda");
	            
	            // Creating HTTP client
	            HttpClient client = HttpClient.newHttpClient();
	            
	            // Creating HTTP GET request
	            HttpRequest request = HttpRequest.newBuilder()
	                    .uri(uri)
	                    .GET()
	                    .build();
	            
	            // Sending the request and obtaining the response
	            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	            
	            // Verifying the response code
	            if (response.statusCode() != 200) {
	                System.out.println("Falha ao recuperar dados. Código de status HTTP: " + response.statusCode());
	                return;
	            }
	            
	            // Analyzing JSON response
	            String responseBody = response.body();
	            JSONArray records = new JSONArray(responseBody);
	            
	            // Counting each gender records
	            Map<String, Integer> genderCount = new HashMap<>();
	            for (int i = 0; i < records.length(); i++) {
	                JSONObject record = records.getJSONObject(i);
	                String gender = record.getString("gender");
	                genderCount.put(gender, genderCount.getOrDefault(gender, 0) + 1);
	            }
	            
	            // Printing the quantity of records for each genders
	            System.out.println("Número de registros para cada gênero:");
	            StringBuilder genderCountReport = new StringBuilder();
	            genderCount.forEach((gender, count) -> {
	                System.out.println(gender + ": " + count);
	                genderCountReport.append(gender).append(": ").append(count).append("\n");
	            });
	            
	            // Saving the data of gender counting in S3 bucket
	            saveToS3Bucket(genderCountReport.toString(), accessKeyId, secretAccessKey);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    // Function to save the data of gender counting to S3 bucket
	    private static void saveToS3Bucket(String report, String accessKeyId, String secretAccessKey) {
	        try {
	        	
	            // Creating AwsBasicCredentials object with my credentials
	            AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(accessKeyId, secretAccessKey);
	            
	            // Creating a static credential provider with my credentials
	            StaticCredentialsProvider credentialsProvider = StaticCredentialsProvider.create(awsCredentials);
	            
	            // Creating a S3 client with my credentials and defining the region (In this case, using .US_WEST_2 according to informations extracted from the URL)
	            S3Client s3Client = S3Client.builder()
	                    .credentialsProvider(credentialsProvider)
	                    .region(Region.US_WEST_2)
	                    .build();
	            
	            // Defining the path witch data of gender counting is being saved **This path is a path in my PC, for future savings, this path needs to be changed**
	            Path filePath = Paths.get("/home/matheus/DigiageDocuments/teste-digiage-workspace/teste-digiage/gender_count_report.txt");
	            
	            // Saving the data of gender counting in txt file **If the txt file doesn't exists, this function will create it**
	            Files.writeString(filePath, report);
	            
	            // Verifying if the file was successfully saved at the defined path
	            if (Files.exists(filePath)) {
	                System.out.println("O Arquivo foi salvo corretamente em: " + filePath.toString());
	            } else {
	                System.err.println("O Arquivo não foi salvo corretamente em: " + filePath.toString());
	                return;
	            }
	            
	            // Naming the S3 bucket
	            String bucketName = "interview-digiage";
	            
	            // File name in S3 bucket
	            String objectKey = "gender_count_report.txt";
	            
	            // Creating a PutObjectRequest to configure the file upload request
	            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
	                    .bucket(bucketName)
	                    .key(objectKey)
	                    .build();
	            
	            // Saving the file at S3 bucket
	            s3Client.putObject(putObjectRequest, filePath);
	            
	            System.out.println("Arquivo salvo no bucket S3 '" + bucketName + "' com o nome '" + objectKey + "'.");
	            
	        } catch (S3Exception e) {
	            System.err.println("Falha ao salvar o arquivo no bucket S3: " + e.getMessage());
	        } catch (IOException e) {
	            System.err.println("Falha ao salvar o arquivo localmente: " + e.getMessage());
	        }
	    }
	}