package foodygram.services;

//Imports the Google Cloud client library
import com.google.cloud.vision.spi.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.protobuf.ByteString;

import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import okhttp3.OkHttpClient;

public class ImageRecognitionService {
	private ClarifaiBuilder clarifaiBuilder;
	private ClarifaiClient clarifaiClient;
	/*
	public ImageRecognitionService() {
		new ClarifaiBuilder("W5P4PEO4WNZVqPcbIqMsALU84mHoBnc1OJG5CEAw", "-o3hDfmjmOvqjoowcgHkEfm-L6qV9sP7ygMXZpxp")
	    .client(new OkHttpClient()) // OPTIONAL. Allows customization of OkHttp by the user
	    .buildSync().registerAsDefaultInstance();
	}
	*/
	public String Recognize() {
		
		return "";
	}
}
